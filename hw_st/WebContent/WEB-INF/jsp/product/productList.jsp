<%@page import="hwst.domain.product.ProductVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
						<c:choose>
							<c:when test="${sessionScope.productViewStat eq 'all'}">
								<h2 class="title text-center">상품 전체보기</h2>
							</c:when>
							<c:when test="${sessionScope.productViewStat eq 'searchKeyword'}">
								<h2 class="title text-center">검색된 상품보기</h2>
							</c:when>
							<c:when test="${sessionScope.productViewStat eq 'searchCategory'}">
								<h2 class="title text-center">해당 카테고리 상품보기</h2>
							</c:when>
						</c:choose>
						
                        <c:forEach items="${list}" var="list" > 
						<%-- <c:forEach items="${sessionScope.productList}" var="list" >   --%>
                        <div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/product/<c:out value="${list.categoryNo}"/>/<c:out value="${list.productNo}"/>_1.jpg" alt="" />
										<h2><fmt:formatNumber value="${list.basicPrice}"/>원</h2>
										<p><c:out value="${list.name}"/></p>
										<a href="viewProductDetails.do?productNo=<c:out value="${list.productNo}"/>" class="btn btn-default add-to-cart"><i class="fa fa-search"></i>상품상세보기</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<p><c:out value="${list.details}"/></p>
											<h2><fmt:formatNumber value="${list.basicPrice}"/>원</h2>
											<p><c:out value="${list.name}"/></p>
											<a href="viewProductDetails.do?productNo=<c:out value="${list.productNo}"/>" class="btn btn-default add-to-cart"><i class="fa fa-search"></i>상품상세보기</a>
										</div>
									</div>
									<img src="images/home/new.png" class="new" alt="" />
								</div>
							</div>
						</div>
						</c:forEach>
						<c:if test="${empty list}">
							<img src="https://www.harimmarket.com/user/images/common/object_ing.gif">
						</c:if>
						
						<!-- <ul class="pagination">
							<li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul> -->
						<%-- <%
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
						%>
						<c:if test="${not empty list}">
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
                    </ul><!--/.pagination--> --%>
                    <%-- </c:if> --%>
					</div><!--features_items-->
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