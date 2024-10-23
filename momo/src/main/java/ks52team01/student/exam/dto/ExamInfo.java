package ks52team01.student.exam.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ExamInfo {
	
	private String examCode;
	private String userCode;
	private String examNm;
	private String examType;
	private String examOEType;
	private String examTarGrd;
	private Date examDate;
	private String examInst;
}
