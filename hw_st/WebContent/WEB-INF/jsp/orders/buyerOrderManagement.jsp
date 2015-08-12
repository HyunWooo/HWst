<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

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
	
	//무통장입금 상태변경
	if(index==1){
		if (confirm("무통장 입금을 수행합니다. \n입금하시겠습니까?")){    //확인
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
			i.setAttribute("value",  "COMPLETEPAYMENT");
			fm.appendChild(i);
			
			fm.submit();
		}
			
	}
	
	//해당주문 삭제(입금대기중 경우에만)
	if(index==2){
		
		var fm = document.createElement("form");
		
		fm.setAttribute("method", "post");
		fm.setAttribute("action", "deleteOrder.do");
		document.body.appendChild(fm);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "orderNo");
		i.setAttribute("value", countNo);
		fm.appendChild(i);
		
		fm.submit();
	}
	 
	
	//배송상품 수령확인
	if(index==3){
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
		i.setAttribute("value", "DELIVERYALLCOMPLETE");
		fm.appendChild(i);
		
		fm.submit();
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
							<td class="info">주문일자<br>(주문번호)</td>
							<td class="image">이미지</td>
							<td class="description">상품정보<br>/옵션정보_재고수량</td>
							<td class="price">상품금액(수량)</td>
							<td class="stat">배송상태</td>
							<td class="stat">주문상태</td>
							<td class="delete">취소</td>
						</tr>
					</thead>
					
					<tbody>
					<!-- 장바구니 리스트 출력 -->
						<c:forEach items="${list}" var="orderList" varStatus="status">
							<tr>
								<c:if test="${orderList.orderNoCount ne 0}">
									<td class="cart_info" rowspan="${orderList.orderNoCount}">
										<p><fmt:formatDate value="${orderList.orderTime}" pattern="yyyy-MM-dd"/><br>(${orderList.orderNo})</p>
									</td>
								</c:if>
								<td class="cart_image">
									<a href="viewProductDetails.do?productNo=<c:out value="${orderList.productNo}"/>"><img src="images/product/<c:out value="${orderList.categoryNo}"/>/<c:out value="${orderList.productNo}"/>_1.jpg" alt="" /></a>
								</td>
								<td class="cart_description">
									<h4><a href="viewProductDetails.do?productNo=<c:out value="${orderList.productNo}"/>">${orderList.name}</a></h4>
									<p></p>
									<p>/${orderList.productOptionName}_${orderList.productAmount}개</p>
								</td>
								<td class="cart_price">
									<p><fmt:formatNumber value="${orderList.totalPrice}"/>원(${orderList.buyAmount}개)</p>
									<input type="hidden" id="${status.count}" name="discountedTotalPrice" value="${orderList.discountedTotalPrice}"/>
								</td>
								<td class="cart_stat">
									<input type="hidden" id="${status.count}" name="orderNo" value="${orderList.orderNo}">
									<input type="hidden" id="${status.count}" name="productOptionNo" value="${orderList.productOptionNo}">
									<c:if test="${orderList.orderStat ne 'DEPOSITWATING' and orderList.orderStat ne 'DELETEDORDER'  and orderList.orderStat ne 'COMPLETEPAYMENT'}">
										<c:choose>
											<c:when test="${orderList.deliveryStat eq 'DISPATCHREADY'}">
												&nbsp;&nbsp;&nbsp;발송준비중
											</c:when>
											<c:when test="${orderList.deliveryStat eq 'DELIVERING'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송중
												<br>
												<button type="button" class="btn btn-fefault cart" id="${status.count}" name="delivery" value="${status.count}"onclick="mySubmit(this.form,3,this.value);">상품수령확인</button>
											</c:when>
											<c:when test="${orderList.deliveryStat eq 'DELIVERYALLCOMPLETE'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송완료
											</c:when>
										</c:choose>
									</c:if>
								</td>
								<c:if test="${orderList.orderNoCount ne 0}">
									<td class="cart_stat" rowspan="${orderList.orderNoCount}">
										<c:choose>
											<c:when test="${orderList.orderStat eq 'DEPOSITWATING' and orderList.quantityCheck eq 1}">
													&nbsp;&nbsp;&nbsp;재고 부족<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 'DEPOSITWATING' and orderList.quantityCheck ne 1}">
													&nbsp;&nbsp;&nbsp;${orderList.discountedTotalPrice}<br>입금대기중<br>
													<button type="button" class="btn btn-fefault cart" id="${status.count}" name="deposit"value="${orderList.orderNo}"onclick="mySubmit(this.form,1,this.value);">입금하기</button>
											</c:when>
											<c:when test="${orderList.orderStat eq 'COMPLETEPAYMENT'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;결제완료<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 'DELIVERYREADY'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송준비중<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 'DELIVERING'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송중<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 'DELIVERYALLCOMPLETE' or orderList.orderStat eq 'SELLINGPRICEREFUND'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전체배송완료<br>
											</c:when>
										</c:choose>
									</td>
								</c:if>
								<c:if test="${orderList.orderNoCount ne 0}">
									<td class="cart_delete" rowspan="${orderList.orderNoCount}">
										<c:if test="${orderList.orderStat eq 'DEPOSITWATING'}">
											<button class="cart_delete_button" type='button' id="${orderList.orderNo}" name='delOrder' value='${orderList.orderNo}' onClick='mySubmit(this.form,2,this.value)'>주문취소</button>
										</c:if>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->
	<section>
		<img src="images/order/deliveryProcess.jpg" class="img-responsive" alt=""  align="middle" />
	</section>
	</form>

<!-- footer -->
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>
<!-- /footer -->	

	


    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>