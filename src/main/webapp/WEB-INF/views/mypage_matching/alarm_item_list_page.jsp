<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Title</title>
<link rel="stylesheet"
	href="resources/css/mypage_matching_alarm_item_list_page.css">
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
</head>
<script>
function goToPage(page) {
	let currentPage = ${pagevo.page};
	let totalPage = ${pagevo.totPage};
	if(page<1){
		page=1;
	}else if(page>totalPage){
		page=totalPage;
	}
	let url = "mypage_matching_alarm_item_list_page?page=" + page;
    window.location.href = url;
}
function goToDetailPage(atcid,fdSn) {
	let url = "mypage_matching_item_detail?atcid="+atcid+"&fdSn="+fdSn;
    window.location.href = url;
}
function goToDetailListPage(total_id) {
    let url = "mypage_matching_alarm_detail_list_page?total_id=" + total_id+"&page=1";
    window.location.href = url;
}
</script>
<body>
	<div class="main-body">
		<div class="main-contents">

			<!-- main -->

			<!-- 검색창과 검색결과 -->

			<div class="searchbar-container">
				<!-- <form action=""> -->
				<div class="searchbar-select-group">
					<div style="display: flex;">
						<button class="btn-list" id="btn-search-all"
							onclick="location.href='mypage_matching_alarm_list_page?page=1'"
							style="cursor: pointer;">전체보기</button>
						<button class="btn-list" id="btn-search-item"
							onclick="location.href='mypage_matching_alarm_item_list_page?page=1'"
							style="cursor: pointer;">물건</button>
						<button class="btn-list" id="btn-search-ani"
							onclick="location.href='mypage_matching_alarm_ani_list_page?page=1'"
							style="cursor: pointer;">동물</button>
						<button class="btn-list" id="btn-search-key"
							onclick="location.href='mypage_matching_alarm_keyword_list_page?page=1'"
							style="cursor: pointer;">키워드목록</button>
					</div>
					<!-- <div style="display: flex;">
						<div class="searchbar-content">
							<select id="reply_status" style="border: 1px solid #D8D8D8;">
								<option>제목+내용</option>
								<option>제목</option>
								<option>내용</option>
							</select>
						</div>
						<div class="searchbar-content">
							<input type="text"
								style="border: 1px solid #D8D8D8; width: 334px;"
								placeholder="Search">
						</div>
						<button class="btn-list" id="btn-search-alarm" onclick="#"
							style="cursor: pointer;">
							<img src="resources/img/bell-off.png" alt="">알림제거
						</button>
						<button class="btn-list" id="btn-search" onclick="#"
							style="cursor: pointer;">
							조회<img src="resources/img/search.png" alt="">
						</button>
					</div> -->

				</div>
				<!-- </form> -->



			</div>

			<div class="result-totnum-container">
				<span>등록된 알림 키워드(${list.size() }개)</span>
			</div>
			<!--           </div> -->
			<!-- 검색결과 리스트 프레임 끝 -->
			<!--등록게시물 키워드 시작 1  -->

			<c:forEach items="${list }" var="dto" begin="${pagevo.rowStart-1}"
				end="${pagevo.rowEnd-1}">

				<!-- 아이템시작 -->
				<c:if test="${not empty dto.item_dto}">
					<div class="content-wrapper">
						<div class="talbe-caption-container">
							<div class="table-caption-item">
								<div style="display: flex;">
									<!-- <input type="checkbox" class="table-check-box" /> -->
									&nbsp; <span id="item-name-text">분실물명 :</span> <span
										id="item-name-value"><strong>&nbsp;${dto.item_dto.item_name }</strong></span>
								</div>

							</div>
							<div class="table-caption">
								<div class="registrationed_alarm_keywords_list">
									<span class="item_tag_01"> 물건</span> <span class="item_tag_02">${dto.item_dto.item_name}</span>
									<span class="item_tag_03">${dto.item_dto.lostday}</span> <span
										class="item_tag_04">${dto.item_dto.upr_cd}</span> <span
										class="item_tag_05">${dto.item_dto.address}</span>
								</div>
							</div>
						</div>
						<div class="list-control-container">
							<a href="#" onclick="goToDetailListPage(${dto.total_id})">모두
								보기(${dto.matching_item_dto.size()}개)</a>
						</div>
					</div>

					<!-- 검색 결과 리스트프레임 -->
					<div class="result-list">
						<c:forEach items="${dto.matching_item_dto}" var="dto2" begin="0"
							end="4">
							<!-- 목록1개가 list-card -->
							<div class="list-card" style="cursor: pointer"
								onclick="goToDetailPage('${dto2.atcid}','${dto2.fdSn}')">
								<div class="card-photo">
									<img src="${dto2.fdFilePathImg}" alt="">
								</div>
								<div class="content-items">
									<div class="item-title">
										<span>${dto2.fdPrdtNm}</span>
									</div>
									<ul class="item-details">
										<li><span class="detail-title"></span><span>${dto2.atcid}</span></li>
										<li><span class="detail-title">물품분류:</span><span>${dto2.prdtClNm}</span></li>
										<li><span class="detail-title">보관장소:</span><span>${dto2.depPlace}</span></li>
										<li><span class="detail-title">습득일자:</span><span>${dto2.fdYmd}</span></li>
									</ul>
								</div>
							</div>
							<!-- list-card 1개 끝 -->
						</c:forEach>
					</div>
				</c:if>


				<!-- 동물 시작 -->
				<c:if test="${not empty dto.animal_dto}">
					<div class="content-wrapper">
						<div class="talbe-caption-container">
							<div class="table-caption-item">
								<div style="display: flex;">
									<!-- <input type="checkbox" class="table-check-box" /> -->
									&nbsp; <span id="item-name-text">분실동물명 :</span> <span
										id="item-name-value"><strong>&nbsp;${dto.animal_dto.animal_name }</strong></span>
								</div>

							</div>
							<div class="table-caption">
								<div class="registrationed_alarm_keywords_list">
									<span class="item_tag_01"> 동물</span> <span class="item_tag_02">${dto.animal_dto.animal_name}</span>
									<span class="item_tag_03">${dto.animal_dto.missingday}</span> <span
										class="item_tag_04">${dto.animal_dto.upr_cd}</span> <span
										class="item_tag_05">${dto.animal_dto.address}</span>
								</div>
							</div>
						</div>
						<div class="list-control-container">
							<a href="#" onclick="goToDetailListPage(${dto.total_id})">모두
								보기(${dto.matching_animal_dto.size()}개)</a>
						</div>
					</div>
					<!-- 검색 결과 리스트프레임 -->
					<div class="result-list">
						<c:forEach items="${dto.matching_animal_dto}" var="dto2" begin="0"
							end="4">
							<!-- 목록1개가 list-card -->
							<div class="list-card" style="cursor: pointer"
								onclick="goToDetailPage_ani('${dto2.noticeNo}')">
								<div class="card-photo">
									<img src="${dto2.filename}" alt="">
								</div>
								<div class="content-items">
									<div class="item-title">
										<span>${dto2.kindCd}</span>
									</div>
									<ul class="item-details">
										<li><span class="detail-title">구조날짜:</span><span>${dto2.happenDt}</span></li>
										<li><span class="detail-title">공고번호:</span><span>${dto2.desertionNo}</span></li>
										<li><span class="detail-title">성별:</span><span>${dto2.sexCd}</span></li>
										<li><span class="detail-title">발견장소:</span><span>${dto2.happenPlace}</span></li>
									</ul>
								</div>
							</div>
							<!-- list-card 1개 끝 -->
						</c:forEach>
					</div>
				</c:if>
			</c:forEach>

			<!-- 검색 결과 리스트프레임 끝-->

			<!-- page -->

			<div class="result-container">
				<div class="page-container">
					<div class="currentOftotal">
						<span>Page</span><span class="current-page">${pagevo.page}</span><span>of</span><span
							class="total-page">${pagevo.pageEnd}</span>
					</div>
					<ul class="pagelist-container">
						<li class="btn-prev"><a href="javascript:void(0);"
							onclick="goToPage(${pagevo.page}-1)"><img
								src="resources/img/chevron-left.png" alt=""></a></li>
						<c:forEach begin="${pagevo.pageStart}" end="${pagevo.pageEnd}"
							var="i">
							<c:choose>
								<c:when test="${i eq pagevo.page}">
									<li><span class="currpage">${i}</span></li>
								</c:when>
								<c:otherwise>
									<li><a href="javascript:void(0);" onclick="goToPage(${i})">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<li class="btn-next"><a href="javascript:void(0);"
							onclick="goToPage(${pagevo.page}+1)"><img
								src="resources/img/chevron-left.png" alt=""></a></li>
					</ul>

					<ul class="switchBtn-container">
						<li class="btn-prev-group"><a href="javascript:void(0);"
							onclick="goToPage(${pagevo.page}-10)">Previous</a></li>
						<li class="btn-next-group"><a href="javascript:void(0);"
							onclick="goToPage(${pagevo.page}+10)">Next</a></li>
					</ul>
				</div>
			</div>


		</div>
	</div>
</body>


</html>
