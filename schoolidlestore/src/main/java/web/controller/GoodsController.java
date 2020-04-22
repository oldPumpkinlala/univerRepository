package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.dao.GoodsDao;
import web.pojo.Goods;
import web.service.GoodsService;

import java.io.IOException;

@Controller
public class GoodsController {
  @Autowired
    private GoodsService goodsService;
    /**
     *查询所有图书
     *
     */
    public String findAll(Model model) throws IOException {
        // System.out.println("bookfindall");
        model.addAttribute("goodslist", goodsService.findAll());
        return "/goods/list";
    }
    /**
     *按分类查询图书
     *
     */
    public String findByCategory(String cid,Model model) throws IOException {

        model.addAttribute("goodslist", goodsService.findByCategory(cid));
        return "/goods/list";
    }
    /**
     * 按gid查询商品
     *
     */
    public String load(String gid,Model model) throws  IOException {

        model.addAttribute("goods", goodsService.load(gid));
        return "/goods/desc";
    }

    /**
     * 删除商品
     */
    public String delete(String gid) throws IOException {

        goodsService.delete(gid);
      //  return findAll(request,response);
        return "/goods/list";
    }

    /**
     *   编辑商品
     */
    public String edit(Goods goods) throws IOException {
        goodsService.edit(goods);
        return "/goods/list";
//        Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
//        Category category  = CommonUtils.toBean(request.getParameterMap(), Category.class);
//        book.setCategory(category);
//        bookservice.edit(book);
//        return findAll(request,response);
    }
}
