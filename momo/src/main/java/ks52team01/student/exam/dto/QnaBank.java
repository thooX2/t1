package ks52team01.student.exam.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class QnaBank {

	private String ExamMappingQuestionCode;
	private String ExamCode;
	private String ExamQnaCode;
	private String SubMjrCatCode;
	private String SubMirCatNm;
	private String SubMirCatCode;
	private String ExamQnaTypeNm;
	private String QnaType;
	private String ExamQnaChapNm;
	private String QnaChap;
	private String QnaSubject;
	private String QnaQst;
	private String QnaSlt1;
	private String QnaSlt2;
	private String QnaSlt3;
	private String QnaSlt4;
	private String QnaSlt5;
	private String QnaAns;
	private Integer QnaScr;
	private String QnaCmt;
	private Timestamp QnaCreateTime;

}
