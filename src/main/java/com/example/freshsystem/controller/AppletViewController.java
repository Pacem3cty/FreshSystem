package com.example.freshsystem.controller;

import com.example.freshsystem.service.AppletViewSupplyService;
import com.example.freshsystem.service.GetOrderHistoryService;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ᛟ
 * @date 2021/6/1 - 15:13
 */

@RestController//默认返回类型为json
public class AppletViewController {

    @Autowired
    private AppletViewSupplyService appletViewSupplyService;
    @Autowired
    GetOrderHistoryService getOrderHistoryService;

    public static JSONObject getJSONObject(HttpServletRequest request) throws IOException, JSONException {//获取小程序发送至后台的数据并转成JSON类型
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));//服务端Socket对象中得到输入流
        StringBuffer sb = new StringBuffer();//定义可变长字符串对象
        String s = null;
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        JSONObject jsonObject = new JSONObject(sb.toString());//将JSON字符串转换为JSON对象
        return jsonObject;
    }

//    //获取所有商品列表 用于首页
//    @RequestMapping(value = "/goodslist",produces = "application/json")
//    public Object printAllGoodsList(){
//        List<Goods> goodsList = appletViewSupplyService.getAllGoodsInfo();
//        return goodsList;
//    }

//    @RequestMapping(value = "/getAllGoodsInfo", produces = "application/json")
//    public @ResponseBody String getAllGoodsInfo(){
//        String allGoodsListInfo = appletViewSupplyService.getAllGoodsInfo().toString();
//        return allGoodsListInfo;
//    }

//    @RequestMapping("/getAllGoodsInfo")
//    @ResponseBody
//    public JSONObject getAllGoodsInfoJSON() throws JSONException {
//        JSONObject jsonObject = new JSONObject();
//        List<Goods> allGoodsInfo = appletViewSupplyService.getAllGoodsInfo();
//        jsonObject.put("allGoodsInfo",allGoodsInfo);
//        String goodsInfo = appletViewSupplyService.getGoodsInfo();
//        return jsonObject;
//    }

    @RequestMapping(value = "getAllGoodsInfo01")
    @ResponseBody
    public String getGoodsInfo() throws JSONException {
        return appletViewSupplyService.getGoodsInfo();
    }

    @RequestMapping(value = "getAllGoodsInfo02")
    @ResponseBody
    public Map<String,Object> getGoodsInfoMapType() throws JSONException {
        return appletViewSupplyService.getGoodsInfoMapType();
    }


    @ResponseBody
    @RequestMapping(value = "getMyOrderHistory",method = RequestMethod.POST)
    public Map<String,String> getMyOrderHistory(HttpServletRequest request) throws IOException, JSONException {
        String personPhone = getJSONObject(request).getString("personPhone");
//    public Map<String,String> getMyOrderHistory(@RequestBody String personPhone){
        System.out.println("personPhone = " + personPhone);
        //发送的请求当中，需要一个phone字符串即可
        Map<String,String> map = new HashMap();     //创建待返回对象
        //获取到历史记录，并放入到map当中返回
//        System.out.println("getOrderHistoryService.getMyOrderHistory(personPhone) = " + getOrderHistoryService.getMyOrderHistory(personPhone));
        map.put("history",getOrderHistoryService.getMyOrderHistory(personPhone));
        return map;
    }

}