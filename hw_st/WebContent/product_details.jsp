<%@page import="hwst.domain.ProductVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8");%>

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

<script type="text/javascript" charset='utf-8'>
function getSelectValue(frm)
{
	if(frm.selectBox.options[frm.selectBox.selectedIndex].id == 0){
		alert("품절된 상품옵션은 구매하실 수 없습니다.");
		frm.discountedTotalPrice.value = null;
	}else if(frm.selectBox.options[frm.selectBox.selectedIndex].id == -1){
		frm.discountedTotalPrice.value = null;
	}
	 else{
		 var obj = document.getElementsByName('productOne'); //'productOne' 을 포함한 Tag들을 찾아서 배열로 만들어준다.
	     //alert(obj[0].id);
	     var i= obj.length ;
	     var optionText = $("#list option:selected").text();
	     var optionNum = frm.selectBox.selectedIndex;
	     var eachPrice = document.getElementsByName('eachPrice');
	     var quantity = document.getElementsByName('quantity');
	     var productOne = document.getElementsByName('productOne');
	     var eachPrice2 = ((parseInt(frm.selectBox.options[frm.selectBox.selectedIndex].value) + parseInt(frm.basicPrice.value)))+"원";
	     var span = document.createElement('span');
	     var pass;
	     alert(productOne.length);
	     for(var k=0; k <= productOne.length ;k++){
	    	 if(productOne[k].id==frm.selectBox.selectedIndex){
	    		alert("이미 선택된 옵션항목입니다.");
	    		pass='false';
	    	 }else{
	    		pass='true';
	    	 }
		 }
	     alert(pass);
	     if(pass=='true'){
	     span.innerHTML =document.getElementById('myTable').innerHTML
	     	+ "<input type='text' size='40' name='productOne' id='"+optionNum+"' value='" +optionText+"'>"
		   	+ "<button type='button'  name='cart_quantity_down' id='cart_quantity_down' value='"+i+"' onclick='minusQuantity(this.form,this.value);''> - </button>"
		   	+"<input class='cart_quantity_input' type='text' name='quantity' value='1' readonly>"
			+"<button type='button' name='cart_quantity_up' id='cart_quantity_up' value='"+i+"' onclick='plusQuantity(this.form,this.value);''> + </button>"
			+ "<input type='text' name='eachPrice' value='"+eachPrice2+"'readonly>"
			+"<button type='button' name='delButton' value='"+i+"' onClick='del(this.form,this.value);'>x</button>";
	        document.getElementById('field').appendChild(span);
	       frm.totalPrice.value = parseInt(frm.totalPrice.value) + parseInt(eachPrice2) +"원";	
	     }
	        
	   /*   document.getElementById('myTable').innerHTML = document.getElementById('myTable').innerHTML
	     	+ "<input type='text' size='40' name='productOne' value='" +optionText+"'>"
		   	+ "<button type='button'  name='cart_quantity_down' id='cart_quantity_down' value='"+i+"' onclick='minusQuantity(this.form,this.value);''> - </button>"
		   	+"<input class='cart_quantity_input' type='text' name='quantity' value='1' readonly>"
			+"<button type='button' name='cart_quantity_up' id='cart_quantity_up' value='"+i+"' onclick='plusQuantity(this.form,this.value);''> + </button>"
			+ "<input type='text' name='eachPrice' value='"+eachPrice2+"'readonly>"
			+"<button type='button' name='delButton' value='"+i+"' onClick='del(this.form,this.value);'>x</button>"; */
		
		
		/* frm.totalPrice.value = ((parseInt(frm.selectBox.options[frm.selectBox.selectedIndex].value) + parseInt(frm.basicPrice.value))*parseInt(frm.quantity.value))+"원"; */
		/*  if(frm.discountPercent.value != null){
			frm.discountPrice.value = -(parseInt(frm.totalPrice.value)*((parseInt(frm.discountPercent.value))/100)*parseInt(frm.quantity.value))+"원";
			frm.discountedTotalPrice.value = (parseInt(frm.totalPrice.value)*((100-parseInt(frm.discountPercent.value))/100)*parseInt(frm.quantity.value))+"원";
		 }
		 else{
			 frm.discountedTotalPrice.value = (parseInt(frm.totalPrice.value)*parseInt(frm.quantity.value))+"원";
		 } */
	 }
}

