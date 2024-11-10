package ks52team01.student.exam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks52team01.common.mapper.CommonMapper;
import ks52team01.student.exam.dto.ExamAnalyse;
import ks52team01.student.exam.dto.ExamInfo;
import ks52team01.student.exam.dto.ExamMappingQuestion;
import ks52team01.student.exam.dto.ExamSubjectResult;
import ks52team01.student.exam.dto.QnaBank;
import ks52team01.student.exam.mapper.ExamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ExamServiceImpl implements ExamService {

	private final ExamMapper examMapper;

	@Override
	public void registerResultToSubjectTable(String userCode, String examCode, String subMjrCateCode,
			List<String> qnaCode, List<String> userAnswer) {

		ExamSubjectResult examResult = new ExamSubjectResult();
		examResult.setExamCode(examCode);
		examResult.setUserCode(userCode);
		examResult.setSubMjrCatCode(subMjrCateCode);
		switch (subMjrCateCode) {
		case "smjrcc1":
			examResult.setTableName("user_ans_kor");
			examResult.setPreCode("uakc");
			examResult.setPkColumnName("user_ans_kor_code");
			break;
		case "smjrcc2":
			examResult.setTableName("user_ans_math");
			examResult.setPreCode("uamc");
			examResult.setPkColumnName("user_ans_math_code");
			break;
		case "smjrcc3":
			examResult.setTableName("user_ans_eng");
			examResult.setPreCode("uaec");
			examResult.setPkColumnName("user_ans_eng_code");
			break;
		case "smjrcc4":
			examResult.setTableName("user_ans_kor_his");
			examResult.setPreCode("uakhc");
			examResult.setPkColumnName("user_ans_kor_his_code");
			break;
		case "smjrcc5":
			examResult.setTableName("user_ans_inq1");
			examResult.setPreCode("uaico");
			examResult.setPkColumnName("user_ans_inq1_code");
			break;
		case "smjrcc6":
			examResult.setTableName("user_ans_inq1");
			examResult.setPreCode("uaico");
			examResult.setPkColumnName("user_ans_inq1_code");
			break;
		case "smjrcc7":
			examResult.setTableName("user_ans_inq1");
			examResult.setPreCode("uaico");
			examResult.setPkColumnName("user_ans_inq1_code");
			break;
		case "smjrcc8":
			examResult.setTableName("user_ans_frn");
			examResult.setPreCode("uafc");
			examResult.setPkColumnName("user_ans_frn_code");
			break;
		}

		examResult.setUserAnswer(userAnswer);
		examResult.setQnaCode(qnaCode);
		examMapper.registerResultToSubjectTable(examResult);
	}

	@Override
	public List<QnaBank> getQuestionInfoListByExamCode(String examCode, String currentSubject) {
		String currentMjrCode = null;
		switch (currentSubject) {
		case "smjrcc1":
			currentMjrCode = currentSubject;
			currentSubject = null;
			break;
		case "smjrcc2":
			currentMjrCode = currentSubject;
			currentSubject = null;
			break;
		case "smjrcc3":
			currentMjrCode = currentSubject;
			currentSubject = null;
			break;
		}

		return examMapper.getQuestionInfoListByExamCode(examCode, currentSubject, currentMjrCode);
	}

	@Override
	public List<ExamInfo> getSearchExamList(ExamInfo examInfo) {

		return examMapper.getSearchExamList(examInfo);
	}

	@Override
	public ExamInfo getExamInfoByExamCode(String examCode) {

		return examMapper.getExamInfoByExamCode(examCode);
	}

	@Override
	public List<ExamMappingQuestion> getExamQuestionInfobyExamCode(String examCode) {

		return examMapper.getExamQuestionInfobyExamCode(examCode);
	}

	@Override
	public List<ExamInfo> getRegisteredQustionExamList() {

		return examMapper.getRegisteredQustionExamList();
	}

	@Override
	public List<ExamAnalyse> getUserExamData(String userCode, String majorCode) {
		return examMapper.selectUserExamData(userCode, majorCode);
	}

}
