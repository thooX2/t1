package ks52team01.student.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks52team01.student.user.dto.User;
import ks52team01.student.user.dto.UserJoinInfo;

@Mapper
public interface UserMapper {

	public void userJoinAction(UserJoinInfo userJoinInfo);

	public User getUserById(User user);

	public boolean searchUser(String searchType, String searchValue);

	public String searchAreaCode(String userAddress);
}
