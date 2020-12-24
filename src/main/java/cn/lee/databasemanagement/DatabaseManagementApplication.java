package cn.lee.databasemanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@MapperScan("cn.lee.databasemanagement.mapper")//对mapper包的扫描
public class DatabaseManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseManagementApplication.class, args);
    }

}
