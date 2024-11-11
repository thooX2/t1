package ks52team01.admin.user.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

	public void adminPage();

	public void adminLoginMove();

	public void adminLogoutAction();

	public void adminInfoModifyAction();

	public void adminJoinAction();

	public void adminInfoDetailAction();

	public void adminDeleteAction();

	public void adminFindIdAction();

	public void adminFindPwAction();
}
