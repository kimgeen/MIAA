package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryDto {
	private String rnum;
	private String user_id;
	private String board_num;
	private String board_title;
	private String board_content;
	private String board_registration_date;
	private String board_reply_status;
	private String board_filesrc;
}
