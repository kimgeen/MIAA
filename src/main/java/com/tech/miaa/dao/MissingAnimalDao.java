package com.tech.miaa.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.tech.miaa.dto.AnimalDto;
import com.tech.miaa.dto.AnimalImgDto;

public interface MissingAnimalDao {
	public void animalWrite(String user_tel, String openclose, String missingday,String address,String animalname,
			String sexCd,String weight,String animalkind1,String animalkind2, String age,String sepcialMark,
			String userId,String addresscode1, String addresscode2);
	public void imgUpLoad(String userId, int i, String animalname, String fileName, String animalkind1);

	public ArrayList<AnimalDto> get_missing_animals(String user_id);

	public int totalCount(@Param("searchday1")String searchday1, @Param("searchday2")String searchday2, 
			@Param("addressCode1")String addressCode1,@Param("addressCode2")String addressCode2, 
			@Param("animalkind1")String animalkind1, @Param("animalkind2")String animalkind2);
	public ArrayList<AnimalDto> animalListView(@Param("searchday1")String searchday1, @Param("searchday2")String searchday2, 
			@Param("addressCode1")String addressCode1,@Param("addressCode2")String addressCode2, 
			@Param("animalkind1")String animalkind1, @Param("animalkind2")String animalkind2, 
			@Param("rowStart")int rowStart, @Param("rowEnd")int rowEnd);
	public AnimalDto missing_ani_detail_page(String total_id);
	public ArrayList<AnimalImgDto> missing_ani_detail_img(String total_id);
	public void missing_ani_delete_img(String total_id);
	public void missing_ani_modify(String openclose, String Missingday, String address, String animalname, String animalkind1, 
			String animalkind2, String sexCd,String weight, String age, String sepcialMark, String addressCode1, 
			String addressCode2, String total_id);
	public void missing_ani_delete_content(String total_id);
}
