package ks52team01.admin.exam.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AdminExamQnaChap {

	private String examQnaChapCode; // 문항유형코드
	private String userCode; // 등록유저코드
	private String subMjrCatCode; // 과목대분류코드
	private String subMirCatCode; // 과목중분류코드
	private String examQnaChapNm; // 문항유형명
	private Timestamp examQnaChapNmCreateDate; // 등록날짜
	private String subMirCatNm; // 과목중분류이름
	private String subMjrCatNm; // 과목중분류이름

}
