package ks52team01.student.score.dto;

import lombok.Data;

@Data
public class KoreanScore {
	private String tookExamInfoCode;
	private String subMirCatNm;
	private int subjectScoreOrigin;
	private int korStdScr;
	private int korPct;
	private int korGrd;
	private int korRanking;
}
