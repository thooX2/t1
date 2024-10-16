package ks52team01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ks52team01.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 로그인 체크 인터셉터 등록
		LoginCheckInterceptor loginCheckInterceptor = new LoginCheckInterceptor();
		registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/exam/**").addPathPatterns("/user/userMyPage").addPathPatterns("/score/**").addPathPatterns("/user/userInfoModfiy").excludePathPatterns("/exam/examMain");

	}

}
