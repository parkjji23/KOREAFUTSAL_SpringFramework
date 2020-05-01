<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//2020_01_02 수정부분
	String uss = (String)session.getAttribute("ID");
	String log = "로그인";
	if(uss!=null)
		log="로그아웃"; 	
		//수정부분 끝

	String headerurl = (String)request.getAttribute( "javax.servlet.include.request_uri" ); 
	session.setAttribute("headerurl",headerurl);
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
			if(lr=="loginCom"){/*  && thisfilefullname!="sign" && thisfilefullname!="insertResult" */
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


<link href="css/logostyle.css" media="screen, projection" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet"><!-- font-family:'Nanum Gothic', sans-serif -->

<style>
input[type=button],input[type=submit]{
font-weight:bold;
}
*{
font-family:'Nanum Gothic', sans-serif;
}
</style>
<body>
	
	<header id="header">
		
		<div id="navtop">
			<div id="navtop_logo">
				<a class="border-animation" href="index">
    				<div class="border-animation__inner">KOREA FUTSAL PARK</div>
    			</a>
			</div>
			<div id="navtop_menu" style="margin-left: 156px;">
				<ul class="menu">
					<li class="borderRightLeft"><a href="branchlistview">대관</a>
						<ul>
						</ul></li>
					<li class="borderRightLeft"><a href="matchapply" >매치/용병</a>
						<ul>
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
						<ul>
							<li><a href="galList" >팀갤러리</a></li>
							<li><a href="teamboardlist" >팀게시판</a></li>
							<li><a href="teamlist" >팀관리</a></li>
						</ul></li>
					<li class="borderRightLeft"><a href="qna" >고객센터</a>
						<ul style="width: 210px; ">
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
								<A id=forgot_username_link title="If you remember your password, try logging in with your email" href="findid.jsp" class="forgot-username" style="color: white; font-size: 13px; word-spacing: 15px; letter-spacing: 1px;"> 아이디찾기 | </A> <a href="findpass.jsp" id="resend_password_link" class="forgot" style="color: white; font-size: 13px;">비밀번호찾기</a>
							</p>
						</form>
					</fieldset>
				</div>
				<div id="LoginAjax"></div>
			</div>
		</div>

		
		
	</header>
</body>