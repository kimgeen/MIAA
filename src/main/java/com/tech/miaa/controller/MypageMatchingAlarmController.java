package com.tech.miaa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tech.miaa.abdmApi.AbdmPublicItem;
import com.tech.miaa.dao.MatchingAlarmDao;
import com.tech.miaa.dto.AnimalDetailDto;
import com.tech.miaa.dto.AnimalDto;
import com.tech.miaa.dto.FounddetailDto;
import com.tech.miaa.dto.FounditemDto;
import com.tech.miaa.dto.ItemDto;
import com.tech.miaa.dto.matchingAlarmDto;
import com.tech.miaa.dto.matchingAlarmListDto;
import com.tech.miaa.service.FounditemService;
import com.tech.miaa.service.MatchingAlarmService;
import com.tech.miaa.serviceInter.LostItemServiceInter;
import com.tech.miaa.serviceInter.MypageMatchingAlarmServiceInter;
import com.tech.miaa.util.PrdCode;
import com.tech.miaa.vopage.PageVO3;

//원진호_알림목록_0401추가
@Controller
public class MypageMatchingAlarmController {
	@Autowired
	private SqlSession sqlSession;
	private List<AbdmPublicItem> itemList;
	MypageMatchingAlarmServiceInter mypageMatchingAlarmServiceInter;
	PrdCode prd = new PrdCode();
	LostItemServiceInter itemService;

