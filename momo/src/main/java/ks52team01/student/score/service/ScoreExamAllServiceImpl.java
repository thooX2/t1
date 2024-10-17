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
	public List<TookExam> getTookExam() {
		// TODO Auto-generated method stub
		return scoreMapper.getTookExam();
	}

	@Override
	public KoreanHistoryScore getKoreanHistoryScore() {
		// TODO Auto-generated method stub
		return scoreMapper.getKoreanHistoryScore();
	}

	@Override
	public KoreanScore getKoreanScore() {
		// TODO Auto-generated method stub
		return scoreMapper.getKoreanScore();
	}
	
	@Override
	public MathScore getMathScore() {
		// TODO Auto-generated method stub
		return scoreMapper.getMathScore();
	}

	@Override
	public EnglishScore getEnglishScore() {
		// TODO Auto-generated method stub
		return scoreMapper.getEnglishScore();
	}

	@Override
	public Inquiry1Score getInquiry1Score() {
		// TODO Auto-generated method stub
		return scoreMapper.getInquiry1Score();
	}

	@Override
	public Inquiry2Score getInquiry2Score() {
		// TODO Auto-generated method stub
		return scoreMapper.getInquiry2Score();
	}

	@Override
	public SecondLanguageAndChineseCharactersScore getSecondLanguageAndChineseCharactersScore() {
		// TODO Auto-generated method stub
		SecondLanguageAndChineseCharactersScore secondLanguageAndChineseCharactersScore = scoreMapper.getSecondLanguageAndChineseCharactersScore();
		if(secondLanguageAndChineseCharactersScore == null) {
			SecondLanguageAndChineseCharactersScore newSecondLanguageAndChineseCharactersScore = new SecondLanguageAndChineseCharactersScore();
			System.out.println("asdfasdfasdf");
			System.out.println(newSecondLanguageAndChineseCharactersScore.getTookExamInfoCode());
		}
		return scoreMapper.getSecondLanguageAndChineseCharactersScore();
	}
}
