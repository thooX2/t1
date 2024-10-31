package ks52team01.student.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.score.dto.EnglishScore;
import ks52team01.student.score.dto.Inquiry1Score;
import ks52team01.student.score.dto.Inquiry2Score;
import ks52team01.student.score.dto.KoreanHistoryScore;
import ks52team01.student.score.dto.MathScore;
import ks52team01.student.score.dto.SecondLanguageAndChineseCharactersScore;
import ks52team01.student.score.dto.Subject;
import ks52team01.student.score.dto.SubjectAvg;

@Mapper
public interface ScoreMapper {
	
	public List<Subject> getSubjectScoreList(String userCode, String tookExamInfoCode);
	
	public Subject getKoreanScore(String userCode, String tookExamInfoCode); // 국어 점수 산출 쿼리
	public SubjectAvg getKoreanScoreNationAvg(String examCode); // 국어 점수 전국 평균 산출 쿼리
	public SubjectAvg getKoreanScoreProvinceAvg(String examCode, String provinceCode); // 국어 점수 도 평균 산출 쿼리
	public SubjectAvg getKoreanScoreMunicipalityAvg(String examCode, String municipalityCode); // 국어 점수 시 평균 산출 쿼리
	
	public Subject getMathScore(String userCode, String tookExamInfoCode); // 수학 점수 산출 쿼리
	public SubjectAvg getMathScoreNationAvg(String examCode); // 수학 점수 전국 평균 산출 쿼리
	public SubjectAvg getMathScoreProvinceAvg(String examCode, String provinceCode); // 수학 점수 도 평균 산출 쿼리
	public SubjectAvg getMathScoreMunicipalityAvg(String examCode, String municipalityCode); // 수학 점수 시 평균 산출 쿼리
	
	public Subject getEnglishScore(String userCode, String tookExamInfoCode); // 영어 점수 산출 쿼리
	public SubjectAvg getEnglishScoreNationAvg(String examCode); // 영어 점수 전국 평균 산출 쿼리
	public SubjectAvg getEnglishScoreProvinceAvg(String examCode, String provinceCode); // 영어 점수 도 평균 산출 쿼리
	public SubjectAvg getEnglishScoreMunicipalityAvg(String examCode, String municipalityCode); // 영어 점수 시 평균 산출 쿼리
	
	public Subject getKoreanHistoryScore(String userCode, String tookExamInfoCode); // 한국사 점수 산출 쿼리
	public SubjectAvg getKoreanHistoryScoreNationAvg(String examCode); // 한국사 점수 전국 평균 산출 쿼리
	public SubjectAvg getKoreanHistoryScoreProvinceAvg(String examCode, String provinceCode); // 한국사 점수 도 평균 산출 쿼리
	public SubjectAvg getKoreanHistoryScoreMunicipalityAvg(String examCode, String municipalityCode); // 한국사 점수 시 평균 산출 쿼리
	
	public Subject getInquiry1Score(String userCode, String tookExamInfoCode); // 탐구1 점수 산출 쿼리
	public SubjectAvg getInquiry1ScoreNationAvg(String examCode); // 탐구1 점수 전국 평균 산출 쿼리
	public SubjectAvg getInquiry1ScoreProvinceAvg(String examCode, String provinceCode); // 탐구1 점수 도 평균 산출 쿼리
	public SubjectAvg getInquiry1ScoreMunicipalityAvg(String examCode, String municipalityCode); // 탐구1 점수 시 평균 산출 쿼리
	
	public Subject getInquiry2Score(String userCode, String tookExamInfoCode); // 탐구2 점수 산출 쿼리
	public SubjectAvg getInquiry2ScoreNationAvg(String examCode); // 탐구2 점수 전국 평균 산출 쿼리
	public SubjectAvg getInquiry2ScoreProvinceAvg(String examCode, String provinceCode); // 탐구2 점수 도 평균 산출 쿼리
	public SubjectAvg getInquiry2ScoreMunicipalityAvg(String examCode, String municipalityCode); // 탐구2 점수 시 평균 산출 쿼리
	
	public Subject getSecondLanguageAndChineseCharactersScore(String userCode, String tookExamInfoCode); // 제2외국어 및 한문 점수 산출 쿼리
	public SubjectAvg getSecondLanguageAndChineseCharactersScoreNationAvg(String examCode); // 제2외국어 및 한문 점수 전국 평균 산출 쿼리
	public SubjectAvg getSecondLanguageAndChineseCharactersScoreProvinceAvg(String examCode, String provinceCode); // 제2외국어 및 한문 점수 도 평균 산출 쿼리
	public SubjectAvg getSecondLanguageAndChineseCharactersScoreMunicipalityAvg(String examCode, String municipalityCode); // 제2외국어 및 한문 점수 시 평균 산출 쿼리
}
