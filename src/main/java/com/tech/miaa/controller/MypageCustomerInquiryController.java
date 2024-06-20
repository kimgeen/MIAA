package com.tech.miaa.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.tech.miaa.dto.AdminInquiryDto;
import com.tech.miaa.dto.AdminInquirySearchDto;
import com.tech.miaa.dto.InquiryDto;
import com.tech.miaa.service.InquiryService;
import com.tech.miaa.serviceInter.MypageCustomerInquiryServiceInter;
import com.tech.miaa.vopage.PageVO2;

@Controller
public class MypageCustomerInquiryController {
	@Autowired
	private SqlSession sqlSession;

	MypageCustomerInquiryServiceInter mypageCustomerInquiryServiceInter;

//	문의글 등록 페이지
	@RequestMapping("mypage_customer_inquiry_write_page")
	public String mypage_customer_inquiry_write_page(HttpServletRequest request, Model model) {
		return "mypage_customer.inquiry_write_page.문의글 등록.3";
	}

//	문의내역 페이지
	@RequestMapping("mypage_customer_inquiry_list_page")
	public String mypage_customer_inquiry_list_page(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId, PageVO2 pageVo2, @ModelAttribute("dto") AdminInquirySearchDto dto) {
		
		String strPage = null;
						
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		model.addAttribute("pageVo",pageVo2);
		
		
		mypageCustomerInquiryServiceInter = new InquiryService();
		
		try {
			mypageCustomerInquiryServiceInter.inquiry_list(model,pageVo2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "mypage_customer.inquiry_list_page.문의내역.3";
	}

//	수정 페이지
	@RequestMapping("mypage_customer_inquiry_modify_page")
	public String mypage_customer_inquiry_modify_page(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);

		mypageCustomerInquiryServiceInter = new InquiryService();
		try {
			InquiryDto list = mypageCustomerInquiryServiceInter.modify_list(model);
			model.addAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "mypage_customer.inquiry_modify_page.문의내역.3";
	}

//	상세 페이지
	@RequestMapping("mypage_customer_inquiry_detail_page")
	public String mypage_customer_inquiry_detail_page(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		String currpage=request.getParameter("currPage");
		String START_YMD=request.getParameter("START_YMD");
		String END_YMD=request.getParameter("END_YMD");
		String reply_status=request.getParameter("reply_status");
		

		mypageCustomerInquiryServiceInter = new InquiryService();
		try {
			AdminInquiryDto list = mypageCustomerInquiryServiceInter.detail_list(model);
			model.addAttribute("list", list);
			model.addAttribute("currPage",currpage);
			model.addAttribute("START_YMD",START_YMD);
			model.addAttribute("END_YMD",END_YMD);
			model.addAttribute("reply_status",reply_status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "mypage_customer.inquiry_detail_page.문의내역.3";
	}

//	게시물 작성
	@RequestMapping("inquiry_write")
	public String inquiry_write(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId,
			@RequestParam("files") ArrayList<MultipartFile> files) {
		
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		model.addAttribute("files", files);
		mypageCustomerInquiryServiceInter = new InquiryService();
		mypageCustomerInquiryServiceInter.inquiry_wirte(model);

		return "redirect:mypage_customer_inquiry_list_page";
	}

//	게시물 수정
	@RequestMapping("inquiry_modify")
	public String inquiry_modify(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId,
			@RequestParam("files") ArrayList<MultipartFile> files) {
		
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		model.addAttribute("files", files);
		mypageCustomerInquiryServiceInter = new InquiryService();
		mypageCustomerInquiryServiceInter.inquiry_modify(model);

		return "redirect:mypage_customer_inquiry_list_page";
	}

//	게시물 선택삭제
	@RequestMapping(value = "/inquiry_delete")
	public String inquiry_delete(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		mypageCustomerInquiryServiceInter = new InquiryService();

		String[] ajaxMsg = request.getParameterValues("valueArr");
		int size = ajaxMsg.length;
		for (int i = 0; i < size; i++) {
			mypageCustomerInquiryServiceInter.delete(ajaxMsg[i], model);
		}

		return "redirect:mypage_customer_inquiry_list_page";
	}

}