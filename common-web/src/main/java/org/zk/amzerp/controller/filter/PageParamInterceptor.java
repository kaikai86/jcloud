package org.zk.amzerp.controller.filter;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理通用分页参数
 * 
 * @author haozi
 *
 */
@CommonsLog
@Component
public class PageParamInterceptor implements HandlerInterceptor {
    final static String HAS_PAGE = "hasPage";
    final static String PAGE_NUMBER = "pageNumber";
    final static String PAGE_SIZE = "pageSize";
    final static String TOTAL_PAGE = "totalPage";

    private int pageNumber = 1;// 默认查询第一页
    private int pageSize = 10;// 默认每页10条
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String pageNumberInHeader = request.getHeader(PAGE_NUMBER);
        String pageNumberInUrl = request.getParameter(PAGE_NUMBER);
        String pageSizeInHeader = request.getHeader(PAGE_SIZE);
        String pageSizeInUrl = request.getParameter(PAGE_SIZE);
        boolean hasPageNumber = true;
        boolean hasPageSize = true;
        if (StringUtils.isBlank(pageNumberInHeader) && StringUtils.isBlank(pageNumberInUrl)) {
            hasPageNumber = false;
            MDC.put(PAGE_NUMBER, String.valueOf(pageNumber));
        } else {
            String pageNumberInThread = StringUtils.isBlank(pageNumberInUrl) ? pageNumberInHeader : pageNumberInUrl;// 优先使用url中参数
            MDC.put(PAGE_NUMBER, pageNumberInThread);
        }
        if (StringUtils.isBlank(pageSizeInHeader) && StringUtils.isBlank(pageSizeInUrl)) {
            hasPageSize = false;
            MDC.put(PAGE_SIZE, String.valueOf(pageSize));
        } else {
            String pageSizeInThread = StringUtils.isBlank(pageSizeInUrl) ? pageSizeInHeader : pageSizeInUrl;// 优先使用url中参数
            MDC.put(PAGE_SIZE, pageSizeInThread);
        }
        if(hasPageNumber || hasPageSize){
            MDC.put(HAS_PAGE,"true");
        }else {
            MDC.put(HAS_PAGE,"false");
        }
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
        if (StringUtils.isBlank(response.getHeader(TOTAL_PAGE)) && StringUtils.isNotBlank(MDC.get(TOTAL_PAGE))) {
            response.addHeader(TOTAL_PAGE, MDC.get(TOTAL_PAGE));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        MDC.clear();
    }
}
