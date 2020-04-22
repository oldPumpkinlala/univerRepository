package web.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import web.pojo.Category;

import java.util.List;

@Repository
public interface CategoryDao {


    /**
     *  查询数据库中的所有分类
     */
    @Select("SELECT * FROM category")
    public List<Category> findAll();

    /**
     *  后台添加分类之前  先查询数据库看是否已有该分类
     */
    @Select("select * from category where cname=#{cname}")
    public Category findByCname(String cname);

    /**
     *  后台添加分类
     */
    @Insert("insert into category values(#{cid},#{cname})")
    public void addCategory(Category category);


   @Delete("delete from category where cid=#{cid}")
    public void delete(String cid);

   @Select("select * from category where cid=#{cid}")
    public Category fingByCid(String cid);

    /**
     * 修改分类
     */
    @Update("update category set cname=#{cname} where cid=#{cid}")
    public void edit( @Param("cname")String cname,@Param("cid")String cid);
    //Mybatis是按顺序传递参数的
    //当只有一个参数时，dao接口的方法中可不用添加注解。Mybatis可成功匹配参数。
    //当大于一个参数时，dao接口的方法中需要使用注解@Param(“XXX”)为Mybatis指定参数名称

}
