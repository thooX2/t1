package ks52team01.student.score.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks52team01.student.exam.dto.TookExamInfo;
import ks52team01.student.score.dto.Subject;
import ks52team01.student.score.service.ScoreExamAllService;
import ks52team01.student.user.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/score")
@Slf4j
public class ScoreController {

	private final ScoreExamAllService scoreExamAllService;

	@GetMapping("/scoreMain")
	public String getScoreMain(Model model, HttpSession session) {
		// 세션에 저장된 회원 정보
		User user = (User) session.getAttribute("loggedInUser");
		
		// 최초로 응시한 모의고사 목록 조회
		String userCode = user.getUserCode();
		List<TookExamInfo> firstTookExamList = scoreExamAllService.getFirstTookExamList(userCode);
		
		// 현재 모의고사 점수 조회
		TookExamInfo curTookExam = firstTookExamList.get(0);
		String areaCityCode = curTookExam.getAreaCityCode();
		String examCode = curTookExam.getExamCode();
		String tookExamInfoCode = curTookExam.getTookExamInfoCode();
		Map<String, Subject> subjectScoreMap = scoreExamAllService.getTookExamScore(userCode, areaCityCode, examCode, tookExamInfoCode);
		
		Date userBirthDate = user.getUserBirthDate();
		String formattedUserBirthDate = new SimpleDateFormat("yy.MM.dd").format(userBirthDate);
		
		log.info("subjectScoreMap : {}", subjectScoreMap);
		
		model.addAttribute("user", user);
		model.addAttribute("tookExamList", firstTookExamList);
		model.addAttribute("subjectScoreMap", subjectScoreMap);
		model.addAttribute("formattedUserBirthDate", formattedUserBirthDate);
		return "view/user/score/exam_all_score_summary";
	}
	
	@PostMapping("/searchTookExamScore")
	@ResponseBody
	public Map<String, Subject> getScoreMain(@RequestBody TookExamInfo tookExamInfo, HttpSession session) {
		// 세션에 저장된 회원 정보
		User user = (User) session.getAttribute("loggedInUser");
		String userCode = user.getUserCode();
		
		log.info("+++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++");
		log.info("tookExamInfo : {}", tookExamInfo);
		log.info("+++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++ +++++");
		
		String areaCityCode = tookExamInfo.getAreaCityCode();
		String examCode = tookExamInfo.getExamCode();
		String tookExamInfoCode = tookExamInfo.getTookExamInfoCode();
		return scoreExamAllService.getTookExamScore(userCode, areaCityCode, examCode, tookExamInfoCode);
	}

	@GetMapping("/examAllScoreSummary")
	public String getExamAllScoreSummary() {
		return "view/user/score/exam_all_score_summary";
	}

	@GetMapping("/examAllOriginalScore")
	public String getExamAllOriginalScore() {
		return "view/user/score/exam_all_original_score";
	}

	@GetMapping("/examAllStandardScore")
	public String getExamAllStandardScore() {
		return "view/user/score/exam_all_standard_score";
	}

	@GetMapping("/examAllPercentScore")
	public String getExamAllPercentScore() {
		return "view/user/score/exam_all_percent_score";
	}

	@GetMapping("/examAllGradeScore")
	public String getExamAllGradeScore() {
		return "view/user/score/exam_all_grade_score";
	}

	@GetMapping("/examAllRank")
	public String getExamAllRank() {
		return "view/user/score/exam_all_rank";
	}

	@GetMapping("/examSubjectScoreSummary")
	public String getExamSubjectScoreSummary() {
		return "view/user/score/exam_subject_score_summary";
	}

	@GetMapping("/examSubjectOriginalScore")
	public String getExamSubjectOriginalScore() {
		return "view/user/score/exam_subject_original_score";
	}

	@GetMapping("/examSubjectStandardScore")
	public String getExamSubjectStandardScore() {
		return "view/user/score/exam_subject_standard_score";
	}

	@GetMapping("/examSubjectPercentScore")
	public String getExamSubjectPercentScore() {
		return "view/user/score/exam_subject_percent_score";
	}

	@GetMapping("/examSubjectGradeScore")
	public String getExamSubjectGradeScore() {
		return "view/user/score/exam_subject_grade_score";
	}

	@GetMapping("/examSubjectRank")
	public String getExamSubjectRank() {
		return "view/user/score/exam_subject_rank";
	}

	@GetMapping("/examSubjectChapterTypeCorrectIncoreectAnalysis")
	public String getExamSubjectChapterTypeCorrectIncorrectAnalysis() {
		return "view/user/score/exam_subject_chapter_type_correct_incorrect_analysis";
	}

	@GetMapping("/examAllScoreList")
	public String getExamAllScoreList() {
		return "view/user/score/exam_all_score_list";
	}

	@GetMapping("/examAllScoreCreate")
	public String moveExamAllScoreCreate() {
		return "view/user/score/exam_all_score_create";
	}

	public void addExamAllScoreCreate() {

	}

	@GetMapping("/examAllScoreUpdate")
	public String moveExamAllScoreUpdate() {
		return "view/user/score/exam_all_score_update";
	}

	public void modifyExamAllScoreUpdate() {

	}

	@GetMapping("/examAllScoreDelete")
	public String moveExamAllScoreDelete() {
		return "view/user/score/exam_all_score_delete";
	}

	public void removeExamAllScoreDelete() {

	}

	@GetMapping("/examAllScoreSelect")
	public String getExamAllScoreSelect() {
		return "view/user/score/exam_all_score_select";
	}

	@GetMapping("/examSubjectScoreCreate")
	public String moveExamSubjectScoreCreate() {
		return "view/user/score/exam_subject_score_create";
	}

	public void addExamSubjectScoreCreate() {

	}

	@GetMapping("/examSubjectScoreUpdate")
	public String moveExamSubjectScoreUpdate() {
		return "view/user/score/exam_subject_score_update";
	}

	public void modifyExamSubjectScoreUpdate() {

	}

	@GetMapping("/examSubjectScoreDelete")
	public String moveExamSubjectScoreDelete() {
		return "view/user/score/exam_subject_score_delete";
	}

	public void removeExamSubjectScoreDelete() {

	}

	@GetMapping("/examSubjectScoreSelect")
	public String getExamSubjectScoreSelect() {
		return "view/user/score/exam_subject_score_select";
	}
}
