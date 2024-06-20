package com.tech.miaa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tech.miaa.dto.AdminDataDto1;
import com.tech.miaa.dto.AdminInquirySearchDto;
import com.tech.miaa.service.AdminInquiryService;
import com.tech.miaa.service.AdminMainDataService;
import com.tech.miaa.serviceInter.AdminInquiryServiceInter;
import com.tech.miaa.serviceInter.AdminMainDataServiceInter;
import com.tech.miaa.vopage.PageVO;

@Controller
public class AdminMainController {
	@Autowired
	private SqlSession sqlSession;

	AdminMainDataServiceInter adminMainDataServiceInter;
	

//	문의내역 페이지
	@RequestMapping("admin_main_page")
	public String admin_main_page(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId,
			@SessionAttribute(name = "isAdmin", required = false) String isAdmin) {
		String result = "redirect:/";
		
		//접속자가 관리자인지 확인 후 뷰단경로 처리
		if (isAdmin == null) {		
			if (userId != null) {
				System.out.println("관리자아이디가 아닙니다");
				System.out.println("로그인 유저의 id : " + userId);
			} else if (userId == null) {
				System.out.println("로그인 하지 않았습니다.");
			}
		}
		else if (isAdmin.equals("admin")) {
			System.out.println("관리자입니다.");
			result = "admin.main_page.관리자페이지.1a";
		}
		//싱글톤위한 값 전달
		model.addAttribute("userId", userId);
		model.addAttribute("IsAdmin", isAdmin);
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);

		
		//inquiry 조인 테이블 가져오와서 모델에 넘기기
		adminMainDataServiceInter=new AdminMainDataService();
		try {
			adminMainDataServiceInter.get_main_data(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return result;
	}
	

}