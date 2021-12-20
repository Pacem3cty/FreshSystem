package com.example.freshsystem.domain;

import org.mockito.internal.matchers.Any;

import java.util.List;
/**
 * @author ᛟ
 * @date 2021/5/31 - 0:51
 */
public class OrderEntity {
    private List<ShoppingListUnit> shoppingListUnits;
    private String personPhone;
    private String consignNum;
    private String consignAddress;

    public OrderEntity(){

    }

    public List<ShoppingListUnit> getShoppingListUnits() {
        return shoppingListUnits;
    }

    public void setShoppingListUnits(List<ShoppingListUnit> shoppingListUnits) {
        this.shoppingListUnits = shoppingListUnits;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
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
}
