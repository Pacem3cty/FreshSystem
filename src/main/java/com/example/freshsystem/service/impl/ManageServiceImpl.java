package com.example.freshsystem.service.impl;

import com.example.freshsystem.dao.GoodsDao;
import com.example.freshsystem.dao.ManageDao;
import com.example.freshsystem.dao.OrderDao;
import com.example.freshsystem.domain.Goods;
import com.example.freshsystem.domain.Order;
import com.example.freshsystem.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
/**
 * @author zhuizhuaaa
 * @date 2021/6/4 - 23:54
 */
@Service("manageService")
public class ManageServiceImpl implements ManageService {
    @Autowired
    ManageDao manageDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> getAllInfo() {
        return manageDao.selectAll();
    }

    @Override
    public List<Goods> getFruitsInfo() {
        List<Goods> goods=manageDao.selectFruits();
        return goods;
    }

    @Override
    public List<Goods> getFrozenInfo() {
        List<Goods> goods=manageDao.selectFrozenFoods();
        return goods;
    }

    @Override
    public List<Goods> getEdibleWineInfo() {
        List<Goods> goods=manageDao.selectEdibleWine();
        return goods;
    }

    @Override
    public List<Goods> getImportedSnacksInfo() {
        List<Goods> goods=manageDao.selectImportedSnacks();
        return goods;
    }

    @Override
    public List<Goods> getCasualSnacksInfo() {
        List<Goods> goods=manageDao.selectCasualSnacks();
        return goods;
    }

    @Override
    public List<Goods> getInstantNoodlesInfo() {
        List<Goods> goods=manageDao.selectInstantNoodles();
        return goods;
    }

    @Override
    public List<Goods> getInstantPreparationInfo() {
        List<Goods> goods=manageDao.selectInstantPreparation();
        return goods;
    }

    @Override
    public List<Goods> getRawMilkInfo() {
        List<Goods> goods=manageDao.selectRawMilk();
        return goods;
    }

    @Override
    public List<Goods> getWaterTeaInfo() {
        List<Goods> goods=manageDao.selectWaterTea();
        return goods;
    }

    @Override
    public List<Goods> getGrainSeasoningInfo() {
        List<Goods> goods=manageDao.selectGrainSeasoning();
        return goods;
    }

    @Override
    public List<Goods> getSeafoodInfo() {
        List<Goods> goods=manageDao.selectSeafood();
        return goods;
    }

    @Override
    public List<Goods> getFarmEggsInfo() {
        List<Goods> goods=manageDao.selectFarmEggs();
        return goods;
    }

    @Override
    public List<Goods> getMeatInfo() {
        List<Goods> goods=manageDao.selectMeat();
        return goods;
    }

    @Override
    public List<Goods> getFreshVegetablesInfo() {
        List<Goods> goods=manageDao.selectFreshVegetables();
        return goods;
    }

    @Override
    public List<Goods> getImportedFruit() {
        List<Goods> goods=manageDao.selectImportedFruit();
        return goods;
    }

    @Override
    public List<Order> getOrderInfo() {
        List<Order> orders = orderDao.selectAllOrder();
        return orders;
    }

    @Override
    public boolean updateOrder(String orderId, BigDecimal orderPrice, String consignNum, String consignAddress, String deliverymanId, int isReturn) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderPrice(orderPrice);
        order.setConsignNum(consignNum);
        order.setConsignAddress(consignAddress);
        order.setDeliverymanId(deliverymanId);
        order.setIsReturn(isReturn);
        return orderDao.updateOrder(order);
    }

    @Override
    public void addgoods(String goodsId, String type, String brand, String goodsName, BigDecimal price, String img, String netwt, int quantity, String origin) {
        Goods goods=new Goods(goodsId, type,brand, goodsName, price, img, netwt,quantity, origin);
        manageDao.insertGoodsImformations(goods);

    }
    @Override
    public void updateGoods(String goodsId, String type, String brand, String goodsName, BigDecimal price, String img, String netwt, int quantity, String origin){
       Goods goods=new Goods(goodsId, type,brand, goodsName, price, img, netwt,quantity, origin);
       manageDao.updateGoods(goods);

    }

    @Override
    public void deleteGoods(String goodsId) {
        manageDao.deleteGoods(goodsId);
    }

}
