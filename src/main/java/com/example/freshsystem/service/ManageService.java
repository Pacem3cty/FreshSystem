package com.example.freshsystem.service;

import com.example.freshsystem.domain.Goods;
import com.example.freshsystem.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public interface ManageService {
    //对各种类别商品进行查询
    List<Goods> getAllInfo();

    List<Goods> getFruitsInfo();//时令水果

    List<Goods> getFrozenInfo();//速冻食品

    List<Goods> getEdibleWineInfo();//食用酒品

    List<Goods> getImportedSnacksInfo();//进口零食

    List<Goods> getCasualSnacksInfo();//休闲零食

    List<Goods> getInstantNoodlesInfo();//方便面

    List<Goods> getInstantPreparationInfo();//速溶冲调

    List<Goods> getRawMilkInfo();//生鲜牛奶

    List<Goods> getWaterTeaInfo();//水饮名茶

    List<Goods> getGrainSeasoningInfo();//粮油调味

    List<Goods> getSeafoodInfo();//海鲜水产

    List<Goods> getFarmEggsInfo();//农家鸡蛋

    List<Goods> getMeatInfo();//精选肉类

    List<Goods> getFreshVegetablesInfo();//新鲜蔬菜

    List<Goods> getImportedFruit();//进口水果

    List<Order> getOrderInfo();

    boolean updateOrder(String orderId,BigDecimal orderPrice,String consignNum,String consignAddress, String deliverymanId,int isReturn);
    //增加商品
    void addgoods(String goodsId, String type, String brand, String goodsName, BigDecimal price, String img, String netwt, int quantity, String origin);
     //更新商品信息
    void updateGoods(String goodsId, String type, String brand, String goodsName, BigDecimal price, String img, String netwt, int quantity, String origin);
    //删除商品信息
    void deleteGoods(String goodsId);
}