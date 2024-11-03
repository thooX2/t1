package ks52team01.admin.exam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks52team01.admin.exam.dto.AdminExamInfo;
import ks52team01.admin.exam.dto.AdminExamQnaChap;
import ks52team01.admin.exam.dto.AdminExamQnaType;
import ks52team01.admin.exam.dto.AdminQnaBank;
import ks52team01.admin.exam.dto.AdminSubMirCate;
import ks52team01.admin.exam.dto.AdminSubMjrCate;
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
	public List<AdminQnaBank> getQuestionListBySmjrcc(String smjrcc) {

		return adminExamMapper.getQuestionListBySmjrcc(smjrcc);
	}

	@Override
	public List<AdminExamInfo> searchExamList(AdminExamInfo examInfo, String searchType, String searchKeyword,
			String startDate, String endDate) {

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("examInfo", examInfo);
		paramMap.put("searchType", searchType);
		paramMap.put("searchKeyword", searchKeyword);
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);

		return adminExamMapper.searchExamList(paramMap);
	}

	@Override
	public void modifyExamInfo(AdminExamInfo examInfo) {

		adminExamMapper.modifyExamInfo(examInfo);
	}

	@Override
	public AdminExamInfo getExamInfoByExamCode(String examCode) {

		return adminExamMapper.getExamInfoByExamCode(examCode);
	}

	@Override
	public List<AdminExamInfo> getExamInfoList() {

		return adminExamMapper.getExamInfoList();
	}

	@Override
	public void addExamInfo(AdminExamInfo examInfo) {

		String newExamCode = commonMapper.getPrimaryKey("exam_info", "exam_code", "ec");
		examInfo.setExamCode(newExamCode);

		adminExamMapper.addExamInfo(examInfo);
	}

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
	public void modifyQuestionProc(AdminQnaBank qnaBank) {

		adminExamMapper.modifyQuestionProc(qnaBank);

	}

	@Override
	public AdminQnaBank getQuestionInfo(String qnaCode) {

		return adminExamMapper.getQuestionInfo(qnaCode);
	}

	@Override
	public List<AdminQnaBank> searchQuestionList(AdminQnaBank qnaBank, String subjectName) {

		if (subjectName != null) {
			String SubMjrCatCode = "";
			switch (subjectName) {
			case "국어":
				SubMjrCatCode = "smjrcc1";
				break;
			case "수학":
				SubMjrCatCode = "smjrcc2";
				break;
			case "영어":
				SubMjrCatCode = "smjrcc3";
				break;
			case "한국사":
				SubMjrCatCode = "smjrcc4";
				break;
			case "탐구":
				SubMjrCatCode = "smjrcc5,smjrcc6,smjrcc7";
				break;
			case "제 2외국어/한문":
				SubMjrCatCode = "smjrcc8";
				break;
			}
			qnaBank.setSubMjrCatCode(SubMjrCatCode);
		}

		log.error(qnaBank.getSubMirCatCode());

		return adminExamMapper.searchQuestionList(qnaBank);
	}

	@Override
	public List<AdminQnaBank> getQuestionListAll() {

		return adminExamMapper.getQuestionListAll();
	}

	@Override
	public void addExamQuestion(AdminQnaBank qnaBank) {

		adminExamMapper.addExamQuestion(qnaBank);
	}

	@Override
	public List<AdminExamQnaChap> getQnaChapList() {

		return adminExamMapper.getQnaChapList();
	}

	@Override
	public List<AdminExamQnaType> getQnaTypeList() {

		return adminExamMapper.getQnaTypeList();
	}

	@Override
	public List<User> getUserListByGrade(String gradeCode) {

		return adminExamMapper.getUserListByGrade(gradeCode);
	}

	@Override
	public List<AdminSubMirCate> getAdminExamCategoryList() {

		return adminExamMapper.getAdminExamCategoryList();
	}

}
