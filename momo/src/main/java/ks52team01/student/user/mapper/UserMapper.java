package ks52team01.student.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.user.dto.User;

@Mapper
public interface UserMapper {

	public void userMyPage();

	public void loginAction();

	public void logoutAction();

	public void userInfoModify();

	public void userInfoModifyAction();

	public void userJoinAction();

	public void userInfoDetailAction();

	public void userDeleteAction();

	public void userFindIdAction();

	public void userFindPwAction();

	public User getUserById(User user);
}
