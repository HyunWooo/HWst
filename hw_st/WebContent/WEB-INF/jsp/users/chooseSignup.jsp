<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<c:choose>
		<c:when test="${not empty sessionScope.userLoginInfo.name}">
			<script>
				alert("이미 로그인 된 상태입니다.");
				history.go(-1);
			</script>
		</c:when>
		<c:when test="${sessionScope.loginFail=='Y'}">
			<script>
				alert("아이디와 패스워드를 다시 확인하세요.");
				<%session.invalidate();%>
				history.go();
			</script>
		</c:when>
	<c:otherwise>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="http://s.011st.com/img/common/icon/favicon.ico"  type="image/x-ico">
    <title>현우st</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <!-- <link rel="shortcut icon" href="images/ico/favicon.ico"> -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>
	<!-- /header -->
	
			<section id="form"><!--form-->
				<div class="container">
					<div class="row">
						<div class="col-sm-4">
							<a href="signupBuyer.do"><img src="images/users/buyer.JPG" class="img-responsive" alt="" />
						</div>
						<div class="col-sm-1">
							<h2 class="or">OR</h2>
						</div>
						<div class="col-sm-4">
							<a href="signupSeller.do"><img src="images/users/seller.JPG" class="img-responsive" alt="" />
						</div>
					</div>
				</div>
			</section><!--/form-->
		</c:otherwise>
	</c:choose>
	
	
	
<!-- footer -->
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>
<!-- /footer -->	

	

  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>