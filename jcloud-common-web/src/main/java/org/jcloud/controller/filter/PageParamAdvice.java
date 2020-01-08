package org.jcloud.controller.filter;

import cn.hutool.core.util.StrUtil;
import org.jcloud.controller.api.vo.Result;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;

import static org.jcloud.controller.constant.WebConstant.TOTAL_PAGE;

@RestControllerAdvice
public class PageParamAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
            ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        HttpServletResponse actualResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        /**
         * 处理使用了@ResponseBody的情况
         */
        if (StrUtil.isBlank(actualResponse.getHeader(TOTAL_PAGE)) && StrUtil.isNotBlank(MDC.get(TOTAL_PAGE))) {
            actualResponse.addHeader(TOTAL_PAGE, MDC.get(TOTAL_PAGE));
        }
        return o;
    }
}
