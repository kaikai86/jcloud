package cn.org.jcloud.controller.handler.message;

import cn.org.jcloud.jwechat.bean.message.receive.InTextMessage;
import cn.org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.handler.message.AbstractWxTextMessageHandler;
import cn.org.jcloud.jwechat.util.OutMessageHelper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title WxTextMessageHandler
 * @Description 微信文本消息处理实现
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class WxTextMessageHandler extends AbstractWxTextMessageHandler {


    @Override
    protected OutBaseMessage handleDetail(InTextMessage textMessage, String openId, String content, OutMessageHelper outMessageHelper, WxConfig wxConfig) {
        String token = wxConfig.getToken();
        return outMessageHelper.replyNullMessage();
    }
}
