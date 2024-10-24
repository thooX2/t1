package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Inquiry1Score {

	private String inq1ScrCode;
	private String userCode;
	private String examCode;
	private String inq1SltSub;
	private String inq1subjectScoreCode;
	private int	   inq1StdScr;
	private int    inq1Pct;
	private int    inq1Grd;
	private int    inq1Ranking;
	private Date   inq1ScrCreateTime;
	private Date   inq1ScrUpdateTime;
	
	private SubjectScore subjectScore;
	private SubjectMinorCategory subjectMinorCategory;
}