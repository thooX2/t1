package ks52team01.student.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks52team01.common.files.dto.QnaImg;
import ks52team01.common.files.service.FileService;
import ks52team01.student.exam.dto.ExamAnalyse;
import ks52team01.student.exam.dto.ExamInfo;
import ks52team01.student.exam.dto.ExamMappingQuestion;
import ks52team01.student.exam.dto.QnaBank;
import ks52team01.student.exam.service.ExamService;
import ks52team01.student.user.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/exam")
public class ExamController {

	private final ExamService examService;
	private final FileService fileService;

	@PostMapping("/{examCode}/solutions")
	public String userExamSolution(@PathVariable(name = "examCode") String examCode,
			@RequestParam(name = "userAnswer") List<String> userAnswer,
			@RequestParam(name = "examAnswer") List<String> examAnswer,
			@RequestParam(name = "currentSubject") String currentSubject,
			@RequestParam(name = "currentSubjectName") String currentSubjectName,
			@RequestParam(name = "subMjrCateCode") String subMjrCateCode,
			@RequestParam(name = "subject", required = false) List<String> subject,
			@RequestParam(name = "qnaCode") List<String> qnaCode, Model model, HttpSession session) {

		// currentSubject는 국어/수학/영어/한국사를 제외한 과목을 선택할수 있는 과목은 과목중분류를
		// 국어/수학/영어/한국사는 과목대분류를 반환한다

		// 그래서 유저정답을 저장할 메서드에 필요한 선택한 모든과목의 대분류를 subMirCateCode로 반환
		// subject는 exam_take_main에서 선택한 과목의 list이다.(현재 시험본 과목제외)

		User loginUser = null; // 인터셉터 활성화시 이부분의 if를 지워도 무방
		if (session.getAttribute("loggedInUser") != null) {
			loginUser = (User) session.getAttribute("loggedInUser");
			String userCode = loginUser.getUserCode();
			examService.registerResultToSubjectTable(userCode, examCode, subMjrCateCode, qnaCode, userAnswer);
		}

		List<QnaBank> questionInfoList = examService.getQuestionInfoListByExamCode(examCode, currentSubject);
		List<QnaImg> qnaImgList = new ArrayList<QnaImg>();
		qnaImgList = fileService.getQnaImgListByExamCode(currentSubject);

		model.addAttribute("questionInfoList", questionInfoList);
		model.addAttribute("userAnswer", userAnswer);
		model.addAttribute("examAnswer", examAnswer);
		// 이게 아래(getQuestionInfoListByExamCode)의 examName임
		model.addAttribute("examName", currentSubjectName);
		model.addAttribute("subject", subject);
		model.addAttribute("examCode", examCode);
		model.addAttribute("qnaImgList", qnaImgList);
		log.info("모의고사 해설화면으로 이동");

		return "view/user/exam/user_exam_solution";
	}

	@GetMapping("/{examCode}/examination")
	public String getQuestionInfoListByExamCode(@PathVariable(name = "examCode") String examCode,
			@RequestParam(name = "subject", required = false) List<String> subject,
			@RequestParam(name = "examName") String examName, Model model) {
		String pathString = "redirect:/exam/examList";

		String currentSubject = "";
		if (subject != null) {
			// 첫 번째 요소를 반환하고 제거
			currentSubject = subject.remove(0);

			List<QnaBank> questionInfoList = examService.getQuestionInfoListByExamCode(examCode, currentSubject);
			List<QnaImg> qnaImgList = new ArrayList<QnaImg>();
			qnaImgList = fileService.getQnaImgListByExamCode(currentSubject);

			model.addAttribute("examCode", examCode);
			model.addAttribute("examName", examName);
			model.addAttribute("subject", subject);
			// 해설페이지에서 해설을 가져오기 위해 전달
			model.addAttribute("currentSubject", currentSubject);
			model.addAttribute("questionInfoList", questionInfoList);
			model.addAttribute("qnaImgList", qnaImgList);

			pathString = "view/user/exam/user_exam_take";
		} else {
			pathString = "view/user/exam/user_exam_take_done";
		}

		return pathString;
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
