package com.example.freshsystem.controller;

import com.example.freshsystem.domain.Goods;
import com.example.freshsystem.domain.Order;
import com.example.freshsystem.domain.Staff;
import com.example.freshsystem.service.ManageService;
import org.codehaus.jettison.json.JSONException;
import org.junit.platform.commons.function.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ManageController {
    @Autowired
    ManageService manageService;
    @RequestMapping(value = "/printFruits", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Goods> printFruits(){
        return manageService.getAllInfo();
    }

    @RequestMapping(value = "/addFruits", produces = {"application/json;charset=UTF-8"})
    public boolean addFruits(@RequestBody Goods goods) {
        String goodsId=goods.getGoodsId();
        String type=goods.getType();
        String img=goods.getImg();
        String brand=goods.getBrand();
        String goodsName=goods.getGoodsName();
        BigDecimal price=goods.getPrice();
        String netwt=goods.getNetwt();
        int quantity=goods.getQuantity();
        String origin=goods.getOrigin();
        System.out.println("bbb");
        try {
            manageService.addgoods(goodsId,type,brand,goodsName,price, img,netwt,quantity, origin);

        }catch (Exception e){
            return false;
        }
       return  true;
    }

    @RequestMapping(value = "/updateGoods",produces = "application/json;charset=UTF-8")
    public void updateGoods(@RequestBody Goods goodss) {
        String goodsId = goodss.getGoodsId();
        String type = goodss.getType();
        String img = goodss.getImg();
        String brand = goodss.getBrand();
        String goodsName = goodss.getGoodsName();
        BigDecimal price = goodss.getPrice();
        String netwt = goodss.getNetwt();
        int quantity = goodss.getQuantity();
        String origin = goodss.getOrigin();
        manageService.updateGoods(goodsId, type, brand, goodsName, price, img, netwt, quantity, origin);
        System.out.println(goodss);

    }

    @RequestMapping(value = "/deleteGoods",produces = "application/json;charset=UTF-8")
    public void deletdeGoods(String goodsId){
        System.out.println("aaa");
        manageService.deleteGoods(goodsId);

    }

    @RequestMapping(value = "/printOrder", produces = {"application/json;charset=UTF-8"})
    public List<Order> printAllOrder(){
        return manageService.getOrderInfo();
    }

    @RequestMapping(value = "/updateOrder",produces = "application/json;charset=UTF-8")
    public List<Order> updateOrder(String orderId,BigDecimal orderPrice,String consignNum,String consignAddress, String deliverymanId,int isReturn){//修改员工信息
        manageService.updateOrder(orderId,orderPrice,consignNum,consignAddress,deliverymanId,isReturn);
        return manageService.getOrderInfo();
    }





}
