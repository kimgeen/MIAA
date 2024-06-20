<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<link rel="stylesheet"
	href="resources/css/mypage_customer_inquiry_modify_page.css">
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
<!-- 글자수 제한 표현 -->
<script>
	$(document).on("keydown change", "#inquiry_content", function() {
		let content = $(this).val();

		// 글자수 세기
		if (content.length == 0 || content == '') {
			$('.textCount').text('0자');
		} else {
			$('.textCount').text(content.length + '자');
		}

		// 글자수 제한
		if (content.length > 300) {
			// 300자 부터는 타이핑 되지 않도록
			$(this).val($(this).val().substring(0, 300));
			// 300자 넘으면 알림창 뜨도록
			alert('글자수는 300자까지 입력 가능합니다.');
		}
		;
	});
</script>
<!-- 파일크기 제한 -->
<script>
	$(document).on("change", "input[type='file']", function() {
		var fileVal = $(this).val();
		if (fileVal != "") {
			var ext = fileVal.split('.').pop().toLowerCase(); //확장자분리
			//아래 확장자가 있는지 체크
			if ($.inArray(ext, [ 'jpg', 'jpeg', 'gif', 'png' ]) == -1) {
				alert('jpg,gif,jpeg,png 파일만 업로드 할수 있습니다.');
				$(this).val("");
				return;
			}
			const inputValue = event.target.value;
			console.log(inputValue);
			console.log(event.target.files);
			var maxSize = 3 * 1024 * 1024; // 3MB
			var fileSize = $(this)[0].files[0].size;
			if (fileSize > maxSize) {
				alert("첨부파일 사이즈는 3MB 이내로 등록 가능합니다.");
				$(this).val("");
				return;
			}
		}

	});
</script>
<body>
	<div class="main-container">

		<div class="main-contents">

			<form action="inquiry_modify" method="post"
			enctype="multipart/form-data">

				<div class="table-container">
					<div class="table-title">
						<img src="resources/img/clipboard.png" alt=""><span>*필수입력사항</span>
					</div>
					<div class="table">

						<div class="table-row">
							<div class="row-title">
								<span>*제목</span>
							</div>
							<div class="row-content">
								<input type="text" name="inquiry_title" id="inquiry_title"
									placeholder="제목을 입력하세요" required="required"
									value="${list.board_title}">
							</div>
						</div>

						<div class="table-row">
							<div class="row-title">
								<span>*내용</span>
							</div>
							<div class="row-content" id="textarea-content">
								<!-- 텍스트제한 표시 추가 필요 -->
								<textarea name="inquiry_content" id="inquiry_content"
									maxlength="300" placeholder="내용을 입력하세요." required="required">${list.board_content}</textarea>
								<div class="textLengthWrap">
									<span class="textCount">${fn:length(list.board_content)}자</span> <span class="textTotal">/300자</span>
								</div>
							</div>
						</div>
						<!-- 파일형식 제한 필요 -->
						<div class="table-row">
							<div class="row-title">
								<span>사진첨부</span>
							</div>
							<div class="col-content">
								<div class="in-row-content">
									<input type="file" name="files" id="file1" accept="image/*">
									<label for="file1">사진첨부</label>
								</div>
															
								<div class="image-ex-text">*첨부파일은 한개당 3mb까지 제한되고 확장자는
									JPEG,GIF,PNG로 제한됩니다.</div>
							</div>
						</div>
					</div>
				</div>

				<ul class="bottom-btns">
					<input type="hidden" name="inquiry_num" value="${list.board_num}" />
					<li><button type="submit">수정하기</button></li>
					<li><button type="button"
							onclick="location.href='mypage_customer_inquiry_list_page';">취소하기</button></li>
				</ul>

			</form>

		</div>
	</div>
</body>

</html>