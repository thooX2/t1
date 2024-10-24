package ks52team01.admin.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ks52team01.admin.exam.dto.ExamQnaChap;
import ks52team01.admin.exam.dto.ExamQnaType;
import ks52team01.admin.exam.dto.QnaBank;
import ks52team01.admin.exam.dto.SubMirCate;
import ks52team01.admin.exam.dto.SubMjrCate;
import ks52team01.admin.exam.service.AdminExamService;
import ks52team01.student.user.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/admin/exam/")
public class AdminExamController {

	private final AdminExamService adminExamService;

	@GetMapping("/searchQuestionList")
	@ResponseBody
	public List<QnaBank> searchQuestionList(QnaBank qnaBank) {
		List<QnaBank> searchList = new ArrayList<QnaBank>();
		log.error("searchKeyword:{}", qnaBank);
		return searchList;
	}

	@PostMapping("/addQuestion")
	public String adminExamAddQuestion(QnaBank qnaBank) {
		adminExamService.addExamQuestion(qnaBank);

		return "redirect:/admin/exam/questionList";
	}

	@GetMapping("/category")
	public String adminExamCategory(Model model) {

		List<SubMirCate> categoryList = new ArrayList<SubMirCate>();
		categoryList = adminExamService.getAdminExamCategoryList();

		model.addAttribute("categoryList", categoryList);
		return "view/admin/exam/admin_exam_category";
	}

	@GetMapping("/management")
	public String admintest6() {
		return "view/admin/exam/admin_exam_management";
	}

	@GetMapping("/addQuestion")
	public String adminExamAddQuestion(Model model) {
		List<SubMirCate> categoryList = new ArrayList<SubMirCate>();
		categoryList = adminExamService.getAdminExamCategoryList();

		List<User> userList = new ArrayList<User>();
		userList = adminExamService.getUserListByGrade("ugc1");

		List<ExamQnaType> qnaTypeList = new ArrayList<ExamQnaType>();
		qnaTypeList = adminExamService.getQnaTypeList();

		List<ExamQnaChap> qnaChapList = new ArrayList<ExamQnaChap>();
		qnaChapList = adminExamService.getQnaChapList();

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("userList", userList);
		model.addAttribute("qnaTypeList", qnaTypeList);
		model.addAttribute("qnaChapList", qnaChapList);

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
	public String admintest(Model model) {
		List<SubMirCate> categoryList = new ArrayList<SubMirCate>();
		categoryList = adminExamService.getAdminExamCategoryList();

		List<User> userList = new ArrayList<User>();
		userList = adminExamService.getUserListByGrade("ugc1");

		List<QnaBank> questionList = new ArrayList<QnaBank>();
		questionList = adminExamService.getQuestionListAll();

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("userList", userList);
		model.addAttribute("questionList", questionList);

		return "view/admin/exam/admin_exam_question_list";
	}

}
