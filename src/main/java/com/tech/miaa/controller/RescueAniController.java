package com.tech.miaa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.miaa.abdmApi.AbandonmentPublicSrvc;
import com.tech.miaa.abdmApi.AbdmKindItem;
import com.tech.miaa.abdmApi.AbdmPublic;
import com.tech.miaa.abdmApi.AbdmPublicItem;
import com.tech.miaa.abdmApi.SexEnum;
import com.tech.miaa.dto.AnimalDetailDto;
import com.tech.miaa.dto.AnimalSearchDto;
import com.tech.miaa.vopage.PageVO;

@Controller
public class RescueAniController {
    @Autowired
    private SqlSession sqlSession;
    private List<AbdmPublicItem> itemList;
    private AbdmPublic abdmPublic;
    private Boolean isFirst = true;
    private AnimalSearchDto current_dto;
    private ArrayList<AbdmKindItem> abdmKindItems = new ArrayList<>();

    private PageVO current_pageVO;

    @RequestMapping(value = "rescue_ani_search_page")
    public String rescue_ani_search_page(HttpServletRequest request, Model model,AnimalSearchDto dto, PageVO page_VO) {
        if (dto.getSearch_str_date() != null || dto.getSearch_end_date() != null || dto.getSidoSelectBox() != null || dto.getSigunguSelectBox() != null || dto.getUpKindSelectBox() != null || dto.getKindSelectedBox() != null) {
            current_dto = dto;
        }
        String strPage = request.getParameter("page");
        if (strPage == null) {
            strPage = "1";
        }
        int page = Integer.parseInt(strPage);
        //페이지 초과문제 해결
        if (current_pageVO != null && current_pageVO.getTotPage() < page) page = current_pageVO.getTotPage();
        page_VO.setPage(page);
        if (current_dto == null) {
            abdmPublic = AbandonmentPublicSrvc.abandonmentPublic(page_VO.getPage());
        } else {
            abdmPublic = AbandonmentPublicSrvc.abandonmentPublic(current_dto, page_VO.getPage());
        }

        int totalCount = 0;
        itemList = abdmPublic.getItems();
        if (abdmPublic.getTotalCount() != null) {
            totalCount = Integer.parseInt(abdmPublic.getTotalCount());
        }
        //성별 filtering
//        if (current_dto != null) {
//            if (!current_dto.getSexSelectedBox().isEmpty()) {
//                System.out.println(current_dto.getSexSelectedBox());
//                List<AbdmPublicItem> filterItems = itemList.stream().filter(x -> x.getSexCd().equals(current_dto.getSexSelectedBox())).collect(Collectors.toList());
//                itemList = filterItems;
//            }
//        }
//        SexEnum[] sexEnum = SexEnum.values();
        page_VO.pageCalculate(totalCount);
        current_pageVO = page_VO;
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i).getNoticeNo());
        }
        model.addAttribute("itemList", itemList);
        model.addAttribute("dto", current_dto);
//        model.addAttribute("sexEnum", sexEnum);
        model.addAttribute("abdmKindItems", abdmKindItems);
        model.addAttribute("pageVO", page_VO);
        return "rescue_ani.search_page.보호동물 검색.3";
    }

    //JeongMin
    @RequestMapping(value = "/rescue_ani_detail_page", method = RequestMethod.GET)
    public String rescue_ani_detail_page(HttpServletRequest request, Model model) {
        String ab = request.getParameter("noticeNo");
        Optional<AbdmPublicItem> result = itemList.stream().filter(x -> x.getNoticeNo().equals(ab)).findAny();
        AbdmPublicItem item = result.get();
        System.out.println(item.getKindCd());
        AnimalDetailDto dto = new AnimalDetailDto(item);
        model.addAttribute("dto", dto);
        return "rescue_ani.detail_page.보호동물 상세페이지.2";
    }

    @RequestMapping("rescue_ani_detail_map")
    public String lost_item_detail_map(HttpServletRequest request, Model model) {
        System.out.println("rescue_ani_detail_map");
        model.addAttribute("request", request);
        String address = request.getParameter("address");
        model.addAttribute("address", address);
        return "rescue_ani/detail_map";
    }
}
