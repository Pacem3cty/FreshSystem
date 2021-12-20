package com.example.freshsystem.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-02 11:18
 */
public class BuyRecord {

    String personPhone;         // 绑定号
    String time;                // 时间
    String orderId;             // 单号
    BigDecimal orderPrice;          // 单价
    int isReturn;               // 是否退单
    String consignNum;          // 收货号
    String consignAddress;      // 收货地址
    String deliverymanId;       //  配送员

    String goodsId;         // 商品ID
    String goodsName;       // 名称
    String type;            // 种类
    int amount;             // 数量
    BigDecimal goodsAllPrice;   // 该商品在本记录内的总价格

    public BuyRecord(String personPhone, String time, String orderId, BigDecimal orderPrice, int isReturn, String consignNum, String consignAddress, String deliverymanId, String goodsId, String goodsName, String type, int amount, BigDecimal goodsAllPrice) {
        this.personPhone = personPhone;
        this.time = time;
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.isReturn = isReturn;
        this.consignNum = consignNum;
        this.consignAddress = consignAddress;
        this.deliverymanId = deliverymanId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.type = type;
        this.amount = amount;
        this.goodsAllPrice = goodsAllPrice;
    }

    @Override
    public String toString() {
        return "BuyRecord{" +
                "personPhone='" + personPhone + '\'' +
                ", time='" + time + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderPrice=" + orderPrice +
                ", isReturn=" + isReturn +
                ", consignNum='" + consignNum + '\'' +
                ", consignAddress='" + consignAddress + '\'' +
                ", deliverymanId='" + deliverymanId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", goodsAllPrice=" + goodsAllPrice +
                '}';
    }

    public String getCommonInfoJSON_Type(){
        //给一个订单，把共有信息转字符串
        return
                "\"orderId\":\"" + orderId + "\"" +
                        ", \"time\":\"" + transTimeMode(time) + "\"" +
                        ", \"orderPrice\":\"" + orderPrice + "\"" +
                        ", \"consignNum\":\"" + consignNum + "\"" +
                        ", \"consignAddress\":\"" + consignAddress + "\"" +
                        ", \"deliverymanId\":\"" + deliverymanId + "\"" +
                        ", \"isReturn\":\"" + isReturn + "\""       +","
                        + "\"list\":["
                ;
    }

    public String getDifferentInfoJSON_Type(){
        return "{" +
                " \"goodsId\":\"" + goodsId + "\"" +
                ", \"goodsName\":\"" + goodsName + "\"" +
                ", \"amount\":\"" + amount + "\"" +
                ", \"goodsAllPrice\":\"" + goodsAllPrice + "\"" +
                '}';
    }

    public String transTimeMode(String parmTime){

        BigInteger time = new BigInteger(parmTime);

        BigInteger year = time.divide(new BigInteger("10000000000000"));
//        System.out.println("year = " + year);
        //获取月份Long
        BigInteger monthLong = time.subtract(year.multiply(new BigInteger("10000000000000")));
//        System.out.println("monthLong = " + monthLong);
        //获取月份
        BigInteger month = monthLong.divide(new BigInteger("100000000000"));
//        System.out.println("month = " + month);

        //获取日Long
        BigInteger dayLong = monthLong.subtract(month.multiply(new BigInteger("100000000000")));
//        System.out.println("dayLong = " + dayLong);
        //获取日
        BigInteger day = dayLong.divide(new BigInteger("1000000000"));
//        System.out.println("day = " + day);
        //获取时Long
        BigInteger hourLong = dayLong.subtract(day.multiply(new BigInteger("1000000000")));
//        System.out.println("hourLong = " + hourLong);
        //获取时
        BigInteger hour = hourLong.divide(new BigInteger("10000000"));
//        System.out.println("hour = " + hour);
//        System.out.println();

        //获取分Long       //减去头两个
        BigInteger minLong = hourLong.subtract(hour.multiply(new BigInteger("10000000")));
//        System.out.println("minLong = " + minLong);
        //获取分
        BigInteger min = minLong.divide(new BigInteger("100000"));
        String min2l = String.format("%2d", min).replace(" ", "0");
//        System.out.println("min = " + min);
        //获取秒
        BigInteger secondLong = minLong.subtract(min.multiply(new BigInteger("100000")));
//        System.out.println("secondLong = " + secondLong);
        BigInteger second = secondLong.divide(new BigInteger("1000"));
        String second2l = String.format("%2d", second).replace(" ", "0");
//        System.out.println("second = " + second);

        String returnTime = "20"+year+"-"+month+"-"+day+" "+hour+":"+min2l+":"+second2l;
        System.out.println("returnTime = " + returnTime);
        return returnTime;

    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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

    public int getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(int isReturn) {
        this.isReturn = isReturn;
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getGoodsAllPrice() {
        return goodsAllPrice;
    }

    public void setGoodsAllPrice(BigDecimal goodsAllPrice) {
        this.goodsAllPrice = goodsAllPrice;
    }
}
