package com.example.freshsystem.service;

import com.example.freshsystem.FreshSystemApplication;
import com.example.freshsystem.domain.ShoppingListUnit;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-08 16:20
 */

@ComponentScan("com.example.freshsystem")
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FreshSystemApplication.class)
@WebAppConfiguration
class CustomerOrderServiceTest {

    @Autowired
    CustomerOrderService customerOrderService;

    @Test
    void placeAnOrder() {

        //获取到测试数据
        String phoneNum1 = "13556203730";
        String phoneNum2 = "13556203730";
        String address = "榕5-535";
        List<ShoppingListUnit> shoppingList = new ArrayList<ShoppingListUnit>();
        ShoppingListUnit shoppingListUnit01 = new ShoppingListUnit("10000536890",3,"name 01 test");
        ShoppingListUnit shoppingListUnit02 = new ShoppingListUnit("10000589360",3,"name 02 test");
        ShoppingListUnit shoppingListUnit03 = new ShoppingListUnit("10000774888",3,"name 03 test");
        shoppingList.add(shoppingListUnit01);shoppingList.add(shoppingListUnit02);shoppingList.add(shoppingListUnit03);

        //测试下单

        customerOrderService.printAutoWireSuccess();

        boolean isSuccess = customerOrderService.placeAnOrder(shoppingList, phoneNum1, phoneNum2, address);
        System.out.println("place order is success? -> " + isSuccess);
    }

    @Test
    void cancelAnOrder(){
        customerOrderService.cancelAnOrder("13556203730210608214720013");
    }
}