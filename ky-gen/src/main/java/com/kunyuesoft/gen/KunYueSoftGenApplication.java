package com.kunyuesoft.gen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kunyuesoft.gen.**.mapper")
public class KunYueSoftGenApplication {

    public static void main(String[] args) {
        SpringApplication.run(KunYueSoftGenApplication.class, args);
    }

}
