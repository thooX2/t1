package ks52team01.student.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.score.dto.Test;
import ks52team01.student.score.dto.TookExam;

@Mapper
public interface ScoreMapper {

	public void getScoreMain();
	
	public List<Test> getExamAllOriginalScore();
	
	public List<TookExam> getTookExam();
}
