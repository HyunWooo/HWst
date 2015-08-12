<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${orderList.buyAmount > orderList.productAmount}">
	<%
	String sName =" 상품옵션의 주문수량이 재고보다 큽니다. ";
	out.println("<script>alert('" + sName + "');</script>");
	out.println("<script>history.back(-1);</script>");%>
</c:if>
<script type="text/javascript" charset="utf-8">
function cancel(){
	<%session.removeAttribute("fromCart");%>
	javascript:history.back(-1);
}
function doOrder(frm){
	var fm = document.createElement("form");//스크립트 내 폼 생성
	if($("#bankKind option:selected").val()=='-1'){
		alert("은행을 선택해주세요");
		return false;
	}
	if($(':radio[name="deliver_info"]:checked').val()=="directInput"){
		if(!document.directInput.receiverName.value){
			alert("수령인을 입력하세요");
			return false;
		}	
		if(!document.directInput.phone.value){
			alert("전화번호를 입력하세요");
			return false;
		}
		if(!document.directInput.postCode.value){
			alert("우편번호를 입력하세요");
			return false;
		}
		if(!document.directInput.address.value){
			alert("주소를 입력하세요");
			return false;
		}
	}
		
	fm.setAttribute("method", "post");
	fm.setAttribute("action", "insertOrders.do");
	document.body.appendChild(fm);
	
	$("input[name=productOptionNo]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "productOptionNo");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	$("input[name=buyAmount]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "buyAmount");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	$("input[name=totalPrice]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "totalPrice");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});

	$("input[id=deletedCart]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "deletedCart");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	if($(':radio[name="deliver_info"]:checked').val()=="directInput"){
		$("input[id=directInputReceiverName]").each(function() {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "receiverName");
			i.setAttribute("value",  $(this).val());
			fm.appendChild(i);
		});
		
		$("input[id=directInputPhone]").each(function() {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "phone");
			i.setAttribute("value",  $(this).val());
			fm.appendChild(i);
		});
		
		$("input[id=directInputPostCode]").each(function() {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "postCode");
			i.setAttribute("value",  $(this).val());
			fm.appendChild(i);
		});
		
		$("input[id=directInputAddress]").each(function() {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "address");
			i.setAttribute("value",  $(this).val());
			fm.appendChild(i);
		});
		
	}
	else if($(':radio[name="deliver_info"]:checked').val()=="basicInput"){
		$("input[id=basicInputReceiverName]").each(function() {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "receiverName");
			i.setAttribute("value",  $(this).val());
			fm.appendChild(i);
		});
		
		$("input[id=basicInputPhone]").each(function() {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "phone");
			i.setAttribute("value",  $(this).val());
			fm.appendChild(i);
		});
		
		$("input[id=basicInputPostCode]").each(function() {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "postCode");
			i.setAttribute("value",  $(this).val());
			fm.appendChild(i);
		});
		
		$("input[id=basicInputAddress]").each(function() {
			var i = document.createElement("input");
			i.setAttribute("type", "hidden");
			i.setAttribute("name", "address");
			i.setAttribute("value",  $(this).val());
			fm.appendChild(i);
		});
	}
		
	$("input[name=checkout_Info]").each(function() {	
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "checkoutInfo");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	$("input[name=userNo]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "userNo");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	$("input[name=grade]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "grade");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	$("textarea[name=message]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "message");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	$("input[name=allTotalPrice]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "allTotalPrice");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	$("input[name=discountPrice]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "discountPrice");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	$("input[name=discountedTotalPrice]").each(function() {
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "discountedTotalPrice");
		i.setAttribute("value",  $(this).val());
		fm.appendChild(i);
	});
	
	fm.submit();
}


//은행명 선택에 따른 계좌번호 출력
function chooseBank(frm,bankNo){
	if(bankNo==0){
		$("#accountNo").text("국민은행_9-3341-3855-49");
	}
	else if(bankNo==1){
		$("#accountNo").text("우리은행_1002-389-901006");
	}
	else if(bankNo==2){
		$("#accountNo").text("신한은행_110-272-000257");	
	}
}

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

