package ks52team01.admin.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks52team01.admin.exam.service.AdminExamService;
import ks52team01.admin.user.service.AdminService;
import ks52team01.common.files.service.FileService;
import ks52team01.common.files.util.FilesUtils;
import ks52team01.common.mapper.CommonMapper;
import ks52team01.student.user.dto.User;
import ks52team01.student.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {

	private final AdminService adminService;
	private final UserService userService;

	@PostMapping("/admin/adminLoginMove")
	public String adminLoginMove(@RequestParam(name = "userId") String userId,
			@RequestParam(name = "userPw") String userPw, HttpSession session, Model model) {
		int loginResult = adminService.adminLoginAction(userId, userPw);

		// 아이디가 없는 경우
		if (loginResult == -1) {
			model.addAttribute("error", "해당정보를 가진 관리자아이디가 없습니다");
			return "view/admin/user/admin_login";
		}

		// 비밀번호가 틀린 경우
		if (loginResult == 0) {
			model.addAttribute("error", "해당정보를 가진 관리자아이디가 없습니다");

			return "view/admin/user/admin_login";
		}
		User user = new User();
		user.setUserId(userId);
		user.setUserPw(userPw);
		// 로그인 성공 시
		User loginUser = userService.getUserById(user);
		session.setAttribute("loggedInUser", loginUser);

		return "redirect:/admin/exam/category";
	}

	@GetMapping("/admin/adminPage")
	public String adminPage() {
		return "view/admin/user/admin_main_home";
	}

	@GetMapping("/admin/adminLoginMove")
	public String adminLoginMove() {
		return "view/admin/user/admin_login";
	}

	// 15번 문서 보면서 URI 매핑하다가 의도를 모르겠어서 중지

	public void adminLogoutAction() {

	}

	public void adminInfoModifyAction() {

	}

	public void adminJoinAction() {

	}

	public void adminInfoDetailAction() {

	}

	public void adminDeleteAction() {

	}

	public void adminFindIdAction() {

	}

	public void adminFindPwAction() {

	}
}
