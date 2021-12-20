package com.example.freshsystem.dao;

import com.example.freshsystem.domain.BuyRecord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-02 13:20
 */

@Repository
@Mapper
@Component
public interface BuyRecordDao {
    //添加记录
    @Insert("INSERT INTO `freshsystem`.`buyrecord`(`personphone`,`time`,`orderid`,`orderprice`," + "`isreturn`,`consignnum`,`consignaddress`,`deliverymanid`," + "`goodsid`,`goodsname`,`type`,`amount`,`goodsallprice`)" +
            "VALUES (#{personPhone},#{time},#{orderId},#{orderPrice},0,#{consignNum},#{consignAddress},#{deliverymanId},#{goodsId},#{goodsName},#{type},#{amount},#{goodsAllPrice});")
    boolean addOneRecord(BuyRecord buyRecord);
    //删除记录 根据单号
    @Delete("delete from buyrecord where orderId = #{orderId}")
    boolean deleteRecordByOrderId(String orderId);
    //删除记录 根据电话号码
    @Delete("")
    boolean deleteRecordByPhoneNum(String phoneNum);

    //选择记录
    // 1、根据单号
    @Select("SELECT`personphone`,`time`,`orderid`,`orderprice`,`isreturn`,`consignnum`,`consignaddress`,`deliverymanid`,`goodsid`,`goodsname`,`type`,`amount`,`goodsallprice`" +
            "FROM `freshsystem`.`buyrecord`" +
            "WHERE `orderid` = #{orderId};")
    List<BuyRecord> seletctRecordByOrderId(String orderId);
    // 2、根据绑定的手机号
    @Select("SELECT * FROM `buyrecord` WHERE `personphone` = #{phoneNum} ORDER BY `orderid` DESC;")
    List<BuyRecord> seletctRecordByPhoneNum(String phoneNum);
    // 3.根据商品编号
    @Select("")
    List<BuyRecord> seletctRecordByGoodsId(String goodsId);
    // 4、根据商品名称（精确）
    @Select("")
    List<BuyRecord> seletctRecordByGoodsName(String goodsName);
    // 4、根据商品名称（模糊）
    @Select("")
    List<BuyRecord> seletctRecordLikeGoodsName(String goodsName);
    // 5、根据商品种类
    @Select("")
    List<BuyRecord> seletctRecordByGoodsType(String goodsType);
    // 6、根据配送员
    @Select("")
    List<BuyRecord> seletctRecordByDeliverMan(String deliverManId);

    // 根据订单号退单，把对应的订单号当中 isReturn 改成 1
    @Update("UPDATE `freshsystem`.`buyrecord` SET `isreturn` = 1 WHERE `orderid` = #{orderId};")
    int returnOrder(String orderId);

    //=========================================================================================================================
    //=========================================================================================================================
    //=========================================================================================================================
    //=========================================================================================================================
    //=======================                                                        ==========================================
    //=======================           要添加DAO在下面加，上面的是固定的，尽量不要加        ==========================================
    //=======================                                                        ==========================================
    //=========================================================================================================================
    //=========================================================================================================================
    //=========================================================================================================================
    //=========================================================================================================================

}
