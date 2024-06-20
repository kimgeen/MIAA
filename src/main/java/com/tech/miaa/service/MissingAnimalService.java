
package com.tech.miaa.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.tech.miaa.dao.MissingAnimalDao;
import com.tech.miaa.dto.AnimalDto;
import com.tech.miaa.dto.AnimalImgDto;
import com.tech.miaa.serviceInter.MissingAnimalServiceInter;
import com.tech.miaa.util.PrdCode;
import com.tech.miaa.vopage.PageVO;

public class MissingAnimalService implements MissingAnimalServiceInter {
	
	private String filePath="C:\\23setspring\\springwork23\\MIAA\\src\\main\\webapp";
	
	@Override
	public ArrayList<AnimalDto> missing_ani_search(Model model) {
		Map<String, Object> map = model.asMap();SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		HttpServletRequest request = (HttpServletRequest) map.get("request"); PrdCode pc = new PrdCode();
		MissingAnimalDao dao = sqlSession.getMapper(MissingAnimalDao.class);
		
		String searchday1=""; String searchday2=""; String addressCode1=""; String addressCode2="";
		String animalkind1=""; String animalkind2="";
		
		if(request.getParameter("searchday1")!=null) searchday1=request.getParameter("searchday1");
		if(request.getParameter("searchday2")!=null) searchday2=request.getParameter("searchday2");
		if(request.getParameter("addressCode1")!=null) addressCode1=request.getParameter("addressCode1");
		if(request.getParameter("addressCode2")!=null) addressCode2=request.getParameter("addressCode2");
		if(request.getParameter("animalkind1")!=null) animalkind1=request.getParameter("animalkind1");
		if(request.getParameter("animalkind2")!=null) animalkind2=request.getParameter("animalkind2");
		
		//페이징 처리
		PageVO pageVo = new PageVO();
		int totalCount=dao.totalCount(searchday1,searchday2,addressCode1,addressCode2, animalkind1,animalkind2);
		String strPage=request.getParameter("page");
		if(strPage==null) {strPage="1";}
		int page=Integer.parseInt(strPage);
		pageVo.setPage(page); pageVo.pageCalculate(totalCount);
		int rowStart=pageVo.getRowStart(); int rowEnd=pageVo.getRowEnd();
		
		ArrayList<AnimalDto> animalList = dao.animalListView(searchday1,searchday2,addressCode1,addressCode2,
				animalkind1,animalkind2,rowStart,rowEnd);
		
		ArrayList<String> searchContent= new ArrayList<>();
		searchContent.add(0, searchday1); searchContent.add(1, searchday2); searchContent.add(2, addressCode1);
		searchContent.add(3, addressCode2); searchContent.add(4, animalkind1); searchContent.add(5, animalkind2);
		
		//사진이 없을 때 기본이미지로 대체
		for (int i = 0; i < animalList.size(); i++) {
			if(animalList.get(i).getFilename()==null) {
				if(animalList.get(i).getUpkind().equals("417000")) {
					animalList.get(i).setFilename("resources/ani_default/강아지.png");
				}else if(animalList.get(i).getUpkind().equals("422400")) {
					animalList.get(i).setFilename("resources/ani_default/고양이.png");
				}else if(animalList.get(i).getUpkind().equals("429900")) {
					animalList.get(i).setFilename("resources/ani_default/기타.png"); 
				}
			}
			String upkind="P"+animalList.get(i).getUpkind();
			animalList.get(i).setUpkind(pc.getPrdNameByCode(upkind));
			if(animalList.get(i).getUpr_cd()==null) {
				animalList.get(i).setUpr_cd("전체");
			}else{
				String upr_cd="C"+animalList.get(i).getUpr_cd();
				animalList.get(i).setUpr_cd(pc.getPrdNameByCode(upr_cd));
			}
		}
		
		model.addAttribute("searchContent", searchContent);
		model.addAttribute("totalCount", totalCount); model.addAttribute("pageVo", pageVo);
		
		return animalList;
	}
	
	@Override
	public String missing_ani_write(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		ArrayList<MultipartFile> files = (ArrayList<MultipartFile>) map.get("files");
		String result=""; 
		MissingAnimalDao dao = sqlSession.getMapper(MissingAnimalDao.class);
		
		String openclose=request.getParameter("openclose"); String Missingday=request.getParameter("Missingday");
		String address=request.getParameter("address"); String animalname=request.getParameter("animalname");
		String animalkind1=request.getParameter("animalkind1"); String animalkind2=request.getParameter("animalkind2");
		String sexCd=request.getParameter("sexCd"); String weight=request.getParameter("weight");
		String age=request.getParameter("age"); String user_tel=request.getParameter("userTel");
		String sepcialMark=request.getParameter("sepcialMark"); String userId=request.getParameter("userId"); 
		String addressCode1=request.getParameter("addressCode1"); String addressCode2=request.getParameter("addressCode2");
		
		if(Missingday.equals("")|| address.equals("")|| animalname.equals("") || animalkind1.equals("축종을 선택하세요") || 
				addressCode1.equals("지역을 선택하세요")) {
			result="redirect:missing_ani_write_page";
		}else {
			dao.animalWrite(user_tel, openclose, Missingday, address, animalname, animalkind1, animalkind2,sexCd,weight,
					age, sepcialMark, userId, addressCode1, addressCode2);
			for (int i = 0; i < files.size(); i++) {
				if(files.get(i).getOriginalFilename()=="") {
					continue;
				}else if(files.get(i).getOriginalFilename()!=""){
					try {
						UUID uuid=UUID.randomUUID();
						String fileName="resources/ani_img/"+uuid+"_"+files.get(i).getOriginalFilename();
						File saveFile = new File(filePath, fileName);
						files.get(i).transferTo(saveFile);
						dao.imgUpLoad(userId,(i+1),animalname,fileName,animalkind1);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
				}}}
			result="redirect:missing_ani_search_page";}
		return result;}

