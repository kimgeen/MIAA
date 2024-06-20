
package com.tech.miaa.service;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.tech.miaa.dao.LostItemDao;
import com.tech.miaa.dto.ItemDto;
import com.tech.miaa.dto.ItemImgDto;
import com.tech.miaa.serviceInter.LostItemServiceInter;


import com.tech.miaa.util.PrdCode;
import com.tech.miaa.vopage.PageVO;

public class LostItemService implements LostItemServiceInter {
	
	private String filePath="C:\\23setspring\\springwork23\\MIAA\\src\\main\\webapp";
	
	@Override
	public ArrayList<ItemDto> lost_item_search(Model model) {
		Map<String, Object> map = model.asMap(); SqlSession sqlSession = (SqlSession) map.get("sqlSession"); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		LostItemDao dao = sqlSession.getMapper(LostItemDao.class);
		
		String searchday1 = ""; String searchday2 = ""; String addressCode = "";
		String itemkind1 =""; String itemkind2 = ""; String colorCd = "";
		
		//검색조건 채우기 작업
		if(request.getParameter("searchday1")!=null) searchday1=request.getParameter("searchday1");
		if(request.getParameter("searchday2")!=null) searchday2=request.getParameter("searchday2");
		if(request.getParameter("addressCode")!=null) addressCode=request.getParameter("addressCode");
		if(request.getParameter("itemkind1")!=null) itemkind1=request.getParameter("itemkind1");
		if(request.getParameter("itemkind2")!=null) itemkind2=request.getParameter("itemkind2");
		if(request.getParameter("colorCd")!=null) colorCd=request.getParameter("colorCd");
		
		//검색조건 저장하기
		ArrayList<String> searchContent= new ArrayList<>();
		searchContent.add(0, searchday1); searchContent.add(1, searchday2); searchContent.add(2, addressCode);
		searchContent.add(3, itemkind1); searchContent.add(4, itemkind2); searchContent.add(5, colorCd);
		
		//페이징 로직 처리
		PageVO pageVo = new PageVO();
		int totalCount=dao.totalCount(searchday1,searchday2,addressCode,itemkind1,itemkind2,colorCd);
		String strPage=request.getParameter("page");
		if(strPage==null) strPage="1";
		int page=Integer.parseInt(strPage);
		pageVo.setPage(page); pageVo.pageCalculate(totalCount);
		int rowStart=pageVo.getRowStart(); int rowEnd=pageVo.getRowEnd();
		
		ArrayList<ItemDto> itemList = dao.itemlistview(searchday1,searchday2,addressCode,itemkind1,itemkind2,colorCd,
				rowStart,rowEnd);
		
		
		//사진이 없을 때 기본이미지로 대체
		for (int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getFilename()==null) {
				if(itemList.get(i).getUpkind().equals("컴퓨터")) {
					itemList.get(i).setFilename("resources/item_default/노트북.png");
				}else if(itemList.get(i).getUpkind().equals("휴대폰")) {
					itemList.get(i).setFilename("resources/item_default/휴대폰.png");
				}else if(itemList.get(i).getUpkind().equals("지갑")) {
					itemList.get(i).setFilename("resources/item_default/지갑.png"); 
				}else if(itemList.get(i).getUpkind().equals("전자기기")) {
					itemList.get(i).setFilename("resources/item_default/전자기기.png");
				}else if(itemList.get(i).getUpkind().equals("산업용품")) {
					itemList.get(i).setFilename("resources/item_default/산업.png"); 
				}else if(itemList.get(i).getUpkind().equals("귀금속")) {
					itemList.get(i).setFilename("resources/item_default/보석.png");
				}else if(itemList.get(i).getUpkind().equals("기타물품")) {
					itemList.get(i).setFilename("resources/item_default/기타물품.png");
				}else if(itemList.get(i).getUpkind().equals("서류")) {
					itemList.get(i).setFilename("resources/item_default/서류.png");
				}else if(itemList.get(i).getUpkind().equals("스포츠용품")) {
					itemList.get(i).setFilename("resources/item_default/스포츠.png"); 
				}else if(itemList.get(i).getUpkind().equals("자동차")) {
					itemList.get(i).setFilename("resources/item_default/자동차.png");
				}else if(itemList.get(i).getUpkind().equals("현금")) {
					itemList.get(i).setFilename("resources/item_default/현금.png");
				}else if(itemList.get(i).getUpkind().equals("의류")) {
					itemList.get(i).setFilename("resources/item_default/의류.png"); 
				}else if(itemList.get(i).getUpkind().equals("쇼핑백")) {
					itemList.get(i).setFilename("resources/item_default/쇼핑백.png"); 
				}else if(itemList.get(i).getUpkind().equals("악기")) {
					itemList.get(i).setFilename("resources/item_default/악기.png"); 
				}else if(itemList.get(i).getUpkind().equals("카드")) {
					itemList.get(i).setFilename("resources/item_default/카드.png"); 
				}else if(itemList.get(i).getUpkind().equals("유가증권")) {
					itemList.get(i).setFilename("resources/item_default/증권.png"); 
				}else if(itemList.get(i).getUpkind().equals("증명서")) {
					itemList.get(i).setFilename("resources/item_default/증명서.png");
				}else if(itemList.get(i).getUpkind().equals("가방")) {
					itemList.get(i).setFilename("resources/item_default/가방.png"); 
				}else if(itemList.get(i).getUpkind().equals("도서용품")) {
					itemList.get(i).setFilename("resources/item_default/책.png");
				}else if(itemList.get(i).getUpkind().equals("유류품")) {
					itemList.get(i).setFilename("resources/item_default/유류물품.png");
				}
			}
		}
		model.addAttribute("searchContent", searchContent);
		model.addAttribute("totalCount", totalCount); model.addAttribute("pageVo", pageVo);
		return itemList;
	}

	@Override
	public String lost_item_write(Model model){
		Map<String, Object> map = model.asMap(); HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		ArrayList<MultipartFile> files = (ArrayList<MultipartFile>) map.get("files");
		String result=""; LostItemDao dao = sqlSession.getMapper(LostItemDao.class);

		String openclose=request.getParameter("openclose"); String lostday=request.getParameter("lostday");
		String address=request.getParameter("address"); String itemname=request.getParameter("itemname");
		String itemkind1=request.getParameter("itemkind1"); String itemkind2=request.getParameter("itemkind2");
		String colorCd=""; 
		String user_tel=request.getParameter("userTel");
		if(!request.getParameter("colorCd").equals("색상을 선택하세요")) colorCd=request.getParameter("colorCd");
		String sepcialMark=request.getParameter("sepcialMark");
		String userId=request.getParameter("userId"); String addressCode=request.getParameter("addressCode");
		
		if(lostday.equals("")|| address.equals("")|| itemname.equals("") || itemkind1.equals("분류를 선택하세요") || 
				addressCode.equals("지역을 선택하세요")) {
			result="redirect:lost_item_write_page";
		}else {
			dao.itemWrite(user_tel, openclose, lostday, address, itemname, itemkind1, itemkind2, colorCd, sepcialMark, userId,addressCode);
			for (int i = 0; i < files.size(); i++) {
				if(files.get(i).getOriginalFilename()=="") {
					continue;
				}else if(files.get(i).getOriginalFilename()!=""){
					try {
						UUID uuid=UUID.randomUUID();
						String fileName="resources/item_img/"+uuid+"_"+files.get(i).getOriginalFilename();
						File saveFile = new File(filePath, fileName);
						files.get(i).transferTo(saveFile);
						dao.imgUpLoad(userId,(i+1),itemname,fileName,itemkind2);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();}}}
			result="redirect:lost_item_search_page";}
		return result;}

	@Override
	public void lost_item_detail_page(Model model) {
		Map<String, Object> map = model.asMap(); HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		SqlSession sqlSession = (SqlSession) map.get("sqlSession"); LostItemDao dao = sqlSession.getMapper(LostItemDao.class);
		String total_id = request.getParameter("total_id"); PrdCode pc = new PrdCode();
		String kind=request.getParameter("kind");
		ItemDto dto=dao.lost_item_detail_page(total_id);
		ArrayList<ItemImgDto> imgDtos=dao.lost_item_detail_img(total_id);
		
			//사진이 없을 때 기본아이콘 대체
			if (imgDtos.size()==0) {
				if(dto.getUpkind().equals("컴퓨터")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/노트북.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("휴대폰")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/휴대폰.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("지갑")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/지갑.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("전자기기")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/전자기기.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("산업용품")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/산업.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("귀금속")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/보석.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("기타물품")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/기타물품.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("서류")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/서류.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("스포츠용품")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/스포츠.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("자동차")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/자동차.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("현금")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/현금.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("의류")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/의류.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("쇼핑백")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/쇼핑백.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("악기")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/악기.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("카드")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/카드.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("유가증권")) {
					ItemImgDto imgdto = new ItemImgDto(0,0, null, "resources/item_default/증권.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("증명서")) {
					ItemImgDto imgdto = new ItemImgDto(0,0,null, "resources/item_default/증명서.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("가방")) {
					ItemImgDto imgdto = new ItemImgDto(0,0,null, "resources/item_default/가방.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("도서용품")) {
					ItemImgDto imgdto = new ItemImgDto(0,0,null, "resources/item_default/책.png"); imgDtos.add(0, imgdto);
				}else if(dto.getUpkind().equals("유류품")) {
					ItemImgDto imgdto = new ItemImgDto(0,0,null, "resources/item_default/유류물품.png"); imgDtos.add(0, imgdto);
				}}
		model.addAttribute("dto", dto); model.addAttribute("imgDtos", imgDtos); model.addAttribute("kind", kind);
	}
	
	@Override
	public void lost_item_delete(Model model) {
		Map<String, Object> map = model.asMap(); HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		SqlSession sqlSession = (SqlSession) map.get("sqlSession"); String total_id = request.getParameter("total_id"); 
		LostItemDao dao = sqlSession.getMapper(LostItemDao.class);
		if((String) map.get("total_id")!=null) {
			total_id=(String) map.get("total_id");
		}
		System.out.println("아이템 totalid:"+total_id);
		ArrayList<ItemImgDto> imgDtos=dao.lost_item_detail_img(total_id);
		if(imgDtos.size()!=0) {
			System.out.println(imgDtos.get(0).getFilename());
		}else {
			System.out.println("이미지 없음");
		}
		
		if(imgDtos.size()!=0) {
			for (int i = 0; i < imgDtos.size(); i++) {
				String fileName=imgDtos.get(i).getFilename();
				File file = new File(filePath, fileName);
				file.delete();}}
		
		dao.lost_item_delete_content(total_id);
	}
	
	@Override
	public void lost_item_modify_page(Model model) {
		Map<String, Object> map = model.asMap(); HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession"); String total_id = request.getParameter("total_id");
		LostItemDao dao = sqlSession.getMapper(LostItemDao.class);
		
		ItemDto dto = dao.lost_item_detail_page(total_id);
		ArrayList<ItemImgDto> imgDtos=dao.lost_item_detail_img(total_id);
		
		model.addAttribute("dto", dto); model.addAttribute("imgDtos", imgDtos);
	}
	
	@Override
	public String lost_item_modify(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		ArrayList<MultipartFile> files = (ArrayList<MultipartFile>) map.get("files");
		String result=null; LostItemDao dao = sqlSession.getMapper(LostItemDao.class);
		
		String openclose=request.getParameter("openclose"); String lostday=request.getParameter("lostday");
		String address=request.getParameter("address"); String itemname=request.getParameter("itemname");
		String itemkind1=request.getParameter("itemkind1"); String itemkind2=request.getParameter("itemkind2");
		String colorCd="";
		if(request.getParameter("colorCd")!=null) {
			colorCd=request.getParameter("colorCd"); 
		}
		String sepcialMark = request.getParameter("sepcialMark"); String total_id = request.getParameter("total_id");
		String user_id = request.getParameter("user_id"); String addressCode=request.getParameter("addressCode");
		//기존 업로드 사진 삭제
		int cnt=0;
		for (int i = 0; i < files.size(); i++) {
			if(files.get(i).getOriginalFilename()!="") cnt=cnt+1;
		}
		if(cnt>0) {
			ArrayList<ItemImgDto> imgDtos=dao.lost_item_detail_img(total_id);
			if(imgDtos.size()!=0) {
				for (int i = 0; i < imgDtos.size(); i++) {
					String fileName=imgDtos.get(i).getFilename();
					File file = new File(filePath, fileName);
					file.delete();
					dao.lost_item_delete_img(total_id);}}}
		//수정
		if(lostday.equals("")|| address.equals("")|| itemname.equals("") || itemkind2.equals("분류를 선택하세요") || 
				addressCode.equals("지역을 선택하세요")) {
			result="redirect:lost_item_modify_page?total_id="+total_id;
		}else {
			dao.lost_item_modify(openclose,lostday,address,itemname,itemkind1,itemkind2,colorCd,sepcialMark,addressCode,total_id);
			if(cnt>0) {
				for (int i = 0; i < files.size(); i++) {
					if(files.get(i).getOriginalFilename()=="") {
						continue;
					}else if(files.get(i).getOriginalFilename()!=""){
						try {
							UUID uuid=UUID.randomUUID();
							String fileName="resources/item_img/"+uuid+"_"+files.get(i).getOriginalFilename();
							File saveFile = new File(filePath, fileName);
							files.get(i).transferTo(saveFile);
							dao.imgUpLoad(user_id,(i+1),itemname,fileName,itemkind2);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();}}}}
			result="redirect:lost_item_search_page";
		}
		return result;}

	@Override
	public String mypage_item_modify(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		ArrayList<MultipartFile> files = (ArrayList<MultipartFile>) map.get("files");
		String result=""; LostItemDao dao = sqlSession.getMapper(LostItemDao.class);

		String openclose=request.getParameter("openclose"); String lostday=request.getParameter("lostday");
		String address=request.getParameter("address"); String itemname=request.getParameter("itemname");
		String itemkind1=request.getParameter("itemkind1"); String itemkind2=request.getParameter("itemkind2");
		String colorCd="";
		if(request.getParameter("colorCd")!=null) {
			colorCd=request.getParameter("colorCd"); 
		}
		String sepcialMark = request.getParameter("sepcialMark"); String total_id = request.getParameter("total_id");
		String user_id = request.getParameter("user_id"); String addressCode=request.getParameter("addressCode");
		//기존 업로드 사진 삭제
		int cnt=0;
		for (int i = 0; i < files.size(); i++) {
			if(files.get(i).getOriginalFilename()!="") cnt=cnt+1;
		}
		if(cnt>0) {
			ArrayList<ItemImgDto> imgDtos=dao.lost_item_detail_img(total_id);
			if(imgDtos.size()!=0) {
				for (int i = 0; i < imgDtos.size(); i++) {
					String fileName=imgDtos.get(i).getFilename();
					File file = new File(filePath, fileName);
					file.delete();
					dao.lost_item_delete_img(total_id);}}}
		//수정
		if(lostday.equals("")|| address.equals("")|| itemname.equals("") || itemkind2.equals("분류를 선택하세요") || 
				addressCode.equals("지역을 선택하세요")) {
			result="redirect:mypage_item_modify_page?total_id="+total_id;
		}else {
			dao.lost_item_modify(openclose,lostday,address,itemname,itemkind1,itemkind2,colorCd,sepcialMark,addressCode,total_id);
			if(cnt>0) {
				for (int i = 0; i < files.size(); i++) {
					if(files.get(i).getOriginalFilename()=="") {
						continue;
					}else if(files.get(i).getOriginalFilename()!=""){
						try {
							UUID uuid=UUID.randomUUID();
							String fileName="resources/item_img/"+uuid+"_"+files.get(i).getOriginalFilename();
							File saveFile = new File(filePath, fileName);
							files.get(i).transferTo(saveFile);
							dao.imgUpLoad(user_id,(i+1),itemname,fileName,itemkind2);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();}}}}
			result="redirect:mypage_post_list_page";
		}
		return result;
	}
}
