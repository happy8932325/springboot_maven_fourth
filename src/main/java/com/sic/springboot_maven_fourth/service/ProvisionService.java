package com.sic.springboot_maven_fourth.service;

import com.sic.springboot_maven_fourth.dao.ProvisionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvisionService {
    private final ProvisionDao provisionDao;

    @Autowired
    public ProvisionService(ProvisionDao provisionDao) {
        this.provisionDao = provisionDao;
    }

    public String getProvision() {
        // 调用dao获取配置信息
        List<ProvisionDao> provision = provisionDao.getProvision();
        for (ProvisionDao p : provision){
            System.out.println(p.getProvision());
        }
        return "Provision Calculated Successfully";
    }
}
