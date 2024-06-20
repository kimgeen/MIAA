<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/main_selection.css" />
<link rel="stylesheet" href="resources/css/joinform.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>
<main>
	<div class="main-selection">
		<div class="selection-name">
			<span>관리자 회원가입</span>
		</div>
		<div class="selection-explain">
			<span> 이미 사용 중인 계정이 있다면 <a href="loginform"
				style="color: #0066FF; text-decoration: underline;">로그인</a> 하세요
			</span>
			<span>관리자 계정 가입을 위한 인증번호는 관련자에게 문의하세요</span>
		</div>
	</div>
	<div class="join_insert"
		style="width: 100%; height: 100%;  margin: auto; margin-top: 20px; text-align: center;">

		<form action="admin_join">

			<div class="inputbox-container">
				<div class="input-box">
					<input type="text" id="id" name="id" placeholder="아이디" required="required" /> <label
						for="id">아이디</label>
				</div>
				<div class="button-container">
					<input type="button" id="idchk" onclick="idchk();" value="아이디 중복확인" style="cursor: pointer;">
				</div>
			</div>

			<div class="inputbox-container">
				<div class="input-box">
					<input type="password" id="pw" name="pw" placeholder="비밀번호" required="required" /> <label
						for="pw">비밀번호</label>
				</div>
			</div>

			<div class="inputbox-container">
				<div class="input-box">
					<input type="password" id="pw2" name="pw2" placeholder="비밀번호 확인" required="required" />
					<label for="pw">비밀번호 확인</label>
				</div>
				<div class="button-container">
					<input type="button" id="pwchk" name="pwchk" value="비밀번호 확인" style="cursor: pointer;">
				</div>
			</div>

			<div class="inputbox-container">
				<div class="input-box">
					<input type="email" id="email" name="email" placeholder="이메일" required="required"/> <label
						for="email">이메일</label>
				</div>
				<div class="button-container">
					<input type="button" id="emailchk" onclick="emailchk();"
						value="이메일 중복확인" style="cursor: pointer;">
				</div>
			</div>
			
			
			<div class="inputbox-container">
				<div class="input-box">
					<input type="text" id="code" name="code" placeholder="인증번호" required="required" /> <label
						for="code">인증번호</label>
				</div>
			</div>

			<div class="joinBtn-container">
				<input type="submit" id="join" value="회원가입" style="cursor: pointer;">
			</div>

			<script>
				$(document).ready(function() {
					$("#idchk").click(idchk);

				});
				function idchk() {
					$.ajax({
						url : "admin_idcheck",
						type : "post",
						dataType : "json",
						data : {
							"id" : $("#id").val()
						},
						success : function(num) {
							if (num == 1) {
								alert("중복된 아이디입니다.");
							} else if (num == -1) {
								alert("아이디를 입력하세요.")
							} else {
								alert("사용가능한 아이디입니다.")
							}
						}
					});
				}
			</script>
			<script>
				$(document).ready(function() {
					$("#emailchk").click(emailchk);
				});
				function emailchk() {
					$.ajax({
						url : "admin_emailchk",
						type : "post",
						dataType : "json",
						data : {
							"email" : $("#email").val()
						},
						success : function(num2) {
							if (num2 == 1) {
								alert("중복된 이메일입니다.");
							} else if (num2 == 0) {
								alert("사용가능한 이메일입니다.")
							} else {
								alert("이메일을 입력하세요.")
							}
						}
					});
				}
			</script>
			<script>
				$(document).ready(function() {
					$("#pwchk").click(function() {
						if ($("#pw").val() == "" || $("#pw2").val() == "") {
							alert("비밀번호를 입력하세요.");
						} else if ($("#pw").val() == $("#pw2").val()) {
							alert("비밀번호가 일치합니다.");
						} else {
							alert("비밀번호가 일치하지 않습니다.");
						}
					})
				})
			</script>
		</form>
		</main>
</body>
</html>