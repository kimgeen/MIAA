package com.tech.miaa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tech.miaa.email.Email;
import com.tech.miaa.email.EmailSender;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tech.miaa.dao.MemberDao;
import com.tech.miaa.dto.MemberDto;
import com.tech.miaa.service.MemberService;
import com.tech.miaa.serviceInter.MemberServiceInter;

@Controller
public class MemberController {
	@Autowired
	private SqlSession sqlSession;
	MemberServiceInter memberServiceInter;
	@Autowired
	private Email setemail;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping("loginform")
	public String loginform(HttpServletRequest request, Model model) {
		return "login.loginform_page.로그인 페이지.1";
	}
	@RequestMapping("joinform")
	public String joinform(HttpServletRequest request, Model model) {
		return "login.joinform_page.회원가입 페이지.1";
	}
	@RequestMapping("searchidform")
	public String searchidform(HttpServletRequest request, Model model) {
		return "login.searchidform.아이디 찾기 페이지.1";
	}
	@RequestMapping("searchpwform")
	public String searchpwform(HttpServletRequest request, Model model) {
		return "login.searchpwform.비밀번호 찾기 페이지.1";
	}
	@RequestMapping("mypageform")
	public String mypageform(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId) {
		HttpSession session = request.getSession(false);
		model.addAttribute("userId",userId);
		return "login.mypageform.마이 페이지.3";
	}
	@RequestMapping("mypage_delete_account_page")
	public String mypage_delete_account_page(HttpServletRequest request, Model model) {
		return "login.mypage_delete_account_page.마이 페이지.3";
	}
	@RequestMapping("mypage_modify_account_page")
	public String mypage_modify_account_page(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class); MemberDto dto = dao.getMember(userId);
		model.addAttribute("dto", dto);
		return "login.mypage_modify_account_page.회원정보수정.3";
	}

	@ResponseBody
	@RequestMapping("idcheck")
	public int idcheck(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		memberServiceInter=new MemberService();
		
		int num=memberServiceInter.idchek(model);
		
		return num;
	}
	
	@ResponseBody
	@RequestMapping("emailchk")
	public int emailchk(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		memberServiceInter=new MemberService();
		
		int num=memberServiceInter.emailchk(model);
		
		return num;
	}
	//회원정보 수정시의 emailchk2 추가 0425 김영빈
	@ResponseBody
	@RequestMapping("emailchk2")
	public int emailchk2(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		memberServiceInter=new MemberService();
		
		int num=memberServiceInter.emailchk2(model);
		
		return num;
	}

	@ResponseBody
	@RequestMapping("searchid")
	public String searchid(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		memberServiceInter=new MemberService();
		
		String fineid=memberServiceInter.searchid(model);
		
		return fineid;
	}
	
	@ResponseBody
	@RequestMapping("searchpw")
	public String searchpw(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("setemail",setemail);
		model.addAttribute("emailSender",emailSender);
		model.addAttribute("mailSender",mailSender);
		memberServiceInter=new MemberService();
		
		String finepw = memberServiceInter.searchpw(model);
		
		return finepw;
	}
	
	@RequestMapping("join")
	public String join(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		memberServiceInter=new MemberService();
		
		String result=memberServiceInter.join(model);
		
		return result;
	}
	@RequestMapping("modify_account")
	public String modify_account(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		memberServiceInter=new MemberService();
		
		String result=memberServiceInter.modify_account(model);
		
		return result;
	}
	
	@RequestMapping("del_account")
	public String del_account(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId) {
		HttpSession session = request.getSession(false);
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId",userId);
		memberServiceInter=new MemberService();
		
		memberServiceInter.del_account(model);
		
		session.invalidate();	
		return "redirect:/";
	}
	
	@RequestMapping("login")
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		memberServiceInter=new MemberService();
		
		String result=memberServiceInter.login(model);
		
		
		return result;
	}
	@RequestMapping("logout")
	public String logout(HttpServletRequest request, @SessionAttribute(name = "userId", required = false) String userId) {
		HttpSession session = request.getSession(false);
		if(userId != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}