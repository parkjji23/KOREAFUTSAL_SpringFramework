<%@page import="com.korea.futsal.vo.TeamDto"%>
<%@page import="com.korea.futsal.vo.TeamBoardListDto"%>
<%@page import="com.korea.futsal.vo.GalBoardDto"%>
<%@page import="com.korea.futsal.vo.PageInfo"%>
<%@page import="com.korea.futsal.vo.NoticeboardDto"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>


<%
	/* PageInfo pageinfo = (PageInfo) request.getAttribute("pageInfo");
	int LISTCOUNT = pageinfo.getLISTCOUNT();
	int NOWPAGE = pageinfo.getPAGE();
	int MAXPAGE = pageinfo.getMAXPAGE();
	int STARTPAGE = pageinfo.getSTARTPAGE();
	int ENDPAGE = pageinfo.getENDPAGE(); */
	String T_CODE = (String)request.getAttribute("T_CODE");
	String TEAMNAME = (String)request.getAttribute("TEAMNAME");
	if(TEAMNAME==null)
		TEAMNAME="전체";
%>
<%
	//2020_01_02 수정부분
	String url = request.getServletPath();
	session.setAttribute("url", url);
	String includeurl = "header.jsp";
	String asidebanner = "asidebanner.jsp";
	String uss = (String) session.getAttribute("ID");
	String log = "로그인";
	if (uss == null)
		uss = "GUEST";
	else {
		log = "로그아웃";
		includeurl = "sign_login.jsp";
	}
	//수정부분 끝
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>팀게시판</title>
<link rel="stylesheet" href="css/galboardstyle.css">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/signbutton.css">
<!--기본적인 body등의 css-->
<link rel="stylesheet" href="css/basicStyle.css" media="screen">
<link rel="stylesheet" href="css/navmid33.css">
<!--Q&A에 펠요한 css-->
<link rel="stylesheet" href="css/Q&Astyle.css" media="screen">
<!-- Q&A에 필요한 script -->
<script type="text/javascript" src="Q&Ascript.js"></script>

<!--주메뉴밑줄기능-->
<link rel="stylesheet" href="css/borderRightLeft.css" media="screen">
<!-- 광호Q&A -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!--2020.01.03 추가 css 분리-->
<link rel="stylesheet" href="css/logform.css" media="screen">
<link rel="stylesheet" href="css/galstyle.css" media="screen">
<!--2020.01.03 추가 javascript.가입기능 분리-->
<script type="text/javascript" src="js/signjs.js"></script>
<!--서브메뉴부르는css-->
<link rel="stylesheet" href="css/style2.css" media="screen">
<!--배너2 자동슬라이드-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.infinitecarousel.js"></script>
<!--footer css 파일 추가-->
<link rel="stylesheet" href="css/footer.css">

<!----------------------------서브메뉴마우스오버기능-------------------------->
<link rel="stylesheet" type="text/css" href="css/subMenuMouseOver.css">
<!----------------------------회원가입스크립트랑 스타일(따로 빼면 에러)-------------------------->
<script type='text/javascript'>
	$(function() {
		$('#forgot_username_link').tipsy({
			gravity : 'w'
		});
	});
</script>
<link href="css/front.css" media="screen, projection" rel="stylesheet" type="text/css">
<script src="js/jquery2.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".signin").click(function(e) {
			e.preventDefault();
			$("fieldset#signin_menu").toggle();
			$(".signin").toggleClass("menu-open");
		});
		$("fieldset#signin_menu").mouseup(function() {
			return false
		});
		$(document).mouseup(function(e) {
			if ($(e.target).parent("a.signin").length == 0) {
				$(".signin").removeClass("menu-open");
				$("fieldset#signin_menu").hide();
				//console.log($(e.target).parent("a.mypage").length);

			}
		});

	});
</script>
<!----------------------------alam form 추가 2020.01.06-------------------------->
<script type="text/javascript">
	$(document).ready(function() {
		$(".mypage").click(function(e) {
			e.preventDefault();
			$("fieldset#mypage_menu").toggle();
			$(".mypage").toggleClass("menu-open");
		});
		$("fieldset#mypage_menu").mouseup(function() {
			return false
		});
		$(document).mouseup(function(e) {
			if ($(e.target).parent("a.mypage").length == 0) {
				$(".mypage").removeClass("menu-open");
				$("fieldset#mypage_menu").hide();
				console.log($(e.target).parent("a.signin").length);
			}
		});

	});
