<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Title</title>
<link rel="stylesheet" href="resources/css/admin_inquiry_list_page.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
</head>
<script type="text/javascript">

$(document).ready(function(){
    let checkedList = $("input[name='RowCheck']");
    let allCheck = $("input[name='allCheck']");
    
    //allcheck에 따라 rowcheck의 체크박스 상태 변화(해체와 체크가 둘다 true false로 각각 적용됨)
    allCheck.click(function(){
        checkedList.each(function(){
        	// jquery 객체인 allCheck의 dom요소에 접근 allCheck[0]
        	// allCheck[0]의 체크상태를 각 rowCheck 체크박스의 상태에 적용
            this.checked = allCheck[0].checked;
        });
    }); 
    
    //rowcheck의 체크박스가 하나라도 해제되면 allcheck도 해제,전체 선택일때만 allcheck가 체크됨
    checkedList.click(function(){
    	if($("input[name='RowCheck']:checked").length == checkedList.length){
    		allCheck[0].checked = true;
    	}else{
    		allCheck[0].checked = false;
    	}
    });
    
    //삭제버튼
    $("#btn-delete").click(function() {
        // 선택된 체크박스의 값을 담을 배열을 생성
        let checkedValues = [];

        // 선택된 체크박스의 값을 배열에 추가
        $("input[name='RowCheck']:checked").each(function() {
            checkedValues.push($(this).val());
        });
				
        // 만약 선택된 체크박스가 없는 경우 아무 작업도 수행하지 않음
        if (checkedValues.length === 0) {
            alert("삭제할 항목을 선택해주세요.");
            return;
        }
        console.log(checkedValues);
        // 삭제를 확인하는 경고창을 띄우고, 확인 시 서버로 선택된 항목을 전송
        let confirmDelete = confirm("정말 삭제하시겠습니까?");
        if (confirmDelete) {
            // 서버로 데이터를 전송합니다.
        	$.ajax({
        	    url: "admin_inquiry_delete_ajax",
        	    method: "POST",
        	    dataType : "json",
        	   traditional: true,
         	   data: {"chkVal" : checkedValues},
        	    success: function(resultCnt) {
        	    	if(resultCnt >= 1) {
        	    		//url 주소설정
	        	    		let currpage = $(".current-page").text();
	        	    		let newPath = "admin_inquiry_list_page?currPage="+currpage;
	        	    		
	        	    		// inquiry-form의 모든 매개변수를 가져와서 URL에 추가
	        			    let form = document.getElementById("inquiry-form");
	        			    
	        			 		// 폼을 초기화하는 코드 작성=====> 안넣으면 검색 조건 변경한 후 페이지버튼 누르면  검색조건 변경된 페이지가 호출됨
	        		      form.reset(); // 폼 초기화(현재페이지 렌더링기준)
	        		      
	        			    let formData = new FormData(form);
	        		      // FormData의 각 항목에 대해 반복
	        		        formData.forEach(function(value, key) {
	        		            newPath += '&' + key + '=' + value; // 새로운 경로에 항목 추가
	        		        });
        		      
                        alert("삭제 성공");
                        location.replace(newPath) //페이지 새로고침
                    }
                    else{
                        alert("삭제 실패");
                    }
                } 
        	});
        }
    });
    
});

