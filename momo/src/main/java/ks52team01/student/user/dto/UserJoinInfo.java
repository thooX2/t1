package ks52team01.student.user.dto;

import lombok.Data;

@Data
public class UserJoinInfo {
	private String userId;
	private String userPw;
	private String userPwCheck;
	private String userName;
	private String userZip;
	private String userAddress;
	private String userDetailAddress;
	private String userPhone;
	private String userEmail;
	private String userBirthDate;
	private char userGender;
}
