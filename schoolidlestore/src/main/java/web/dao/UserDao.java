package web.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import web.pojo.User;

@Repository  //此注解代表这是一个持久层，
public interface UserDao {
    /**
     * 按用户名查询User
     */
    @Select("SELECT * FROM tb_user where username=#{username}")
    public User findByUsername(String username);
    /**
     *  按邮件名查询User
     */
    @Select("SELECT * FROM tb_user where email=#{email}")
    public User findByEmail(String email);
    /**
     * 向数据库中添加用户
    */
    @Insert("insert into tb_user(uid,username,password,email,code) values(#{uid},#{username},#{password},#{email},#{code})")
    public void add(User user);

    /**
     *根据激活码查询用户
     */
    @Select("SELECT * from tb_user where code=#{code}")
    public User findByCode(String code);

    /**
     *更新用户的激活状态
     */
    @Update("UPDATE tb_user set state=#{b} where code=#{code}")
    public void update(@Param("b")boolean b,@Param("code")String code);
    //Mybatis是按顺序传递参数的
    //当只有一个参数时，dao接口的方法中可不用添加注解。Mybatis可成功匹配参数。
    //当大于一个参数时，dao接口的方法中需要使用注解@Param(“XXX”)为Mybatis指定参数名称
}
