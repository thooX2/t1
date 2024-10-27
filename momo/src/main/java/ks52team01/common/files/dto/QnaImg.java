package ks52team01.common.files.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QnaImg {
	private String qnaImgCode; // 문항이미지코드
	private String qnaCode; // 문항코드
	private String userCode; // 회원코드
	private String qnaImgType; // 문항이미지유형
	private String qnaImgPath; // 문항이미지경로
	private int qnaImgSortCol; // 문항이미지정렬컬럼
	private String qnaImgOriginalName; // 이미지파일원래이름
	private String qnaImgNewName; // 이미지파일새이름
	private Long qnaFileSize; // 이미지파일크기
	private Timestamp qnaImgCreateTime; // 문항이미지생성시간
	private Timestamp qnaImgUpdateTime; // 문항이미지수정시간
}
