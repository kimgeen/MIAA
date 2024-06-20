<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/css/main_contents.css"/>
    <script src="<c:url value="/resources/js/jquery-3.7.1.min.js"/>" type="text/javascript"></script>
    <script type="text/javascript">
        function getSigungu(val) {
            var optionTag = document.getElementById("sigunguSelectBox");
            optionTag.innerHTML = '<option value="">-전체-</option>';
            switch (val) {
                case "6110000" : {
                    optionTag.innerHTML += '<option value="6119999">가정보호</option>' +
                        '<option value="3220000">강남구</option>' +
                        '<option value="3240000">강동구</option>' +
                        '<option value="3080000">강북구</option>' +
                        '<option value="3150000">강서구</option>' +
                        '<option value="3200000">관악구</option>' +
                        '<option value="3040000">광진구</option>' +
                        '<option value="3160000">구로구</option>' +
                        '<option value="3170000">금천구</option>' +
                        '<option value="3100000">노원구</option>' +
                        '<option value="3090000">도봉구</option>' +
                        '<option value="3050000">동대문구</option>' +
                        '<option value="3190000">동작구</option>' +
                        '<option value="3130000">마포구</option>' +
                        '<option value="3120000">서대문구</option>' +
                        '<option value="6119998">서울특별시</option>' +
                        '<option value="3210000">서초구</option>' +
                        '<option value="3030000">성동구</option>' +
                        '<option value="3070000">성북구</option>' +
                        '<option value="3230000">송파구</option>' +
                        '<option value="3140000">양천구</option>' +
                        '<option value="3180000">영등포구</option>' +
                        '<option value="3020000">용산구</option>' +
                        '<option value="3110000">은평구</option>' +
                        '<option value="3000000">종로구</option>' +
                        '<option value="3010000">중구</option>' +
                        '<option value="3060000">중랑구</option>';
                    break;

                }
                case "6260000" : {
                    optionTag.innerHTML += '<option value="3360000">강서구</option>' +
                        '<option value="3350000">금정구</option>' +
                        '<option value="3400000">기장군</option>' +
                        '<option value="3310000">남구</option>' +
                        '<option value="3270000">동구</option>' +
                        '<option value="3300000">동래구</option>' +
                        '<option value="3290000">부산진구</option>' +
                        '<option value="3320000">북구</option>' +
                        '<option value="3390000">사상구</option>' +
                        '<option value="3340000">사하구</option>' +
                        '<option value="3260000">서구</option>' +
                        '<option value="3380000">수영구</option>' +
                        '<option value="3370000">연제구</option>' +
                        '<option value="3280000">영도구</option>' +
                        '<option value="3250000">중구</option>' +
                        '<option value="3330000">해운대구</option>';
                    break;

                }

                case "6270000" : {
                    optionTag.innerHTML += '<option value="5141000">군위군</option>' +
                        '<option value="3440000">남구</option>' +
                        '<option value="3470000">달서구</option>' +
                        '<option value="3480000">달성군</option>' +
                        '<option value="3420000">동구</option>' +
                        '<option value="3450000">북구</option>' +
                        '<option value="3430000">서구</option>' +
                        '<option value="3460000">수성구</option>' +
                        '<option value="3410000">중구</option>';
                    break;

                }

                case "6280000" : {
                    optionTag.innerHTML += '<option value="3570000">강화군</option>' +
                        '<option value="3550000">계양구</option>' +
                        '<option value="3530000">남동구</option>' +
                        '<option value="3500000">동구</option>' +
                        '<option value="3510500">미추홀구</option>' +
                        '<option value="3540000">부평구</option>' +
                        '<option value="3560000">서구</option>' +
                        '<option value="3520000">연수구</option>' +
                        '<option value="3580000">옹진군</option>' +
                        '<option value="3490000">중구</option>';
                    break;

                }

                case "6290000" : {
                    optionTag.innerHTML = '<option value="6299998">광산구</option>' +
                        '<option value="6299998">광주광역시</option>' +
                        '<option value="3610000">남구</option>' +
                        '<option value="3590000">동구</option>' +
                        '<option value="3620000">북구</option>' +
                        '<option value="3600000">서구</option>';
                    break;

                }

                case "5690000" : {
                    break;

                }

                case "6300000" : {
                    optionTag.innerHTML += '<option value="3680000">대덕구</option>' +
                        '<option value="3640000">동구</option>' +
                        '<option value="3660000">서구</option>' +
                        '<option value="3670000">유성구</option>' +
                        '<option value="3650000">중구</option>';
                }

                case "6310000" : {
                    optionTag.innerHTML += '<option value="3700000">남구</option>' +
                        '<option value="3710000">동구</option>' +
                        '<option value="3720000">북구</option>' +
                        '<option value="3730000">울주군</option>' +
                        '<option value="3690000">중구</option>';
                    break;

                }

                case "6410000" : {
                    optionTag.innerHTML += '<option value="4160000">가평군</option>' +
                        '<option value="3940000">고양시</option>' +
                        '<option value="3970000">과천시</option>' +
                        '<option value="3900000">광명시</option>' +
                        '<option value="5540000">광주시</option>' +
                        '<option value="3980000">구리시</option>' +
                        '<option value="4020000">군포시</option>' +
                        '<option value="5630000">기흥구</option>' +
                        '<option value="4090000">김포시</option>' +
                        '<option value="3990000">남양주시</option>' +
                        '<option value="3920000">동두천시</option>' +
                        '<option value="3860000">부천시</option>' +
                        '<option value="3780000">성남시</option>' +
                        '<option value="3740000">수원시</option>' +
                        '<option value="4010000">시흥시</option>' +
                        '<option value="3930000">안산시</option>' +
                        '<option value="4080000">안성시</option>' +
                        '<option value="3830000">안양시</option>' +
                        '<option value="5590000">양주시</option>' +
                        '<option value="4170000">양평군</option>' +
                        '<option value="5700000">여주시</option>' +
                        '<option value="4140000">연천군</option>' +
                        '<option value="4000000">오산시</option>' +
                        '<option value="4050000">용인시</option>' +
                        '<option value="4030000">의왕시</option>' +
                        '<option value="3820000">의정부시</option>' +
                        '<option value="4070000">이천시</option>' +
                        '<option value="4060000">파주시</option>' +
                        '<option value="3910000">평택시</option>' +
                        '<option value="5600000">포천시</option>' +
                        '<option value="4040000">하남시</option>' +
                        '<option value="5530000">화성시</option>';
                    break;

                }

                case "6530000" : {
                    optionTag.innerHTML += '<option value="4201000">강릉시</option>' +
                        '<option value="4341000">고성군</option>' +
                        '<option value="4211000">동해시</option>' +
                        '<option value="4241000">삼척시</option>' +
                        '<option value="4231000">속초시</option>' +
                        '<option value="4321000">양구군</option>' +
                        '<option value="4351000">양양군</option>' +
                        '<option value="4271000">영월군</option>' +
                        '<option value="4191000">원주시</option>' +
                        '<option value="4331000">인제군</option>' +
                        '<option value="4291000">정선군</option>' +
                        '<option value="4301000">철원군</option>' +
                        '<option value="4181000">춘천시</option>' +
                        '<option value="4221000">태백시</option>' +
                        '<option value="4281000">평창군</option>' +
                        '<option value="4251000">홍천군</option>' +
                        '<option value="4311000">화천군</option>' +
                        '<option value="4261000">횡성군</option>';
                    break;

                }

                case "6430000" : {
                    optionTag.innerHTML += '<option value="4460000">괴산군</option>' +
                        '<option value="4480000">단양군</option>' +
                        '<option value="4420000">보은군</option>' +
                        '<option value="4440000">영동군</option>' +
                        '<option value="4430000">옥천군</option>' +
                        '<option value="4470000">음성군</option>' +
                        '<option value="4400000">제천시</option>' +
                        '<option value="5570000">증평군</option>' +
                        '<option value="4450000">진천군</option>' +
                        '<option value="5710000">청주시</option>' +
                        '<option value="4390000">충주시</option>';
                    break;

                }

                case "6440000" : {
                    optionTag.innerHTML += '<option value="5580000">계룡시</option>' +
                        '<option value="4500000">공주시</option>' +
                        '<option value="4550000">금산군</option>' +
                        '<option value="4540000">논산시</option>' +
                        '<option value="5680000">당진시</option>' +
                        '<option value="4510000">보령시</option>' +
                        '<option value="4570000">부여군</option>' +
                        '<option value="4530000">서산시</option>' +
                        '<option value="4580000">서천군</option>' +
                        '<option value="4520000">아산시</option>' +
                        '<option value="4560000">연기군</option>' +
                        '<option value="4610000">예산군</option>' +
                        '<option value="4490000">천안시</option>' +
                        '<option value="4590000">청양군</option>' +
                        '<option value="4620000">태안군</option>' +
                        '<option value="4600000">홍성군</option>';
                    break;

                }

                case "6540000" : {
                    optionTag.innerHTML += '<option value="4781000">고창군</option>' +
                        '<option value="4671000">군산시</option>' +
                        '<option value="4711000">김제시</option>' +
                        '<option value="4701000">남원시</option>' +
                        '<option value="4741000">무주군</option>' +
                        '<option value="4791000">부안군</option>' +
                        '<option value="4771000">순창군</option>' +
                        '<option value="4721000">완주군</option>' +
                        '<option value="4681000">익산시</option>' +
                        '<option value="4761000">임실군</option>' +
                        '<option value="4751000">장수군</option>' +
                        '<option value="4641000">전주시</option>' +
                        '<option value="4691000">정읍시</option>' +
                        '<option value="4731000">진안군</option>';
                    break;

                }

                case "6460000" : {
                    optionTag.innerHTML += '<option value="4920000">강진군</option>' +
                        '<option value="4880000">고흥군</option>' +
                        '<option value="4860000">곡성군</option>' +
                        '<option value="4840000">광양시</option>' +
                        '<option value="4870000">구례군</option>' +
                        '<option value="4830000">나주시</option>' +
                        '<option value="4850000">담양군</option>' +
                        '<option value="4800000">목포시</option>' +
                        '<option value="4950000">무안군</option>' +
                        '<option value="4890000">보성군</option>' +
                        '<option value="4820000">순천시</option>' +
                        '<option value="5010000">신안군</option>' +
                        '<option value="4810000">여수시</option>' +
                        '<option value="4970000">영광군</option>' +
                        '<option value="4940000">영암군</option>' +
                        '<option value="4990000">완도군</option>' +
                        '<option value="4980000">장성군</option>' +
                        '<option value="4910000">장흥군</option>' +
                        '<option value="5000000">진도군</option>' +
                        '<option value="4960000">함평군</option>' +
                        '<option value="4930000">해남군</option>' +
                        '<option value="4900000">화순군</option>';
                    break;

                }

                case "6470000" : {
                    optionTag.innerHTML += '<option value="5130000">경산시</option>' +
                        '<option value="6479998">경상북도</option>' +
                        '<option value="5050000">경주시</option>' +
                        '<option value="5200000">고령군</option>' +
                        '<option value="5080000">구미시</option>' +
                        '<option value="5060000">김천시</option>' +
                        '<option value="5120000">문경시</option>' +
                        '<option value="5240000">봉화군</option>' +
                        '<option value="5110000">상주시</option>' +
                        '<option value="5210000">성주군</option>' +
                        '<option value="5070000">안동시</option>' +
                        '<option value="5180000">영덕군</option>' +
                        '<option value="5170000">영양군</option>' +
                        '<option value="5090000">영주시</option>' +
                        '<option value="5100000">영천시</option>' +
                        '<option value="5230000">예천군</option>' +
                        '<option value="5260000">울릉군</option>' +
                        '<option value="5250000">울진군</option>' +
                        '<option value="5150000">의성군</option>' +
                        '<option value="5190000">청도군</option>' +
                        '<option value="5160000">청송군</option>' +
                        '<option value="5220000">칠곡군</option>' +
                        '<option value="5020000">포항시</option>';
                    break;

                }

                case "6480000" : {
                    optionTag.innerHTML += '<option value="5370000">거제시</option>' +
                        '<option value="5470000">거창군</option>' +
                        '<option value="5420000">고성군</option>' +
                        '<option value="5350000">김해시</option>' +
                        '<option value="5430000">남해군</option>' +
                        '<option value="5360000">밀양시</option>' +
                        '<option value="5340000">사천시</option>' +
                        '<option value="5450000">산청군</option>' +
                        '<option value="5380000">양산시</option>' +
                        '<option value="5390000">의령군</option>' +
                        '<option value="5310000">진주시</option>' +
                        '<option value="5410000">창녕군</option>' +
                        '<option value="5320000">창원시</option>' +
                        '<option value="5280000">창원시</option>' +
                        '<option value="5670000">창원시</option>' +
                        '<option value="5330000">통영시</option>' +
                        '<option value="5440000">하동군</option>' +
                        '<option value="5400000">함안군</option>' +
                        '<option value="5460000">함양군</option>' +
                        '<option value="5480000">합천군</option>' +
                        '<option value="6489999"></option>';
                    break;

                }

                case "6500000" : {
                    optionTag.innerHTML += '<option value="6520000">서귀포시</option>' +
                        '<option value="6510000">제주시</option>' +
                        '<option value="6500000">제주특별자치도</option>';
                    break;
                }
            }

        }

        function getKind(val) {
            var optionTag = document.getElementById("kindSelectedBox");
            optionTag.innerHTML = '<option value="">-전체-</option>';
            switch (val) {
                case "417000" : {
                    optionTag.innerHTML += '<option value="000054">골든 리트리버</option>' +
                        '<option value="000056">그레이 하운드</option>' +
                        '<option value="000055">그레이트 덴</option>' +
                        '<option value="000118">그레이트 피레니즈</option>' +
                        '<option value="000115">기타</option>' +
                        '<option value="000037">꼬똥 드 뚤레아</option>' +
                        '<option value="000081">네오폴리탄 마스티프</option>' +
                        '<option value="000204">노르포크 테리어</option>' +
                        '<option value="000083">노리치 테리어</option>' +
                        '<option value="00216">노퍽 테리어</option>' +
                        '<option value="000082">뉴펀들랜드</option>' +
                        '<option value="000038">닥스훈트</option>' +
                        '<option value="000039">달마시안</option>' +
                        '<option value="000040">댄디 딘몬트 테리어</option>' +
                        '<option value="000043">도고 까니리오</option>' +
                        '<option value="000042">도고 아르젠티노</option>' +
                        '<option value="000153">도고 아르젠티노</option>' +
                        '<option value="000041">도베르만</option>' +
                        '<option value="000120">도사</option>' +
                        '<option value="000219">도사 믹스견</option>' +
                        '<option value="000155">동경견</option>' +
                        '<option value="000069">라브라도 리트리버</option>' +
                        '<option value="000071">라사 압소</option>' +
                        '<option value="000142">라이카</option>' +
                        '<option value="000093">래빗 닥스훈드</option>' +
                        '<option value="000167">랫 테리어</option>' +
                        '<option value="000070">레이크랜드 테리어</option>' +
                        '<option value="000166">로디지안 리즈백</option>' +
                        '<option value="000094">로트와일러</option>' +
                        '<option value="000121">로트와일러</option>' +
                        '<option value="000223">로트와일러 믹스견</option>' +
                        '<option value="000152">마리노이즈</option>' +
                        '<option value="000073">마스티프</option>' +
                        '<option value="000146">말라뮤트</option>' +
                        '<option value="000072">말티즈</option>' +
                        '<option value="000159">맨체스터테리어</option>' +
                        '<option value="000076">미니어쳐 닥스훈트</option>' +
                        '<option value="000075">미니어쳐 불 테리어</option>' +
                        '<option value="000079">미니어쳐 슈나우저</option>' +
                        '<option value="000078">미니어쳐 푸들</option>' +
                        '<option value="000077">미니어쳐 핀셔</option>' +
                        '<option value="000074">미디엄 푸들</option>' +
                        '<option value="000080">미텔 스피츠</option>' +
                        '<option value="000114">믹스견</option>' +
                        '<option value="000133">바센지</option>' +
                        '<option value="000012">바셋 하운드</option>' +
                        '<option value="000017">버니즈 마운틴 독</option>' +
                        '<option value="000015">베들링턴 테리어</option>' +
                        '<option value="000164">벨기에 그로넨달</option>' +
                        '<option value="000157">벨기에 쉽독</option>' +
                        '<option value="000148">벨기에 테뷰런</option>' +
                        '<option value="000016">벨지안 셰퍼드 독</option>' +
                        '<option value="000020">보더 콜리</option>' +
                        '<option value="000021">보르조이</option>' +
                        '<option value="000022">보스턴 테리어</option>' +
                        '<option value="000024">복서</option>' +
                        '<option value="000208">볼로네즈</option>' +
                        '<option value="000023">부비에 데 플랑드르</option>' +
                        '<option value="000026">불 테리어</option>' +
                        '<option value="000027">불독</option>' +
                        '<option value="000169">브뤼셀그리펀</option>' +
                        '<option value="000025">브리타니 스파니엘</option>' +
                        '<option value="000019">블랙 테리어</option>' +
                        '<option value="000013">비글</option>' +
                        '<option value="000018">비숑 프리제</option>' +
                        '<option value="000014">비어디드 콜리</option>' +
                        '<option value="000162">비즐라</option>' +
                        '<option value="000085">빠삐용</option>' +
                        '<option value="000096">사모예드</option>' +
                        '<option value="000095">살루키</option>' +
                        '<option value="000001">삽살개</option>' +
                        '<option value="000034">샤페이</option>' +
                        '<option value="000104">세인트 버나드</option>' +
                        '<option value="000031">센트럴 아시안 오브차카</option>' +
                        '<option value="000099">셔틀랜드 쉽독</option>' +
                        '<option value="000122">셰퍼드</option>' +
                        '<option value="000123">슈나우져</option>' +
                        '<option value="000097">스코티쉬 테리어</option>' +
                        '<option value="000132">스코티시 디어하운드</option>' +
                        '<option value="000154">스태퍼드셔 불 테리어</option>' +
                        '<option value="000222">스태퍼드셔 불 테리어 믹스견</option>' +
                        '<option value="000105">스탠다드 푸들</option>' +
                        '<option value="000124">스피츠</option>' +
                        '<option value="000100">시바</option>' +
                        '<option value="000103">시베리안 허스키</option>' +
                        '<option value="000151">시베리안라이카</option>' +
                        '<option value="000139">시잉프랑세즈</option>' +
                        '<option value="000101">시츄</option>' +
                        '<option value="000102">시코쿠</option>' +
                        '<option value="000098">실리햄 테리어</option>' +
                        '<option value="000136">실키테리어</option>' +
                        '<option value="000202">아나톨리안 셰퍼드</option>' +
                        '<option value="000160">아메리칸 불독</option>' +
                        '<option value="000203">아메리칸 스태퍼드셔 테리어</option>' +
                        '<option value="000221">아메리칸 스태퍼드셔 테리어 믹스견</option>' +
                        '<option value="000008">아메리칸 아키다</option>' +
                        '<option value="000131">아메리칸 에스키모</option>' +
                        '<option value="000009">아메리칸 코카 스파니엘</option>' +
                        '<option value="000119">아메리칸 핏불 테리어</option>' +
                        '<option value="000220">아메리칸 핏불 테리어 믹스견</option>' +
                        '<option value="000150">아메리칸불리</option>' +
                        '<option value="000210">아이리쉬 레드 앤 화이트 세터</option>' +
                        '<option value="000057">아이리쉬 세터</option>' +
                        '<option value="000058">아이리쉬 울프 하운드</option>' +
                        '<option value="000059">아이리쉬소프트코튼휘튼테리어</option>' +
                        '<option value="000006">아키다</option>' +
                        '<option value="000004">아프간 하운드</option>' +
                        '<option value="000007">알라스칸 말라뮤트</option>' +
                        '<option value="000005">에어델 테리어</option>' +
                        '<option value="000143">오브차카</option>' +
                        '<option value="000011">오스트랄리안 셰퍼드 독</option>' +
                        '<option value="000010">오스트랄리안 캐틀 독</option>' +
                        '<option value="000217">오스트레일리안 켈피</option>' +
                        '<option value="000137">올드 잉글리쉬 불독</option>' +
                        '<option value="000084">올드 잉글리쉬 쉽독</option>' +
                        '<option value="000163">와이마라너</option>' +
                        '<option value="000112">와이어 폭스 테리어</option>' +
                        '<option value="000113">요크셔 테리어</option>' +
                        '<option value="000149">울프독</option>' +
                        '<option value="211">웨스트 시베리언 라이카</option>' +
                        '<option value="000110">웨스트하이랜드화이트테리어</option>' +
                        '<option value="000205">웰시 코기 카디건</option>' +
                        '<option value="000108">웰시 코기 펨브로크</option>' +
                        '<option value="000109">웰시 테리어</option>' +
                        '<option value="000060">이탈리안 그레이 하운드</option>' +
                        '<option value="000046">잉글리쉬 세터</option>' +
                        '<option value="000047">잉글리쉬 스프링거 스파니엘</option>' +
                        '<option value="000044">잉글리쉬 코카 스파니엘</option>' +
                        '<option value="000045">잉글리쉬 포인터</option>' +
                        '<option value="000053">자이언트 슈나우져</option>' +
                        '<option value="000062">재패니즈 스피츠</option>' +
                        '<option value="000061">잭 러셀 테리어</option>' +
                        '<option value="000052">저먼 셰퍼드 독</option>' +
                        '<option value="000165">저먼 와이어헤어드 포인터</option>' +
                        '<option value="000051">저먼 포인터</option>' +
                        '<option value="215">저먼 헌팅 테리어</option>' +
                        '<option value="000156">제주개</option>' +
                        '<option value="000129">제페니즈칭</option>' +
                        '<option value="000067">진도견</option>' +
                        '<option value="000035">차우차우</option>' +
                        '<option value="000033">차이니즈 크레스티드 독</option>' +
                        '<option value="000032">치와와</option>' +
                        '<option value="000028">카네 코르소</option>' +
                        '<option value="000158">카레리안 베어독</option>' +
                        '<option value="000144">카이훗</option>' +
                        '<option value="000030">캐벌리어 킹 찰스 스파니엘</option>' +
                        '<option value="000029">케니스펜더</option>' +
                        '<option value="000064">케리 블루 테리어</option>' +
                        '<option value="000207">케언 테리어</option>' +
                        '<option value="000002">코리아 트라이 하운드</option>' +
                        '<option value="000068">코리안 마스티프</option>' +
                        '<option value="000125">코카 스파니엘</option>' +
                        '<option value="000141">코카 푸</option>' +
                        '<option value="000145">코카시안오브차카</option>' +
                        '<option value="000036">콜리</option>' +
                        '<option value="000066">클라인스피츠</option>' +
                        '<option value="000065">키슈</option>' +
                        '<option value="000063">키스 훈드</option>' +
                        '<option value="000140">토이 맨체스터 테리어</option>' +
                        '<option value="000107">토이 푸들</option>' +
                        '<option value="000106">티베탄 마스티프</option>' +
                        '<option value="000209">파라오 하운드</option>' +
                        '<option value="000086">파슨 러셀 테리어</option>' +
                        '<option value="000088">팔렌</option>' +
                        '<option value="000090">퍼그</option>' +
                        '<option value="000087">페키니즈</option>' +
                        '<option value="000138">페터데일테리어</option>' +
                        '<option value="000089">포메라니안</option>' +
                        '<option value="000126">포인터</option>' +
                        '<option value="000127">폭스테리어</option>' +
                        '<option value="000128">푸들</option>' +
                        '<option value="000091">풀리</option>' +
                        '<option value="000003">풍산견</option>' +
                        '<option value="000161">프레사까나리오</option>' +
                        '<option value="000050">프렌치 불독</option>' +
                        '<option value="000168">프렌치 브리타니</option>' +
                        '<option value="000049">플랫 코티드 리트리버</option>' +
                        '<option value="000147">플롯하운드</option>' +
                        '<option value="000092">피레니안 마운틴 독</option>' +
                        '<option value="000048">필라 브라질레이로</option>' +
                        '<option value="000135">핏불테리어</option>' +
                        '<option value="000224">핏불테리어 믹스견</option>' +
                        '<option value="000206">허배너스</option>' +
                        '<option value="000130">화이트리트리버</option>' +
                        '<option value="000134">화이트테리어</option>' +
                        '<option value="000111">휘펫</option>';
                    break;
                }
                case "422400" : {
                    optionTag.innerHTML += '<option value="000116">고양이</option>' +
                        '<option value="000201">기타</option>' +
                        '<option value="000170">노르웨이 숲</option>' +
                        '<option value="000218">니벨룽</option>' +
                        '<option value="000171">데본 렉스</option>' +
                        '<option value="000172">러시안 블루</option>' +
                        '<option value="00213">레그돌</option>' +
                        '<option value="000173">레그돌-라가머핀</option>' +
                        '<option value="000174">맹크스</option>' +
                        '<option value="000175">먼치킨</option>' +
                        '<option value="000176">메인쿤</option>' +
                        '<option value="000212">믹스묘</option>' +
                        '<option value="000177">발리네즈</option>' +
                        '<option value="000178">버만</option>' +
                        '<option value="000179">벵갈</option>' +
                        '<option value="000180">봄베이</option>' +
                        '<option value="000216">브리티쉬롱헤어</option>' +
                        '<option value="000181">브리티시 쇼트헤어</option>' +
                        '<option value="000182">사바나캣</option>' +
                        '<option value="000183">샤트룩스</option>' +
                        '<option value="000184">샴</option>' +
                        '<option value="000185">셀커크 렉스</option>' +
                        '<option value="000186">소말리</option>' +
                        '<option value="000187">스노우 슈</option>' +
                        '<option value="000188">스코티시폴드</option>' +
                        '<option value="000189">스핑크스</option>' +
                        '<option value="000190">시베리안 포레스트</option>' +
                        '<option value="000191">싱가퓨라</option>' +
                        '<option value="000192">아메리칸 쇼트헤어</option>' +
                        '<option value="000193">아비시니안</option>' +
                        '<option value="000194">재패니즈밥테일</option>' +
                        '<option value="000195">터키시 앙고라</option>' +
                        '<option value="000196">통키니즈</option>' +
                        '<option value="00214">페르시안</option>' +
                        '<option value="000197">페르시안 친칠라</option>' +
                        '<option value="000198">하바나 브라운</option>' +
                        '<option value="000199">하일랜드 폴드</option>' +
                        '<option value="000200">한국 고양이</option>';
                    break;
                }
                case "429900" : {
                    optionTag.innerHTML += '<option value="000117">기타축종</option>';
                    break;
                }
            }
        }

        window.onload = function () {
            var selectedSido = "${dto.sidoSelectBox}";
            var selectedSigungu = "${dto.sigunguSelectBox}";
            var selectedUpKind = "${dto.upKindSelectBox}"
            var selectedKind = "${dto.kindSelectedBox}"
            var sidoSelectBox = document.getElementById("sidoSelectBox");
            var sigunguSelectBox = document.getElementById("sigunguSelectBox");
            var upKindSelectBox = document.getElementById("upKindSelectBox");
            var kindSelectedBox = document.getElementById("kindSelectedBox");

            getSigungu(selectedSido);
            getKind(selectedUpKind);

            sigunguSelectBox.value = selectedSigungu;
            kindSelectedBox.value = selectedKind;
        }
    </script>

    <title>Insert title here</title>
