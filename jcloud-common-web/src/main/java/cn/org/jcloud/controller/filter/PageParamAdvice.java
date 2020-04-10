package cn.org.jcloud.controller.filter;

import cn.hutool.core.util.StrUtil;
import cn.org.jcloud.controller.constant.WebConstant;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;

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
        if (StrUtil.isBlank(actualResponse.getHeader(WebConstant.TOTAL_PAGE)) && StrUtil.isNotBlank(MDC.get(WebConstant.TOTAL_PAGE))) {
            actualResponse.addHeader(WebConstant.TOTAL_PAGE, MDC.get(WebConstant.TOTAL_PAGE));
        }
        return o;
    }
}
