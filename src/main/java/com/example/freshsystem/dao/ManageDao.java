package com.example.freshsystem.dao;

import com.example.freshsystem.domain.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
/**
 * @author zhuizhuaaa
 * @date 2021/6/4 - 14:10
 */
@Repository
@Mapper
public interface ManageDao {
    //查各分类商品
    @Select("select * from freshgoods")
    List<Goods> selectAll();
    @Select("select * from freshgoods where goodstype = '时令水果'")
    List<Goods> selectFruits();
    @Select("select * from freshgoods where goodstype = #{速冻食品}")
    List<Goods> selectFrozenFoods();
    @Select("select * from freshgoods where goodstype = #{食用酒品}")
    List<Goods> selectEdibleWine();
    @Select("select * from freshgoods where goodstype = #{进口零食}")
    List<Goods> selectImportedSnacks();
    @Select("select * from freshgoods where goodstype = #{休闲零食}")
    List<Goods> selectCasualSnacks();
    @Select("select * from freshgoods where goodstype = #{方便面}")
    List<Goods> selectInstantNoodles();
    @Select("select * from freshgoods where goodstype = #{速溶冲调}")
    List<Goods> selectInstantPreparation();
    @Select("select * from freshgoods where goodstype = #{生鲜牛奶}")
    List<Goods> selectRawMilk();
    @Select("select * from freshgoods where goodstype = #{水饮名茶}")
    List<Goods> selectWaterTea();
    @Select("select * from freshgoods where goodstype = #{粮油调味}")
    List<Goods> selectGrainSeasoning();
    @Select("select * from freshgoods where goodstype = #{海鲜水产}")
    List<Goods> selectSeafood();
    @Select("select * from freshgoods where goodstype = #{农家鸡蛋}")
    List<Goods> selectFarmEggs();
    @Select("select * from freshgoods where goodstype = #{精选肉类}")
    List<Goods> selectMeat();
    @Select("select * from freshgoods where goodstype = #{新鲜蔬菜}")
    List<Goods> selectFreshVegetables();
    @Select("select * from freshgoods where goodstype = #{进口水果}")
    List<Goods> selectImportedFruit();
    //增加商品数据
    @Insert("insert into freshgoods(goodsid,type,brand,goodsname,price,img,netwt,quantity,origin)"+" values(#{goodsId},#{type},#{brand},#{goodsName},#{price},#{img},#{netwt},#{quantity},#{origin})")
    public void insertGoodsImformations(Goods goods);

    @Update("UPDATE freshgoods SET type= #{type}, brand= #{brand},goodsname = #{goodsName}, price= #{price}, img= #{img}, netwt= #{netwt},quantity = #{quantity},origin = #{origin}WHERE goodsid = #{goodsId}")
    int updateGoods(Goods goods);

    @Delete("delete from freshgoods where goodsid = #{goodsId} ")
    int deleteGoods(String goodsId);



}
