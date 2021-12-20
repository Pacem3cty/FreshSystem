package com.example.freshsystem.domain;

import java.math.BigDecimal;

/**
 * @author ᛟ
 * @date 2021/5/31 - 0:51
 */
public class Goods {

    String goodsId;// 商品id
    String type;  //类型
    String brand; //品牌
    String goodsName;//商品名称
    BigDecimal price;//价格
    String img; //图片
    String netwt; //净含量
    int quantity; //数量
    String origin;  //产地

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNetwt() {
        return netwt;
    }

    public void setNetwt(String netwt) {
        this.netwt = netwt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Goods() { }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + goodsId +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + goodsName + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", netwt='" + netwt + '\'' +
                ", quantity=" + quantity +
                ", origin='" + origin + '\'' +
                '}';
    }

    public Goods(String goodsId, String type, String brand, String goodsName, BigDecimal price, String img, String netwt, int quantity, String origin) {
        this.goodsId = goodsId;
        this.type = type;
        this.brand = brand;
        this.goodsName = goodsName;
        this.price = price;
        this.img = img;
        this.netwt = netwt;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getAppletViewInfo(){
        return "{" +
                "\"id\":\"" + goodsId + "\"" +
                ", \"type\":\"" + type + '\"' +
                ", \"brand\":\"" + brand + '\"' +
                ", \"name\":\"" + goodsName + '\"' +
                ", \"price\":\"" + price + "\""+
                ", \"img\":\"" + img + '\"' +
                ", \"netwt\":\"" + netwt + '\"' +
                ", \"quantity\":\"" + quantity + "\""+
                ", \"origin\":\"" + origin + '\"' +
                "}";
    }

}

