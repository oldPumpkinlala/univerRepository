package web.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CategoryDao;
import web.dao.GoodsDao;
import web.pojo.Category;
import web.service.CategoryException;
import web.service.CategoryService;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private GoodsDao goodsDao;

    //查询所有分类
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
  //添加分类
    public void add(Category category) throws CategoryException {
        Category caty = categoryDao.findByCname(category.getCname());
        if(caty != null)throw new CategoryException("已有该商品分类，请不要重复添加！！");

        categoryDao.addCategory(category);
    }
   //删除分类
    public void delete(String cid) throws CategoryException {

        int count = goodsDao.getCountByCid(cid);
        ////我们查询的是哪张表   查询的是goods表  看goods表中有多少个该分类下的商品 所以写在GoodsDao下  跨膜块
        if(count > 0 )throw new CategoryException("该分类下还有图书，删除分类失败！！！");
        ///如果该分类下没有商品  那么删除
        categoryDao.delete(cid);
    }

    public Category load(String cid) {
        return categoryDao.fingByCid(cid);
    }

    public void edit(String cid, String cname) {
        categoryDao.edit(cid,cname);

    }
}
