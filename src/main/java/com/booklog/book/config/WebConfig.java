package com.booklog.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/v1/books/**") // v1/books/ 경로에 대해서 CORS 설정
			.allowedOrigins("http://localhost:3000") // 리액트 애플리케이션의 도메인을 설정
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowCredentials(true);
	}
}