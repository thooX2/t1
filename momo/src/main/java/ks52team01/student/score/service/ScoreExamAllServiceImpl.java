package ks52team01.student.score.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ks52team01.student.exam.dto.TookExamInfo;
import ks52team01.student.exam.mapper.ExamMapper;
import ks52team01.student.score.dto.Subject;
import ks52team01.student.score.dto.SubjectAvg;
import ks52team01.student.score.mapper.ScoreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScoreExamAllServiceImpl implements ScoreExamAllService {

	private final ExamMapper examMapper;
	private final ScoreMapper scoreMapper;

	@Override
	public List<TookExamInfo> getTookExamList(String userCode) {
		// TODO Auto-generated method stub
		return examMapper.getTookExamList(userCode);
	}
	
	@Override
	public List<TookExamInfo> getFirstTookExamList(String userCode) {
		// TODO Auto-generated method stub
		return examMapper.getFirstTookExamList(userCode);
	}

	@Override
	public Map<String, Subject> getTookExamScore(String userCode, String areaCityCode, String examCode, String tookExamInfoCode) {
		// TODO Auto-generated method stub
		
		Map<String, Subject> subjectMap = new LinkedHashMap<String, Subject>();
		
		String provinceCode = areaCityCode.substring(0, 2);
		String municipalityCode = areaCityCode.substring(0, 4);
		System.out.println(provinceCode);
		System.out.println(municipalityCode);

		// 국어 과목 점수 산출
		Subject koreanScore = scoreMapper.getKoreanScore(userCode, tookExamInfoCode);
		
		if(koreanScore != null) {
			// 국어 과목 점수 평균 산출
			SubjectAvg koreanScoreNationAvg = scoreMapper.getKoreanScoreNationAvg(examCode);
			SubjectAvg koreanScoreProvinceAvg;
			SubjectAvg koreanScoreMunicipalityAvg;
			koreanScore.setSubjectOriginalScoreNationAvg(koreanScoreNationAvg.getSubjectOriginalScoreNationAvg());
			koreanScore.setSubjectStandardScoreNationAvg(koreanScoreNationAvg.getSubjectStandardScoreNationAvg());
			koreanScore.setSubjectPercentNationAvg(koreanScoreNationAvg.getSubjectPercentNationAvg());
			koreanScore.setSubjectGradeNationAvg(koreanScoreNationAvg.getSubjectGradeNationAvg());
			koreanScore.setSubjectRankNationAvg(koreanScoreNationAvg.getSubjectRankNationAvg());
			if(provinceCode.equals("11") || provinceCode.equals("26") || provinceCode.equals("27") || provinceCode.equals("28") ||
			   provinceCode.equals("29") || provinceCode.equals("30") || provinceCode.equals("31") || provinceCode.equals("36")) {
				koreanScoreProvinceAvg = null;
				koreanScoreMunicipalityAvg = scoreMapper.getKoreanScoreProvinceAvg(examCode, provinceCode);
				koreanScore.setSubjectOriginalScoreMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectOriginalScoreProvinceAvg());
				koreanScore.setSubjectStandardScoreMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectStandardScoreProvinceAvg());
				koreanScore.setSubjectPercentMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectPercentProvinceAvg());
				koreanScore.setSubjectGradeMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectGradeProvinceAvg());
				koreanScore.setSubjectRankMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectRankProvinceAvg());
			}
			else {
				koreanScoreProvinceAvg = scoreMapper.getKoreanScoreProvinceAvg(examCode, provinceCode);
				koreanScoreMunicipalityAvg = scoreMapper.getKoreanScoreMunicipalityAvg(examCode, municipalityCode);
				koreanScore.setSubjectOriginalScoreProvinceAvg(koreanScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
				koreanScore.setSubjectStandardScoreProvinceAvg(koreanScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
				koreanScore.setSubjectPercentProvinceAvg(koreanScoreProvinceAvg.getSubjectPercentProvinceAvg());
				koreanScore.setSubjectGradeProvinceAvg(koreanScoreProvinceAvg.getSubjectGradeProvinceAvg());
				koreanScore.setSubjectRankProvinceAvg(koreanScoreProvinceAvg.getSubjectRankProvinceAvg());
				koreanScore.setSubjectOriginalScoreMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
				koreanScore.setSubjectStandardScoreMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
				koreanScore.setSubjectPercentMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
				koreanScore.setSubjectGradeMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
				koreanScore.setSubjectRankMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			}
			System.out.println(koreanScore);
		}
		subjectMap.put("koreanScore", koreanScore);

		// 수학 과목 점수 산출
		Subject mathScore = scoreMapper.getMathScore(userCode, tookExamInfoCode);

		if(mathScore != null) {
			// 수학 과목 점수 평균 산출
			SubjectAvg mathScoreNationAvg = scoreMapper.getMathScoreNationAvg(examCode);
			SubjectAvg mathScoreProvinceAvg;
			SubjectAvg mathScoreMunicipalityAvg;
			mathScore.setSubjectOriginalScoreNationAvg(mathScoreNationAvg.getSubjectOriginalScoreNationAvg());
			mathScore.setSubjectStandardScoreNationAvg(mathScoreNationAvg.getSubjectStandardScoreNationAvg());
			mathScore.setSubjectPercentNationAvg(mathScoreNationAvg.getSubjectPercentNationAvg());
			mathScore.setSubjectGradeNationAvg(mathScoreNationAvg.getSubjectGradeNationAvg());
			mathScore.setSubjectRankNationAvg(mathScoreNationAvg.getSubjectRankNationAvg());
			if(provinceCode.equals("11") || provinceCode.equals("26") || provinceCode.equals("27") || provinceCode.equals("28") ||
			   provinceCode.equals("29") || provinceCode.equals("30") || provinceCode.equals("31") || provinceCode.equals("36")) {
				mathScoreProvinceAvg = null;
				mathScoreMunicipalityAvg = scoreMapper.getMathScoreProvinceAvg(examCode, provinceCode);
				mathScore.setSubjectOriginalScoreMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectOriginalScoreProvinceAvg());
				mathScore.setSubjectStandardScoreMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectStandardScoreProvinceAvg());
				mathScore.setSubjectPercentMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectPercentProvinceAvg());
				mathScore.setSubjectGradeMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectGradeProvinceAvg());
				mathScore.setSubjectRankMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectRankProvinceAvg());
			}
			else {
				mathScoreProvinceAvg = scoreMapper.getMathScoreProvinceAvg(examCode, provinceCode);
				mathScoreMunicipalityAvg = scoreMapper.getMathScoreMunicipalityAvg(examCode, municipalityCode);
				mathScore.setSubjectOriginalScoreProvinceAvg(mathScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
				mathScore.setSubjectOriginalScoreMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
				mathScore.setSubjectStandardScoreProvinceAvg(mathScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
				mathScore.setSubjectStandardScoreMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
				mathScore.setSubjectPercentProvinceAvg(mathScoreProvinceAvg.getSubjectPercentProvinceAvg());
				mathScore.setSubjectPercentMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
				mathScore.setSubjectGradeProvinceAvg(mathScoreProvinceAvg.getSubjectGradeProvinceAvg());
				mathScore.setSubjectGradeMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
				mathScore.setSubjectRankProvinceAvg(mathScoreProvinceAvg.getSubjectRankProvinceAvg());
				mathScore.setSubjectRankMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			}
		}
		subjectMap.put("mathScore", mathScore);

		
		// 영어 과목 점수 산출
		Subject englishScore = scoreMapper.getEnglishScore(userCode, tookExamInfoCode);

		if(englishScore != null) {
			// 영어 과목 점수 평균 산출
			SubjectAvg englishScoreNationAvg = scoreMapper.getEnglishScoreNationAvg(examCode);
			SubjectAvg englishScoreProvinceAvg;
			SubjectAvg englishScoreMunicipalityAvg;
			englishScore.setSubjectOriginalScoreNationAvg(englishScoreNationAvg.getSubjectOriginalScoreNationAvg());
			englishScore.setSubjectStandardScoreNationAvg(englishScoreNationAvg.getSubjectStandardScoreNationAvg());
			englishScore.setSubjectPercentNationAvg(englishScoreNationAvg.getSubjectPercentNationAvg());
			englishScore.setSubjectGradeNationAvg(englishScoreNationAvg.getSubjectGradeNationAvg());
			englishScore.setSubjectRankNationAvg(englishScoreNationAvg.getSubjectRankNationAvg());
			if(provinceCode.equals("11") || provinceCode.equals("26") || provinceCode.equals("27") || provinceCode.equals("28") ||
			   provinceCode.equals("29") || provinceCode.equals("30") || provinceCode.equals("31") || provinceCode.equals("36")) {	
				englishScoreProvinceAvg = null;
				englishScoreMunicipalityAvg = scoreMapper.getEnglishScoreProvinceAvg(examCode, provinceCode);
				englishScore.setSubjectOriginalScoreMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectOriginalScoreProvinceAvg());
				englishScore.setSubjectStandardScoreMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectStandardScoreProvinceAvg());
				englishScore.setSubjectPercentMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectPercentProvinceAvg());
				englishScore.setSubjectGradeMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectGradeProvinceAvg());
				englishScore.setSubjectRankMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectRankProvinceAvg());
			}
			else {
				englishScoreProvinceAvg = scoreMapper.getEnglishScoreProvinceAvg(examCode, provinceCode);
				englishScoreMunicipalityAvg = scoreMapper.getEnglishScoreMunicipalityAvg(examCode, municipalityCode);
				englishScore.setSubjectOriginalScoreProvinceAvg(englishScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
				englishScore.setSubjectOriginalScoreMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
				englishScore.setSubjectStandardScoreProvinceAvg(englishScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
				englishScore.setSubjectStandardScoreMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
				englishScore.setSubjectPercentProvinceAvg(englishScoreProvinceAvg.getSubjectPercentProvinceAvg());
				englishScore.setSubjectPercentMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
				englishScore.setSubjectGradeProvinceAvg(englishScoreProvinceAvg.getSubjectGradeProvinceAvg());
				englishScore.setSubjectGradeMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
				englishScore.setSubjectRankProvinceAvg(englishScoreProvinceAvg.getSubjectRankProvinceAvg());
				englishScore.setSubjectRankMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			}
		}
		subjectMap.put("englishScore", englishScore);
		
		// 한국사 과목 점수 산출
		Subject koreanHistoryScore = scoreMapper.getKoreanHistoryScore(userCode, tookExamInfoCode);

		if(koreanHistoryScore != null) {
			// 한국사 과목 점수 평균 산출
			SubjectAvg koreanHistoryScoreNationAvg = scoreMapper.getKoreanHistoryScoreNationAvg(examCode);
			SubjectAvg koreanHistoryScoreProvinceAvg;
			SubjectAvg koreanHistoryScoreMunicipalityAvg;
			koreanHistoryScore.setSubjectOriginalScoreNationAvg(koreanHistoryScoreNationAvg.getSubjectOriginalScoreNationAvg());
			koreanHistoryScore.setSubjectStandardScoreNationAvg(koreanHistoryScoreNationAvg.getSubjectStandardScoreNationAvg());
			koreanHistoryScore.setSubjectPercentNationAvg(koreanHistoryScoreNationAvg.getSubjectPercentNationAvg());
			koreanHistoryScore.setSubjectGradeNationAvg(koreanHistoryScoreNationAvg.getSubjectGradeNationAvg());
			koreanHistoryScore.setSubjectRankNationAvg(koreanHistoryScoreNationAvg.getSubjectRankNationAvg());
			if(provinceCode.equals("11") || provinceCode.equals("26") || provinceCode.equals("27") || provinceCode.equals("28") ||
			   provinceCode.equals("29") || provinceCode.equals("30") || provinceCode.equals("31") || provinceCode.equals("36")) {	
				koreanHistoryScoreProvinceAvg = null;
				koreanHistoryScoreMunicipalityAvg = scoreMapper.getKoreanHistoryScoreProvinceAvg(examCode, provinceCode);
				koreanHistoryScore.setSubjectOriginalScoreMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectOriginalScoreProvinceAvg());
				koreanHistoryScore.setSubjectStandardScoreMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectStandardScoreProvinceAvg());
				koreanHistoryScore.setSubjectPercentMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectPercentProvinceAvg());
				koreanHistoryScore.setSubjectGradeMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectGradeProvinceAvg());
				koreanHistoryScore.setSubjectRankMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectRankProvinceAvg());
			}
			else {
				koreanHistoryScoreProvinceAvg = scoreMapper.getKoreanHistoryScoreProvinceAvg(examCode, provinceCode);
				koreanHistoryScoreMunicipalityAvg = scoreMapper.getKoreanHistoryScoreMunicipalityAvg(examCode, municipalityCode);
				koreanHistoryScore.setSubjectOriginalScoreProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
				koreanHistoryScore.setSubjectOriginalScoreMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
				koreanHistoryScore.setSubjectStandardScoreProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
				koreanHistoryScore.setSubjectStandardScoreMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
				koreanHistoryScore.setSubjectPercentProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectPercentProvinceAvg());
				koreanHistoryScore.setSubjectPercentMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
				koreanHistoryScore.setSubjectGradeProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectGradeProvinceAvg());
				koreanHistoryScore.setSubjectGradeMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
				koreanHistoryScore.setSubjectRankProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectRankProvinceAvg());
				koreanHistoryScore.setSubjectRankMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			}
		}
		subjectMap.put("koreanHistoryScore", koreanHistoryScore);
		
		// 탐구1 과목 점수 산출
		Subject inquiry1Score = scoreMapper.getInquiry1Score(userCode, tookExamInfoCode);

		if(inquiry1Score != null) {
			// 탐구1 과목 점수 평균 산출
			SubjectAvg inquiry1ScoreNationAvg = scoreMapper.getInquiry1ScoreNationAvg(examCode);
			SubjectAvg inquiry1ScoreProvinceAvg;
			SubjectAvg inquiry1ScoreMunicipalityAvg;
			inquiry1Score.setSubjectOriginalScoreNationAvg(inquiry1ScoreNationAvg.getSubjectOriginalScoreNationAvg());
			inquiry1Score.setSubjectStandardScoreNationAvg(inquiry1ScoreNationAvg.getSubjectStandardScoreNationAvg());
			inquiry1Score.setSubjectPercentNationAvg(inquiry1ScoreNationAvg.getSubjectPercentNationAvg());
			inquiry1Score.setSubjectGradeNationAvg(inquiry1ScoreNationAvg.getSubjectGradeNationAvg());
			inquiry1Score.setSubjectRankNationAvg(inquiry1ScoreNationAvg.getSubjectRankNationAvg());
			if(provinceCode.equals("11") || provinceCode.equals("26") || provinceCode.equals("27") || provinceCode.equals("28") ||
			   provinceCode.equals("29") || provinceCode.equals("30") || provinceCode.equals("31") || provinceCode.equals("36")) {	
				inquiry1ScoreProvinceAvg = null;
				inquiry1ScoreMunicipalityAvg = scoreMapper.getInquiry1ScoreProvinceAvg(examCode, provinceCode);
				inquiry1Score.setSubjectOriginalScoreMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectOriginalScoreProvinceAvg());
				inquiry1Score.setSubjectStandardScoreMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectStandardScoreProvinceAvg());
				inquiry1Score.setSubjectPercentMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectPercentProvinceAvg());
				inquiry1Score.setSubjectGradeMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectGradeProvinceAvg());
				inquiry1Score.setSubjectRankMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectRankProvinceAvg());
			}
			else {
				inquiry1ScoreProvinceAvg = scoreMapper.getInquiry1ScoreProvinceAvg(examCode, provinceCode);
				inquiry1ScoreMunicipalityAvg = scoreMapper.getInquiry1ScoreMunicipalityAvg(examCode, municipalityCode);
				inquiry1Score.setSubjectOriginalScoreProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
				inquiry1Score.setSubjectOriginalScoreMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
				inquiry1Score.setSubjectStandardScoreProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
				inquiry1Score.setSubjectStandardScoreMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
				inquiry1Score.setSubjectPercentProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectPercentProvinceAvg());
				inquiry1Score.setSubjectPercentMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
				inquiry1Score.setSubjectGradeProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectGradeProvinceAvg());
				inquiry1Score.setSubjectGradeMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
				inquiry1Score.setSubjectRankProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectRankProvinceAvg());
				inquiry1Score.setSubjectRankMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			}
		}
		subjectMap.put("inquiry1Score", inquiry1Score);
		
		// 탐구2 과목 점수 산출
		Subject inquiry2Score = scoreMapper.getInquiry2Score(userCode, tookExamInfoCode);

		if(inquiry2Score != null) {
			// 탐구2 과목 점수 평균 산출
			SubjectAvg inquiry2ScoreNationAvg = scoreMapper.getInquiry2ScoreNationAvg(examCode);
			SubjectAvg inquiry2ScoreProvinceAvg;
			SubjectAvg inquiry2ScoreMunicipalityAvg;
			inquiry2Score.setSubjectOriginalScoreNationAvg(inquiry2ScoreNationAvg.getSubjectOriginalScoreNationAvg());
			inquiry2Score.setSubjectStandardScoreNationAvg(inquiry2ScoreNationAvg.getSubjectStandardScoreNationAvg());
			inquiry2Score.setSubjectPercentNationAvg(inquiry2ScoreNationAvg.getSubjectPercentNationAvg());
			inquiry2Score.setSubjectGradeNationAvg(inquiry2ScoreNationAvg.getSubjectGradeNationAvg());
			inquiry2Score.setSubjectRankNationAvg(inquiry2ScoreNationAvg.getSubjectRankNationAvg());
			if(provinceCode.equals("11") || provinceCode.equals("26") || provinceCode.equals("27") || provinceCode.equals("28") ||
			   provinceCode.equals("29") || provinceCode.equals("30") || provinceCode.equals("31") || provinceCode.equals("36")) {	
				inquiry2ScoreProvinceAvg = null;
				inquiry2ScoreMunicipalityAvg = scoreMapper.getInquiry2ScoreProvinceAvg(examCode, provinceCode);
				inquiry2Score.setSubjectOriginalScoreMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectOriginalScoreProvinceAvg());
				inquiry2Score.setSubjectStandardScoreMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectStandardScoreProvinceAvg());
				inquiry2Score.setSubjectPercentMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectPercentProvinceAvg());
				inquiry2Score.setSubjectGradeMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectGradeProvinceAvg());
				inquiry2Score.setSubjectRankMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectRankProvinceAvg());
			}
			else {
				inquiry2ScoreProvinceAvg = scoreMapper.getInquiry2ScoreProvinceAvg(examCode, provinceCode);
				inquiry2ScoreMunicipalityAvg = scoreMapper.getInquiry2ScoreMunicipalityAvg(examCode, municipalityCode);
				inquiry2Score.setSubjectOriginalScoreProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
				inquiry2Score.setSubjectOriginalScoreMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
				inquiry2Score.setSubjectStandardScoreProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
				inquiry2Score.setSubjectStandardScoreMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
				inquiry2Score.setSubjectPercentProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectPercentProvinceAvg());
				inquiry2Score.setSubjectPercentMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
				inquiry2Score.setSubjectGradeProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectGradeProvinceAvg());
				inquiry2Score.setSubjectGradeMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
				inquiry2Score.setSubjectRankProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectRankProvinceAvg());
				inquiry2Score.setSubjectRankMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			}
		}
		subjectMap.put("inquiry2Score", inquiry2Score);
		
		// 제2외국어 및 한문 과목 점수 산출 널처리
		Subject secondLanguageAndChineseCharactersScore = scoreMapper.getSecondLanguageAndChineseCharactersScore(userCode, tookExamInfoCode);

		if(secondLanguageAndChineseCharactersScore != null) {
			// 제2외국어 및 한문 과목 점수 평균 산출
			SubjectAvg secondLanguageAndChineseCharactersScoreNationAvg = scoreMapper.getSecondLanguageAndChineseCharactersScoreNationAvg(examCode);
			SubjectAvg secondLanguageAndChineseCharactersScoreProvinceAvg;
			SubjectAvg secondLanguageAndChineseCharactersScoreMunicipalityAvg;
			secondLanguageAndChineseCharactersScore.setSubjectOriginalScoreNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectOriginalScoreNationAvg());
			secondLanguageAndChineseCharactersScore.setSubjectStandardScoreNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectStandardScoreNationAvg());
			secondLanguageAndChineseCharactersScore.setSubjectPercentNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectPercentNationAvg());
			secondLanguageAndChineseCharactersScore.setSubjectGradeNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectGradeNationAvg());
			secondLanguageAndChineseCharactersScore.setSubjectRankNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectRankNationAvg());
			if(provinceCode.equals("11") || provinceCode.equals("26") || provinceCode.equals("27") || provinceCode.equals("28") ||
			   provinceCode.equals("29") || provinceCode.equals("30") || provinceCode.equals("31") || provinceCode.equals("36")) {	
				secondLanguageAndChineseCharactersScoreProvinceAvg = null;
				secondLanguageAndChineseCharactersScoreMunicipalityAvg = scoreMapper.getSecondLanguageAndChineseCharactersScoreProvinceAvg(examCode, provinceCode);
				secondLanguageAndChineseCharactersScore.setSubjectOriginalScoreMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectOriginalScoreProvinceAvg());
				secondLanguageAndChineseCharactersScore.setSubjectStandardScoreMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectStandardScoreProvinceAvg());
				secondLanguageAndChineseCharactersScore.setSubjectPercentMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectPercentProvinceAvg());
				secondLanguageAndChineseCharactersScore.setSubjectGradeMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectGradeProvinceAvg());
				secondLanguageAndChineseCharactersScore.setSubjectRankMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectRankProvinceAvg());
			}
			else {
				secondLanguageAndChineseCharactersScoreProvinceAvg = scoreMapper.getSecondLanguageAndChineseCharactersScoreProvinceAvg(examCode, provinceCode);
				secondLanguageAndChineseCharactersScoreMunicipalityAvg = scoreMapper.getSecondLanguageAndChineseCharactersScoreMunicipalityAvg(examCode, municipalityCode);
				secondLanguageAndChineseCharactersScore.setSubjectOriginalScoreProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
				secondLanguageAndChineseCharactersScore.setSubjectOriginalScoreMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
				secondLanguageAndChineseCharactersScore.setSubjectStandardScoreProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
				secondLanguageAndChineseCharactersScore.setSubjectStandardScoreMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
				secondLanguageAndChineseCharactersScore.setSubjectPercentProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectPercentProvinceAvg());
				secondLanguageAndChineseCharactersScore.setSubjectPercentMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
				secondLanguageAndChineseCharactersScore.setSubjectGradeProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectGradeProvinceAvg());
				secondLanguageAndChineseCharactersScore.setSubjectGradeMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
				secondLanguageAndChineseCharactersScore.setSubjectRankProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectRankProvinceAvg());
				secondLanguageAndChineseCharactersScore.setSubjectRankMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			}
		}
		subjectMap.put("secondLanguageAndChineseCharactersScore", secondLanguageAndChineseCharactersScore);

		return subjectMap;
	}
}