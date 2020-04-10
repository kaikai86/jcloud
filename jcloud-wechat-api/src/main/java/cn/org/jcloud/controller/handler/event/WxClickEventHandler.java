package cn.org.jcloud.controller.handler.event;


import cn.org.jcloud.jwechat.bean.message.event.InClickEvent;
import cn.org.jcloud.jwechat.bean.message.send.OutBaseMessage;
import cn.org.jcloud.jwechat.config.WxConfig;
import cn.org.jcloud.jwechat.handler.event.AbstractWxClickEventHandler;
import cn.org.jcloud.jwechat.util.OutMessageHelper;

/**
 * @Title WxClickEventHandler
 * @Description 微信点击事件处理实现
 * @Author ZhangKai
 * @Date 2020/4/7 0007
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class WxClickEventHandler extends AbstractWxClickEventHandler {

    @Override
    protected OutBaseMessage handleDetail(InClickEvent inClickEvent, String openId, OutMessageHelper outMessageHelper, WxConfig config, String eventKey) {
        switch (eventKey) {
            case "HBDERP1001":
                break;
        }
        return null;
    }
}
