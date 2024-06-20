<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/admin_header.css" />
<title>Insert title here</title>
  <style>
.main-container {
	display: flex;
	flex-wrap: wrap;
	gap: 4%;
	padding-left: 4%;
	padding-right: 4%;
	width: 1440px;
	margin: 20px auto;
}

.content-list {
	margin: 10px 0;
	max-width: 44%;
	flex-basis: 44%;
	border: 2px solid #ffffff;
	border-radius: 5px;
	box-shadow: 0px 2px 2px 0px rgba(0, 0, 0, 0.14), 0px 2px 6px 0px
		rgba(0, 0, 0, 0.14), 0px 2px 2px 0px rgba(0, 0, 0, 0.14);
	display: flex;
	flex-direction: column;
}

.content-caption {
	border-bottom: 0.0625rem solid #EAECF0;;
	padding: 10px 5px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}
.content{
	margin : auto 0;
}
select {
	padding: 0.2rem 0.5rem;
	border-radius: 10px;
	font-size: 0.8rem;
	font-family: "Noto Sans KR", sans-serif;
	border-width: 0.0625rem;
}
</style>

</head>
<body>
	<div class="main-container">
		<div class="content-list">
			<div class="content-caption">
				<div class="list-title">날짜별 실종동물 등록수</div>
				<div class="list-selection">
					<select name="" id="">
						<option value="">시간</option>
					</select>
				</div>
			</div>
			<div class="content">
				<canvas id="myChart1"> </canvas>
			</div>
		</div>
		<div class="content-list">
			<div class="content-caption">
				<div class="list-title">날짜별 유기/분실동물 등록수</div>
				<div class="list-selection">
					<select name="" id="">
						<option value="">시간</option>
					</select>
				</div>
			</div>
			<div class="content">
				<canvas id="myChart2"> </canvas>
			</div>
		</div>
		<div class="content-list">
			<div class="content-caption">
				<div class="list-title">지역별 분실물 등록수</div>
			</div>
			<div class="content">
			</div>
		</div>
		<div class="content-list">
			<div class="content-caption">
				<div class="list-title">지역별 보호동물 등록수</div>
			</div>
		</div>
	</div>
<script>
	// list1에서 가져온 데이터 (JSON 형식)
	   let list1 = JSON.parse('${list1}'); // json 문자열을 JS객체화

	   // 레이블과 데이터 배열 초기화
	   let labels1 = [];
	   let data1 = [];


	// list1 배열을 순회하며 각 요소의 upkind와 upkind_count를 추출하여 배열에 추가
	   $.each(list1, function(index, item) {
	       // 각 객체에서 upkind와 upkind_count 속성의 값 가져오기
	       let upkind = item.upkind;
	       let upkind_count = item.upkind_count;

	       // 가져온 값들을 레이블과 데이터 배열에 추가
	       labels1.push(upkind); // upkind를 레이블 배열에 추가
	       data1.push(upkind_count); // upkind_count를 데이터 배열에 추가
	   });
  const ctx = document.getElementById('myChart1');
  const ctx2 = document.getElementById('myChart2');

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: labels1,
      datasets: [{
        label: '등록수',
        data: data1,
        borderWidth: 1
      }]
    },
    options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
  });
	const myChart2= new Chart(ctx2,
			{
				type : 'polarArea',
				data : {
					labels : ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
					datasets : [ {
						label : '#청바지매출액',
						data : [12, 19, 3, 5, 2, 3],
						backgroundColor:[
							'rgba(255,99,130,1.0)',
							'rgba(55,99,16,0.2)',
							'rgba(10,99,13,0.2)',
							'rgba(255,99,130,1.0)',
							'#0000ff'
						],
						borderColor:[
							'rgba(255,99,130,1.0)',
							'rgba(55,99,16,0.2)',
							'rgba(10,99,13,0.2)',
							'rgba(255,99,130,1.0)',
							'#0000ff'
						],
						borderWidth : 3
					} ]
				},
				options : {
					scales:{
						y:{
							 beginAtZero:true
						}
					}
				}
			});
</script>
</body>
</html>