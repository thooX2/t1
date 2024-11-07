package ks52team01.student.exam.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ExamMappingQuestion {

	private String examMappingQuestionCode; // exam_mapping_question_code
	private String userCode; // user_code
	private String examCode; // exam_code
	private String examQnaCode; // exam_qna_code
	private Timestamp examMappingQuestionRegTime; // exam_mapping_question_reg_time

	private String subMjrCatCode;
	private String subMirCatNm;

}
