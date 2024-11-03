package ks52team01.admin.exam.service;

import java.util.List;

import ks52team01.admin.exam.dto.AdminExamInfo;
import ks52team01.admin.exam.dto.AdminExamQnaChap;
import ks52team01.admin.exam.dto.AdminExamQnaType;
import ks52team01.admin.exam.dto.AdminQnaBank;
import ks52team01.admin.exam.dto.AdminSubMirCate;
import ks52team01.student.user.dto.User;

public interface AdminExamService {

	List<AdminSubMirCate> getAdminExamCategoryList();

	List<User> getUserListByGrade(String gradeCode);

	List<AdminExamQnaType> getQnaTypeList();

	List<AdminExamQnaChap> getQnaChapList();

	void addExamQuestion(AdminQnaBank qnaBank);

	List<AdminQnaBank> getQuestionListAll();

	List<AdminQnaBank> searchQuestionList(AdminQnaBank qnaBank, String subjectName);

	AdminQnaBank getQuestionInfo(String qnaCode);

	void modifyQuestionProc(AdminQnaBank qnaBank);

	int modifyQustionState(List<String> qnaCode, boolean isState);

	void addExamInfo(AdminExamInfo examInfo);

	List<AdminExamInfo> getExamInfoList();

	AdminExamInfo getExamInfoByExamCode(String examCode);

	void modifyExamInfo(AdminExamInfo examInfo);

	List<AdminExamInfo> searchExamList(AdminExamInfo examInfo, String searchType, String searchKeyword,
			String startDate, String endDate);

	List<AdminQnaBank> getQuestionListBySmjrcc(String smjrcc);

}
