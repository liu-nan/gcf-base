package com.gcf.provider.asset.configer;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcf.provider.asset.filter.AuthorizeFilter;

@Configuration
public class LocalConfiger {

	@Bean
	public FilterRegistrationBean<AuthorizeFilter> authorizeFilter(){
		FilterRegistrationBean<AuthorizeFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new AuthorizeFilter());
		bean.setOrder(1);
		//过滤规则
//		List<String> urls = new ArrayList<>();
//        urls.add("/users/*");
//        filterRegistrationBean.setUrlPatterns(urls);//
		return bean;
	}
}
