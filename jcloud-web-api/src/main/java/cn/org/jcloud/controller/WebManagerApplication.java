package cn.org.jcloud.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages="cn.org.jcloud.controller")
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = "cn.org.jcloud.client")
public class WebManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebManagerApplication.class);
    }
}
