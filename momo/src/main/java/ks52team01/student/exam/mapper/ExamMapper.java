package ks52team01.student.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ks52team01.student.exam.dto.ExamAnalyseDto;
import ks52team01.student.exam.dto.TookExamInfo;

@Mapper
public interface ExamMapper {
	//
	 List<ExamAnalyseDto> selectUserExamData(@Param("userCode") String userCode, @Param("majorCode") String majorCode);
	// 회원이 응시한 모의고사 목록 조회
	List<TookExamInfo> getTookExamList(String userCode);
	
	// 회원이 최초로 응시한 모의고사 목록 조회
	List<TookExamInfo> getFirstTookExamList(String userCode);
}
