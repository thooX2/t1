package ks52team01.student.score.dto;

import lombok.Data;

@Data
public class Inquiry2Score {
	private String tookExamInfoCode;
	private String subMirCatNm;
	private int subjectScoreOrigin;
	private int inq2StdScr;
	private int inq2Pct;
	private int inq2Grd;
	private int inq2Ranking;
}
