package cn.org.jcloud.controller.handler.event;


import cn.org.jcloud.jwechat.bean.message.event.InSubscribeEvent;
import cn.org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.handler.event.AbstractWxSubscribeEventHandler;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

/**
 * @Title WxSubscribeEventHandler
 * @Description 微信关注事件处理实现
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class WxSubscribeEventHandler extends AbstractWxSubscribeEventHandler {


    @Override
    protected OutBaseMessage handleDetail(InSubscribeEvent inSubscribeEvent, String openId, OutMessageHelper outMessageHelper, WxConfig wxConfig) {
        String content = "你好，欢迎关注XXX公众号";
        //保存该微信账户到微信
        return outMessageHelper.replyTextMessage(content);
    }
}
