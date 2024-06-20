package com.tech.miaa.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.tech.miaa.dto.AnimalDto;
import com.tech.miaa.service.MissingAnimalService;
import com.tech.miaa.serviceInter.MissingAnimalServiceInter;

@Controller
public class MissingAniController {
	@Autowired
	private SqlSession sqlSession;

	MissingAnimalServiceInter animalService;
	
	//검색 페이지
	@RequestMapping("missing_ani_search_page")
	public String missing_ani_search_page(HttpServletRequest request, Model model) {
		model.addAttribute("sqlSession", sqlSession); model.addAttribute("request", request);
		animalService = new MissingAnimalService();
		
		ArrayList<AnimalDto> animalList = animalService.missing_ani_search(model);
		
		model.addAttribute("animalList", animalList);
		return "missing_ani.search_page.실종동물 상세검색.3";
	}
	
	//작성 페이지
	@RequestMapping("missing_ani_write_page")
	public String missing_ani_write_view(Model model, @SessionAttribute(name = "userId", required = false) String userId){
		String result = "";
			if (userId != null) result = "missing_ani.write_page.실종동물 등록페이지.2";
			else if (userId == null) result = "login.loginform_page.로그인페이지.1";
		return result;
	}
	@RequestMapping("missing_ani_write")
	public String missing_ani_write(HttpServletRequest request, Model model,
			@RequestParam("files") ArrayList<MultipartFile> files) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("files", files);

		animalService = new MissingAnimalService();
		String result=animalService.missing_ani_write(model);
		return result;
	}
	
	//상세 페이지
	@RequestMapping("missing_ani_detail_page")
	public String missing_ani_detail_page(HttpServletRequest request, Model model ) {
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		animalService = new MissingAnimalService();
		
		animalService.missing_ani_detail_page(model);
		
		return "missing_ani.detail_page.보호동물 상세페이지.2";
	}
	
	//삭제 페이지
	@RequestMapping("missing_ani_delete")
	public String missing_ani_modify(HttpServletRequest request, Model model){
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		animalService = new MissingAnimalService();
		
		animalService.missing_ani_delete(model);
		
		return "redirect:missing_ani_search_page";
	}
	
	//수정페이지
	@RequestMapping("missing_ani_modify_page")
	public String missing_ani_modify_page(HttpServletRequest request, Model model){
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		
		animalService = new MissingAnimalService();
		animalService.missing_ani_modify_page(model);
		return "missing_ani.modify_page.실종동물 수정.2";
	}
	@RequestMapping("missing_ani_modify")
	public String missing_ani_modify(HttpServletRequest request, Model model, @RequestParam("files") ArrayList<MultipartFile> files){
		model.addAttribute("request", request); model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("files", files);
		
		animalService = new MissingAnimalService();
		String result=animalService.missing_ani_modify(model);
		
		return result;
	}
	
}
