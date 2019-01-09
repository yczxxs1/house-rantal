package com.netflix.houserental.common.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class BeanConfig {

	/**
	 * <p>类型转换
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	/**
	 * <p>服务消费
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * <p>类型转换
	 * @return
	 */
	@Bean
	public MapperFactory mapperFactory() {
		return new DefaultMapperFactory.Builder().build();
	}
	
	/**
	 * <p>类型转换
	 * @return
	 */
	@Bean
	public MapperFacade mapperFacade() {
		return mapperFactory().getMapperFacade();
	}
}
