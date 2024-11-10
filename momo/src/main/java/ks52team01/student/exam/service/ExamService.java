package ks52team01.student.exam.service;

import java.util.List;

import ks52team01.student.exam.dto.ExamAnalyse;
import ks52team01.student.exam.dto.ExamInfo;
import ks52team01.student.exam.dto.ExamMappingQuestion;
import ks52team01.student.exam.dto.QnaBank;

public interface ExamService {

	List<ExamAnalyse> getUserExamData(String userCode, String majorCode);

	List<ExamInfo> getRegisteredQustionExamList();

	List<ExamMappingQuestion> getExamQuestionInfobyExamCode(String examCode);

	ExamInfo getExamInfoByExamCode(String examCode);

	List<ExamInfo> getSearchExamList(ExamInfo examInfo);

	List<QnaBank> getQuestionInfoListByExamCode(String examCode, String currentSubject);

	void registerResultToSubjectTable(String userCode, String examCode, String subMjrCateCode, List<String> qnaCode, List<String> userAnswer);

}
