<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/css/header.css"/>
    <title>Insert title here</title>
</head>
<style>

    /* 모달창 */
    * {
        box-sizing: border-box;
    }

    .modal {
        font-size: 15px;
        /* 스타일 - customize */
        /* background-color: rgba(0, 0, 0, 0.7); */
        pointer-events: none;
        padding: 20px;
        /* 트랜지션 효과 */
        transition: opacity 0.3s ease-in-out;
        opacity: 0;
        /* 화면 전체를 덮게하는 코드 */
        position: fixed;
        top: -58px;
        left: 350px;
        width: 100%;
        height: 100%;
        /* 중앙에 오게하는 코드 */
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .modal-content {
        /* 스타일 - customize */
        max-width: 350px;
        width: 100%;
        height: 750px;
        background-color: white;
        /* padding: 15px; */
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        /* 트랜지션 효과 */
        opacity: 0;
        transition: opacity 0.3s ease-in-out, transform 0.3s ease-in-out;
        transform: scale(0.8);
    }

    .modal.show {
        /* 모달이 열렸을 때 보여지게 하는 코드 */
        opacity: 1;
        pointer-events: auto;
    }

    .modal.show .modal-content {
        /* 모달이 열렸을 때 보여지게 하는 코드 */
        opacity: 1;
        transform: scale(1);
    }

    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
        cursor: pointer;
    }

    .close:hover {
        color: black;
    }

    /* 떨림 효과 */
    .bell:hover {
        animation: vibration 0.5s infinite;
    }

    @keyframes vibration {
        from {
            transform: rotate(5deg);

        }

        to {
            transform: rotate(-5deg);
        }

    }

    /* 모달창 CSS */
    .modal-content-view {
        margin-top: 20px;
        padding: 8px;
        border-radius: 8px;
        flex-shrink: 0;
        color: #ffffff;
        border-style: none;
        background-color: #fafafa;
        color: black;
        font-family: inherit;
        border: 1px solid #D8D8D8;
        /* 글넘침 방지 */
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        word-spacing: break-all;
    }
