package com.example.freshsystem.service;

import com.example.freshsystem.dao.BuyRecordDao;
import com.example.freshsystem.dao.GoodsDao;
import com.example.freshsystem.dao.OrderDao;
import com.example.freshsystem.dao.StaffDao;
import com.example.freshsystem.domain.*;
import com.example.freshsystem.tools.CreateOrderSerialTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-02 13:19
 */

//为顾客订单提供服务
@Service
public class CustomerOrderService {

    @Autowired
    GoodsDao goodsDao;
    @Autowired
    BuyRecordDao buyRecordDao;
    @Autowired
    StaffDao staffDao;
    @Autowired
    OrderDao orderDao;

    public void printAutoWireSuccess(){
        System.out.println("auto wire success");
    }

    //        下单           订单             用户名             收货号码             收货地址
    @Transactional
    public boolean  placeAnOrder(List<ShoppingListUnit> shoppingListUnits,
                          String personPhone, String consignNum, String consignAddress){

        //返回状态
        boolean returnStatus = false;
        //购买记录链表
        List<BuyRecord> buyRecordList = new ArrayList<>();

        try{
            // 生成时间
            String time = CreateOrderSerialTool.getTime();
            // 生成订单号
            String orderId = personPhone+time;

            //找一个倒霉蛋充当配送员
            List<Staff> deliverManList = staffDao.selectAllDeliverMan();            //获取所有配送员
            int numOfDeliverMan = 0;
            for (Staff staff : deliverManList) { numOfDeliverMan ++; }               //算出有几个配送员  假如是5个
            int index = CreateOrderSerialTool.getMillisecondNum()%numOfDeliverMan;  //得到 0 1 2 3 4 的任意一个结果
            Staff daomeidan = deliverManList.get(index);                            //得到那个倒霉蛋
            String deliverymanId = daomeidan.getStaffId();
            System.out.println("deliverymanId = " + deliverymanId);

            //定义总金额
            BigDecimal sumMoneyBigDecimal = new BigDecimal(0);
            //对订单进行遍历
            for (ShoppingListUnit unit : shoppingListUnits) {
                System.out.println("unit.getGoodsId() = " + unit.getGoodsId());
                //获取到list当中的商品id
                String goodsId = unit.getGoodsId();
                //获取到商品表中的商品
                Goods goods = goodsDao.selectByGoodsId(goodsId);
//                System.err.println("=====================================");
                System.out.println(goods);
                //进行删减数量操作     获取原来的  减去 要删去的数量
//                System.err.println("goods.getQuantity() = " + goods.getQuantity());
//                System.err.println("unit.getAmount() = " + unit.getAmount());
                int restNum = goods.getQuantity()-unit.getAmount();     //计算余量
                System.out.println("restNum = " + restNum);

                if (restNum<0){                //处理异常情况
                    System.err.println("商品 "+goods.getGoodsId()+" 余量不够");
                    //手动事务回滚，不抛出异常
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
                goods.setQuantity(restNum);
                //放回数据库当中，更新库存量
                goodsDao.updateGoods(goods);


                //定义BigDecimal类型的数量
                BigDecimal thisAmount = new BigDecimal(unit.getAmount());
                //定义BigDecimal类型的价格
                BigDecimal thisPrice = new BigDecimal(String.valueOf(goods.getPrice()));
                //这个商品总价，用BigDecimal进行运算得出，得到该条商品的总价
                BigDecimal thisGoodsAllPriceBigDecimal = new BigDecimal(String.valueOf(thisAmount.multiply(thisPrice)));
//                System.err.println("thisGoodsAllPriceBigDecimal = " + thisGoodsAllPriceBigDecimal);

                //计算总金额
                sumMoneyBigDecimal = sumMoneyBigDecimal.add(thisGoodsAllPriceBigDecimal);//对总价添加该商品价格
                System.out.println("sumMoneyBigDecimal = " + sumMoneyBigDecimal);
                //System.err.println(personPhone);
                //生成购买记录<容易出错>
                BuyRecord buyRecord = new BuyRecord(personPhone,time,orderId,thisGoodsAllPriceBigDecimal,0,consignNum,consignAddress,deliverymanId,
                        goods.getGoodsId(),goods.getGoodsName(),goods.getType(), unit.getAmount(), thisGoodsAllPriceBigDecimal);
                //生成购买记录链表
                System.out.println("buyRecord = " + buyRecord);
                buyRecordList.add(buyRecord);
                System.out.println(buyRecord);

            }

            //算出总价了
//            System.err.println("该笔订单总价 sumMoney = " + sumMoneyBigDecimal);
            //对购买记录链表进行循环
            for (BuyRecord buyRecord : buyRecordList) {
                buyRecord.setOrderPrice(sumMoneyBigDecimal);      //商品总价标一标
                buyRecordDao.addOneRecord(buyRecord);   //往数据库添加一条购买记录
            }

            //在数据库生成订单记录
            BigDecimal orderPrice = sumMoneyBigDecimal;
            Order order = new Order(orderId,orderPrice,consignNum,consignAddress,deliverymanId,0);
            orderDao.addOrder(order);

            returnStatus = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return returnStatus;
        }
    }       //下单完成

    //取消订单
    public boolean cancelAnOrder(String orderId){
        System.out.println("执行取消订单方法 单号为 "+orderId);
        boolean returnStatus = false;
        try{
//            orderDao.cancelOrder(orderId);
            //获取到订单记录，退单选项改1
            buyRecordDao.returnOrder(orderId);
            //获取到下单记录
            List<BuyRecord> buyRecordList = buyRecordDao.seletctRecordByOrderId(orderId);
            //进行遍历
            for (BuyRecord buyRecord : buyRecordList) {
                //获取到该条记录的商品id
                String goodsId = buyRecord.getGoodsId();
                //通过商品id获取到对应的商品
                Goods goods = goodsDao.selectByGoodsId(goodsId);
                //获取到下单前的数量  ->  现有数量 + 购买记录的数量
                int quantity = goods.getQuantity() + buyRecord.getAmount();
                //给商品设置回去
                goods.setQuantity(quantity);
                //更新数据库
                goodsDao.updateGoods(goods);
                System.out.println("成功执行取消订单方法");
            }


            returnStatus = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            return returnStatus;
        }
    }//取消订单完成

    //删除订单
    public boolean deleteAnOrder(String orderId){
        System.out.println("执行删除订单方法 单号为"+orderId);
        boolean returnStatus = false;
        try{
            orderDao.deleteOrder(orderId);
            //获取到订单记录，退单选项改1
            buyRecordDao.deleteRecordByOrderId(orderId);
            System.out.println("成功执行删除订单方法");
            returnStatus = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            return returnStatus;
        }
    }//删除订单完成
}
