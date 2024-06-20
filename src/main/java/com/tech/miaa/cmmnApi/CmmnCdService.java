package com.tech.miaa.cmmnApi;

import com.tech.miaa.abdmApi.XmlParser;
import java.net.URLEncoder;
import java.util.HashMap;

public class CmmnCdService {
    //상위물품코드맵

    /* 물품분류코드조회
     * 상위물품코드를 기준으로 물품분류코드 정보를 조회하는 물품분류 코드조회 기능 제공
     * call back url:http://apis.data.go.kr/1320000/CmmnCdService/getCmmnCd
     * 최대사이즈 : [4000] byte
     * 평균응답시간 :  [500] ms
     * 초당 최대 트랙잭션 : [30] tps */

    //상위물품코드 전부 가지고오는 method
    public static HashMap<String,String> gethiPrdCdAll(){
        HashMap<String,String> hiPrdtCd_map = new HashMap<>();
        try {
            //대분류
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1320000/CmmnCdService/getThngClCd"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + API_KEY); /*Service Key*/

            XmlParser xmlParser = new XmlParser();

            ThngClCd a = (ThngClCd) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETTHNGCLCD);
            System.out.println(a.getHeaderResult().getResultCode());
            System.out.println(a.getHeaderResult().getResultMsg());

            for (int i =0; i<a.getItems().size(); i++){
                System.out.println(a.getItems().get(i).getPrdtNm());
                System.out.println(a.getItems().get(i).getPrdtCd());
                System.out.println(a.getItems().get(i).getHiPrdtCd());
                System.out.println("+++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return hiPrdtCd_map;
    }


    public static void getThngClCd(String hiPrdCd){
        try {
            //대분류
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1320000/CmmnCdService/getThngClCd"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + API_KEY); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("PRDT_CL_CD_01","UTF-8") + "=" + URLEncoder.encode(hiPrdCd, "UTF-8")); /*상위물품코드명*/

            XmlParser xmlParser = new XmlParser();

            ThngClCd a = (ThngClCd) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETTHNGCLCD);
            System.out.println(a.getHeaderResult().getResultCode());
            System.out.println(a.getHeaderResult().getResultMsg());

            for (int i =0; i<a.getItems().size(); i++){
                System.out.println(a.getItems().get(i).getPrdtNm());
                System.out.println(a.getItems().get(i).getPrdtCd());
                System.out.println(a.getItems().get(i).getHiPrdtCd());
                System.out.println("+++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /* 공통코드조회
     * 코드명을 기준으로 코드정보를 조회하는 공통코드 조회 기능 제공
     * call back url:http://apis.data.go.kr/1320000/CmmnCdService/getCmmnCd
     * 최대사이즈 : [4000] byte
     * 평균응답시간 :  [500] ms
     * 초당 최대 트랙잭션 : [30] tps */

    private final static String API_KEY = "hm0qJL%2FrZFagiGGwrhjAQ6KMXI2DOUcHs5uVRpIGSk0k1yvSZiQDcIr%2BzGHVVbw1Cs0n2wAIZNlzXcaeJbukmQ%3D%3D";
    public static void getCmmnCd(String comm){
        try {
            //색상코드. 지역구분
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1320000/CmmnCdService/getCmmnCd"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" +API_KEY); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("GRP_NM","UTF-8") + "=" + URLEncoder.encode(comm, "UTF-8")); /*코드그룹명,지역구분,*/
//            urlBuilder.append("&" + URLEncoder.encode("CD_NM","UTF-8") + "=" + URLEncoder.encode("서울특별시", "UTF-8")); /*코드명*/

            XmlParser xmlParser = new XmlParser();
            CmmnCd a = (CmmnCd) xmlParser.parsing(urlBuilder.toString(), XmlParser.GETCMMNCD);
            System.out.println(a.getHeaderResult().getResultCode());
            System.out.println(a.getHeaderResult().getResultMsg());

            for (int i =0; i<a.getItems().size(); i++){
                System.out.println(a.getItems().get(i).getCdNm());
                System.out.println(a.getItems().get(i).getCommCd());
                System.out.println(a.getItems().get(i).getCommGrpCd());
                System.out.println(a.getItems().get(i).getGrpNm());

            }

//            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
//            Document doc = dBuilder.parse(urlBuilder.toString());
//            // 제일 첫번째 태그
//            doc.getDocumentElement().normalize();
//
//            // 파싱할 tag
//            NodeList nList = doc.getElementsByTagName("item");
//
//            for (int i = 0; i<nList.getLength(); i++){
//                Node node = nList.item(i);
//                Element element = (Element) node;
//                System.out.println("======================================");
//                System.out.println("commCd : "+getTagValue("commCd",element));
//                System.out.println("cdNm : "+getTagValue("cdNm",element));
//                System.out.println("commGrpCd : "+getTagValue("commGrpCd",element));
//                System.out.println("grpNm : "+getTagValue("grpNm",element));
//                System.out.println("======================================");
//            }
//            System.out.println(nList.getLength());
//
//            NodeList re = doc.getElementsByTagName("header");
//            for (int j = 0; j<re.getLength(); j++){
//                Node node2 = re.item(j);
//                Element element2 = (Element) node2;
//                System.out.println("======================================");
//                System.out.println("commCd : "+getTagValue("resultCode",element2));
//                System.out.println("cdNm : "+getTagValue("resultMsg",element2));
//                System.out.println("======================================");
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
