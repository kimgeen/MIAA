<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <link rel="stylesheet" href="resources/css/main_selection.css"/>
    <link rel="stylesheet" href="resources/css/searchpwform.css"/>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
    <link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
          rel='stylesheet' type='text/css'>

</head>
<style>

    /* 모달창 */
    * {
        box-sizing: border-box;
    }

    .pw_modal {
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
        top: 0px;
        left: 0px;
        width: 100%;
        height: 100%;
        /* 중앙에 오게하는 코드 */
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .pw-modal-content {
        /* 스타일 - customize */
        max-width: 350px;
        width: 100%;
        height: 200px;
        background-color: white;
        /* padding: 15px; */
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        /* 트랜지션 효과 */
        opacity: 0;
        transition: opacity 0.3s ease-in-out, transform 0.3s ease-in-out;
        transform: scale(0.8);
        /* 중앙에 오게하는 코드 */
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .pw_modal.show {
        /* 모달이 열렸을 때 보여지게 하는 코드 */
        opacity: 1;
        pointer-events: auto;
    }

    .pw_modal.show .pw-modal-content {
        /* 모달이 열렸을 때 보여지게 하는 코드 */
        opacity: 1;
        transform: scale(1);
    }

    /*.close {*/
    /*    color: #aaa;*/
    /*    float: right;*/
    /*    font-size: 28px;*/
    /*    font-weight: bold;*/
    /*    cursor: pointer;*/
    /*}*/

    /*.close:hover {*/
    /*    color: black;*/
    /*}*/

</style>

<body>

<div class="main-selection">
    <div class="selection-name">
        <span>비밀번호 찾기</span>
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
                <input type="text" id="id" name="id" placeholder="아이디" required="required"/> <label
                    for="id">아이디</label>
            </div>
            <div class="input-box">
                <input type="text" id="email" name="email" placeholder="이메일" required="required"/> <label
                    for="email">이메일</label>
            </div>
            <div
                    style="display: flex; justify-content: flex-start; margin-top: 40px;">
                <input type="button" id="searchpw" name="searchpw"
                       onclick="searchpw();" value="찾기" style="cursor: pointer;"> <input type="submit"
                                                                                         id="searchpw" value="확인"
                                                                                         style="margin-left: 10px; cursor: pointer;">
            </div>

        </form>
    </div>
</main>

<script>
    $(document).ready(function () {
        $("#searchpw").click(searchpw);
    });

    function searchpw() {
        $.ajax({
            url: "searchpw",
            type: "post",
            datatype: "json",
            data: {
                "id": $("#id").val(),
                "email": $("#email").val()
            },
            success: function (finepw) {
                if (finepw != null) {
                    if (finepw == "") {
                        // alert("아이디,이름,이메일을 다시 입력하세요.");
                        document.getElementById("pw_content").innerHTML="아이디,이름,이메일을 다시 입력하세요.";
                    } else {
                        // alert("해당 메일로 비밀번호가 발송되었습니다.");
                        document.getElementById("pw_content").innerHTML="해당 메일로 비밀번호가 발송되었습니다.";
                        document.getElementById("pwModal").classList.toggle("show");
                    }
                }
            }
        });
    }
</script>

<!-- 모달 창 -->
<div id="pwModal" class="pw_modal">
    <div class="pw-modal-content">

        <div id="pw_content" style="display: flex; justify-content: center; align-items: center; height: 100px">

        </div>

        <div style="height: 50px; width: 100px; background-color: #0066ff;
        text-align: center; line-height: 50px; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);">
				<span><a style="color: #ffffff; font-size: 18px;" href="searchpwform">확인</a></span>
        </div>

    </div>

</div>
<script>
    // HTML 문서의 로딩이 완료되었을 때, 해당 함수를 실행
    // document.addEventListener("DOMContentLoaded", function () {
    //     // elements
    //     // var modalBtn = document.getElementById("modalBtn");
    //     var modal = document.getElementById("pwModal");
    //     var closeBtn = document.getElementById("closeBtn");
    //
    //     // functions
    //     function toggleModal() {
    //         modal.classList.toggle("show");
    //     }
    //
    //     // events
    //     // modalBtn.addEventListener("click", toggleModal);
    //     // closeBtn.addEventListener("click", function () {
    //     //     toggleModal();
    //     //     changeImg();
    //     // });
    //
    //     window.addEventListener("click", function (event) {
    //         // 모달의 검은색 배경 부분이 클릭된 경우 닫히도록 하는 코드
    //         if (event.target === modal) {
    //             toggleModal();
    //             // changeImg();
    //         }
    //     });
    // });
</script>
</body>
</html>