package com.example.freshsystem.dao;

import com.example.freshsystem.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ᛟ
 * @date 2021/5/31 - 11:29
 */

@Component
@Repository
@Mapper
//商品表
public interface GoodsDao {

    //0.搜索所有商品
    @Select("SELECT `goodsid`,`type`,`brand`,`goodsname`,`price`,`img`,`netwt`,`quantity`,`origin`" +
            "FROM `freshsystem`.`freshgoods`" + " ORDER BY `type`;")
    List<Goods> selectAllGoods();//前端传值到后台获取相应的产品类型

    //1.根据商品名精确搜索
    Goods selectByName(String name);

    //2.根据商品名模糊搜索
    List<Goods> selectLikeName(String name);

    //3.根据编号精确搜索
    @Select("SELECT`goodsid`,`type`,`brand`,`goodsname`,`price`,`img`,`netwt`,`quantity`,`origin`" +
            "FROM `freshsystem`.`freshgoods`" +
            "WHERE `goodsid` = #{id};")
    Goods selectByGoodsId(String id);

    //4.根据编号模糊搜索
    Goods selectLikeGoodsId(String id);

    //5.根据类别搜索
    @Select("select * from freshsystem where goodstype = #{goodstype}")
    List<Goods> selectGoodsByType(String type);

    //6.根据品牌搜索
    @Select("select * from freshsystem where goodstype = #{goodstype}")
    List<Goods> selectGoodsByBrand(String brand);

    //7.根据产地搜索
    @Select("select * from freshsystem where goodstype = #{goodstype}")
    List<Goods> selectGoodsByOrigin(String origin);


    // 8.添加商品 类别 品牌 名称 编号 净含量 产地 图片url 数量 售价
    boolean addGoods(Goods goods);
    // 9.删除商品 编号
    int deleteGoods(String id);
    // 10.更新库存量
    @Update("UPDATE `freshsystem`.`freshgoods`" +
            "SET `quantity` = #{quantity}" +
            " WHERE `goodsid` = #{goodsId};")
    int updateGoods(Goods goods);

}
