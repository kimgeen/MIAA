package com.tech.miaa.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.miaa.dto.FounddetailDto;
import com.tech.miaa.dto.FounditemDto;
import com.tech.miaa.dto.FoundsearchDto;
import com.tech.miaa.service.FounditemService;
import com.tech.miaa.serviceInter.FounditemServiceInter;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoundItemController {
	@Autowired
	private SqlSession sqlSession;
	FounditemServiceInter fservice;

	@RequestMapping(value = "/found_item_search_page", method = RequestMethod.GET)
	public String found_item_search_page(HttpServletRequest request, Model model) {
		String xml_code = "";
		request.setAttribute("xml_code", xml_code);
		model.addAttribute("request", request);
		FoundsearchDto searchDto = new FoundsearchDto();
		fservice = new FounditemService();
		searchDto = fservice.getFoundsearchValue(model);
		xml_code = fservice.found_item_search_AreaPd(model);
		ArrayList<FounditemDto> list;
		list = fservice.getFoundList(xml_code);
		int total = fservice.getTotal();
		int allsearchPage = fservice.getAllsearchPage();
		model.addAttribute("list", list);
		model.addAttribute("total", total);
		model.addAttribute("xml_code", xml_code);
		model.addAttribute("pageNum", 0);
		model.addAttribute("searchDto", searchDto);
		model.addAttribute("allsearchPage",allsearchPage);
		return "found_item.search_page.습득물 상세검색.3";
	}

	// mhs
	@RequestMapping(value = "found_item_search1", method = {RequestMethod.GET, RequestMethod.POST})
	public String found_item_search1(HttpServletRequest request, Model model) {
		System.out.println("검색중");
		String xml_code = "";
		System.out.println("컨트롤러_기간분류별");
//		데이터가져오기
		model.addAttribute("request", request);
		FoundsearchDto searchDto = new FoundsearchDto();
		fservice = new FounditemService();
		searchDto = fservice.getFoundsearchValue(model);


		System.out.println("-----------------------");
		System.out.println("도시1 : " + searchDto.getCity());
//		System.out.println("도시2 : " + searchDto.getCity2());
		System.out.println("색깔 : " + searchDto.getColor());
		System.out.println("시작일 : " + searchDto.getStartYMD());
		System.out.println("종료일 : " + searchDto.getEndYMD());
		System.out.println("대분류 : " + searchDto.getMainCategory());
		System.out.println("중분류 : " + searchDto.getSubCategory());
		System.out.println("-----------------------");

		xml_code = fservice.found_item_search_AreaPd(model);
		System.out.println(xml_code);
		ArrayList<FounditemDto> list;
		list = fservice.getFoundList(xml_code);
		int total = fservice.getTotal();
		int allsearchPage = fservice.getAllsearchPage();
		model.addAttribute("list", list);
		model.addAttribute("total", total);
		model.addAttribute("xml_code", xml_code);
		model.addAttribute("pageNum", 0);
		model.addAttribute("searchDto", searchDto);
		model.addAttribute("allsearchPage",allsearchPage);
		if(request.getParameter("prev_search_chk").equals("1")) {
			model.addAttribute("pageNum", "9");
		}
		System.out.println("단위페이지 : "+((allsearchPage-1)*10)+"(실제값:"+allsearchPage+")");
		System.out.println(list);
		System.out.println(total);

		return "found_item.search_page.습득물 상세검색.3";
	}


	// mhs
	@RequestMapping(value = "found_item_view", method = RequestMethod.POST)
	public String found_item_view(HttpServletRequest request, Model model) {
		String page = request.getParameter("page");
		System.out.println(page+"번째라고 입력됩니다");
		String xml_code = request.getParameter("xml_code");
		System.out.println("페이지 : " + (Integer.parseInt(page) + 1) + "page(index:" + page + ")");
		System.out.println("코드 : " + xml_code);

		// 데이터가져오기
		ArrayList<FounditemDto> list;
		list = fservice.getFoundList(xml_code);
		model.addAttribute("list", list);

		FoundsearchDto searchDto = new FoundsearchDto();

		String city0 = request.getParameter("Dto_city");
		System.out.println("도시받은거 : "+city0);
		searchDto.setCity(request.getParameter("Dto_city"));
		searchDto.setColor(request.getParameter("Dto_color"));
		searchDto.setStartYMD(request.getParameter("Dto_startYmd"));
		searchDto.setEndYMD(request.getParameter("Dto_endYmd"));
		searchDto.setMainCategory(request.getParameter("Dto_mainCategory"));
		searchDto.setSubCategory(request.getParameter("Dto_subCategory"));

//		model.addAttribute("request", request);
//		searchDto = fservice.getFoundsearchValue(model);
		System.out.println("--------페이지---------------");
		System.out.println("도시1 : " + searchDto.getCity());
//		System.out.println("도시2 : " + searchDto.getCity2());
		System.out.println("색깔 : " + searchDto.getColor());
		System.out.println("시작일 : " + searchDto.getStartYMD());
		System.out.println("종료일 : " + searchDto.getEndYMD());
		System.out.println("대분류 : " + searchDto.getMainCategory());
		System.out.println("중분류 : " + searchDto.getSubCategory());
		System.out.println("-----------------------");


		model.addAttribute("searchDto", searchDto);
		int total = fservice.getTotal();
		int allsearchPage = fservice.getAllsearchPage();
		model.addAttribute("allsearchPage",allsearchPage);
		System.out.println("단위페이지 : "+((allsearchPage-1)*10)+"(실제값:"+allsearchPage+")");
		model.addAttribute("total", total);
		model.addAttribute("xml_code", xml_code);
		model.addAttribute("pageNum", page);
		System.out.println("Math.ceil(total/10)값 : "+Math.ceil(total/10));
		System.out.println("pageNum값 : " + page);
		System.out.println("(allsearchPage-1)*10+pageNum+1 : "+(allsearchPage-1)*10+page+1);

		return "found_item.search_page.습득물 상세검색.3";
	}

	// mhs
	@RequestMapping(value = "/found_item_detail_page", method = RequestMethod.POST)
	public String found_item_detail_page(HttpServletRequest request, Model model) {

		String xml_code = request.getParameter("xml_code");
		String page = request.getParameter("page");
		String Dto_city = request.getParameter("Dto_city");
		String Dto_startYMD = request.getParameter("Dto_startYmd");
		String Dto_endYMD = request.getParameter("Dto_endYmd");
		String Dto_mainCategory = request.getParameter("Dto_mainCategory");
		String Dto_subCategory = request.getParameter("Dto_subCategory");
		String Dto_color = request.getParameter("Dto_color");

		model.addAttribute("xml_code", xml_code);
		model.addAttribute("page", page);
		model.addAttribute("Dto_city", Dto_city);
		model.addAttribute("Dto_startYMD", Dto_startYMD);
		model.addAttribute("Dto_endYMD", Dto_endYMD);
		model.addAttribute("Dto_mainCategory", Dto_mainCategory);
		model.addAttribute("Dto_subCategory", Dto_subCategory);
		model.addAttribute("Dto_color", Dto_color);
		String atcid = request.getParameter("atcid");
		String fdSn = request.getParameter("fdsn");
		FounddetailDto dto = fservice.found_item_detailview(atcid, fdSn);
		System.out.println("하나만 test : " + dto.getAtcId());
		model.addAttribute("dto", dto);

		return "found_item.detail_page.습득물 상세페이지.2";
	}

	@RequestMapping(value = "/found_item_detail_map", method = RequestMethod.GET)
	public String found_item_detail_map(HttpServletRequest request, Model model) {

		String fdPlaceTel = request.getParameter("fdPlaceTel");
		String fdPlace = request.getParameter("fdPlace");
		model.addAttribute("fdPlaceTel",fdPlaceTel);
		model.addAttribute("fdPlace",fdPlace);

		return "found_item.detail_map.지도상세보기.1";
	}


//	// JeongMin
//	@RequestMapping(value = "/found_item_detail_page", method = RequestMethod.GET)
//	public String found_item_detail_page(HttpServletRequest request, Model model) {
//
//		return "found_item.detail_page.습득물 상세페이지.2";
//	}
}
