package com.tech.miaa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FounddetailDto {

	private String atcId;//ex)F2018113000002322 - 관리번호
	private String csteSteNm;//ex)종결</csteSteNm> - 유실물상태
	private String depPlace;//ex)서울강북경찰서</depPlace> - 접수장소
	private String fdFilePathImg;//ex)https://www.lost112.go.kr/lostnfs/images/sub/img04_no_img.gif - 사진주소
	private String fdHor;//ex)24  - 습득시간
	private String fdPlace;//ex)노상  - 습득장소
	private String fdPrdtNm;//ex) 영성용가박  - 물품명
	private String fdSn;//ex)1 습득순번
	private String fdYmd;//ex) 2018-11-30   - 습득일자
	private String fndKeepOrgnSeNm;//ex)관서보관  - 습득물보관기관구분명
	private String orgId;//ex) O0000129  - 기관아이디
	private String orgNm;//ex) 서울강북경찰서  - 기관명
	private String prdtClNm;//ex) 가방 > 여성용가방  - 물품분류명
	private String tel; //ex) 02-944-4347  - 전화번호
	private String uniq;//ex) 내용 번동파출소에서는 [2018.11.30] [영성용가박(핑크(분홍)색)]을 습득/보관 하였습니다  - 특이사항
	
	
	
}
