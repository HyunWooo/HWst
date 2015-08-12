<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<c:if test="${sessionScope.deleteCartStat eq true}">
		<script>
			alert("해당 장바구니 항목이 삭제되었습니다.");
			<%session.removeAttribute("deleteCartStat");%>
			window.location.reload();
		</script>
	</c:if>
	
	<c:if test="${sessionScope.updateCartAmountByCartNo eq true}">
		<script>
			alert("해당 장바구니정보의 수정이 완료되었습니다");
			<%session.removeAttribute("updateCartAmountByCartNo");%>
			window.location.reload();
		</script>
	</c:if>

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


//개별상품의 체크박스 선택시 총금액변경
function clickCheck(){
	var allTotalPrice = 0;
	var selectedCount = $("input[name=box]:checked").size();
	
	$("input[name=box]:checked").each(function() {
		  allTotalPrice= parseInt(allTotalPrice) +parseInt($(this).val());
		});
	$("input[name=selectedCount]").val(selectedCount+"개");
	$("input[name=allTotalPrice]").val(commaNum(allTotalPrice)+"원"); 
	
	var discountPercent =$("input[name=discountPercent]").val();
	var discountPrice= ((parseInt(discountPercent)/100) *parseInt(allTotalPrice));
	$("input[name=discountPrice]").val(commaNum(discountPrice)+"원");
	var discountedTotalPrice= (((100-parseInt(discountPercent))/100) *parseInt(allTotalPrice));
	$("input[name=discountedTotalPrice]").val(commaNum(discountedTotalPrice)+"원");
	
}	

//수량변경,선택주문하기,전체주문하기 submit 분기
function mySubmit(frm,index,countNo){
	var division = parseInt(countNo)-1;
	var cartNo = document.getElementsByName('cartNo');
	var buyAmount = document.getElementsByName('buyAmount');
	var productAmount = document.getElementsByName('productAmount');
	
	
	//수량 update 실행
	if(index==1){
		frm.updateBuyAmountStat.value = cartNo[parseInt(division)].value;//update하려는 해당 장바구니번호를 따로 저장
		
		if(buyAmount[parseInt(division)].value < 1){ //update할 상품의 수량이 0 이하일 경우 걸러줌
			alert("수량은 1 이상이어야 합니다");
			window.location.reload();
		}
		else if(parseInt(buyAmount[parseInt(division)].value) > parseInt(productAmount[parseInt(division)].value)){//update할 장바구니수량이 해당상품옵션의 재고보다 많을 경우를 체크
			alert("재고보다 많이 선택할 수는 없습니다");
			window.location.reload();
			
		}
		else{
			/* document.cartDetailsForm.action='updateCartAmountByCartNo.do';
			document.cartDetailsForm.submit(); */
			
			var fm = document.createElement("form");
			
			fm.setAttribute("method", "post");
			fm.setAttribute("action", "updateCartAmount.do");
			document.body.appendChild(fm);
			
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "cartNo");
			i.setAttribute("value", frm.updateBuyAmountStat.value);
			fm.appendChild(i);
			
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "buyAmount");
			i.setAttribute("value", buyAmount[parseInt(division)].value);
			fm.appendChild(i);
			
			fm.submit();
		}
	}
	
	//선택상품주문 실행
	if(index==2){
		var fm = document.createElement("form");
		
		fm.setAttribute("method", "post");
		fm.setAttribute("action", "selectBySelectedCartList.do");
		document.body.appendChild(fm);
		$("input[name=box]:checked").each(function(index) {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "cartNo");
			i.setAttribute("value",  $(this).attr("id") );
			fm.appendChild(i);
		});
		fm.submit();
	}
	 
	
	//전체상품주문 실행
	if(index==3){
		var fm = document.createElement("form");
		
		fm.setAttribute("method", "post");
		fm.setAttribute("action", "selectBySelectedCartList.do");
		document.body.appendChild(fm);
		
		$("input[name=box]").each(function(index) {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "cartNo");
			i.setAttribute("value",  $(this).attr("id") );
			fm.appendChild(i);
		});
		fm.submit();
	}
	
	//개별상품 주문하기버튼 클릭시 주문실행
	if(index==4){
		var fm = document.createElement("form");
		
		fm.setAttribute("method", "post");
		fm.setAttribute("action", "selectBySelectedCartList.do");
		document.body.appendChild(fm);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "cartNo");
		i.setAttribute("value", cartNo[parseInt(division)].value);
		fm.appendChild(i);
		fm.submit();
	}
	
	
	//해당장바구니 삭제
	if(index==5){
		var fm = document.createElement("form");
		
		fm.setAttribute("method", "post");
		fm.setAttribute("action", "deleteCart.do");
		document.body.appendChild(fm);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "cartNo");
		i.setAttribute("value", countNo);
		fm.appendChild(i);
		fm.submit();
	}
}

