package ks52team01.student.exam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ks52team01.student.exam.dto.ExamAnalyse;
import ks52team01.student.exam.dto.ExamInfo;
import ks52team01.student.exam.dto.ExamMappingQuestion;
import ks52team01.student.exam.dto.ExamSubjectResult;
import ks52team01.student.exam.dto.QnaBank;
import ks52team01.student.exam.dto.TookExamInfo;

@Mapper
public interface ExamMapper {
	//
	List<ExamAnalyse> selectUserExamData(@Param("userCode") String userCode, @Param("majorCode") String majorCode);

	// 회원이 응시한 모의고사 목록 조회
	List<TookExamInfo> getTookExamList(String userCode);

	// 회원이 최초로 응시한 모의고사 목록 조회
	List<TookExamInfo> getFirstTookExamList(String userCode);

	List<ExamInfo> getRegisteredQustionExamList();

	List<ExamMappingQuestion> getExamQuestionInfobyExamCode(String examCode);

	ExamInfo getExamInfoByExamCode(String examCode);

	List<ExamInfo> getSearchExamList(ExamInfo examInfo);

	List<QnaBank> getQuestionInfoListByExamCode(String examCode, String currentSubject, String currentMjrCode);

	int registerResultToSubjectTable(ExamSubjectResult examResult);

	Map<String, Object> searchExamRatingExist(String userCode, String examCode);

	int registerExamRatingToExam(String newPk, String userCode, String examCode, String rating);

	int modifyExamRatingToExam(String userCode, String examCode, String rating);
}
