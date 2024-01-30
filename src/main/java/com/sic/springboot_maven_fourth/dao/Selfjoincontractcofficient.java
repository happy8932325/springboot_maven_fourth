package com.sic.springboot_maven_fourth.dao;

import com.sic.springboot_maven_fourth.pojo.Selfjoincontractcoefficient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Selfjoincontractcofficient {

    @Select("select * from selfjoincontractcoefficienttest")
    List<Selfjoincontractcoefficient> SelectAll();

    @Update("update selfjoincontractcoefficienttest set selfJoinContractCoefficient = #{selfJoinContractCoefficient} where name = #{name}")
    void updateSelfJoinContractCoefficient(Selfjoincontractcoefficient selfjoincontractcoefficient);
}
