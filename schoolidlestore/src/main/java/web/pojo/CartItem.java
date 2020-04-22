package web.pojo;

import java.math.BigDecimal;

public class CartItem {
    private Goods goods;
    private int count;///一种商品可能购买多个

    public double getSubTotal() {////////返回一个条目的小计
        BigDecimal price = new BigDecimal(goods.getPrice()+"");///因为BigDecimal必须使用String 构造器
        BigDecimal cnt = new BigDecimal(count+"");
        return cnt.multiply(price).doubleValue();///BigDecimal 的父亲是Number类型   所有Number类型都可转换成Double类型 doubleValue()
    }
    public Goods getGoods() {
        return goods;
    }
    public void setBook(Goods goods) {
        this.goods = goods;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "CartItem [goods=" + goods + ", count=" + count + "]";
    }
    public CartItem() {
        super();
        // TODO Auto-generated constructor stub
    }
    public CartItem(Goods goods, int count) {
        super();
        this.goods = goods;
        this.count = count;
    }
}
