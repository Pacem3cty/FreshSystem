package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springboot.enitiy.Goods;
import springboot.enitiy.GoodsDao;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 11:38
 */

@Service
public class MyServiceImpl1 implements MyService{

    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> printInfo() {
        List<Goods> allGoods = goodsDao.getAllGoods();
        for (Goods good : allGoods) {
            System.out.println(good);
        }
        System.out.println("it has invoke the method in MyServiceImpl 1");
        return allGoods;
    }
}
