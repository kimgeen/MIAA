package com.tech.miaa.serviceInter;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.tech.miaa.dto.AnimalDto;
import com.tech.miaa.dto.ItemDto;
import com.tech.miaa.dto.matchingAlarmDto;
// 원진호_알림목록_0401추가
public interface MypageMatchingAlarmServiceInter {
   /* public String mypage_matching_alarm(Model model); */
   /* 원진호_0409_추가 */
   ArrayList<ItemDto> matching_alarm_list(Model model);
//   ItemDto matching_alarm_dto(t)
   ArrayList<AnimalDto> matching_alarm_anilist(Model model);
   public void mypage_alarm_delete(String string, Model model);
   ArrayList<matchingAlarmDto> alert_item_list(Model model);
   
   /* 원진호_0417추가 */   
   /* 등록된 분실물의 소분류추출 쿼리  */
//   ArrayList<matchingAlarmDto> lost_item_upr_cd(Model model);
   
}