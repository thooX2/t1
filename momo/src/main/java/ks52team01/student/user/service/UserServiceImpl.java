package ks52team01.student.user.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

import ks52team01.common.ResponseError;
import ks52team01.student.user.dto.User;
import ks52team01.student.user.dto.UserJoinInfo;
import ks52team01.student.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void userMyPage() {

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

	@Override
	public ResponseError userJoinCheck(UserJoinInfo userJoinInfo) {
		// TODO Auto-generated method stub
		ResponseError error = new ResponseError();
		error.setSuccess(true);
		
		// ID Check
		String idPattern = "^[a-zA-Z0-9]*$";
		Matcher matcher = Pattern.compile(idPattern).matcher(userJoinInfo.getUserId());
		if(!matcher.find()) {
			error.setErrorCode("IdError"); 
			error.setErrorMessage("사용 할 수 없는 아이디입니다.");
			error.setSuccess(false);
			return error;
		}
		if(userMapper.searchUser("user_id", userJoinInfo.getUserId())) {
			error.setErrorCode("IdError"); 
			error.setErrorMessage("이미 사용중인 아이디입니다.");
			error.setSuccess(false);
			return error;
		}
		
		// Password Check
		String pwPattern = "^[a-zA-Z0-9~`!@#$%\\\\^&*()-]*$";
		matcher = Pattern.compile(pwPattern).matcher(userJoinInfo.getUserPw());
		if(!matcher.find()) {
			error.setErrorCode("PwError"); 
			error.setErrorMessage("맞지 않는 비밀번호 형식입니다.");
			error.setSuccess(false);
			return error;
		}
		if(userJoinInfo.getUserPw().equals(userJoinInfo.getUserPwCheck())) {
			error.setErrorCode("PwError"); 
			error.setErrorMessage("비밀번호가 일치하지 않습니다.");
			error.setSuccess(false);
			return error;
		}
		
		// Name Check
		String NamePattern = "^[가-힣]*$";
		matcher = Pattern.compile(NamePattern).matcher(userJoinInfo.getUserName());
		if(!matcher.find()) {
			error.setErrorCode("NameError"); 
			error.setErrorMessage("이름을 한글로 입력해주세요.");
			error.setSuccess(false);
			return error;
		}
		
		// Phone Check
		if(userMapper.searchUser("user_email", userJoinInfo.getUserPhone())) {
			error.setErrorCode("PhoneError"); 
			error.setErrorMessage("입력한 핸드폰 번호로 가입된 정보가 있습니다.\n다른 번호를 사용하세요.");
			error.setSuccess(false);
			return error;
		}
		
		// Email Check
		if(userMapper.searchUser("userPhone", userJoinInfo.getUserEmail())) {
			error.setErrorCode("EmailError"); 
			error.setErrorMessage("입력한 이메일로 가입된 정보가 있습니다.\n다른 이메일을 사용하세요.");
			error.setSuccess(false);
			return error;
		}
		
		// BirthDate Check
		
		// Gender Check
		if(userJoinInfo.getUserGender() == 'f') {
			userJoinInfo.setUserGender('여');
		} else {
			userJoinInfo.setUserGender('남');
		}
		
		if(error.isSuccess()) userMapper.userJoinAction(userJoinInfo);
		
		return error;
	}
	
	
}
