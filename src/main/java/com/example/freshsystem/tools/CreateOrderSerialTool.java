package com.example.freshsystem.tools;

import java.math.BigInteger;
import java.util.Calendar;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-06-01 17:23
 */
public class CreateOrderSerialTool {

    public static int getMillisecondNum(){
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int millisecondNum = c.get(Calendar.MILLISECOND);
        return millisecondNum;
    }

    public static String getTime(){

        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        System.out.println("c.toString() = " + c.toString());

        int yearNum = c.get(Calendar.YEAR) - 2000;
        String year = String.format("%2d", yearNum).replace(" ", "0");
//        System.out.println("year = " + year);

        int monthNum = c.get(Calendar.MONTH) + 1;
        String month = String.format("%2d", monthNum).replace(" ", "0");
//        System.out.println("month = " + month);

        int dateNum = c.get(Calendar.DATE);
        String date = String.format("%2d", dateNum).replace(" ", "0");
//        System.out.println("date = " + date);

        int hourNum = c.get(Calendar.HOUR_OF_DAY);
        String hour = String.format("%2d", hourNum).replace(" ", "0");
//        System.out.println("hour = " + hour);

        int minuteNum = c.get(Calendar.MINUTE);
        String minute = String.format("%2d", minuteNum).replace(" ", "0");
//        System.out.println("minute = " + minute);

        int secondNum = c.get(Calendar.SECOND);
        String second = String.format("%2d", secondNum).replace(" ", "0");
//        System.out.println("second = " + second);

        int millisecondNum = c.get(Calendar.MILLISECOND);
        String millisecond = String.format("%3d", millisecondNum).replace(" ", "0");
//        System.out.println("millisecond = " + millisecond);

        String time = year+month+date+hour+minute+second+millisecond;
        return time;
    }

    public static String transTimeMode(String parmTime){
//        String parmTime = "210308123426201";
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
//        System.out.println("min = " + min);
        //获取秒
        BigInteger secondLong = minLong.subtract(min.multiply(new BigInteger("100000")));
//        System.out.println("secondLong = " + secondLong);
        BigInteger second = secondLong.divide(new BigInteger("1000"));
//        System.out.println("second = " + second);

        String returnTime = "20"+year+" "+month+"-"+day+" "+hour+":"+min+" "+second+"'";
        System.out.println("returnTime = " + returnTime);
        return returnTime;
    }

//    public static String createDataSerial(String phoneNum){
//
//        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
//
//        int yearNum = c.get(Calendar.YEAR) - 2000;
//        String year = String.format("%2d", yearNum).replace(" ", "0");
//        System.out.println("year = " + year);
//
//        int monthNum = c.get(Calendar.MONTH) + 1;
//        String month = String.format("%2d", monthNum).replace(" ", "0");
//        System.out.println("month = " + month);
//
//        int dateNum = c.get(Calendar.DATE);
//        String date = String.format("%2d", dateNum).replace(" ", "0");
//        System.out.println("date = " + date);
//
//        int hourNum = c.get(Calendar.HOUR_OF_DAY);
//        String hour = String.format("%2d", hourNum).replace(" ", "0");
//        System.out.println("hour = " + hour);
//
//        int minuteNum = c.get(Calendar.MINUTE);
//        String minute = String.format("%2d", minuteNum).replace(" ", "0");
//        System.out.println("minute = " + minute);
//
//        int secondNum = c.get(Calendar.SECOND);
//        String second = String.format("%2d", secondNum).replace(" ", "0");
//        System.out.println("second = " + second);
//
//        int millisecondNum = c.get(Calendar.MILLISECOND);
//        String millisecond = String.format("%3d", millisecondNum).replace(" ", "0");
//        System.out.println("millisecond = " + millisecond);
//
//        String dateNowString = phoneNum+year+month+date+hour+minute+second+millisecond;
//        System.out.println("dateNowString = " + dateNowString);
//        return dateNowString;
//    }

}
