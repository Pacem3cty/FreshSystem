package com.example.freshsystem.domain;

import java.math.BigDecimal;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-01 23:03
 */
public class Order {
    String orderId;         //单号
//    String consignname;    //
    BigDecimal orderPrice;      //该订单价格
    String consignNum;      //收货号码
    String consignAddress;  //收货地址
    String deliverymanId;   //配送员id
    int isReturn;           //是否被退单




    public Order() {
    }

    public Order(String orderId,BigDecimal orderPrice, String consignNum, String consignAddress, String deliverymanId, int isReturn) {
//        this.consignname = consignname;
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.consignNum = consignNum;
        this.consignAddress = consignAddress;
        this.deliverymanId = deliverymanId;
        this.isReturn = isReturn;
    }

//    public String getConsignname() {
//        return consignname;
//    }
//
//    public void setConsignname(String consignname) {
//        this.consignname = consignname;
//    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getConsignNum() {
        return consignNum;
    }

    public void setConsignNum(String consignNum) {
        this.consignNum = consignNum;
    }

    public String getConsignAddress() {
        return consignAddress;
    }

    public void setConsignAddress(String consignAddress) {
        this.consignAddress = consignAddress;
    }

    public String getDeliverymanId() {
        return deliverymanId;
    }

    public void setDeliverymanId(String deliverymanId) {
        this.deliverymanId = deliverymanId;
    }

    public int getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(int isReturn) {
        this.isReturn = isReturn;
    }
}
