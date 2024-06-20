# 프로젝트명 : MIAA (Missing ITEM and ANIMAL Alarm)
<br/>
<p align="center">
  <img src="https://github.com/jeongmin-Lee0321/MIAA/assets/146930254/d4218bb2-2664-45b9-ab5e-673f04e784cc">
</p>
<br/>

## 프로젝트 소개
* MIAA프로젝트는 분실물과 분실동물을 찾을 때 각각 다른 사이트에서 조회해야하는 번거로움을 한사이트에서 한번에 처리할 수 있게하기 위해 기획했습니다.
* 사용자가 분실물, 분실동물 정보를 등록하면 그 게시물을 기준으로 API를 통해 매칭되는 결과를 알람 형태로 알려줍니다. 
* 사용자가 자기가 찾는것이 아닌 알람을 삭제하면 삭제된 결과는 더이상 알람으로 전송하지 않아 좀더 빠르게 찾고자 하는 것을 찾을 수 있게 도와줍니다.
<br/>

## 프로젝트 기간
* 2024.02.16~2024.04.26

| 기간 | 설명 |
| ----- | ----- |
| 2.16 ~ 2.21  | 프로젝트 제안 및 선정, 기획 |
| 2.21 ~ 3.5 | 프로젝트 기능 정의 및 ERD설계 |
| 3.5 ~ 3.11 | UI디자인 및 사용 API분석 |
| 3.11 ~ 3.18 | 홈페이지 화면 구현 |
| 3.18 ~ 4.26 | 개인 별 기능 구현 및 TEST |
| 4.26 | 프로젝트 발표 및 마무리 |
<br/>

## 팀원 및 담당역할
#### 김근영(팀장) 
* 로그인 및 회원가입 기능
* 습득물 찾기 및 수정, 삭제기능
* 실종동물 찾기 및 수정, 삭제기능
* 내정보 등록게시물 관리기능
#### 김영빈(서기)
* 페이지 화면 디자인 프론트
* Tiles 설정
* 관리자 페이지 기능
* DB설계
#### 이정민(팀원)
* 유기동물 API분석
* 유기동물 API 사용 유기동물 찾기 기능
* 회원 비밀번호 및 아이디 찾기 기능
#### 문성원(팀원)
* 페이지 화면 디자인(프론트)
* 회원정보 수정 및 회원탈퇴 기능
* 1:1 문의 게시판 기능
#### 마한슬(팀원)
* 경찰청 API분석
* 매칭 알람 기능
* 스케줄러 생성
<br/>

## 개발 환경
<p align="center">
  <img src="https://github.com/kimgeen/SeoulTransport/assets/146930254/36b0e331-afea-433d-9f84-6d3def286eaf">
</p>
<br/>

## 주요 기능 및 프로세스
<p align="center">
  <img src="https://github.com/jeongmin-Lee0321/MIAA/assets/146930254/f70ac1bc-53a3-4038-b04a-ea7a859b7a39">
</p>
<br/>

## 담당 주요 기능 상세설명
 전체 영상 : https://youtu.be/tvcSdTwA2cM?si=cBgy41U-UUKb2WNl
<br/>

### [분실물 및 실종동물 검색기능]
<p align="center">
  <img src="https://github.com/jeongmin-Lee0321/MIAA/assets/146930254/aea79398-fa47-4dd4-9f35-34c5e5c60254">
</p>

* 사용자가 등록한 게시물을 검색하는 기능으로 각 조건을 선택하면 DB에 저장되어있는 데이터 중 조건에 충족하는 게시물을 출력합니다.
* 검색기능은 회원 및 비회원 모두 사용할 수 있는 기능입니다.
* 품목은 상위 카테고리를 정하면 하위 카테고리 리스트가 자동으로 가져와지게 구현했습니다.

<br/>

### [분실물 및 실종동물 게시물 등록기능]
<p align="center">
  <img src="https://github.com/jeongmin-Lee0321/MIAA/assets/146930254/616bc599-e1e3-4848-8596-58713d53bd02">
</p>

* 자신이 잃어버린 물건 또는 반려동물을 찾기위해 등록하는 게시물입니다. 사용자가 등록하면 그 내용이 DB에 저장됩니다. 등록기능은 회원만 사용 가능 한 기능입니다.
* 등록하면 이 등록된 게시물의 내용을 기준으로 API에서 검색 하여 유사한 내용을 알람으로 매칭시켜줍니다.
* 사용자가 사진을 등록 안하면 카테고리에 맞는 기본 아이콘이 기본 이미지로 대체되게 구현했습니다.

<br/>

### [분실물 및 실종동물 등록게시물 수정,삭제기능]
<p align="center">
  <img src="https://github.com/jeongmin-Lee0321/MIAA/assets/146930254/c9c7fedb-6216-4794-8760-245782c98f61">
</p>

* 내가 등록한 게시물의 수정 및 삭제기능입니다. 회원만 사용 가능하며 등록된 게시물이 있어야 합니다.
* 수정 전에 사진이 등록 안되어있고 수정시에도 사진을 등록 안하면 수정된 카테고리에 맞게 기본 이미지가 대체됩니다.
* 수정 전에 사진이 등록 되어있고 수정시 사진을 등록 안하면 수정 전에 사진이 그대로 유지됩니다.

<br/>

### [내정보 등록게시물 관리기능]
<p align="center">
  <img src="https://github.com/jeongmin-Lee0321/MIAA/assets/146930254/6899078b-89d8-4c55-b843-e8af1d28681c">
</p>

* 내가 등록 한 모든 게시물을 한곳에 모아놓은 페이지 입니다. 동물, 물건 구분없이 등록순으로 정렬됩니다.
* 관리 기능은 수정, 삭제, 일괄삭제 기능이 있습니다.
* 상단 카테고리의 선택으로 전체보기, 동물만 보기, 물건만 보기 선택해서 원하는 정보만 출력 할 수 있습니다.

<br/>

## 프로젝트 진행 소감
팀장으로 처음 프로젝트를 이끌어가면서 불안한 점도 많았고 힘든점도 많았습니다. 
