package com.cn.fanguangfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Bangsun
 * @date 2020-11-26
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.cn.fanguangfu.dao"})
public class AppMain {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }
}
