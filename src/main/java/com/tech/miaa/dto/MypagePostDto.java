package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MypagePostDto {
	private String total_id;
	private String item_id;
	private String animal_id;
	private String day;
	private String address;
	private String name;
	private String upkind;
	private String filename;
	private String kind;
}
