package ks52team01.student.score.service;

import java.util.List;

import ks52team01.student.score.dto.Test;
import ks52team01.student.score.dto.TookExam;

public interface ScoreExamAllService {
	
	public void getExamAllScoreSummary();
	
	public List<Test> getExamAllOriginalScore();
	
	public List<TookExam> getTookExam();
	
	public void getExamAllStandardScore();
	
	public void getExamAllPercentScore();
	
	public void getExamAllGradeScore();
	
	public void getExamAllRank();
}
