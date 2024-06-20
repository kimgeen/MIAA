package com.tech.miaa.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.tech.miaa.service.LostItemService;
import com.tech.miaa.service.MissingAnimalService;
import com.tech.miaa.service.MypagePostService;
import com.tech.miaa.serviceInter.LostItemServiceInter;
import com.tech.miaa.serviceInter.MissingAnimalServiceInter;
import com.tech.miaa.serviceInter.MypagePostServiceInter;

@Controller
public class MypagePostController {
	@Autowired
	private SqlSession sqlSession;
	
	MypagePostServiceInter mypagePostService;
	
	MissingAnimalServiceInter animalService;
	
	LostItemServiceInter itemService;

	@RequestMapping("mypage_post_list_page")
	public String mypage_post_list_page(HttpServletRequest request, Model model, @SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession); 
		model.addAttribute("userId", userId);
		mypagePostService=new MypagePostService();
		
		mypagePostService.MypagyPost_list(model);
		
		return "mypage_post.list_page.등록 게시물.3";
	}
	@RequestMapping("mypage_ani_delete")
	public String mypage_ani_delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		animalService = new MissingAnimalService();
		animalService.missing_ani_delete(model);
		return "redirect:mypage_post_list_page";
	}
	@RequestMapping("mypage_item_delete")
	public String mypage_item_delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		itemService = new LostItemService();
		itemService.lost_item_delete(model);
		return "redirect:mypage_post_list_page";
	}
	@RequestMapping("mypage_ani_modify_page")
	public String mypage_ani_modify_page(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		animalService = new MissingAnimalService();
		animalService.missing_ani_modify_page(model);
		
		return "missing_ani.modify_page2.실종동물 수정.2";
	}
	@RequestMapping("mypage_ani_modify")
	public String mypage_ani_modify(HttpServletRequest request, Model model, @RequestParam("files") ArrayList<MultipartFile> files) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("files", files);
		animalService = new MissingAnimalService();
		String result=animalService.mypage_ani_modify(model);
		
		return result;
	}
	@RequestMapping("mypage_item_modify_page")
	public String mypage_item_modify_page(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		itemService = new LostItemService();
		itemService.lost_item_modify_page(model);
		
		return "lost_item.modify_page2.분실물 수정.2";
	}
	@RequestMapping("mypage_item_modify")
	public String mypage_item_modify(HttpServletRequest request, Model model,@RequestParam("files") ArrayList<MultipartFile> files) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("files", files);
		itemService = new LostItemService();
		String result=itemService.mypage_item_modify(model);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value ="/mypage_total_delete")
	public int mypage_total_delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		String[] ajaxMsg = request.getParameterValues("valueArr"); int result=0;
		itemService = new LostItemService(); animalService = new MissingAnimalService();
		for (int i = 0; i < ajaxMsg.length; i++) {
			model.addAttribute("total_id", ajaxMsg[i]);
			animalService.missing_ani_delete(model);
			itemService.lost_item_delete(model);
			result=1;
		}
		return result;
	}
}