</script>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
<script text/javascript>

	$(document).ready(function() {
		 var allTotalPrice = 0;
         var selectedCount = $("input[name=box]:checked").size();
         
         //처음 화면 로딩 시 체크된 항목의 전체금액, 할인금액, 할인된총금액 산정
         $("input[name=box]:checked").each(function() {
       	  allTotalPrice= parseInt(allTotalPrice) +parseInt($(this).val());
			});
         $("input[name=selectedCount]").val(selectedCount+"개");
         $("input[name=allTotalPrice]").val(commaNum(allTotalPrice)+"원"); 
         
         var discountPercent =$("input[name=discountPercent]").val();
         var discountPrice= ((parseInt(discountPercent)/100) *parseInt(allTotalPrice));
         if(allTotalPrice==0){
        	 $("input[name=discountPrice]").val("0원");
        	 $("input[name=discountedTotalPrice]").val("0원");
         }
         else{
        	 $("input[name=discountPrice]").val(commaNum(discountPrice)+"원");
        	 var discountedTotalPrice= (((100-parseInt(discountPercent))/100) *parseInt(allTotalPrice));
             $("input[name=discountedTotalPrice]").val(commaNum(discountedTotalPrice)+"원");
         }
         
         
         
         
		// 체크 박스 모두 체크
		$("#checkAll").click(function() {
	          $( '.cart_check_input' ).prop( 'checked', this.checked);
	          
	          var allTotalPrice = 0;
	          var selectedCount = $("input[name=box]:checked").size();
	          
	          $("input[name=box]:checked").each(function() {
	        	  allTotalPrice= parseInt(allTotalPrice) +parseInt($(this).val());
				});
	          $("input[name=selectedCount]").val(selectedCount+"개");
	          $("input[name=allTotalPrice]").val(commaNum(allTotalPrice)+"원"); 
	          
	          var discountPercent =$("input[name=discountPercent]").val();
	          var discountPrice= ((parseInt(discountPercent)/100) *parseInt(allTotalPrice));
	          $("input[name=discountPrice]").val(commaNum(discountPrice)+"원");
	          var discountedTotalPrice= (((100-parseInt(discountPercent))/100) *parseInt(allTotalPrice));
	          $("input[name=discountedTotalPrice]").val(commaNum(discountedTotalPrice)+"원");
	          
		});
          
 		// 체크 되어 있는 값 추출
		$("#cartChecks").click(function() {
			$("input[name=box]:checked").each(function() {
				var test = $(this).val();
				console.log(test);
			});
		});
		
		// test case
		test1();

	});

	function test1() {

		console.log("################################################");
		console.log("## test1 START");
		console.log("################################################");

		var cnt = $("input:checkbox").size();
		console.log("checkboxSize=" + cnt);

		$("input[name=box]:checkbox").each(function() {
			var checkboxValue = $(this).val();
			console.log("checkboxValue=" + checkboxValue);
		});

		console.log("----------------------------------------------");

		$("#checkboxArea").children().each(function() {
			var checkboxValue = $(this).children(":checkbox").val();
			var text = $(this).children().eq(1).text();
			console.log(text + "=" + checkboxValue);
		});
	}
	

	
</script>

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

