package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Getter
@Setter*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	private String user_id;
	private String user_shpwd;	
	private String user_bcpwd;
	private String user_email;
	private int user_postcode;
	private String user_address;
	private String user_detailaddress;
	private String user_grade;
	private String user_tel;
	private String user_join_date;
	private String user_last_login;
	
	
	
	
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
	public int getUser_postcode() {
		return user_postcode;
	}
	public void setUser_postcode(int user_postcode) {
		this.user_postcode = user_postcode;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_detailaddress() {
		return user_detailaddress;
	}
	public void setUser_detailaddress(String user_detailaddress) {
		this.user_detailaddress = user_detailaddress;
	}
}
