package ks52team01.admin.exam.service;

import java.util.List;

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
	private final CommonMapper commonMapper;

	@Override
	public List<QnaBank> getQuestionListAll() {
	
		return adminExamMapper.getQuestionListAll();
	}
	
	
	
	@Override
	public void addExamQuestion(QnaBank qnaBank) {
		String newQnaCode = commonMapper.getPrimaryKey("qna_bank", "qna_code", "qc");
		qnaBank.setQnaCode(newQnaCode);

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
