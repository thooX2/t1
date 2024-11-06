package ks52team01.student.exam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks52team01.student.exam.dto.ExamAnalyse;
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

	// AJAX 요청을 처리하는 메서드
    @GetMapping("/userExamData")
    @ResponseBody
    public List<ExamAnalyse> getUserExamData(@RequestParam String userCode, @RequestParam String majorCode) {
        log.info("사용자 {}의 {}에 대한 시험 데이터 요청", userCode, majorCode);
        
        List<ExamAnalyse> scores = examService.getUserExamData(userCode, majorCode);
        log.info("test:{}",scores);
        return scores; // 데이터 반환
    }
	
	@GetMapping("/examList")
	public String moveExamList() {
		log.info("모의고사 메인으로 이동");
		return "view/user/exam/user_exam_list";
	}


	@GetMapping("/examMain")
	public String moveExamMain() {
		log.info("모의고사 메인으로 이동");
		return "view/user/exam/user_exam_list";
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