	@Override
	public void missing_ani_detail_page(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		MissingAnimalDao dao = sqlSession.getMapper(MissingAnimalDao.class); PrdCode pc = new PrdCode();
		String total_id = request.getParameter("total_id"); String kind=request.getParameter("kind");
		
		AnimalDto dto = dao.missing_ani_detail_page(total_id);
		ArrayList<AnimalImgDto> imgDtos=dao.missing_ani_detail_img(total_id);
		//사진이 없을 때 기본아이콘 대체
		if (imgDtos.size()==0) {
			if(dto.getUpkind().equals("417000")) {
				AnimalImgDto imgdto = new AnimalImgDto(0,0, null, "resources/ani_default/강아지.png"); imgDtos.add(0, imgdto);
			}else if(dto.getUpkind().equals("422400")) {
				AnimalImgDto imgdto = new AnimalImgDto(0,0, null, "resources/ani_default/고양이.png"); imgDtos.add(0, imgdto);
			}else if(dto.getUpkind().equals("429900")) {
				AnimalImgDto imgdto = new AnimalImgDto(0,0, null, "resources/ani_default/기타.png"); imgDtos.add(0, imgdto);
			}
		}
		String upkind="P"+dto.getUpkind();
		dto.setUpkind(pc.getPrdNameByCode(upkind));
		if(dto.getUpr_cd()==null) dto.setUpr_cd("전체");
		else{
			String upr_cd="C"+dto.getUpr_cd();
			dto.setUpr_cd(pc.getPrdNameByCode(upr_cd));
		}
		model.addAttribute("dto", dto); model.addAttribute("imgDtos", imgDtos); model.addAttribute("kind", kind);
	}
	
	@Override
	public void missing_ani_delete(Model model) {
		Map<String, Object> map = model.asMap(); HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		MissingAnimalDao dao = sqlSession.getMapper(MissingAnimalDao.class);
		String total_id=request.getParameter("total_id");
		
		if((String) map.get("total_id")!=null) {
			total_id=(String) map.get("total_id");
		}
		System.out.println("애니멀 totalid:"+total_id);
		ArrayList<AnimalImgDto> imgDtos=dao.missing_ani_detail_img(total_id);
		if(imgDtos.size()!=0) {
			System.out.println(imgDtos.get(0).getFilename());
		}else {
			System.out.println("이미지 없음");
		}
		if(imgDtos.size()!=0) {
			for (int i = 0; i < imgDtos.size(); i++) {
				String fileName=imgDtos.get(i).getFilename();
				File file = new File(filePath, fileName);
				file.delete();
		}}
		dao.missing_ani_delete_content(total_id);
	}

	@Override
	public void missing_ani_modify_page(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		MissingAnimalDao dao = sqlSession.getMapper(MissingAnimalDao.class);
	
		String total_id = request.getParameter("total_id");
		
		AnimalDto dto = dao.missing_ani_detail_page(total_id);
		ArrayList<AnimalImgDto> imgDtos=dao.missing_ani_detail_img(total_id);
		
		if(imgDtos.size()==0) {
			if(dto.getUpkind().equals("417000")) {
				AnimalImgDto imgdto = new AnimalImgDto(0, 0, null, "resources/ani_default/강아지.png"); imgDtos.add(0, imgdto);
			}else if(dto.getUpkind().equals("422400")) {
				AnimalImgDto imgdto = new AnimalImgDto(0, 0, null, "resources/ani_default/고양이.png"); imgDtos.add(0, imgdto);
			}else if(dto.getUpkind().equals("429900")) {
				AnimalImgDto imgdto = new AnimalImgDto(0, 0, null, "resources/ani_default/기타.png"); imgDtos.add(0, imgdto);
			}
		}
		model.addAttribute("dto", dto); model.addAttribute("imgDtos", imgDtos);
	}

