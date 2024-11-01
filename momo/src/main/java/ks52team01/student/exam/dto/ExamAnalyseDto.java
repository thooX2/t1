package ks52team01.student.exam.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ExamAnalyseDto {
    private String subjectScoreCode; // 과목 점수 코드
    private String userCode;          // 회원 코드
    private String tookExamInfoCode;          // 응시 시험 코드
    private String majorCode;         // 대분류 코드
    private String minorCode;         // 중분류 코드
    private int subjectScoreOrigin;                // 과목 원 점수
    private String scoreRegTime;    // 채점 결과 시간
}
