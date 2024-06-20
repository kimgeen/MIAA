<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/mypage_delete_account_page.css" />
</head>
<body>
<div>
<main> 	
		<div class="pw_insert"
			style="width: 100%; height: 400px;  display: flex; justify-content: center; align-items: center; margin: auto; margin-top: 20px; text-align: center;">
			<form action="del_account">				
				<div class="input-box">
					<input type="text" id="pw" name="pw" placeholder="비밀번호" required="required" /> <label
						for="pw">비밀번호</label>
				</div>
				<div class="check">
					<div class="delBtn-container">
						<input type="submit" id="del_account" value="확인" style="cursor: pointer; ">
					</div>
					
				</div>
			</form>
		</div>
	</main>

</div>
</body>
</html>