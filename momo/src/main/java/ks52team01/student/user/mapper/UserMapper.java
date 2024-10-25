package ks52team01.student.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.user.dto.User;
import ks52team01.student.user.dto.UserJoinInfo;

@Mapper
public interface UserMapper {

	public void userMyPage();

	public void userInfoModify();

	public void userInfoModifyAction();

	public void userJoinAction(UserJoinInfo userJoinInfo);

	public void userInfoDetailAction();

	public void userDeleteAction();

	public void userFindIdAction();

	public void userFindPwAction();

	public User getUserById(User user);

	public boolean searchUser(String searchType, String searchValue);

	public String searchAreaCode(String userAddress);
}
