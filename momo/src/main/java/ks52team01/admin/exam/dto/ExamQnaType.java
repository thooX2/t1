package ks52team01.admin.exam.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ExamQnaType {

	private String examQnaTypeCode; // 문항유형코드
	private String subMjrCatCode; // 과목
	private String subMirCatCode; // 중분류
	private String userCode; // 등록유저코드
	private String examQnaTypeNm; // 문항유형명
	private Timestamp examQnaTypeCreateDate; // 등록날짜

}
