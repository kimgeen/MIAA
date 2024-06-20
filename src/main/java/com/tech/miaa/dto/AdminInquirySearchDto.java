package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminInquirySearchDto {
	private int rowStart;
	private int rowEnd;
	private String START_YMD;
	private String END_YMD;
	private String reply_status;
	private String search_type;
	private String search_content;
}
