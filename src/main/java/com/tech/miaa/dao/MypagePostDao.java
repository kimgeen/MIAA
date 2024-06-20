package com.tech.miaa.dao;

import com.tech.miaa.dto.MemberDto;
import com.tech.miaa.dto.MypagePostDto;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MypagePostDao {
	public ArrayList<MypagePostDto> mypage_post_list_page(@Param("userId")String userId, 
			@Param("rowStart")int rowStart, @Param("rowEnd")int rowEnd, @Param("reply_status")String reply_status);
	public int totalCount(@Param("userId")String userId,@Param("reply_status")String reply_status);
}
