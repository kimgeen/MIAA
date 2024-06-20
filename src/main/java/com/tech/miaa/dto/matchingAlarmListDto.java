package com.tech.miaa.dto;

import java.util.ArrayList;

import com.tech.miaa.abdmApi.AbdmPublicItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class matchingAlarmListDto {
   private ItemDto item_dto;
   private AnimalDto animal_dto;
   private ArrayList<FounditemDto> matching_item_dto;
   private ArrayList<AbdmPublicItem> matching_animal_dto;
   private int total_id;
}