<form name="cartDetailsForm" method="POST">
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="index.do">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
			
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="check"><input type="checkbox" id="checkAll" value="check all" checked="checked" ></td>
							<td class="image">이미지</td>
							<td class="description">상품/옵션정보</td>
							<td class="price">상품가격</td>
							<td class="quantity">수량</td>
							<td class="total">개별상품 총가격</td>
							<td class="delete">주문</td>
						</tr>
					</thead>
					
					<tbody>
					<!-- 장바구니 리스트 출력 -->
						<c:forEach items="${list}" var="cartList" varStatus="status">
							<tr>
								<td class="cart_check">
								<c:if test="${cartList.productAmount ne 0}">
									<input class="cart_check_input" type="checkbox" name="box" id="${cartList.cartNo}"  onclick="clickCheck();" checked="checked" value="${cartList.eachPrice * cartList.buyAmount}"/>
								</c:if>
								</td>
								<td class="cart_image">
									<a href="viewProductDetails.do?productNo=<c:out value="${cartList.productNo}"/>"><img src="images/product/<c:out value="${cartList.categoryNo}"/>/<c:out value="${cartList.productNo}"/>_1.jpg" alt="" /></a>
								</td>
								<td class="cart_description">
									<h4><a href="viewProductDetails.do?productNo=<c:out value="${cartList.productNo}"/>">${cartList.name}</a></h4>
									<p></p>
									<p>/${cartList.productOptionName}_재고 : ${cartList.productAmount}개</p>
								</td>
								<td class="cart_price">
									<p><fmt:formatNumber value="${cartList.eachPrice}"/>원</p>
								</td>
								<td class="cart_quantity">
									&nbsp;&nbsp;&nbsp;&nbsp;<input class="cart_quantity_input" type="number" name="buyAmount" id="${cartList.categoryNo}" value="${cartList.buyAmount}" autocomplete="off"  min="1" max="${cartList.productAmount}">
									<c:if test="${cartList.productAmount ne 0}">
									<hr>
									<button type="button" class="btn btn-fefault cart" name="updateButton"value="${status.count}"onclick="mySubmit(this.form,1,this.value);">변경</button>
									</c:if>
								</td>
								<td class="cart_total">
									<p class="cart_total_price"><fmt:formatNumber value="${cartList.eachPrice * cartList.buyAmount}"/>원</p>
								</td>
								<td class="cart_delete">
									<c:if test="${cartList.productAmount eq 0}">
									&nbsp;&nbsp;&nbsp;&nbsp;품절
									</c:if>
									<c:if test="${cartList.productAmount ne 0}">
									<button class="cart_delete_button" type='button' name='eachOrder' value='${status.count}' onClick='mySubmit(this.form,4,this.value);'>주문하기</button>
									</c:if>
									<hr>
									<input type="hidden" name="cartNo" value="${cartList.cartNo}">
									<input type="hidden" name="totalPrice" value="${cartList.eachPrice * cartList.buyAmount}">
									<input type="hidden" name="discountPercent" value="${sessionScope.userLoginInfo.discountPercent}"/>
									<input type="hidden" name="productAmount" value="${cartList.productAmount}"/>
									<button class="cart_delete_button" type='button' name='delButton' value='${cartList.cartNo}' onClick='mySubmit(this.form,5,this.value);'>삭제</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input type="hidden" name="updateBuyAmountStat" />
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="col-sm-8">
						<table class="table table-condensed total-result">
							<tr>
								<td>선택한 장바구니 개수</td>
								<td><input type="text" name = "selectedCount" value="0개" readonly></td>
							</tr>
							<tr>
								<td>주문금액</td>
								<td><input type="text" name="allTotalPrice" value="0원" readonly></td>
							</tr>
							<tr>
								<td>등급 할인금액</td> 
								<td><input type="text" name="discountPrice" value="0원" readonly></td>
							</tr>
							<tr>
								<td>결제예정금액</td> 
								<td><input type="text" name="discountedTotalPrice" value="0원" readonly></td>
							</tr>
						</table>
						<br><a class="btn btn-default update" href="javascript:history.back(-1)">뒤로가기</a>
						<a class="btn btn-default check_out" onclick="mySubmit(this.form,2,this.value);">선택상품주문</a>
						<a class="btn btn-default check_out" onclick="mySubmit(this.form,3,this.value);">전체주문</a>
			</div>
		</div>
	</section><!--/#do_action-->
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