function del(frm,id){
	 	var obj = document.getElementsByName('productOne');
	   var delButton = document.getElementsByName('delButton');
	   var quantity = document.getElementsByName('quantity');
	   var cart_quantity_down = document.getElementsByName('cart_quantity_down');
	   var cart_quantity_up = document.getElementsByName('cart_quantity_up');
	   var eachPrice = document.getElementsByName('eachPrice');
	   var eachPrice3 = eachPrice[id].value;
	   frm.totalPrice.value = parseInt(frm.totalPrice.value) - parseInt(eachPrice3) +"원";
	   obj[id].outerHTML="";
	   delButton[id].outerHTML="";
	   quantity[id].outerHTML="";
	   cart_quantity_down[id].outerHTML="";
	   cart_quantity_up[id].outerHTML="";
	   eachPrice[id].outerHTML="";
	 
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

function plusQuantity(frm,id){
/* 	alert($("#list option:selected").text());
	alert($("#list option:selected").val()); */
	var quantity = document.getElementsByName('quantity');
	var eachPrice = document.getElementsByName('eachPrice');
/* 	alert(frm);
	alert(frm.productOne.value);
	alert(frm.quantity.value); */
	if(frm.selectBox.options[frm.selectBox.selectedIndex].id == -1){
		alert("상품옵션을 먼저 선택해주세요");
	}
	else{
		quantity[id].value = parseInt(quantity[id].value) +1;
		eachPrice[id].value = ((parseInt(frm.selectBox.options[frm.selectBox.selectedIndex].value) + parseInt(frm.basicPrice.value))*parseInt(quantity[id].value))+"원";
		frm.totalPrice.value = parseInt(frm.totalPrice.value) + (parseInt(frm.selectBox.options[frm.selectBox.selectedIndex].value) + parseInt(frm.basicPrice.value)) +"원";
		
		/*  if(frm.discountPercent.value != null){
			frm.discountPrice.value = -(parseInt(frm.totalPrice.value)*((parseInt(frm.discountPercent.value))/100))+"원";
			frm.discountedTotalPrice.value = (parseInt(frm.totalPrice.value)*((100-parseInt(frm.discountPercent.value))/100))+"원";
		 }
		 else{
			 frm.discountedTotalPrice.value = (parseInt(frm.totalPrice.value)*parseInt(frm.quantity.value))+"원";
		 } */
	}
}

function minusQuantity(frm,id){
	var quantity = document.getElementsByName('quantity');
	var eachPrice = document.getElementsByName('eachPrice');
	
	if(frm.selectBox.options[frm.selectBox.selectedIndex].id == -1){
		alert("상품옵션을 먼저 선택해주세요");
	}
	else{
		if(quantity[id].value >1){
			quantity[id].value = parseInt(quantity[id].value) -1;
			eachPrice[id].value = ((parseInt(frm.selectBox.options[frm.selectBox.selectedIndex].value) + parseInt(frm.basicPrice.value))*parseInt(quantity[id].value))+"원";
			
			frm.totalPrice.value = parseInt(frm.totalPrice.value) - ((parseInt(frm.selectBox.options[frm.selectBox.selectedIndex].value) + parseInt(frm.basicPrice.value)))+"원";
			 
			/*  if(frm.discountPercent.value != null){
				frm.discountPrice.value = -(parseInt(frm.totalPrice.value)*((parseInt(frm.discountPercent.value))/100)*parseInt(frm.quantity.value))+"원";
				frm.discountedTotalPrice.value = (parseInt(frm.totalPrice.value)*((100-parseInt(frm.discountPercent.value))/100)*parseInt(frm.quantity.value))+"원";
			 }
			 else{
				 frm.discountedTotalPrice.value = (parseInt(frm.totalPrice.value)*parseInt(frm.quantity.value))+"원";
			 } */
		}
		else{
			alert("수량은 0 이하일 수 없습니다.");
		}
	}
}

</script>

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
										<li><a href="cart.do"><i class="fa fa-shopping-cart"></i> Cart</a></li>
										<li><a href= "userManagement.do"><i class="fa fa-user"></i>${sessionScope.userLoginInfo.name}님</a></li>
										<li><a href="logoutProcess.do"><i class="fa fa-crosshairs"></i> Logout</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="chooseSignup.do"><i class="fa fa-pencil"></i> Sign Up</a></li>
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
							<a href="index.do"><img src="images/home/logo.png" alt="" /></a>
						</div>
						<!-- 안쓰는 버튼그룹 -->
						<div class="btn-group pull-right">
							<!-- <div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									USA
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canada</a></li>
									<li><a href="#">UK</a></li>
								</ul>
							</div>
							
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									DOLLAR
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canadian Dollar</a></li>
									<li><a href="#">Pound</a></li>
								</ul>
							</div> -->
						</div>
					</div>
					<div class="col-sm-8">
						<div class="search_box pull-right">
							 <form action="selectProductByKeyword.do"  name="selectProductByKeyword.do" method="post">
	                             <input type="text" placeholder="Search" id="keyword"  name = "keyword" autocomplete="off"/>
                             </form>
						</div>
						<div class="mainmenu pull-right">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.do" class="active">Home</a></li>
								<li class="dropdown"><a href="allProductView.do">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="allProductView.do">상품전체보기</a></li>
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
					
						<!-- <div class="brands_products">brands_products
							<h2>Brands</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<li><a href=""> <span class="pull-right">(50)</span>Acne</a></li>
									<li><a href=""> <span class="pull-right">(56)</span>Grüne Erde</a></li>
									<li><a href=""> <span class="pull-right">(27)</span>Albiro</a></li>
									<li><a href=""> <span class="pull-right">(32)</span>Ronhill</a></li>
									<li><a href=""> <span class="pull-right">(5)</span>Oddmolly</a></li>
									<li><a href=""> <span class="pull-right">(9)</span>Boudestijn</a></li>
									<li><a href=""> <span class="pull-right">(4)</span>Rösch creative culture</a></li>
								</ul>
							</div>
						</div>/brands_products
						
						<div class="price-range">price-range
							<h2>Price Range</h2>
							<div class="well">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b>$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div>/price-range -->
						
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
							<div id="similar-product" class="carousel slide" data-ride="carousel">
								
								  <!-- Wrapper for slides -->
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

								  <!-- Controls -->
								  <a class="left item-control" href="#similar-product" data-slide="prev">
									<i class="fa fa-angle-left"></i>
								  </a>
								  <a class="right item-control" href="#similar-product" data-slide="next">
									<i class="fa fa-angle-right"></i>
								  </a>
							</div>

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="images/product-details/new.jpg" class="newarrival" alt="" />
								<h2>${product.name}</h2>
								<p>상품번호: ${product.productNo}</p>
								<img src="images/product-details/rating.png" alt="" /><br>
								<span>
									<span>${product.basicPrice}원</span>
									<!-- <label>수량:</label>
									<input type="text" value="3" /> -->
								</span>
								<form action="">
									<button type="button" class="btn btn-fefault cart">
											<i class="fa fa-shopping-cart"></i>
											장바구니 담기
									</button>
									<button type="button" class="btn btn-fefault cart">
											<i class="fa fa-won"></i>
											주문하기
									</button>
								</form>	
								<a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
								<ul class="user_info">
									<li class="single_field">
										<form name="form">
													<label>옵션 선택</label>
													<select name="selectBox" id="list" onchange="getSelectValue(this.form);" >
															<option id="-1">선택하세요</option>
														<c:forEach items="${productOptionList}" var="productOptionList" >
															<option id="${productOptionList.productAmount}" value="${productOptionList.addPrice}">${productOptionList.optionProcedure}.${productOptionList.productOptionName}(+${productOptionList.addPrice}원)
															<c:if test="${productOptionList.productAmount > 0}">_재고수량: ${productOptionList.productAmount}개</c:if>
															<c:if test="${productOptionList.productAmount eq 0}">_재고수량: 품절</c:if>
															</option>
														</c:forEach>
													</select>
											<input type="hidden" name="basicPrice" value="${product.basicPrice}"/>
											<input type="hidden" name="discountPercent" value="${sessionScope.userLoginInfo.discountPercent}"/>
											
											<!-- <label>수량 선택</label>
											<div class="cart_quantity_button">
												<button type="button"  id="cart_quantity_down" onclick="minusQuantity(this.form);"> - </button>
												<input class="cart_quantity_input" type="text" name="quantity" value="1" readonly>
												<button type="button" id="cart_quantity_up" onclick="plusQuantity(this.form);"> + </button>
											</div> -->
												
											<span id="myTable" style="border:5 dotted #ff0000;">
											</span>
											
											<span id="field"></span>
											<span>
												<span>총금액 <input type="text" name="totalPrice" value="0원" readonly></span>
												<c:if test="${not empty sessionScope.userLoginInfo}">
														<span>등급 할인금액 <input type="text" name="discountPrice" readonly></span>
														<span>할인된 총금액 <input type="text" name="discountedTotalPrice" readonly></span>
												</c:if>
											</span>
										</form>
									</li>
								</ul>
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
					
					<div class="recommended_items"><!--recommended_items-->
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
					</div><!--/recommended_items-->
					
				</div>
			</div>
		</div>
	</section>
	
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