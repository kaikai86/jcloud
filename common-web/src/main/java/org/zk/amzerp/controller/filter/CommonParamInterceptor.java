package org.zk.amzerp.controller.filter;

import com.hbd.erp.model.auth.vo.AuthUserVO;
import com.hbd.erp.model.constant.UserConstants;
import com.hbd.erp.service.auth.AuthUserService;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

/**
 * 处理微服务间的通用参数
 * 
 * @author haozi
 *
 */
@CommonsLog
@Component
public class CommonParamInterceptor implements HandlerInterceptor {
    @Autowired
    private AuthUserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info(request.getRequestURI());
        String userId = request.getParameter(UserConstants.CLOUD_USER_ID) == null ? "-1"
                : request.getParameter(UserConstants.CLOUD_USER_ID);
        MDC.put(UserConstants.CLOUD_USER_ID,userId);
        if (StringUtils.isNotBlank(userId)&&"-1" != userId) {
            AuthUserVO userVO = userService.getById(BigInteger.valueOf(Long.valueOf(userId)));
            if (userVO != null) {
                MDC.put(UserConstants.USER_ADMIN_TYPE, userVO.getAdminType());
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        MDC.clear();
    }
}
