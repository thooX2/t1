package ks52team01.student.score.service;

import java.util.List;

import ks52team01.student.exam.dto.TookExamInfo;
import ks52team01.student.score.dto.EnglishScore;
import ks52team01.student.score.dto.Inquiry1Score;
import ks52team01.student.score.dto.Inquiry2Score;
import ks52team01.student.score.dto.KoreanHistoryScore;
import ks52team01.student.score.dto.KoreanScore;
import ks52team01.student.score.dto.MathScore;
import ks52team01.student.score.dto.SecondLanguageAndChineseCharactersScore;

public interface ScoreExamAllService {
	
	public void getExamAllScoreSummary();
	
	public List<Double> getRegionalAvgList(TookExamInfo tookExamInfo);
	
	public List<TookExamInfo> getTookExamList(String userCode);
	
	public KoreanHistoryScore getKoreanHistoryScore(String userCode, String tookExamInfoCode);
	
	public KoreanScore getKoreanScore(String userCode, String tookExamInfoCode);
	
	public MathScore getMathScore(String userCode, String tookExamInfoCode);
	
	public EnglishScore getEnglishScore(String userCode, String tookExamInfoCode);
	
	public Inquiry1Score getInquiry1Score(String userCode, String tookExamInfoCode);
	
	public Inquiry2Score getInquiry2Score(String userCode, String tookExamInfoCode);
	
	public SecondLanguageAndChineseCharactersScore getSecondLanguageAndChineseCharactersScore(String userCode, String tookExamInfoCode);
	
	public void getExamAllStandardScore();
	
	public void getExamAllPercentScore();
	
	public void getExamAllGradeScore();
	
	public void getExamAllRank();
}
