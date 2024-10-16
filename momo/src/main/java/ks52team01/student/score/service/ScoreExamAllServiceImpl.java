package ks52team01.student.score.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks52team01.student.score.dto.Test;
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
	public List<Test> getExamAllOriginalScore() {
		return scoreMapper.getExamAllOriginalScore();
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
}
