package ks52team01.admin.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.user.dto.User;

@Mapper
public interface AdminMapper {

	public User getAdminById(String userId, String userPw);
}
