package com.tech.miaa.dto;

import lombok.AllArgsConstructor;

public class FounditemDto {

	/*기본값 8개 */
	String atcid;		// 관리ID	
	String fdSbjt;		// 게시글제목
	String fdSn;		// 습득순번
	String prdtClNm;	// 물품분류명
	String fdPrdtNm; 	// 물품명
	String fdYmd;		// 습득일자
	String depPlace;	// 보관장소
	String rnum;		// 검색결과 글번호(검색 후 결과값 페이지이동시에도 보존)
	
	/*색상*/
	String clrNm;		// 색상명
	
	/*이미지*/
	String fdFilePathImg;	// 습득물이미지명(주소)
	
	/*도로명주소*/
	String addr;	// 기관도로명주소
	
	public String getClrNm() {
		return clrNm;
	}
	public void setClrNm(String clrNm) {
		this.clrNm = clrNm;
	}
	public String getFdSn() {
		return fdSn;
	}
	public void setFdSn(String fdSn) {
		this.fdSn = fdSn;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAtcid() {
		return atcid;
	}
	public void setAtcid(String atcid) {
		this.atcid = atcid;
	}
	public String getFdSbjt() {
		return fdSbjt;
	}
	public void setFdSbjt(String fdSbjt) {
		this.fdSbjt = fdSbjt;
	}
	public String getPrdtClNm() {
		return prdtClNm;
	}
	public void setPrdtClNm(String prdtClNm) {
		this.prdtClNm = prdtClNm;
	}
	public String getFdPrdtNm() {
		return fdPrdtNm;
	}
	public void setFdPrdtNm(String fdPrdtNm) {
		this.fdPrdtNm = fdPrdtNm;
	}
	public String getFdYmd() {
		return fdYmd;
	}
	public void setFdYmd(String fdYmd) {
		this.fdYmd = fdYmd;
	}
	public String getDepPlace() {
		return depPlace;
	}
	public void setDepPlace(String depPlace) {
		this.depPlace = depPlace;
	}
	public String getFdFilePathImg() {
		return fdFilePathImg;
	}
	public void setFdFilePathImg(String fdFilePathImg) {
		this.fdFilePathImg = fdFilePathImg;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	
}
