package com.tech.miaa.dto;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.tech.miaa.util.PrdCode.Prd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
	private String total_id;
	private String item_id;
	private String user_tel;
	private String openclose; // 공개여부
	private String lostday; // 분실날짜
	private String address; // 분실장소
	private String item_name; // 분실물 : 물품명
	private String upkind; // 분실물 : 대분류
	private String upr_cd; // 분실물 : 소분류
	private String colorcd; // 색상
	private String sepcialmark; // 특징
	private String user_id;
	private Date item_date; // 
	private String addressCode; 
	private String total_id1;
	private String filename;
}
