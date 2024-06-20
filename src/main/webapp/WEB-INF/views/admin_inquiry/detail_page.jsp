<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kor">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="resources/css/admin_inquiry_write_page.css">
<title>Document</title>
<style>
body {
	margin: 0px;
	padding: 0px;
	font-family: "Noto Sans KR", sans-serif;
	font-optical-sizing: auto;
	font-weight: 500;
	font-style: normal;
}
</style>
</head>

<body>
	<div class="main-container">
		<div class="main-selection">
			<div class="index">
				<span>1대1문의 관리</span><span>></span><span>상세검색</span><span>></span><span>문의글
					상세페이지</span>
			</div>
			<div class="main-selection-flex">
				<div class="main-selection-ex">
					<div class="title">문의글 상세페이지</div>
				</div>
			</div>
		</div>

		<div class="main-contents">
			<ul class="top-btns">
				<li><button type="button" id="list">목록으로</button></li>
				<li><button type="button" id="delete">삭제하기</button></li>
			</ul>
			<div class="image-selection">
				<div class="image-container" >
					<img src="resources/inquiry_img/${list.userInquiry.board_filesrc}"
						onerror="this.onerror=null; this.src='resources/img/image_no.png'"
						id="inquiry-image" style="cursor: pointer;"
						onclick="window.open(this.src)">
				</div>
				</div>
				<!-- table1 -->
				<div class="table-container">
					<div class="table-title">
						<img src="resources/img/clipboard.png" alt=""><span>회원
							문의내용</span>
					</div>
					<div class="table">

						<div class="table-row">
							<div class="row-title">
								<span>관리번호</span>
							</div>
							<div class="row-content">${list.userInquiry.board_num}</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>제목</span>
							</div>
							<div class="row-content">${list.userInquiry.board_title}</div>
						</div>
						<div class="table-row" id="lg-content">
							<div class="row-title">
								<span>내용</span>
							</div>
							<div class="row-content" id="lg-content">${list.userInquiry.board_content}</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>등록일자</span>
							</div>
							<div class="row-content">${list.userInquiry.board_registration_date}</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>처리상태</span>
							</div>
							<c:choose>
								<c:when test="${list.userInquiry.board_reply_status eq '답변완료'}">
									<div class="row-content" style="color: #0066ff">${list.userInquiry.board_reply_status}</div>
								</c:when>
								<c:otherwise>
									<div class="row-content">${list.userInquiry.board_reply_status}</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<c:if test="${list.userInquiry.board_reply_status eq '답변완료'}">
					<!-- table2 -->
					<div class="table-container">
						<div class="table-title">
							<img src="resources/img/clipboard.png" alt=""><span>관리자
								답변</span>
						</div>
						<div class="table">
							<div class="table-row">
								<div class="row-title">
									<span>처리일자</span>
								</div>
								<div class="row-content">${list.board_reply_date}</div>
							</div>
							<div class="table-row">
								<div class="row-title">
									<span>답변내용</span>
								</div>
								<div class="row-content" id="lg-content">
									${list.board_reply}</div>
							</div>
						</div>
					</div>
				</c:if>
				<ul class="bottom-btns">
					<c:choose>
						<c:when test="${list.userInquiry.board_reply_status eq '답변완료'}">
							<li><button type="button" id="to-write-page">답변수정</button></li>
						</c:when>
						<c:otherwise>
							<li><button type="button" id="to-write-page">답변작성</button></li>
						</c:otherwise>
					</c:choose>
				</ul>
				<!-- form 시작 -->
				<form action="admin_inquiry_write_page" method="get" id="get_form">
					<!-- hidden 보드넘 , 검색조건-->
					<input type="hidden" name="board_num"
						value="${list.userInquiry.board_num}"> <input
						type="hidden" name="currPage" value="${currPage}"> <input
						type="hidden" name="START_YMD" value="${search.START_YMD}">
					<input type="hidden" name="END_YMD" value="${search.END_YMD}">
					<input type="hidden" name="reply_status"
						value="${search.reply_status}"> <input type="hidden"
						name="search_type" value="${search.search_type}"> <input
						type="hidden" name="search_content"
						value="${search.search_content}">
				</form>
				<!-- form 끝 -->
			</div>
		</div>
</body>
<script>
	$(document).ready(function() {
		// "답변수정" 버튼 클릭 시
		$("#to-write-page").click(function() {
			$("#get_form").submit();
		});
	});

	// 리스트(목록) 버튼에 리스너 추가
	let listpath = "admin_inquiry_list_page?";
	$(document).ready(function() {
		$("#list").click(function() {
			// inquiry-form의 모든 매개변수를 가져와서 URL에 추가
			let form = document.getElementById("get_form");
			let formData = new FormData(form);
			// FormData의 각 항목에 대해 반복
			formData.forEach(function(value, key) {
				// board_num일 경우에는 추가하지 않음
				if (key !== "board_num") {
					listpath += '&' + key + '=' + value; // 새로운 경로에 항목 추가
				}
			});
			window.location.href = listpath; // listpage로 이동
		});
	});
	
	//삭제버튼애드리스너
	$(document).ready(function() {
	    $("#delete").click(function() {
	        // 삭제하기 버튼 클릭 시 경고창 표시
	        var confirmDelete = confirm("정말 삭제하시겠습니까?");
	        if (confirmDelete) {
	            // "예"를 선택한 경우 폼 제출
	            var form = document.getElementById("get_form");
	            form.action = "admin_inquiry_delete"; // 폼의 action 변경
	            form.method = "post"; // 폼의 method 변경
	            form.submit(); // 폼 제출
	        } else {
	            // "아니오"를 선택한 경우 아무 동작도 하지 않음
	        }
	    });
	});
</script>
</html>