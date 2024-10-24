package ks52team01.student.score.controller;

import java.text.SimpleDateFormat;
import java.util.List;

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
		String userAreaCityCode = user.getAreaCityCode();
		// 출력 날짜 형식 정의
		SimpleDateFormat outputFormat = new SimpleDateFormat("yy.MM.dd");
		// Date 객체를 원하는 형식의 문자열로 변환
		String formattedUserBirthDate = outputFormat.format(user.getUserBirthDate());
		List<TookExamInfo> tookExamList = scoreExamAllService.getTookExamList(userCode);
		String examCode = tookExamList.get(0).getExamCode();
		String korSubCode = tookExamList.get(0).getKorSltSub();
		// 전국, 도, 시별 과목 원점수 평균
		List<Double> regionalAvgList = scoreExamAllService.getRegionalAvgList(tookExamList.get(0));
		log.info("::::::::::::::::: regoin ::::::: {}", regionalAvgList);
		model.addAttribute("regionalAvgList", regionalAvgList);
		String tookExamInfoCode = tookExamList.get(0).getTookExamInfoCode();
		KoreanScore koreanScore = scoreExamAllService.getKoreanScore(userCode, tookExamInfoCode);
		MathScore mathScore = scoreExamAllService.getMathScore(userCode, tookExamInfoCode);
		EnglishScore englishScore = scoreExamAllService.getEnglishScore(userCode, tookExamInfoCode);
		KoreanHistoryScore koreanHistoryScore = scoreExamAllService.getKoreanHistoryScore(userCode, tookExamInfoCode);
		Inquiry1Score inquiry1Score = scoreExamAllService.getInquiry1Score(userCode, tookExamInfoCode);
		Inquiry2Score inquiry2Score = scoreExamAllService.getInquiry2Score(userCode, tookExamInfoCode);
		SecondLanguageAndChineseCharactersScore secondLanguageAndChineseCharactersScore = scoreExamAllService.getSecondLanguageAndChineseCharactersScore(userCode, tookExamInfoCode);
//		log.info("tookExam : {}", tookExamList);
//		log.info("koreanHistoryScore : {}", koreanHistoryScore);
//		log.info("koreanScore : {}", koreanScore);
//		log.info("mathScore : {}", mathScore);
//		log.info("englishScore : {}", englishScore);
//		log.info("inquiry1Score : {}", inquiry1Score);
//		log.info("inquiry2Score : {}", inquiry2Score);
//		log.info("secondLanguageAndChineseCharactersScore : {}", secondLanguageAndChineseCharactersScore);
		ExamScore examScore = new ExamScore();
		examScore.setKoreanScore(koreanScore);
		examScore.setMathScore(mathScore);
		examScore.setEnglishScore(englishScore);
		examScore.setKoreanHistoryScore(koreanHistoryScore);
		examScore.setInquiry1Score(inquiry1Score);
		examScore.setInquiry2Score(inquiry2Score);
		examScore.setSecondLanguageAndChineseCharactersScore(secondLanguageAndChineseCharactersScore);
		model.addAttribute("user", user);
		model.addAttribute("formattedUserBirthDate", formattedUserBirthDate);
		model.addAttribute("tookExamList", tookExamList);
		model.addAttribute("examScore", examScore);
		return "view/user/score/exam_all_score_summary";
	}
	
	@PostMapping("/searchTookExamScore")
	@ResponseBody
	public ExamScore getScoreMain(String tookExamInfoCode, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		String userCode = user.getUserCode();
		KoreanScore koreanScore = scoreExamAllService.getKoreanScore(userCode, tookExamInfoCode);
		MathScore mathScore = scoreExamAllService.getMathScore(userCode, tookExamInfoCode);
		EnglishScore englishScore = scoreExamAllService.getEnglishScore(userCode, tookExamInfoCode);
		KoreanHistoryScore koreanHistoryScore = scoreExamAllService.getKoreanHistoryScore(userCode, tookExamInfoCode);
		Inquiry1Score inquiry1Score = scoreExamAllService.getInquiry1Score(userCode, tookExamInfoCode);
		Inquiry2Score inquiry2Score = scoreExamAllService.getInquiry2Score(userCode, tookExamInfoCode);
		SecondLanguageAndChineseCharactersScore secondLanguageAndChineseCharactersScore = scoreExamAllService.getSecondLanguageAndChineseCharactersScore(userCode, tookExamInfoCode);
		ExamScore examScore = new ExamScore();
		examScore.setKoreanScore(koreanScore);
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
