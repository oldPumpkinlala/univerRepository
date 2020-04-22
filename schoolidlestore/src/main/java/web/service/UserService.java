package web.service;

import web.pojo.User;

public interface UserService {
    /**
     *用户注册
     */
    public void regist(User form) throws UserException;

    /**
     *每一个用户的激活码不同  根据传入的激活码查找用户并激活
     */
    public void active(String code) throws UserException;

    /**
     *用户登录
     */
    public User login(User form) throws UserException;
}
