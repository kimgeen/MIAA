package com.tech.miaa.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.tech.miaa.dto.ItemDto;
import com.tech.miaa.dto.matchingAlarmDto;
import com.tech.miaa.service.LostItemService;
import com.tech.miaa.service.MatchingAlarmService;
import com.tech.miaa.serviceInter.LostItemServiceInter;
import com.tech.miaa.serviceInter.MypageMatchingAlarmServiceInter;

@Controller
public class LostItemController {
	@Autowired
	private SqlSession sqlSession;

	LostItemServiceInter itemService;
	
	//검색 페이지
	@RequestMapping("lost_item_search_page")
	public String lost_item_search_page(HttpServletRequest request, Model model) {
		model.addAttribute("sqlSession", sqlSession); model.addAttribute("request", request);
		itemService = new LostItemService();
		
		ArrayList<ItemDto> itemList = itemService.lost_item_search(model);
		model.addAttribute("itemList", itemList);

		return "lost_item.search_page.분실물 상세검색.3";}
	
	//작성 페이지
	@RequestMapping("lost_item_write_page")
	public String lost_item_write_view(Model model, @SessionAttribute(name = "userId", required = false) String userId) {
		String result = "";
			if (userId != null) result = "lost_item.write_page.분실물등록.2";
			else if (userId == null) result = "login.loginform_page.로그인페이지.1";
		return result;
	}
	@RequestMapping("lost_item_write")
	public String lost_item_write(HttpServletRequest request, Model model,
			@RequestParam("files") ArrayList<MultipartFile> files) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("files", files);
		
		itemService = new LostItemService();
		String result = itemService.lost_item_write(model);
		
		return result;}
	
	//상세 페이지
	@RequestMapping("lost_item_detail_page")
	public String lost_item_detail_page(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		itemService = new LostItemService();
		
		itemService.lost_item_detail_page(model);
		
		return "lost_item.detail_page.분실물 상세페이지.2";}
	
	@RequestMapping("lost_item_detail_map")
	public String lost_item_detail_map(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); 
		String address = request.getParameter("address");
		model.addAttribute("address", address);
		return "lost_item/detail_map";}
	
	//삭제 페이지
	@RequestMapping("lost_item_delete")
	public String lost_item_delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		
		itemService = new LostItemService();
		itemService.lost_item_delete(model);
		
		return "redirect:lost_item_search_page";}
	
	//수정 페이지
	@RequestMapping("lost_item_modify_page")
	public String lost_item_modify_page(HttpServletRequest request, Model model) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		
		itemService = new LostItemService();
		itemService.lost_item_modify_page(model);

		return "lost_item.modify_page.분실물 수정.2";}
	
	@RequestMapping("lost_item_modify")
	public String mypage_post(HttpServletRequest request, Model model,
			@RequestParam("files") ArrayList<MultipartFile> files) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("files", files);
		
		itemService = new LostItemService();
		String result = itemService.lost_item_modify(model);

		return result;}
}
