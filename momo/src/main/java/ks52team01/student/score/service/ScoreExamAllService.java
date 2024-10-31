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
import ks52team01.student.score.dto.Subject;

public interface ScoreExamAllService {
	
	public void getExamAllScoreSummary();
	
	public List<TookExamInfo> getFirstTookExamList(String userCode);
	
	public List<Subject> getSubjectScoreList(String userCode, String tookExamInfoCode, String examCode, String areaCityCode);
	
	public List<Subject> getSubjectScoreAvgList();
	
	public Subject getKoreanHistoryScore(String userCode, String tookExamInfoCode);
	
	public Subject getKoreanScore(String userCode, String tookExamInfoCode);
	
	public Subject getMathScore(String userCode, String tookExamInfoCode);
	
	public Subject getEnglishScore(String userCode, String tookExamInfoCode);
	
	public Subject getInquiry1Score(String userCode, String tookExamInfoCode);
	
	public Subject getInquiry2Score(String userCode, String tookExamInfoCode);
	
	public Subject getSecondLanguageAndChineseCharactersScore(String userCode, String tookExamInfoCode);
	
	public void getExamAllStandardScore();
	
	public void getExamAllPercentScore();
	
	public void getExamAllGradeScore();
	
	public void getExamAllRank();
}
