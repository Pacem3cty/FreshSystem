package com.example.freshsystem.controller;

import com.example.freshsystem.domain.Goods;

import com.example.freshsystem.service.AppletViewSupplyService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author ᛟ
 * @date 2021/6/1 - 15:13
 */
@RestController//默认返回类型为json
public class GoodsController {
    @Autowired
    private AppletViewSupplyService appletViewSupplyService;

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

    //获取所有商品列表 用于首页
    @RequestMapping(value = "/goodslist",produces = "application/json")
    public Object printAllGoodsList(){
        List<Goods> goodsList = appletViewSupplyService.getAllGoodsInfo();
        return  goodsList;
    }
}