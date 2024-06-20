package com.tech.miaa.dto;

import com.tech.miaa.abdmApi.AbdmPublicItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnimalDetailDto {

	private AbdmPublicItem item;
	private String upKind;
	private String kind;
	public AnimalDetailDto(AbdmPublicItem item) {
		this.item = item;
	}

	public String getUpKind() {
		int start =item.getKindCd().indexOf("[");
		int end = item.getKindCd().indexOf("]")+1;
		this.upKind = item.getKindCd().substring(start,end);
		return this.upKind;
	}

	public String getKind() {
		int start = item.getKindCd().indexOf("]")+2;
		int end = item.getKindCd().length();
		kind = item.getKindCd().substring(start,end);
		return kind;
	}


}
