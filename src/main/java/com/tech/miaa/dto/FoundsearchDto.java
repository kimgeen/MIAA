package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoundsearchDto {

	private String city;
//	private String city2;
	private String startYMD;
	private String endYMD;
	private String mainCategory;
	private String subCategory;
	private String color;
	
}
