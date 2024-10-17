package ks52team01.student.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.score.dto.EnglishScore;
import ks52team01.student.score.dto.Inquiry1Score;
import ks52team01.student.score.dto.Inquiry2Score;
import ks52team01.student.score.dto.KoreanHistoryScore;
import ks52team01.student.score.dto.KoreanScore;
import ks52team01.student.score.dto.MathScore;
import ks52team01.student.score.dto.SecondLanguageAndChineseCharactersScore;
import ks52team01.student.score.dto.TookExam;

@Mapper
public interface ScoreMapper {

	public void getScoreMain();
	
	public List<TookExam> getTookExam(String userCode);
	
	public KoreanHistoryScore getKoreanHistoryScore(String userCode);
	
	public KoreanScore getKoreanScore(String userCode);
	
	public MathScore getMathScore(String userCode);
	
	public EnglishScore getEnglishScore(String userCode);
	
	public Inquiry1Score getInquiry1Score(String userCode);
	
	public Inquiry2Score getInquiry2Score(String userCode);
	
	public SecondLanguageAndChineseCharactersScore getSecondLanguageAndChineseCharactersScore(String userCode);
}