	@Override
	public String missing_ani_modify(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		ArrayList<MultipartFile> files = (ArrayList<MultipartFile>) map.get("files");
		String result=""; MissingAnimalDao dao = sqlSession.getMapper(MissingAnimalDao.class);
		
		String openclose=request.getParameter("openclose"); String Missingday=request.getParameter("Missingday");
		String address=request.getParameter("address"); String animalname=request.getParameter("animalname");
		String animalkind1=request.getParameter("animalkind1"); String animalkind2=request.getParameter("animalkind2");
		String sexCd=request.getParameter("sexCd"); String weight=request.getParameter("weight"); String age=request.getParameter("age");
		String sepcialMark=request.getParameter("sepcialMark"); String userId=request.getParameter("userId"); 
		String addressCode1=request.getParameter("addressCode1"); String addressCode2=request.getParameter("addressCode2");
		String total_id = request.getParameter("total_id");
		//기존 업로드 사진 삭제
		int cnt=0;
		for (int i = 0; i < files.size(); i++) {
			if(files.get(i).getOriginalFilename()!="") cnt=cnt+1;
		}
		if(cnt>0) {
			ArrayList<AnimalImgDto> imgDtos=dao.missing_ani_detail_img(total_id);
			if(imgDtos.size()!=0) {
				for (int i = 0; i < imgDtos.size(); i++) {
					String fileName=imgDtos.get(i).getFilename();
					File file = new File(filePath, fileName);
					file.delete();
				}
				dao.missing_ani_delete_img(total_id);}}
		
		// 내용 수정
		if(Missingday.equals("")|| address.equals("")|| animalname.equals("") || animalkind1.equals("축종을 선택하세요") || 
				addressCode1.equals("지역을 선택하세요")) {
			result="redirect:missing_ani_modify_page?total_id="+total_id;
		}else {
			dao.missing_ani_modify(openclose, Missingday, address, animalname, animalkind1, animalkind2,sexCd,weight,
					age, sepcialMark,addressCode1, addressCode2,total_id);
			for (int i = 0; i < files.size(); i++) {
				if(files.get(i).getOriginalFilename()=="") {
					continue;
				}else if(files.get(i).getOriginalFilename()!=""){
					try {
						UUID uuid=UUID.randomUUID();
						String fileName="resources/ani_img/"+uuid+"_"+files.get(i).getOriginalFilename();
						File saveFile = new File(filePath, fileName);
						files.get(i).transferTo(saveFile);
						dao.imgUpLoad(userId,(i+1),animalname,fileName,animalkind1);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			result="redirect:missing_ani_search_page";}
		return result;}
	
	@Override
	public String mypage_ani_modify(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		ArrayList<MultipartFile> files = (ArrayList<MultipartFile>) map.get("files");
		String result=""; MissingAnimalDao dao = sqlSession.getMapper(MissingAnimalDao.class);
		
		String openclose=request.getParameter("openclose"); String Missingday=request.getParameter("Missingday");
		String address=request.getParameter("address"); String animalname=request.getParameter("animalname");
		String animalkind1=request.getParameter("animalkind1"); String animalkind2=request.getParameter("animalkind2");
		String sexCd=request.getParameter("sexCd"); String weight=request.getParameter("weight"); String age=request.getParameter("age");
		String sepcialMark=request.getParameter("sepcialMark"); String userId=request.getParameter("userId"); 
		String addressCode1=request.getParameter("addressCode1"); String addressCode2=request.getParameter("addressCode2");
		String total_id = request.getParameter("total_id");
		//기존 업로드 사진 삭제
		int cnt=0;
		for (int i = 0; i < files.size(); i++) {
			if(files.get(i).getOriginalFilename()!="") cnt=cnt+1;
		}
		if(cnt>0) {
			ArrayList<AnimalImgDto> imgDtos=dao.missing_ani_detail_img(total_id);
			if(imgDtos.size()!=0) {
				for (int i = 0; i < imgDtos.size(); i++) {
					String fileName=imgDtos.get(i).getFilename();
					File file = new File(filePath, fileName);
					file.delete();
				}
				dao.missing_ani_delete_img(total_id);}}
		
		// 내용 수정
		if(Missingday.equals("")|| address.equals("")|| animalname.equals("") || animalkind1.equals("축종을 선택하세요") || 
				addressCode1.equals("지역을 선택하세요")) {
			result="redirect:mypage_ani_modify_page?total_id="+total_id;
		}else {
			dao.missing_ani_modify(openclose, Missingday, address, animalname, animalkind1, animalkind2,sexCd,weight,
					age, sepcialMark,addressCode1, addressCode2,total_id);
			for (int i = 0; i < files.size(); i++) {
				if(files.get(i).getOriginalFilename()=="") {
					continue;
				}else if(files.get(i).getOriginalFilename()!=""){
					try {
						UUID uuid=UUID.randomUUID();
						String fileName="resources/ani_img/"+uuid+"_"+files.get(i).getOriginalFilename();
						File saveFile = new File(filePath, fileName);
						files.get(i).transferTo(saveFile);
						dao.imgUpLoad(userId,(i+1),animalname,fileName,animalkind1);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			result="redirect:mypage_post_list_page";}
		return result;}
}