package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class EnglishScore {
	
	private String engScrCode;
	private String userCode;
	private String examCode;
	private String engSubjectScoreCode;
	private int    engStdScr;
	private int    engPct;
	private int    engGrd;
	private int    engRanking;
	private Date   engScrCreateTime;
	private Date   engScrUpdateTime;
	
	private SubjectScore subjectScore;
	private SubjectMajorCategory subjectMajorCategory;
	private SubjectMinorCategory subjectMinorCategory;
}
