package ks52team01.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ks52team01.student.user.dto.User;

public class AdminLoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 세션에서 로그인 정보를 가져옵니다.
		User user = (User) request.getSession().getAttribute("loggedInUser"); // 'loggedUser'는 로그인한 사용자 정보를 담고 있는 세션 속성

		// 로그인되지 않은 경우
		if (user == null) {
			// 로그인 페이지로 리다이렉트
			response.sendRedirect("/admin/adminNotLogin");
			return false; // 요청을 중단
		}

		if (!("ugc1").equals(user.getGradeCode())) {
			response.sendRedirect("/admin/adminHaveNotAuth");
			return false; // 요청을 중단
		}

		return true; // 로그인된 경우 요청을 계속 진행
	}
}