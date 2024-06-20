<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="resources/css/ani_detail_page.css">
</head>
<script>
    function submit_list_Form() {
        document.getElementById('list_form').submit();
    }
    function submit_list_Form2() {
        document.getElementById('list_form2').submit();
    }
    function openNewWindow(fdPlaceTelValue,fdPlaceValue) {
        // URL에 파라미터 추가
        var url = "/found_item_detail_map?fdPlaceTel=" + encodeURIComponent(fdPlaceTelValue)+"&fdPlace="
            + encodeURIComponent(fdPlaceValue);

        // 새 창 열기
        var newWindow = window.open(url, "_blank", "width=600,height=400");

        // 새 창에 포커스 주기
        newWindow.focus();
    }
</script>
<body>
<div class="main-body">
    <div class="main-selection">
        <div class="page-route">
            <span>습득물>상세검색>습득물 상세페이지</span>
        </div>
        <div class="selection-name">
            <span>습득물 상세페이지</span>
        </div>
        <div class="selection-explain">
            <span>분실하신 물건 여부를 확인하시고, 아래 기재된 보관장소연락처로 관리번호를 말씀해주시기 바랍니다.</span>
        </div>
        <div class="btn-top-container">
            <button class="btn-list" id="btn-top-rescue-list" onclick="submit_list_Form2()" style="cursor: pointer;">목록으로
                <form id="list_form2" action="found_item_view" method="post">
                    <input type="hidden" name="xml_code" value="${fn:escapeXml(xml_code)}"/>
                    <input type="hidden" name="page" value="${page}"/>
                    <input type="hidden" name="Dto_city" value="${Dto_city}"/>
                    <input type="hidden" name="Dto_startYmd" value="${Dto_startYmd}"/>
                    <input type="hidden" name="Dto_endYmd" value="${Dto_endYmd}"/>
                    <input type="hidden" name="Dto_mainCategory" value="${Dto_mainCategory}"/>
                    <input type="hidden" name="Dto_subCategory" value="${Dto_subCategory}"/>
                    <input type="hidden" name="Dto_color" value="${Dto_color}"/>
                </form>
            </button>


        </div>
    </div>

    <div class="image-selection">
        <div class="image-container">
            <img src="resources/img/chevron-left.png" alt="" id="chevron-left">
            <img src="${dto.fdFilePathImg}" alt="" id="ani-image">
            <img src="resources/img/chevron-right.png" alt="" id="chevron-right">
        </div>

    </div>

    <div class="found-item-info">
        <div class="info-name-container">
            <img src="resources/img/clipboard.png" alt="" class="info-icon">
            <span class="info-name">물품정보</span>
        </div>
        <table class="info-table">
            <tr>
                <th class="info-table-name">습득물명</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="fd_prdt_nm">
                        ${dto.fdPrdtNm}
                    </div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">습득일자</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="fd_ymd">
                        ${dto.fdYmd}
                    </div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">습득장소</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="fd_place">
                        ${dto.fdPlace}
                    </div>
                </td>
                <th class="info-table-name">물품분류</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="prdt_cl_nm">${dto.prdtClNm}</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">관리번호</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="atc_ic">
                        ${dto.atcId}
                    </div>
                </td>
                <th class="info-table-name">보관상태</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="cste_ste_nm">${dto.csteSteNm}</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name" rowspan="3">특징</th>
                <td class="info-table-value" colspan="3" rowspan="3">
                    <div class="table-value-container" id="uniq">
                        ${dto.uniq}
                    </div>
                </td>
            </tr>
            <tr></tr>
            <tr></tr>
        </table>

    </div>

    <div class="rescue-info">
        <div class="info-name-container">
            <img src="resources/img/clipboard.png" alt="" class="info-icon">
            <span class="info-name">보관장소</span>
            <button class="btn-map" onclick="openNewWindow('${dto.tel}','${dto.depPlace}')" style="cursor: pointer;" >지도로 위치 찾기</button>
        </div>
        <table class="info-table">
            <tr>
                <th class="info-table-name">보관장소</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="dep_place">
                        ${dto.depPlace}
                    </div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">전화번호</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="tel">
                        ${dto.tel}
                    </div>
                </td>
            </tr>

        </table>
    </div>

    <div class="btn-bottom-container">
        <div class="btn-bottom-container">
            <button class="btn-list" id="btn-bottom-list" onclick="submit_list_Form()" style="cursor: pointer;">목록으로
                <form id="list_form" action="found_item_view" method="post">
                    <input type="hidden" name="xml_code" value="${fn:escapeXml(xml_code)}"/>
                    <input type="hidden" name="page" value="${page}"/>
                    <input type="hidden" name="Dto_city" value="${Dto_city}"/>
                    <input type="hidden" name="Dto_startYmd" value="${Dto_startYmd}"/>
                    <input type="hidden" name="Dto_endYmd" value="${Dto_endYmd}"/>
                    <input type="hidden" name="Dto_mainCategory" value="${Dto_mainCategory}"/>
                    <input type="hidden" name="Dto_subCategory" value="${Dto_subCategory}"/>
                    <input type="hidden" name="Dto_color" value="${Dto_color}"/>
                </form>
            </button>
        </div>
    </div>
</div>
</body>
</html>
