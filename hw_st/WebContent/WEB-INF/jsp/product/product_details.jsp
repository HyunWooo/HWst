<%@page import="hwst.domain.product.ProductVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<c:if test="${sessionScope.insertCartStat eq true}">
		<%session.removeAttribute("insertCartStat");%>
		<script>
			<%session.removeAttribute("insertCartStat");%>
			window.location.reload();
			
			if (confirm("장바구니가 추가되었습니다. \n장바구니 목록을 확인하시겠습니까?")){    //확인
				location.href = "allCartView.do";
			}
			else{
				<%session.removeAttribute("insertCartStat");%>
				window.location.reload();
			}
			
		</script>
	</c:if>
	
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

<script type="text/javascript" charset='utf-8'>

//숫자포맷변경
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

//상품옵션선택시 라인추가 및 금액 변경
function getSelectValue(frm)
{
	if(frm.selectBox.options[frm.selectBox.selectedIndex].id == 0){
		alert("품절된 상품옵션은 구매하실 수 없습니다.");
	}
	
	else if(frm.selectBox.options[frm.selectBox.selectedIndex].id == -1){
	}
	
	else{
		 var productOne = document.getElementsByName('productOne'); //'productOptionNo' 을 포함한 Tag들을 찾아서 배열로 만들어준다.
	     //alert(obj[0].id);
	     var i= productOne.length ;
	     var productOptionNo= $("#list option:selected").text();
	     var optionText = frm.selectBox.options[frm.selectBox.selectedIndex].label;
	     var optionProcedure = frm.selectBox.selectedIndex;
	     var eachPrice2 = ((parseInt(frm.selectBox.options[frm.selectBox.selectedIndex].value) + parseInt(frm.basicPrice.value)))+"원";
	     var span = document.createElement('span');
	     var pass = 'true';
 	    
	     
	     for(var k=0; k < productOne.length ;k++){
	    	 if(productOne[k].id==frm.selectBox.selectedIndex){
	    		alert("이미 선택된 옵션항목입니다.");
	    		pass='false';
	    		break;
	    	 }else{
	    		pass='true';
	    	 }
		 }
	
	     
	     if(pass=='true'){
	     span.innerHTML =document.getElementById('myTable').innerHTML
	     	+ "<input type='text' size='40' name='productOne' id='"+optionProcedure+"' value='" +optionText+"' readonly>"
	     	+ "<input type='hidden' name='productOptionNo' id='"+productOptionNo+"' value='" +productOptionNo+"'>"
		   	+ "<button type='button'  name='cart_quantity_down' id='cart_quantity_down' value='"+i+"' onclick='minusQuantity(this.form,this.value);''> - </button>"
		   	+"<input class='cart_quantity_input' type='text' name='buyAmount' value='1' readonly>"
			+"<button type='button' name='cart_quantity_up' id='cart_quantity_up' value='"+i+"' onclick='plusQuantity(this.form,this.value);''> + </button>"
			+ "<input type='text' name='eachPrice' value= '"+eachPrice2+"'readonly>"
			+"<button type='button' name='delButton' value='"+i+"' onClick='del(this.form,this.value);'>x</button>";
	        document.getElementById('field').appendChild(span);
	       frm.totalPrice.value = parseInt(frm.totalPrice.value) + parseInt(eachPrice2) +"원";	
	     }
	     
	     
		 if(frm.discountPercent.value != -1){
			frm.discountPrice.value = -(parseInt(frm.totalPrice.value)*((parseInt(frm.discountPercent.value))/100))+"원";
			frm.discountedTotalPrice.value = parseInt(frm.totalPrice.value) + parseInt(frm.discountPrice.value)+"원";
		 }
	}
}

