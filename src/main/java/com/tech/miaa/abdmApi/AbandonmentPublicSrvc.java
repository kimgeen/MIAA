package com.tech.miaa.abdmApi;

import java.net.URLEncoder;

import com.tech.miaa.dto.AnimalDto;
import com.tech.miaa.dto.AnimalSearchDto;

public class AbandonmentPublicSrvc {
    private final static String API_KEY = "hm0qJL%2FrZFagiGGwrhjAQ6KMXI2DOUcHs5uVRpIGSk0k1yvSZiQDcIr%2BzGHVVbw1Cs0n2wAIZNlzXcaeJbukmQ%3D%3D";
    private final static String BASIC_URL = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/";

    private StringBuilder urlBuilder;

    /*시도 조회
     * 동물보호관리시스템의 유기동물조회 조회조건의 '시도'조건을 가져올 수 있다.
     * call back url:http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido
     * 최대사이즈 : [4000] byte
     * 평균응답시간 :  [500] ms
     * 초당 최대 트랙잭션 : [30] tps */
    public static AbdmSido getSido() {
        AbdmSido sido = new AbdmSido();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + API_KEY); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수(1,000 이하)*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml(기본값) 또는 json*/

            XmlParser xmlParser = new XmlParser();

            sido = (AbdmSido) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETABDMSIDO);
            System.out.println(sido.getHeaderResult().getResultCode());
            System.out.println(sido.getHeaderResult().getResultMsg());
            System.out.println(sido.getHeaderResult().getReqNo());

            for (int i =0; i<sido.getItems().size(); i++){
                System.out.println(sido.getItems().get(i).getOrgCd());
                System.out.println(sido.getItems().get(i).getOrgdownNm());

            }
            System.out.println(sido.getNumOfRows());
            System.out.println(sido.getPageNo());
            System.out.println(sido.getTotalCount());
            System.out.println("+++++++++++++++++++++");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sido;
    }



    /*시군구 조회
     * 동물보호관리시스템의 유기동물조회 조회조건의 '시군구'조건을 가져올 수 있다.
     * call back url:http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu
     * 최대사이즈 : [4000] byte
     * 평균응답시간 :  [500] ms
     * 초당 최대 트랙잭션 : [30] tps */

    public static AbdmSigungu getSigungu(String uprCd) {
        AbdmSigungu sigungu = new AbdmSigungu();

        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + API_KEY); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("upr_cd", "UTF-8") + "=" + URLEncoder.encode(uprCd, "UTF-8")); /*시군구 상위코드(시도코드) (입력 시 데이터 O, 미입력 시 데이터 X)*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml(기본값) 또는 json*/

            XmlParser xmlParser = new XmlParser();

            sigungu = (AbdmSigungu) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETABDMSIGUNGU);
            System.out.println(sigungu.getHeaderResult().getResultCode());
            System.out.println(sigungu.getHeaderResult().getResultMsg());
            System.out.println(sigungu.getHeaderResult().getReqNo());

            for (int i = 0; i < sigungu.getItems().size(); i++) {
                System.out.println(sigungu.getItems().get(i).getUprCd());
                System.out.println(sigungu.getItems().get(i).getOrgCd());
                System.out.println(sigungu.getItems().get(i).getOrgdownNm());
                System.out.println("+++++++++++++++++++++");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sigungu;
    }

    /*보호소 조회
     * 동물보호관리시스템의 유기동물조회 조회조건의 '보호소'조건을 가져올 수 있다.
     * call back url:http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter
     * 최대사이즈 : [4000] byte
     * 평균응답시간 :  [500] ms
     * 초당 최대 트랙잭션 : [30] tps */
    public static AbdmShelter getShelter(String uprCd, String org_cd) {
        AbdmShelter shelter = new AbdmShelter();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + API_KEY); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("upr_cd", "UTF-8") + "=" + URLEncoder.encode(uprCd, "UTF-8")); /*시도코드(입력 시 데이터 O, 미입력 시 데이터 X)*/
            urlBuilder.append("&" + URLEncoder.encode("org_cd", "UTF-8") + "=" + URLEncoder.encode(org_cd, "UTF-8")); /*시군구코드(입력 시 데이터 O, 미입력 시 데이터 X)*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml(기본값) 또는 json*/

            XmlParser xmlParser = new XmlParser();

            shelter = (AbdmShelter) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETABDMSHELTER);
            System.out.println(shelter.getHeaderResult().getResultCode());
            System.out.println(shelter.getHeaderResult().getResultMsg());
            System.out.println(shelter.getHeaderResult().getReqNo());

            for (int i = 0; i < shelter.getItems().size(); i++) {
                System.out.println(shelter.getItems().get(i).getCareNm());
                System.out.println(shelter.getItems().get(i).getCareRegNo());
                System.out.println("+++++++++++++++++++++");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shelter;
    }
    /*품종 조회
     * 동물보호관리시스템의 유기동물조회 조회조건의 '품종'조건을 가져올 수 있다.
     * call back url:http://apis.data.go.kr/1543061/abandonmentPublicSrvc/kind
     * 최대사이즈 : [4000] byte
     * 평균응답시간 :  [500] ms
     * 초당 최대 트랙잭션 : [30] tps */

    //하위 품종 코드 가져오는 method
    public static AbdmKind getkind(String up_kind_cd) {
        AbdmKind kind = new AbdmKind();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/kind"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + API_KEY); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("up_kind_cd", "UTF-8") + "=" + URLEncoder.encode(up_kind_cd, "UTF-8")); /*축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900)*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml(기본값) 또는 json*/

            XmlParser xmlParser = new XmlParser();

            kind = (AbdmKind) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETABDMKIND);
            System.out.println(kind.getHeaderResult().getResultCode());
            System.out.println(kind.getHeaderResult().getResultMsg());
            System.out.println(kind.getHeaderResult().getReqNo());

            for (int i = 0; i < kind.getItems().size(); i++) {
                System.out.println(kind.getItems().get(i).getKindCd());
                System.out.println(kind.getItems().get(i).getKNm());
                System.out.println("+++++++++++++++++++++");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kind;
    }

    /*유기동물 조회
     * 동물보호관리시스템의 유기동물 정보를 조회한다
     * call back url:http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic
     * 최대사이즈 : [4000] byte
     * 평균응답시간 :  [500] ms
     * 초당 최대 트랙잭션 : [30] tps */
    public static AbdmPublic abandonmentPublic(int page) {
        AbdmPublic abdmPublic = new AbdmPublic();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + API_KEY); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(page), "UTF-8")); /*페이지 번호 (기본값 : 1)*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*페이지당 보여줄 개수 (1,000 이하), 기본값 : 10*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml(기본값) 또는 json*/

            XmlParser xmlParser = new XmlParser();

            abdmPublic = (AbdmPublic) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETABDMPUBLIC);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return abdmPublic;
    }

    public static AbdmPublic abandonmentPublic(AnimalSearchDto dto, int pageno) {
        AbdmPublic abdmPublic = new AbdmPublic();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + API_KEY); /*Service Key*/
            if (dto.getSearch_str_date() != null && !dto.getSearch_str_date().isEmpty()) {
                String date ="";
                String charsToRemove = "-";
                for (char c : charsToRemove.toCharArray()) {
                    date = dto.getSearch_str_date().replace(String.valueOf(c), "");
                }
                urlBuilder.append("&" + URLEncoder.encode("bgnde", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*유기날짜(검색 시작일) (YYYYMMDD)*/
            }
            if (dto.getSearch_end_date() != null && !dto.getSearch_end_date().isEmpty()) {
                String date ="";
                String charsToRemove = "-";
                for (char c : charsToRemove.toCharArray()) {
                    date = dto.getSearch_str_date().replace(String.valueOf(c), "");
                }
                urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*유기날짜(검색 종료일) (YYYYMMDD)*/
            }
            if (dto.getUpKindSelectBox() != null && !dto.getUpKindSelectBox().isEmpty()) {
                urlBuilder.append("&" + URLEncoder.encode("upkind", "UTF-8") + "=" + URLEncoder.encode(dto.getUpKindSelectBox(), "UTF-8")); /*축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900)*/
            }
            if (dto.getKindSelectedBox() != null && !dto.getKindSelectedBox().isEmpty()) {
                urlBuilder.append("&" + URLEncoder.encode("kind", "UTF-8") + "=" + URLEncoder.encode(dto.getKindSelectedBox(), "UTF-8")); /*품종코드 (품종 조회 OPEN API 참조)*/
            }
            if (dto.getSidoSelectBox() != null && !dto.getSidoSelectBox().isEmpty()) {
                urlBuilder.append("&" + URLEncoder.encode("upr_cd", "UTF-8") + "=" + URLEncoder.encode(dto.getSidoSelectBox(), "UTF-8")); /*시도코드 (시도 조회 OPEN API 참조)*/
            }
            if (dto.getSigunguSelectBox() != null && !dto.getSigunguSelectBox().isEmpty()) {
                urlBuilder.append("&" + URLEncoder.encode("org_cd", "UTF-8") + "=" + URLEncoder.encode(dto.getSigunguSelectBox(), "UTF-8")); /*시군구코드 (시군구 조회 OPEN API 참조)*/
            }
//            if (!dto.getShelterSelectBox().isEmpty()) {
//                urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" + URLEncoder.encode(dto.getShelterSelectBox(), "UTF-8")); /*보호소번호 (보호소 조회 OPEN API 참조)*/
//            }
            System.out.println(urlBuilder.toString());
//            urlBuilder.append("&" + URLEncoder.encode("state", "UTF-8") + "=" + URLEncoder.encode("protect", "UTF-8")); /*상태(전체 : null(빈값), 공고중 : notice, 보호중 : protect)*/
//            urlBuilder.append("&" + URLEncoder.encode("neuter_yn","UTF-8") + "=" + URLEncoder.encode("U", "UTF-8")); /*상태 (전체 : null(빈값), 예 : Y, 아니오 : N, 미상 : U)*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(pageno), "UTF-8")); /*페이지 번호 (기본값 : 1)*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*페이지당 보여줄 개수 (1,000 이하), 기본값 : 10*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml(기본값) 또는 json*/


            XmlParser xmlParser = new XmlParser();

            abdmPublic = (AbdmPublic) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETABDMPUBLIC);
//
//            System.out.println(abdmPublic.getHeaderResult().getResultCode());
//            System.out.println(abdmPublic.getHeaderResult().getResultMsg());
//            System.out.println(abdmPublic.getHeaderResult().getReqNo());
//
//            for (int i = 0; i < abdmPublic.getItems().size(); i++) {
//                System.out.println(abdmPublic.getItems().get(i).getDesertionNo());
//                System.out.println(abdmPublic.getItems().get(i).getAge());
//                System.out.println(abdmPublic.getItems().get(i).getWeight());
//                System.out.println(abdmPublic.getItems().get(i).getNoticeNo());
//                System.out.println(abdmPublic.getItems().get(i).getNoticeSdt());
//                System.out.println(abdmPublic.getItems().get(i).getNoticeEdt());
//                System.out.println(abdmPublic.getItems().get(i).getSexCd());
//                System.out.println(abdmPublic.getItems().get(i).getCareNm());
//                System.out.println(abdmPublic.getItems().get(i).getFilename());
//                System.out.println(abdmPublic.getItems().get(i).getPopfile());
//                System.out.println("+++++++++++++++++++++");
//            }
//            System.out.println("nor : " + abdmPublic.getNumOfRows());
//            System.out.println("pageno : " + abdmPublic.getPageNo());
//            System.out.println("total : " + abdmPublic.getTotalCount());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return abdmPublic;
    }

    public static AbdmPublic abandonmentPublic(AnimalDto dto) {
        AbdmPublic abdmPublic = new AbdmPublic();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + API_KEY); /*Service Key*/
            if (dto.getMissingday() != null && !dto.getMissingday().isEmpty()) {
                String date ="";
                String charsToRemove = "-";
                for (char c : charsToRemove.toCharArray()) {
                    date = dto.getMissingday().replace(String.valueOf(c), "");
                }
                urlBuilder.append("&" + URLEncoder.encode("bgnde", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*유기날짜(검색 시작일) (YYYYMMDD)*/
            }
//            if (dto.getSearch_end_date() != null && !dto.getSearch_end_date().isEmpty()) {
//                String date ="";
//                String charsToRemove = "-";
//                for (char c : charsToRemove.toCharArray()) {
//                    date = dto.getSearch_str_date().replace(String.valueOf(c), "");
//                }
//                urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*유기날짜(검색 종료일) (YYYYMMDD)*/
//            }
            if (dto.getUpkind() != null && !dto.getUpkind().isEmpty()) {
                urlBuilder.append("&" + URLEncoder.encode("upkind", "UTF-8") + "=" + URLEncoder.encode(dto.getUpkind(), "UTF-8")); /*축종코드 (개 : 417000, 고양이 : 422400, 기타 : 429900)*/
            }
            if (dto.getUpr_cd() != null && !dto.getUpr_cd().isEmpty()) {
                urlBuilder.append("&" + URLEncoder.encode("kind", "UTF-8") + "=" + URLEncoder.encode(dto.getUpr_cd(), "UTF-8")); /*품종코드 (품종 조회 OPEN API 참조)*/
            }
            if (dto.getAddresscode1() != null && !dto.getAddresscode1().isEmpty()) {
                urlBuilder.append("&" + URLEncoder.encode("upr_cd", "UTF-8") + "=" + URLEncoder.encode(dto.getAddresscode1(), "UTF-8")); /*시도코드 (시도 조회 OPEN API 참조)*/
            }
            if (dto.getAddresscode2() != null && !dto.getAddresscode2().isEmpty()) {
                urlBuilder.append("&" + URLEncoder.encode("org_cd", "UTF-8") + "=" + URLEncoder.encode(dto.getAddresscode2(), "UTF-8")); /*시군구코드 (시군구 조회 OPEN API 참조)*/
            }
//            if (!dto.getShelterSelectBox().isEmpty()) {
//                urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" + URLEncoder.encode(dto.getShelterSelectBox(), "UTF-8")); /*보호소번호 (보호소 조회 OPEN API 참조)*/
//            }
//            urlBuilder.append("&" + URLEncoder.encode("state", "UTF-8") + "=" + URLEncoder.encode("protect", "UTF-8")); /*상태(전체 : null(빈값), 공고중 : notice, 보호중 : protect)*/
//            urlBuilder.append("&" + URLEncoder.encode("neuter_yn","UTF-8") + "=" + URLEncoder.encode("U", "UTF-8")); /*상태 (전체 : null(빈값), 예 : Y, 아니오 : N, 미상 : U)*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호 (기본값 : 1)*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*페이지당 보여줄 개수 (1,000 이하), 기본값 : 10*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml(기본값) 또는 json*/


            XmlParser xmlParser = new XmlParser();

            abdmPublic = (AbdmPublic) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETABDMPUBLIC);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return abdmPublic;
    }
    
    //스케줄러 때문에 오버라이딩 했습니다. - 04-20 마한슬
    public static AbdmPublic abandonmentPublic() {
        AbdmPublic abdmPublic = new AbdmPublic();
        String page = "2";
        String page_numOfRows = "1000";
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + API_KEY); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /*페이지 번호 (기본값 : 1)*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(page_numOfRows, "UTF-8")); /*페이지당 보여줄 개수 (1,000 이하), 기본값 : 10*/
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml(기본값) 또는 json*/

            XmlParser xmlParser = new XmlParser();

            abdmPublic = (AbdmPublic) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETABDMPUBLIC);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return abdmPublic;
    }
}

