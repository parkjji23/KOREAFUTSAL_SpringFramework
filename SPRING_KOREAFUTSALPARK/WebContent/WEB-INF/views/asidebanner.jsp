<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="mainleft">
		<div id="leftbanner">
			<div id="banner1">
				<a href="introduce_page.jsp" >
					<img src="img/20191211.jpg" width="100%" height="100%" />
				</a>
			</div>
			<!-- 좌측지도배너시작 -->
			<div id="banner3">
			<div id="map" style="width:235px;height:217px;">
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2edbdc3d0bf82bd372695a3c24dd635a&libraries"></script>
				<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		 // 지도에 클릭 이벤트를 등록합니다
		// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
		    
		   location.href="index.do?command=index"
		    
		}); 
	</script>
				</div>
				</div>
				<!-- 좌측지도배너끝 -->
		</div>
	</div>
</body>
</html>