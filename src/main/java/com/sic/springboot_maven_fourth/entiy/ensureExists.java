package com.sic.springboot_maven_fourth.entiy;

import com.sic.springboot_maven_fourth.pojo.Cash;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ensureExists {
    private Cash cash;

    public double getCashExists() {
        double exists;
        if (cash.getGroup().equals("西北")) {
            exists = 0.085;
        } else if (cash.getGroup().equals("市政")) {
            exists = 0.12;
        } else {
            exists = 0.082;
        }
        return exists;
    }
}
