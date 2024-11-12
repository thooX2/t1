package ks52team01.admin.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.user.dto.User;

@Mapper
public interface AdminMapper {

	public void adminPage();

	public void adminLoginMove();

	public void adminLogoutAction();

	public void adminInfoModifyAction();

	public void adminJoinAction();

	public void adminInfoDetailAction();

	public void adminDeleteAction();

	public void adminFindIdAction();

	public void adminFindPwAction();

	public User getAdminById(String userId, String userPw);
}
