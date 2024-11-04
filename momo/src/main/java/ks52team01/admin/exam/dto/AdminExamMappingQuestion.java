package ks52team01.admin.exam.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class AdminExamMappingQuestion {

	private String examMappingQuestionCode;
	private String userCode;
	private String selectedExamCode;
	private List<String> totalQuestionList;
	private Timestamp examMappingQuestionRegTime;
	private String registeredQuestion;

	// pk구현용 변수
	private int examMappingQuestionNumber;
}
