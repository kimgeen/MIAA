package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSearchDto {
	private String search_str_date;
	private String search_end_date;
	private String sidoSelectBox;
	private String upKindSelectBox;
	private String kindSelectedBox;
	private String colorCd;
	private int rowStart;
	private int rowEnd;
}
