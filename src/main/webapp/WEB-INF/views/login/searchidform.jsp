<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href="resources/css/main_selection.css" />
<link rel="stylesheet" href="resources/css/searchidform.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
	rel='stylesheet' type='text/css'>

</head>
<body>

	<div class="main-selection">
		<div class="selection-name">
			<span>아이디 찾기</span>
		</div>
		<div class="selection-explain">
			<span></span>
		</div>
	</div>

	<main>

		<div class="searchid_insert"
			style="width: 100%; height: 400px;  display: flex; justify-content: center; align-items: center; margin: auto; margin-top: 20px; text-align: center;">
			<form action="loginform">
				<div class="input-box">
					<input type="text" id="email" name="email" placeholder="이메일" required="required" /> <label
						for="email">이메일</label>
				</div>
				<div
					style="display: flex; justify-content: flex-start; margin-top: 40px;">
					<input type="button" id="searchid" name="searchid"
						onclick="searchid();" value="찾기" style="cursor: pointer;"> <input type="submit"
						id="searchid" value="확인" style="margin-left: 10px; cursor: pointer;">
				</div>

			</form>
		</div>
	</main>

	<script>
		$(document).ready(function() {
			$("#searchid").click(searchid);
		});
		function searchid() {
			$.ajax({
				url : "searchid",
				type : "post",
				datatype : "json",
				data : {
					"email" : $("#email").val()
				},
				success : function(fineid) {
					if (fineid != null) {
						if (fineid == "") {
							alert("아이디가 없습니다.")
						} else {
							alert("아이디 : " + fineid);
						}
					}
				}
			});
		}
	</script>
</body>
</html>