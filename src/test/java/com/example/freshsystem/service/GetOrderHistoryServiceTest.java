package com.example.freshsystem.service;

import com.example.freshsystem.FreshSystemApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.example.freshsystem.service.GetOrderHistoryService;

import static org.junit.jupiter.api.Assertions.*;



@ComponentScan("com.example.freshsystem")
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FreshSystemApplication.class)
@WebAppConfiguration
class GetOrderHistoryServiceTest {

    @Autowired
    GetOrderHistoryService getOrderHistoryService;

    @Test
    void getMyOrderHistory() {
        getOrderHistoryService.getMyOrderHistory("13924680329");
    }
}