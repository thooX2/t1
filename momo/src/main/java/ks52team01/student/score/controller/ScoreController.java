package ks52team01.student.score.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks52team01.student.exam.dto.TookExamInfo;
import ks52team01.student.score.dto.EnglishScore;
import ks52team01.student.score.dto.ExamScore;
import ks52team01.student.score.dto.Inquiry1Score;
import ks52team01.student.score.dto.Inquiry2Score;
import ks52team01.student.score.dto.KoreanHistoryScore;
import ks52team01.student.score.dto.KoreanScore;
import ks52team01.student.score.dto.MathScore;
import ks52team01.student.score.dto.SecondLanguageAndChineseCharactersScore;
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
		User user = (User) session.getAttribute("loggedInUser");
		String userCode = user.getUserCode();
		List<TookExamInfo> firstTookExamList = scoreExamAllService.getFirstTookExamList(userCode);
		/*
		 * 그래프 영역 
		 * 전국/도/시 과목 원점수/표준점수/백분위/등급/석차 평균
		 */
		String tookExamInfoCode = firstTookExamList.get(0).getTookExamInfoCode();
		String examCode = firstTookExamList.get(0).getExamCode();
		String areaCityCode = firstTookExamList.get(0).getAreaCityCode();
		Map<String, Object> map;
		List<Subject> subjectScoreAvgList = scoreExamAllService.getSubjectScoreAvgList();
		List<Subject> subjectScoreList = scoreExamAllService.getSubjectScoreList(userCode, tookExamInfoCode, examCode, areaCityCode);
		for(int i=0; i<subjectScoreList.size(); i++) {
			String curSubjectMajorCategoryCode = subjectScoreList.get(i).getSubjectMajorCategoryCode();
			switch(curSubjectMajorCategoryCode) {
				case "smjrcc1" : // 대분류 국어 과목
					subjectScoreList.get(i);
					break;
				case "smjrcc2" : // 대분류 수학 과목
					subjectScoreList.get(i);
					break;
				case "smjrcc3" : // 대분류 영어 과목
					subjectScoreList.get(i);
					break;
				case "smjrcc4" : // 대분류 한국사 과목
					subjectScoreList.get(i);
					break;
				case "smjrcc5" : // 대분류 사회탐구 과목
					subjectScoreList.get(i);
					break;
				case "smjrcc6" : // 대분류 과학탐구 과목
					subjectScoreList.get(i);
					break;
				case "smjrcc7" : // 대분류 직업탐구 과목
					subjectScoreList.get(i);
					break;
				case "smjrcc8" : // 대분류 제2외국어 및 한문 과목
					subjectScoreList.get(i);
					break;
				default :
					break;
			}
		}
		// 출력 날짜 형식 정의
		SimpleDateFormat outputFormat = new SimpleDateFormat("yy.MM.dd");
		// Date 객체를 원하는 형식의 문자열로 변환
		String formattedUserBirthDate = outputFormat.format(user.getUserBirthDate());
		
		log.info("subjectScoreList : {}", subjectScoreList);
		
		model.addAttribute("user", user);
		model.addAttribute("tookExamList", firstTookExamList);
		model.addAttribute("subjectScoreList", subjectScoreList);
		model.addAttribute("formattedUserBirthDate", formattedUserBirthDate);
		return "view/user/score/exam_all_score_summary";
	}
	
	@PostMapping("/searchTookExamScore")
	@ResponseBody
	public ExamScore getScoreMain(String tookExamInfoCode, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		String userCode = user.getUserCode();
		Subject koreanScore = scoreExamAllService.getKoreanScore(userCode, tookExamInfoCode);
		MathScore mathScore = scoreExamAllService.getMathScore(userCode, tookExamInfoCode);
		EnglishScore englishScore = scoreExamAllService.getEnglishScore(userCode, tookExamInfoCode);
		KoreanHistoryScore koreanHistoryScore = scoreExamAllService.getKoreanHistoryScore(userCode, tookExamInfoCode);
		Inquiry1Score inquiry1Score = scoreExamAllService.getInquiry1Score(userCode, tookExamInfoCode);
		Inquiry2Score inquiry2Score = scoreExamAllService.getInquiry2Score(userCode, tookExamInfoCode);
		SecondLanguageAndChineseCharactersScore secondLanguageAndChineseCharactersScore = scoreExamAllService.getSecondLanguageAndChineseCharactersScore(userCode, tookExamInfoCode);
		ExamScore examScore = new ExamScore();
		// examScore.setKoreanScore(koreanScore);
		examScore.setMathScore(mathScore);
		examScore.setEnglishScore(englishScore);
		examScore.setKoreanHistoryScore(koreanHistoryScore);
		examScore.setInquiry1Score(inquiry1Score);
		examScore.setInquiry2Score(inquiry2Score);
		examScore.setSecondLanguageAndChineseCharactersScore(secondLanguageAndChineseCharactersScore);
		return examScore;
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
