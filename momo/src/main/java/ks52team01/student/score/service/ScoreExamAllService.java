package ks52team01.student.score.service;

import java.util.List;
import java.util.Map;

import ks52team01.student.exam.dto.TookExamInfo;
import ks52team01.student.score.dto.Subject;

public interface ScoreExamAllService {
	
	public List<TookExamInfo> getFirstTookExamList(String userCode);
	
	public Map<String, Subject> getTookExamScore(String userCode, String areaCityCode, String examCode, String tookExamInfoCode);
}