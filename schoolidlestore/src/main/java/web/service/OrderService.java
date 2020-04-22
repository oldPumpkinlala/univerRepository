package web.service;

import web.pojo.Order;

import java.util.List;

public interface OrderService {
    /**
     *  添加订单
     */
    public void add(Order order);

    /**
     * 根据uid 查找这个用户的所有订单
     */
    public List<Order> findByUid(String uid);

    /**
     *  加载指定订单
     */
    public Order loadOrder(String oid);

    /**
     * 确认订单状态的修改
     */
    public void confirm(String oid) throws OrderException;
        ///先查看数据库中改订单的状态是不是3   因为有商家可能会在地址栏直接输入/OrderServlet?method=confirm
        /////这样还没有发货  就确认了    但是商家不能访问数据库   管理员才能

}
