package cn.org.jcloud.controller.wechat;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import cn.org.jcloud.jwechat.api.message.WxMainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title WechatController
 * @Description     微信验证、接收推送消息Controller
 * @Author ZhangKai
 * @Date 2020/4/10 0010
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@RestController
@Slf4j
public class WechatController {

    @Autowired
    private WxMainService wxMainService;


    @RequestMapping(method = RequestMethod.GET)
    public String bind(@RequestParam(name = "signature", required = false) String signature,
                       @RequestParam(name = "timestamp", required = false) String timestamp,
                       @RequestParam(name = "nonce", required = false) String nonce,
                       @RequestParam(name = "echostr", required = false) String echostr) {

        log.info("接收到来自微信服务器的认证消息：[{},{},{},{}]",signature,timestamp,nonce,echostr);

        if (StrUtil.isBlank(signature) || StrUtil.isBlank(timestamp) || StrUtil.isBlank(nonce) || StrUtil.isBlank(echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }
        log.info("微信配置:[{}]",JSONUtil.toJsonStr(wxMainService.getConfig()));
        if (wxMainService.check(timestamp, nonce, signature)) {
            log.info("微信绑定成功,echostr： [{}]",echostr);
            return echostr;
        } else {
            log.warn("绑定微信服务器失败");
        }
        return"非法请求";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handel(@RequestBody String requestBody, @RequestParam("signature") String signature,
                         @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce,
                         @RequestParam(name = "encrypt_type", required = false) String encType,
                         @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        log.info("接收到来自微信服务器的推送消息认证：[{},{},{}]",signature,timestamp,nonce);
        if (encType != null && msgSignature != null) {
            log.info("接收到来自微信服务器的加密消息：[{},{}]",encType,msgSignature);
        }
        log.info("接收到来自微信服务器的xml消息：[{\n".concat(requestBody).concat("\n}]"));
        if (!wxMainService.check(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }
        String handle = wxMainService.handle(encType, requestBody, timestamp, nonce, msgSignature);
        log.info("返回给微信服务器的消息：[{}]",handle);
        return handle;

    }
}
