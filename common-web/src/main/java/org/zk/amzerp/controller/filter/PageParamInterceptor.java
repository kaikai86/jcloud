package org.zk.amzerp.controller.filter;

import cn.hutool.core.util.StrUtil;
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
        if (StrUtil.isBlank(pageNumberInHeader) && StrUtil.isBlank(pageNumberInUrl)) {
            hasPageNumber = false;
            MDC.put(PAGE_NUMBER, String.valueOf(pageNumber));
        } else {
            String pageNumberInThread = StrUtil.isBlank(pageNumberInUrl) ? pageNumberInHeader : pageNumberInUrl;// 优先使用url中参数
            MDC.put(PAGE_NUMBER, pageNumberInThread);
        }
        if (StrUtil.isBlank(pageSizeInHeader) && StrUtil.isBlank(pageSizeInUrl)) {
            hasPageSize = false;
            MDC.put(PAGE_SIZE, String.valueOf(pageSize));
        } else {
            String pageSizeInThread = StrUtil.isBlank(pageSizeInUrl) ? pageSizeInHeader : pageSizeInUrl;// 优先使用url中参数
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
        if (StrUtil.isBlank(response.getHeader(TOTAL_PAGE)) && StrUtil.isNotBlank(MDC.get(TOTAL_PAGE))) {
            response.addHeader(TOTAL_PAGE, MDC.get(TOTAL_PAGE));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        MDC.clear();
    }
}
