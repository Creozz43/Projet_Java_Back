package com.epf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.epf.config.DataSourceConfig;



@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.checkConnection();

    }

}