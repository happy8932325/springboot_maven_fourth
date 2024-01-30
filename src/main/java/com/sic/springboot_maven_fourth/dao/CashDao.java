package com.sic.springboot_maven_fourth.dao;

import com.sic.springboot_maven_fourth.pojo.Cash;
import com.sic.springboot_maven_fourth.pojo.Selfjoincontractcoefficient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CashDao {

    @Select("select * from cashtest")
    List<Cash> SelectAll();

    @Update("update cashtest set selfJoinContractCoefficient = #{selfJoinContractCoefficient} where name = #{name}")
    void updateSelfJoinContractCoefficient(Selfjoincontractcoefficient selfjoincontractcoefficient);

    @Update("update cashtest set volumeCommission = #{volumeCommission} where Contract_No = #{contractNo}")
    void updateVolumeCommission(Cash cash);

    @Update("update cashtest set targetProfit = #{targetProfit} where Contract_No = #{contractNo}")
    void updateTargetProfit(Cash cash);

    @Update("update cashtest set profitCommission = #{profitCommission} where Contract_No = #{contractNo}")
    void updateProfitCommission(Cash cash);

    @Update("update cashtest set selfJoinContractCommission = #{selfJoinContractCommission} where Contract_No = #{contractNo}")
    void updateSelfJoinContractCommission(Cash cash);

    @Update("update cashtest set cash = #{cash} where Contract_No = #{contractNo}")
    void updateTotalCommission(Cash cash);
}
