package web.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private String oid;
    private Date ordertime;/////java.util.Date  不嫩使用java.sql下的Date   java.sql包中的东西只能出现在dao中
    private Double total;
    private int state;
    private User owner;/////数据库表中的uid  在bean中直接写对应的对象
    private  String address;

    private List<OrderItem> orderitemlist;
    //private List<OrderItem> orderitemlist = new ArrayList<OrderItem>();/////反向关联  这个订单下有哪些订单条目
    //////这里应该要 new 吧  不然不会报空指针异常吗？？？？
    //// order表里面 并没有 orderitemlist 这个字段


    public List<OrderItem> getOrderitemlist() {
        return orderitemlist;
    }
    public void setOrderitemlist(List<OrderItem> orderitemlist) {
        this.orderitemlist = orderitemlist;
    }



    public String getOid() {
        return oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }
    public Date getOrdertime() {
        return ordertime;
    }
    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", owner="
                + owner + ", address=" + address + "]";
    }
    public Order(String oid, Date ordertime, Double total, int state, User owner, String address) {
        super();
        this.oid = oid;
        this.ordertime = ordertime;
        this.total = total;
        this.state = state;
        this.owner = owner;
        this.address = address;
    }
    public Order() {

    }

}
