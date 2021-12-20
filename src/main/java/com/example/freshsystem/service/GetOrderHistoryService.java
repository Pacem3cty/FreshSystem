package com.example.freshsystem.service;

import com.example.freshsystem.dao.BuyRecordDao;
import com.example.freshsystem.domain.BuyRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-12 23:27
 */

@Service
public class GetOrderHistoryService {

    @Autowired
    BuyRecordDao buyRecordDao;

    //获取到绑定手机号的订单
    public String getMyOrderHistory(String phone){
        System.out.println("进入到service当中执行getMyOrderHistory");
        System.out.println("phone = " + phone);

        //获取到订单链表
        List<BuyRecord> orderList = buyRecordDao.seletctRecordByPhoneNum(phone);

        System.out.println("orderList = " + orderList);

        //如果orderList长度为0.返回空字符串
        if(orderList.size()==0) return "";

        //定义copyList，得到查重后的list
        List<BuyRecord> copyList = new ArrayList();
        //得到每个订单的商品数量
        List<Integer> currentOrderAmountList = new ArrayList<>();

        //对copyList进行赋值

        //定义头指针，指向第0个元素
        String iPtr = orderList.get(0).getOrderId();
        //把第0个元素放入copyList
        copyList.add(orderList.get(0));
        //定义当前Order的数量，因为从index = 1开始遍历
        Integer currentOrderAmount = 1;

        //从1开始遍历
        for (int i = 1; i < orderList.size(); i++) {
            //如果和头指针的orderId不同
            if (!orderList.get(i).getOrderId().equals(iPtr)) {//和指针不同 或者到了链表最后一个元素
                iPtr = orderList.get(i).getOrderId();                   //指针指向当前元素
                copyList.add(orderList.get(i));                         //当前这个放入 copy 链表
                currentOrderAmountList.add(currentOrderAmount);         //把当前数量加进去
                currentOrderAmount = 1;                                 //计数器归1
            }
            else if( i==orderList.size()-1 ){                           //到了最后一个元素
                currentOrderAmount++;                                   //计数器+1
                currentOrderAmountList.add(currentOrderAmount);         //添加到数组
            }
            else {                                                      //和指针相同
                currentOrderAmount++;                                   //给 int + 1
                //相同就不管了
            }
        }

        System.out.println("currentOrderAmountList = " + currentOrderAmountList);

        // currentOrderAmountList 初始完成 int类型的数量List
        // copyList               初始化 copyList 完成
        int index = 0;      String data = new String("");           data+="[";
        int diJiCiXunHuan = 0;
        //对int链表进行循环
        for (Integer integer : currentOrderAmountList) {
            diJiCiXunHuan++;
            String dataUnit = new String("{");   String end = "]}";
            //获取共同数据
            String commonInfoJSON_type = orderList.get(index).getCommonInfoJSON_Type();
            dataUnit += commonInfoJSON_type;
            //获取元素数据      从 index 开始  到  index + num - 1
            int indexCopy = index;
            for(int i = index ; i < integer + indexCopy ; i++){
                System.out.println("index = " + index);
                //添加不同元素的数据
                dataUnit += orderList.get(index).getDifferentInfoJSON_Type();
                //根据情况补  ,
                if(i!=(indexCopy+integer)-1){
                    dataUnit += ",";      //给Shopping List加，
                }
                index++;
            }
            System.out.println("出循环");
            dataUnit+=end;
            data += dataUnit;
            if(diJiCiXunHuan!=currentOrderAmountList.size()){
                data += ",";                                    //给dataUnit 加 ，
            }
        }

        data+="]";

        System.out.println(data);
        System.out.println("data in service = " + data);

        return data;
    }

}
