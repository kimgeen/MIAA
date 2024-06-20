<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/css/ani_detail_page.css">
    <script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
</head>
<script>
function goBack() {
	window.history.back();
}
</script>
<body>
<div class="main-body">
    <div class="main-selection">
        <div class="page-route">
            <span>보호동물>상세검색>보호동물 상세페이지</span>
        </div>
        <div class="selection-name">
            <span>보호동물 상세페이지</span>
        </div>
        <div class="selection-explain">
            <span> 찾으시는 동물을 확인하시고, 아래 기재된 보호장소연락처로 공고번호를 말씀해주시기 바랍니다.</span>
        </div>
        <div class="btn-top-container">
            <button class="btn-list" id="btn-top-rescue-list" onclick="goBack() style="cursor: pointer">목록으로</button>
        </div>
    </div>

    <div class="image-selection">
        <div class="image-container">
            <img src="resources/img/chevron-left.png" alt="" id="chevron-left">
            <img src="${dto.item.getPopfile()}" alt="" id="ani-image">
            <img src="resources/img/chevron-right.png" alt="" id="chevron-right">
        </div>

    </div>

    <div class="ani-info">
        <div class="info-name-container">
            <img src="resources/img/clipboard.png" alt="" class="info-icon">
            <span class="info-name">동물정보</span>
        </div>
        <table class="info-table">
            <tr>
                <th class="info-table-name">공고번호</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="notice_no">
                        ${dto.item.getNoticeNo()}
                    </div>
                </td>
                <th class="info-table-name">동물종류</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="kind">
                        ${dto.upKind }
                    </div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">품종</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="kind_cd">
                        ${dto.kind }
                    </div>
                </td>
                <th class="info-table-name">색상</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="color_cd">
                        ${dto.item.getColorCd()}
                    </div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">성별</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="sex_cd">
                        ${dto.item.getSexCd()}
                    </div>
                </td>
                <th class="info-table-name">중성화 여부</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="neuter_yn">
                        ${dto.item.getNeuterYn()}
                    </div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">체중</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="weight">
                        ${dto.item.getWeight()}
                    </div>
                </td>
                <th class="info-table-name">나이</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="age">${dto.item.getAge()}</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">특징</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="special_mark">
                        ${dto.item.getSpecialMark()}
                    </div>
            </tr>
        </table>

    </div>

    <div class="rescue-info">
        <div class="info-name-container">
            <img src="resources/img/clipboard.png" alt="" class="info-icon">
            <span class="info-name">구조정보</span>
        </div>
        <table class="info-table">
            <tr>
                <th class="info-table-name">구조일</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="happen_dt">${dto.item.getHappenDt()}</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">구조장소</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="happen_place">${dto.item.getHappenPlace()}</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">공고기간</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="notice">${dto.item.getNoticeSdt()} ~ ${dto.item.getNoticeEdt()}</div>
                </td>
            </tr>

        </table>
    </div>

    <div class="shelter-info">
        <div class="info-name-container">
            <img src="resources/img/clipboard.png" alt="" class="info-icon">
            <span class="info-name">동물보호센터</span>
            <button class="btn-map" onclick="location.href='rescue_ani_detail_map?address=${dto.item.getCareAddr()}'">지도로 위치 찾기</button>
        </div>
        <table class="info-table">
            <tr>
                <th class="info-table-name">보호센터명</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="care_nm">${dto.item.getCareNm()}</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">주소</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="care_addr">${dto.item.getCareAddr()}</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">전화번호</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="care_tel">${dto.item.getCareTel()}</div>
                </td>
            </tr>

        </table>
    </div>

    <div class="btn-bottom-container">
        <button class="btn-list" id="btn-bottom-list" onclick="goBack()" style="cursor: pointer">목록으로</button>
    </div>
</div>
</body>
</html>
