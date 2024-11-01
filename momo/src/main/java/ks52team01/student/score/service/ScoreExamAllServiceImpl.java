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

@Service
@RequiredArgsConstructor
public class ScoreExamAllServiceImpl implements ScoreExamAllService {

	private final ExamMapper examMapper;
	private final ScoreMapper scoreMapper;

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
		String municipalityCode = areaCityCode.substring(2, 4);

		// 국어 과목 점수 산출
		Subject koreanScore = scoreMapper.getKoreanScore(userCode, tookExamInfoCode);
		
		if(koreanScore != null) {
			// 국어 과목 점수 평균 산출
			SubjectAvg koreanScoreNationAvg = scoreMapper.getKoreanScoreNationAvg(examCode);
			SubjectAvg koreanScoreProvinceAvg = scoreMapper.getKoreanScoreProvinceAvg(examCode, provinceCode);
			SubjectAvg koreanScoreMunicipalityAvg = scoreMapper.getKoreanScoreMunicipalityAvg(examCode, municipalityCode);
	
			// 국어 과목 점수 + 점수 평균 종합
			koreanScore.setSubjectOriginalScoreNationAvg(koreanScoreNationAvg.getSubjectOriginalScoreNationAvg());
			koreanScore.setSubjectOriginalScoreProvinceAvg(koreanScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
			koreanScore.setSubjectOriginalScoreMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
			koreanScore.setSubjectStandardScoreNationAvg(koreanScoreNationAvg.getSubjectStandardScoreNationAvg());
			koreanScore.setSubjectStandardScoreProvinceAvg(koreanScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
			koreanScore.setSubjectStandardScoreMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
			koreanScore.setSubjectPercentNationAvg(koreanScoreNationAvg.getSubjectPercentNationAvg());
			koreanScore.setSubjectPercentProvinceAvg(koreanScoreProvinceAvg.getSubjectPercentProvinceAvg());
			koreanScore.setSubjectPercentMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
			koreanScore.setSubjectGradeNationAvg(koreanScoreNationAvg.getSubjectGradeNationAvg());
			koreanScore.setSubjectGradeProvinceAvg(koreanScoreProvinceAvg.getSubjectGradeProvinceAvg());
			koreanScore.setSubjectGradeMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
			koreanScore.setSubjectRankNationAvg(koreanScoreNationAvg.getSubjectRankNationAvg());
			koreanScore.setSubjectRankProvinceAvg(koreanScoreProvinceAvg.getSubjectRankProvinceAvg());
			koreanScore.setSubjectRankMunicipalityAvg(koreanScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			System.out.println(koreanScore); // test
		}
		subjectMap.put("koreanScore", koreanScore);

		// 수학 과목 점수 산출
		Subject mathScore = scoreMapper.getMathScore(userCode, tookExamInfoCode);

		if(mathScore != null) {
			// 수학 과목 점수 평균 산출
			SubjectAvg mathScoreNationAvg = scoreMapper.getMathScoreNationAvg(examCode);
			SubjectAvg mathScoreProvinceAvg = scoreMapper.getMathScoreProvinceAvg(examCode, provinceCode);
			SubjectAvg mathScoreMunicipalityAvg = scoreMapper.getMathScoreMunicipalityAvg(examCode, municipalityCode);
			
			// 수학 과목 점수 + 점수 평균 종합
			mathScore.setSubjectOriginalScoreNationAvg(mathScoreNationAvg.getSubjectOriginalScoreNationAvg());
			mathScore.setSubjectOriginalScoreProvinceAvg(mathScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
			mathScore.setSubjectOriginalScoreMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
			mathScore.setSubjectStandardScoreNationAvg(mathScoreNationAvg.getSubjectStandardScoreNationAvg());
			mathScore.setSubjectStandardScoreProvinceAvg(mathScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
			mathScore.setSubjectStandardScoreMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
			mathScore.setSubjectPercentNationAvg(mathScoreNationAvg.getSubjectPercentNationAvg());
			mathScore.setSubjectPercentProvinceAvg(mathScoreProvinceAvg.getSubjectPercentProvinceAvg());
			mathScore.setSubjectPercentMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
			mathScore.setSubjectGradeNationAvg(mathScoreNationAvg.getSubjectGradeNationAvg());
			mathScore.setSubjectGradeProvinceAvg(mathScoreProvinceAvg.getSubjectGradeProvinceAvg());
			mathScore.setSubjectGradeMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
			mathScore.setSubjectRankNationAvg(mathScoreNationAvg.getSubjectRankNationAvg());
			mathScore.setSubjectRankProvinceAvg(mathScoreProvinceAvg.getSubjectRankProvinceAvg());
			mathScore.setSubjectRankMunicipalityAvg(mathScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			System.out.println(mathScore); // test
		}
		subjectMap.put("mathScore", mathScore);

		
		// 영어 과목 점수 산출
		Subject englishScore = scoreMapper.getEnglishScore(userCode, tookExamInfoCode);

		if(englishScore != null) {
			// 영어 과목 점수 평균 산출
			SubjectAvg englishScoreNationAvg = scoreMapper.getEnglishScoreNationAvg(examCode);
			SubjectAvg englishScoreProvinceAvg = scoreMapper.getEnglishScoreProvinceAvg(examCode, provinceCode);
			SubjectAvg englishScoreMunicipalityAvg = scoreMapper.getEnglishScoreMunicipalityAvg(examCode, municipalityCode);
			
			// 영어 과목 점수 + 점수 평균 종합
			englishScore.setSubjectOriginalScoreNationAvg(englishScoreNationAvg.getSubjectOriginalScoreNationAvg());
			englishScore.setSubjectOriginalScoreProvinceAvg(englishScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
			englishScore.setSubjectOriginalScoreMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
			englishScore.setSubjectStandardScoreNationAvg(englishScoreNationAvg.getSubjectStandardScoreNationAvg());
			englishScore.setSubjectStandardScoreProvinceAvg(englishScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
			englishScore.setSubjectStandardScoreMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
			englishScore.setSubjectPercentNationAvg(englishScoreNationAvg.getSubjectPercentNationAvg());
			englishScore.setSubjectPercentProvinceAvg(englishScoreProvinceAvg.getSubjectPercentProvinceAvg());
			englishScore.setSubjectPercentMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
			englishScore.setSubjectGradeNationAvg(englishScoreNationAvg.getSubjectGradeNationAvg());
			englishScore.setSubjectGradeProvinceAvg(englishScoreProvinceAvg.getSubjectGradeProvinceAvg());
			englishScore.setSubjectGradeMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
			englishScore.setSubjectRankNationAvg(englishScoreNationAvg.getSubjectRankNationAvg());
			englishScore.setSubjectRankProvinceAvg(englishScoreProvinceAvg.getSubjectRankProvinceAvg());
			englishScore.setSubjectRankMunicipalityAvg(englishScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			System.out.println(englishScore); // test
		}
		subjectMap.put("englishScore", englishScore);
		
		// 한국사 과목 점수 산출
		Subject koreanHistoryScore = scoreMapper.getKoreanHistoryScore(userCode, tookExamInfoCode);

		if(koreanHistoryScore != null) {
			// 한국사 과목 점수 평균 산출
			SubjectAvg koreanHistoryScoreNationAvg = scoreMapper.getKoreanHistoryScoreNationAvg(examCode);
			SubjectAvg koreanHistoryScoreProvinceAvg = scoreMapper.getKoreanHistoryScoreProvinceAvg(examCode, provinceCode);
			SubjectAvg koreanHistoryScoreMunicipalityAvg = scoreMapper.getKoreanHistoryScoreMunicipalityAvg(examCode, municipalityCode);
			
			// 한국사 과목 점수 + 점수 평균 종합
			koreanHistoryScore.setSubjectOriginalScoreNationAvg(koreanHistoryScoreNationAvg.getSubjectOriginalScoreNationAvg());
			koreanHistoryScore.setSubjectOriginalScoreProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
			koreanHistoryScore.setSubjectOriginalScoreMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
			koreanHistoryScore.setSubjectStandardScoreNationAvg(koreanHistoryScoreNationAvg.getSubjectStandardScoreNationAvg());
			koreanHistoryScore.setSubjectStandardScoreProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
			koreanHistoryScore.setSubjectStandardScoreMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
			koreanHistoryScore.setSubjectPercentNationAvg(koreanHistoryScoreNationAvg.getSubjectPercentNationAvg());
			koreanHistoryScore.setSubjectPercentProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectPercentProvinceAvg());
			koreanHistoryScore.setSubjectPercentMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
			koreanHistoryScore.setSubjectGradeNationAvg(koreanHistoryScoreNationAvg.getSubjectGradeNationAvg());
			koreanHistoryScore.setSubjectGradeProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectGradeProvinceAvg());
			koreanHistoryScore.setSubjectGradeMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
			koreanHistoryScore.setSubjectRankNationAvg(koreanHistoryScoreNationAvg.getSubjectRankNationAvg());
			koreanHistoryScore.setSubjectRankProvinceAvg(koreanHistoryScoreProvinceAvg.getSubjectRankProvinceAvg());
			koreanHistoryScore.setSubjectRankMunicipalityAvg(koreanHistoryScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			System.out.println(koreanHistoryScore); // test
		}
		subjectMap.put("koreanHistoryScore", koreanHistoryScore);
		
		// 탐구1 과목 점수 산출
		Subject inquiry1Score = scoreMapper.getInquiry1Score(userCode, tookExamInfoCode);

		if(inquiry1Score != null) {
			// 탐구1 과목 점수 평균 산출
			SubjectAvg inquiry1ScoreNationAvg = scoreMapper.getInquiry1ScoreNationAvg(examCode);
			SubjectAvg inquiry1ScoreProvinceAvg = scoreMapper.getInquiry1ScoreProvinceAvg(examCode, provinceCode);
			SubjectAvg inquiry1ScoreMunicipalityAvg = scoreMapper.getInquiry1ScoreMunicipalityAvg(examCode, municipalityCode);
			
			// 탐구1 과목 점수 + 점수 평균 종합
			inquiry1Score.setSubjectOriginalScoreNationAvg(inquiry1ScoreNationAvg.getSubjectOriginalScoreNationAvg());
			inquiry1Score.setSubjectOriginalScoreProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
			inquiry1Score.setSubjectOriginalScoreMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
			inquiry1Score.setSubjectStandardScoreNationAvg(inquiry1ScoreNationAvg.getSubjectStandardScoreNationAvg());
			inquiry1Score.setSubjectStandardScoreProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
			inquiry1Score.setSubjectStandardScoreMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
			inquiry1Score.setSubjectPercentNationAvg(inquiry1ScoreNationAvg.getSubjectPercentNationAvg());
			inquiry1Score.setSubjectPercentProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectPercentProvinceAvg());
			inquiry1Score.setSubjectPercentMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
			inquiry1Score.setSubjectGradeNationAvg(inquiry1ScoreNationAvg.getSubjectGradeNationAvg());
			inquiry1Score.setSubjectGradeProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectGradeProvinceAvg());
			inquiry1Score.setSubjectGradeMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
			inquiry1Score.setSubjectRankNationAvg(inquiry1ScoreNationAvg.getSubjectRankNationAvg());
			inquiry1Score.setSubjectRankProvinceAvg(inquiry1ScoreProvinceAvg.getSubjectRankProvinceAvg());
			inquiry1Score.setSubjectRankMunicipalityAvg(inquiry1ScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			System.out.println(inquiry1Score); // test
		}
		subjectMap.put("inquiry1Score", inquiry1Score);
		
		// 탐구2 과목 점수 산출
		Subject inquiry2Score = scoreMapper.getInquiry2Score(userCode, tookExamInfoCode);

		if(inquiry2Score != null) {
			// 탐구2 과목 점수 평균 산출
			SubjectAvg inquiry2ScoreNationAvg = scoreMapper.getInquiry2ScoreNationAvg(examCode);
			SubjectAvg inquiry2ScoreProvinceAvg = scoreMapper.getInquiry2ScoreProvinceAvg(examCode, provinceCode);
			SubjectAvg inquiry2ScoreMunicipalityAvg = scoreMapper.getInquiry2ScoreMunicipalityAvg(examCode, municipalityCode);
			
			// 탐구2 과목 점수 + 점수 평균 종합
			inquiry2Score.setSubjectOriginalScoreNationAvg(inquiry2ScoreNationAvg.getSubjectOriginalScoreNationAvg());
			inquiry2Score.setSubjectOriginalScoreProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
			inquiry2Score.setSubjectOriginalScoreMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
			inquiry2Score.setSubjectStandardScoreNationAvg(inquiry2ScoreNationAvg.getSubjectStandardScoreNationAvg());
			inquiry2Score.setSubjectStandardScoreProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
			inquiry2Score.setSubjectStandardScoreMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
			inquiry2Score.setSubjectPercentNationAvg(inquiry2ScoreNationAvg.getSubjectPercentNationAvg());
			inquiry2Score.setSubjectPercentProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectPercentProvinceAvg());
			inquiry2Score.setSubjectPercentMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
			inquiry2Score.setSubjectGradeNationAvg(inquiry2ScoreNationAvg.getSubjectGradeNationAvg());
			inquiry2Score.setSubjectGradeProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectGradeProvinceAvg());
			inquiry2Score.setSubjectGradeMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
			inquiry2Score.setSubjectRankNationAvg(inquiry2ScoreNationAvg.getSubjectRankNationAvg());
			inquiry2Score.setSubjectRankProvinceAvg(inquiry2ScoreProvinceAvg.getSubjectRankProvinceAvg());
			inquiry2Score.setSubjectRankMunicipalityAvg(inquiry2ScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			System.out.println(inquiry2Score); // test
		}
		subjectMap.put("inquiry2Score", inquiry2Score);
		
		// 제2외국어 및 한문 과목 점수 산출 널처리
		Subject secondLanguageAndChineseCharactersScore = scoreMapper.getSecondLanguageAndChineseCharactersScore(userCode, tookExamInfoCode);

		if(secondLanguageAndChineseCharactersScore != null) {
			// 제2외국어 및 한문 과목 점수 평균 산출
			SubjectAvg secondLanguageAndChineseCharactersScoreNationAvg = scoreMapper.getSecondLanguageAndChineseCharactersScoreNationAvg(examCode);
			SubjectAvg secondLanguageAndChineseCharactersScoreProvinceAvg = scoreMapper.getSecondLanguageAndChineseCharactersScoreProvinceAvg(examCode, provinceCode);
			SubjectAvg secondLanguageAndChineseCharactersScoreMunicipalityAvg = scoreMapper.getSecondLanguageAndChineseCharactersScoreMunicipalityAvg(examCode, municipalityCode);
			
			// 제2외국어 및 한문 과목 점수 + 점수 평균 종합
			secondLanguageAndChineseCharactersScore.setSubjectOriginalScoreNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectOriginalScoreNationAvg());
			secondLanguageAndChineseCharactersScore.setSubjectOriginalScoreProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectOriginalScoreProvinceAvg());
			secondLanguageAndChineseCharactersScore.setSubjectOriginalScoreMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectOriginalScoreMunicipalityAvg());
			secondLanguageAndChineseCharactersScore.setSubjectStandardScoreNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectStandardScoreNationAvg());
			secondLanguageAndChineseCharactersScore.setSubjectStandardScoreProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectStandardScoreProvinceAvg());
			secondLanguageAndChineseCharactersScore.setSubjectStandardScoreMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectStandardScoreMunicipalityAvg());
			secondLanguageAndChineseCharactersScore.setSubjectPercentNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectPercentNationAvg());
			secondLanguageAndChineseCharactersScore.setSubjectPercentProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectPercentProvinceAvg());
			secondLanguageAndChineseCharactersScore.setSubjectPercentMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectPercentMunicipalityAvg());
			secondLanguageAndChineseCharactersScore.setSubjectGradeNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectGradeNationAvg());
			secondLanguageAndChineseCharactersScore.setSubjectGradeProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectGradeProvinceAvg());
			secondLanguageAndChineseCharactersScore.setSubjectGradeMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectGradeMunicipalityAvg());
			secondLanguageAndChineseCharactersScore.setSubjectRankNationAvg(secondLanguageAndChineseCharactersScoreNationAvg.getSubjectRankNationAvg());
			secondLanguageAndChineseCharactersScore.setSubjectRankProvinceAvg(secondLanguageAndChineseCharactersScoreProvinceAvg.getSubjectRankProvinceAvg());
			secondLanguageAndChineseCharactersScore.setSubjectRankMunicipalityAvg(secondLanguageAndChineseCharactersScoreMunicipalityAvg.getSubjectRankMunicipalityAvg());
			System.out.println(secondLanguageAndChineseCharactersScore); // test
		}
		subjectMap.put("secondLanguageAndChineseCharactersScore", secondLanguageAndChineseCharactersScore);

		return subjectMap;
	}
}