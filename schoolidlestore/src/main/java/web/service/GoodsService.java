package web.service;

import web.pojo.Goods;

import java.util.List;

public interface GoodsService {

    /**
     *   查询所有商品
     */
    public List<Goods> findAll();

    /**
     *  根据分类 cid  查询商品
     */
    public List<Goods> findByCategory(String cid);

    /**
     *  根据商品 gid  查询商品
     */
    public Goods load(String gid);

    /**
     *  添加商品
     */
    public void add(Goods goods);

    /**
     *  删除指定 gid 的商品 将该商品的 del 字段 设为true
     */
    public void delete(String gid);

    /**
     *   修改 编辑商品
     */
    public void edit(Goods goods);
}
