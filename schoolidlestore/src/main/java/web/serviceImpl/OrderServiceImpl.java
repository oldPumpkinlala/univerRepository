package web.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.OrderDao;
import web.pojo.Order;
import web.service.OrderException;
import web.service.OrderService;

import java.sql.SQLException;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    //SSM框架下的事务
    @Transactional
    public void add(Order order) {
        try {


            orderDao.add(order);
            orderDao.addOrderItem(order.getOrderitemlist());


        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    public List<Order> findByUid(String uid) {
        List<Order> orderlist = orderDao.findByUid(uid);

        return orderlist;
    }

    public Order loadOrder(String oid) {

        return orderDao.loadOrder(oid);
    }

    public void confirm(String oid) throws OrderException {
        ///先查看数据库中改订单的状态是不是3   因为有商家可能会在地址栏直接输入/OrderServlet?method=confirm
        /////这样还没有发货  就确认了    但是商家不能访问数据库   管理员才能
        if(orderDao.getstateByOid(oid) != 3) throw new OrderException("确认收货失败，您不是什么好人！！！");

        orderDao.updateState(4, oid);////如果确认数据库中该订单的状态为3   则确认收货成功
    }
}
