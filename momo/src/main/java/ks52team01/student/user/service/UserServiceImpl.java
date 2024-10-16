package ks52team01.student.user.service;

import org.springframework.stereotype.Service;

import ks52team01.student.user.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private final ks52team01.student.user.mapper.UserMapper userMapper;

	public UserServiceImpl(ks52team01.student.user.mapper.UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void userMyPage() {

	}

	@Override
	public void loginAction() {

	}

	@Override
	public void logoutAction() {

	}

	@Override
	public void userInfoModify() {

	}

	@Override
	public void userInfoModifyAction() {

	}

	@Override
	public void userJoinAction() {

	}

	@Override
	public void userInfoDetailAction() {

	}

	@Override
	public void userDeleteAction() {

	}

	public void userFindIdAction() {

	}

	public void userFindPwAction() {

	}

	@Override
	public User getUserById(User user) {

		return userMapper.getUserById(user);

	}

	@Override
	public int userLoginAction(User user) {

		// 사용자 ID로 유저 정보를 조회합니다.
		User foundUser = userMapper.getUserById(user);

		// 1. 아이디가 존재하지 않는 경우
		if (foundUser == null || foundUser.getUserId() == null) {
			return -1; // 아이디 없음
		}

		// 2. 비밀번호가 틀린 경우
		if (!user.getUserPw().equals(foundUser.getUserPw())) {
			return 0; // 비밀번호 틀림
		}

		// 3. 로그인 성공
		return 1; // 로그인 성공
	}
}
