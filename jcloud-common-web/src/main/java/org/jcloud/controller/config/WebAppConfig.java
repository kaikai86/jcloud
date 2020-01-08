package org.jcloud.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.jcloud.controller.filter.PageParamInterceptor;

@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    @Autowired
    private PageParamInterceptor pageParamInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
        // 通用分页参数处理
        registry.addInterceptor(pageParamInterceptor).addPathPatterns("/**");
	}

}
