package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class SubjectScore {

	private String subjectScoreCode;
	private String userCode;
	private String tookExamInfoCode;
	private String subMjrCatCode;
	private String subMirCatCode;
	private int    subjectScoreOrigin;
	private Date   subjectScoreRegTime;
	
	private SubjectMinorCategory subjectMinorCategory;
}