</script>
<!----------------------------회원가입스크립트랑 스타일여기까지------------------------------------>
<script>
	/*스크롤 내리면 메뉴 위치 이동하는 기능------따로빼면 작동xxxxxx*/
	$(function() {
		var shrinkHeader = 30;
		var shrinkhollow = 465;
		$(window).scroll(function() {
			var scroll = getCurrentScroll();
			if (scroll >= shrinkHeader) {
				$('#navtop').addClass('shrink');
			} else {
				$('#navtop').removeClass('shrink');
			}
			if (scroll >= shrinkhollow) {
				$('#navtop').addClass('shrinkhollow');
			} else {
				$('#navtop').removeClass('shrinkhollow');
			}
		});
		function getCurrentScroll() {
			return window.pageYOffset || document.documentElement.scrollTop;
		}
	});
</script>
<style>


.subli ul {
	float: left;
	border: 1px;
}
#galtablenav{
	width: 100%;
    float: left;
    text-align: center;
}
.tab_wrap {
    border: 1px solid #4b4b4b;
    height: 72px;
}
.t03 {
    margin: 0px;
    padding: 0px;
}
.t03 ul {
    list-style-type: disc;
}
.tab_wrap ul li.on {
    z-index: 10;
}
.tab_wrap ul.t03 li {
    width: 50%;
}
.tab_wrap ul li {
    position: relative;
    float: left;
}
.t03 li {
    list-style: none;
}
.t03 li {
    display: list-item;
    text-align: -webkit-match-parent;
}
.tab_wrap ul li:first-child > a {
    border-left: 0;
}
.tab_wrap ul li.on > a {
    background: #2c3c57;
    color: #fff;
}
.tab_wrap ul li > a {
    display: block;
    position: relative;
    border-left: 1px solid #2c3c57;
    background: #fff;
    color: #2c3c57;
    font-size: 22px;
    font-weight: 700;
    line-height: 70px;
    text-align: center;
}
.tab_wrap ul li.on > a:after {
    content: "";
    display: block;
    position: absolute;
    left: 50%;
    bottom: -13px;
    margin-left: -6px;
    width: 13px;
    height: 13px;
    background: url(img/bg_tab_arr.png) no-repeat 0 0;
}


<!--여기부터 팀게시판 css-->
.league_cont .teams_table {
    position: relative;
    margin-top: 60px;
}
.league_cont .teams_table .search {
    padding: 14px 0 14px 75px;
    background: #2c3c57 url(img/icon_league_search.png) no-repeat 0 center;
    font-size: 0;
    line-height: 47px;
}
.league_cont .teams_table .search .select:first-child {
    margin-left: 14px;
    width: 30%;
}
.league_cont .teams_table .search .select {
    margin-right: 8px;
    width: 36%;
    height: 47px;
}
.league_cont .select {
    display: inline-block;
    position: relative;
    padding: 0;
    height: 40px;
    border: 1px solid #e0e0e0;
    background: #fff;
    box-sizing: border-box;
    -moz-box-sizing: border-box;
}
.league_cont .select:after {
    content: "";
    display: block;
    position: absolute;
    right: 12px;
    top: 50%;
    margin-top: -4px;
    width: 13px;
    height: 8px;
    background: url(img/select_arrow.png) no-repeat center center;
    background-size: 11px auto;
}
.league_cont .teams_table .search .select label {
    line-height: 45px;
}
.league_cont .select label {
    position: absolute;
    top: 0px;
    right: 20px;
    bottom: 0;
    left: 10px;
    color: #404040;
    font-size: 16px;
    line-height: 38px;
    text-align: left;
}
.league_cont label {
    cursor: default;
}
.league_cont .select select {
    position: relative;
    z-index: 1;
    padding: 0 4px;
    width: 100%;
    height: 38px;
    line-height: 38px;
    vertical-align: top;
    opacity: 0;
    filter: alpha(opacity=0);
    margin-top: 8px;
}

