package com.sic.springboot_maven_fourth;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@SpringBootTest
class SpringbootMavenFourthApplicationTests {
    @Test
    public void testMonth() {
        //获取系统时间
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        //获取当前月份
        int month = now.getMonthValue();
        //断言当前月份在1-12之间
        System.out.println(month);
    }

}
