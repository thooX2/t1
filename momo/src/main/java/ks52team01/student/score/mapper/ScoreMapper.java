package ks52team01.student.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.exam.dto.TookExamInfo;
import ks52team01.student.score.dto.EnglishScore;
import ks52team01.student.score.dto.Inquiry1Score;
import ks52team01.student.score.dto.Inquiry2Score;
import ks52team01.student.score.dto.KoreanHistoryScore;
import ks52team01.student.score.dto.KoreanScore;
import ks52team01.student.score.dto.MathScore;
import ks52team01.student.score.dto.SecondLanguageAndChineseCharactersScore;

@Mapper
public interface ScoreMapper {

	public void getScoreMain();
	
	public Double getNationAvg(String examCode, String korSubCode);
	
	public Double getProvinceAvg(String examCode, String korSubCode, String provinceCode);
	
	public Double getMunicipalityAvg(String examCode, String korSubCode, String municipalityCode);
	
	public KoreanHistoryScore getKoreanHistoryScore(String userCode, String tookExamInfoCode);
	
	public KoreanScore getKoreanScore(String userCode, String tookExamInfoCode);
	
	public MathScore getMathScore(String userCode, String tookExamInfoCode);
	
	public EnglishScore getEnglishScore(String userCode, String tookExamInfoCode);
	
	public Inquiry1Score getInquiry1Score(String userCode, String tookExamInfoCode);
	
	public Inquiry2Score getInquiry2Score(String userCode, String tookExamInfoCode);
	
	public SecondLanguageAndChineseCharactersScore getSecondLanguageAndChineseCharactersScore(String userCode, String tookExamInfoCode);
}
