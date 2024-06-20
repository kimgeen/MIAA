<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link rel="stylesheet" href="resources/css/mypage_customer_inquiry_detail_page.css">
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

		<div class="main-contents">
				
				<div class="image-selection">
        <div class="image-container">
            <img src="resources/inquiry_img/${list.userInquiry.board_filesrc}" onerror="this.onerror=null; this.src='resources/img/image_no.png'" id="inquiry-image" style="cursor: pointer;" onclick="window.open(this.src)">
        </div>

    </div>
				
				
				<div class="table-container">
					<div class="table-title">
						<img src="resources/img/clipboard.png" alt=""><span>상세내역</span>
					</div>
					<div class="table">

						<div class="table-row">
							<div class="row-title">
								<span>관리번호</span>
							</div>
							<div class="row-content">
								<input type="text" name="inquiry_title" id="inquiry_title" readonly="readonly" value="${list.userInquiry.board_num}">
							</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>제목</span>
							</div>
							<div class="row-content" id="input-title">
								<input type="text" name="inquiry_title" id="inquiry_title" readonly="readonly" value="${list.userInquiry.board_title}">
							</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>내용</span>
							</div>
							<div class="row-content" id="textarea-content">
								<!-- 텍스트제한 표시 추가 필요 -->
								<textarea name="inquiry_content" id="inquiry_content" maxlength="300" readonly="readonly">${list.userInquiry.board_content}</textarea>
							</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>등록일자</span>
							</div>
							<div class="row-content">
								<input type="text" name="inquiry_title" id="inquiry_title" readonly="readonly" value="${list.userInquiry.board_registration_date}">
							</div>
						</div>
						
						<!-- 이미지만 업로드가능하고 이미지클릭해서 다운로드 가능하기에 주석처리 -->
						
						<%-- <div class="table-row">
							<div class="row-title">
								<span>첨부파일</span>
							</div>
							<div class="row-content">
								<input type="text" name="inquiry_title" id="inquiry_title"
									placeholder="첨부파일 없음" readonly="readonly" value="${list.board_filesrc}">
							</div>
						</div> --%>
						
						<div class="table-row">
							<div class="row-title">
								<span>처리상태</span>
							</div>
							<div class="row-content">
								<input type="text" name="inquiry_title" id="inquiry_title" readonly="readonly" value="${list.userInquiry.board_reply_status}">
							</div>
						</div>
						<c:if test="${list.userInquiry.board_reply_status eq '답변완료'}">
						<div class="table-row">
							<div class="row-title">
								<span>답변일자</span>
							</div>
							<div class="row-content" id="input-title">
								<input type="text" name="inquiry_title" id="inquiry_title" readonly="readonly" value="${list.board_reply_date}">
							</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>답변</span>
							</div>
							<div class="row-content" id="textarea-content">
								<!-- 텍스트제한 표시 추가 필요 -->
								<textarea name="inquiry_content" id="inquiry_content" maxlength="300" readonly="readonly">${list.board_reply}</textarea>
							</div>
						</div>
						</c:if>

						
					</div>
				</div>

				<ul class="bottom-btns">
					<li><button type="button"
							onclick="location.href='mypage_customer_inquiry_list_page?currPage=${currPage}&START_YMD=${START_YMD}&END_YMD=${END_YMD}&reply_status=${reply_status}';">목록으로</button></li>
				</ul>

		</div>
	</div>
</body>

</html>