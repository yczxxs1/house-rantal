package com.netflix.houserental.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	/*@Autowired
	private Interceptor interceptor;*/

	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//默认匹配/**，且无返回值，如果引入spring boot security这返回验证错误
		registry.addInterceptor(interceptor).addPathPatterns("/acdfsdf");
		super.addInterceptors(registry);
	}*/
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
	

}
