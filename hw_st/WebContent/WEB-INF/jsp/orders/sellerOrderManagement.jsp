<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:choose>
	<c:when test="${sessionScope.userLoginInfo.userSection ne 2}">
		<script>
			alert("판매자 전용 페이지입니다.");
			<%session.invalidate();%>
			location.href("redirect:login.do");
		</script>
	</c:when>
</c:choose>
<head>	
<script type="text/javascript" charset="utf-8">

//amt = commaNum(amt)  
// 1000000 => 1,000,000  
function commaNum(num) {  
    var len, point, str;  

    num = num + "";  
    point = num.length % 3;  
    len = num.length;  

    str = num.substring(0, point);  
    while (point < len) {  
        if (str != "") str += ",";  
        str += num.substring(point, point + 3);  
        point += 3;  
    }  
    return str;  
}  

//수량변경,선택주문하기,전체주문하기 submit 분기
function mySubmit(frm,index,countNo){
	
	//무통장입금확인 상태변경
	if(index==1){
		if (confirm("입금을 확인하셨습니까? \n확인 후 배송을 준비해 주세요") == true){    //확인
			var fm = document.createElement("form");
			
			fm.setAttribute("method", "post");
			fm.setAttribute("action", "updateOrderStat.do");
			document.body.appendChild(fm);
			
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "orderNo");
			i.setAttribute("value", countNo);
			fm.appendChild(i);
			
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "orderStat");
			i.setAttribute("value",  3);
			fm.appendChild(i);
			
			fm.submit();
		}
			
	}
	
	//배송상태가 배송준비중일때, 배송요청하기
	if(index==2){
		var division = parseInt(countNo)-1;
		var orderNo = document.getElementsByName("orderNo");
		var productOptionNo = document.getElementsByName("productOptionNo");
		
		var fm = document.createElement("form");
		
		fm.setAttribute("method", "post");
		fm.setAttribute("action", "udtDeliveryStat.do");
		document.body.appendChild(fm);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "orderNo");
		i.setAttribute("value", orderNo[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "productOptionNo");
		i.setAttribute("value", productOptionNo[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "deliveryStat");
		i.setAttribute("value", 2);
		fm.appendChild(i);
		
		fm.submit();
	}
	 
	
	//결제금액받기 실행
	if(index==3){
		var division = parseInt(countNo)-1;
		var orderNo = document.getElementsByName("orderNo");
		var productOptionNo = document.getElementsByName("productOptionNo");
		var price = document.getElementsByName("discountedTotalPrice");
		var thisPrice = price[parseInt(division)].value;

		var discountedTotalPrice = thisPrice.substr(0,thisPrice.length-1);
		var endPrice = parseInt(discountedTotalPrice)*0.95*1000;
		var fee = parseInt(discountedTotalPrice)*0.05*1000;

		if (confirm("수수료 "+fee+"원을 제외한 "+endPrice+"원이 입금됩니다. \n계속하시겠습니까?") == true){
			alert("입금되었습니다!");
			
			var fm = document.createElement("form");
			
			fm.setAttribute("method", "post");
			fm.setAttribute("action", "updateOrderStat.do");
			document.body.appendChild(fm);
			
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "orderNo");
			i.setAttribute("value", orderNo[parseInt(division)].value);
			fm.appendChild(i);
			
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "orderStat");
			i.setAttribute("value",  6);
			fm.appendChild(i);
			
			fm.submit();
		}
	}
}

</script>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>

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
								<li><a><i class="fa fa-star"></i> 관리자 문의</a></li>
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
								<li class="dropdown"><a href="#">내상품관리<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                    	<li><a href="orderManagement.do">주문관리</a></li>
                                        <li><a href="allProductView.do">상품등록</a></li>
                                    </ul>
                                </li> 
								<!-- <li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="blog.jsp">Blog List</a></li>
										<li><a href="blog_single.jsp">Blog Single</a></li>
                                    </ul>
                                </li>  -->
								<!-- <li><a href="404.jsp">404</a></li> -->
								<li><a href="contact_us.do">Contact-us</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	</header><!--/header-->

