package web.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import web.pojo.Order;
import web.pojo.OrderItem;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrderDao {

    //@Insert("insert into orders values(#{oid},#{orderitem},#{total},#{state},#{uid},#{address})")
    public void add(Order order);
        /**
         *   order中的time是 java.util.Date   要把java.util.Date 转成java.sql.Date
         */
      //  Timestamp timestamp = new Timestamp(order.getOrdertime().getTime());
        ///getTime()转换成毫秒数
        //new TimeStamp(传入的是毫秒数)   java.sql.TimeStamp

    /**
     * 当库中有多条的数据需要修改等操作时,一条一条去update,必定不是一个好方法.  批量处理
     */
    //?????????????????????????????????????????????????????????????????
    public void addOrderItem(List<OrderItem> orderitemlist) ;
//    {
//        String sql = "insert into orderitem values(?,?,?,?,?)";
//        //创建一个二维数组  为这个二维数组赋值    批处理直接传递sql 和这个二维数组
//        Object[][] params = new Object[orderitemlist.size()][];   //用我们传递过来的参数的长度 为数组的第一维赋值
//        for(int i=0 ; i < orderitemlist.size() ;i++) {
//            OrderItem item  = orderitemlist.get(i); ///这个是我们传递参数传过来的
//
//
//            params[i] = new Object[]{item.getIid(),item.getCount(),item.getSubtotal(),
//                    item.getOrder().getOid(),item.getBook().getBid()};
//        }
//        try {
//            qr.batch(sql, params);
//        } catch (SQLException e) {
//            throw  new RuntimeException(e);
//        }
//    }

    /**
     *   根据当前session中的uid查询出 order  再遍历每个order  得到 orderitem
     */
    public List<Order> findByUid(String uid);
//    {
//        String sql = "SELECT * FROM orders where uid = ?";
//        try {
//
//            List<Order> orderlist = qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
//            //数据库表orders 中的字段 uid  但Order类中并没有 uid这个属性  只有owner
//            // 但是uid也不会自动生成owner 虽然上述语句返回的order对象
//            // 但order对象中的owner属性不是上面这条查询语句自动生成的 而是我们从session中获取的
//            for(Order order:orderlist) {///遍历这个用户的订单
//                loadOrderitem(order);/////加载这个订单的订单条目   Order类中有一个 orderitemlist属性
//            }
//            return orderlist;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    /**
     *  加载参数对应的订单中的条目
     */
    public void loadOrderitem(Order order);
//    {
//        String sql = "select * from orderitem i,book b where i.bid=b.bid and i.oid=?";
//        List<Map<String, Object>> mapList;
//        try {
//            ///因为一行结果集对应的不是一个JavaBean  所以不能使用BeanHandler
//            mapList = qr.query(sql, new MapListHandler(),order.getOid());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        List<OrderItem> orderitemlist = new ArrayList<OrderItem>();
//        for(Map<String,Object> map : mapList) {
//            OrderItem orderitem = toOrderItem(map);
//            orderitemlist.add(orderitem);
//        }
//
//        order.setOrderitemlist(orderitemlist);
//
//    }



    //////查询 传入的  订单状态
    public int getstateByOid(String oid);
//    {
//        String sql = "select state from orders where oid=?";
//        try {
//            Number state = (Number)qr.query(sql, new ScalarHandler(),oid);
//            System.out.println(state);
//            return state.intValue();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
       public Order loadOrder(String oid) ;
       //{
//    String sql = "select * from orders where oid=?";
//
//    try {
//
//        ///按照订单id查询  order
//        Order  order = qr.query(sql, new BeanHandler<Order>(Order.class),oid);
//        ////加载这个order 的 orderitem
//        loadOrderitem(order);
//        return order;
//
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
//
//}
    ////修改传入的订单状态
    @Update("update orders set state=#{state} where oid=#{oid}")
    public void updateState(@Param("state")int state,@Param("oid")String oid);
}
