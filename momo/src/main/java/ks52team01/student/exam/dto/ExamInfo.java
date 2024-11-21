package ks52team01.student.exam.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class ExamInfo {

	private String examCode;
	private String userCode;
	private String examNm;
	private String examType;
	private String examOEType;
	private String examTarGrd;
	private String examDescription;
	private Date examDate;
	private String examInst;

	private int registeredQuestionCount;
	private String userId;
	private String userName;
	private String beginYear;
	private String endYear;
	private boolean monthAll;
	private List<String> subj;
	private List<String> month;
	private String examLike;
	private String examHate;
}
