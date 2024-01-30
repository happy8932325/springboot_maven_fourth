package com.sic.springboot_maven_fourth.service;

import com.sic.springboot_maven_fourth.dao.CashDao;
import com.sic.springboot_maven_fourth.dao.groupCoefficientDao;
import com.sic.springboot_maven_fourth.dao.CashDaoV2;
import com.sic.springboot_maven_fourth.entiy.CalGroupCoefficients;
import com.sic.springboot_maven_fourth.pojo.Groupcoefficient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CashServiceV2 {
    private  final CashDaoV2 cashDaoV2;

    private final groupCoefficientDao groupCoefficientDao;

    @Autowired
    public CashServiceV2(CashDaoV2 cashDaoV2, com.sic.springboot_maven_fourth.dao.groupCoefficientDao groupCoefficientDao) {
        this.cashDaoV2 = cashDaoV2;
        this.groupCoefficientDao = groupCoefficientDao;
    }

    @Transactional
    public String getCash() {
        //step:1 先获取核算体规模系数
        List<Groupcoefficient> allData = groupCoefficientDao.getAllData();
        //step:2 allData传给一个entity用来计算所有数据
        List<Groupcoefficient> calGroupCoefficients = new CalGroupCoefficients(allData).getGroupcoefficients();
        System.out.println(calGroupCoefficients);
        //step:3 更新核算体规模系数到数据库
        updateGroupcoefficient(calGroupCoefficients);
        //step:4 计算核算体规模系数
        return  "核算体规模系数计算完成";
    }

    private void updateGroupcoefficient(List<Groupcoefficient> calGroupCoefficients) {
        // 更新结果到数据库
        for (Groupcoefficient groupcoefficient : calGroupCoefficients){
            groupCoefficientDao.updateGroupcoefficient(groupcoefficient);
        }
    }
}
