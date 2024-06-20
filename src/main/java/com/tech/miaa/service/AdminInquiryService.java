
package com.tech.miaa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tech.miaa.dao.AdminInquiryDao;
import com.tech.miaa.dto.AdminInquiryDto;
import com.tech.miaa.dto.AdminInquirySearchDto;
import com.tech.miaa.serviceInter.AdminInquiryServiceInter;
import com.tech.miaa.vopage.PageVO;

public class AdminInquiryService implements AdminInquiryServiceInter {

	@Override
	public void inquiry_list(Model model, PageVO pageVo) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		AdminInquirySearchDto dto = (AdminInquirySearchDto) map.get("dto");
		String id = (String) map.get("userId");

		// 페이징 처리를 위한 pageVo 가져오기-(현재페이지를 가져와서 현재페이지경우의수를 정한후 PageVo를 셋팅)
		pageVo = get_pagevo(model, pageVo);

		model.addAttribute("pageVo", pageVo);

		// 만들어진 PageVo로 글목록의 star와 end를 가져옴
		int rowStart = pageVo.getRowStart();
		int rowEnd = pageVo.getRowEnd();

		// 전달받은 검색 조건 세팅
		set_search_dto(model, pageVo);

		// db에서 list가져오기
		AdminInquiryDao dao = sqlSession.getMapper(AdminInquiryDao.class);
		ArrayList<AdminInquiryDto> list = null;
		if (rowStart == 0 && rowEnd == 0) {
			System.out.println("get_pagevo 문제발생");

		} else {
			try {
				list = dao.join_inquiry_list(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		model.addAttribute("search", dto);
		model.addAttribute("list", list);

	}

	@Override
	public PageVO get_pagevo(Model model, PageVO pageVo) {
		int page = 0; // 현재 페이지
		int total = 0; // 모든 게시물 갯수
		int displayRowCount = 6; // 보여질 페이지 갯수

		Map<String, Object> map = model.asMap();
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		AdminInquirySearchDto dto = (AdminInquirySearchDto) map.get("dto");
		String currPage = request.getParameter("currPage");

		// 토탈페이지 먼저 구하기
		AdminInquiryDao dao = sqlSession.getMapper(AdminInquiryDao.class);

		try {
			total = dao.get_total(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("전체 목록개수" + total);
		// 현재페이지 경우의수
		if (currPage == null) { // strPage 가 뷰에서 전달되지 않은경우(첫화면)
			currPage = "1";
			page = Integer.parseInt(currPage);
		} else { // strPage값이 뷰에서 현재로 전달된경우
			page = Integer.parseInt(currPage);
			if (page > total / displayRowCount) {// 현재페이지 값이 총 페이지 갯수보다 클경우 시작페이지= 총페이지 갯수
				page = total / displayRowCount + (total % displayRowCount == 0 ? 0 : 1);
			} else if (page <= 0) {// 시작페이지 값이 음수일경우 page =1
				page = 1;
			}
		}

		pageVo.setDisplayRowCount(displayRowCount);// 보여질 페이지 갯수 적용
		pageVo.setPage(page);// 시작페이지 적용

		pageVo.pageCalculate(total);

		System.out.println("전달받은 현재페이지" + currPage);

		return pageVo;
	}

	@Override
	public void set_search_dto(Model model, PageVO pageVo) {
		Map<String, Object> map = model.asMap();
		AdminInquirySearchDto dto = (AdminInquirySearchDto) map.get("dto");
		// 만들어진 PageVo로 글목록의 star와 end를 가져옴
		int rowStart = pageVo.getRowStart();
		int rowEnd = pageVo.getRowEnd();
		dto.setRowEnd(rowEnd);
		dto.setRowStart(rowStart);

		// ModelAttribute로 request의 parameter는 dto 자동으로 들어감
		// 따라서 request parameter에 없는 rowEnd와 rowStart만 pageVo로 주입 되는것

		// param-> null 이면 최초 화면

		// param -> null이 아니면 검색조건 추가한 창

	}

	@Override
	public void inquiry_detail_page(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		AdminInquirySearchDto dto = (AdminInquirySearchDto) map.get("dto");
		String id = (String) map.get("userId");
		String board_num = request.getParameter("board_num");
		String currPage = request.getParameter("currPage");
		// db에서 list_page 내용가져오기
		AdminInquiryDao dao = sqlSession.getMapper(AdminInquiryDao.class);
		AdminInquiryDto detailDto = null;
		try {
			detailDto = dao.inquiry_detail_page(board_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 검색조건
		model.addAttribute("search", dto);
		// 조인테이블 결과
		model.addAttribute("list", detailDto);
		// 현재 페이지
		model.addAttribute("currPage", currPage);
	}

	@Override
	public void inquiry_write_page(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		AdminInquirySearchDto dto = (AdminInquirySearchDto) map.get("dto");
		System.out.println(dto.getSearch_type());
		System.out.println(request.getParameter("search_type"));
		String id = (String) map.get("userId");
		String bn = request.getParameter("board_num");
		String currPage = request.getParameter("currPage");
		// db에서 write_page 내용가져오기
		AdminInquiryDao dao = sqlSession.getMapper(AdminInquiryDao.class);
		AdminInquiryDto detailDto = null;

		try {
			detailDto = dao.inquiry_write_page(bn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 검색조건
		model.addAttribute("search", dto);
		// 조인테이블 결과
		model.addAttribute("list", detailDto);
		// 현재 페이지
		model.addAttribute("currPage", currPage);
	}

	@Override
	public void inquiry_write(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		String id = (String) map.get("userId");
		String board_reply = request.getParameter("board_reply");
		String board_num = request.getParameter("board_num");

		// db에서 write 내용 update
		AdminInquiryDao dao = sqlSession.getMapper(AdminInquiryDao.class);
		System.out.println("inquiry_write실행");
		try {
			// 어드민 인쿼리 테이블 답변,답변날짜 업데이트
			int write1 = dao.inquiry_write1(board_num, id, board_reply);
			// 유저 인쿼리 테이블 답변상태 없데이트
			int write2 = dao.inquiry_write2(board_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void redirect_data_set_for_list(Model model, RedirectAttributes redAttri) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		AdminInquirySearchDto dto = (AdminInquirySearchDto) map.get("dto");
		String START_YMD = dto.getSTART_YMD();
		String END_YMD = dto.getEND_YMD();
		String reply_status = dto.getReply_status();
		String search_type = dto.getSearch_type();
		String search_content = dto.getSearch_content();
		String currPage = request.getParameter("currPage");
		
		redAttri.addAttribute("START_YMD", START_YMD);
		redAttri.addAttribute("END_YMD", END_YMD);
		redAttri.addAttribute("reply_status", reply_status);
		redAttri.addAttribute("search_type", search_type);
		redAttri.addAttribute("search_content", search_content);
		redAttri.addAttribute("currPage", currPage);

	}
	@Override
	public void redirect_data_set_for_write(Model model, RedirectAttributes redAttri) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		AdminInquirySearchDto dto = (AdminInquirySearchDto) map.get("dto");
		String board_num = request.getParameter("board_num");
		String START_YMD = dto.getSTART_YMD();
		String END_YMD = dto.getEND_YMD();
		String reply_status = dto.getReply_status();
		String search_type = dto.getSearch_type();
		String search_content = dto.getSearch_content();
		String currPage = request.getParameter("currPage");
		
		redAttri.addAttribute("START_YMD", START_YMD);
		redAttri.addAttribute("END_YMD", END_YMD);
		redAttri.addAttribute("reply_status", reply_status);
		redAttri.addAttribute("search_type", search_type);
		redAttri.addAttribute("search_content", search_content);
		redAttri.addAttribute("currPage", currPage);
		redAttri.addAttribute("board_num", board_num);
	}
	
	@Override
	public void inquiry_delete(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		String board_num = request.getParameter("board_num");
		AdminInquiryDao dao = sqlSession.getMapper(AdminInquiryDao.class);
		try {
			// 유저 인쿼리 테이블에서 삭제 (어드민테이블은 on delete CASCADE 제약조건으로 자동삭제됨)
			int deletecount = dao.inquiry_delete(board_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int inquiry_delete_for_ajax(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		// 클라이언트로부터 받은 숫자 배열을 처리합니다.
		String[] chkValues= request.getParameterValues("chkVal");
		List<String> chkValList = Arrays.asList(chkValues);
		System.out.println("가져온 리스트내용 : "+chkValList.toString());
        int deletecount = 0;
		AdminInquiryDao dao = sqlSession.getMapper(AdminInquiryDao.class);
		try {
			System.out.println("DEL실행직전" );
			deletecount= dao.inquiry_delete_for_ajax(chkValList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(deletecount);
		return deletecount;
	}
}