.league_cont select {
    margin: 0;
    border: 1px solid #999;
    line-height: 22px;
    height: 22px;
    color: #a6a6a6;
    font-weight: bold;
}
.league_cont select {
    -webkit-writing-mode: horizontal-tb !important;
    text-rendering: auto;
    color: -internal-light-dark-color(black, white);
    letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    display: inline-block;
    text-align: start;
    -webkit-appearance: menulist;
    box-sizing: border-box;
    align-items: center;
    white-space: pre;
    -webkit-rtl-ordering: logical;
    background-color: -internal-light-dark-color(white, black);
    cursor: default;
    margin: 0em;
    font: 400 13.3333px Arial;
    border-radius: 0px;
    border-width: 1px;
    border-style: solid;
    border-color: rgb(169, 169, 169);
    border-image: initial;
}
.league_cont option {
    font-weight: normal;
    display: block;
    white-space: pre;
    min-height: 1.2em;
    padding: 0px 2px 1px;
}
.league_cont .teams_table .search_wrap {
    position: absolute;
    top: 14px;
    right: 14px;
    padding-right: 119px;
}
.league_cont div {
    display: block;
}
.league_cont .teams_table .search_wrap input {
    height: 48px;
    width: 330px;
}
.teams_table input[placeholder] {
    line-height: 1em !important;
}
.teams_table input[type='text'], input[type='password'] {
    -webkit-border-radius: 0;
    -webkit-appearance: none;
    outline: none;
}
.teams_table input[type='text'], input[type='password'] {
    height: 30px;
    margin: 0;
    padding: 3px 9px 3px 9px;
    border: 1px solid #ddd;
    background: #fff;
    color: #383838;
    font-size: 16px;
    line-height: 43px;
    vertical-align: middle;
}
.teams_table input {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
}
.teams_table input {
    -webkit-writing-mode: horizontal-tb !important;
    text-rendering: auto;
    color: -internal-light-dark-color(black, white);
    letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    display: inline-block;
    text-align: start;
    -webkit-appearance: textfield;
    background-color: -internal-light-dark-color(white, black);
    -webkit-rtl-ordering: logical;
    cursor: text;
    margin: 0em;
    font: 400 13.3333px Arial;
    padding: 1px 0px;
    border-width: 2px;
    border-style: inset;
    border-color: initial;
    border-image: initial;
}
.league_cont .teams_table .search_wrap button {
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    width: 120px;
    height: 48px;
    background: #4c89cd;
    text-align: center;
}
.league_cont button {
    display: inline-block;
    padding: 0;
    border: 0;
    background: transparent;
    font-family: 'Nanum Gothic','맑은 고딕','AppleGothic','돋움','Dotum', sans-serif;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    white-space: nowrap;
    -webkit-transition: all 0.25s ease-out;
    -moz-transition: all 0.25s ease-out;
    -ms-transition: all 0.25s ease-out;
    -o-transition: all 0.25s ease-out;
    transition: all 0.25s ease-out;
}
.league_cont button {
    -webkit-appearance: button;
    -webkit-writing-mode: horizontal-tb !important;
    text-rendering: auto;
    color: buttontext;
    letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    display: inline-block;
    text-align: center;
    align-items: flex-start;
    cursor: default;
    background-color: buttonface;
    box-sizing: border-box;
    margin: 0em;
    font: 400 13.3333px Arial;
    padding: 1px 6px;
    
    border-style: outset;
    border-color: buttonface;
    border-image: initial;
}
.league_cont .league_cont .teams_table .search_wrap button span {
    display: inline-block;
    padding-right: 30px;
    background: url(/images/content/icon_league_search_s.png) no-repeat right center;
    background-size: auto 40px;
    color: #fff;
    font-size: 18px;
    font-weight: 700;
}
body .league_cont{
    *overflow-y: ;
    width: 983px;
    float: left;
    min-width: 320px;
    color: #403d3f;
    font-size: 18px;
    font-family: 'Nanum Gothic','NanumBarunGothic','AppleGothic','Dotum', sans-serif;
    font-weight: normal;
    line-height: 26px;
    -webkit-text-size-adjust: none;
    word-spacing: 0;
    letter-spacing: -0.3px;
}
.league_cont .teams_table .table_wrap table {
    border: 0;
}
.league_cont .table_wrap table {
    border: 1px solid #636363;
    border-top: 0;
    border-left: 0;
}
.league_cont table {
    width: 100%;
    border: 0 none;
    border-collapse: collapse;
    border-spacing: 0;
}
.league_cont table {
    display: table;
    
    border-spacing: 2px;
    border-color: grey;
}
.league_cont table caption {
    width: 0;
    height: 0;
    line-height: 0px;
    visibility: hidden;
}
.league_cont caption {
    display: table-caption;
    text-align: -webkit-center;
}
.league_cont colgroup {
    display: table-column-group;
}
.league_cont thead {
    display: table-header-group;
    vertical-align: middle;
    border-color: inherit;
}
.league_cont tr {
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
}
.league_cont .teams_table .table_wrap table thead tr th {
    border: 0;
    border-top: 2px solid #2c3c57;
    border-bottom: 2px solid #2c3c57;
    background: #fff;
    color: #4d4d4d;
    font-size: 18px;
    font-weight: 700;
}
.league_cont .table_wrap table thead tr th {
    padding: 21px 0;
    height: 22px;
    background: #f0f1f3;
    color: #383838;
    font-size: 22px;
    line-height: 22px;
    text-align: center;
}
.table_wrap table th, .table_wrap table td {
    border-top: 1px solid #636363;
    border-left: 1px solid #636363;
    font-size: 12px;
    vertical-align: middle;
}
.league_cont table th, table td {
    border: 0 none;
}
.league_cont table th {
    font-weight: normal;
}
.league_cont th {
    display: table-cell;
    vertical-align: inherit;
    font-weight: bold;
    text-align: -internal-center;
}
.league_cont tbody {
    display: table-row-group;
    vertical-align: middle;
    border-color: inherit;
}
.league_cont .teams_table .table_wrap table tbody tr:nth-child(2n-1) td {
    background: #f0f1f3;
}
.league_cont .teams_table .table_wrap table tbody tr td:first-child {
    border-left: 0;
}
.league_cont .teams_table .table_wrap table tbody tr td {
    padding: 10px 0;
    border-top: 0;
    border-bottom: 1px solid #d5d8dd;
    border-left: 1px solid #d5d8dd;
    background: #fff;
    font-size: 18px;
    line-height: 50px;
}
.table_wrap table tbody tr td {
    padding: 18px 0;
    height: 20px;
    color: #2a2a2a;
    font-size: 18px;
    line-height: 28px;
    text-align: center;
    word-break: keep-all;
}
.table_wrap table th, .table_wrap table td {
    border-top: 1px solid #636363;
    border-left: 1px solid #636363;
    font-size: 12px;
    vertical-align: middle;
}
.league_cont table th, table td {
    border: 0 none;
}
.league_cont .teams_table .table_wrap table tbody tr td .emb_wrap {
    margin: 0 22px;
    padding-left: 75px;
    font-size: 18px;
    font-weight: 700;
    line-height: 50px;
}
.table_wrap table tbody tr td .emb_wrap {
    position: relative;
    padding-left: 55px;
    font-size: 16px;
    line-height: 32px;
    text-align: left;
}
.league_cont .teams_table .table_wrap table tbody tr td .btn_view {
    display: inline-block;
    padding: 0 19px 0 19px;
    height: 42px;
    background: #4c89cd;
    color: #fff;
    font-size: 16px;
    text-align: center;
    line-height: 42px;
}
.league_cont a:visited {
    text-decoration: none;
}
.league_cont a {
    color: #000;
    text-decoration: none;
}
.league_cont a .team{
	color: #000;
}
.league_cont a:-webkit-any-link {
    color: -webkit-link;
    cursor: pointer;
    text-decoration: underline;
}
.league_cont .h_tit {
    position: relative;
    margin-bottom: 45px;
    padding-bottom: 24px;
    font-size: 60px;
    font-family: 'NanumBarunGothicL';
    line-height: 60px;
    text-align: center;
}
.league_cont .h_tit:after {
    content: "";
    display: block;
    position: absolute;
    bottom: 0;
    left: 50%;
    margin-left: -49px;
    width: 98px;
    height: 2px;
    background: #bfc4cc;
}
.table_wrap table tbody tr td .emb_wrap .emb img {
    width: 100%;
    height: auto;
}
.league_cont .teams_table .table_wrap table tbody tr td .emb_wrap .emb {
    width: 50px;
    height: 50px;
}
.table_wrap table tbody tr td .emb_wrap .emb {
    display: block;
    position: absolute;
    top: 0;
    left: 0;
    width: 32px;
    height: 32px;
}
.league_cont .teams_table .search_wrap button span {
    display: inline-block;
    padding-right: 30px;
    background: url(img/icon_league_search_s.png) no-repeat right center;
    background-size: auto 40px;
    color: #fff;
    font-size: 18px;
    font-weight: 700;
}
.pager_wrap {
    position: relative;
    margin-top: 42px;
    font-size: 0;
    line-height: 0;
    text-align: center;
    letter-spacing: -10px;
}
.pager_wrap a.btn_page.prev {
    margin: 0;
    background: #fff url(img/icn_page_prev.png) no-repeat center center;
}
.pager_wrap a.btn_page {
}
.pager_wrap a {
    display: inline-block;
    margin-left: 8px;
    width: 79px;
    height: 41px;
    border: 1px solid #cecece;
    background: #fff;
    color: #afafaf;
    font-size: 16px;
    line-height: 41px;
    vertical-align: top;
    letter-spacing: 0;
}
.hide {
    display: block;
    overflow: hidden;
    position: absolute;
    top: 0;
    left: 0;
    width: 0;
    height: 0;
    text-indent: -9999px;
}
.pager_wrap .page {
    display: inline-block;
    margin: 0 22px;
    text-align: center;
    vertical-align: top;
}
.pager_wrap .page a.on {
    border: 1px solid #2c3c57;
    background: #2c3c57;
    color: #fff;
    text-decoration: none;
}
.pager_wrap .page a:first-child {
    margin: 0;
}
.pager_wrap .page a {
    position: relative;
    width: 41px;
    height: 41px;
}
.pager_wrap a {
    display: inline-block;
    margin-left: 8px;
    width: 79px;
    height: 41px;
    border: 1px solid #cecece;
    background: #fff;
    color: #afafaf !important;
    font-size: 16px;
    line-height: 41px;
    vertical-align: top;
    letter-spacing: 0;
}
.pager_wrap a.btn_page.next {
    margin: 0;
    background: #fff url(img/icn_page_next.png) no-repeat center center;
}
.pager_wrap a.btn_page {
}
.pager_wrap a {
    display: inline-block;
    margin-left: 8px;
    width: 79px;
    height: 41px;
    border: 1px solid #cecece;
    background: #fff;
    color: #afafaf;
    font-size: 16px;
    line-height: 41px;
    vertical-align: top;
    letter-spacing: 0;
}

