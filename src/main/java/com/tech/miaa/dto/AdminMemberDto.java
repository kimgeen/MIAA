package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Getter
@Setter*/
@NoArgsConstructor
@AllArgsConstructor
public class AdminMemberDto {
	private String user_id;
	private String user_shpwd;	
	private String user_bcpwd;
	private String user_email;
	private MemberDto member;
	
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_shpwd() {
		return user_shpwd;
	}
	public void setUser_shpwd(String user_shpwd) {
		this.user_shpwd = user_shpwd;
	}
	public String getUser_bcpwd() {
		return user_bcpwd;
	}
	public void setUser_bcpwd(String user_bcpwd) {
		this.user_bcpwd = user_bcpwd;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public MemberDto getMember() {
		return member;
	}
	public void setMember(MemberDto member) {
		this.member = member;
	}

	
}
