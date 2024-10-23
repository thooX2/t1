package ks52team01.student.score.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks52team01.student.exam.dto.TookExamInfo;
import ks52team01.student.exam.mapper.ExamMapper;
import ks52team01.student.score.dto.EnglishScore;
import ks52team01.student.score.dto.Inquiry1Score;
import ks52team01.student.score.dto.Inquiry2Score;
import ks52team01.student.score.dto.KoreanHistoryScore;
import ks52team01.student.score.dto.KoreanScore;
import ks52team01.student.score.dto.MathScore;
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
	public KoreanHistoryScore getKoreanHistoryScore(String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getKoreanHistoryScore(tookExamInfoCode);
	}

	@Override
	public KoreanScore getKoreanScore(String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getKoreanScore(tookExamInfoCode);
	}
	
	@Override
	public MathScore getMathScore(String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getMathScore(tookExamInfoCode);
	}

	@Override
	public EnglishScore getEnglishScore(String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getEnglishScore(tookExamInfoCode);
	}

	@Override
	public Inquiry1Score getInquiry1Score(String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getInquiry1Score(tookExamInfoCode);
	}

	@Override
	public Inquiry2Score getInquiry2Score(String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getInquiry2Score(tookExamInfoCode);
	}

	@Override
	public SecondLanguageAndChineseCharactersScore getSecondLanguageAndChineseCharactersScore(String tookExamInfoCode) {
		// TODO Auto-generated method stub
		return scoreMapper.getSecondLanguageAndChineseCharactersScore(tookExamInfoCode);
	}
}