//선택한 상품옵션 삭제
function del(frm,vals){
	   var obj = document.getElementsByName('productOne');
	   var productOptionNo = document.getElementsByName('productOptionNo');
	   var delButton = document.getElementsByName('delButton');
	   var quantity = document.getElementsByName('buyAmount');
	   var cart_quantity_down = document.getElementsByName('cart_quantity_down');
	   var cart_quantity_up = document.getElementsByName('cart_quantity_up');
	   var eachPrice = document.getElementsByName('eachPrice');
	   var eachPrice3 = eachPrice[vals].value;
	   
	   frm.totalPrice.value = parseInt(frm.totalPrice.value) - parseInt(eachPrice3) +"원";

	   
	   if(frm.discountPercent.value != -1){
			frm.discountPrice.value = -(parseInt(frm.totalPrice.value)*((parseInt(frm.discountPercent.value))/100))+"원";
			frm.discountedTotalPrice.value = parseInt(frm.totalPrice.value) + parseInt(frm.discountPrice.value)+"원";
		 }
	   
	   productOptionNo[vals].outerHTML="";
	   obj[vals].outerHTML="";
	   delButton[vals].outerHTML="";
	   quantity[vals].outerHTML="";
	   cart_quantity_down[vals].outerHTML="";
	   cart_quantity_up[vals].outerHTML="";
	   eachPrice[vals].outerHTML="";
	 
	 //삭제한뒤 다시한번 현재 남은 inputbox의 값을 읽어서 다시 재설정 해준다.
	    delButton = document.getElementsByName('delButton'); 
		cart_quantity_down = document.getElementsByName('cart_quantity_down');
		cart_quantity_up = document.getElementsByName('cart_quantity_up');
	    for(var k=0; k < delButton.length ;k++){
	      delButton[k].value= k;
	      cart_quantity_down[k].value= k;
	      cart_quantity_up[k].value= k;
	    }
	}


//수량 더하기
function plusQuantity(frm,vals){
	var quantity = document.getElementsByName('buyAmount');
	var eachPrice = document.getElementsByName('eachPrice');
	var productOne = document.getElementsByName('productOne');
	
	
	/* 재고수량 판단 */
	if(parseInt(frm.selectBox.options[productOne[vals].id].id) > parseInt(quantity[vals].value)){
		quantity[vals].value = parseInt(quantity[vals].value) +1;
		eachPrice[vals].value = parseInt(eachPrice[vals].value) + parseInt(frm.selectBox.options[productOne[vals].id].value) + parseInt(frm.basicPrice.value) + "원";
		frm.totalPrice.value = parseInt(frm.totalPrice.value) + (parseInt(frm.selectBox.options[productOne[vals].id].value) + parseInt(frm.basicPrice.value)) +"원";
	
		
		  if(frm.discountPercent.value != -1){
			frm.discountPrice.value = -(parseInt(frm.totalPrice.value)*((parseInt(frm.discountPercent.value))/100))+"원";
			frm.discountedTotalPrice.value = (parseInt(frm.totalPrice.value)*((100-parseInt(frm.discountPercent.value))/100))+"원";
		 }
	}
	
	else{
		alert("재고수량이 부족합니다");
	}
	
}

//수량 빼기
function minusQuantity(frm,vals){
	var quantity = document.getElementsByName('buyAmount');
	var eachPrice = document.getElementsByName('eachPrice');
	var productOne = document.getElementsByName('productOne');
	
		if(quantity[vals].value >1){
			quantity[vals].value = parseInt(quantity[vals].value) -1;
			eachPrice[vals].value =  parseInt(eachPrice[vals].value) - parseInt(frm.selectBox.options[productOne[vals].id].value) - parseInt(frm.basicPrice.value) + "원";
			
			frm.totalPrice.value = parseInt(frm.totalPrice.value) - (parseInt(frm.selectBox.options[productOne[vals].id].value) + parseInt(frm.basicPrice.value)) +"원";
			 
			  if(frm.discountPercent.value != -1){
				frm.discountPrice.value = -(parseInt(frm.totalPrice.value)*((parseInt(frm.discountPercent.value))/100))+"원";
				frm.discountedTotalPrice.value = (parseInt(frm.totalPrice.value)*((100-parseInt(frm.discountPercent.value))/100))+"원";
			 }
			}
			else{
				alert("수량은 0 이하일 수 없습니다.");
			}
}


//하나의 FORM에서 2개의 SUBMIT 발생 - 장바구니담기와 상품주문 분기
function mySubmit(frm,index){
	if(frm.productOne == null){
		alert("상품옵션을 선택해주세요");
	}
	else{
		if(index==1){
			if(frm.userNo.value != -1){	
				document.productDetailsForm.action='insertCart.do';
				document.productDetailsForm.submit();
			}
			else{
				alert("로그인 후 이용하실 수 있습니다.");
				location.href='login.do';
			}
		}
		if(index==2){
			if(frm.userNo.value != -1){
				document.productDetailsForm.action='selectProductOptionByPoNo.do';
				document.productDetailsForm.submit();
			}
			else{
				alert("로그인 후 이용하실 수 있습니다.");
				location.href='login.do';
			}
		}
	}
}


