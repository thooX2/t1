package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class SecondLanguageAndChineseCharactersScore {
	
	private String frnScrCode;
	private String userCode;
	private String examCode;
	private String frnSltSub;
	private String frnSubjectScoreCode;
	private int    frnStdScr;
	private int    frnPct;
	private int    frnGrd;
	private int    frnRanking;
	private Date   frnScrCreateTime;
	private Date   frnScrUpdateTime;
	
	private SubjectScore subjectScore;
	private SubjectMinorCategory subjectMinorCategory;
}
