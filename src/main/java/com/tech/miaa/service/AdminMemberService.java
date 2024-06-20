package com.tech.miaa.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.tech.miaa.dao.AdminInquiryDao;
import com.tech.miaa.dao.AdminMemberDao;
import com.tech.miaa.dto.AdminMemberDto;
import com.tech.miaa.dto.AdminMemberSearchDto;
import com.tech.miaa.serviceInter.AdminMemberServiceInter;
import com.tech.miaa.util.CryptoUtil;
import com.tech.miaa.vopage.PageVO;

public class AdminMemberService implements AdminMemberServiceInter {

    @Override
    public int admin_idchek(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");
        SqlSession sqlSession = (SqlSession) map.get("sqlSession");

        String id = request.getParameter("id");
        int num = 0;
        if (id == "") {
            num = -1;
        } else {
            AdminMemberDao dao = sqlSession.getMapper(AdminMemberDao.class);
            num = dao.admin_idcheck(id);
        }
        return num;
    }

    @Override
    public int admin_emailchk(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");
        SqlSession sqlSession = (SqlSession) map.get("sqlSession");

        String email = request.getParameter("email");
        int num = 0;

        if (email == "") {
            num = -1;
        } else {
            AdminMemberDao dao = sqlSession.getMapper(AdminMemberDao.class);
            num = dao.admin_emailcheck(email);
        }

        return num;
    }

    //	admin_codeck 관리자가입 코드 Aldkxptmxm
    @Override
    public int admin_codechk(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");
        SqlSession sqlSession = (SqlSession) map.get("sqlSession");
        //인증코드
        String code = request.getParameter("code");
        int num = 0;

        if (code == "") {
            num = -1; //값없을 경우 -1
        } else if (code.equals("Aldkxptmxm")) {
            num = 0; // 맞을경우 0
        } else {
            num = 1; // 틀릴경우 -1
        }

        return num;
    }

    @Override
    public String admin_join(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");
        SqlSession sqlSession = (SqlSession) map.get("sqlSession");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String pw2 = request.getParameter("pw2");
        String shpwd = "";
        String bcpwd = "";
        String email = request.getParameter("email");
//		인증코드
        String code = request.getParameter("code");

        String result = "redirect:admin";

        // 암호화 처리
        try {
            shpwd = CryptoUtil.sha512(pw);
            bcpwd = CryptoUtil.encryptAES256(pw, shpwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bcpwd);
        AdminMemberDao dao = sqlSession.getMapper(AdminMemberDao.class);
        int idcheck = dao.admin_idcheck(id);
        int emailcheck = dao.admin_emailcheck(email);
        //인증코드체크
        int codecheck = admin_codechk(model);

        switch (codecheck) {
            case 0:
                if (id != "" && email != "" && pw != "") {
                    // 가입가능여부 확인 (아이디, 이메일 중복확인)
                    if (idcheck >= 1 && emailcheck >= 1) {
                        System.out.println("아이디와 이메일이 중복됩니다.");
                    } else if (idcheck == 0 && emailcheck >= 1) {
                        System.out.println("이메일이 중복됩니다.");
                    } else if (idcheck >= 1 && emailcheck == 0) {
                        System.out.println("아이디가 중복됩니다.");
                    } else {
                        // 가입가능여부 확인 (비밀번호와 비밀번호 확인 같은지 확인)
                        if (pw.equals(pw2)) {
                            System.out.println("관리자 가입 완료.");
                            dao.admin_join(id, shpwd, bcpwd, email);
                            result = "redirect:loginform";
                        } else {
                            System.out.println("비밀번호를 확인해주세요.");
                        }
                    }
                }
                break;
            case -1:
                System.out.println("인증코드가 틀렸습니다");
            default:
                System.out.println("인증코드를 확인해주세요");
                break;
        }

        return result;
    }

    @Override
    public void member_list(Model model, PageVO pageVo) {
    	Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		AdminMemberSearchDto dto = (AdminMemberSearchDto) map.get("dto");
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
		AdminMemberDao dao = sqlSession.getMapper(AdminMemberDao.class);
		List<AdminMemberDto> list = null;
		if (rowStart == 0 && rowEnd == 0) {
			System.out.println("get_pagevo 문제발생");

		} else {
			try {
				list = dao.getJoinedMembers(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		model.addAttribute("search", dto);
		model.addAttribute("list", list);

    }

    public PageVO get_pagevo(Model model, PageVO pageVo) {
		int page = 0; // 현재 페이지
		int total = 0; // 모든 게시물 갯수
		int displayRowCount = 6; // 보여질 페이지 갯수

		Map<String, Object> map = model.asMap();
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		AdminMemberSearchDto dto = (AdminMemberSearchDto) map.get("dto");
		String currPage = request.getParameter("currPage");

		// 토탈페이지 먼저 구하기
		AdminMemberDao dao = sqlSession.getMapper(AdminMemberDao.class);

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

    public void set_search_dto(Model model, PageVO pageVo) {
        Map<String, Object> map = model.asMap();
        AdminMemberSearchDto dto = (AdminMemberSearchDto) map.get("dto");
		// 만들어진 PageVo로 글목록의 star와 end를 가져옴
		int rowStart = pageVo.getRowStart();
		int rowEnd = pageVo.getRowEnd();
		dto.setRowEnd(rowEnd);
		dto.setRowStart(rowStart);
		
		System.out.println("search_type:" + dto.getSearch_type());


    }

	@Override
	public int joined_member_delete_for_ajax(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		// 클라이언트로부터 받은 숫자 배열을 처리합니다.
		String[] chkValues= request.getParameterValues("chkVal");
		List<String> chkValList = Arrays.asList(chkValues);
		System.out.println("가져온 리스트내용 : "+chkValList.toString());
        int deletecount = 0;
        AdminMemberDao dao = sqlSession.getMapper(AdminMemberDao.class);
		try {
			System.out.println("DEL실행직전" );
			//member에서 삭제
			deletecount = dao.joined_member_delete_for_ajax(chkValList);
			//miaa_admin에서 삭제
			deletecount += dao.joined_member_delete2_for_ajax(chkValList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(deletecount);
		return deletecount;
	}
}
