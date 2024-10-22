package ks52team01.admin.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks52team01.admin.exam.service.AdminExamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/admin/exam/")
public class AdminExamController {

	private final AdminExamService adminExamService;

	@GetMapping("/category")
	public String adminExamCategory() {
		adminExamService.getAdminExamCategoryList();

		return "view/admin/exam/admin_exam_category";
	}

	@GetMapping("/management")
	public String admintest6() {
		return "view/admin/exam/admin_exam_management";
	}

	@GetMapping("/addQuestion")
	public String admintest5() {
		return "view/admin/exam/admin_exam_add_question";
	}

	@GetMapping("/questionPopup")
	public String admintest4() {
		return "view/admin/exam/admin_exam_question_popup";
	}

	@GetMapping("/managementList")
	public String admintest3() {
		return "view/admin/exam/admin_exam_management_list";
	}

	@GetMapping("/questionList")
	public String admintest() {
		return "view/admin/exam/admin_exam_question_list";
	}

}