<form name="cartDetailsForm" method="POST">
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="orderManagement.do">Home</a></li>
				  <li class="active">주문관리</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
			
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="info">주문일자<br>(주문번호)</td>
							<td class="image">이미지</td>
							<td class="description">상품정보<br>/옵션정보_재고수량</td>
							<td class="price">상품금액(수량)</td>
							<td class="stat">배송상태</td>
							<td class="stat">주문상태</td>
							<td class="delete">구매자ID<br>(구매자명)<br></td>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${list}" var="orderList" varStatus="status">
							<tr>
								<c:if test="${orderList.orderNoCount ne 0}">
									<td class="cart_info" rowspan="${orderList.orderNoCount}">
										<p><fmt:formatDate value="${orderList.orderTime}" pattern="yyyy-MM-dd"/><br>(${orderList.orderNo})</p>
									</td>
								</c:if>
								<td class="cart_image">
									<img src="images/product/<c:out value="${orderList.categoryNo}"/>/<c:out value="${orderList.productNo}"/>_1.jpg" alt="" />
								</td>
								<td class="cart_description">
									<h4>${orderList.name}</h4>
									<p></p>
									<p>/${orderList.productOptionName}_${orderList.productAmount}개</p>
								</td>
								<td class="cart_price">
									<p><fmt:formatNumber value="${orderList.totalPrice}"/>원(${orderList.buyAmount}개)</p>
								</td>
								<td class="cart_stat">
									<input type="hidden" id="${status.count}" name="orderNo" value="${orderList.orderNo}">
									<input type="hidden" id="${status.count}" name="productOptionNo" value="${orderList.productOptionNo}">
									<input type="hidden" id="${status.count}" name="discountedTotalPrice" value="${orderList.discountedTotalPrice}">
									<c:if test="${orderList.orderStat > 2}">
										<c:choose>
											<c:when test="${orderList.deliveryStat eq 1}">
												&nbsp;&nbsp;&nbsp;발송준비중
												<br>
												<button type="button" class="btn btn-fefault cart" id="${status.count}" name="delivery" value="${status.count}"onclick="mySubmit(this.form,2,this.value);">배송 요청</button>
											</c:when>
											<c:when test="${orderList.deliveryStat eq 2}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송중
											</c:when>
											<c:when test="${orderList.deliveryStat eq 3}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송완료
											</c:when>
										</c:choose>
									</c:if>
								</td>
								<c:if test="${orderList.orderNoCount ne 0}">
									<td class="cart_stat" rowspan="${orderList.orderNoCount}">
										<c:choose>
											<c:when test="${orderList.orderStat eq 1 and orderList.quantityCheck eq 1}">
													&nbsp;&nbsp;&nbsp;재고 부족<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 1 and orderList.quantityCheck ne 1}">
													&nbsp;&nbsp;&nbsp;${orderList.discountedTotalPrice}<br>입금대기중<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 2}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;결제완료<br>
												<input type="hidden" id="${status.count}" name="orderStat" value="${orderList.orderStat}">
												<button type="button" class="btn btn-fefault cart" id="${status.count}" name="deposit"value="${orderList.orderNo}"onclick="mySubmit(this.form,1,this.value);">입금확인하기</button>
											</c:when>
											<c:when test="${orderList.orderStat eq 3}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송준비중<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 4}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송중<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 5}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전체배송완료<br>
												<button type="button" class="btn btn-fefault cart" id="${status.count}" name="deposit"value="${status.count}"onclick="mySubmit(this.form,3,this.value);">결제금액받기</button>
											</c:when>
											<c:when test="${orderList.orderStat eq 6}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;결제금액 수금완료<br>
											</c:when>
										</c:choose>
									</td>
								</c:if>
								<c:if test="${orderList.orderNoCount ne 0}">
									<td class="cart_delete" rowspan="${orderList.orderNoCount}">
										${orderList.id}<br>(${orderList.userName})
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
		<img src="images/order/deliveryProcess.jpg" class="img-responsive" alt=""  align="middle" /><br><br><br><br>
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
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>