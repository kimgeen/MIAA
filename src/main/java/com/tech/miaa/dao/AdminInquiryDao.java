package com.tech.miaa.dao;

import java.util.ArrayList;
import java.util.List;

import com.tech.miaa.dto.AdminInquiryDto;
import com.tech.miaa.dto.AdminInquirySearchDto;

public interface AdminInquiryDao {

	public Integer get_total(AdminInquirySearchDto dto);
	public ArrayList<AdminInquiryDto> join_inquiry_list(AdminInquirySearchDto dto);
	public AdminInquiryDto inquiry_detail_page(String bn);
	public AdminInquiryDto inquiry_write_page(String bn);
	public int inquiry_write1(String board_num, String id, String board_reply);
	public int inquiry_write2(String board_num);
	public int inquiry_delete(String board_num);
	public int inquiry_delete_for_ajax(List<String> chkValList);
}
