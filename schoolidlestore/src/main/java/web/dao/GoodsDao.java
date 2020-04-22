package web.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import web.pojo.Goods;

import java.util.List;
@Repository
public interface GoodsDao {

    /**
     *查询没有删除的所有商品 删除并不是真的删除 而是将该
     *    商品的  del 字段 设为 true
     */
    @Select("select * from goods where del='false'")
    public List<Goods> findAll();


    /**
     *  根据 cid 分类查询商品
     */
    @Select("select * from goods where cid=#{cid} and del='flase'")
    public List<Goods> findByCategory(String cid);


    /**
     *  GoodsMapper.xml
     */
    Goods findByGid(String gid);

//    @Select("select * FROM goods where gid=#{gid} and del='false'")
//    public Goods findByBid(String gid) {
//        String sql = "SELECT * FROM book where bid=? and del='false'";
//        try {
//            /**
//             *  book表中  只有 cid  但cid不能直接映射成category对象 需要我们手动设置  book.setCategory
//             */
//            //	return qr.query(sql, new BeanHandler<Book>(Book.class),bid);
//
//            Map<String,Object> map = qr.query(sql, new MapHandler(),bid);
//            Category category = CommonUtils.toBean(map, Category.class);
//            Book book = CommonUtils.toBean(map, Book.class);
//            book.setCategory(category);
//            return book;
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }



    /**
     *后台删除分类时  先调用本方法  看该分类中是否有商品
     */
    @Select("select count(*) from goods where cid=#{cid}")
    public int getCountByCid(String cid);


    /**
     *   GoodsMapper.xml
     */
    void add(Goods goods);
//    public void add(Goods book) {
//
//        try {
//            String sql = "insert into book values(?,?,?,?,?,?，?)";
//            Object[] params = {book.getBid(),book.getBname(),book.getPrice(),
//                    book.getAuthor(),book.getImage(),book.getCategory().getCid(),0};
////			例如表tab_name有(col1,col2,col3，col4)4个字段。
////			只填你需要添的，就要把列名写上values后对应列值，语法：
////			insert into tab_name (col1,col2,col3) values(val1,val2,val3);
////			如果你想省略列名，那就要把所有字段的值都填上了，语法：
////			insert into tab_name values(val1,val2,val3，val4);
//            ///所以在这里 需要给最后一个表示是否删除的字段del 赋值
//            qr.update(sql, params);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }


    /**
     *   删除商品并不是真的物理删除  只是把该商品的del字段该为true
     */
   @Update("update goods set del=true where gid=#{gid}")
    public void delete(String gid);


    /**
     * GoodsDaoMapper.xml
     */
    void edit(Goods goods);
//    public void edit(Goods goods) {
//
//        try {
//            String sql  = "update book set bname=?,price=?, author=?, image=? ,cid=?  where bid=?";
//            Object[] params = {book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),
//                    book.getCategory().getCid(),book.getBid()};
//            qr.update(sql, params);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
}