.league_cont .teams_table {
    position: relative;
}
<!--여기까지 팀게시판css-->


</style>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet"><!-- font-family:'Nanum Gothic', sans-serif -->

<style>
	.h_tit {
    position: relative;
    margin-bottom: 45px;
    padding-bottom: 24px;
    font-size: 50px;
    font-family: 'NanumBarunGothicL';
    line-height: 60px;
    text-align: center;
}
.h_tit:after {
    content: "";
    display: block;
    position: absolute;
    bottom: 0;
    left: 50%;
    margin-left: -49px;
    width: 98px;
    height: 2px;
    background: #bfc4cc;
}
input[type=button]{
font-weight:bold;
}
*{
font-family:'Nanum Gothic', sans-serif;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="<%=includeurl%>" />
	</header>
	<aside>
		<jsp:include page="<%=asidebanner%>" />
	</aside>
	<section id="main">
		<section id="mainright">
			<div id="matList">
				<div class="sec_ban2 margin2">

					<h3 class="h_tit" style="font-weight:normal;">공 지 사 항</h3>

					<table class="table table-striped margin2">
						<thead>
							<tr id="tabletitle">
								<th></th>
								<th scope="col" class="thtitle" style="text-align: center"><span>제목</span></th>
								<th scope="col" class="thname"><span>작성자</span></th>
								<th scope="col" class="thdate"><span>작성일</span></th>
								<th scope="col" class="thview"><span>조회</span></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${teamboardlistNotice}" var="vo" varStatus="status" begin="0" end="2" step="1">
							<tr>
								<td class="thgongji">공지</td>
								<td class="thtitle"><a href="noticeboard_view&NO=${vo.NO}"> ${vo.TITLE}</a></td>
								<td class="thname">${vo.ADMINNAME}</td>
								<td class="thdate"style="width: 96px;">${vo.DATE}</td>
								<td class="thview">${vo.READCOUNT}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table> 
				</div>
				
				
				<div id="galtablenav">
					<div class="tab_wrap">
						<ul class="t03">
							<li><a href="galList.bo">팀 갤러리</a></li>
							<li class="on" ><a href="teamboardlist">팀 게시판</a></li>
						</ul>
					</div>
					<div style="text-align: center; font-size: 45px;margin-top: 50px; "><%=TEAMNAME %> 팀 게시판</div>
					<input type="button" value="글쓰기" class="signbutton signbutton5 buttonmargin" onClick="script: location.href='team_board_list_writeform&id=<%=uss %>'" style="margin-right: 34px;">
				
				</div>
				
				<div class="container" style="width: 1193px;">
					
					<div class="league_cont team">
					<div class="teams_table" style="clear:both;width: 950px;">
						
					
						<div class="search">
							<form name="frm_search" method="post" action="teamboardlist">
							
							<span class="select">
								<label for="select02" style="width:100%;">전체</label>
								<select id="select02" name="searchtype" class="select_box" style="width:100%;" onchange="fn_SelBranch();">
									<option value="all">전 체</option>
									<option value="subject">글 제목</option>
									<option value="id">글 쓴이</option>
								</select>
							</span>
							<div class="search_wrap">
								<input type="text" name="search" value="" placeholder="팀명을 입력 하세요">
								<button type="button" class="search_button" onclick="this.form.submit();"><span>검색</span></button>
							</div>
							<input type="hidden" name="id" id="id" value="<%=uss%>" />
							<input type="hidden" name="teamcode" id="teamcode" value="<%=T_CODE%>" />
							</form>
						</div>
						<script>
						$("#select02").change(function(){
							var select_name = $(this).children("option:selected").text();
					        $(this).siblings("label").text(select_name);
						});
						</script>
						<div class="table_wrap">
							<table>
							
							<caption>팀 테이블</caption>
							<colgroup>
								<col style="width:80px" class="tb">
								<col style="">
								<col style="width:130px" class="w07">
								<col style="width:130px" class="tb">
								<col style="width:100px" class="w07">
							</colgroup>
							<thead>
								<tr>
									<th scope="col" class="tb">글번호</th>
									<th scope="col">글제목</th>
									<th scope="col">글쓴이</th>
									<th scope="col" class="tb">게시일</th>
									<th scope="col">조회수</th>
								</tr>
							</thead>
							<tbody>
							
							<c:forEach items="${teamboardlist}" var="teamboardlist" varStatus="status">
										<tr>
											<td class="tb">${teamboardlist.NO}</td>				
											<td><div class="emb_wrap">
													<a href="teamboarddetail&teamBoardNo=${teamboardlist.NO}">
													<span class="team">${teamboardlist.SUBJECT}
														</span></a></div></td>
											<td>${teamboardlist.ID}</td>
											<td class="tb">${teamboardlist.DATE}</td>
											<td>${teamboardlist.READCOUNT}</td>
										</tr>
							 </c:forEach>
							</tbody>
							</table>
						</div>
						<!-- Page -->
						 <%-- <section id="pageList" style="clear:both; text-align: center;">
					<ul class="pagination">
						<%
							if (NOWPAGE <= 1) {
						%>
						<li><a style="color:black;">이전</a></li>&nbsp;
						<%
							} else {
						%>
						
						<li><a href="teamboardlist&page=<%=NOWPAGE - 1%>">이전</a></li>&nbsp;
						<%
							}
						%>

						<%
							for (int a = STARTPAGE; a <= ENDPAGE; a++) {
									if (a == NOWPAGE) {
						%>
						<li><a style="color:black;"><%=a%></a></li>
						<%
							} else {
						%>
						<li><a href="teamboardlist&page=<%=a%>&teamcode=<%=T_CODE%>"><%=a%>
						</a></li>&nbsp;
						<%
							}
						%>
						<%
							}
						%>

						<%
							if (NOWPAGE >= MAXPAGE) {
						%>
						<li><a style="color:black;">다음</a></li>
						<%
							} else {
						%>
						<li><a href="teamboardlist&page=<%=NOWPAGE + 1%>">다음</a></li>
						<%
							}
						%>
						</ul>
					</section> --%>
						<!-- //Page -->
					</div>
					</div>
					
					<aside style="margin-left: -25px;position: relative;top: -282px;">
						<div id="wrap">
							<div class="product-head">

								 <div id="form"></div>
								<div class="subli logolistmargin">
								<c:forEach items="${teamlist}" var="teamlist" varStatus="status">
									<li><img src="img/${teamlist.TEAMLOGO}" align="absmiddle" class="subli_img" /> <a href="teamboardlist&teamcode=${teamlist.TEAMCODE}&teamname=${teamlist.TEAMNAME}" >${teamlist.TEAMNAME}</a></li>
									</c:forEach>
								</div>
							</div>
						</div>
					</aside>
				</div>
			</div>
			</div>
			</div>
		</section>
	</section>
	<footer id="footer" style="margin-top:200px;">
		<jsp:include page="Footer.jsp" />
	</footer>
	<jsp:include page="quickbar.jsp" />
</body>
</html>