
package com.tech.miaa.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.tech.miaa.dto.ItemDto;
import com.tech.miaa.vopage.PageVO;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.tech.miaa.dto.FounddetailDto;
import com.tech.miaa.dto.FounditemDto;
import com.tech.miaa.dto.FoundsearchDto;
import com.tech.miaa.serviceInter.FounditemServiceInter;
import com.tech.miaa.util.PrdCode;

public class FounditemService implements FounditemServiceInter {

	public static String ServiceKey = "XDBJ0UVn425mRe%2Fi9JDxdSEyLFFr1xKIRRPGJGZDKuR6QfNj4CbpIg0V%2FGxI6VbU8FM6e3tr70yQNMZ13cd%2BJw%3D%3D"; // 서비스키
	private int total = 0;
	private int AllsearchPage = 1;

	@Override
	// 분류별, 지역별, 기간별 습득물 정보 조회
	// GetLosfundInfoAccToClAreaPd
	public String found_item_search_AreaPd(Model model) {
		// TODO Auto-generated method stub
		PrdCode prd = new PrdCode();
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String result_code = ""; // 전체 결과값
		String PRDT_CL_CD_01 = ""; // 대분류
		String PRDT_CL_CD_02 = ""; // 중분류
		String FD_COL_CD = ""; // 색상코드
		String START_YMD = ""; // 시작일
		String END_YMD = ""; // 종료일
		String N_FD_LCT_CD = ""; // 습득지역(코드)

//		if (request.getParameter("cityname2").equals("") && !request.getParameter("cityname").equals(""))
//			N_FD_LCT_CD = request.getParameter("cityname");
//		else if (!request.getParameter("cityname2").equals("") && !request.getParameter("cityname2").isEmpty())
//			N_FD_LCT_CD = request.getParameter("cityname2");
		
		if (!request.getParameter("cityname").equals(""))
			N_FD_LCT_CD = request.getParameter("cityname");
		
		String pageNo = request.getParameter("allsearchPage");

		if ((!request.getParameter("prd_mainCategory").equals(""))
				&& (!request.getParameter("prd_mainCategory").isEmpty()))
			PRDT_CL_CD_01 = request.getParameter("prd_mainCategory");

		System.out.println("중분류원제목 : " + request.getParameter("prd_subCategory"));
		System.out.println("중분류코드:" + PRDT_CL_CD_02);
		if ((!request.getParameter("prd_subCategory").equals(""))
				&& (!request.getParameter("prd_subCategory").isEmpty()))
			PRDT_CL_CD_02 = prd.getPrdCode(request.getParameter("prd_subCategory").replace(" ", "")).toString();
		System.out.println("중분류코드:" + PRDT_CL_CD_02);
		if (!request.getParameter("color").equals(""))
			FD_COL_CD = request.getParameter("color");
		if (!request.getParameter("START_YMD").equals(""))
			START_YMD = request.getParameter("START_YMD");
		if (!request.getParameter("END_YMD").equals(""))
			END_YMD = request.getParameter("END_YMD");
		
		if (pageNo == null || pageNo.equals(""))
			pageNo = "1";

		System.out.println("인터내부\n" + "대분류 : " + PRDT_CL_CD_01 + "\n중분류 : " + PRDT_CL_CD_02 + "\n시작종료일 : " + START_YMD
				+ "~" + END_YMD + "\n도시 : " + N_FD_LCT_CD);

		try {
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1320000/LosfundInfoInqireService/getLosfundInfoAccToClAreaPd"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + ServiceKey); /* Service Key 서비스키 */
			if (!PRDT_CL_CD_01.equals(""))
				urlBuilder.append("&" + URLEncoder.encode("PRDT_CL_CD_01", "UTF-8") + "="
						+ URLEncoder.encode(PRDT_CL_CD_01, "UTF-8")); /* 대분류 */
			if (!PRDT_CL_CD_02.equals(""))
				urlBuilder.append("&" + URLEncoder.encode("PRDT_CL_CD_02", "UTF-8") + "="
						+ URLEncoder.encode(PRDT_CL_CD_02, "UTF-8")); /* 중분류 */
			if (!FD_COL_CD.equals(""))
				urlBuilder.append("&" + URLEncoder.encode("FD_COL_CD", "UTF-8") + "="
						+ URLEncoder.encode(FD_COL_CD, "UTF-8")); /* 습득물 색상 */
			if (!START_YMD.equals(""))
				urlBuilder.append("&" + URLEncoder.encode("START_YMD", "UTF-8") + "="
						+ URLEncoder.encode(START_YMD.replace("-", ""), "UTF-8")); /* 검색시작일 */
			if (!END_YMD.equals(""))
				urlBuilder.append("&" + URLEncoder.encode("END_YMD", "UTF-8") + "="
						+ URLEncoder.encode(END_YMD.replace("-", ""), "UTF-8")); /* 검색종료일 */
			if (!N_FD_LCT_CD.equals(""))
				urlBuilder.append("&" + URLEncoder.encode("N_FD_LCT_CD", "UTF-8") + "="
						+ URLEncoder.encode(N_FD_LCT_CD, "UTF-8")); /* 습득지역 */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /* 페이지 번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("100", "UTF-8")); /* 목록 건수 우선 10으로 설정 */
			System.out.println(urlBuilder.toString());
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();

			/*
			 * 장문의 xml코드를 String화 해서 result_code에 저장 후 parsing작업
			 */
			result_code = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result_code;

	}

	// 습득물 명칭, 보관 장소별 습득물 정보 조회
	// GetLosfundInfoAccTpNmCstdyPlace
	@Override
	public String found_item_search_Place(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String result_code = ""; // 전체 결과값
//		public static ArrayList<Lostitem> list = new ArrayList<Lostitem>(); // 습득물품 리스트
		String PRDT_NM = request.getParameter("PRDT_NM"); // 물품명
		String DEP_PLACE = request.getParameter("DEP_PLACE"); // 보관장소
		String pageNo = request.getParameter("pageNo"); // 페이지번호

		if (PRDT_NM == null)
			PRDT_NM = "";
		if (DEP_PLACE == null)
			DEP_PLACE = "";
		if (pageNo == null || pageNo.equals(""))
			pageNo = "1";

		try {
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1320000/LosfundInfoInqireService/getLosfundInfoAccTpNmCstdyPlace"); /*
																												 * URL
																												 */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + ServiceKey); /* Service Key */
			if (!PRDT_NM.equals(""))
				urlBuilder.append("&" + URLEncoder.encode("PRDT_NM", "UTF-8") + "="
						+ URLEncoder.encode(PRDT_NM, "UTF-8")); /* 물품명 */
			if (!DEP_PLACE.equals(""))
				urlBuilder.append("&" + URLEncoder.encode("DEP_PLACE", "UTF-8") + "="
						+ URLEncoder.encode(DEP_PLACE, "UTF-8")); /* 보관장소 */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /* 페이지 번호 */
			urlBuilder.append(
					"&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* 목록 건수 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			System.out.println(sb.toString());

			/*
			 * 장문의 xml코드를 String화 해서 result_code에 저장 후 parsing작업
			 */
			result_code = sb.toString();
			return result_code;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result_code;
	}

	private static String getElementValue(Element parentElement, String tagName) {
		NodeList nodeList = parentElement.getElementsByTagName(tagName);
		if (nodeList.getLength() > 0) {
			Node node = nodeList.item(0);
			if (node.getFirstChild() != null) {
				return node.getFirstChild().getNodeValue();
			}
		}
		return null;
	}

	public ArrayList<FounditemDto> getFoundList(String rsCode) {

		ArrayList<FounditemDto> list = new ArrayList<FounditemDto>();

		try {
			// XML 문자열을 Document 객체로 파싱
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(rsCode)));

			// <item> 요소들을 NodeList로 가져옴
			NodeList itemList = doc.getElementsByTagName("item");
			NodeList totalCountList = doc.getElementsByTagName("totalCount"); // 검색결과 갯수
			NodeList pageNo = doc.getElementsByTagName("pageNo"); // 검색결과 갯수
			
			AllsearchPage = Integer.parseInt(pageNo.item(0).getTextContent());
			
			total = Integer.parseInt(totalCountList.item(0).getTextContent());

			// <item> 요소들을 순회하며 파싱
			for (int i = 0; i < itemList.getLength(); i++) {
				Node itemNode = itemList.item(i);
				if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
					Element itemElement = (Element) itemNode;
					FounditemDto fitem = new FounditemDto();
					// 각 요소의 값 가져오기
					String atcId = getElementValue(itemElement, "atcId");
					String clrNm = getElementValue(itemElement, "clrNm");
					String depPlace = getElementValue(itemElement, "depPlace");
					String fdFilePathImg = getElementValue(itemElement, "fdFilePathImg");
					String fdPrdtNm = getElementValue(itemElement, "fdPrdtNm");
					String fdSbjt = getElementValue(itemElement, "fdSbjt");
					String fdSn = getElementValue(itemElement, "fdSn");
					String fdYmd = getElementValue(itemElement, "fdYmd");
					String prdtClNm = getElementValue(itemElement, "prdtClNm");
					String rnum = getElementValue(itemElement, "rnum");
					String addr = getElementValue(itemElement, "addr");

					// Item 객체 생성하여 리스트에 추가
					fitem.setAtcid(atcId);
					fitem.setFdSbjt(clrNm);
					fitem.setDepPlace(depPlace);
					if (fdFilePathImg.isEmpty())
						fitem.setFdFilePathImg("https://www.lost112.go.kr/lostnfs/images/sub/img02_no_img.gif");
					else
						fitem.setFdFilePathImg(fdFilePathImg);
					fitem.setFdPrdtNm(fdPrdtNm);
					fitem.setFdSbjt(fdSbjt);
					fitem.setFdSn(fdSn);
					fitem.setFdYmd(fdYmd);
					fitem.setPrdtClNm(prdtClNm);
					fitem.setRnum(rnum);
					fitem.setAddr(addr);

					list.add(fitem);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;

	}

	public int getTotal() {
		return total;
	}

	public int getAllsearchPage() {
		return AllsearchPage;
	}

	@Override
	public FounddetailDto found_item_detailview(String atc_id, String fd_sn) {
		// TODO Auto-generated method stub
		String result_code = ""; // 전체 결과값
		FounddetailDto dto = new FounddetailDto();
		try {
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1320000/LosfundInfoInqireService/getLosfundDetailInfo"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + ServiceKey); /* Service Key */
			urlBuilder.append(
					"&" + URLEncoder.encode("ATC_ID", "UTF-8") + "=" + URLEncoder.encode(atc_id, "UTF-8")); /* 관리ID */
			urlBuilder.append(
					"&" + URLEncoder.encode("FD_SN", "UTF-8") + "=" + URLEncoder.encode(fd_sn, "UTF-8")); /* 습득순번 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			System.out.println(sb.toString());

			result_code = sb.toString();

			System.out.println("작동완료, 디테일코드xml : " + result_code);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(result_code)));

			// <item> 요소를 NodeList로 가져옴
			NodeList itemList = doc.getElementsByTagName("item");

			// NodeList에 있는 첫 번째 <item> 요소를 가져옴
			Node itemNode = itemList.item(0);

			if (itemNode != null && itemNode.getNodeType() == Node.ELEMENT_NODE) {
				Element itemElement = (Element) itemNode;
				// 각 요소의 값 가져오기
				dto.setAtcId(getElementValue(itemElement, "atcId"));
				dto.setCsteSteNm(getElementValue(itemElement, "csteSteNm"));
				dto.setDepPlace(getElementValue(itemElement, "depPlace"));
				dto.setFdFilePathImg(getElementValue(itemElement, "fdFilePathImg"));
				dto.setFdHor(getElementValue(itemElement, "fdHor"));
				dto.setFdPlace(getElementValue(itemElement, "fdPlace"));
				dto.setFdPrdtNm(getElementValue(itemElement, "fdPrdtNm"));
				dto.setFdSn(getElementValue(itemElement, "fdSn"));
				dto.setFdYmd(getElementValue(itemElement, "fdYmd"));
				dto.setFndKeepOrgnSeNm(getElementValue(itemElement, "fndKeepOrgnSeNm"));
				dto.setOrgId(getElementValue(itemElement, "orgId"));
				dto.setOrgNm(getElementValue(itemElement, "orgNm"));
				dto.setPrdtClNm(getElementValue(itemElement, "prdtClNm"));
				dto.setTel(getElementValue(itemElement, "tel"));
				dto.setUniq(getElementValue(itemElement, "uniq"));
			}

			System.out.println("----------------------------------------------------");
			System.out.println("관리ID : " + dto.getAtcId());
			System.out.println("보관상태명 : " + dto.getCsteSteNm());
			System.out.println("보관장소 : " + dto.getDepPlace());
			System.out.println("습득물사진파일경로 : " + dto.getFdFilePathImg());
			System.out.println("습득시간 : " + dto.getFdHor());
			System.out.println("습득장소 : " + dto.getFdPlace());
			System.out.println("물품명 : " + dto.getFdPrdtNm());
			System.out.println("습득순번 : " + dto.getFdSn());
			System.out.println("습득일자 : " + dto.getFdYmd());
			System.out.println("습득물보관기관구분명 : " + dto.getFndKeepOrgnSeNm());
			System.out.println("기관아이디 : " + dto.getOrgId());
			System.out.println("기관명 : " + dto.getOrgNm());
			System.out.println("물품분류명 : " + dto.getPrdtClNm());
			System.out.println("전화번호 : " + dto.getTel());
			System.out.println("특이사항 : " + dto.getUniq());
			System.out.println("----------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public FoundsearchDto getFoundsearchValue(Model model) {
		FoundsearchDto dto = new FoundsearchDto();
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		dto.setCity(request.getParameter("cityname"));
//		dto.setCity2(request.getParameter("cityname2"));
		dto.setColor(request.getParameter("color"));
		dto.setStartYMD(request.getParameter("START_YMD"));
		dto.setEndYMD(request.getParameter("END_YMD"));
		dto.setMainCategory(request.getParameter("prd_mainCategory"));
		dto.setSubCategory(request.getParameter("prd_subCategory"));
		return dto;
	}

	public String found_item_search_AreaPd(ItemDto itemDto) {
		String result_code = ""; // 전체 결과값

		try {
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1320000/LosfundInfoInqireService/getLosfundInfoAccToClAreaPd"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + ServiceKey); /* Service Key 서비스키 */
			if (!itemDto.getUpkind().equals(""))
				urlBuilder.append("&" + URLEncoder.encode("PRDT_CL_CD_01", "UTF-8") + "="
						+ URLEncoder.encode(itemDto.getUpkind(), "UTF-8")); /* 대분류 */
			if (!itemDto.getUpr_cd().equals(""))
				urlBuilder.append("&" + URLEncoder.encode("PRDT_CL_CD_02", "UTF-8") + "="
						+ URLEncoder.encode(itemDto.getUpr_cd(), "UTF-8")); /* 중분류 */
//			if (!itemDto.getColorcd().equals(""))
//				urlBuilder.append("&" + URLEncoder.encode("FD_COL_CD", "UTF-8") + "="
//						+ URLEncoder.encode(itemDto.getColorcd(), "UTF-8")); /* 습득물 색상 */
			if (!itemDto.getLostday().equals(""))
				urlBuilder.append("&" + URLEncoder.encode("START_YMD", "UTF-8") + "="
						+ URLEncoder.encode(itemDto.getLostday().replace("-", ""), "UTF-8")); /* 검색시작일 */
//			if (!END_YMD.equals(""))
//				urlBuilder.append("&" + URLEncoder.encode("END_YMD", "UTF-8") + "="
//						+ URLEncoder.encode(END_YMD.replace("-", ""), "UTF-8")); /* 검색종료일 */
			if (!itemDto.getAddressCode().equals(""))
				urlBuilder.append("&" + URLEncoder.encode("N_FD_LCT_CD", "UTF-8") + "="
						+ URLEncoder.encode(itemDto.getAddressCode(), "UTF-8")); /* 습득지역 */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("500", "UTF-8")); /* 목록 건수 우선 10으로 설정 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			result_code = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result_code;

	}
	
	
	public String found_item_search_AreaPd(int search_page) {
		String result_code = ""; // 전체 결과값

		try {
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1320000/LosfundInfoInqireService/getLosfundInfoAccToClAreaPd"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + ServiceKey); /* Service Key 서비스키 */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(search_page), "UTF-8")); /* 페이지 번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("100", "UTF-8")); /* 목록 건수 우선 10으로 설정 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			result_code = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result_code;

	}
	
	
}
