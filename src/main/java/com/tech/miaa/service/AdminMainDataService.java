
package com.tech.miaa.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.tech.miaa.dao.AdminMainDataDao;
import com.tech.miaa.dto.AdminDataDto1;
import com.tech.miaa.serviceInter.AdminMainDataServiceInter;

public class AdminMainDataService implements AdminMainDataServiceInter {

	@Override
	public void get_main_data(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SqlSession sqlSession = (SqlSession) map.get("sqlSession");
		String id = (String) map.get("userId");



		// db에서 list가져오기
		AdminMainDataDao dao = sqlSession.getMapper(AdminMainDataDao.class);
		List<AdminDataDto1> list1 = null;
	

			try {
				list1 = dao.get_count_anikind_by_date();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Gson 객체 생성
			Gson gson = new Gson();

			// Java 객체를 JSON 형식의 문자열로 변환
			String json1 = gson.toJson(list1);
			
			
//			System.out.println(json1);
			model.addAttribute("list1", json1);

	}

	
}
