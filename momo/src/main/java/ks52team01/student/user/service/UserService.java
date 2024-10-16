package ks52team01.student.user.service;

import ks52team01.student.user.dto.User;

public interface UserService {
	

	public void userMyPage() ;
	
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

	public int userLoginAction(User user);
	
}
