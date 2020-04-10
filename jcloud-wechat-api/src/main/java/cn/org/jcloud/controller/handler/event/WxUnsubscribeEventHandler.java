package cn.org.jcloud.controller.handler.event;

import cn.org.jcloud.jwechat.bean.message.event.InUnsubscribeEvent;
import cn.org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.handler.event.AbstractWxUnsubscribeEventHandler;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

/**
 * @Title WxUnsubscribeEventHandler
 * @Description 微信取消关注事件处理实现
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class WxUnsubscribeEventHandler extends AbstractWxUnsubscribeEventHandler {


    @Override
    protected OutBaseMessage handleDetail(InUnsubscribeEvent inUnsubscribeEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config) {
        return null;
    }
}
