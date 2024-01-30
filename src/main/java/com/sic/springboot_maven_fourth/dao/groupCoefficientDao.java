package com.sic.springboot_maven_fourth.dao;

import com.sic.springboot_maven_fourth.pojo.Groupcoefficient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface groupCoefficientDao {

    @Select("SELECT * FROM groupcoefficienttest")
    List<Groupcoefficient> getAllData();

    @Update("UPDATE groupcoefficienttest SET revenueGold2Month=#{revenueGold2Month},groupCoefficient=#{groupCoefficient} WHERE `group`=#{group}")
    void updateGroupcoefficient(Groupcoefficient groupcoefficient);

}
