package ks52team01.admin.exam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.admin.exam.dto.AdminExamInfo;
import ks52team01.admin.exam.dto.AdminExamQnaChap;
import ks52team01.admin.exam.dto.AdminExamQnaType;
import ks52team01.admin.exam.dto.AdminQnaBank;
import ks52team01.admin.exam.dto.AdminSubMirCate;
import ks52team01.admin.exam.dto.AdminExamMappingQuestion;
import ks52team01.student.user.dto.User;

@Mapper
public interface AdminExamMapper {

	List<AdminSubMirCate> getAdminExamCategoryList();

	List<User> getUserListByGrade(String gradeCode);

	List<AdminExamQnaType> getQnaTypeList();

	List<AdminExamQnaChap> getQnaChapList();

	void addExamQuestion(AdminQnaBank qnaBank);

	List<AdminQnaBank> getQuestionListAll();

	List<AdminQnaBank> searchQuestionList(AdminQnaBank qnaBank);

	AdminQnaBank getQuestionInfo(String qnaCode);

	int modifyQuestionProc(AdminQnaBank qnaBank);

	int modifyQustionState(Map<String, Object> paramMap);

	int addExamInfo(AdminExamInfo examInfo);

	List<AdminExamInfo> getExamInfoList();

	AdminExamInfo getExamInfoByExamCode(String examCode);

	int modifyExamInfo(AdminExamInfo examInfo);

	List<AdminExamInfo> searchExamList(Map<String, Object> paramMap);

	List<AdminQnaBank> getQuestionListBySmjrcc(String smjrcc);

	int registerQuestionToExam(AdminExamMappingQuestion examMappingQuestion);

	List<AdminQnaBank> getQuestionListByExamCode(String examCode);

	int deleteQuestionFromExam(String selectedExamCode);

}
