package ks52team01.admin.user.service;

public interface AdminService {

	public void adminPage();
	
	public void adminLoginMove() ;
	
	public void adminLogoutAction();
	
	public void adminInfoModifyAction();
	
	public void adminJoinAction();
	
	public void adminInfoDetailAction();
	
	public void adminDeleteAction();
	
	public void adminFindIdAction();
	
	public void adminFindPwAction();

	public int adminLoginAction(String userId, String userPw);
}
