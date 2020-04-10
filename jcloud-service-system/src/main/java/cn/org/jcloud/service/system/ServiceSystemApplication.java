package cn.org.jcloud.service.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "cn.org.jcloud")
@MapperScan("cn.org.jcloud.service")
@EnableDiscoveryClient
public class ServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSystemApplication.class);
    }
}