</script>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
<script text/javascript>

	$(document).ready(function() {
		var totalPrice = document.getElementsByName('totalPrice');
		var allTotalPrice = 0;
		for(var k=0; k<totalPrice.length; k++){
			allTotalPrice = parseInt(allTotalPrice) + parseInt(totalPrice[k].value);
		}
		$("input[name=allTotalPrice]").val(commaNum(allTotalPrice)+"원");
		
		var discountPercent =$("input[name=discountPercent]").val();
		var discountPrice= ((parseInt(discountPercent)/100) *parseInt(allTotalPrice));
		$("input[name=discountPrice]").val(commaNum(discountPrice)+"원");
		var discountedTotalPrice= (((100-parseInt(discountPercent))/100) *parseInt(allTotalPrice));
		$("input[name=discountedTotalPrice]").val(commaNum(discountedTotalPrice)+"원");
	});

	$(function() {
		//라디오 버튼 클릭 이벤트 처리에 대한 부분
		 $("[type='radio']").click(function(e){
		  var tar = $(':radio[name="deliver_info"]:checked').val();  //선택된 라디오 버튼에 대한 값을 가져옴
		  if(tar=="directInput"){  
			   $("#directInput").show();  //같은 div의 id영역을 보이기
			   $("#basicInput").hide(); 
		  } else if(tar=="basicInput"){ 
			   $("#basicInput").show();   //같은 div의 id영역을 감추기
			   $("#directInput").hide();
		  }
		  
		 });
	});
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
	<!-- header -->
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>
	<!-- /header -->

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="index.do">Home</a></li>
				  <li class="active">주문 & 결제</li>
				</ol>
			</div><!--/breadcrums-->

			<div class="review-payment">
				<h2 class="heading">주문 & 결제</h2>
			</div>

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">&nbsp;&nbsp;&nbsp;&nbsp;이미지&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td class="description">상품/옵션정보</td>
							<td class="price">상품가격</td>
							<td class="quantity">수량</td>
							<td class="total">개별상품 총가격</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="orderList" varStatus="status">
						<tr>
							<td class="cart_image">
								<a href="viewProductDetails.do?productNo=<c:out value="${orderList.productNo}"/>"><img src="images/product/<c:out value="${orderList.categoryNo}"/>/<c:out value="${orderList.productNo}"/>_1.jpg" alt="" /></a>
							</td>
							<td class="cart_description">
								<h4><a href="viewProductDetails.do?productNo=<c:out value="${orderList.productNo}"/>">${orderList.name}</a></h4>
								<p></p>
								<p>/${orderList.productOptionName}_재고 : ${orderList.productAmount}개</p>
							</td>
							<td class="cart_price">
								<p><fmt:formatNumber value="${orderList.eachPrice}"/>원</p>
							</td>
							<td class="cart_quantity">
							<c:if test="${orderList.buyAmount > orderList.productAmount}">
								<%
								String sName =" 상품옵션의 주문수량이 재고보다 큽니다. ";
								out.println("<script>alert('" + sName + "');</script>");
								out.println("<script>history.back(-1);</script>");%>
								<input class="cart_quantity_input" type="text" name="buyAmount" id="${orderList.productOptionNo}" value="${orderList.productAmount}"  readonly ">
							</c:if>
							<c:if test="${orderList.buyAmount <= orderList.productAmount}">
								<input class="cart_quantity_input" type="text" name="buyAmount" id="${orderList.productOptionNo}" value="${orderList.buyAmount}"  readonly ">
							</c:if>
							</td>
							<td class="cart_total">
								<p class="cart_total_price"><fmt:formatNumber value="${orderList.eachPrice * orderList.buyAmount}"/>원</p>
								<input type="hidden" name="totalPrice" value="${orderList.eachPrice * orderList.buyAmount}">
								<input type="hidden" name="productOptionNo" value="${orderList.productOptionNo}">
								<input type="hidden" name="productAmount" value="${orderList.productAmount}"/>
							</td>
						</tr>
					</c:forEach>
						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>주문금액</td>
										<td><input type="text" name="allTotalPrice" value="0원" readonly></td>
									</tr>
									<tr>
										<td>등급 할인금액</td> 
										<td><input type="text" name="discountPrice" value="0원" readonly><input type="hidden" name="discountPercent" value="${sessionScope.userLoginInfo.discountPercent}"/></td>
									</tr>
									<tr>
										<td>결제예정금액</td> 
										<td><input type="text" name="discountedTotalPrice" value="0원" readonly></td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			
			<div class="step-one">
				<h2 class="heading">배송지 정보 입력</h2>
			</div>
			<div class="register-req">
				<ul class="nav">
					<li>
						<input type="radio" id="deliver_gubun" name="deliver_info" value="basicInput" checked="checked"> 기본주소 (주문자 정보)&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="deliver_gubun" name="deliver_info" value="directInput" >직접입력
					</li>
				</ul>
			</div><!--/register-req-->
			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-3">
						<div class="shopper-info" id="basicInput">
							<p>주문자 정보</p>
								<label>받는사람명</label><input type="text" id="basicInputReceiverName" name="receiverName" value="${sessionScope.userLoginInfo.name}" readonly>
								<label>전화번호</label><input type="text" id="basicInputPhone" name="phone" value="${sessionScope.userLoginInfo.phone}" readonly>
								<label>우편번호</label><input type="text" id="basicInputPostCode" name="postCode" value="${sessionScope.userLoginInfo.postCode}" readonly>
								<label>주소</label><input type="text"  id="basicInputAddress" name="address" value="${sessionScope.userLoginInfo.address}" readonly style="width:620px;">
						</div>
						<div class="shopper-info" id="directInput" style="display:none">
						<form name="directInput">
							<p>주문자 정보</p>
								<label>받는사람명</label><input type="text" id="directInputReceiverName" name="receiverName" placeholder="받는사람명" maxlength="10">
								<label>전화번호</label><input type="text" id="directInputPhone" name="phone" placeholder="전화번호" maxlength="20">
								<label>우편번호</label><input type="text" id="directInputPostCode" name="postCode" placeholder="우편번호" maxlength="10">
								<label>주소</label><input type="text" id="directInputAddress" name="address" placeholder="주소" maxlength="50"  style="width:620px;">
						</form>
						</div>
					</div>
					<input type="hidden" name="userNo" value="${sessionScope.userLoginInfo.userNo}">
					<input type="hidden" name="grade" value="${sessionScope.userLoginInfo.grade}">
					<div class="col-sm-5 clearfix">
						<div class="order-message">
							<p>배송시요구사항</p><hr>
							<textarea name="message"   rows="10"  maxlength="50"></textarea>
							<label>* 특정한 배송일을 지정하고자 할 경우에는<br> 판매자와의 개별연락이 필요합니다.</label>
						</div>
					</div>
					<div class="col-sm-4">
					</div>					
				</div>
			</div>
			<hr>
			
			<!-- 여기부터 11번가꺼 -->
			<div class="shopper-informations">
				<div class="row">
					<div class="step-one">
						<h2 class="heading">결제 정보 입력</h2>
					</div>
					<div class="register-req">
						<ul class="nav">
							<li>
								<input type="radio" name="checkout_Info"checked="checked" value="1"/>무통장입금
							</li>
						</ul>
					</div><!--/register-req-->
					<div class="col-sm-8">
						<table>
							<colgroup>
								<col style="width:109px;">
								<col>
							</colgroup>
							
							<tbody>
								<tr id="NOACCOUNT_TABLE" name="NOACCOUNT_TABLE">
									<th scope="row">
										<label for="bankKind">입금은행</label>
									</th>
									<td>
										<div id="BankKindDiv">
											<select name="bankKind" id="bankKind" onchange="chooseBank(this.form,this.value)" style="width: 140px;">
												<option value="-1">은행선택</option>
												<option value="0">국민은행</option>
												<option value="1">우리은행</option>
												<option value="2">신한은행</option>
											</select>
											<label id = "accountNo" name="accountNo"></label>
										</div>
										<span id="bankInfo"></span>
									</td>
								</tr>
								<!-- 무통장입금:E -->
				
								<!-- 무통장입금안내:S -->
								<tr id="NOACCOUNT_TABLE" name="NOACCOUNT_TABLE">
									<th scope="row">결제안내</th>
									<td>
											<br>
											입금시 예금주명은 '11번가, ㈜커머스플래닛' 등으로 확인될 수 있습니다.
									</td>
								</tr>
								<tr>
									<td>
										<a class="btn btn-primary" onclick="doOrder(this.form)">결제하기</a>
										<a class="btn btn-primary" onclick="cancel()">취소하기</a>
										<input type="text" value="${sessionScope}">
										<input type="text" value="${DeletedCartList}">
										<c:if test="${DeletedCartList ne null}">
											<c:forEach items="${DeletedCartList}" var="List" varStatus="status">
												<input type="text" id="deletedCart" name="deletedCart" value="${List}">
											</c:forEach>
										</c:if>
									</td>
								</tr>
								<!-- 무통장입금안내:E -->
								</tbody>
							</table>
						</div>
						<div class="col-sm-4">
						</div>
					</div>
				</div>
			</div>
			<br><br>
			<hr>
			<br><br>
	</section> <!--/#cart_items-->

	

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