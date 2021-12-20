package com.example.freshsystem.domain;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-01 23:44
 */



//前端传输过来的链表单元
public class ShoppingListUnit {

    //商品id
    String goodsId;
    //数量
    int amount;

    //商品名       其实这个真的用不到
    //最主要是上面两个字段
    String goodsName;

    public ShoppingListUnit() {
    }

    @Override
    public String toString() {
        return "ShoppingListUnit{" +
                "goodsId='" + goodsId + '\'' +
                ", amount=" + amount +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }

    public ShoppingListUnit(String goodsId, int amount, String goodsName) {
        this.goodsId = goodsId;
        this.amount = amount;
        this.goodsName = goodsName;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
