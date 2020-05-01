<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
//2020_01_02 수정부분
	String uss = (String)session.getAttribute("ID");
	String log = "로그인";
	if(uss!=null)
		log="로그아웃"; 	

	String headerurl = (String)request.getAttribute( "javax.servlet.include.request_uri" ); 
	session.setAttribute("headerurl",headerurl);
%>
<!-- 컨트롤러 서블릿패스의 uri를 가져옴 -->
<%
	String servlet_uri = (String)request.getAttribute("javax.servlet.forward.request_uri");
	if(servlet_uri==null){
		servlet_uri=request.getRequestURI();
	}
%>
<script>
<!-- 헤더의 자동로그인 추가부분 2020.03.25 by pang-->
function loginajax() {
	$.ajax({
	type:"post",
	url:"loginbutton",       
	data:{
		ID:$('#username').val(),
		PW:$('#password').val()
	},	
	success:function(lr){
		/* var thisfilefullname = document.URL.substring(document.URL.lastIndexOf("/") + 1, document.URL.length); */
		$("#LoginAjax").html(lr); //로그인결과 [성공/실패] 글자띄워주기
			if(!ID.isEmpty() && thisfilefullname!="sign" && thisfilefullname!="insertResult"){
					/* HttpSession session = request.getSession();
					session.setAttribute("ID", ID);
					session.setAttribute("NAME", NAME); */
					location.reload();
			}else{
					location.href = "index";
			}
		},
	error:function(){
		alert("Error");
	}
	});
}
</script>
<!--마이페이지 접근 위한 css 파일 분리-->
<link href="css/front.css" media="screen, projection" rel="stylesheet" type="text/css">
<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet"><!-- font-family:'Nanum Gothic', sans-serif -->
<link href="css/logostyle.css" media="screen, projection" rel="stylesheet" type="text/css">

<style>
input[type=button],input[type=submit]{
font-weight:bold;
}
*{
font-family:'Nanum Gothic', sans-serif;
}
</style>

<style>
<%if(servlet_uri!=null){%>
	<%if(servlet_uri.contains("branch")) {%>
	
	<%}else if(servlet_uri.contains("mat")){ %>
	#navmid_1 {
		float : left;
		width: 50%; height:100%
	}
	#navmid_2 {
		float : left;
		width: 50%; height:100%
	}
	<%}else if(servlet_uri.contains("league")){ %>
	#navmid_1 {
		float : left;
		width: 33.3%; height:100%
	}
	#navmid_2 {
		float : left;
		width: 33.3%; height:100%
	}
	#navmid_3 {
		float : left;
		width: 33.4%; height:100%
	}
	<%}else if(servlet_uri.contains("team")||servlet_uri.contains("gal")){ %>
	#navmid_1 {
		float : left;
		width: 33.3%; height:100%
	}
	#navmid_2 {
		float : left;
		width: 33.3%; height:100%
	}
	#navmid_3 {
		float : left;
		width: 33.4%; height:100%
	}
	<%}else if(servlet_uri.contains("servicecenter")){ %>
	#navmid_1 {
		float : left;
		width: 50%; height:100%
	}
	#navmid_2 {
		float : left;
		width: 50%; height:100%
	}
	<%}else{ %>
	
	<%} %>
