package ks52team01.student.score.service;

import java.util.List;

import ks52team01.student.score.dto.EnglishScore;
import ks52team01.student.score.dto.Inquiry1Score;
import ks52team01.student.score.dto.Inquiry2Score;
import ks52team01.student.score.dto.KoreanHistoryScore;
import ks52team01.student.score.dto.KoreanScore;
import ks52team01.student.score.dto.MathScore;
import ks52team01.student.score.dto.SecondLanguageAndChineseCharactersScore;
import ks52team01.student.score.dto.TookExam;

public interface ScoreExamAllService {
	
	public void getExamAllScoreSummary();
	
	public List<TookExam> getTookExam(String userCode);
	
	public KoreanHistoryScore getKoreanHistoryScore(String userCode);
	
	public KoreanScore getKoreanScore(String userCode);
	
	public MathScore getMathScore(String userCode);
	
	public EnglishScore getEnglishScore(String userCode);
	
	public Inquiry1Score getInquiry1Score(String userCode);
	
	public Inquiry2Score getInquiry2Score(String userCode);
	
	public SecondLanguageAndChineseCharactersScore getSecondLanguageAndChineseCharactersScore(String userCode);
	
	public void getExamAllStandardScore();
	
	public void getExamAllPercentScore();
	
	public void getExamAllGradeScore();
	
	public void getExamAllRank();
}
