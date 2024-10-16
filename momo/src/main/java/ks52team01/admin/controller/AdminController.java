package ks52team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

	@PostMapping("admin/adminPage")
	public String adminPage() {
		return "views/admin/admin_main_home";
	}
	
	@PostMapping("admin/adminLoginMove")
	public String adminLoginMove() {
		return "views/admin/admin_login";
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
