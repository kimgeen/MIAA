package com.tech.miaa.serviceInter;

import org.springframework.ui.Model;

import com.tech.miaa.dto.AdminInquiryDto;
import com.tech.miaa.dto.InquiryDto;
import com.tech.miaa.vopage.PageVO2;

public interface MypageCustomerInquiryServiceInter {
	public void inquiry_wirte(Model model);
	/* public ArrayList<InquiryDto> inquiry_list(Model model,PageVO pageVo); */
	public InquiryDto modify_list(Model model);
	public AdminInquiryDto detail_list(Model model);
	public void inquiry_modify(Model model);
	public void delete(String string, Model model);
	public void inquiry_list(Model model, PageVO2 pageVo2);
	public PageVO2 get_pagevo(Model model,PageVO2 pageVo,String id);
	
	
}
