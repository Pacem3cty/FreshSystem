package com.example.freshsystem.service;

import com.example.freshsystem.FreshSystemApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-08 22:33
 */

@ComponentScan("com.example.freshsystem")
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FreshSystemApplication.class)
@WebAppConfiguration
class AppletViewSupplyServiceTest {

    @Autowired
    AppletViewSupplyService appletViewSupplyService;

    @Test
    void getGoodsInfo() throws JSONException {
        appletViewSupplyService.getGoodsInfo();
    }

    @Test
    void printInfo() throws JSONException {
        System.out.println(appletViewSupplyService.getGoodsInfoMapType());
    }
}