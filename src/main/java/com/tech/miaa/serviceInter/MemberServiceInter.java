package com.tech.miaa.serviceInter;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.tech.miaa.dto.MemberDto;

public interface MemberServiceInter {
	public String join(Model model);
	public String modify_account(Model model);
	public String del_account(Model model);
	public int idchek(Model model);
	public int emailchk(Model model);
	public String searchid(Model model);
	public String searchpw(Model model);
	public String login(Model model);
	//회원정보 수정시의 emailchk2 추가 0425 김영빈
	public int emailchk2(Model model);
}
