package ks52team01.student.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks52team01.student.exam.service.ExamService;
import ks52team01.student.exam.service.ExamServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/exam")
public class ExamController {

	private final ExamService examService;

	public ExamController(ExamServiceImpl examServiceImpl) {
		this.examService = examServiceImpl;
	}

	@GetMapping("/test6")
	public String admintest6() {
		return "view/admin/exam/admin_exam_management";
	}

	@GetMapping("/test5")
	public String admintest5() {
		return "view/admin/exam/admin_exam_add_question";
	}

	@GetMapping("/test4")
	public String admintest4() {
		return "view/admin/exam/admin_exam_question_popup";
	}

	@GetMapping("/test3")
	public String admintest3() {
		return "view/admin/exam/admin_exam_management_list";
	}

	@GetMapping("/test2")
	public String admintest2() {
		return "view/admin/exam/admin_exam_category";
	}

	@GetMapping("/test1")
	public String admintest() {
		return "view/admin/exam/admin_exam_question_list";
	}

	@GetMapping("/examMain")
	public String moveExamMain() {
		log.info("모의고사 메인으로 이동");
		return "view/user/exam/exam_main";
	}

	@GetMapping("/userExamCreate")
	public String moveExamCreate() {
		log.info("모의고사 생성으로 이동");
		return "view/user/exam/user_exam_create";
	}

	@GetMapping("/userExamResultList")
	public String userExamResultList() {
		log.info("모의고사 응시 목록으로 이동");
		return "view/user/exam/user_exam_took_list";
	}

	@GetMapping("/userExamAnalyzePopup")
	public String userExamAnalyzePopup() {
		log.info("모의고사 결과분석 팝업으로 이동");
		return "view/user/exam/user_exam_analyze_popup";
	}

	@GetMapping("/userExamTake")
	public String userExamTake() {

		log.info("모의고사 응시로 이동");
		return "view/user/exam/user_exam_take";
	}

	@GetMapping("/userExamAnalyse")
	public String userExamAnalyse() {
		log.info("모의고사 결과분석으로 이동");
		return "view/user/exam/user_exam_analyse";
	}

	@PostMapping("/userExamSolution")
	public String userExamSolution(@RequestParam String userAnswer, @RequestParam String examAnswer, Model model) {

		model.addAttribute("userAnswer", userAnswer);
		model.addAttribute("examAnswer", examAnswer);

		log.info("모의고사 해설화면으로 이동");

		return "view/user/exam/user_exam_solution";
	}

	@GetMapping("/ccr")
	public String userExamAnalyseCcr() {
		log.info("단원별정답률분석페이지로 이동");
		return "view/user/exam/user_exam_analyse_ccr";
	}

	@GetMapping("/weak")
	public String userExamAnalyseWeak() {
		log.info("취약파트로 이동");
		return "view/user/exam/user_exam_analyse_weak_type";
	}

	@GetMapping("/chap")
	public String userExamAnalyseChap() {
		log.info("취약단원파트로 이동");
		return "view/user/exam/user_exam_analyse_chap";
	}
}
