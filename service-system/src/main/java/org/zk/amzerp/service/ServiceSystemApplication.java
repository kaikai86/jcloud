package org.zk.amzerp.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "org.zk.amzerp")
@MapperScan("org.zk.amzerp.service")
@EnableDiscoveryClient
public class ServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSystemApplication.class);
    }
}
