package ks52team01.student.score.dto;

import lombok.Data;

@Data
public class MathScore {
	private String tookExamInfoCode;
	private String subMirCatNm;
	private int subjectScoreOrigin;
	private int mathStdScr;
	private int mathPct;
	private int mathGrd;
	private int mathRanking;
}
