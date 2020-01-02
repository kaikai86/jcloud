package org.zk.amzerp.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "org.zk.amzerp")
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = "org.zk.amzerp.client")
public class WebManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebManagerApplication.class);
    }
}
