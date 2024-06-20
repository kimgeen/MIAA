<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Title</title>
<link rel="stylesheet"
	href="resources/css/mypage_matching_alarm_keyword_list_page.css">
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
	let url = "mypage_matching_alarm_keyword_list_page?page=" + page;
    window.location.href = url;
}
function goToDetailListPage(total_id) {
    let url = "mypage_matching_alarm_detail_list_page?total_id=" + total_id+"&page=1";
    window.location.href = url;
}


</script>
<body>
	<div class="main-body">

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
							<input type="text" style="border: 1px solid #D8D8D8; width: 334px;" placeholder="Search">
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

		<!-- 검색창과 검색결과 끝 -->

		<div class="content-wrapper">
			<div class="content-container">

				<!-- <div class="table-caption-wrapper">
				<div class="talbe-caption-container">
					
					<div class="table-caption">
						<div>
							<div class="searchbar-content">
							<select name="reply_status" id="reply_status" style="font-family: inherit; border: 1px solid #D8D8D8;">
								<option value="all" >전체</option>
								<option value="item" >물건</option>
								<option value="animal" >동물</option>														
							</select>
						</div>
						</div>
					</div>

				</div>
				<div class="list-control-container">
					<button class="btn-list" id="btn-write" onclick="#"
						style="cursor: pointer; font-family: inherit;">해당 알림제거
					</button>
					<button class="btn-list" id="btn-delete" onclick="#"
						style="cursor: pointer; font-family: inherit;">원글삭제
					</button>
				</div>
				

			</div> -->


				<table class="info-table">
					<tr>
						<th><input type="checkbox" name="allCheck" id="allCheck"
							class="table-check-box"></th>

						<th class="table-title"><div style="margin-left: 5px;">게시
								제목</div></th>


						<th></th>
					</tr>
					<c:forEach items="${list }" var="dto" begin="${pagevo.rowStart-1}"
						end="${pagevo.rowEnd-1}">
						<c:if test="${not empty dto.item_dto}">
							<tr>
								<td><input type="checkbox" name="RowCheck" value=""
									class="table-check-box"></td>

								<td class="table-title">


									<div class="registrationed_alarm">
										<span><strong><a href="#"
												onclick="goToDetailListPage(${dto.total_id})">${dto.item_dto.item_name }</a></strong></span>
									</div>
									<div class="registrationed_alarm_keywords_list">
										<span class="item_tag_01"> 물건</span> <span class="item_tag_02">${dto.item_dto.item_name}</span>
										<span class="item_tag_03">${dto.item_dto.lostday}</span> <span
											class="item_tag_04">${dto.item_dto.upr_cd}</span> <span
											class="item_tag_05">${dto.item_dto.address}</span>
									</div>
								</td>

								<td>
									<!-- <input type="image" src="resources/img/trash_icon.png"
								onclick="" style="cursor: pointer;" /> -->
								</td>
							</tr>
						</c:if>
						<c:if test="${not empty dto.animal_dto}">
							<tr>
								<td><input type="checkbox" name="RowCheck" value=""
									class="table-check-box"></td>

								<td class="table-title">


									<div class="registrationed_alarm">
										<span><strong><a href="#"
												onclick="goToDetailListPage(${dto.total_id})">${dto.animal_dto.animal_name }</a></strong></span>
									</div>
									<div class="registrationed_alarm_keywords_list">
										<span class="item_tag_01"> 동물</span> <span class="item_tag_02">${dto.animal_dto.animal_name}</span>
										<span class="item_tag_03">${dto.animal_dto.missingday}</span>
										<span class="item_tag_04">${dto.animal_dto.upr_cd}</span> <span
											class="item_tag_05">${dto.animal_dto.address}</span>
									</div>
								</td>

								<td>
									<!-- <input type="image" src="resources/img/trash_icon.png"
								onclick="" style="cursor: pointer;" /> -->
								</td>
							</tr>

						</c:if>
					</c:forEach>


				</table>
			</div>
		</div>


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
</body>

</html>
