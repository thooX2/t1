package ks52team01.student.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks52team01.student.exam.service.ExamService;
import ks52team01.student.exam.service.ExamServiceImpl;

@Controller
public class ExamController {

	private final ExamService examService;

	public ExamController(ExamServiceImpl examServiceImpl) {
		this.examService = examServiceImpl;
	}

	@GetMapping("/exam/examMain")
	public String moveExamMain() {
		System.out.println("모의고사 메인으로 이동");
		return "view/user/exam/exam_main";
	}

	@GetMapping("/exam/userExamCreate")
	public String moveExamCreate() {
		System.out.println("모의고사 생성으로 이동");
		return "view/user/exam/user_exam_create";
	}

	@GetMapping("/exam/userExamResultList")
	public String userExamResultList() {
		System.out.println("모의고사 응시 목록으로 이동");
		return "view/user/exam/user_exam_took_list";
	}

	@GetMapping("/exam/userExamAnalyzePopup")
	public String userExamAnalyzePopup() {
		System.out.println("모의고사 결과분석 팝업으로 이동");
		return "view/user/exam/user_exam_analyze_popup";
	}

	@GetMapping("/exam/userExamTake")
	public String userExamTake() {
		System.out.println("모의고사 응시로 이동");
		return "view/user/exam/user_exam_take";
	}

	@GetMapping("/exam/userExamAnalyse")
	public String userExamAnalyse() {
		System.out.println("모의고사 결과분석으로 이동");
		return "view/user/exam/user_exam_analyse";
	}

	@PostMapping("/exam/userExamSolution")
	public String userExamSolution(@RequestParam String userAnswer, @RequestParam String examAnswer, Model model) {

		model.addAttribute("userAnswer", userAnswer);
		model.addAttribute("examAnswer", examAnswer);

		System.out.println("모의고사 해설화면으로 이동");

		return "view/user/exam/user_exam_solution";
	}

	@GetMapping("/exam/ccr")
	public String userExamAnalyseCcr() {
		System.out.println("단원별정답률분석페이지로 이동");
		return "view/user/exam/user_exam_analyse_ccr";
	}

	@GetMapping("/exam/weak")
	public String userExamAnalyseWeak() {
		System.out.println("취약파트로 이동");
		return "view/user/exam/user_exam_analyse_weak_type";
	}

	@GetMapping("/exam/chap")
	public String userExamAnalyseChap() {
		System.out.println("취약단원파트로 이동");
		return "view/user/exam/user_exam_analyse_chap";
	}
}
