package ks52team01.student.user.dto;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class User {
	private String userCode;
	private String userId;
	private String gradeCode;
	private String areaCityCode;
	private String userPw;
	private String userEmail;
	private String userAddress;
	private String userDetailAddress;
	private String userPhone;
	private String userName;
	private Date userBirthDate;
	private String userGender;
	private Timestamp userSignDate;
	private Timestamp userUpdateDate;
	private Timestamp userDeleteDate;
	private boolean userDormantStatus;
	private boolean userDeleteStatus;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getAreaCityCode() {
		return areaCityCode;
	}

	public void setAreaCityCode(String areaCityCode) {
		this.areaCityCode = areaCityCode;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserDetailAddress() {
		return userDetailAddress;
	}

	public void setUserDetailAddress(String userDetailAddress) {
		this.userDetailAddress = userDetailAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserBirthDate() {
		return userBirthDate;
	}

	public void setUserBirthDate(Date userBirthDate) {
		this.userBirthDate = userBirthDate;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Timestamp getUserSignDate() {
		return userSignDate;
	}

	public void setUserSignDate(Timestamp userSignDate) {
		this.userSignDate = userSignDate;
	}

	public Timestamp getUserUpdateDate() {
		return userUpdateDate;
	}

	public void setUserUpdateDate(Timestamp userUpdateDate) {
		this.userUpdateDate = userUpdateDate;
	}

	public Timestamp getUserDeleteDate() {
		return userDeleteDate;
	}

	public void setUserDeleteDate(Timestamp userDeleteDate) {
		this.userDeleteDate = userDeleteDate;
	}

	public boolean isUserDormantStatus() {
		return userDormantStatus;
	}

	public void setUserDormantStatus(boolean userDormantStatus) {
		this.userDormantStatus = userDormantStatus;
	}

	public boolean isUserDeleteStatus() {
		return userDeleteStatus;
	}

	public void setUserDeleteStatus(boolean userDeleteStatus) {
		this.userDeleteStatus = userDeleteStatus;
	}

}
