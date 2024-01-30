package com.sic.springboot_maven_fourth.service;

import com.sic.springboot_maven_fourth.dao.CashDao;
import com.sic.springboot_maven_fourth.dao.Selfjoincontractcofficient;
import com.sic.springboot_maven_fourth.entiy.CalSelfCoefficients;
import com.sic.springboot_maven_fourth.entiy.ensureExists;
import com.sic.springboot_maven_fourth.pojo.Cash;
import com.sic.springboot_maven_fourth.pojo.Selfjoincontractcoefficient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CashService {
    private final CashDao cashDao;
    private final Selfjoincontractcofficient selfjoincontractcoefficientDao;


    @Autowired
    public CashService(CashDao cashDao, Selfjoincontractcofficient selfjoincontractcoefficientDao) {
        this.cashDao = cashDao;
        this.selfjoincontractcoefficientDao = selfjoincontractcoefficientDao;
    }

    @Transactional
    public String CalCash() {
        List<Cash> cashes = cashDao.SelectAll();
        List<Selfjoincontractcoefficient> selfjoincontractcoefficients = selfjoincontractcoefficientDao.SelectAll();
        //step 1:计算自接系数
        selfjoincontractcoefficients = new CalSelfCoefficients(selfjoincontractcoefficients).calSelfCoefficient();
        //step 2:更新自接系数到总表
        updateSelfJoinContractCoefficient(selfjoincontractcoefficients);
        //step 3:计算规模提成
        CalVolumeCommission(cashes);
        //step 4:计算目标利润
        UpdateTargetProfit(cashes);
        //step 5:计算利润提成
        cashes = cashDao.SelectAll(); //这里要重新获取一下数据，因为上面的操作已经更新了数据
        UpdateProfitCommission(cashes);
        //step 6:自接合同提成
        UpdateSelfJoinContractCommission(cashes);
        cashes = cashDao.SelectAll(); //这里要重新获取一下数据，因为上面的操作已经更新了数据
        //step 7:计算总提成
        for (Cash cash : cashes) {
            cash.setCash(cash.getVolumeCommission() + cash.getProfitCommission() + cash.getSelfJoinContractCommission());
            cashDao.updateTotalCommission(cash);
        }

        return "Cash Calculation Successfully";
    }

    private void updateSelfJoinContractCoefficient(List<Selfjoincontractcoefficient> selfjoincontractcoefficients) {
        //todo 更新自接合同系数到总表
        for (Selfjoincontractcoefficient selfjoincontractcoefficient : selfjoincontractcoefficients) {
            selfjoincontractcoefficientDao.updateSelfJoinContractCoefficient(selfjoincontractcoefficient);
            cashDao.updateSelfJoinContractCoefficient(selfjoincontractcoefficient);
        }
    }
    private void CalVolumeCommission(List<Cash> cashes) {
        //todo 计算规模提成
        for (Cash cash : cashes) {
            double exists =new ensureExists(cash).getCashExists();
            if (cash.getName().equals("何岱林")||cash.getName().equals("施昌钧")) {
                cash.setVolumeCommission(0);
            }else {
                double temp =cash.getCurrentWithdrawal() / cash.getCurrentRevenue() * cash.getCurrentWithdrawal() * 0.3 * exists ;
                //保留整数
                cash.setVolumeCommission((int)temp);
            }
            cashDao.updateVolumeCommission(cash);
        }
    }

    private void UpdateTargetProfit(List<Cash> cashes) {
        //todo 计算目标利润
        for (Cash cash : cashes) {
            cash.setTargetProfit((int)(cash.getCurrentRevenue() * 0.4));
            cashDao.updateTargetProfit(cash);
        }
    }
    private void UpdateProfitCommission(List<Cash> cashes) {
        //todo 计算利润提成
        for (Cash cash : cashes) {
            double exists =new ensureExists(cash).getCashExists();
            if (cash.getName().equals("何岱林")||cash.getName().equals("施昌钧")) {
                cash.setProfitCommission(0);}
            else{
            cash.setProfitCommission((int)(cash.getCurrentProfit() / cash.getTargetProfit() * cash.getCurrentWithdrawal() * 0.55 * exists));
            }
            cashDao.updateProfitCommission(cash);
        }
    }
    private void UpdateSelfJoinContractCommission(List<Cash> cashes) {
        //todo 计算自接合同提成
        for (Cash cash : cashes) {
            double exists =new ensureExists(cash).getCashExists();
            if (cash.getName().equals("何岱林")||cash.getName().equals("施昌钧")) {
                cash.setSelfJoinContractCommission(0);}
            else{
                cash.setSelfJoinContractCommission((int)(cash.getCurrentWithdrawal() * cash.getSelfJoinContractCoefficient() * 0.15 * exists));
            }
            cashDao.updateSelfJoinContractCommission(cash);
        }
    }
}
