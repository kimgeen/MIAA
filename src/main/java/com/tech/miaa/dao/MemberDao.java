package com.tech.miaa.dao;

import com.tech.miaa.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;

public interface MemberDao {
	public void join(String id, String shpwd, String bcpwd,
	String email, String postcode, String address, String detailAddress,String tel);
	public void modify_account(String id, String shpwd, String bcpwd,
			String email, String postcode, String address, String detailAddress,String tel);
	public int idcheck(String id);
	public int emailcheck(String email);
	//회원정보 수정시의 emailchk2 추가 0425 김영빈
	public int emailcheck2(String email, String id);
	public String searchid(String email);
	public void del_account(String bcpwd,String id);
	public String searchpw1(String id, String email);
	public String searchpw2(String id, String email);
	public int login1(String id, String bcpwd);
	public MemberDto login2(String id, String bcpwd);
	public MemberDto getMember(String id);
	public ArrayList<MemberDto> getMembers();
	public void login_date_update(String id);
}
