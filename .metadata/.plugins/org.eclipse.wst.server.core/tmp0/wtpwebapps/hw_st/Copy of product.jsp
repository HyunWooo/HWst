<%@page import="hwst.domain.ProductVo"%>
<%@page import="hwst.domain.CategoryVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
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
										<li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i> Cart</a></li>
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
								<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="allProductView.do">Products</a></li>
										<li><a href="product_details.do">Product Details</a></li> 
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
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											의류
										</a>
									</h4>
								</div>
								<div id="sportswear" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">남성의류 </a></li>
											<li><a href="#">여성의류 </a></li>
											<li><a href="#">유아의류 </a></li>
											<li><a href="#">스포츠용</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#mens">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											악세사리
										</a>
									</h4>
								</div>
								<div id="mens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">귀걸이</a></li>
											<li><a href="#">목걸이</a></li>
										</ul>
									</div>
								</div>
							</div>
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											디지털
										</a>
									</h4>
								</div>
								<div id="womens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">가전제품</a></li>
											<li><a href="#">컴퓨터</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">기타 잡화</a></h4>
								</div>
							</div>
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
							<img src="http://i.011st.com/ds/2015/06/16/635/495e5851754d0cb0d49924bfe87374da.jpg" alt="" /><br>
							<img src="http://i.011st.com/ds/2015/06/23/635/3969f1a36b8d710d43466a0f8022f231.jpg" alt="" />
							<!-- <img src="images/home/shipping.jpg" alt="" /> -->
						</div><!--/shipping-->
						
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">All New Item</h2>
						<%
						   final int ROWSIZE = 6;
						   final int BLOCK = 5;
						   int pg = 1;
						   if(request.getParameter("pg")!=null) {
						      pg = Integer.parseInt(request.getParameter("pg"));
						   }
						  /*  int start = (pg*ROWSIZE) - (ROWSIZE-1);
						   int end = (pg*ROWSIZE); */
						   int allPage = 0;
						   int startPage = ((pg-1)/BLOCK*BLOCK)+1;
						   int endPage = ((pg-1)/BLOCK*BLOCK)+BLOCK;
					
						   
							List<ProductVo> list = (List<ProductVo>)(session.getAttribute("productList"));
							allPage = (int)Math.ceil(list.size()/(double)ROWSIZE);
							                             
	                       if(endPage > allPage) {
	                          endPage = allPage;
	                       }
                       
                           int pageNum = 1;
	                       if(request.getParameter("pg") != null){
	                          if(request.getParameter("pg").equals("0")){
	                             pageNum = 1;
	                          }
	                          else{
	                             pageNum = Integer.parseInt(request.getParameter("pg"));
	                          }
	                       }
	                        
	                       ProductVo tempPro = null;
	                       if(list.size()>20){
	                           for(int i = (pageNum - 1) * 10; i < (pageNum * 10) - 1; i++)
	                           {
	                        		tempPro = list.get(i);
						%>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/product/product12.jpg" alt="" />
										<h2><%= tempPro.getBasicPrice() %></h2>
										<p>$<%= tempPro.getName() %></p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2><%=tempPro.getBasicPrice() %></h2>
											<p><%= tempPro.getName() %></p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
									</div>
								</div>
								 <div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href=""><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
						<% 
                                   }} else if(list.size()>7){
                               for(int i = (pageNum - 1) * 9; i < list.size() ; i++)
                               {
                                  tempPro = list.get(i);
                                  %>
						<!-- 여기까지가 상품 하나부분 -->
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/product/product12.jpg" alt="" />
										<h2><%= tempPro.getBasicPrice()%></h2>
										<p><%= tempPro.getName() %></p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2><%= tempPro.getBasicPrice()%></h2>
											<p><%= tempPro.getName() %></p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href=""><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
						<% 
                               }}else{
                                  for(int i = (pageNum - 1) * 10; i < list.size() ; i++)
                                  {
                                  tempPro = list.get(i);
                        %>
                        <div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/product/<%= tempPro.getCategoryNo() %>/<%= tempPro.getProductNo() %>_1.jpg" alt="" />
										<h2><%= tempPro.getBasicPrice() %>원</h2>
										<p><%= tempPro.getName() %></p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-search"></i>상품상세보기</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<p><%= tempPro.getDetails() %></p>
											<h2><%= tempPro.getBasicPrice() %>원</h2>
											<p><%= tempPro.getName() %></p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-search"></i>상품상세보기</a>
										</div>
									</div>
									<img src="images/home/new.png" class="new" alt="" />
								</div>
							</div>
						</div>
						<% 
                               }
                               }
                        %>
						
						
						
						<!-- <ul class="pagination">
							<li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul> -->
						<ul class="pagination pagination-lg">
                       <li><a href="product.do?pg=<%=startPage-1%>"><!-- <i class="fa fa-long-arrow-left"> --></i>Previous Page</a></li>
		                  <%
		                     for(int i=startPage; i<= endPage; i++){
		                        if(i==pg){
		                  %>
		                           <li class="active"><a href="product.do?pg=<%=i %>"><%=i %></a></li>
		                  <%
		                        }else{
		                  %>
		                           <li><a href="product.do?pg=<%=i %>"><%=i %></a></li>
		                  <%
		                        }
		                     }
		                  %>
	                   <li><a href="product.do?pg=<%=endPage+1%>">Next Page<!-- <i class="fa fa-long-arrow-right"></i> --></a></li>
                    </ul><!--/.pagination-->
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>
	
	<footer id="footer"><!--Footer-->
		<div class="footer-bottom">
			<div class="container">
					<div class="col-sm-6">
						<div class="single-widget">
							<p class="pull-left">Copyright © 2015 HW. All rights reserved.</p>
						</div>
					</div>
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