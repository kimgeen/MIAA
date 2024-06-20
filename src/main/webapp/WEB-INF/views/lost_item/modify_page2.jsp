<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kor">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/lost_item_write_page.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
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
		<div class="main-selection">
			<div class="index">
				<span>분실물</span><span>></span><span>상세검색</span><span>></span><span>분실물
					상세페이지</span><span>></span><span>분실물 수정</span>
			</div>
			<div class="main-selection-flex">
				<div class="main-selection-ex">
					<div class="title">분실물 수정</div>
					<div class="describe">등록하신 분실물에 대해 변경사항을 수정하실 수 있습니다. 내정보의
						알림은 수정된 내용을 기반으로 초기화 됩니다.</div>
				</div>
			</div>
		</div>

		<div class="main-contents">
			<ul class="top-btns">
				<li><button type="submit">수정하기</button></li>
				<li><button type="button"
						onclick="history.back()">취소하기</button></li>
			</ul>
			<div class="essential">
				<span>*는 필수 입력사항 입니다</span>
			</div>
			<!-- form 시작 -->
			<form action="mypage_item_modify" method="post"
				enctype="multipart/form-data">
				<!-- table1 -->
				<div class="table-container">
					<div class="table-title">
						<img src="resources/img/clipboard.png" alt=""><span>분실자
							정보</span>
					</div>
					<div class="table">
						<div class="table-row">
							<div class="row-title">
								<span>공개여부*</span>
							</div>
							<div class="row-content">
								<div class="radio-container">
									<input type="radio" name="openclose" id="openclose"
										value="true"><span>공개</span>
								</div>
								<div class="radio-container">
									<input type="radio" name="openclose" id="openclose"
										value="false" checked><span>비공개</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- table2 -->
				<div class="table-container">
					<div class="table-title">
						<img src="resources/img/clipboard.png" alt=""><span>분실일시
							및 장소</span>
					</div>
					<div class="table">
						<div class="table-row">
							<div class="row-title">
								<span>분실날짜*</span>
							</div>
							<div class="row-content">
								<input type="date" name="lostday" id="lostday"
									value="${dto.lostday }">
							</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>분실장소*</span>
							</div>
							<div class="col-content">
								<div class="zip-container">
									<button type="button" onclick="sample6_execDaumPostcode()">
										<span>우편번호검색</span>
									</button>
								</div>
								<div class="addr-container">
									<input type="text" id="sample6_address" name="address"
										placeholder="도로명주소" readonly value="${dto.address }">
									<input type="hidden" id="sample6_extraAddress" name="address2"
										placeholder="상세주소" readonly>
								</div>
							</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>관할지*</span>
							</div>
							
							<div class="row-content">
								<select name="addressCode" id="addressCode">
									<option value="LCA000">서울특별시</option>
									<option value="LCH000">강원도</option>
									<option value="LCI000">경기도</option>
									<option value="LCJ000">경상남도</option>
									<option value="LCK000">경상북도</option>
									<option value="LCQ000">광주광역시</option>
									<option value="LCR000">대구광역시</option>
									<option value="LCS000">대전광역시</option>
									<option value="LCT000">부산광역시</option>
									<option value="LCU000">울산광역시</option>
									<option value="LCV000">인천광역시</option>
									<option value="LCL000">전라남도</option>
									<option value="LCM000">전라북도</option>
									<option value="LCN000">충청남도</option>
									<option value="LCO000">충청북도</option>
									<option value="LCP000">제주특별자치도</option>
									<option value="LCW000">세종특별자치시</option>
									<option value="LCF000">해외</option>
									<option value="LCE000">기타</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<!-- table3 -->
				<div class="table-container">
					<div class="table-title">
						<img src="resources/img/clipboard.png" alt=""><span>분실물품
							정보</span>
					</div>
					<div class="table">

						<div class="table-row">
							<div class="row-title">
								<span>품명*</span>
							</div>
							<div class="row-content">
								<input type="text" name="itemname" id="itemname"
									value="${dto.item_name }">
							</div>
						</div>
						<div class="table-row">
							<div class="row-title">
								<span>품목*</span>
							</div>
							
							<div class="row-content">
								<select name="itemkind1" id="itemkind1"
									onchange="getSubCategories(this.value)">
								<option value="컴퓨터">컴퓨터</option>
								<option value="휴대폰">휴대폰</option>
								<option value="지갑">지갑</option>
								<option value="전자기기">전자기기</option>
								<option value="산업용품">산업용품</option>
								<option value="귀금속">귀금속</option>
								<option value="기타물품">기타물품</option>
								<option value="서류">서류</option>
								<option value="스포츠용품">스포츠용품</option>
								<option value="자동차">자동차</option>
								<option value="현금">현금</option>
								<option value="의류">의류</option>
								<option value="쇼핑백">쇼핑백</option>
								<option value="악기">악기</option>
								<option value="카드">카드</option>
								<option value="유가증권">유가증권</option>
								<option value="증명서">증명서</option>
								<option value="가방">가방</option>
								<option value="도서용품">도서용품</option>
								<option value="유류품">유류품</option>
								</select> <span>-</span> <select name="itemkind2" id="itemkind2">
								</select>
							</div>
						</div>

						<div class="table-multi-row">
							<div class="table-row">
								<div class="row-title">
									<span>색상*</span>
								</div>
								<div class="row-content">
									<select name="colorCd" id="colorCd">
										<option value="CL1001">흰색</option>
										<option value="CL1002">검정</option>
										<option value="CL1003">빨강</option>
										<option value="CL1004">주황</option>
										<option value="CL1005">노랑</option>
										<option value="CL1006">초록</option>
										<option value="CL1007">파랑</option>
										<option value="CL1008">갈색</option>
										<option value="CL1009">보라</option>
										<option value="CL1010">핑크</option>
										<option value="CL1011">기타</option>
									</select>
								</div>
							</div>
						</div>

						<div class="table-row">
							<div class="row-title">
								<span>특징*</span>
							</div>
							<div class="row-content" id="textarea-content">
								<!-- 텍스트제한 표시 추가 필요 -->
								<textarea name="sepcialMark" id="sepcialMark" maxlength="300">${dto.sepcialmark }</textarea>
							</div>
						</div>
						<!-- 파일형식 제한 필요 -->
						<div class="table-row">
							<div class="row-title">
								<span>사진첨부</span>
							</div>
							<div class="col-content">
								*수정 시 사진을 다시 넣어 주세요.
								<div class="in-row-content">
									<input type="file" name="files" id="file1" accept="image/*">
									<label for="file1">사진첨부</label>
								</div>
								<div class="in-row-content">
									<input type="file" name="files" id="file2" accept="image/*">
									<label for="file2">사진첨부</label>
								</div>
								<div class="in-row-content">
									<input type="file" name="files" id="file3" accept="image/*">
									<label for="file3">사진첨부</label>
								</div>
								<div class="in-row-content">
									<input type="file" name="files" id="file4" accept="image/*">
									<label for="file4">사진첨부</label>
								</div>
								<div class="in-row-content">
									<input type="file" name="files" id="file5" accept="image/*">
									<label for="file5">사진첨부</label>
								</div>
								<div class="image-ex-text">*첨부파일은 한개당 3mb까지 제한되고 확장자는
									JPEG,GIF,PNG로 제한됩니다.</div>
							</div>
						</div>
					</div>
				</div>
				<ul class="bottom-btns">
					<li><button type="submit">수정완료</button></li>
					<li><button type="button"
							onclick="history.back()">취소하기</button></li>
				</ul>
				<!-- hidden 세션로그인 id -->
				<input type="hidden" name="total_id" value="${dto.total_id }">
				<input type="hidden" name="user_id" value="${dto.user_id }">
			</form>
			<!-- form 끝 -->
		</div>
	</div>
	<script>
		//주소록 찾기
		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							var addr = ''; // 주소 변수
							var extraAddr = ''; // 참고항목 변수
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								addr = data.roadAddress;
							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								addr = data.jibunAddress;
							}
							if (data.userSelectedType === 'R') {
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								document.getElementById("sample6_extraAddress").value = extraAddr;

							} else {
								document.getElementById("sample6_extraAddress").value = '';
							}

							document.getElementById("sample6_address").value = addr;
						}
					}).open();
		}
	</script>
	<script>
		function getSubCategories(mainCategory) {
			var prd_subCategory = document.getElementById("itemkind2");
			switch (mainCategory) {
			case '컴퓨터': // 컴퓨터
				itemkind2.innerHTML = '<option value="삼성노트북">삼성노트북</option><option value="LG노트북">LG노트북</option><option value="삼보노트북">삼보 노트북</option><option value="기타">기타</option><option value="HP노트북">HP노트북</option><option value="애플노트북">애플 노트북</option>';
				break;
			case '휴대폰': // 휴대폰
				itemkind2.innerHTML = '<option value="삼성휴대폰">삼성 휴대폰</option><option value="LG휴대폰">LG휴대폰</option><option value="스카이휴대폰">스카이휴대폰</option><option value="아이폰">아이폰</option><option value="기타통신기기">기타통신기기</option><option value="모토로라휴대폰">모토로라 휴대폰</option><option value="기타휴대폰">기타 휴대폰</option>';
				break;
			case '지갑': // 지갑
				itemkind2.innerHTML = '<option value="여성용 지갑">여성용 지갑</option><option value="남성용 지갑">남성용 지갑</option><option value="기타 지갑">기타 지갑</option>';
				break;
			case '전자기기': // 전자기기
				itemkind2.innerHTML = '<option value="PMP">PMP</option><option value="MP3">MP3</option><option value="PDA">PDA</option><option value="카메라">카메라</option><option value="전자수첩">전자수첩</option><option value="기타용품">기타용품</option><option value="태블릿">태블릿</option><option value="스마트워치">스마트워치</option><option value="무선이어폰">무선이어폰</option>';
				break;
			case '산업용품': // 산업용품
				itemkind2.innerHTML = '<option value="기타물품">기타물품</option>';
				break;
			case '귀금속': // 귀금속
				itemkind2.innerHTML = '<option value="반지">반지</option><option value="목걸이">목걸이</option><option value="귀걸이">귀걸이</option><option value="시계">시계</option><option value="기타">기타</option>';
				break;
			case '기타물품': // 기타물품
				itemkind2.innerHTML = '<option value="기타">기타</option><option value="매장문화재">매장문화재</option><option value="선글라스">선글라스</option><option value="안경">안경</option>';
				break;
			case '서류': // 서류
				itemkind2.innerHTML = '<option value="서류">서류</option><option value="기타물품">기타물품</option>';
				break;
			case '스포츠용품': // 스포츠용품
				itemkind2.innerHTML = '<option value="스포츠용품">스포츠용품</option><option value="수영복">수영복</option><option value="수영물품">수영물품</option>';
				break;
			case '자동차': // 자동차
				itemkind2.innerHTML = '<option value="자동차열쇠">자동차열쇠</option><option value="네비게이션">네비게이션</option><option value="자동차번호판">자동차번호판</option><option value="기타용품">기타용품</option><option value="임시번호판">임시번호판</option>';
				break;
			case '현금': // 현금
				itemkind2.innerHTML = '<option value="현금">현금</option><option value="수표">수표</option><option value="기타">기타</option><option value="외화">외화</option>';
				break;
			case '의류': // 의류
				itemkind2.innerHTML = '<option value="여성의류">여성의류</option><option value="남성의류">남성의류</option><option value="아기의류">아기의류</option><option value="기타의류">기타의류</option><option value="모자">모자</option><option value="신발">신발</option>';
				break;
			case '쇼핑백': // 쇼핑백
				itemkind2.innerHTML = '<option value="쇼핑백">쇼핑백</option>';
				break;
			case '악기': // 악기
				itemkind2.innerHTML = '<option value="건반악기">건반악기</option><option value="관악기">관악기</option><option value="타악기">타악기</option><option value="현악기">현악기</option><option value="기타악기">기타악기</option>';
				break;
			case '카드': // 카드
				itemkind2.innerHTML = '<option value="신용(체크)카드">신용(체크)카드</option><option value="일반카드">일반카드</option><option value="기타카드">기타카드</option>';
				break;
			case '유가증권': // 유가증권
				itemkind2.innerHTML = '<option value="어음">어음</option><option value="상품권">상품권</option><option value="채권">채권</option><option value="기타">기타</option>';
				break;
			case '증명서': // 증명서
				itemkind2.innerHTML = '<option value="신분증">신분증</option><option value="면허증">면허증</option><option value="여권">여권</option><option value="기타">기타</option><option value="판결문">판결문</option>';
				break;
			case '가방': // 가방
				itemkind2.innerHTML = '<option value="여성용가방">여성용가방</option><option value="남성용가방">남성용가방</option><option value="기타가방">기타가방</option>';
				break;
			case '도서용품': // 도서용품
				itemkind2.innerHTML = '<option value="학습서적">학습서적</option><option value="소설">소설</option><option value="컴퓨터서적">컴퓨터서적</option><option value="만화책">만화책</option><option value="기타서적">기타서적</option>';
				break;
			case '유류품': // 유류품
				itemkind2.innerHTML = '<option value="유류품">유류품</option>';
				break;
			default:
				itemkind2.innerHTML = ''; //초기화
				break;
			}
		}
	</script>
	<script>
	window.onload = function() {
		// 모델에 담긴 데이터로 셀렉트 박스를 선택하고 onchange 이벤트를 발생시킴
		var selectedMainCategory = "${dto.upkind }";
		var selectedSubCategory = "${dto.upr_cd }";
		var selectedAddressCode = "${dto.addressCode }";
		var selectedColorCd = "${dto.colorcd }";
		var prd_mainCategory = document.getElementById("itemkind1");
		var prd_subCategory = document.getElementById("itemkind2");
		var prd_addressCode = document.getElementById("addressCode");
		var prd_colorCd = document.getElementById("colorCd");

		prd_addressCode.value = selectedAddressCode;
		prd_mainCategory.value = selectedMainCategory;
		prd_colorCd.value = selectedColorCd;
		// 서브 카테고리 업데이트 함수 호출
		if (selectedMainCategory !== "" && selectedMainCategory !== null) {
			// 서브 카테고리 업데이트 함수 호출
			getSubCategories(selectedMainCategory);
			// 서브 카테고리 선택
			prd_subCategory.value = selectedSubCategory;
		}
	};
</script>
<script>
		$(document).ready(
				function() {//로드완료시
					var now_utc = Date.now() // 지금 날짜를 밀리초로
					// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
					var timeOff = new Date().getTimezoneOffset() * 60000; // 분단위를 밀리초로 변환
					// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
					var today = new Date(now_utc - timeOff).toISOString()
							.split("T")[0];
					document.getElementById("lostday").setAttribute("max",
							today); //선택날짜 최대값 오늘날짜로 제한
				});
	</script>
</body>

</html>