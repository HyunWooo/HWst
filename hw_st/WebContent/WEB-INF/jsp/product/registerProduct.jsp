<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<script type="text/javascript" charset="UTF-8" language="javascript">
		
		var oTbl;
		//Row 추가
		function insRow(frm) {
		  var opTotalNum = document.getElementsByName('opTotalNum');
		  var plusPOName = document.getElementsByName('plusPOName');
		  var i= plusPOName.length ;
		  oTbl = document.getElementById("addTable");
		  var oRow = oTbl.insertRow();
		  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex};

		  frm.opTotalNum.value=plusPOName.length+1;
		  
		  if(plusPOName.length>9){
			  alert("옵션추가는 한번에 10개로 제한됩니다.");
			  return false;
		  }
		  oRow.insertCell(0).innerHTML = "<input type=text id="+i+" name=plusPOName maxlength=20 value=''>";
		  oRow.insertCell(1).innerHTML = "<input type=number id="+i+" name=plusOP min=1 value=''>";
		  oRow.insertCell(2).innerHTML = "<input type=number id="+i+" name=plusAddPrice min=0 value=''>";
		  oRow.insertCell(3).innerHTML = "<input type=number id="+i+" name=plusProductAmount min=0 value=''>";
		  oRow.insertCell(4).innerHTML = "<input type=number id="+i+" name=optionValue min=1 max=2 value=''>";
		  oRow.insertCell(5).innerHTML = "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
		  
		}
		//Row 삭제
		function removeRow(frm) {
		  oTbl.deleteRow(oTbl.clickedRowIndex);
		}

		function checkIt(frm){
			var plusPOName = document.getElementsByName('plusPOName');
			var plusOP = document.getElementsByName('plusOP');
			var plusAddPrice = document.getElementsByName('plusAddPrice');
			var plusProductAmount = document.getElementsByName('plusProductAmount');
			var optionValue = document.getElementsByName('optionValue');
			var optionProcedure = document.getElementsByName('optionProcedure');
		 	var i= plusPOName.length ;
			  
			if(!frm.categoryNo.value){
				alert("카테고리번호를 입력하세요");
				return false;
			}
			if(!frm.name.value){
				alert("상품명을 입력하세요");
				return false;
			}
			if(!frm.basicPrice.value){
				alert("기본가격을 입력하세요");
				return false;
			}
			if(!frm.details.value){
				alert("상세설명을 입력하세요");
				return false;
			}
			if(frm.plusPOName == null){
				alert("적어도 한개 이상의 상품옵션이 등록되어야 합니다");
				return false;
			}
			 for(var k=0; k < plusPOName.length ;k++){
				if(!plusPOName[k].value){
					alert("상품옵션명을 입력하세요");
					return false;
				}
				if(!plusOP[k].value){
					alert("옵션순서를 입력하세요");
					return false;
				}
				if(plusOP[k].value < optionProcedure.length+1){
						alert("기존항목의 옵션순서와 중복입니다.");
						return false;
				}
				if(plusOP[k-1] != null){
					if(plusOP[k-1].value==plusOP[k].value){
						alert("추가중인 옵션순서에서 중복이 발생하였습니다.");
						return false;
					}
				}
				if(!plusAddPrice[k].value){
					alert("추가금액을 입력하세요");
					return false;
				}
				if(!plusProductAmount[k].value){
					alert("재고수량을 입력하세요");
					return false;
				}
				if(!optionValue[k].value){
					alert("옵션상태를 선택하세요");
					return false;
				}
				if(optionValue[k].value>2){
					alert("잘못된 옵션상태입니다");
					return false;
				}
				
			 }
			 frm.submit();
		}

		function getSelectValue(frm,i)
		{
			 frm.categoryNo.value = frm.selectBox.options[frm.selectBox.selectedIndex].value;
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
	</header><!--/header-->
	
			<section id="cart_items">
				<div class="container">
					<div class="table-responsive cart_info">
					<form action="insertPrd.do" name="insertPOform" method="post" onSubmit="return checkIt()">
							<h2>상품 등록</h2>
							<div class="shopper-informations">
								<div class="row">
									<div class="col-sm-3">
										<div class="shopper-info" id="basicInput">
								<select name="selectBox" id="list" onchange="getSelectValue(this.form);" width="100px;">
									<c:forEach items="${sessionScope.categoryList}" var="categoryList" >
										<option id="${categoryList.categoryNo}" label="${categoryList.categoryName}" value="${categoryList.categoryNo}">
										</option>
									</c:forEach>
								</select>
								<label>카테고리번호</label><input type="text" placeholder="카테고리번호" name="categoryNo" readonly/><br>
								<label>상품명</label><input type="text" placeholder="상품명" name="name" /><br>
								<label>기본가격</label><input type="number" placeholder="기본가격" name="basicPrice" /><br>
								<label>상세설명</label><input type="text" placeholder="상세설명" name="details"/><br>
								<input type="hidden" name="opTotalNum" value="0">
								</div>
								</div>
								</div>
								</div>
						<br>
						
						<table class="table table-condensed">
						  <tr>
						    <td colspan="2" align="left" bgcolor="#FFFFFF">
						      <table width="100%" border="0" cellpadding="0" cellspacing="0">
						        <tr>
						         <td colspan="5" bgcolor="#FFFFFF" height="25" align="left">
							         <input name="addButton" type="button" style="cursor:hand" onClick="insRow(this.form)" value="옵션추가">
							         <font color="#FF0000">*</font>옵션추가를 클릭해 보세요.</td>
						        </tr>
						        <tr>
						         <td>
						           <table id="addTable" class="table table-condensed">
						            <tr class="cart_menu">
										<td class="info">상품옵션명</td>
										<td class="optionProcedure">옵션순서</td>
										<td class="addPrice">추가금액</td>
										<td class="stat">재고수량</td>
										<td class="stats">옵션상태<br>활성화:1/비활성화:2</td>
										<td class="delete">해당옵션삭제</td>
									</tr>
						          </table>
						          </td>
						        </tr>
						       </table>
						      </td>
						   </tr>
						 </table>
						 <table border="0" cellspacing="0" cellpadding="0">
						    <tr>
						      <td height="10">
						      </td>
						    </tr>
						    <tr>
						      <td align="center">
						      <input type="hidden" name="userNo" value="${sessionScope.userLoginInfo.userNo}" >
						      <input type="button" name="button" value="상품 등록" onclick="checkIt(this.form)">
						      </td>
						    </tr>
						 </table>
					</div>
					</form>
				</div>
			</section><!--/form-->
	
	
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