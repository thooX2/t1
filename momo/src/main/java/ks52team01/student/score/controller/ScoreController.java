package ks52team01.student.score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/score")
@Slf4j
public class ScoreController {

	@GetMapping("/scoreMain")
	public String getScoreMain() {
		return "view/user/score/exam_all_score_summary";
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
