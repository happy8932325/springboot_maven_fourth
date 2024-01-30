package com.sic.springboot_maven_fourth.dao;

import com.sic.springboot_maven_fourth.pojo.Groupcoefficient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface groupCoefficientDao {

    @Select("SELECT * FROM groupcoefficient")
    List<Groupcoefficient> getAllData();

    @Update("update groupcoefficient set groupCoefficient = #{groupCoefficient} where `group` = #{group}")
    void updateGroupcoefficient(Groupcoefficient groupcoefficient);

}
