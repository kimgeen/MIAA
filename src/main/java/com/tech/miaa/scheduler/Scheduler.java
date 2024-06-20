package com.tech.miaa.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tech.miaa.abdmApi.AbandonmentPublicSrvc;
import com.tech.miaa.abdmApi.AbdmPublicItem;
import com.tech.miaa.dao.MatchingAlarmDao;
import com.tech.miaa.dao.MemberDao;
import com.tech.miaa.dao.MissingAnimalDao;
import com.tech.miaa.dto.AnimalDto;
import com.tech.miaa.dto.FounditemDto;
import com.tech.miaa.dto.ItemDto;
import com.tech.miaa.dto.LastDataCheckDto;
import com.tech.miaa.dto.MemberDto;
import com.tech.miaa.service.FounditemService;
import com.tech.miaa.service.MatchingAlarmService;
import com.tech.miaa.serviceInter.MypageMatchingAlarmServiceInter;
import com.tech.miaa.util.PrdCode;

@Component
public class Scheduler {

	@Autowired
	private SqlSession sqlSession;

	// sec/min/hour/day/month/day of week/year
	// 0-59/0-59/0~23/1-31/1-12/0-6/생략가능

	// 동물 및 습득물 데이터 저장
//	@Scheduled(cron = "* * 0/2 * * *")
	public void updateTotalItemData() {
		System.out.println("DB_insert 테스트 : " + new Date());

		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		MatchingAlarmDao matchingAlarmDao = sqlSession.getMapper(MatchingAlarmDao.class); // api 호출
		FounditemService founditemService = new FounditemService();

		LastDataCheckDto lastcodes = matchingAlarmDao.getlastcheck("atcid");
		// 전날 가장앞자리 데이터의 번호
		String lastcode = lastcodes.getPrimeID();
		System.out.println("습득물 최근번호 : " + lastcode);
		// 임시저장
		String dummy_primeID = "";
		boolean last_chk = false;
		int total = 0;
		String status = lastcodes.getStatus();
		System.out.println("api진입전 습득물 상태 : " + lastcodes.getStatus());

		if (lastcode == null) {
			System.out.println("db체크값이 비었으므로 2024-01-01로 초기화합니다.");
			matchingAlarmDao.updateStatus("done", "atcid");
			matchingAlarmDao.updatePrimeID("F2024042000000185", "atcid");
		}

		for (int i = 1; i <= 1000; i++) {
			System.out.println("습득물 데이터 시작"+i+"번");
			
			if (last_chk) {
				matchingAlarmDao.updateStatus("done", "atcid");
				matchingAlarmDao.updatePrimeID(dummy_primeID, "atcid");
				System.out.println("습득물데이터 저장 완료");
				System.out.println("date 입력 갯수 : " + total);
				break;
			}

			String code = founditemService.found_item_search_AreaPd(i);
			ArrayList<FounditemDto> founditemDtos = founditemService.getFoundList(code);
			int index = 0;
			// db 저장
			for (FounditemDto dto : founditemDtos) {

				if (dto.getAtcid().equals(lastcode)) {
					total = ((i - 1) * 100) + index;
					last_chk = true;
					break;
				} else if (i == 1 && dto.getRnum().equals("1")) {
					matchingAlarmDao.updateStatus("push", "atcid");
					dummy_primeID = dto.getAtcid();
				}

				if (dto.getAtcid() == null) {
					dto.setAtcid("");
				}
				if (dto.getFdSbjt() == null) {
					dto.setFdSbjt("");
				}
				if (dto.getFdSn() == null) {
					dto.setFdSn("");
				}
				if (dto.getPrdtClNm() == null) {
					dto.setPrdtClNm("");
				}
				if (dto.getFdPrdtNm() == null) {
					dto.setFdPrdtNm("");
				}
				if (dto.getFdYmd() == null) {
					dto.setFdYmd("");
				}
				if (dto.getDepPlace() == null) {
					dto.setDepPlace("");
				}
				if (dto.getRnum() == null) {
					dto.setRnum("");
				}
				if (dto.getClrNm() == null) {
					dto.setClrNm("");
				}
				if (dto.getFdFilePathImg() == null) {
					dto.setFdFilePathImg("");
				}
				if (dto.getAddr() == null) {
					dto.setAddr("");
				}
				try {
					matchingAlarmDao.total_item_write(dto.getAtcid(), dto.getClrNm(), dto.getDepPlace(),
							dto.getFdFilePathImg(), dto.getFdPrdtNm(), dto.getFdSbjt(), dto.getFdSn(), dto.getFdYmd(),
							dto.getPrdtClNm(), dto.getRnum(), dto.getAddr());
				} catch (DuplicateKeyException e) {
					System.out.println("중복값발견 : " + dto.getAtcid());
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				index++;
				
			}
			
		}

		MissingAnimalDao missingAnimalDao = sqlSession.getMapper(MissingAnimalDao.class);

		LastDataCheckDto lastcodes2 = matchingAlarmDao.getlastcheck("desertionNo");
		String lastcode2 = lastcodes2.getPrimeID();
		System.out.println("습득동물 최근번호 : " + lastcode2);
		List<AbdmPublicItem> abdmPublicItems = AbandonmentPublicSrvc.abandonmentPublic().getItems();
		int index2 = 0;
		String dummy_primeID2 = "";

		if (lastcode2 == null) {
			System.out.println("db체크값이 비었으므로 초기화합니다.");
			matchingAlarmDao.updateStatus("done", "desertionNo");
			matchingAlarmDao.updatePrimeID("all", "desertionNo");
		}

		for (AbdmPublicItem item : abdmPublicItems) {

			if (index2 == 0) {
				dummy_primeID2 = item.getDesertionNo();
				matchingAlarmDao.updateStatus("push", "desertionNo");

			} else if (item.getDesertionNo().equals(lastcode2)) {
				matchingAlarmDao.updateStatus("done", "desertionNo");
				matchingAlarmDao.updatePrimeID(dummy_primeID2, "desertionNo");
				System.out.println("동물데이터 저장 완료");
				System.out.println("date 입력 갯수 : " + index2);
				break;
			}
			try {
				matchingAlarmDao.total_animal_write(item.getDesertionNo(), item.getFilename(), item.getHappenDt(),
						item.getHappenPlace(), item.getKindCd(), item.getColorCd(), item.getAge(), item.getWeight(),
						item.getNoticeNo(), item.getNoticeSdt(), item.getNoticeEdt(), item.getPopfile(),
						item.getProcessState(), item.getSexCd(), item.getNeuterYn(), item.getSpecialMark(),
						item.getCareNm(), item.getCareTel(), item.getCareAddr(), item.getOrgNm(), item.getChargeNm(),
						item.getOfficetel(), item.getNoticeComment());
			} catch (DuplicateKeyException e) {
				System.out.println("중복값발견 : " + item.getDesertionNo());
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			index2++;
		}

	}

	// 지정된 시간마다 member의 갯수만큼 member가 작성한 분실물키워드를 db와 매칭해 alarm테이블에 삽입
//	@Scheduled(cron = "* * 0/2 * * *")
	public void updatematchingAlarm() {
		MypageMatchingAlarmServiceInter mypageMatchingAlarmServiceInter;
		mypageMatchingAlarmServiceInter = new MatchingAlarmService();
		MemberDao memberdao = sqlSession.getMapper(MemberDao.class);
		MatchingAlarmDao matchingAlarmDao = sqlSession.getMapper(MatchingAlarmDao.class);
		ArrayList<MemberDto> member_list = memberdao.getMembers();
		PrdCode prd = new PrdCode();

		for (MemberDto m_dto : member_list) {
			ArrayList<ItemDto> list = matchingAlarmDao.matching_alarm_list(m_dto.getUser_id());
			for (ItemDto item_dto : list) {
				String kind = item_dto.getUpr_cd() == null ? item_dto.getUpkind() : item_dto.getUpr_cd();
				try {

					String totalID = item_dto.getTotal_id();
					String userID = item_dto.getUser_id();
					String lostday = item_dto.getLostday();

					System.out.println("userID:" + userID);
					System.out.println("totalID:" + totalID);
					System.out.println("lostday:" + lostday);
					System.out.println("kind:" + kind);

					matchingAlarmDao.set_matching_alarm_list(userID, totalID,lostday, kind);

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();

				}

			}
			
			ArrayList<AnimalDto> anilist = matchingAlarmDao.matching_alarm_anilist(m_dto.getUser_id());
			for (AnimalDto ani_dto : anilist) {
				String kind = ani_dto.getUpr_cd() == null ? prd.getPrdNameByCode(("P"+ani_dto.getUpkind()))
						: prd.getPrdNameByCode("C"+ani_dto.getUpr_cd());
				System.out.println("품종:"+kind);
				String totalID = ani_dto.getTotal_id();
				String userID = m_dto.getUser_id();
				String missingday = ani_dto.getMissingday();
				
				matchingAlarmDao.set_matching_alarm_anilist(userID,totalID,missingday,kind);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();

				}
			}

		}
	}

}