/*
 * path : 전송 URL
 * params : 전송 데이터 {'q':'a','s':'b','c':'d'...}으로 묶어서 배열 입력
 * method : 전송 방식(생략가능)
 */
/* function post_to_url(path, params, method) {
    method = method || "post"; // Set method to post by default, if not specified.
    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);
    for(var key in params) {
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", key);
        hiddenField.setAttribute("value", params[key]);
        form.appendChild(hiddenField);
    }
    document.body.appendChild(form);
    form.submit();
} */
</script>

<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>
	<!-- /header -->
	
	<section id="advertisement">
		<div class="container">
			<!-- <img src="images/product/advertisement.jpg" alt="" /> -->
			<img src="http://i.011st.com/browsing/banner/2015/06/22/11641/2015062209092255388_8674945_1.jpg" alt="" />
			
		</div>
	</section>
	
	<!-- 카테고리 jstl -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
						<c:forEach items="${sessionScope.upCategoryList}" var="list" varStatus="status">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<c:if test="${status.last eq false}" >
										<a data-toggle="collapse" data-parent="#accordian" href="#<c:out value="${list.categoryName}"/>">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											<c:out value="${list.categoryName}"/>
										</a>
									</c:if>
									<c:if test="${status.last eq true}" >
										<a href="#"><c:out value="${list.categoryName}"/></a>
									</c:if>
									</h4>
								</div>
								<div id="<c:out value="${list.categoryName}"/>" class="panel-collapse collapse">
									<div class="panel-body">
										<c:forEach items="${sessionScope.categoryList}" var="list2" >
										<c:if test="${list.categoryNo eq list2.upCategoryNo}" >
										<ul>
											<li><a href="selectProductByCategory.do?categoryNo=<c:out value="${list2.categoryNo}"/>"><c:out value="${list2.categoryName}"/></a></li>
										</ul>
										</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
						</c:forEach>
						</div><!--/category-products-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
						
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="images/product/<c:out value="${product.categoryNo}"/>/<c:out value="${product.productNo}"/>_1.jpg" alt="" />
							</div>
							<!-- <div id="similar-product" class="carousel slide" data-ride="carousel">
								
								  Wrapper for slides
								    <div class="carousel-inner">
										<div class="item active">
										  <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
										  <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
										  <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
										</div>
										<div class="item">
										  <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
										  <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
										  <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
										</div>
										<div class="item">
										  <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
										  <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
										  <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
										</div>
										
									</div>

								  Controls
								  <a class="left item-control" href="#similar-product" data-slide="prev">
									<i class="fa fa-angle-left"></i>
								  </a>
								  <a class="right item-control" href="#similar-product" data-slide="next">
									<i class="fa fa-angle-right"></i>
								  </a>
							</div> -->

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="images/product-details/new.jpg" class="newarrival" alt="" />
								<h2>${product.name}</h2>
								<p>상품번호: ${product.productNo}</p>
								<!-- <img src="images/product-details/rating.png" alt="" /> --><br>
								<span>
									<span><fmt:formatNumber value="${product.basicPrice}"/>원</span>
									<!-- <label>수량:</label>
									<input type="text" value="3" /> -->
								</span>
								<form name="productDetailsForm" method="POST">
									<button type="button" class="btn btn-fefault cart" onclick="mySubmit(this.form,1);">
											<i class="fa fa-shopping-cart"></i>
											장바구니 담기
									</button>
									<button type="button" class="btn btn-fefault cart" onclick="mySubmit(this.form,2);">
											<i class="fa fa-won"></i>
											주문하기
									</button>
									<!-- <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a> -->
									<ul class="user_info">
										<li class="single_field">
											<label>옵션 선택</label>
											<select name="selectBox" id="list" onchange="getSelectValue(this.form);" >
													<option id="-1">선택하세요</option>
												<c:forEach items="${productOptionList}" var="productOptionList" >
													<option id="${productOptionList.productAmount}" label="${productOptionList.optionProcedure}.${productOptionList.productOptionName}(+<fmt:formatNumber value="${productOptionList.addPrice}"/>원)<c:if test="${productOptionList.productAmount > 0}">_재고수량: ${productOptionList.productAmount}개</c:if><c:if test="${productOptionList.productAmount eq 0}">_재고수량: 품절</c:if>" 
													value="${productOptionList.addPrice}">${productOptionList.productOptionNo}
													</option>
												</c:forEach>
											</select>
											<input type="hidden" name="basicPrice" value="${product.basicPrice}"/>
											<c:if test='${empty sessionScope.userLoginInfo.discountPercent}'>
												<input type="hidden" name="discountPercent" value="-1"/>
												<input type="hidden" name="userNo" value="-1"/>
											</c:if>
											<c:if test='${not empty sessionScope.userLoginInfo.discountPercent}'>
												<input type="hidden" name="discountPercent" value="${sessionScope.userLoginInfo.discountPercent}"/>
												<input type="hidden" name="userNo" value="${sessionScope.userLoginInfo.userNo}"/>
											</c:if>
											<span id="myTable"></span>
											<span id="field"></span>
											<span>
												총금액 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="text" name="totalPrice" value="0원" readonly><br>
												<c:if test="${not empty sessionScope.userLoginInfo}">
														등급 할인금액 <input type="text" name="discountPrice" value="0원" readonly><br>
														할인된 총금액 <input type="text" name="discountedTotalPrice" value="0원" readonly>
												</c:if>
											</span>
										</li>
									</ul>
								</form>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
					
					<div class="category-tab shop-details-tab"><!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#details" data-toggle="tab">상품상세정보</a></li>
								<li><a href="#companyprofile" data-toggle="tab">판매자정보</a></li>
								<li><a href="#tag" data-toggle="tab">Q&A</a></li>
								<li><a href="#reviews" data-toggle="tab">상품평 (5)</a></li>
							</ul>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="details" >
								${product.details}
							</div>							
							<div class="tab-pane fade" id="companyprofile" >
								<div class="total_area">
									<ul>
										<li>판매자명 : <span>${sellerInfo.name}</span></li>
										<li>판매자 연락처 : <span>${sellerInfo.phone}</span></li>
										<li>우편번호 : <span>${sellerInfo.postCode}</span></li>
										<li>주소 : <span>${sellerInfo.address}</span></li>
									</ul>
								</div>
							</div>
							
							<div class="tab-pane fade" id="tag" >
								<div class="col-sm-12">
									<ul>
										<li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
										<li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
										<li><a href=""><i class="fa fa-calendar-o"></i>31 DEC 2014</a></li>
									</ul>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
									<p><b>Write Your Review</b></p>
									
									<form action="#">
										<span>
											<input type="text" placeholder="Your Name"/>
											<input type="email" placeholder="Email Address"/>
										</span>
										<textarea name="" ></textarea>
										<b>Rating: </b> <img src="images/product-details/rating.png" alt="" />
										<button type="button" class="btn btn-default pull-right">
											Submit
										</button>
									</form>
								</div>
							</div>
							
							<div class="tab-pane fade" id="reviews" >
								<div class="col-sm-12">
									<ul>
										<li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
										<li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
										<li><a href=""><i class="fa fa-calendar-o"></i>31 DEC 2014</a></li>
									</ul>
									<p>짱 좋아요</p>
									<p><b>Write Your Review</b></p>
									
									<form action="#">
										<span>
											<input type="text" placeholder="Your Name"/>
											<input type="email" placeholder="Email Address"/>
										</span>
										<textarea name="" ></textarea>
										<b>Rating: </b> <img src="images/product-details/rating.png" alt="" />
										<button type="button" class="btn btn-default pull-right">
											Submit
										</button>
									</form>
								</div>
							</div>
							
						</div>
					</div><!--/category-tab-->
					
					<!-- <div class="recommended_items">recommended_items
						<h2 class="title text-center">recommended items</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">	
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="images/home/recommend1.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="images/home/recommend2.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="images/home/recommend3.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="item">	
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="images/home/recommend1.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="images/home/recommend2.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="images/home/recommend3.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div>/recommended_items -->
					
				</div>
			</div>
		</div>
	</section>
	
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