package ks52team01.student.exam.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ExamSubjectResult {

	private String userCode;
	private String examCode;
	private String tableName;
	private String subMjrCatCode;
	private String preCode;
	private String pkColumnName;
	private int maxNumber;

	List<String> qnaCode;
	List<String> userAnswer;

}
