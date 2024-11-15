package ks52team01.student.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks52team01.common.ResponseError;
import ks52team01.student.user.dto.User;
import ks52team01.student.user.dto.UserJoinInfo;
import ks52team01.student.user.service.UserService;
import ks52team01.student.user.service.UserServiceImpl;

@Controller
public class UserController {
	private final UserService userService;

	public UserController(UserServiceImpl userServiceImpl) {
		this.userService = userServiceImpl;
	}

	@GetMapping("/user/userMyPage")
	public String userMyPage() {
		return "view/user/user/user_mypage";
	}

	@GetMapping("/user/loginMove")
	public String loginMove() {
		return "view/user/user/user_login";
	}

	@PostMapping("/user/loginAction")
	public String loginAction(@ModelAttribute User user, Model model, HttpSession session) {
		System.out.println("유저로그인 실행");
		int loginResult = userService.userLoginAction(user);

		// 아이디가 없는 경우
		if (loginResult == -1) {
			model.addAttribute("errorId", "아이디가 존재하지 않습니다.");
			return "view/user/user/user_login";
		}

		// 비밀번호가 틀린 경우
		if (loginResult == 0) {
			model.addAttribute("errorPw", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("userId", user.getUserId()); // 입력한 아이디를 모델에 추가
			return "view/user/user/user_login";
		}

		// 로그인 성공 시
		User loginUser = userService.getUserById(user);
		session.setAttribute("loggedInUser", loginUser);
		return "redirect:/index";

	}

	@GetMapping("/user/logout")
	public String logoutAction(HttpSession session) {
		System.out.println("유저 로그아웃");
		session.invalidate();
		return "redirect:/index";
	}

	@GetMapping("/user/userJoinMove")
	public String userJoinMove() {
		return "view/user/user/user_join_form";
	}

	@PostMapping("/user/userJoinAction")
	public String userJoinAction() {
		return "view/home/index";
	}

	@PostMapping("/user/userJoinCheck")
	@ResponseBody
	public ResponseError getUserJoinCheck(UserJoinInfo userJoinInfo) {
		return userService.userJoinCheck(userJoinInfo);
	}

	@GetMapping("/user/userNotLogIn")
	public String userNotLogIn() {
		return "view/user/user/not_login";
	}
}
