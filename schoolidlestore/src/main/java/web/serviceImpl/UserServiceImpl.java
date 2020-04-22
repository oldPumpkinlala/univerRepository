package web.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.pojo.User;
import web.service.UserException;
import web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    //光标放在需要修改的变量名上，然后shift + F6  同事修改所有同名变量
    @Override
    public void regist(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());
        if(user != null)throw new UserException("用户名已存在！！");

        user = userDao.findByEmail(form.getEmail());
        if(user != null)throw new UserException("该邮箱已经注册过了！！");

        ///user 为  null  则添加用户
        userDao.add(form);
    }

    @Override
    public void active(String code) throws UserException {
        User user = userDao.findByCode(code);

        if(user == null) throw new UserException("没有该激活码对应的用户，激活码无效！！！");

        if(user.isState())throw new UserException("该用户已激活，请不要重复激活！！");

        userDao.update(true,code);
    }

    @Override
    public User login(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());

        if(user == null)throw new UserException("该用户不存在！！");

        if(!user.isState())throw new UserException("该用户尚未激活！！");

        if(!form.getPassword().equals(user.getPassword()))
            throw new UserException("密码错误！！！");

        return user;
    }
}
