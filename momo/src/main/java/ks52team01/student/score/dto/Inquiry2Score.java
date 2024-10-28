package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Inquiry2Score {

	private String inq2ScrCode;
	private String userCode;
	private String examCode;
	private String inq2SltSub;
	private String inq2subjectScoreCode;
	private int	   inq2StdScr;
	private int    inq2Pct;
	private int    inq2Grd;
	private int    inq2Ranking;
	private Date   inq2ScrCreateTime;
	private Date   inq2ScrUpdateTime;
	
	private SubjectScore subjectScore;
	private SubjectMinorCategory subjectMinorCategory;
}