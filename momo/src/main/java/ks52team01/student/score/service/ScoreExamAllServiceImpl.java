package ks52team01.student.score.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ks52team01.student.exam.dto.TookExamInfo;
import ks52team01.student.exam.mapper.ExamMapper;
import ks52team01.student.score.dto.EnglishScore;
import ks52team01.student.score.dto.Inquiry1Score;
import ks52team01.student.score.dto.Inquiry2Score;
import ks52team01.student.score.dto.KoreanHistoryScore;
import ks52team01.student.score.dto.KoreanScore;
import ks52team01.student.score.dto.KoreanScoreAvg;
import ks52team01.student.score.dto.MathScore;
import ks52team01.student.score.dto.MathScoreAvg;
import ks52team01.student.score.dto.SecondLanguageAndChineseCharactersScore;
import ks52team01.student.score.mapper.ScoreMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreExamAllServiceImpl implements ScoreExamAllService {

	private final ExamMapper examMapper;
	private final ScoreMapper scoreMapper;

	@Override
	public void getExamAllScoreSummary() {

	}

	@Override
	public void getExamAllStandardScore() {

	}

	@Override
	public void getExamAllPercentScore() {

	}

	@Override
	public void getExamAllGradeScore() {

	}

	@Override
	public void getExamAllRank() {

	}

	@Override
	public List<TookExamInfo> getTookExamList(String userCode) {
		// TODO Auto-generated method stub
		return examMapper.getTookExamList(userCode);
	}

	@Override
	public KoreanHistoryScore getKoreanHistoryScore(String userCode, String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getKoreanHistoryScore(userCode, tookExamInfoCode);
	}

	@Override
	public KoreanScore getKoreanScore(String userCode, String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getKoreanScore(userCode, tookExamInfoCode);
	}

	@Override
	public MathScore getMathScore(String userCode, String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getMathScore(userCode, tookExamInfoCode);
	}

	@Override
	public EnglishScore getEnglishScore(String userCode, String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getEnglishScore(userCode, tookExamInfoCode);
	}

	@Override
	public Inquiry1Score getInquiry1Score(String userCode, String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getInquiry1Score(userCode, tookExamInfoCode);
	}

	@Override
	public Inquiry2Score getInquiry2Score(String userCode, String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getInquiry2Score(userCode, tookExamInfoCode);
	}

	@Override
	public SecondLanguageAndChineseCharactersScore getSecondLanguageAndChineseCharactersScore(String userCode,
			String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getSecondLanguageAndChineseCharactersScore(userCode, tookExamInfoCode);
	}

	@Override
	public List<Double> getRegionalAvgList(TookExamInfo tookExamInfo) {
		// TODO Auto-generated method stub
		String examCode = tookExamInfo.getExamCode();
		String userAreaCityCode = tookExamInfo.getAreaCityCode();
		String provinceCode = userAreaCityCode.substring(0, 2);
		String municipalityCode = userAreaCityCode.substring(3, 5);
		String koreanMajorSubject = tookExamInfo.getKorSltSubMjr();
		String koreanMinorSubject = tookExamInfo.getKorSltSub();
		String mathMajorSubject = tookExamInfo.getMathSltSubMjr();
		String mathMinorSubject = tookExamInfo.getMathSltSub();
		String englishMajorSubject = tookExamInfo.getEngSltSubMjr();
		String englishMinorSubject = tookExamInfo.getEngSltSub();
		String koreanHistoryMajorSubject = tookExamInfo.getKorHisSltSubMjr();
		String koreanHistoryMinorSubject = tookExamInfo.getKorHisSltSub();
		String inquiry1MajorSubject = tookExamInfo.getInq1SltSubMjr();
		String inquiry1MinorSubject = tookExamInfo.getInq1SltSub();
		String inquiry2MajorSubject = tookExamInfo.getInq2SltSubMjr();
		String inquiry2MinorSubject = tookExamInfo.getInq2SltSub();
		String foreignMajorSubject = tookExamInfo.getFrnSltSubMjr();
		String foreignMinorSubject = tookExamInfo.getFrnSltSub();
		// 국어 시험을 봤다면
		if (koreanMajorSubject != null) {
			KoreanScoreAvg koreanOriginScoreAvg = new KoreanScoreAvg();
			koreanOriginScoreAvg.setKoreanOriginNationAvg(scoreMapper.getNationAvg(examCode, koreanMinorSubject));
			koreanOriginScoreAvg.setKoreanOriginNationAvg(scoreMapper.getProvinceAvg(examCode, koreanMinorSubject, provinceCode));
			koreanOriginScoreAvg.setKoreanOriginProvinceAvg(-1.0);
			// 서울, 인천, 세종, 대전, 대구, 울산, 광주, 부산 출신이 아니라면
			if (!(provinceCode.equals("11") || provinceCode.equals("28") || provinceCode.equals("26")
					|| provinceCode.equals("27") || provinceCode.equals("29") || provinceCode.equals("27")
					|| provinceCode.equals("31") || provinceCode.equals("36"))) {
				koreanOriginScoreAvg.setKoreanOriginProvinceAvg(scoreMapper.getMunicipalityAvg(examCode, koreanMinorSubject, municipalityCode));
			}
		}

		return null;
	}
}
