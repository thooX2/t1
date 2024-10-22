package ks52team01.student.score.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks52team01.student.score.dto.EnglishScore;
import ks52team01.student.score.dto.Inquiry1Score;
import ks52team01.student.score.dto.Inquiry2Score;
import ks52team01.student.score.dto.KoreanHistoryScore;
import ks52team01.student.score.dto.KoreanScore;
import ks52team01.student.score.dto.MathScore;
import ks52team01.student.score.dto.SecondLanguageAndChineseCharactersScore;
import ks52team01.student.score.dto.TookExam;
import ks52team01.student.score.mapper.ScoreMapper;
import ks52team01.student.user.dto.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreExamAllServiceImpl implements ScoreExamAllService {

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
	public List<TookExam> getTookExam(String userCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getTookExam(userCode);
	}

	@Override
	public KoreanHistoryScore getKoreanHistoryScore(String userCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getKoreanHistoryScore(userCode);
	}

	@Override
	public KoreanScore getKoreanScore(String userCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getKoreanScore(userCode);
	}
	
	@Override
	public MathScore getMathScore(String userCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getMathScore(userCode);
	}

	@Override
	public EnglishScore getEnglishScore(String userCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getEnglishScore(userCode);
	}

	@Override
	public Inquiry1Score getInquiry1Score(String userCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getInquiry1Score(userCode);
	}

	@Override
	public Inquiry2Score getInquiry2Score(String userCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getInquiry2Score(userCode);
	}

	@Override
	public SecondLanguageAndChineseCharactersScore getSecondLanguageAndChineseCharactersScore(String userCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getSecondLanguageAndChineseCharactersScore(userCode);
	}

	@Override
	public KoreanHistoryScore getKoreanHistoryScoreByTookExamCode(String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getKoreanHistoryScoreByTookExamCode(tookExamInfoCode);
	}
}
