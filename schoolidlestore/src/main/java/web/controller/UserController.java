package web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.Utils.CommonUtils;
import web.Utils.Mail;
import web.Utils.MailUtils;
import web.pojo.Cart;
import web.pojo.User;
import web.service.UserException;
import web.service.UserService;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Controller
public class UserController {
   @Autowired
    private UserService userService;

   @RequestMapping("/user/registuser")
    public String regist(Model model,User user) throws  IOException {
       System.out.println("controller..regist方法.....");
        //	1.将表单转换成bean  添加uuid和激活码
        //	2.输入校验
        //	  >如有错  保存错误信息到request 转发到regist.jsp
        //	3.调用service的findByUsername() findByEmail()  add()
        //	  >如有异常  catch  保存错误信息到request 转发到regist.jsp
        //	4.如果以上步骤没有错误 则 发送激活邮件
        //	5.保存成功信息到request  转发到msg.jsp

     //   User form  = CommonUtils.toBean(request.getParameterMap(),User.class);
        user.setUid(CommonUtils.uuid());//添加  id
        user.setCode(CommonUtils.uuid()+CommonUtils.uuid());//添加激活码

        //输入校验
        /**
         *    创建一个Map用来保存错误信息  其中 键  是表单字段的名称  值 是错误信息
         */
        Map<String,String> errorsmap = new HashMap<String,String>();
        if(user.getUsername() == null||user.getUsername().trim().isEmpty()) {
            errorsmap.put("username", "用户名不能为空！");
        }else if(user.getUsername().length()<2  || user.getUsername().length() >13) {
            errorsmap.put("username", "用户名长度需在2-13之间！！");
        }

        if(user.getPassword() == null||user.getPassword().trim().isEmpty()) {
            errorsmap.put("password", "密码不能为空！");
        }else if(user.getPassword().length()<2  || user.getPassword().length() >13) {
            errorsmap.put("password", "密码长度需在2-13之间！！");
        }

        if(user.getEmail() == null||user.getEmail().trim().isEmpty()) {
            errorsmap.put("email", "邮箱不能为空！");
        }else if(!user.getEmail().matches("\\w+@\\w+\\.\\w+")) {////////如果邮箱格式不匹配正则表达式
            errorsmap.put("email", "请输入正确的邮箱格式！！");
        }

        ///最好在这里判断一下 errorsmap.size() != null  可以避免空指针异常  如果不加这句 前面的errorsmap又没有初始化的话
        //就会报空指针异常    之前  我写一个List<>  没有new ArrayList<>()   就报了空指针异常

        if(errorsmap != null && errorsmap.size()>0) {
            System.out.println("erroesmap not null ");
            model.addAttribute("errors", errorsmap);
            model.addAttribute("form", user);///回显
            return "/user/regist";//----------第一个可能退出本方法的点
            //return; 退出Servlet 中的regist方法  避免继续向下执行
        }

        ///如果输入验证没有错 则调用service层的  添加方法   其中添加方法可能会抛异常
        try {
            userService.regist(user);


            ///发送邮件

            //加载配置文件
            Properties props = new Properties();
            props.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));

            String from = props.getProperty("from");
            String host = props.getProperty("host");
            String pwd = props.getProperty("pwd");
            String uname = props.getProperty("uname");
            String subject = props.getProperty("subject");
            String content = props.getProperty("content");
            String to = user.getEmail();

            content = MessageFormat.format(content, user.getCode());///替换 properties文件中的第一个占位符{0}


            Session session  = web.Utils.MailUtils.createSession(host, uname, pwd);
            Mail mail = new Mail(from, to, subject, content);
            MailUtils.send(session, mail);




            ///没有异常 注册用户成功  则保存成功信息  转发msg.jsp
            model.addAttribute("msg", "注册成功！请立即到邮箱激活！！");
            return "/msg";//------------第二个退出本方法的点
        }catch(UserException e){
            model.addAttribute("msg",e.getMessage());
            ///userservice.add(form)可能抛出两种异常 如果两种异常都抛出了呢？ 不会覆盖异常信息吗？？

            model.addAttribute("form", user);
            return "/user/regist";//-------------第三个退出本方法的点
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


   @RequestMapping("active")
    public String active(Model model,String code) throws ServletException, IOException {
       System.out.println("usercontroller...active方法....");
       // String code = model.getParameter("code");
        try {
            userService.active(code);
            model.addAttribute("msg", "激活成功！！");
            return "/msg";
        } catch (UserException e) {
            model.addAttribute("msg", e.getMessage());
            return "/msg";
        }

        ///return null;////BaseServlet中  规定  每个 mehtod  都有返回值！！！！！！！你可以看一下BaseServlet的源码
    }

   @RequestMapping("loginuser")
    public String login(User form,Model model,HttpSession session) throws ServletException, IOException {

      //  User form = CommonUtils.toBean(request.getParameterMap(), User.class);
       System.out.println("/user/loginuser.......");
        //输入校验
        Map<String,String> errors = new HashMap<String,String>();
        if(form.getUsername() == null || form.getUsername().trim().isEmpty()) {
            errors.put("username", "用户名不能为空！！");
        }else if(form.getUsername().length()<2 || form.getUsername().length()>13) {
            errors.put("username", "用户名长度需在2-13之间！！");
        }
        if(form.getPassword() == null ||form.getPassword().trim().isEmpty()) {
            errors.put("password", "密码不能为空！！");
        }

        if(errors.size() > 0 && errors != null) {
            model.addAttribute("errors", errors);
            model.addAttribute("form", form);
            return "user/login";
        }

        ///输入验证通过后
        try {
            User user = userService.login(form);//返回从数据库查出来的user  我们传递的form只有username和password两个字段
            session.setAttribute("session_user", user);///按理来说应该先把session销毁（销毁上一个session）避免用户信息泄露

            ///登录成功后 为用户分配购物车  cart   cart对象可存储在session  cookie 或数据库中
           session.setAttribute("cart", new Cart());


            return "main";
        } catch (UserException e) {
            model.addAttribute("form", form);
            model.addAttribute("msg", e.getMessage());///如果抛出多个异常  会覆盖吗
            return "msg";
        }
    }


    public String quit(HttpSession session) throws ServletException, IOException {
       session.invalidate();/////退出销毁session
        return "/main";
    }
}
