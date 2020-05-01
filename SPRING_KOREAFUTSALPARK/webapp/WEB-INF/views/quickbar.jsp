<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String headerurl = (String) session.getAttribute("headerurl");
	String uss = (String)session.getAttribute("id");
%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>quickbar</title>
<link rel="stylesheet" href="css/quick.css">
</head>
<body>
	<div id="quick_">
		<ul class="quick_inner">
			<li class="q1"><a href="Mypage.jsp" title="마이페이지" > <img src="img/mypage_icon.png" alt="마이페이지">
			</a> <span>마이페이지</span></li>

			<li class="q2"><a href="branchlistview" title="풋살장예약"> <img src="img/reservation_icon.png" alt="풋살장예약">
			</a> <span>풋살장예약</span></li>

			<li class="q3"><a href="Mypage.jsp" title="예약한구장"> <img src="img/reservation_icon2.png" alt="예약한구장">
			</a> <span>예약한구장</span></li>

			<li class="pageTop"><a href="#header" title="맨위로"> <img src="img/top_icon.png" alt="맨위로">
			</a> <span>맨위로</span></li>

			<li class="pageDw"><a href="#footer" title="맨아래로"> <img src="img/dw_icon.png" alt="맨아래로">
			</a> <span>맨아래로</span></li>
		</ul>
	</div>
</body>
</html>
