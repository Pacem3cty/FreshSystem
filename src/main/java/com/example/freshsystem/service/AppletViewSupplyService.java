package com.example.freshsystem.service;

import com.example.freshsystem.dao.GoodsDao;
import com.example.freshsystem.domain.BuyRecord;
import com.example.freshsystem.domain.Goods;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-03 17:15
 */


//为小程序前端信息提供服务
@Service
public class AppletViewSupplyService {

    @Autowired
    GoodsDao goodsDao;

    //  获取顾客锁能看到的商品信息
    public List<Goods> getAllGoodsInfo(){
        List<Goods> goodsList = goodsDao.selectAllGoods();
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
        return goodsList;
    }

    public String getGoodsInfo() throws JSONException {

        JSONObject jsonObject = new JSONObject();

        //商品列表，需要处理的信息
        List<Goods> goodsList = goodsDao.selectAllGoods();

        //类型链表，分类返回
        List<String> typeList = new ArrayList<>();

        //获取类型List
        {
            //获取第一个商品的类型
            String type = goodsList.get(0).getType();
            typeList.add(type);        //把第一个类型放入类型链表

            for (Goods goods : goodsList) {
                String currentType = goods.getType();
                //看看和上一个是不是一样的
                if (type.equals(currentType)){      //如果一样
                    continue;                   //什么也不做
                }else {                             //如果不一样
                    typeList.add(currentType);      //把这个不一样的加进链表
                    type = currentType;             //把指针换成现在类型
                }
            }
        }

        //计算Type的数量
        int numOfType = 0;
        for (String s : typeList) { numOfType++; }
        System.out.println("numOfType = " + numOfType);

        //生成返回结果，链表的链表
        List<List<Goods>> returnList = new ArrayList<>();

        int index = 0;
        //对类型进行循环
        for (String type : typeList) {
            //生成对应类型的链表
            List<Goods> goodsTypeList = new ArrayList<>();
            //对商品链表进行循环
            for (Goods goods : goodsList) {
                boolean isAdd = false;
                if (goods.getType().equals(type)){  //如果类型合适
                    goodsTypeList.add(goods);       //添加到商品类型链表
//                    goodsList.remove(goods);      //删除该节点，但加了会报错
                }else {     //到这里，类型不合适
                        //把链表加到 index位置上
                    if(!isAdd){
                        returnList.add(index,goodsTypeList);
                        isAdd = true;
                    }
                }
            }
            index++;
        }       //结束分类

        int i = 0;
        for (List<Goods> goodsList1 : returnList) {
            jsonObject.put(String.valueOf(i),goodsList1.toString());
            i++;
        }



        String leftMenu = left_menu(typeList);
        String rightMenu = right_menu(returnList);
        System.out.print(leftMenu);System.out.println(",");
        System.out.println(rightMenu);
        return leftMenu+","+rightMenu;
    }


    public Map<String,Object> getGoodsInfoMapType() throws JSONException {

        JSONObject jsonObject = new JSONObject();

        //商品列表，需要处理的信息
        List<Goods> goodsList = goodsDao.selectAllGoods();

        //类型链表，分类返回
        List<String> typeList = new ArrayList<>();

        //获取类型List
        {
            //获取第一个商品的类型
            String type = goodsList.get(0).getType();
            typeList.add(type);        //把第一个类型放入类型链表

            for (Goods goods : goodsList) {
                String currentType = goods.getType();
                //看看和上一个是不是一样的
                if (type.equals(currentType)){      //如果一样
                    continue;                   //什么也不做
                }else {                             //如果不一样
                    typeList.add(currentType);      //把这个不一样的加进链表
                    type = currentType;             //把指针换成现在类型
                }
            }
        }

        //计算Type的数量
        int numOfType = 0;
        for (String s : typeList) { numOfType++; }
        System.out.println("numOfType = " + numOfType);

        //生成返回结果，链表的链表
        List<List<Goods>> returnList = new ArrayList<>();

        int index = 0;
        //对类型进行循环
        for (String type : typeList) {
            //生成对应类型的链表
            List<Goods> goodsTypeList = new ArrayList<>();
            //对商品链表进行循环
            boolean isAdd = false;
            for (Goods goods : goodsList) {
                if (goods.getType().equals(type)){  //如果类型合适
                    goodsTypeList.add(goods);       //添加到商品类型链表
//                    goodsList.remove(goods);      //删除该节点，但加了会报错
                }else {     //到这里，类型不合适
                    //把链表加到 index位置上
                    if(!isAdd){
                        returnList.add(index,goodsTypeList);
                        isAdd = true;
                    }
                }
            }
            index++;
        }       //结束分类

        int numOfList = 0;
        for (List<Goods> goodsList1 : returnList) {
            jsonObject.put(String.valueOf(numOfList),goodsList1.toString());
            numOfList++;
        }
        System.out.println("numOfList = " + numOfList);
        for (List<Goods> goods : returnList) {
            int thisListLength = 0;
            for (Goods good : goods) {
                thisListLength++;
            }
            System.out.println("thisListLength = " + thisListLength);
        }

        String leftMenu = left_menu(typeList);
        String rightMenu = right_menu(returnList);
        System.out.print(leftMenu);System.out.println(",");
        System.out.println(rightMenu);

        //返回Map
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("left_menu",leftMenu);
        returnMap.put("right_menu",rightMenu);

        return returnMap;
    }




    String left_menu(List<String> myList) {
        String left = "[";
        String right = "]";
        String body = new String("");

        int sum = 0;
        for (String s : myList) {
            sum++;
        }

        for (String s : myList) {
            sum--;
            //定义内容
            String l = "{\"txt\":\"";   String r = "\"}";
            //拼接内容
            String info = l + s + r;
            //看情况加  ,
            if (sum != 0) {
                info += ",";
            }
            //放入body
            body += info;
        }
        return left + body + right;
    }

    String right_menu(List<List<Goods>> returnList) {
        String left = "[";       String right = "]";
        String body = new String("");

        // right_menu:[   {-----},{-----},{-----},{-----}   ]

        int numOfElement = 0;
        for (List<Goods> goods : returnList) { numOfElement++; }
        for (List<Goods> goodsList : returnList) {
            body += alertStr(goodsList);
            numOfElement--;
            if(numOfElement!=0){ body+=","; }       //看情况补   ,
        }

        return left + body + right;
    }

    String alertStr(List<Goods> goodsList){
        String left = "{\"menu\":["; String right = "]}";
        String body = new String("");
        int sum = 0;
        for (Goods goods : goodsList) { sum++; }
        for (Goods goods : goodsList) {
            body += goods.getAppletViewInfo();       //拼接中间部分内容
            sum--;
            if(sum!=0) { body+=","; }       //看情况补 ,
        }
        return left+body+right;
    }


    //  查看自己的下单记录
    public List<BuyRecord> getMyHistoryRecord(){
        return null;
    }

    //

}
