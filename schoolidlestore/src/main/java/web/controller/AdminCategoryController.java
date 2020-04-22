package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.Utils.CommonUtils;
import web.pojo.Category;
import web.service.CategoryException;
import web.service.CategoryService;

import java.io.IOException;
import java.util.List;

@Controller
public class AdminCategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     *  查询所有分类
     */
    @RequestMapping("")
    public String findAll(Model model) throws IOException {

        List<Category> categorylist = categoryService.findAll();
        //	System.out.println(categorylist);
        model.addAttribute("categorylist", categorylist);
        return "adminjsps/admin/category/list";
    }

    /**
     * 添加分类
     */
    public String add(Category category,Model model) throws  IOException {

        //String cname = request.getParameter("cname");
     //   Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
        category.setCid(CommonUtils.uuid());////为分类生成cid

        try {
            categoryService.add(category);
        } catch (CategoryException e) {
            model.addAttribute("msg", e.getMessage());////如果已有该分类  抛出异常
            return "adminjsps/msg";
        }

        /////findAll(request,response);  开始直接这样写 没加 return  显示空白
        return  "adminjsps/admin/category/list";
      //  return findAll(request,response);//////添加分类完成后  显示分类   看有没有添加成功

        //-------------------------------------------------
        ////上面这句应该怎么写
        //------------------------------------------------------

    }

    public String delete(String cid,Model model) throws IOException {

        try {
            categoryService.delete(cid);
            return "adminjsps/admin/category/list";
           // -----------------------------return findAll(request,response);
        } catch (CategoryException e) {
            model.addAttribute("msg", e.getMessage());
            return "adminjsps/msg";
        }

    }

    /**
     * 修改分类之前 先把 当前分类显示到 mod.jsp
     */
    public String editPre(String cid,Model model) throws IOException {


        model.addAttribute("category",categoryService.load(cid));
        return "adminjsps/admin/category/mod";
    }
    public String edit(String cid,String cname) throws IOException {
        System.out.println("edit......");

        System.out.println(cid);
        System.out.println(cname);
        categoryService.edit(cid,cname);
        return "adminjsps/admin/category/list";
        //-------------------------------------return findAll(request,response);
    }
}
