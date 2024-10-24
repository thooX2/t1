package ks52team01.admin.exam.dto;

import lombok.Data;

@Data
public class SubMirCate {
	// 과목중분류코드
	private String subMirCatCode;

	// 과목대분류코드
	private String subMjrCatCode;

	// 과목중분류명
	private String subMirCatNm;

	// 공통선택
	private String commSlt;

	// 현행시험 사용여부(subject_major_category)
	private String curExamUserState;
	
	// 과목대분류
	private String subMjrName;
	
	// 현행시험 사용여부(subject_minor_category)
	private String subMirState;
	
	private SubMjrCate subMjrCate; 
}
