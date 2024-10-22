package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ExamScore {
	
	private String 									examScrCode;
	private String 									userCode;
	private String 									areaCityCode;
	private String 									examCode;
	private String 									korScrCode;
	private String 									mathScrCode;
	private String 									engScrCode;
	private String 									korHisScrCode;
	private String 									inq1ScrCode;
	private String 									inq2ScrCode;
	private String 									frnScrCode;
	private String 									tmp1ScrCode;
	private String 									tmp2ScrCode;
	private Date   									examScrCreateTime;
	private Date   									examScrUpdateTime;
	
	private KoreanScore 							koreanScore;
	private MathScore 								mathScore;
	private EnglishScore 							englishScore;
	private KoreanHistoryScore						koreanHistoryScore;
	private Inquiry1Score 							inquiry1Score;
	private Inquiry2Score 						    inquiry2Score;
	private SecondLanguageAndChineseCharactersScore secondLanguageAndChineseCharactersScore;
	
	private SubjectMajorCategory 					subjectMajorCategory;
	private SubjectMinorCategory 					subjectMinorCategory;
}