<%}%>
</style>
<body>
	<jsp:include page="quickbar.jsp" />
	<header id="header">
		<video id="video01" autoplay="" playsinline="" muted="" loop="" height="460" width="100%" title="video element">
			<source src="img/video element.mp4" type="video/mp4">
		</video>
		<div id="navtop">
			<div id="navtop_logo">
				<a class="border-animation" href="index">
    				<div class="border-animation__inner">KOREA FUTSAL PARK</div>
    			</a>
			</div>
			<div id="navtop_menu">
				<ul class="menu">
					<li class="borderRightLeft"><a href="branchlistview">대관</a>
						<ul>
						</ul></li>
					<li class="borderRightLeft"><a href="matchapply" >매치/용병</a>
						<ul style="left: -37px;">
							<li><a href="matchapply" >매치신청</a></li>
							<li><a href="yonglist" >용병등록</a></li>
						</ul></li>
					<li class="borderRightLeft"><a href="league_main" >리그</a>
						<ul>
							<li><a href="league_main">리그랭킹</a></li>
							<li><a href="league_team_step1">리그접수</a></li>
							<li><a href="league_join_step1">선수등록</a></li>
						</ul></li>
					<li class="borderRightLeft"><a href="galList" >팀커뮤니티</a>
						<ul style="left: -30px;">
							<li><a href="galList" >팀갤러리</a></li>
							<li><a href="teamboardlist" >팀게시판</a></li>
							<li><a href="teamlist" >팀리스트</a></li>
						</ul></li>
					<li class="borderRightLeft"><a href="qna" >고객센터</a>
						<ul style="left: -40px;">
							<li><a href="noticeboard" >공지사항</a></li>
							<li><a href="qna" >Q&A</a></li>
						</ul></li>
				</ul>
			</div>
			<div id="navtop_login">
				<!--회원상태 창-->


				<a href="sign" style="float: left; line-height: 25px;">회원가입</a>
				<div id="container" style="float: left;">
					<div id="topnav" class="topnav">
						<a href="login" class="signin"> <span ><%=log%></span>
						</a>
					</div>
					<fieldset id="signin_menu">
						<form name="login" method="post" id="signin" action="loginbutton">
							<p>
								<label for="username" style="font-size: 14px;" >아이디</label> <input id="username" name="username" value="" title="username" tabindex="4" type="text">
							</p>
							<p>
								<label for="password" style="font-size: 14px;" >비밀번호</label> <input id="password" name="password" value="" title="password" tabindex="5" type="password">
							</p>
							<p class="remember">
								<input id="signin_submit" value="로그인" tabindex="6" type="button" onclick="loginajax()" > <input id="remember" name="remember" value="1" tabindex="7" type="checkbox"> <label for="remember" style="font-size: 13px;">로그인상태유지</label>
							</p>
							<p>
								<A id=forgot_username_link title="If you remember your password, try logging in with your email" href="findid" class="forgot-username" style="color: white; font-size: 13px; word-spacing: 15px; letter-spacing: 1px;"> 아이디찾기 | </A> <a href="findpass" id="resend_password_link" class="forgot" style="color: white; font-size: 13px;">비밀번호찾기</a>
							</p>
						</form>
					</fieldset>
				</div>
				<div id="LoginAjax"></div>
			</div>
		</div>

		</div>
		<%if(servlet_uri.contains("mat")||servlet_uri.contains("league")||servlet_uri.contains("team")||servlet_uri.contains("gal")||servlet_uri.contains("servicecenter")){%>
		<div id="navmid">
			<%if(servlet_uri!=null){%>
				<%if(servlet_uri.contains("branch")) {%>
				
				<%}else if(servlet_uri.contains("mat")){ %>
					<a id="navmid_1" class="slideDown" href="matchapply" >매치신청</a>
					<a id="navmid_2" class="slideDown" href="yonglist" >용병등록</a>
				<%}else if(servlet_uri.contains("league")){ %>
					<a id="navmid_1" class="slideDown" href="league_main" >리그랭킹</a>
					<a id="navmid_2" class="slideDown" href="league_team_step1" >리그접수</a>
					<a id="navmid_3" class="slideDown" href="league_join_step1" >선수등록</a>
				<%}else if(servlet_uri.contains("team")||servlet_uri.contains("gal")){ %>
					<a id="navmid_1" class="slideDown" href="galList.bo" >팀갤러리</a>
					<a id="navmid_2" class="slideDown" href="teamboardlist" >팀게시판</a>
					<a id="navmid_3" class="slideDown" href="teamlist" >팀리스트</a>
				<%}else if(servlet_uri.contains("servicecenter")){ %>
					<a id="navmid_1" class="slideDown" href="noticeboard" >공지사항</a>
					<a id="navmid_2" class="slideDown" href="qna" >Q&A</a>
				<%}else{ %>
				
				<%} %>
			<%} %>
			
		</div>
		<%} %>
	</header>
</body>