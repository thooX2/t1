package ks52team01.admin.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.admin.exam.dto.SubMjrCateDTO;

@Mapper
public interface AdminExamMapper {

	List<SubMjrCateDTO> getAdminExamCategoryList();

}
