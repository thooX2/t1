package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MathScore {
	
	private String mathScrCode;
	private String userCode;
	private String examCode;
	private String mathSltSub;
	private String mathSubjectScoreCode;
	private int    mathStdScr;
	private int    mathPct;
	private int    mathGrd;
	private int    mathRanking;
	private Date   mathScrCreateTime;
	private Date   mathScrUpdateTime;
	
	private SubjectScore subjectScore;
	private SubjectMajorCategory subjectMajorCategory;
	private SubjectMinorCategory subjectMinorCategory;
}
