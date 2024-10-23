package ks52team01.student.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.exam.dto.TookExamInfo;

@Mapper
public interface ExamMapper {

	// 회원이 응시한 모의고사 목록 조회
	List<TookExamInfo> getTookExamList(String userCode);
}
