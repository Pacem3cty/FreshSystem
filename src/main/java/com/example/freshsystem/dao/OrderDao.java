package com.example.freshsystem.dao;

import com.example.freshsystem.domain.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-01 22:35
 */

@Repository
@Mapper
//订单表
public interface OrderDao {
    // 创建订单
    @Insert("insert into goodsorder(orderId,orderPrice,consignNum,consignAddress,deliverymanId,isReturn)"+"values(#{orderId},#{orderPrice},#{consignNum},#{consignAddress},#{deliverymanId},#{isReturn})")
    boolean addOrder(Order order);

    // 修改订单
    @Update("update goodsorder set orderId = #{orderId},orderPrice = #{orderPrice},consignNum = #{consignNum},consignAddress = #{consignAddress},deliverymanId = #{deliverymanId},isReturn = #{isReturn} where orderId = #{orderId}")
    boolean updateOrder(Order order);

    //查询所有订单
    @Select("select * from goodsorder")
    List<Order> selectAllOrder();

    // 查询订单 精确

    List<Order> selectOrderByOrderId(String OrderId);

    // 查询订单 模糊

    List<Order> selectOrderLikeOrderId(String OrderId);

    // 删除订单
    @Delete("delete from goodsorder where orderId = #{orderId}")
    boolean deleteOrder(String orderId);

    //取消订单
    @Update("update goodsorder set isReturn = 1 where orderId = #{orderId}")
    boolean cancelOrder(String orderId);

    // 根据用户绑定手机号 选择订单  sql语句：
// select ....   where personPhone = phone
// 这样就可以直接获取到绑定号码的全部订单
    @Select("SELECT * FROM `buyrecord` WHERE `personphone` = #{phone} ORDER BY `orderid`;")
    List<Order> selectOrderByPersonPhone(String phone);
}