</script>
<body>
	<div class="main-body">

		<!-- main -->

		<div class="content-wrapper">
			<!-- 검색창과 검색결과 -->
			<div class="searchbar-container">
				<form action="admin_inquiry_list_page" id="inquiry-form">
					<!-- 서치바 셀렉 그룹시작 -->
					<div class="searchbar-select-group">
						<div class="searchbar-title">
							<span>기간</span>
						</div>
						<div class="searchbar-content">
							<input type="date" name="START_YMD" id="START_YMD"
								<c:if test="${search ne null}">value="${search.START_YMD }"</c:if>>
							<span>~</span> <input type="date" name="END_YMD" id="END_YMD"
								<c:if test="${search ne null}">value="${search.END_YMD }"</c:if>>
							<div class="form-date-btn" id="date-today">
								<div class="div-placeholder">
									<div class="div">오늘</div>
								</div>
							</div>
							<div class="form-date-btn" id="date-1week">
								<div class="div-placeholder">
									<div class="div">1주일</div>
								</div>
							</div>
							<div class="form-date-btn" id="date-1month">
								<div class="div-placeholder">
									<div class="div">1개월</div>
								</div>
							</div>
							<div class="form-date-btn" id="date-3month">
								<div class="div-placeholder">
									<div class="div">3개월</div>
								</div>
							</div>
							<div class="form-date-btn" id="date-6month">
								<div class="div-placeholder">
									<div class="div">6개월</div>
								</div>
							</div>
							<div class="form-date-btn" id="date-all">
								<div class="div-placeholder">
									<div class="div">전체</div>
								</div>
							</div>
						</div>
					</div>

					<div class="searchbar-select-group">
						<div class="searchbar-title">
							<span>답변유무</span>
						</div>
						<div class="searchbar-content">
							<select name="reply_status" id="reply_status">
								<option value="all"
									<c:if test="${search.reply_status eq 'all'}">selected</c:if>>전체</option>
								<option value="ing"
									<c:if test="${search.reply_status eq 'ing'}">selected</c:if>>처리중</option>
								<option value="done"
									<c:if test="${search.reply_status eq 'done'}">selected</c:if>>답변완료</option>
							</select>
						</div>
					</div>

					<div class="searchbar-select-group">
						<div class="searchbar-title">
							<select name="search_type" id="search_type">
								<option value="title"
									<c:if test="${search.search_type eq 'title'}">selected</c:if>>제목</option>
								<option value="user"
									<c:if test="${search.search_type eq 'user'}">selected</c:if>>문의자</option>
								<option value="admin"
									<c:if test="${search.search_type eq 'admin'}">selected</c:if>>답변자</option>
							</select>
						</div>
						<div class="searchbar-content">
							<input type="search" name="search_content" id="search_content"
								style="min-width: 300px;"
								<c:if test="${search ne null or search.search_content ne ''}">value="${search.search_content}"</c:if>>
						</div>
					</div>

					<!-- form 조회용 버튼 -->
					<div class="search-btn-block">
						<button type="submit" form="inquiry-form">
							조회<img src="resources/img/searchIcon.png" alt="">
						</button>
						<button class="reset" onclick="resetForm()">
							<div class="div">초기화</div>
						</button>
					</div>
				</form>
			</div>
			<!-- 검색창과 검색결과 끝 -->
			<div class="content-container">
				<div class="table-caption-wrapper">
					<div class="talbe-caption-container">
						<div class="table-caption">
							<span class="caption-total">${pageVo.totRow}개</span><span>의
								문의내역이 있습니다</span>
						</div>
					</div>
					<div class="list-control-container">
						<button class="btn-list" id="btn-delete" style="cursor: pointer;">삭제하기</button>
					</div>

				</div>
				<table class="info-table">
					<tr>
						<th><span><input type="checkbox" name="allCheck"
								id="allCheck" class="table-check-box"></span></th>
						<th><span>글번호</span></th>
						<th class="table-title"><span>제목</span></th>
						<th><span>문의자</span></th>
						<th><span>처리상태</span></th>
						<th><span>문의 날짜</span></th>
						<th><span>답변 날짜</span></th>
						<th><span>답변자</span></th>

					</tr>

					<c:forEach items="${list }" var="list">
						<tr>
							<td><input type="checkbox" name="RowCheck"
								value="${list.userInquiry.board_num}" class="table-check-box"></td>
							<td>${list.userInquiry.board_num}</td>
							<td class="table-title" id="detail-page"><c:choose>
									<c:when test="${search ne null }">
										<a
											href="admin_inquiry_detail_page?board_num=${list.userInquiry.board_num}&currPage=${pageVo.page}&START_YMD=${search.START_YMD }&END_YMD=${search.END_YMD }&reply_status=${search.reply_status}&search_type=${search.search_type}&search_content=${search.search_content}">
											${list.userInquiry.board_title}</a>
									</c:when>
									<c:otherwise>
										<a
											href="admin_inquiry_detail_page?board_num=${list.userInquiry.board_num}&currPage=${pageVo.page}">
											${list.userInquiry.board_title}</a>
									</c:otherwise>
								</c:choose></td>
							<td>${list.userInquiry.user_id}</td>
							<c:choose>
								<c:when test="${list.userInquiry.board_reply_status eq '답변완료'}">
									<td style="color: #0066ff">${list.userInquiry.board_reply_status}</td>
								</c:when>
								<c:otherwise>
									<td>${list.userInquiry.board_reply_status}</td>
								</c:otherwise>
							</c:choose>
							<td>${list.userInquiry.board_registration_date}</td>
							<td>${list.board_reply_date }</td>
							<td>${list.admin_id }</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>

		<!-- page -->

		<div class="result-container">
			<div class="page-container">
				<div class="currentOftotal">
					<span>Page</span><span class="current-page">${pageVo.page}</span><span>of</span><span
						class="total-page">${pageVo.totPage}</span>
				</div>
				<ul class="pagelist-container">
					<li class="btn-prev"><a href="javascript:void(0);"
						onclick="goToPage(${pageVo.page}-1)"><img
							src="resources/img/chevron-left.png" alt=""></a></li>
					<c:forEach begin="${pageVo.pageStart}" end="${pageVo.pageEnd}"
						var="i">
						<c:choose>
							<c:when test="${i eq pageVo.page}">
								<li><span class="currpage">${i}</span></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:void(0);" onclick="goToPage(${i})">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<li class="btn-next"><a href="javascript:void(0);"
						onclick="goToPage(${pageVo.page}+1)"><img
							src="resources/img/chevron-left.png" alt=""></a></li>
				</ul>

				<ul class="switchBtn-container">
					<li class="btn-prev-group"><a href="javascript:void(0);"
						onclick="goToPage(${pageVo.page}-10)">Previous</a></li>
					<li class="btn-next-group"><a href="javascript:void(0);"
						onclick="goToPage(${pageVo.page}+10)">Next</a></li>
				</ul>
			</div>
		</div>

	</div>
	<script>
		function goToPage(pageNumber) {
			var currpage = pageNumber;
			if (pageNumber<=0){
				currpage = 1;
			}else if(currpage>${pageVo.totPage}){//현재페이지가 총페이지보다 클경우 현재페이지 = 총페이지 
				currpage = ${pageVo.totPage};
			}
			else if(currpage>${pageVo.pageEnd}){//페이지 표시갯수인 10이 넘을때는 해당 페이지리스트의 1번으로 가게함
				currpage= pageNumber-(pageNumber-1)%10;
			}
			else if(currpage<${pageVo.pageStart}){//-10page 버튼누를시 -10 말고 이전 페이지리스트의 10번으로 가게함
				currpage= pageNumber-((pageNumber-1)%10)+9;
			}
			var newPath = window.location.pathname + '?currPage=' + currpage;
			
		    // inquiry-form의 모든 매개변수를 가져와서 URL에 추가
		    var form = document.getElementById("inquiry-form");
		    
		 		// 폼을 초기화하는 코드 작성=====> 안넣으면 검색 조건 변경한 후 페이지버튼 누르면  검색조건 변경된 페이지가 호출됨
	      form.reset(); // 폼 초기화(현재페이지 렌더링기준)
	      
		    var formData = new FormData(form);
	      // FormData의 각 항목에 대해 반복
	        formData.forEach(function(value, key) {
	            newPath += '&' + key + '=' + value; // 새로운 경로에 항목 추가
	        });
		    
			window.location.href = newPath; // 새 경로로 페이지 이동
			
		}
	</script>
	<!-- 날짜 제한 -->
	<script>
					var now_utc = Date.now() // 지금 날짜를 밀리초로
					// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
					var timeOff = new Date().getTimezoneOffset() * 60000; // 분단위를 밀리초로 변환
					// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
					var today = new Date(now_utc - timeOff).toISOString()
							.split("T")[0];
					var today2 = new Date(now_utc - timeOff)//.getFullYear()등을 쓰기위한 today2
		$(document).ready(
				function() {//로드완료시
					document.getElementById("START_YMD").setAttribute("max",
							today); //시작날짜 최대값 오늘날짜로 제한
					document.getElementById("END_YMD").setAttribute("max",
							today);//종료날짜 오늘날짜로 제한
				});
 /*날짜선택버튼*/
	document.getElementById('date-today').addEventListener('click', function() {
	    document.getElementById('START_YMD').value = today;
	    document.getElementById('END_YMD').value = today;
	});

	document.getElementById('date-1week').addEventListener('click', function() {
	    const lastWeek = new Date(today2.getFullYear(), today2.getMonth(), today2.getDate() - 7);
	    document.getElementById('START_YMD').value = lastWeek.toISOString().substring(0, 10); // 일주일 전 날짜
	    document.getElementById('END_YMD').value = today.toISOString().substring(0, 10); // 오늘 날짜
	});

	document.getElementById('date-1month').addEventListener('click', setPastDate.bind(null, 1));
	document.getElementById('date-3month').addEventListener('click', setPastDate.bind(null, 3));
	document.getElementById('date-6month').addEventListener('click', setPastDate.bind(null, 6));

	function setPastDate(months) {
	    const pastDate = new Date(today2.getFullYear(), today2.getMonth() - months, today2.getDate());
	    document.getElementById('START_YMD').value = pastDate.toISOString().substring(0, 10);
	    document.getElementById('END_YMD').value = today2.toISOString().substring(0, 10);
	}
	document.getElementById('date-all').addEventListener('click', function() {
	    document.getElementById('START_YMD').value = ""; // 입력 필드를 비웁니다
	    document.getElementById('END_YMD').value = ""; // 입력 필드를 비웁니다
	});
	
	</script>

	<script>
    $(document).ready(function() {
        $(".reset").click(function(event) {
            event.preventDefault(); // 폼의 기본 동작 중지
            // form 안의 input 요소의 값을 빈 문자열로 설정
            $('#inquiry-form input').val('');

            // form 안의 select 요소의 selectedIndex를 0으로 설정하여 첫 번째 옵션을 선택
            $('#inquiry-form select').prop('selectedIndex', 0);
        });
    });
    
</script>

</body>
</html>