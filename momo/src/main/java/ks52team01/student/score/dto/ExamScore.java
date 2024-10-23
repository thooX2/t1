package ks52team01.student.score.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ExamScore {
	
	private KoreanScore 							koreanScore;
	private MathScore 								mathScore;
	private EnglishScore 							englishScore;
	private KoreanHistoryScore						koreanHistoryScore;
	private Inquiry1Score 							inquiry1Score;
	private Inquiry2Score 						    inquiry2Score;
	private SecondLanguageAndChineseCharactersScore secondLanguageAndChineseCharactersScore;
}
