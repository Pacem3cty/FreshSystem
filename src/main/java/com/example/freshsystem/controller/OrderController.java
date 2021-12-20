package com.example.freshsystem.controller;

import com.example.freshsystem.domain.OrderEntity;
import com.example.freshsystem.domain.ShoppingListUnit;
import com.example.freshsystem.service.CustomerOrderService;

import com.example.freshsystem.service.GetOrderHistoryService;
import org.json.JSONException;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.*;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ᛟ
 * @date 2021/6/12 - 16:46
 */
@RestController
public class OrderController {
    @Autowired
    CustomerOrderService customerOrderService;

    public static org.json.JSONObject getJSONObject(HttpServletRequest request) throws IOException, org.json.JSONException {//获取小程序发送至后台的数据并转成JSON类型
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));//服务端Socket对象中得到输入流
        StringBuffer sb = new StringBuffer();//定义可变长字符串对象
        String s = null;
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        org.json.JSONObject jsonObject = new org.json.JSONObject(sb.toString());//将JSON字符串转换为JSON对象
        return jsonObject;
    }

    @RequestMapping(value ="/placeAnOrder",method = RequestMethod.POST)//下单操作 从前端获取购买链表 登录号码 收货号码 收货地址
//    public void placeAnOrder(HttpServletRequest request) throws IOException, JSONException {
    public void placeAnOrder(@RequestBody OrderEntity orderEntity){
        System.out.println("shoppingListUnits = "+orderEntity.getShoppingListUnits()+" personPhone = " + orderEntity.getPersonPhone() + " consignNum = " + orderEntity.getConsignNum() + " consignAddress = " + orderEntity.getConsignAddress());
        //System.out.println("orderEntity.getShoppingListUnits() = " + orderEntity.getShoppingListUnits());
        customerOrderService.placeAnOrder(orderEntity.getShoppingListUnits(),orderEntity.getPersonPhone(), orderEntity.getConsignNum(), orderEntity.getConsignAddress());//后端对数据库生成订单操作执行完成后 返回boolean值到前端
    }

    @RequestMapping(value ="/cancelOrder",method = RequestMethod.POST)//退单 从前端获取订单号
    public boolean cancelOrder(HttpServletRequest request) throws IOException,JSONException {
//    public boolean cancelOrder(@RequestBody String orderId){
        String orderId = getJSONObject(request).getString("orderId");
        System.out.println("orderId=" + orderId);
        return customerOrderService.cancelAnOrder(orderId);//后端对数据库取消订单操作执行完成后 返回boolean值到前端
    }

    @RequestMapping(value ="/deleteOrder",method = RequestMethod.POST)//退单 从前端获取订单号
    public boolean deleteOrder(HttpServletRequest request) throws IOException,JSONException {
//    public boolean cancelOrder(@RequestBody String orderId){
        String orderId = getJSONObject(request).getString("orderId");
        System.out.println("orderId=" + orderId);
        return customerOrderService.deleteAnOrder(orderId);//后端对数据库取消订单操作执行完成后 返回boolean值到前端
    }
}
