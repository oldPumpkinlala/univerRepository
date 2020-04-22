package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    //src=

    @RequestMapping("top")
    public String top(){
        System.out.println("top....");
        return "top";
    }

    @RequestMapping("body")
    public String body(){
        System.out.println("body....");
        return "body";
    }

    @RequestMapping("left")
    public String left(){
        System.out.println("left....");
        return "left";
    }

    //href=

    @RequestMapping("index")
    public String index(){

        return "index";
    }
    @RequestMapping("login")
    public String login(){

        return "/user/login";
    }
    @RequestMapping("regist")
    public String regist(){
        return "/user/regist";
    }

    @RequestMapping("goodslist")
    public String goodslist(){
        return "cart/list";
    }
}
