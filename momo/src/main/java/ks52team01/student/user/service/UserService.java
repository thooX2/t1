package ks52team01.student.user.service;

import ks52team01.common.ResponseError;
import ks52team01.student.user.dto.User;
import ks52team01.student.user.dto.UserJoinInfo;

public interface UserService {

	public User getUserById(User user);

	public int userLoginAction(User user);

	public ResponseError userJoinCheck(UserJoinInfo userJoinData);
	
}
