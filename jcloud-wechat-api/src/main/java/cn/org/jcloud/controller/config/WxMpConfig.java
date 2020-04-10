package cn.org.jcloud.controller.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Title WxMpConfig
 * @Description 微信公众号配置类
 * @Author ZhangKai
 * @Date 2020/4/1 0001
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@Configuration
@Getter
public class WxMpConfig {

    @Value("${weixin.appid}")
    private String appid;
    @Value("${weixin.secret}")
    private String secret;
    @Value("${weixin.encodingaeskey}")
    private String encodingaeskey;
    @Value("${weixin.token}")
    private String token;
}
