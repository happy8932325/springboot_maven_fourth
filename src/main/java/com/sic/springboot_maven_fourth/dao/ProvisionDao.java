package com.sic.springboot_maven_fourth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProvisionDao {
     @Select("select * from provision")
     List<ProvisionDao> getProvision();


}
