package ks52team01.admin.exam.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class AdminExamInfo {

	private String examCode; // 모의고사코드
	private String userCode; // 회원코드
	private String examNm; // 모의고사명
	private String examType; // 모의고사유형
	private String examOeType; // 모의고사홀짝구분
	private String examTarGrd; // 모의고사대상학년
	private String examDescription; // 모의고사 설명
	private Date examDate; // 모의고사시행날짜
	private String examInst; // 모의고사출제기관
	private String userNm; // 회원이름
	private String userId; // 회원아이디

}
