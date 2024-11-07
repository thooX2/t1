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
	private Double subjectOriginalScoreNationAvg;
	private Double subjectOriginalScoreProvinceAvg;
	private Double subjectOriginalScoreMunicipalityAvg;
	private int    subjectStandardScore;
	private Double subjectStandardScoreNationAvg;
	private Double subjectStandardScoreProvinceAvg;
	private Double subjectStandardScoreMunicipalityAvg;
	private int    subjectPercent;
	private Double subjectPercentNationAvg;
	private Double subjectPercentProvinceAvg;
	private Double subjectPercentMunicipalityAvg;
	private int    subjectGrade;
	private Double subjectGradeNationAvg;
	private Double subjectGradeProvinceAvg;
	private Double subjectGradeMunicipalityAvg;
	private int    subjectRank;
	private Double subjectRankNationAvg;
	private Double subjectRankProvinceAvg;
	private Double subjectRankMunicipalityAvg;
}
