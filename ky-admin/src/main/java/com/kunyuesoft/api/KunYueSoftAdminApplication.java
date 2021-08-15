package com.kunyuesoft.api;

import com.kunyuesoft.common.utils.SpringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = "com.kunyuesoft")
@MapperScan("com.kunyuesoft.dao.**.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@Import({SpringUtils.class})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.kunyuesoft.fegin")
public class KunYueSoftAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(KunYueSoftAdminApplication.class, args);
    }

}