</style>
<body>
<div class="header_wrapper">
    <div id="logo_container" onclick="location.href='/miaa';"
         style="cursor: pointer;">
        <img src="resources/img/logo.png" alt="">
    </div>
    <div class="nologo_container">
        <div class="menu_cotainer">
            <div class="menu_title"
                 onclick="location.href='found_item_search_page?cityname=&allsearchPage=1&prd_mainCategory=&prd_subCategory=&color=&START_YMD=&END_YMD=';"
                 style="cursor: pointer;">습득물 찾기
            </div>
            <div class="menu_title"
                 onclick="location.href='lost_item_search_page';"
                 style="cursor: pointer;">분실물 등록
            </div>
            <div class="menu_title"
                 onclick="location.href='rescue_ani_search_page';"
                 style="cursor: pointer;">보호동물 찾기
            </div>
            <div class="menu_title"
                 onclick="location.href='missing_ani_search_page';"
                 style="cursor: pointer;">실종동물 등록
            </div>
        </div>
        <!-- 로그인 전 -->
        <c:if test="${userId == null}">
        <div class="header-btn-container">
            <div class="btn-container">
                <button class="btn-login" style="cursor: pointer;">
                    <div class="text-btn-login" onclick="location.href='loginform';">로그인</div>
                </button>
                <button class="btn-reg" style="cursor: pointer;">
                    <div class="text-btn-reg" onclick="location.href='joinform';">회원가입</div>
                </button>
                </c:if>
                <!-- 로그인 후 -->
                <c:if test="${userId != null}">
                <div class="header-btn-container">
                    <button class="bell-img-container" onmouseover="changeImgHover();"
                            onmouseout="changeImg();" onclick="changeImg();" id="modalBtn">
                        <img class="bell" id="img" src="resources/img/OFF.png"/>
                    </button>
                    <div class="verticalbar-container">
                        <div class="nav-list-item"></div>
                    </div>
                    <div class="btn-container">
                        <button class="btn-login" style="cursor: pointer;">
                            <div class="text-btn-login" onclick="location.href='logout';">로그아웃</div>
                        </button>
                        <button class="btn-reg" style="cursor: pointer;">
                            <div class="text-btn-reg" onclick="location.href='mypageform';">내정보</div>
                        </button>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

        <!-- 모달 창 -->
        <div id="myModal" class="modal">
            <div class="modal-content">

                <div style="height: 20px;">
                    <!-- 닫기창 -->
                    <span class="close" id="closeBtn">&times;</span>
                </div>
                <div style="margin: 20px;">
                    <div style="text-align: center; font-size: 18px; color: #0066ff;"><strong>습득물</strong></div>
                    <div>
                        <div>

                            <c:forEach items="${items}" var="item" end="2">
                                <div class="modal-content-view">
                                    <span>물품명 : </span><span>${item.getFdPrdtNm()}</span><br/> <span>보관장소
								: </span><span>${item.getDepPlace()}</span> <br/>
                                    <span>습득날짜 : </span><span>${item.getFdYmd()}</span><br/>
                                </div>
                            </c:forEach>
                            <%--							<div class="modal-content-view">--%>
                            <%--								<span>물품명 : </span><span>남성용지갑, 운전면허증 1매,우리은행카드1매, 농협카드1매,</span><br />--%>
                            <%--								<span>보관장소 : </span><span>장전지구대</span> <br /> <span>습득날짜--%>
                            <%--								: </span><span>2024-04-21</span><br />--%>
                            <%--							</div>--%>

                        </div>
                    </div>
                    <div style="margin-top: 20px; text-align: center; font-size: 18px; color: #0066ff;">
                        <strong>보호동물</strong></div>
                    <div>
                        <div>
                            <c:forEach items="${animals}" var="animal" end="2">

                                <div class="modal-content-view">
                                    <span>동물명 : </span><span>${animal.getKindCd()}</span><br/> <span>발견장소 :
							</span><span>${animal.getHappenPlace()}</span> <br/> <span>구조날짜 : </span><span>${animal.getHappenDt()}</span><br/>
                                </div>
                            </c:forEach>
<%--                            <div class="modal-content-view">--%>
<%--                                <span>동물명 : </span><span>sgsdg</span><br/> <span>발견장소 :--%>
<%--							</span><span>sgsdg</span> <br/> <span>구조날짜 : </span><span>sgsdg</span><br/>--%>
<%--                            </div>--%>
                        </div>
                    </div>

                </div>

                <div
                        style="height: 50px; background-color: #0066ff; text-align: center; line-height: 50px; border-bottom-left-radius: 5px; border-bottom-right-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);">

				<span><a style="color: #ffffff; font-size: 18px;"
                         href="mypage_matching_alarm_list_page">모두보기</a></span>
                </div>

            </div>

        </div>

</body>
<script>
    // HTML 문서의 로딩이 완료되었을 때, 해당 함수를 실행
    document.addEventListener("DOMContentLoaded", function () {
        // elements
        var modalBtn = document.getElementById("modalBtn");
        var modal = document.getElementById("myModal");
        var closeBtn = document.getElementById("closeBtn");

        // functions
        function toggleModal() {
            modal.classList.toggle("show");
        }

        // events
        modalBtn.addEventListener("click", toggleModal);
        closeBtn.addEventListener("click", function () {
            toggleModal();
            changeImg();
        });

        window.addEventListener("click", function (event) {
            // 모달의 검은색 배경 부분이 클릭된 경우 닫히도록 하는 코드
            if (event.target === modal) {
                toggleModal();
                changeImg();
            }
        });
    });
</script>
<script>
    function changeImg() {
        var image = document.getElementById('img');

        if (image.src.match('resources/img/OFF.png')) {
            image.src = 'resources/img/ON.png';
            checkImg++;

        } else {
            image.src = 'resources/img/OFF.png';
            checkImg--;

        }
    }

    function changeImgHover() {
        document.getElementById("img").src = "resources/img/alarm.png";
    }
</script>
</html>