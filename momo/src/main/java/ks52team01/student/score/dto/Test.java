package ks52team01.student.score.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Test {
	private String subjectScoreCode;
	private String userCode;
	private String tookExamInfoCode;
	private String subMjrCatCode;
	private String subMirCatCode;
	private int subjectScoreOrigin;
	private Timestamp subjectScoreRegTime;
}
