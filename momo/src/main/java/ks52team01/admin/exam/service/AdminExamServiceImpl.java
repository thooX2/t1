package ks52team01.admin.exam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks52team01.admin.exam.dto.ExamQnaChap;
import ks52team01.admin.exam.dto.ExamQnaType;
import ks52team01.admin.exam.dto.QnaBank;
import ks52team01.admin.exam.dto.SubMirCate;
import ks52team01.admin.exam.dto.SubMjrCate;
import ks52team01.admin.exam.mapper.AdminExamMapper;
import ks52team01.common.mapper.CommonMapper;
import ks52team01.student.user.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdminExamServiceImpl implements AdminExamService {

	private final AdminExamMapper adminExamMapper;

	@Override
	public int modifyQustionState(List<String> qnaCode, boolean isState) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		String qnaState = "Y";
		int isChanged = 0;
		if (!isState) {
			qnaState = "N";
		}

		paramMap.put("qnaState", qnaState);
		paramMap.put("qnaCode", qnaCode);

		isChanged = adminExamMapper.modifyQustionState(paramMap);

		return isChanged;
	}

	@Override
	public void modifyQuestionProc(QnaBank qnaBank) {

		adminExamMapper.modifyQuestionProc(qnaBank);

	}

	@Override
	public QnaBank getQuestionInfo(String qnaCode) {

		return adminExamMapper.getQuestionInfo(qnaCode);
	}

	@Override
	public List<QnaBank> searchQuestionList(QnaBank qnaBank) {

		return adminExamMapper.searchQuestionList(qnaBank);
	}

	@Override
	public List<QnaBank> getQuestionListAll() {

		return adminExamMapper.getQuestionListAll();
	}

	@Override
	public void addExamQuestion(QnaBank qnaBank) {

		adminExamMapper.addExamQuestion(qnaBank);
	}

	@Override
	public List<ExamQnaChap> getQnaChapList() {

		return adminExamMapper.getQnaChapList();
	}

	@Override
	public List<ExamQnaType> getQnaTypeList() {

		return adminExamMapper.getQnaTypeList();
	}

	@Override
	public List<User> getUserListByGrade(String gradeCode) {

		return adminExamMapper.getUserListByGrade(gradeCode);
	}

	@Override
	public List<SubMirCate> getAdminExamCategoryList() {

		return adminExamMapper.getAdminExamCategoryList();
	}

}
