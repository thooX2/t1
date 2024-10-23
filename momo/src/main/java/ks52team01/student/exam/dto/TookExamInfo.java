package ks52team01.student.exam.dto;

import lombok.Data;

@Data
public class TookExamInfo {

	private String tookExamInfoCode;
	private String userCode;
	private String areaCode;
	private String areaCityCode;
	private String examCode;
	private String korSltSubMjr;
	private String korSltSub;
	private String mathSltSubMjr;
	private String mathSltSub;
	private String inq1SltSubMjr;
	private String inq1SltSub;
	private String inq2SltSubMjr;
	private String inq2SltSub;
	private String engSltSubMjr;
	private String engSltSub;
	private String korHisSltSubMjr;
	private String korHisSltSub;
	private String frnSltSubMjr;
	private String frnSltSub;
	
	private ExamInfo examInfo;
}