</head>
<body>
<div class="main-contents">
    <!-- 검색창과 검색결과 -->
    <form action="rescue_ani_search_page" method="post">
        <div class="searchbar-container">
            <!-- 서치바 셀렉 그룹시작 -->
            <div class="searchbar-select-group">
                <div class="searchbar-title">
                    <span>기간</span>
                </div>
                <div class="searchbar-content">
                    <input type="date" name="search_str_date" value="${dto.getSearch_str_date()}"> <span>~</span> <input
                        type="date" name="search_end_date" value="${dto.getSearch_end_date()}"> <span>(접수일기준)</span>
                </div>
            </div>

            <!-- 멀티그룹묶음 -->
            <div class="searchbar-mutil-group">
                <div class="searchbar-select-group">
                    <div class="searchbar-title">
                        <span>시도</span>
                    </div>
                    <div class="searchbar-content">
                        <select name="sidoSelectBox" id="sidoSelectBox" onchange="getSigungu(this.value)">
                            <%--                                                            onchange="selectedSido(this.value,${dto.sigunguSelectBox});"--%>
                            <option value="" <c:if test="${dto.sidoSelectBox == ''}">selected="selected"</c:if>>-전체-
                            </option>
                            <option value="6110000"
                                    <c:if test="${dto.sidoSelectBox == '6110000'}">selected="selected"</c:if> >서울특별시
                            </option>
                            <option value="6260000"
                                    <c:if test="${dto.sidoSelectBox == '6260000'}">selected="selected"</c:if>>부산광역시
                            </option>
                            <option value="6270000"
                                    <c:if test="${dto.sidoSelectBox == '6270000'}">selected="selected"</c:if>>대구광역시
                            </option>
                            <option value="6280000"
                                    <c:if test="${dto.sidoSelectBox == '6280000'}">selected="selected"</c:if>>인천광역시
                            </option>
                            <option value="6290000"
                                    <c:if test="${dto.sidoSelectBox == '6290000'}">selected="selected"</c:if>>광주광역시
                            </option>
                            <option value="5690000"
                                    <c:if test="${dto.sidoSelectBox == '5690000'}">selected="selected"</c:if>>세종특별자치시
                            </option>
                            <option value="6300000"
                                    <c:if test="${dto.sidoSelectBox == '6300000'}">selected="selected"</c:if>>대전광역시
                            </option>
                            <option value="6310000"
                                    <c:if test="${dto.sidoSelectBox == '6310000'}">selected="selected"</c:if>>울산광역시
                            </option>
                            <option value="6410000"
                                    <c:if test="${dto.sidoSelectBox == '6410000'}">selected="selected"</c:if>>경기도
                            </option>
                            <option value="6530000"
                                    <c:if test="${dto.sidoSelectBox == '6530000'}">selected="selected"</c:if>>강원특별자치도
                            </option>
                            <option value="6430000"
                                    <c:if test="${dto.sidoSelectBox == '6430000'}">selected="selected"</c:if>>충청북도
                            </option>
                            <option value="6440000"
                                    <c:if test="${dto.sidoSelectBox == '6440000'}">selected="selected"</c:if>>충청남도
                            </option>
                            <option value="6540000"
                                    <c:if test="${dto.sidoSelectBox == '6540000'}">selected="selected"</c:if>>전북특별자치도
                            </option>
                            <option value="6460000"
                                    <c:if test="${dto.sidoSelectBox == '6460000'}">selected="selected"</c:if>>전라남도
                            </option>
                            <option value="6470000"
                                    <c:if test="${dto.sidoSelectBox == '6470000'}">selected="selected"</c:if>>경상북도
                            </option>
                            <option value="6480000"
                                    <c:if test="${dto.sidoSelectBox == '6480000'}">selected="selected"</c:if>>경상남도
                            </option>
                            <option value="6500000"
                                    <c:if test="${dto.sidoSelectBox == '6500000'}">selected="selected"</c:if>>제주특별자치도
                            </option>
                        </select>
                    </div>
                </div>
                <div class="searchbar-select-group">
                    <div class="searchbar-title">
                        <span>시군구</span>
                    </div>
                    <div class="searchbar-content">
                        <select name="sigunguSelectBox" id="sigunguSelectBox">
                        </select>
                    </div>
                </div>
                <%--                <div class="searchbar-select-group">--%>
                <%--                    <div class="searchbar-title">--%>
                <%--                        <span>보호센터</span>--%>
                <%--                    </div>--%>
                <%--                    <div class="searchbar-content">--%>
                <%--                        <select name="shelterSelectBox" id="shelterSelectBox">--%>
                <%--                            <option value="">-전체-</option>--%>
                <%--                        </select>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>

            <div class="searchbar-mutil-group">
                <div class="searchbar-select-group">
                    <div class="searchbar-title">
                        <span>축종 및 품종</span>
                    </div>
                    <div class="searchbar-content">
                        <select name="upKindSelectBox" onchange="getKind(this.value)">
                            <option value="" <c:if test="${dto.upKindSelectBox == ''}">selected="selected"</c:if>>-전체-
                            </option>
                            <option value="417000"
                                    <c:if test="${dto.upKindSelectBox == '417000'}">selected="selected"</c:if>>개
                            </option>
                            <option value="422400"
                                    <c:if test="${dto.upKindSelectBox == '422400'}">selected="selected"</c:if>>고양이
                            </option>
                            <option value="429900"
                                    <c:if test="${dto.upKindSelectBox == '429900'}">selected="selected"</c:if>>기타
                            </option>
                        </select>
                        <span>-</span>
                        <select name="kindSelectedBox" id="kindSelectedBox">

                        </select>
                    </div>
                </div>
