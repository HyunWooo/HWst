<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="contact_us.do"><i class="fa fa-star"></i> 관리자 문의</a></li>
								<li><a href="contact_us.do"><i class="fa fa-phone"></i> 010-3341-3855</a></li>
								<li><a href="contact_us.do"><i class="fa fa-envelope"></i> gusdn@sk.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6 col-xs-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<c:choose>
									<c:when test="${not empty sessionScope.userLoginInfo}">
										<li><a href= "userManagement.do"><i class="fa fa-user"></i>${sessionScope.userLoginInfo.name}님</a></li>
										<li><a href="logoutProcess.do"><i class="fa fa-crosshairs"></i> Logout</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="login.do"><i class="fa fa-lock"></i> Login</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="javascript:history.back(-1)"><img src="images/home/logo.png" alt="" /></a>
						</div>
						<!-- 안쓰는 버튼그룹 -->
						<div class="btn-group pull-right">
						</div>
					</div>
					<div class="col-sm-8">
						<div class="mainmenu pull-right">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="contact_us.do">Contact-us</a></li>
								<li><a href="javascript:history.back(-1)" class="active">뒤로가기</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	</header><!--/header-->
	 
	 <div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12">    			   			
					<h2 class="title text-center">Contact <strong>Us</strong></h2>    			    				    				
					<!-- <div id="gmap" class="contact-map-center">
						<iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3162.335871884976!2d126.98357700000001!3d37.570707999999996!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca2ee98180615%3A0x8c36d262dc3a051e!2z7ZWc6rWt642w7J207YSw67Kg7J207Iqk7KeE7Z2l7JuQ!5e0!3m2!1sko!2skr!4v1423569599455"></iframe>
					</div> -->
					<section id="contact-info">
				        <div class="gmap-area">
				            <div class="container">
				                <div class="row">
				                    <div class="col-sm-5 text-center">
				                        <div class="gmap">
				                            <iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d12661.908279947827!2d126.91921430000004!3d37.496664800000005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9fafb5381bcd%3A0xb8b0c3be1761f097!2z7ISc7Jq47Yq567OE7IucIOuPmeyekeq1rCDsl6zsnZjrjIDrsKnroZwgMTEy!5e0!3m2!1sko!2skr!4v1435132281436" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
				                        </div>
				                    </div>
				
				                    <div class="col-sm-7 map-content" align="center">
				                        <!-- <ul class="row"> -->
				                            <!-- <li class="col-sm-6"> -->
				                                <address>
				                                <br><br><br>
				                                    <h5>HW_st</h5>
				                                    <p>156-709 <br>
				                                       	서울특별시 동작구 신대방동 370-1 성무관 7층</p>
				                                    <p>Phone : 010-3341-3855 <br>
				                                    Email Address : gusdn@sk.com</p>
				                                </address>
				                    </div>
				                </div>
				            </div>
				        </div>
				    </section>  <!--/gmap_area -->
				</div>			 		
			</div> 
			<hr>	
    	</div>	
    </div><!--/#contact-page-->
    
<!-- footer -->
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>
<!-- /footer -->	

	

  
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script type="text/javascript" src="js/gmaps.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>