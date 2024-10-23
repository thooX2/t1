package ks52team01.admin.exam.service;

import java.util.List;

import ks52team01.admin.exam.dto.SubMirCate;
import ks52team01.student.user.dto.User;

public interface AdminExamService {

	List<SubMirCate> getAdminExamCategoryList();

	List<User> getUserListByGrade(String gradeCode);

}
