package com.sic.springboot_maven_fourth.entiy;

import com.sic.springboot_maven_fourth.pojo.Groupcoefficient;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class CalGroupCoefficients {
    private List<Groupcoefficient> groupcoefficients;

    public CalGroupCoefficients(List<Groupcoefficient> groupcoefficients) {
        this.groupcoefficients = groupcoefficients;
    }
    public  List<Groupcoefficient> getGroupcoefficients() {
        //获取系统时间
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        //获取当前月份
        //int month = now.getMonthValue();
        int month = 12; //测试用
        //循环遍历所有数据
        for (Groupcoefficient groupcoefficient : groupcoefficients) {
            groupcoefficient.setRevenueGold2Month(groupcoefficient.getRevenueGold() / 12 * month);
            double temp = groupcoefficient.getCurrentRevenue() / groupcoefficient.getRevenueGold2Month();
            if (temp>=1){
                groupcoefficient.setGroupCoefficient(1);
            }else if (temp<1 && temp>=0.9) {
                groupcoefficient.setGroupCoefficient(0.8);
            }else{
                groupcoefficient.setGroupCoefficient(0.6);
            }
        }
        return groupcoefficients;
    }
}

