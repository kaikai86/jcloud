package cn.org.jcloud.controller;

import cn.org.jcloud.jwechat.annotation.WxHandlerScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Title WechatManagerApplication
 * @Description     微信公众号管理api
 * @Author ZhangKai
 * @Date 2020/4/10 0010
 * @Version 1.0
 * @Email 410618538@qq.com
 */

@SpringBootApplication(scanBasePackages="cn.org.jcloud.controller")
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = "cn.org.jcloud.client")
@WxHandlerScan("com.hbd.erp.wechat.service")
public class WechatManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WechatManagerApplication.class);
    }
}
