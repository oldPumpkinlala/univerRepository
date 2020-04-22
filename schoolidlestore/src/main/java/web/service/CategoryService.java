package web.service;

import web.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     *
     * 查询所有分类
     */
    public List<Category> findAll();

    /**
     *  添加分类
     */
    public void add(Category category) throws CategoryException ;

    /**
     * 删除分类
     */
    public void delete(String cid) throws CategoryException ;

    /**
     * 根据 cid 加载分类对象
     */
    public Category load(String cid);

    /**
     * 编辑修改分类
     */
    public void edit(String cid, String cname) ;
}
