package ks52team01.admin.exam.service;

import java.util.List;

import ks52team01.admin.exam.dto.ExamQnaChap;
import ks52team01.admin.exam.dto.ExamQnaType;
import ks52team01.admin.exam.dto.QnaBank;
import ks52team01.admin.exam.dto.SubMirCate;
import ks52team01.student.user.dto.User;

public interface AdminExamService {

	List<SubMirCate> getAdminExamCategoryList();

	List<User> getUserListByGrade(String gradeCode);

	List<ExamQnaType> getQnaTypeList();

	List<ExamQnaChap> getQnaChapList();

	void addExamQuestion(QnaBank qnaBank);

	List<QnaBank> getQuestionListAll();

	List<QnaBank> searchQuestionList(QnaBank qnaBank);

	QnaBank getQuestionInfo(String qnaCode);

	void modifyQuestionProc(QnaBank qnaBank);

}
