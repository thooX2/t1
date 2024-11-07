package ks52team01.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import ks52team01.interceptor.LoginCheckInterceptor;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

	@Value("${file.path}")
	private String filePath;

	public String getOSRootPath() {
		String rootPath = "file:///";
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("window")) {
			rootPath += "c:";
		}
		return rootPath;
	}

	/**
	 * 외부파일 연결
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String rootPath = getOSRootPath();

		registry.addResourceHandler("/attachment/**").addResourceLocations(rootPath + filePath + "/attachment/")
				.setCachePeriod(3600).resourceChain(true).addResolver(new PathResourceResolver());

		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 로그인 체크 인터셉터 등록
		LoginCheckInterceptor loginCheckInterceptor = new LoginCheckInterceptor();
		registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/exam/**").addPathPatterns("/user/userMyPage")
				.addPathPatterns("/score/**").addPathPatterns("/user/userInfoModfiy").addPathPatterns("/study/**")
				.excludePathPatterns("/exam/examMain");

	}

}