	@RequestMapping(value = "mypage_matching_alarm_list_page", method = RequestMethod.GET)
	public String mypage_matching_alarm_list_page(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		mypageMatchingAlarmServiceInter = new MatchingAlarmService();
		MatchingAlarmDao matchingAlarmDao = sqlSession.getMapper(MatchingAlarmDao.class);
		try {
			/* 현재 session에 있는 id에 해당하는 키워드글들 가져오기 */
			ArrayList<ItemDto> item_list = mypageMatchingAlarmServiceInter.matching_alarm_list(model);
			ArrayList<AnimalDto> ani_list = mypageMatchingAlarmServiceInter.matching_alarm_anilist(model);

			// total+userid + 결과값100개이상 + 타입
			ArrayList<matchingAlarmDto> alert_item_list = mypageMatchingAlarmServiceInter.alert_item_list(model);

			ArrayList<matchingAlarmListDto> master_list = new ArrayList<matchingAlarmListDto>();
			System.out.println(item_list);
			System.out.println(ani_list);
			System.out.println(alert_item_list);
			System.out.println("컨트롤러실행확인");

			// 조건item갯수만큼 반복(분실물게시글갯수)
			for (ItemDto ilist : item_list) {
				matchingAlarmListDto dto = new matchingAlarmListDto();
				dto.setTotal_id(Integer.parseInt(ilist.getTotal_id()));
				System.out.println("아이템 토탈 아이디 : " + dto.getTotal_id());
//				dto.setAnimal_dto(null);
				dto.setItem_dto(ilist);
				// 키워드+리스트드들의 집합
				dto.setMatching_item_dto(matchingAlarmDao.matching_DB_items(dto.getTotal_id()));
				master_list.add(dto);
			}

			for (AnimalDto anilist : ani_list) {
				matchingAlarmListDto dto = new matchingAlarmListDto();
				dto.setTotal_id(Integer.parseInt(anilist.getTotal_id()));
				System.out.println("동물 토탈 아이디 : " + dto.getTotal_id());
//				dto.setItem_dto(null);
				dto.setAnimal_dto(anilist);
				// 키워드+리스트드들의 집합
				dto.setMatching_animal_dto(matchingAlarmDao.matching_DB_animals(dto.getTotal_id()));
				dto.getAnimal_dto().setUpkind(prd.getPrdNameByCode(("P"+dto.getAnimal_dto().getUpkind())));
				if(dto.getAnimal_dto().getUpr_cd()!=null) {
					dto.getAnimal_dto().setUpr_cd(prd.getPrdNameByCode(("C"+dto.getAnimal_dto().getUpr_cd())));
				}
				master_list.add(dto);
			}
			int page = 1;

			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			PageVO3 pagevo = new PageVO3();
			pagevo.setPage(page);
			System.out.println("토탈데이터값 : " + master_list.size());
			pagevo.pageCalculate(master_list.size());
			System.out.println("-------------------------");
			System.out.println("토탈데이터Input여부 : " + pagevo.getTotRow());
			System.out.println("현재 페이지값 : " + pagevo.getPage());
			System.out.println("현재 rowstart : " + (pagevo.getRowStart()));
			System.out.println("현재 rowend : " + (pagevo.getRowEnd()));
			System.out.println("전체페이지 : " + pagevo.getTotPage());
			System.out.println("시작페이지 : " + (pagevo.getPageStart()));
			System.out.println("끝페이지 : " + (pagevo.getPageEnd()));

			model.addAttribute("pagevo", pagevo);
			model.addAttribute("list", master_list);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return "mypage_matching.alarm_list_page.알림 목록.3";
	}

	@RequestMapping(value = "mypage_matching_item_detail", method = { RequestMethod.GET, RequestMethod.POST })
	public String mypage_matching_item_detail(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		String atcid = request.getParameter("atcid");
		String fdSn = request.getParameter("fdSn");
		FounditemService fservice = new FounditemService();
		FounddetailDto dto = fservice.found_item_detailview(atcid, fdSn);
		model.addAttribute("dto", dto);
		return "mypage_matching.alarm_item_detail.상세보기.2";
	}
	
	@RequestMapping(value = "mypage_matching_ani_detail", method = RequestMethod.GET)
	public String mypage_matching_ani_detail(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		String desertionNo = request.getParameter("desertionNo");
		MatchingAlarmDao matchingAlarmDao = sqlSession.getMapper(MatchingAlarmDao.class);
        AbdmPublicItem item = matchingAlarmDao.get_animal_data(desertionNo);
        AnimalDetailDto dto = new AnimalDetailDto(item);
        model.addAttribute("dto", dto);
		return "mypage_matching.alarm_ani_detail.보호동물상세보기.2";
	}
	
	

	/* 원진호_0409_수정 */
	@RequestMapping(value = "mypage_matching_alarm_keyword_list_page", method = RequestMethod.GET)
	public String mypage_matching_alarm_keyword_list_page(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		mypageMatchingAlarmServiceInter = new MatchingAlarmService();
		MatchingAlarmDao matchingAlarmDao = sqlSession.getMapper(MatchingAlarmDao.class);
		try {
			/* 현재 session에 있는 id에 해당하는 키워드글들 가져오기 */
			ArrayList<ItemDto> item_list = mypageMatchingAlarmServiceInter.matching_alarm_list(model);
			ArrayList<AnimalDto> ani_list = mypageMatchingAlarmServiceInter.matching_alarm_anilist(model);

			// total+userid + 결과값100개이상 + 타입
			ArrayList<matchingAlarmDto> alert_item_list = mypageMatchingAlarmServiceInter.alert_item_list(model);

			ArrayList<matchingAlarmListDto> master_list = new ArrayList<matchingAlarmListDto>();
			System.out.println(item_list);
			System.out.println(ani_list);
			System.out.println(alert_item_list);
			System.out.println("컨트롤러실행확인");

			// 조건item갯수만큼 반복(분실물게시글갯수)
			for (ItemDto ilist : item_list) {
				matchingAlarmListDto dto = new matchingAlarmListDto();
				dto.setTotal_id(Integer.parseInt(ilist.getTotal_id()));
				System.out.println("아이템 토탈 아이디 : " + dto.getTotal_id());
//				dto.setAnimal_dto(null);
				dto.setItem_dto(ilist);
				// 키워드+리스트드들의 집합
				dto.setMatching_item_dto(matchingAlarmDao.matching_DB_items(dto.getTotal_id()));
				master_list.add(dto);
			}

			for (AnimalDto anilist : ani_list) {
				matchingAlarmListDto dto = new matchingAlarmListDto();
				dto.setTotal_id(Integer.parseInt(anilist.getTotal_id()));
				System.out.println("동물 토탈 아이디 : " + dto.getTotal_id());
//				dto.setItem_dto(null);
				dto.setAnimal_dto(anilist);
				// 키워드+리스트드들의 집합
				dto.setMatching_animal_dto(matchingAlarmDao.matching_DB_animals(dto.getTotal_id()));
				dto.getAnimal_dto().setUpkind(prd.getPrdNameByCode(("P"+dto.getAnimal_dto().getUpkind())));
				if(dto.getAnimal_dto().getUpr_cd()!=null) {
					dto.getAnimal_dto().setUpr_cd(prd.getPrdNameByCode(("C"+dto.getAnimal_dto().getUpr_cd())));
				}
				master_list.add(dto);
			}
			int page = 1;

			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			PageVO3 pagevo = new PageVO3();
			pagevo.setPage(page);
			System.out.println("토탈데이터값 : " + master_list.size());
			pagevo.pageCalculate(master_list.size());
			System.out.println("-------------------------");
			System.out.println("토탈데이터Input여부 : " + pagevo.getTotRow());
			System.out.println("현재 페이지값 : " + pagevo.getPage());
			System.out.println("현재 rowstart : " + (pagevo.getRowStart()));
			System.out.println("현재 rowend : " + (pagevo.getRowEnd()));
			System.out.println("전체페이지 : " + pagevo.getTotPage());
			System.out.println("시작페이지 : " + (pagevo.getPageStart()));
			System.out.println("끝페이지 : " + (pagevo.getPageEnd()));

			model.addAttribute("pagevo", pagevo);
			model.addAttribute("list", master_list);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return "mypage_matching.alarm_keyword_list_page.알림 목록.3";
	}

	/* 모두보기 눌렀을때 실행 */
	@RequestMapping(value = "mypage_matching_alarm_detail_list_page", method = RequestMethod.GET)
	public String mypage_matching_alarm_detail_list_page(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		mypageMatchingAlarmServiceInter = new MatchingAlarmService();
		MatchingAlarmDao matchingAlarmDao = sqlSession.getMapper(MatchingAlarmDao.class);
		String total_id = request.getParameter("total_id");
		System.out.println("토탈아이디 여부 - 디테일리스트 "+total_id);
		ArrayList<ItemDto> item_list = mypageMatchingAlarmServiceInter.matching_alarm_list(model);
		ArrayList<AnimalDto> ani_list = mypageMatchingAlarmServiceInter.matching_alarm_anilist(model);
		matchingAlarmListDto dto = new matchingAlarmListDto();
		try {
			// 조건item갯수만큼 반복(분실물게시글갯수)
			for (ItemDto ilist : item_list) {
				if(ilist.getTotal_id().equals(total_id)){
					dto.setTotal_id(Integer.parseInt(total_id));
					dto.setItem_dto(ilist);
					dto.setMatching_item_dto(matchingAlarmDao.matching_DB_items(dto.getTotal_id()));
				}
			}
			for (AnimalDto anilist : ani_list) {
				if(anilist.getTotal_id().equals(total_id)){
					dto.setTotal_id(Integer.parseInt(total_id));
					dto.setAnimal_dto(anilist);
					dto.setMatching_animal_dto(matchingAlarmDao.matching_DB_animals(dto.getTotal_id()));
					dto.getAnimal_dto().setUpkind(prd.getPrdNameByCode(("P"+dto.getAnimal_dto().getUpkind())));
					if(dto.getAnimal_dto().getUpr_cd()!=null) {
						dto.getAnimal_dto().setUpr_cd(prd.getPrdNameByCode(("C"+dto.getAnimal_dto().getUpr_cd())));
					}
				}
			}
			
			
			int page = 1;

			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				System.out.println("페이지확인-----------");
			}
			PageVO3 pagevo = new PageVO3();
			pagevo.setPage(page);
			pagevo.setDisplayRowCount(10);
			int size=0;
			if(dto.getMatching_animal_dto()!=null) {
				size = dto.getMatching_animal_dto().size();
			}else if(dto.getMatching_item_dto()!=null) {
				size = dto.getMatching_item_dto().size();
			}
			System.out.println("토탈데이터값 : " + size);
			pagevo.pageCalculate(size);
			System.out.println("-------------------------");
			System.out.println("토탈데이터Input여부 : " + pagevo.getTotRow());
			System.out.println("현재 페이지값 : " + pagevo.getPage());
			System.out.println("현재 rowstart : " + (pagevo.getRowStart()));
			System.out.println("현재 rowend : " + (pagevo.getRowEnd()));
			System.out.println("전체페이지 : " + pagevo.getTotPage());
			System.out.println("시작페이지 : " + (pagevo.getPageStart()));
			System.out.println("끝페이지 : " + (pagevo.getPageEnd()));

			model.addAttribute("pagevo", pagevo);
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		model.addAttribute("dto",dto);
		System.out.println("최종 dto 토탈아이디 확인 : "+dto.getTotal_id());
		
		return "mypage_matching.alarm_detail_list_page.알림 목록.3";
	}

	/* weonjinho_0410추가 */
	@RequestMapping(value = "mypage_matching_alarm_ani_list_page", method = RequestMethod.GET)
	public String mypage_matching_alarm_ani_list_page(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		mypageMatchingAlarmServiceInter = new MatchingAlarmService();
		MatchingAlarmDao matchingAlarmDao = sqlSession.getMapper(MatchingAlarmDao.class);
		PrdCode prd = new PrdCode();
		try {
			/* 현재 session에 있는 id에 해당하는 키워드글들 가져오기 */
			ArrayList<ItemDto> item_list = mypageMatchingAlarmServiceInter.matching_alarm_list(model);
			ArrayList<AnimalDto> ani_list = mypageMatchingAlarmServiceInter.matching_alarm_anilist(model);

			// total+userid + 결과값100개이상 + 타입
			ArrayList<matchingAlarmDto> alert_item_list = mypageMatchingAlarmServiceInter.alert_item_list(model);

			ArrayList<matchingAlarmListDto> master_list = new ArrayList<matchingAlarmListDto>();
			System.out.println(item_list);
			System.out.println(ani_list);
			System.out.println(alert_item_list);
			System.out.println("컨트롤러실행확인");

			for (AnimalDto anilist : ani_list) {
				matchingAlarmListDto dto = new matchingAlarmListDto();
				dto.setTotal_id(Integer.parseInt(anilist.getTotal_id()));
				System.out.println("동물 토탈 아이디 : " + dto.getTotal_id());
//				dto.setItem_dto(null);
				dto.setAnimal_dto(anilist);
				// 키워드+리스트드들의 집합
				
				dto.setMatching_animal_dto(matchingAlarmDao.matching_DB_animals(dto.getTotal_id()));
				dto.getAnimal_dto().setUpkind(prd.getPrdNameByCode(("P"+dto.getAnimal_dto().getUpkind())));
				if(dto.getAnimal_dto().getUpr_cd()!=null) {
					dto.getAnimal_dto().setUpr_cd(prd.getPrdNameByCode(("C"+dto.getAnimal_dto().getUpr_cd())));
				}
				System.out.println("분류 어떻게 뜨는지 확인 : "+dto.getAnimal_dto().getUpkind());
				
				master_list.add(dto);
			}
			int page = 1;

			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			PageVO3 pagevo = new PageVO3();
			pagevo.setPage(page);
			System.out.println("토탈데이터값 : " + master_list.size());
			pagevo.pageCalculate(master_list.size());
			System.out.println("-------------------------");
			System.out.println("토탈데이터Input여부 : " + pagevo.getTotRow());
			System.out.println("현재 페이지값 : " + pagevo.getPage());
			System.out.println("현재 rowstart : " + (pagevo.getRowStart()));
			System.out.println("현재 rowend : " + (pagevo.getRowEnd()));
			System.out.println("전체페이지 : " + pagevo.getTotPage());
			System.out.println("시작페이지 : " + (pagevo.getPageStart()));
			System.out.println("끝페이지 : " + (pagevo.getPageEnd()));

			model.addAttribute("pagevo", pagevo);
			model.addAttribute("list", master_list);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return "mypage_matching.alarm_ani_list_page.알림 목록.3";
	}

	/* weonjinho_0410추가 */
	@RequestMapping(value = "mypage_matching_alarm_item_list_page", method = RequestMethod.GET)
	public String mypage_matching_alarm_item_list_page(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		/* 원진호_0409추가 */
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		mypageMatchingAlarmServiceInter = new MatchingAlarmService();
		MatchingAlarmDao matchingAlarmDao = sqlSession.getMapper(MatchingAlarmDao.class);
		try {
			/* 현재 session에 있는 id에 해당하는 키워드글들 가져오기 */
			ArrayList<ItemDto> item_list = mypageMatchingAlarmServiceInter.matching_alarm_list(model);

			// total+userid + 결과값100개이상 + 타입
			ArrayList<matchingAlarmDto> alert_item_list = mypageMatchingAlarmServiceInter.alert_item_list(model);

			ArrayList<matchingAlarmListDto> master_list = new ArrayList<matchingAlarmListDto>();
			System.out.println(item_list);
			System.out.println(alert_item_list);
			System.out.println("컨트롤러실행확인");

			// 조건item갯수만큼 반복(분실물게시글갯수)
			for (ItemDto ilist : item_list) {
				matchingAlarmListDto dto = new matchingAlarmListDto();
				dto.setTotal_id(Integer.parseInt(ilist.getTotal_id()));
				System.out.println("아이템 토탈 아이디 : " + dto.getTotal_id());
//				dto.setAnimal_dto(null);
				dto.setItem_dto(ilist);
				// 키워드+리스트드들의 집합
				dto.setMatching_item_dto(matchingAlarmDao.matching_DB_items(dto.getTotal_id()));
				master_list.add(dto);
			}

			int page = 1;

			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			PageVO3 pagevo = new PageVO3();
			pagevo.setPage(page);
			System.out.println("토탈데이터값 : " + master_list.size());
			pagevo.pageCalculate(master_list.size());
			System.out.println("-------------------------");
			System.out.println("토탈데이터Input여부 : " + pagevo.getTotRow());
			System.out.println("현재 페이지값 : " + pagevo.getPage());
			System.out.println("현재 rowstart : " + (pagevo.getRowStart()));
			System.out.println("현재 rowend : " + (pagevo.getRowEnd()));
			System.out.println("전체페이지 : " + pagevo.getTotPage());
			System.out.println("시작페이지 : " + (pagevo.getPageStart()));
			System.out.println("끝페이지 : " + (pagevo.getPageEnd()));

			model.addAttribute("pagevo", pagevo);
			model.addAttribute("list", master_list);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return "mypage_matching.alarm_item_list_page.알림 목록.3";
	}
	//문성원
	@RequestMapping(value = "/mypage_alarm_delete")
	public String mypage_alarm_delete(HttpServletRequest request, Model model,
			@SessionAttribute(name = "userId", required = false) String userId) {
		model.addAttribute("request", request);
		model.addAttribute("sqlSession", sqlSession);
		model.addAttribute("userId", userId);
		mypageMatchingAlarmServiceInter = new MatchingAlarmService();
		String[] ajaxMsg = request.getParameterValues("valueArr");
		System.out.println("ajax메세지 : "+ajaxMsg);
		int size = ajaxMsg.length;
		for (int i = 0; i < size; i++) {
			mypageMatchingAlarmServiceInter.mypage_alarm_delete(ajaxMsg[i], model);
		}
		return "redirect:mypage_customer_inquiry_list_page";
	}

}