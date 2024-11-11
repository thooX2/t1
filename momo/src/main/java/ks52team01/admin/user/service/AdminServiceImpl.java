package ks52team01.admin.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks52team01.admin.user.mapper.AdminMapper;
import ks52team01.student.user.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AdminServiceImpl implements AdminService {

	private final AdminMapper adminMapper;

	@Override
	public void adminPage() {

	}

	@Override
	public void adminLoginMove() {

	}

	@Override
	public void adminLogoutAction() {

	}

	@Override
	public void adminInfoModifyAction() {

	}

	@Override
	public void adminJoinAction() {

	}

	@Override
	public void adminInfoDetailAction() {

	}

	@Override
	public void adminDeleteAction() {

	}

	@Override
	public void adminFindIdAction() {

	}

	@Override
	public void adminFindPwAction() {

	}

	@Override
	public int adminLoginAction(String userId, String userPw) {
		// 사용자 ID로 유저 정보를 조회합니다.
		User foundUser = adminMapper.getAdminById(userId, userPw);
		
		// 1. 아이디가 존재하지 않는 경우
		if (foundUser == null || foundUser.getUserId() == null) {
			return -1; // 아이디 없음
		}

		// 2. 비밀번호가 틀린 경우
		if (!userPw.equals(foundUser.getUserPw())) {
			return 0; // 비밀번호 틀림
		}

		// 3. 로그인 성공
		return 1; // 로그인 성공
	}
}
