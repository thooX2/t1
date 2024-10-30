package ks52team01.student.score.dto;

import lombok.Data;

@Data
public class Subject {
	private String tookExamInfoCode;
	private String subjectMajorCategoryCode;
	private String subjectMinorCategoryCode;
	private String subjectMajorCategoryName;
	private String subjectMinorCategoryName;
	private int    subjectOriginalScore;
	private int    subjectStandardScore;
	private int    subjectPercent;
	private int    subjectGrade;
	private int    subjectRank;
}
