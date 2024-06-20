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

import com.tech.miaa.dto.AdminInquirySearchDto;
import com.tech.miaa.service.AdminInquiryService;
import com.tech.miaa.serviceInter.AdminInquiryServiceInter;
import com.tech.miaa.vopage.PageVO;

@Controller
public class AdminInquiryController {
	@Autowired
	private SqlSession sqlSession;

	AdminInquiryServiceInter adminInquiryInter;
	

//	문의내역 페이지
	@RequestMapping("admin_inquiry_list_page")
	public String admin_inquiry_list_page(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId,
			@SessionAttribute(name = "isAdmin", required = false) String isAdmin , PageVO pageVo, @ModelAttribute("dto") AdminInquirySearchDto dto) {
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
			result = "admin_inquiry.list_page.1대1문의관리.3a";
		}
		//싱글톤위한 값 전달
		model.addAttribute("userId", userId);
		model.addAttribute("IsAdmin", isAdmin);
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("pageVo",pageVo);
		
		//inquiry 조인 테이블 가져오와서 모델에 넘기기
		adminInquiryInter=new AdminInquiryService();
		try {
			adminInquiryInter.inquiry_list(model,pageVo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return result;
	}
	
	@RequestMapping("admin_inquiry_detail_page")
	public String admin_inquiry_detail_page(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId,
			@SessionAttribute(name = "isAdmin", required = false) String isAdmin , @ModelAttribute("dto") AdminInquirySearchDto dto) {
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
			result = "admin_inquiry.detail_page.1대1문의글 상세페이지.2a";
		}
		
		//싱글톤위한 값 전달
		model.addAttribute("userId", userId);
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		
		//inquiry 조인 테이블 가져오와서 모델에 넘기기
		adminInquiryInter=new AdminInquiryService();
		try {
			adminInquiryInter.inquiry_detail_page(model);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	@RequestMapping("admin_inquiry_write_page")
	public String admin_inquiry_write_page(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId,
			@SessionAttribute(name = "isAdmin", required = false) String isAdmin , @ModelAttribute("dto") AdminInquirySearchDto dto) {
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
			result = "admin_inquiry.write_page.1대1문의글 상세페이지.2a";
		}

		//싱글톤위한 값 전달
		model.addAttribute("userId", userId);
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		
		//inquiry 조인 테이블 가져오와서 모델에 넘기기
		adminInquiryInter=new AdminInquiryService();
		try {
			adminInquiryInter.inquiry_write_page(model);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return result;
	}
	@RequestMapping("admin_inquiry_write")
	public String admin_inquiry_write(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId,
			@SessionAttribute(name = "isAdmin", required = false) String isAdmin , @ModelAttribute("dto") AdminInquirySearchDto dto, RedirectAttributes redAttri) {
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
			result = "redirect:admin_inquiry_detail_page";
		}
		
		//싱글톤위한 값 전달
		model.addAttribute("userId", userId);
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		
		//inquiry 조인 테이블 가져오와서 모델에 넘기기
		adminInquiryInter=new AdminInquiryService();
		try {
			adminInquiryInter.inquiry_write(model);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//redirectAttribute에 데이터 담기 
		adminInquiryInter.redirect_data_set_for_write(model,redAttri);
		
		
		
		System.out.println(result);
		
		return result;
	}
	
	@RequestMapping("admin_inquiry_delete")
	public String admin_inquiry_delete(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId,
			@SessionAttribute(name = "isAdmin", required = false) String isAdmin , PageVO pageVo, @ModelAttribute("dto") AdminInquirySearchDto dto, RedirectAttributes redAttri) {
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
			result = "redirect:admin_inquiry_list_page";
		}
		//싱글톤위한 값 전달
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);

		//inquiry 조인 테이블 가져오와서 모델에 넘기기
		adminInquiryInter=new AdminInquiryService();
		try {
			adminInquiryInter.inquiry_delete(model);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//redirectAttribute에 데이터 담기 
		adminInquiryInter.redirect_data_set_for_list(model,redAttri);
		
		return result;
	}
	@ResponseBody
	@RequestMapping("/admin_inquiry_delete_ajax")
    public int admin_inquiry_delete_ajax(HttpServletRequest request, Model model) {
		int resultCnt = 0;
		//싱글톤위한 값 전달
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		
		//inquiry 조인 테이블 가져오와서 모델에 넘기기
				adminInquiryInter=new AdminInquiryService();
				try {
					resultCnt = adminInquiryInter.inquiry_delete_for_ajax(model);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("resultCnt : "+resultCnt);
        return resultCnt;
    }

}