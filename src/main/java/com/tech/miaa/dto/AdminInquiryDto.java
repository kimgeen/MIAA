package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminInquiryDto {
	private int board_num;
	private String board_reply_date;
	private String board_reply;
	private String admin_id;
	private InquiryDto userInquiry;
}
