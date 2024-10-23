package ks52team01.admin.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.admin.exam.dto.SubMirCate;
import ks52team01.admin.exam.dto.SubMjrCate;
import ks52team01.student.user.dto.User;

@Mapper
public interface AdminExamMapper {

	List<SubMirCate> getAdminExamCategoryList();

	List<User> getUserListByGrade(String gradeCode);

}
