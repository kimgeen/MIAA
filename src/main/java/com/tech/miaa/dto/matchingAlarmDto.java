package com.tech.miaa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class matchingAlarmDto {
   
   private int total_id; // 게시물 토탈 id
   private String user_id; // 사용자id
   private String primeid;  // 관리ID
   private String type;
   private String alarm_check;
   
}