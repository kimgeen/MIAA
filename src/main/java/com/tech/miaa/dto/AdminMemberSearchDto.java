package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminMemberSearchDto {
	private int rowStart;
	private int rowEnd;
	private String JOIN_START_YMD;
	private String JOIN_END_YMD;
	private String START_YMD;
	private String END_YMD;
	private String member_grade;
	private String search_type;
	private String search_content;
}
