package com.tech.miaa.serviceInter;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tech.miaa.vopage.PageVO;

public interface AdminInquiryServiceInter {
	public void inquiry_list(Model model,PageVO pageVo);
	public PageVO get_pagevo(Model model,PageVO pageVo);
	public void set_search_dto(Model model, PageVO pageVo);
	public void inquiry_delete(Model model);
	public int inquiry_delete_for_ajax(Model model);
	public void inquiry_write_page(Model model);
	public void inquiry_write(Model model);
	public void inquiry_detail_page(Model model);
	public void redirect_data_set_for_write(Model model, RedirectAttributes redAttri);
	public void redirect_data_set_for_list(Model model, RedirectAttributes redAttri);
}
