package web.pojo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
    ///用goods的gid做键   更好查询   若用List 每次都要循环遍历查询gid相同的在添加   gid就相当于一种商品的id

  //获取当前购物车中的商品总价格
    public double getTotals() {
        BigDecimal total = new BigDecimal("0");
        for(CartItem cartitem:map.values()) {
            BigDecimal subtotal = new BigDecimal(cartitem.getSubTotal()+"");
            total = total.add(subtotal);

        }
        return total.doubleValue();
    }

    ///向购物车添加条目
    public  void add(CartItem cartitem) {
        if(map.containsKey(cartitem.getGoods().getGid())) {/////如果传入的这个条目对应的商品id存在map中
            CartItem _cartitem = map.get(cartitem.getGoods().getGid());//获取购物车中该条目对象_cartitem
            _cartitem.setCount(_cartitem.getCount()+cartitem.getCount());//将新条目中的数量 已添加到和购物车本条目的商品数量数相加
            map.put(_cartitem.getGoods().getGid(), _cartitem);
        }else {
            map.put(cartitem.getGoods().getGid(), cartitem);///如不存在  说明这个条目对应的商品还没有加入到购物车中过
        }
    }


    ////清空购物车
    public  void clear() {
        map.clear();///清空map就可
    }


    ///删除某个商品
    public  void delete(String gid) {
        map.remove(gid);
    }

    /////获取所有条目
    public Collection<CartItem> getCartItems(){/////CartItems并不是 Cart类的成员变量  但在jsp页面 可以
        ///////通过${cart.cartItems}    cartItems是属性吗？？？？？
        return  map.values();/////通过values()方法  获取集合中所有的值
    }
}
