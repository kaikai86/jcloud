package cn.org.jcloud.controller.filter;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理通用分页参数
 * 
 * @author zhangkai
 *
 */
@Component
@Slf4j
public class ResponseResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        /**
         * 分页响应头totalPage
         * 如未用@ResponseBody则在此处理，
         * 否则在@see PageParamAdvice 处理
         */
//        if (StrUtil.isBlank(response.getHeader(TOTAL_PAGE)) && StrUtil.isNotBlank(MDC.get(TOTAL_PAGE))) {
//            response.addHeader(TOTAL_PAGE, MDC.get(TOTAL_PAGE));
//        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
