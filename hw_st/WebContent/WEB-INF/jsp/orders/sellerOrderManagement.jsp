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
	
	//무통장입금확인 상태변경
	if(index==1){
		if (confirm("입금을 확인하셨습니까? \n확인 후 배송을 준비해 주세요")){    //확인
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
			i.setAttribute("value",  "DELIVERYREADY");
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
		i.setAttribute("value", "DELIVERING");
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
		var accountNo = document.getElementsByName("accountNo");
		
		var acc = accountNo[0].value;
		var discountedTotalPrice = thisPrice.substr(0,thisPrice.length-1);
		var endPrice = parseInt(discountedTotalPrice)*0.95*1000;
		var fee = parseInt(discountedTotalPrice)*0.05*1000;
		
		if (confirm("귀하의 계좌 "+acc+" 으로 \n총 금액 "+thisPrice+" 중 수수료 "+fee+"원을 제외한\n"+endPrice+"원이 입금됩니다. \n계속하시겠습니까?")){
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
			i.setAttribute("value",  "SELLINGPRICEREFUND");
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
	<!-- header -->
	<jsp:include page="/WEB-INF/jsp/common/sellerHeader.jsp"/>
	<!-- /header -->

<form name="cartDetailsForm" method="POST">
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
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
								<c:set var="key" value="${orderList.orderNo}"/>
								<c:if test="${orderList.rnum eq 1}">
									<td class="cart_info" rowspan="${groupCountMap[key].orderNoCount}">
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
									<c:if test="${orderList.orderStat ne 'DEPOSITWATING' and orderList.orderStat ne 'DELETEDORDER'}">
										<c:choose>
											<c:when test="${orderList.deliveryStat eq 'DISPATCHREADY' and orderList.orderStat ne 'COMPLETEPAYMENT'}">
												&nbsp;&nbsp;&nbsp;발송준비중
												<br>
												<button type="button" class="btn btn-fefault cart" id="${status.count}" name="delivery" value="${status.count}"onclick="mySubmit(this.form,2,this.value);">배송 요청</button>
											</c:when>
											<c:when test="${orderList.deliveryStat eq 'DELIVERING'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송중
											</c:when>
											<c:when test="${orderList.deliveryStat eq 'DELIVERYALLCOMPLETE'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송완료
											</c:when>
										</c:choose>
									</c:if>
								</td>
								<c:if test="${orderList.rnum eq 1}">
									<td class="cart_stat" rowspan="${groupCountMap[key].orderNoCount}">
										<c:choose>
											<c:when test="${orderList.orderStat eq 'DEPOSITWATING' and orderList.quantityCheck eq 1}">
													&nbsp;&nbsp;&nbsp;재고 부족<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 'DEPOSITWATING' and orderList.quantityCheck ne 1}">
													&nbsp;&nbsp;&nbsp;${orderList.discountedTotalPrice}<br>입금대기중<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 'COMPLETEPAYMENT'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;결제완료<br>
												<input type="hidden" id="${status.count}" name="orderStat" value="${orderList.orderStat}">
												<button type="button" class="btn btn-fefault cart" id="${status.count}" name="deposit"value="${orderList.orderNo}"onclick="mySubmit(this.form,1,this.value);">입금확인하기</button>
											</c:when>
											<c:when test="${orderList.orderStat eq 'DELIVERYREADY'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송준비중<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 'DELIVERING'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;배송중<br>
											</c:when>
											<c:when test="${orderList.orderStat eq 'DELIVERYALLCOMPLETE'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전체배송완료<br>
												<button type="button" class="btn btn-fefault cart" id="${status.count}" name="deposit"value="${status.count}"onclick="mySubmit(this.form,3,this.value);">결제금액받기</button>
											</c:when>
											<c:when test="${orderList.orderStat eq 'SELLINGPRICEREFUND'}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;결제금액 수금완료<br>
											</c:when>
										</c:choose>
									</td>
								</c:if>
								<c:if test="${orderList.rnum eq 1}">
									<td class="cart_delete" rowspan="${groupCountMap[key].orderNoCount}">
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
		<input type="hidden" name="accountNo" value="${sessionScope.userLoginInfo.accountNo}">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<img src="images/order/deliveryProcess.jpg" class="img-responsive" alt=""  align="middle" /><br><br><br><br>
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