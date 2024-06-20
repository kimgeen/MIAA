<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/admin_header.css" />
<title>Insert title here</title>
</head>
<body>
    <div class="header_wrapper">
      <div id="logo_container" onclick="location.href='admin_main_page';" style="cursor: pointer;">
        <img src="resources/img/logo.png" alt="">
      </div>
      <div class="admin_title">
      	관리자페이지      
      </div>
      <div class="nologo_container">
        <div class="menu_cotainer">
          <div class="menu_title" onclick="location.href='admin_inquiry_list_page';" style="cursor: pointer;">
            1대1문의 관리
          </div>
          <div class="menu_title" onclick="location.href='admin_member_management_page';" style="cursor: pointer;">
            회원 관리
          </div>
        </div>
        <!-- 로그인 전 -->
<c:if test= "${userId == null}">
        <div class="header-btn-container">
          <div class="btn-container">
            <button class="btn-login" style="cursor: pointer;">
              <div class="text-btn-login" onclick="location.href='loginform';" >로그인</div>
            </button>
            <button class="btn-reg" style="cursor: pointer;">
              <div class="text-btn-reg" onclick="location.href='joinform';" >회원가입</div>
            </button>
</c:if>
		<!-- 로그인 후 -->
<c:if test="${userId != null}">
        <div class="header-btn-container">
          <div class="verticalbar-container">
            <div class="nav-list-item"></div>
          </div>
          <div class="btn-container">
            <button class="btn-login" style="cursor: pointer;">
              <div class="text-btn-login" onclick="location.href='logout';" >로그아웃</div>
            </button>
            <button class="btn-reg" style="cursor: pointer;">
              <div class="text-btn-reg" onclick="location.href='mypageform';" >내정보</div>
            </button>
</c:if>         
          </div>
        </div>
      </div>
    </div>
</body>
</html>