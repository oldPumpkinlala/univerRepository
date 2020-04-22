package web.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.GoodsDao;
import web.pojo.Goods;
import web.service.GoodsService;

import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsdao;

    public List<Goods> findAll() {
        return goodsdao.findAll();
    }

    public List<Goods> findByCategory(String cid) {
        return goodsdao.findByCategory(cid);
    }

    public Goods load(String gid) {
        return goodsdao.findByGid(gid);
    }

    //后台添加图书
    public void add(Goods goods) {
        goodsdao.add(goods);
    }

    public void delete(String gid) {
        goodsdao.delete(gid);

    }

    public void edit(Goods goods) {

        goodsdao.edit(goods);

    }
}
