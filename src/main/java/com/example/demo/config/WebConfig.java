package com.example.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.example.demo.config.interceptors.LoginInterceptor;


@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


	@Autowired
	 private LoginInterceptor loginInterceptor;


	  @Bean
	    LoginInterceptor loginInterceptor() {
	        return new LoginInterceptor();
	    }
	  
    
    public WebConfig(){
        super();
    }

/**
 * 配置静态资源
 */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
    
    
    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        System.out.println("111");
        /// excludePathPatterns("/login") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/hlw/**").excludePathPatterns("/hlw/login","/hlw/emailforpwd","/hlw/index","/hlw/backstage/**");
        		
        super.addInterceptors(registry);
    }
}