<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope.stat eq true}">
	<script>
		alert("재고수량의 수정이 완료되었습니다");
		<%session.removeAttribute("stat");%>
		window.location.reload();
	</script>
</c:if>
<script type="text/javascript" charset="utf-8">
function mySubmit(frm,index,countNo){
	var division = parseInt(countNo)-1;
	var productOptionNo = document.getElementsByName('productOptionNo');
	var productAmount = document.getElementsByName('productAmount');
	
	//상품옵션의 수량 변경
	if(index==1){
		var fm = document.createElement("form");
		
		/* if(productAmount[parseInt(division)].value < 0){ //update할 상품의 수량이 0 이하일 경우 걸러줌
			alert("재고수량은 0 이상이어야 합니다");
			window.location.reload();
			return false;
		} */
		
		fm.setAttribute("method", "post");
		fm.setAttribute("action", "deleteProduct.do");
		document.body.appendChild(fm);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "productNo");
		i.setAttribute("value", productNo[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "details");
		i.setAttribute("value", details[parseInt(division)].value);
		fm.appendChild(i);
		
		fm.submit();
	}
	
	if(index==2){
		 cw=screen.availWidth;     //화면 넓이
		 ch=screen.availHeight;    //화면 높이
	
		 sw=1000;    //띄울 창의 넓이
		 sh=650;    //띄울 창의 높이
	
		 ml=(cw-sw)/2;        //가운데 띄우기위한 창의 x위치
		 mt=(ch-sh)/2;         //가운데 띄우기위한 창의 y위치
		 
	    var url    ="manageProductOption.do";
	    var title  = "상품옵션관리";
	    var status = 'width='+sw+',height='+sh+',top='+mt+',left='+ml+',resizable=no,scrollbars=yes'; 
	    window.open("", title,status);
	    
	    frm.target = title;
	    frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
	    frm.method = "post";
	    frm.submit();     
	}
}
	
	

	
</script>
	
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
								<!-- <li><a href="#"><i class="fa fa-user"></i> Account</a></li> -->
 								<!--<li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li> -->
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
							<a href="orderManagement.do"><img src="images/home/logo.png" alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="mainmenu pull-right">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="orderManagement.do" class="active">주문관리</a></li>
								<li><a href="selectRegisterPrdAll.do" class="active">상품관리</a></li>
								<li><a href="contact_us.do">Contact-us</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<!-- <div class="header-bottom">header-bottom
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div> --><!--/header-bottom-->
	</header><!--/header-->
	
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li class="active">상품관리</li><br><hr>
				  <a href="registerProduct.do"><상품 등록하기></a>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="info">상품명<br>(상품번호)</td>
							<td class="image">이미지</td>
							<td class="description">상품옵션명<br>옵션순서</td>
							<td class="price">기본금액<br>추가금액</td>
							<td class="stat">수량</td>
							<td class="stat">상품상세설명</td>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${list}" var="productOptionList" varStatus="status">
							<tr>
								<c:if test="${productOptionList.productNoCount ne 0}">
									<td class="cart_info" rowspan="${productOptionList.productNoCount}">
									<form name="PODetailsForm" method="POST">
										<p>"${productOptionList.name}"<br>(${productOptionList.productNo})</p>
										<br><input type="hidden" name="productNo" value="${productOptionList.productNo}"/>
										<button type="button" class="btn btn-fefault cart" name="updateButton"value="${productOptionList.productNo}"onclick="mySubmit(this.form,2,this.value);">상품옵션 수정</button>
									</form>
									</td>
								</c:if>
								<td class="cart_image">
									<img src="images/product/<c:out value="${productOptionList.categoryNo}"/>/<c:out value="${productOptionList.productNo}"/>_1.jpg" alt="" />
								</td>
								<td class="cart_description">
									<h4>${productOptionList.productOptionName}</h4>
									<p></p>
									<p>${productOptionList.optionProcedure}번</p>
								</td>
								<td class="cart_price">
									<p><fmt:formatNumber value="${productOptionList.basicPrice}"/>원/<fmt:formatNumber value="${productOptionList.addPrice}"/>원</p>
								</td>
								<td class="cart_stat">
									<input type="hidden" id="${status.count}" name="productOptionNo" value="${productOptionList.productOptionNo}">
									<p>${productOptionList.productAmount}</p>
								</td>
								<c:if test="${productOptionList.productNoCount ne 0}">
									<td class="cart_stats" rowspan="${productOptionList.productNoCount}">
										${productOptionList.details}
										<%-- <button type="button" class="btn btn-fefault cart" name="updateButton"value="${status.count}"onclick="mySubmit(this.form,1,this.value);">삭제</button> --%>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<section>
		<input type="hidden" name="accountNo" value="${sessionScope.userLoginInfo.accountNo}">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<img class="btmprocess" src="images/order/deliveryProcess.jpg" class="img-responsive" alt=""  align="middle" /><br><br><br><br>
	</section>
	</form>
	
	
	<footer id="footer"><!--Footer-->
		<!-- <div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Service</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">Online Help</a></li>
								<li><a href="#">Contact Us</a></li>
								<li><a href="#">Order Status</a></li>
								<li><a href="#">Change Location</a></li>
								<li><a href="#">FAQ’s</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Quock Shop</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">T-Shirt</a></li>
								<li><a href="#">Mens</a></li>
								<li><a href="#">Womens</a></li>
								<li><a href="#">Gift Cards</a></li>
								<li><a href="#">Shoes</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Policies</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">Terms of Use</a></li>
								<li><a href="#">Privecy Policy</a></li>
								<li><a href="#">Refund Policy</a></li>
								<li><a href="#">Billing System</a></li>
								<li><a href="#">Ticket System</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">Company Information</a></li>
								<li><a href="#">Careers</a></li>
								<li><a href="#">Store Location</a></li>
								<li><a href="#">Affillate Program</a></li>
								<li><a href="#">Copyright</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Your email address" />
								<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
								<p>Get the most recent updates from <br />our site and be updated your self...</p>
							</form>
						</div>
					</div>
					
				</div>
			</div>
		</div> -->
		
		<div class="footer-bottom">
			<div class="container">
					<div class="col-sm-6">
						<div class="single-widget">
							<p class="pull-left">Copyright © 2015 HW. All rights reserved.</p>
						</div>
					</div>
					<!-- <div class="col-sm-6">
						<div class="single-widget">
							<ul class="pull-right">
								<li><a href="#">Home</a></li>
								<li><a href="#">About Us</a></li>
								<li><a href="#">Faq</a></li>
								<li><a href="#">Contact Us</a></li>
							</ul>
						</div>
					</div>	 -->
					<!-- <p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p> -->
			</div>
		</div>
		
	</footer><!--/Footer-->
	

  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>