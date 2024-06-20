<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/css/ani_detail_page.css">
</head>
<div class="main-body">
    <div class="main-selection">
        <div class="page-route">
            <span>실종동물>상세검색>실종동물 상세페이지</span>
        </div>
        <div class="selection-name">
            <span>실종동물 상세페이지</span>
        </div>
        <div class="selection-explain">
            <span>소중한 반려동물이 실종되었습니다. 아래와 같은 동물을 발견하셨다면 관할기관에 맡겨주세요.</span>
        </div>
        <div class="btn-top-container">
				<button class="btn-list" id="btn-top-rescue-list" onclick="history.back()"
					style="cursor: pointer;">목록으로</button>
			</div>
    </div>

    <div class="image-selection">
        <div class="image-container">
           <c:forEach var="i" begin="0" end="${imgDtos.size()-1}">
					<div class="mySlides fade">
						<img src="resources/img/chevron-left.png" id="chevron-left" style="cursor: pointer;" onclick="plusSlides(-1)"> 
						<img src="${imgDtos.get(i).getFilename()}" id="ani-image"> 
						<img src="resources/img/chevron-right.png" id="chevron-right" style="cursor: pointer;" onclick="plusSlides(1)">
					</div>
				</c:forEach>
        </div>

    </div>

    <div class="ani-info">
        <div class="info-name-container">
            <img src="resources/img/clipboard.png" alt="" class="info-icon">
            <span class="info-name">동물정보</span>
            <button class="btn-map" onclick="location.href='lost_item_detail_map?address=${dto.address}';" style="cursor: pointer;">지도로 위치 찾기</button>
        </div>
        <table class="info-table">
            <tr>
                <th class="info-table-name">이름</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="ani-name">${dto.animal_name }</div>
                </td>
                <th class="info-table-name">동물종류</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="kind">${dto.upkind }</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">품종</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="kind_cd">${dto.upr_cd }</div>
                </td>
                <th class="info-table-name">성별</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="sexcd">${dto.sexcd }</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">체중</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="weight">${dto.weight } Kg</div>
                </td>
                <th class="info-table-name">나이</th>
                <td class="info-table-value">
                    <div class="table-value-container" id="age">${dto.age } 살</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">특징</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="special_mark">
                        ${dto.sepcialmark }
                    </div>
                </td>
            </tr>
        </table>

    </div>

    <div class="missing-info">
        <div class="info-name-container">
            <img src="resources/img/clipboard.png" alt="" class="info-icon">
            <span class="info-name">실정정보</span>
        </div>
        <table class="info-table">
            <tr>
                <th class="info-table-name">실종일</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="missing_dt">${dto.missingday }</div>
                </td>
            </tr>
            <tr>
                <th class="info-table-name">실종장소</th>
                <td class="info-table-value" colspan="3">
                    <div class="table-value-container" id="missing_place">${dto.address }</div>
                </td>
            </tr>
            <tr>
               <th class="info-table-name">연락처</th>
					<td class="info-table-value" colspan="3">
					<c:if test="${dto.openclose eq 'true'}">
						<div class="table-value-container" id="user_tel">${dto.user_tel}</div>
					</c:if>
					<c:if test="${dto.openclose eq 'false'}">
						<div class="table-value-container" id="user_tel">***-***-****</div>
					</c:if>
					</td>
            </tr>

        </table>
    </div>

    <div class="btn-bottom-container">
			<button class="btn-list" id="btn-bottom-list"
				onclick="history.back()"
				style="cursor: pointer;">목록으로</button>
		</div>
		<div>
			<c:if test="${userId eq dto.user_id and kind==null}">
				<button class="btn-list" id="btn-bottom-list" onclick="modify('${dto.total_id}')" style="cursor: pointer;"> 수정하기</button>
				<button class="btn-list" id="btn-bottom-list" onclick="deletes('${dto.total_id}')" style="cursor: pointer;">삭제하기</button>
				</c:if>
		</div>
</div>
</html>
<script>
function deletes(total_id){
	if(window.confirm("게시물을 삭제하시겠습니까?")){
		location.href='missing_ani_delete?total_id='+total_id;
	}
}
</script>
<script>
function modify(total_id) {
	if(window.confirm("게시물을 수정하시겠습니까?")){
		location.href='missing_ani_modify_page?total_id='+total_id;
	}
}
</script>
</html>
<script>
	var slideIndex = 1;
	showSlides(slideIndex);
	function plusSlides(n) {
		showSlides(slideIndex += n);
	}
	function currentSlide(n) {
		showSlides(slideIndex = n);
	}
	function showSlides(n) {
		var i;
		var slides = document.getElementsByClassName("mySlides");
		var dots = document.getElementsByClassName("dot");
		if (n > slides.length) {
			slideIndex = 1
		}
		if (n < 1) {
			slideIndex = slides.length
		}
		for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}
		for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" active", "");
		}
		slides[slideIndex - 1].style.display = "block";
		dots[slideIndex - 1].className += " active";
	}
</script>
