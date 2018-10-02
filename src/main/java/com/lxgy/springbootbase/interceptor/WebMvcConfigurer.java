package com.lxgy.springbootbase.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Gryant
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
//		registry.addInterceptor(new SessionInterceptor())
//				.addPathPatterns("/tl/**")
		;
		
		super.addInterceptors(registry);
	}

}
