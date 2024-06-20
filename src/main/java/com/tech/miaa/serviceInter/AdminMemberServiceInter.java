package com.tech.miaa.serviceInter;

import com.tech.miaa.vopage.PageVO;
import org.springframework.ui.Model;

public interface AdminMemberServiceInter {
	public String admin_join(Model model);
	public int admin_idchek(Model model);
	public int admin_emailchk(Model model);
	public int admin_codechk(Model model);
	public void member_list(Model model,PageVO pageVo);
	public int joined_member_delete_for_ajax(Model model);
}
