package ks52team01.admin.exam.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class QnaBank {
	private String qnaCode; // 문항코드
	private String userCode; // 출제자 코드
	private String subMjrCatCode; // 과목 대분류 코드
	private String subMirCatCode; // 과목 중분류 코드 (nullable)
	private String qnaType; // 문항 유형
	private String qnaChap; // 문항 단원
	private String qnaSubject; // 문항제목
	private String qnaQst; // 문항 지문
	private String qnaSlt1; // 문항 선택지 1
	private String qnaSlt2; // 문항 선택지 2
	private String qnaSlt3; // 문항 선택지 3
	private String qnaSlt4; // 문항 선택지 4
	private String qnaSlt5; // 문항 선택지 5 (nullable)
	private int qnaAns; // 문항 정답 (선택지 번호)
	private int qnaScr; // 문항 배점
	private String qnaCmt; // 문항 해설
	private String qnaCurExamState; // 현생시험 사용여부
	private Timestamp qnaCreateTime; // 문항 생성 시간
	private Timestamp qnaUpdateTime; // 문항 수정 시간 (nullable)
	private String searchKeyword; // 문항리스트 검색
	private String searchType; // 문항리스트 검색타입
	private String subMjrCatNm; // 문항 대분류명
	private String subMirCatNm; // 문항 중분류명
	private String userId;
	private String userName;
}
