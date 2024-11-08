package ks52team01.student.exam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks52team01.student.exam.dto.ExamAnalyse;
import ks52team01.student.exam.dto.ExamInfo;
import ks52team01.student.exam.dto.ExamMappingQuestion;
import ks52team01.student.exam.service.ExamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/exam")
public class ExamController {

	private final ExamService examService;

	@GetMapping("/{examCode}/examination")
	public String getExamListByExamCode(@PathVariable(name = "examCode") String examCode) {

		return "view/user/exam/user_exam_take";
	}

	@GetMapping("/searchExam")
	@ResponseBody
	public List<ExamInfo> getSearchExamList(ExamInfo examInfo) {
		List<ExamInfo> searchExamList = examService.getSearchExamList(examInfo);
		return searchExamList;
	}

	@GetMapping("/{examCode}/details")
	public String getExamDetails(@PathVariable(name = "examCode") String examCode,
			@RequestParam(name = "examName") String examName, Model model) {

		// 시험에 등록한 문제정보 가져오기
		List<ExamMappingQuestion> examQuestionInfo = examService.getExamQuestionInfobyExamCode(examCode);

		// 시험에 관한 정보 가져오기
		ExamInfo examInfo = examService.getExamInfoByExamCode(examCode);

		model.addAttribute("examName", examName);
		model.addAttribute("examQuestionInfo", examQuestionInfo);
		model.addAttribute("examInfo", examInfo);
		return "view/user/exam/user_exam_info_popup";
	}

	// AJAX 요청을 처리하는 메서드
	@GetMapping("/userExamData")
	@ResponseBody
	public List<ExamAnalyse> getUserExamData(@RequestParam String userCode, @RequestParam String majorCode) {

		List<ExamAnalyse> scores = examService.getUserExamData(userCode, majorCode);
		log.info("성적 분석 - 분석1)성적변화 로 이동");
		return scores; // 데이터 반환
	}

	@GetMapping("/examList")
	public String moveExamList(Model model) {
		log.info("모의고사 메인으로 이동");
		List<ExamInfo> examList = examService.getRegisteredQustionExamList();

		model.addAttribute("examList", examList);
		return "view/user/exam/user_exam_list";
	}

	/*
	 * @GetMapping("/examMain") public String moveExamMain() {
	 * log.info("모의고사 메인으로 이동"); return "view/user/exam/user_exam_list"; }
	 */

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
	public String userExamTake(@RequestParam(name = "examCode") String examCode, Model model) {

		ExamInfo examInfo = examService.getExamInfoByExamCode(examCode);

		// 시험에 등록한 문제정보 가져오기
		List<ExamMappingQuestion> examQuestionInfo = examService.getExamQuestionInfobyExamCode(examCode);
		log.info("모의고사 응시로 이동");

		model.addAttribute("examInfo", examInfo);
		model.addAttribute("examQuestionInfo", examQuestionInfo);
		return "view/user/exam/user_exam_take_main";
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
