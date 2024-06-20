package com.tech.miaa.dto;

import com.tech.miaa.vopage.PageVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalSearchDto {
	private String search_str_date;
	private String search_end_date;
	private String sidoSelectBox;
	private String sigunguSelectBox;
	private String shelterSelectBox;
	private String upKindSelectBox;
	private String kindSelectedBox;
//	private String sexSelectedBox;
//	private PageVO pageVO;
//	private String pageNo;
//	private String pageShift;

	//
//	public String getSearch_str_date() {
//		return search_str_date;
//	}
//	public void setSearch_str_date(String search_str_date) {
//		String charsToRemove = "-";
//		for (char c : charsToRemove.toCharArray()) {
//			search_str_date = search_str_date.replace(String.valueOf(c), "");
//		}
//		this.search_str_date = search_str_date;
//	}
//
//	public String getSearch_end_date() {
//		return search_end_date;
//	}
//
//	public void setSearch_end_date(String search_end_date) {
//		String charsToRemove = "-";
//		for (char c : charsToRemove.toCharArray()) {
//			search_end_date = search_end_date.replace(String.valueOf(c), "");
//		}
//		this.search_end_date = search_end_date;
//	}
}
