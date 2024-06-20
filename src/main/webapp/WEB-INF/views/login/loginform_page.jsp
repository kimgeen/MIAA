<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/main_selection.css" />
<link rel="stylesheet" href="resources/css/loginform.css" />
</head>
<body>
	<main>
	 	<div class="main-selection">
		<div class="selection-name">
			<span>로그인 하기</span>
		</div>
		<div class="selection-explain">
			<span> 아직 계정이 없으신가요? <a href="joinform"
				style="color: #0066FF; text-decoration: underline;">가입하기</a>
			</span>
		</div>
	</div>
		<div class="login_insert"
			style="width: 100%; height: 400px;  display: flex; justify-content: center; align-items: center; margin: auto; margin-top: 20px; text-align: center;">
			<form action="login">
				<div class="input-box">
					<input type="text" id="id" name="id" placeholder="아이디" required="required" /> <label
						for="id">아이디</label>
				</div>
				<div class="input-box">
					<input type="password" id="pw" name="pw" placeholder="비밀번호" required="required"/> <label
						for="pw">비밀번호</label>
				</div>
				<div class="forgot">
					<div>
						<input type="submit" id="login" value="로그인" style="cursor: pointer;">
					</div>
					<div class="searchBtn">
						<a href="searchidform" style="text-align: right;">아이디 찾기</a> <a
							href="searchpwform" style="text-align: right;">비밀번호 찾기</a>
					</div>
				</div>
			</form>
		</div>
	</main>

</body>
</html>