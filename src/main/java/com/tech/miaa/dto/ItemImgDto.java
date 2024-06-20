package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemImgDto {
	private int total_id;
	private int file_id;
	private String user_id;
	private String filename;
}
