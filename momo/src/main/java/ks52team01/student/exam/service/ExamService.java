package ks52team01.student.exam.service;

import java.util.List;

import ks52team01.student.exam.dto.ExamAnalyseDto;

public interface ExamService {

	List<ExamAnalyseDto> getUserExamData(String userCode, String majorCode);
}
