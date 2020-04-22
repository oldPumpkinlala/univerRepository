package web.pojo;

public class OrderItem
{
    private String iid;
    private Double subtotal;
    private Goods goods;   ////关联 Goods商品类
    private Order order; //////关联Order类    该订单条目属于哪个订单   主外键
    private int count;
    public String getIid() {
        return iid;
    }
    public void setIid(String iid) {
        this.iid = iid;
    }
    public Double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    public Goods getGoods() {
        return goods;
    }
    public void setBook(Goods goods) {
        this.goods = goods;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "OrderItem [iid=" + iid + ", subtotal=" + subtotal + ", goods=" + goods + ", order=" + order + ", count="
                + count + "]";
    }
    public OrderItem(String iid, Double subtotal, Goods goods, Order order, int count) {
        super();
        this.iid = iid;
        this.subtotal = subtotal;
        this.goods = goods;
        this.order = order;
        this.count = count;
    }
    public OrderItem() {
        super();
        // TODO Auto-generated constructor stub
    }
}
