package com.tech.miaa.abdmApi;

import com.tech.miaa.cmmnApi.CmmnCd;
import com.tech.miaa.cmmnApi.CmmnCdItem;
import com.tech.miaa.cmmnApi.ThngClCd;
import com.tech.miaa.cmmnApi.ThngClCdItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XmlParser {
    public final static int GETCMMNCD = 0;
    public final static int GETTHNGCLCD = 1;
    public final static int GETABDMSIDO = 2;
    public final static int GETABDMSIGUNGU = 3;
    public final static int GETABDMSHELTER = 4;
    public final static int GETABDMKIND = 5;
    public final static int GETABDMPUBLIC = 6;

    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document doc;

    public Object parsing(String url, int type) throws ParserConfigurationException, IOException, SAXException {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        doc = documentBuilder.parse(url);
        //root tag
        doc.getDocumentElement().normalize();
        Object object = new Object();
        HeaderResult headerResult = getHeaderResult(doc);
        switch (type) {
            case GETCMMNCD : {
                object = cmmnCdParsing(headerResult);
                break;
            }
            case GETTHNGCLCD : {
                object = thngClCdParsing(headerResult);
                break;
            }
            case GETABDMSIDO : {
                object = abdmSidoParsing(headerResult);
                break;
            }
            case GETABDMSIGUNGU : {
                object = abdmSigunguParsing(headerResult);
                break;
            }
            case GETABDMSHELTER : {
                object = abdmShelterParsing(headerResult);
                break;
            }
            case GETABDMKIND :{
                object = abdmKindParsing(headerResult);
                break;
            }
            case GETABDMPUBLIC :{
                object = abdmPublicParsing(headerResult);
                break;
            }
        }
        return object;
    }

    public CmmnCd cmmnCdParsing(HeaderResult headerResult) {
        CmmnCd cmmnCd = new CmmnCd();
        cmmnCd.setHeaderResult(headerResult);

        ArrayList<CmmnCdItem> cmmnCdItems = new ArrayList<CmmnCdItem>();
        NodeList itemsList = doc.getElementsByTagName("item");
        for (int i = 0; i < itemsList.getLength(); i++) {
            Node itmeNode = itemsList.item(i);
            Element element = (Element) itmeNode;
            CmmnCdItem cmmnCdItem = new CmmnCdItem();
            cmmnCdItem.setCommCd(getTagValue(CmmnCdItem.COMMCD, element));
            cmmnCdItem.setCdNm(getTagValue(CmmnCdItem.CDNM, element));
            cmmnCdItem.setCommGrpCd(getTagValue(CmmnCdItem.COMMGRPCD, element));
            cmmnCdItem.setGrpNm(getTagValue(CmmnCdItem.GRPNM, element));
            cmmnCdItems.add(cmmnCdItem);
        }
        cmmnCd.setItems(cmmnCdItems);

        return cmmnCd;
    }

    public ThngClCd thngClCdParsing(HeaderResult headerResult) {
        ThngClCd thngClCd = new ThngClCd();
        thngClCd.setHeaderResult(headerResult);

        ArrayList<ThngClCdItem> thngClCdItems = new ArrayList<ThngClCdItem>();
        NodeList itemsList = doc.getElementsByTagName("item");
        for (int i = 0; i < itemsList.getLength(); i++) {
            Node itmeNode = itemsList.item(i);
            Element element = (Element) itmeNode;
            ThngClCdItem thngClCdItem = new ThngClCdItem();
            thngClCdItem.setPrdtCd(getTagValue(ThngClCdItem.PRDTCD, element));
            thngClCdItem.setPrdtNm(getTagValue(ThngClCdItem.PRDTNM, element));
            thngClCdItem.setHiPrdtCd(getTagValue(ThngClCdItem.HIPRDTCD, element));
            thngClCdItems.add(thngClCdItem);
        }
        thngClCd.setItems(thngClCdItems);

        return thngClCd;
    }

    public AbdmSido abdmSidoParsing(HeaderResult headerResult) {
        AbdmSido abdmSido = new AbdmSido();
        abdmSido.setHeaderResult(headerResult);

        ArrayList<AbdmSidoItem> abdmSidoItems = new ArrayList<AbdmSidoItem>();
        NodeList itemsList = doc.getElementsByTagName("item");
        for (int i = 0; i < itemsList.getLength(); i++) {
            Node itmeNode = itemsList.item(i);
            Element element = (Element) itmeNode;
            AbdmSidoItem abdmSidoItem = new AbdmSidoItem();
            abdmSidoItem.setOrgCd(getTagValue(AbdmSidoItem.ORGCD, element));
            abdmSidoItem.setOrgdownNm(getTagValue(AbdmSidoItem.ORGDOWNNM, element));
            abdmSidoItems.add(abdmSidoItem);
        }
        NodeList itemsList2 = doc.getElementsByTagName("body");

        for (int i = 0; i < itemsList2.getLength(); i++) {
            Node itmeNode = itemsList2.item(i);
            Element element = (Element) itmeNode;
            abdmSido.setNumOfRows(getTagValue(AbdmSido.NUMOFROWS, element));
            abdmSido.setPageNo(getTagValue(AbdmSido.PAGENO, element));
            abdmSido.setTotalCount(getTagValue(AbdmSido.TOTALCOUNT, element));
        }

        abdmSido.setItems(abdmSidoItems);

        return abdmSido;
    }

    public AbdmSigungu abdmSigunguParsing(HeaderResult headerResult) {
        AbdmSigungu abdmSigungu = new AbdmSigungu();
        abdmSigungu.setHeaderResult(headerResult);

        ArrayList<AbdmSigunguItem> abdmSigunguItems = new ArrayList<AbdmSigunguItem>();
        NodeList itemsList = doc.getElementsByTagName("item");
        for (int i = 0; i < itemsList.getLength(); i++) {
            Node itmeNode = itemsList.item(i);
            Element element = (Element) itmeNode;
            AbdmSigunguItem abdmSigunguItem = new AbdmSigunguItem();
            abdmSigunguItem.setUprCd(getTagValue(AbdmSigunguItem.UPRCD,element));
            abdmSigunguItem.setOrgCd(getTagValue(AbdmSigunguItem.ORGCD, element));
            abdmSigunguItem.setOrgdownNm(getTagValue(AbdmSigunguItem.ORGDOWNNM, element));
            abdmSigunguItems.add(abdmSigunguItem);
        }
        abdmSigungu.setItems(abdmSigunguItems);

        return abdmSigungu;
    }

    public AbdmShelter abdmShelterParsing(HeaderResult headerResult) {
        AbdmShelter abdmShelter = new AbdmShelter();
        abdmShelter.setHeaderResult(headerResult);

        ArrayList<AbdmShelterItem> abdmShelterItems = new ArrayList<AbdmShelterItem>();
        NodeList itemsList = doc.getElementsByTagName("item");
        for (int i = 0; i < itemsList.getLength(); i++) {
            Node itmeNode = itemsList.item(i);
            Element element = (Element) itmeNode;
            AbdmShelterItem abdmShelterItem = new AbdmShelterItem();
            abdmShelterItem.setCareRegNo(getTagValue(AbdmShelterItem.CAREREGNO,element));
            abdmShelterItem.setCareNm(getTagValue(AbdmShelterItem.CARENM, element));
            abdmShelterItems.add(abdmShelterItem);
        }
        abdmShelter.setItems(abdmShelterItems);

        return abdmShelter;
    }

    public AbdmKind abdmKindParsing(HeaderResult headerResult) {
        AbdmKind abdmKind = new AbdmKind();
        abdmKind.setHeaderResult(headerResult);

        ArrayList<AbdmKindItem> abdmKindItems = new ArrayList<AbdmKindItem>();
        NodeList itemsList = doc.getElementsByTagName("item");
        for (int i = 0; i < itemsList.getLength(); i++) {
            Node itmeNode = itemsList.item(i);
            Element element = (Element) itmeNode;
            AbdmKindItem abdmKindItem = new AbdmKindItem();
            abdmKindItem.setKindCd(getTagValue(AbdmKindItem.KINDCD,element));
            abdmKindItem.setKNm(getTagValue(AbdmKindItem.KNM, element));
            abdmKindItems.add(abdmKindItem);
        }
        abdmKind.setItems(abdmKindItems);

        return abdmKind;
    }

    public AbdmPublic abdmPublicParsing(HeaderResult headerResult) {
        AbdmPublic abdmPublic = new AbdmPublic();
        abdmPublic.setHeaderResult(headerResult);
        NodeList bodyList = doc.getElementsByTagName("body");
        for (int i = 0; i < bodyList.getLength(); i++) {
            Node bodyNode = bodyList.item(i);
            Element element = (Element) bodyNode;
            abdmPublic.setNumOfRows(getTagValue(AbdmPublic.NUMOFROWS, element));
            abdmPublic.setPageNo(getTagValue(AbdmPublic.PAGENO, element));
            abdmPublic.setTotalCount(getTagValue(AbdmPublic.TOTALCOUNT, element));
        }

        ArrayList<AbdmPublicItem> abdmPublicItems = new ArrayList<AbdmPublicItem>();
        NodeList itemsList = doc.getElementsByTagName("item");
        for (int i = 0; i < itemsList.getLength(); i++) {
            Node itmeNode = itemsList.item(i);
            Element element = (Element) itmeNode;
            AbdmPublicItem abdmPublicItem = new AbdmPublicItem();
            abdmPublicItem.setDesertionNo(getTagValue(AbdmPublicItem.DESERTIONNO,element));
            abdmPublicItem.setFilename(getTagValue(AbdmPublicItem.FILENAME,element));
            abdmPublicItem.setHappenDt(getTagValue(AbdmPublicItem.HAPPENDT,element));
            abdmPublicItem.setHappenPlace(getTagValue(AbdmPublicItem.HAPPENPLACE,element));
            abdmPublicItem.setKindCd(getTagValue(AbdmPublicItem.KINDCD,element));
            abdmPublicItem.setColorCd(getTagValue(AbdmPublicItem.COLORCD,element));
            abdmPublicItem.setAge(getTagValue(AbdmPublicItem.AGE,element));
            abdmPublicItem.setWeight(getTagValue(AbdmPublicItem.WEIGHT,element));
            abdmPublicItem.setNoticeNo(getTagValue(AbdmPublicItem.NOTICENO,element));
            abdmPublicItem.setNoticeSdt(getTagValue(AbdmPublicItem.NOTICESDT,element));
            abdmPublicItem.setNoticeEdt(getTagValue(AbdmPublicItem.NOTICEEDT,element));
            abdmPublicItem.setPopfile(getTagValue(AbdmPublicItem.POPFILE,element));
            abdmPublicItem.setProcessState(getTagValue(AbdmPublicItem.PROCESSSTATE,element));
            abdmPublicItem.setSexCd(getTagValue(AbdmPublicItem.SEXCD,element));
            abdmPublicItem.setNeuterYn(getTagValue(AbdmPublicItem.NEUTERYN,element));
            abdmPublicItem.setSpecialMark(getTagValue(AbdmPublicItem.SPECIALMARK,element));
            abdmPublicItem.setCareNm(getTagValue(AbdmPublicItem.CARENM,element));
            abdmPublicItem.setCareTel(getTagValue(AbdmPublicItem.CARETEL,element));
            abdmPublicItem.setCareAddr(getTagValue(AbdmPublicItem.CAREADDR,element));
            abdmPublicItem.setOrgNm(getTagValue(AbdmPublicItem.ORGNM,element));
            abdmPublicItem.setChargeNm(getTagValue(AbdmPublicItem.CHARGENM,element));
            abdmPublicItem.setOfficetel(getTagValue(AbdmPublicItem.OFFICETEL,element));
            abdmPublicItem.setNoticeComment(getTagValue(AbdmPublicItem.NOTICECOMMENT,element));

            abdmPublicItems.add(abdmPublicItem);
        }
        abdmPublic.setItems(abdmPublicItems);

        return abdmPublic;
    }

    public static HeaderResult getHeaderResult(Document doc) {
        NodeList headerList = doc.getElementsByTagName("header");
        HeaderResult headerResult = new HeaderResult();

        for (int i = 0; i < headerList.getLength(); i++) {
            Node headerNode = headerList.item(i);
            Element element = (Element) headerNode;
            headerResult.setResultCode(getTagValue(HeaderResult.RESULTCODE, element));
            headerResult.setResultMsg(getTagValue(HeaderResult.RESULTMAG, element));
            //abandonment에만 존재
            headerResult.setReqNo(getTagValue(HeaderResult.REQNO, element));
        }
        return headerResult;
    }

    public static String getTagValue(String tag, Element eElement) {
        //결과를 저장할 result 변수 선언
        String result = "";
        NodeList nlList;
        if (eElement.getElementsByTagName(tag).item(0) != null) {
            nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
            result = nlList.item(0).getTextContent();
        }
        return result;
    }

    public static String getTagValue(String tag, String childTag, Element eElement) {

        //결과를 저장할 result 변수 선언
        String result = "";

        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

        for (int i = 0; i < eElement.getElementsByTagName(childTag).getLength(); i++) {

            //result += nlList.item(i).getFirstChild().getTextContent() + " ";
            result += nlList.item(i).getChildNodes().item(0).getTextContent() + " ";
        }

        return result;
    }
}
