package com.tech.miaa.dao;

import java.util.ArrayList;
import java.util.List;

import com.tech.miaa.dto.AdminMemberDto;
import com.tech.miaa.dto.AdminMemberSearchDto;
import com.tech.miaa.dto.MemberDto;

public interface AdminMemberDao {
	public void admin_join(String id, String shpwd, String bcpwd,
	String email);
	public int admin_idcheck(String id);
	public int admin_emailcheck(String email);
	public int admin_login1(String id, String bcpwd);
	public AdminMemberDto admin_login2(String id, String bcpwd);
	public ArrayList<MemberDto> getAdminMembers();
	public List<AdminMemberDto> getJoinedMembers(AdminMemberSearchDto dto);
	public int get_total(AdminMemberSearchDto dto);
	public void login_date_update(String id);
	public int joined_member_delete_for_ajax(List<String> chkValList);
	public int joined_member_delete2_for_ajax(List<String> chkValList);
}