<%--                <div class="searchbar-select-group">--%>
<%--                    <div class="searchbar-title">--%>
<%--                        <span>성별</span>--%>
<%--                    </div>--%>
<%--                    <div class="searchbar-content">--%>
<%--                        <select name="sexSelectedBox" id="sexSelectedBox">--%>
<%--                            <c:forEach items="${sexEnum }" var="sex">--%>
<%--                                <option value="${sex.getCodeValue()}"--%>
<%--                                        <c:if test="${sex.getCodeValue() == dto.sexSelectedBox}">selected="selected"</c:if>>--%>
<%--                                        ${sex.getValue()}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>

            <!-- form 조회용 버튼 -->
            <div class="search-btn-block">
                <button type="submit" id="btn_search" style="font-family: inherit;">
                    조회<img src="resources/img/searchIcon.png" alt="">
                </button>
            </div>
        </div>
        <!-- 검색창과 검색결과 끝 -->

        <!-- result-container시작 -->

        <div class="result-container">
            <!-- 결과 리스트 총 갯수 프레임 -->
            <div class="total-resultNum-wrapper">
                <div class="total-resultNum-container">
                    <span>전체 </span><span class="totalNum">${pageVO.totRow }</span><span>건</span>
                </div>
            </div>

            <!-- 검색 결과 리스트프레임 -->
            <div class="result-list">

                <!-- 목록1개가 list-card -->
                <c:forEach items="${itemList }" var="item">
                    <div class="list-card"
                         onclick="location.href='rescue_ani_detail_page?noticeNo=${item.getNoticeNo() }'"
                         style="cursor: pointer">
                        <div class="card-photo">
                            <img src="${item.getFilename() }" alt="">
                        </div>
                        <div class="content-items">
                            <div class="item-title">
                                <span>${item.getKindCd() }</span>
                            </div>
                            <ul class="item-details">
                                <li><span class="detail-title">구조날짜:</span><span>${item.getHappenDt() }</span></li>
                                <li><span class="detail-title">공고번호:</span><span>${item.getNoticeNo() }</span></li>
                                <li><span class="detail-title">성별:</span><span>${item.getSexCd() }</span></li>
                                <li><span class="detail-title">발견장소:</span><span>${item.getHappenPlace() }</span></li>
                            </ul>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <!-- 검색결과 리스트 프레임 끝 -->
            <!-- 페이징 프레임시작 -->
            <div class="page-container">
                <%--                <div class="currentOftotal">--%>
                <%--                    <span>Page</span><span class="current-page">${pageVO.page}</span><span>of</span><span--%>
                <%--                        class="total-page">${pageVO.totPage}</span>--%>
                <%--                </div>--%>
                <%--                <ul class="pagelist-container">--%>
                <%--                    <li class="btn-prev"><a class="test" href="rescue_ani_search_page?page=${pageVO.page - 1}"><img--%>
                <%--                            src="resources/img/chevron-left.png" alt=""></a></li>--%>
                <%--                    <c:forEach begin="${pageVO.pageStart}" end="${pageVO.pageEnd}" var="i">--%>
                <%--                        <c:choose>--%>
                <%--                            <c:when test="${i eq pageVO.page}">--%>
                <%--&lt;%&ndash;                                <li><a href="#" style="color: red">${i}</a></li>&ndash;%&gt;--%>
                <%--                                <li><button type="submit" name="pageNo" value="${i}" style="color: red">${i}</button></li>--%>
                <%--                            </c:when>--%>
                <%--                            <c:otherwise>--%>
                <%--                                &lt;%&ndash; <li><a href="rescue_ani_search_page?page=${i}">${i}</a></li>&ndash;%&gt;--%>
                <%--                                <li>--%>
                <%--                                    <button type="submit" name="pageNo" value="${i}">${i}</button>--%>
                <%--                                </li>--%>
                <%--                            </c:otherwise>--%>
                <%--                        </c:choose>--%>
                <%--                    </c:forEach>--%>

                <div class="currentOftotal">
                    <span>Page</span><span class="current-page">${pageVO.page}</span><span>of</span><span
                        class="total-page">${pageVO.totPage}</span>
                </div>
                <ul class="pagelist-container">
                    <li class="btn-prev"><a class="test" href="rescue_ani_search_page?page=${pageVO.page - 1}"><img
                            src="resources/img/chevron-left.png" alt=""></a></li>
                    <%--                    <button class="btn-prev" type="submit" name="pageVO.page" value="${pageVO.page-1}"><img--%>
                    <%--                            src="resources/img/chevron-left.png" alt=""></button>--%>
                    <c:forEach begin="${pageVO.pageStart}" end="${pageVO.pageEnd}" var="i">
                        <c:choose>
                            <c:when test="${i eq pageVO.page}">
                                <%--                                <li>${i}</li>--%>
                                <li><a href="#" style="color: #0066ff">${i}</a></li>
                                <%--                                <li>--%>
                                <%--                                    <button type="submit" name="pageVO.page" value="${pageVO.page = i}"--%>
                                <%--                                            style="color: red;">${i}</button>--%>
                                <%--                                </li>--%>
                            </c:when>
                            <c:otherwise>
                                <li><a href="rescue_ani_search_page?page=${i}">${i}</a></li>
                                <%--                                <li>--%>
                                <%--                                    <button type="submit" name="pageVO"--%>
                                <%--                                            value="${pageVO.page = i}">${i}</button>--%>
                                <%--                                </li>--%>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>


                    <li class="btn-next"><a href="rescue_ani_search_page?page=${pageVO.page + 1}"><img
                            src="resources/img/chevron-left.png" alt=""></a></li>
                    <%--                    <button class="btn-next" type="submit" name="pageVO.page" value="${pageVO.getPage() + 1}"><img--%>
                    <%--                            src="resources/img/chevron-right.png" alt=""></button>--%>
                </ul>

                <ul class="switchBtn-container">
                    <li class="btn-prev-group"><a
                            href="rescue_ani_search_page?page=${pageVO.getPageEnd()-19}">Previous</a></li>
                    <li class="btn-next-group"><a href="rescue_ani_search_page?page=${pageVO.getPageEnd()+1}">Next</a>
                    </li>
                    <%--                    <button class="btn-prev-group" type="submit" name="pageVO.page"--%>
                    <%--                            value="${pageVO.getPageEnd()-19}">Previous--%>
                    <%--                    </button>--%>
                    <%--                    <button class="btn-next-group" type="submit" name="pageVO.page"--%>
                    <%--                            value="${pageVO.getPageEnd()+1}">Next--%>
                    <%--                    </button>--%>
                </ul>
            </div>
            <!-- 페이징 프레임 끝 -->
        </div>
        <!-- result-container끝 -->
    </form>
</div>
</body>
</html>
