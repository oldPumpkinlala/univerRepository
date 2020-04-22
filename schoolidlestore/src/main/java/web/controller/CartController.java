package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import web.pojo.Cart;
import web.pojo.CartItem;
import web.pojo.Goods;
import web.service.GoodsService;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CartController {

    @Autowired
    private GoodsService goodsService;


    /**   向购物车添加条目
     */
    public String add(HttpSession session,String cnt,String gid) throws IOException {

        Cart cart = (Cart)session.getAttribute("cart");///登录成功后添加到session的cart对象

        Integer count  = Integer.parseInt(cnt);//获取该商品的购买数量

        Goods book = goodsService.load(gid);//获取该商品的gid

        CartItem cartitem = new CartItem(book,count);//生成一个购物车条目


        cart.add(cartitem);////向购物车添加购物条目
        return "cart/list";
    }

    /**  清空购物车
     */
    public String clear(HttpSession session) throws IOException {

        Cart cart = (Cart) session.getAttribute("cart");///登录成功后添加到session的cart对象

        cart.clear();
        return "cart/list";
    }

    /**    删除某个条目
     */
    public String delete(HttpSession session,String gid) throws IOException {


        Cart cart = (Cart) session.getAttribute("cart");///登录成功后添加到session的cart对象

        cart.delete(gid);
        return "cart/list";
    }

}
