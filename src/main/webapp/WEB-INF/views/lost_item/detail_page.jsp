<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Title</title>
<link rel="stylesheet" href="resources/css/ani_detail_page.css">
</head>
<body>
	<div class="main-body">
		<div class="main-selection">
			<div class="page-route">
				<span>분실물>상세검색>분실물 상세페이지</span>
			</div>
			<div class="selection-name">
				<span>분실물 상세페이지</span>
			</div>
			<div class="selection-explain">
				<span>소중한 물건이 분실되었습니다. 아래와 같은 물건을 발견하셨다면 기재된 연락처로 연락해주시기
					바랍니다.</span>
			</div>
			<div class="btn-top-container">
				<button class="btn-list" id="btn-top-rescue-list"
					onclick="history.back()"
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

		<div class="found-item-info">
			<div class="info-name-container">
				<img src="resources/img/clipboard.png" alt="" class="info-icon">
				<span class="info-name">물품정보</span>
				<button class="btn-map" onclick="location.href='lost_item_detail_map?address=${dto.address}';" style="cursor: pointer;">지도로 위치 찾기</button>
			</div>
			<table class="info-table">
				<tr>
					<th class="info-table-name">분실물명</th>
					<td class="info-table-value" colspan="3">
						<div class="table-value-container" id="ist_prdt_nm">
							${dto.item_name }</div>
					</td>
				</tr>
				<tr>
					<th class="info-table-name">분실일자</th>
					<td class="info-table-value" colspan="3">
						<div class="table-value-container" id="ist_hor">
							${dto.lostday }</div>
					</td>
				</tr>
				<tr>
					<th class="info-table-name">분실장소</th>
					<td class="info-table-value">
						<div class="table-value-container" id="ist_place">
							${dto.address }</div>
					</td>
					<th class="info-table-name">물품분류</th>
					<td class="info-table-value">
						<div class="table-value-container" id="prdt_cl_nm">${dto.upkind } > ${dto.upr_cd }</div>
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
				<tr>
					<th class="info-table-name" rowspan="3">특징</th>
					<td class="info-table-value" colspan="3" rowspan="3">
						<div class="table-value-container" id="ist_uniq">
							${dto.sepcialmark }</div>
					</td>
				</tr>
				<tr></tr>
				<tr></tr>
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
</body>
<script>
function deletes(total_id){
	if(window.confirm("게시물을 삭제하시겠습니까?")){
		location.href='lost_item_delete?total_id='+total_id;
	}
}
</script>
<script>
function modify(total_id) {
	if(window.confirm("게시물을 수정하시겠습니까?")){
		location.href='lost_item_modify_page?total_id='+total_id;
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