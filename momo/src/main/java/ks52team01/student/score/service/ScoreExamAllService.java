package ks52team01.student.score.service;

import java.util.List;

import ks52team01.student.score.dto.Test;

public interface ScoreExamAllService {
	
	public void getExamAllScoreSummary();
	
	public List<Test> getExamAllOriginalScore();
	
	public void getExamAllStandardScore();
	
	public void getExamAllPercentScore();
	
	public void getExamAllGradeScore();
	
	public void getExamAllRank();
}
