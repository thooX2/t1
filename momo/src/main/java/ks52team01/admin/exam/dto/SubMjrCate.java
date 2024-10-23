package ks52team01.admin.exam.dto;

import java.util.List;

import lombok.Data;

@Data
public class SubMjrCate {
	private String subMjrCatCode; // 과목대분류코드
	private String subMjrCatNm; // 과목대분류명
	private int subExamTime; // 과목시험시간
	private int subExamOrder; // 과목시험순서
	private int subQstNum; // 과목문항수
	private int subQstTotalScr; // 과목총점
	private String curExamUserState; // 현행시험 사용여부

	private List<SubMirCate> subMirCateList;
}
