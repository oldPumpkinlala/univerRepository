package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CategoryService;

import java.io.IOException;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("findallcategory")
    public String findAll(Model model) throws IOException {
        model.addAttribute("categorylist", categoryService.findAll());
        return "left";
    }

}
