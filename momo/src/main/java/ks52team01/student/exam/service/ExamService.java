package ks52team01.student.exam.service;

import java.util.List;

import ks52team01.student.exam.dto.ExamAnalyse;
import ks52team01.student.exam.dto.ExamInfo;

public interface ExamService {

	List<ExamAnalyse> getUserExamData(String userCode, String majorCode);

	List<ExamInfo> getRegisteredQustionExamList();
}
