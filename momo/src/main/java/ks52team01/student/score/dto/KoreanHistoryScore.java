package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class KoreanHistoryScore {
	
	private String korHisScrCode;
	private String userCode;
	private String examCode;
	private String korHisSubjectScoreCode;
	private String korHisStdScr;
	private String korHisPct;
	private int    korHisGrd;
	private int    korHisRanking;
	private Date   korHisScrCreateTime;
	private Date   korHisScrUpdateTime;
	
	private SubjectScore subjectScore;
	private SubjectMajorCategory subjectMajorCategory;
	private SubjectMinorCategory subjectMinorCategory;
}
