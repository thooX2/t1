package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class KoreanScore {
	
	private String korScrCode;
	private String userCode;
	private String examCode;
	private String korSltSub;
	private String korSubjectScoreCode;
	private int    StdScr;
	private int    korPct;
	private int    korGrd;
	private int    korRanking;
	private Date   korScrCreateTime;
	private Date   korScrUpdateTime;

	private SubjectScore subjectScore;
	private SubjectMajorCategory subjectMajorCategory;
	private SubjectMinorCategory subjectMinorCategory;
}
