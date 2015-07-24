<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${sessionScope.stat eq true}">
	<script>
		alert("재고수량의 수정이 완료되었습니다");
		<%session.removeAttribute("stat");%>
		window.location.reload();
	</script>
</c:if>
<c:if test="${sessionScope.udt eq true}">
	<script>
		alert("해당 상품옵션의 정보수정이 완료되었습니다");
		<%session.removeAttribute("udt");%>
		window.location.reload();
	</script>
</c:if>

<script type="text/javascript" charset="utf-8">
function mySubmit(frm,index,countNo){
	var division = parseInt(countNo)-1;
	var productOptionNo = document.getElementsByName('productOptionNo');
	var productOptionName = document.getElementsByName('productOptionName');
	var addPrice = document.getElementsByName('addPrice');
	var productAmount = document.getElementsByName('productAmount');
	var optionStat = document.getElementsByName('optionStat');
	var productNo = document.getElementsByName('productNo');
	var optionProcedure = document.getElementsByName('optionProcedure');
	
	//상품옵션의 수량 변경
	if(index==1){
		var fm = document.createElement("form");
		
		if(productAmount[parseInt(division)].value < 0){ //update할 상품의 수량이 0 이하일 경우 걸러줌
			alert("재고수량은 0 이상이어야 합니다");
			window.location.reload();
			return false;
		}
		if(optionStat[parseInt(division)].value < 1){
			alert("옵션상태를 올바르게 선택해주세요");
			window.location.reload();
			return false;
		}
		if(addPrice[parseInt(division)].value < 0){
			alert("추가금액이 잘못되었습니다");
			window.location.reload();
			return false;
		}
		if(optionProcedure[parseInt(division)].value < 1){
			alert("옵션순서가 잘못되었습니다");
			window.location.reload();
			return false;
		}
		if(productOptionName[parseInt(division)].value == null){
			alert("옵션명이 잘못되었습니다");
			window.location.reload();
			return false;
		}
		for(var k=0; k < optionProcedure.length ;k++){
			if(optionProcedure[parseInt(division)].value == optionProcedure[k].value & k!=parseInt(division)){
				alert(optionProcedure[parseInt(division)].value);
				alert(optionProcedure[k].value);
				alert("옵션순서가 중복됩니다");
				window.location.reload();
				return false;
			}
		}
		
		fm.setAttribute("method", "post");
		fm.setAttribute("action", "udtPrdOption.do");
		document.body.appendChild(fm);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "productOptionNo");
		i.setAttribute("value", productOptionNo[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "productOptionName");
		i.setAttribute("value", productOptionName[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "addPrice");
		i.setAttribute("value", addPrice[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "productAmount");
		i.setAttribute("value", productAmount[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "optionStat");
		i.setAttribute("value", optionStat[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "productNo");
		i.setAttribute("value", productNo[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "optionProcedure");
		i.setAttribute("value", optionProcedure[parseInt(division)].value);
		fm.appendChild(i);
		
		fm.submit();
	}
	
	if(index==2){
		var fm = document.createElement("form");
		fm.setAttribute("method", "post");
		fm.setAttribute("action", "delPrdOption.do");
		document.body.appendChild(fm);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "productOptionNo");
		i.setAttribute("value", productOptionNo[parseInt(division)].value);
		fm.appendChild(i);
		
		var i = document.createElement("input");
		i.setAttribute("type", "hidden");
		i.setAttribute("name", "productNo");
		i.setAttribute("value", productNo[parseInt(division)].value);
		fm.appendChild(i);
		
		fm.submit();
	}
}
	
	

var oTbl;
//Row 추가
function insRow() {
  var plusPOName = document.getElementsByName('plusPOName'); //'productOptionNo' 을 포함한 Tag들을 찾아서 배열로 만들어준다.
  var i= plusPOName.length ;
  oTbl = document.getElementById("addTable");
  var oRow = oTbl.insertRow();
  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex};
  var productNo = <%=request.getParameter("productNo")%>;

  if(plusPOName.length>9){
	  alert("옵션추가는 한번에 10개로 제한됩니다.");
	  return false;
	  
  }
  oRow.insertCell(0).innerHTML = "<input type=text id="+i+" name=plusPOName maxlength=20 value=''><input type=hidden name=productNo value="+productNo+">";
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

function checkIt(){
	var plusPOName = document.getElementsByName('plusPOName');
	var plusOP = document.getElementsByName('plusOP');
	var plusAddPrice = document.getElementsByName('plusAddPrice');
	var plusProductAmount = document.getElementsByName('plusProductAmount');
	var optionValue = document.getElementsByName('optionValue');
	var optionProcedure = document.getElementsByName('optionProcedure');
	
	if(document.insertPOform.plusPOName == null){
		alert("먼저 추가를 해주세요");
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
	 }
}

function getSelectValue(frm,i)
{
	var optionStat = document.getElementsByName('optionStat');
	 optionStat[parseInt(i)-1].value = frm.selectBox.options[frm.selectBox.selectedIndex].value;
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
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.do"><img src="images/home/logo.png" alt="" /></a>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
	</header><!--/header-->
	
	
	<section id="cart_items">
		<div class="container">
			<div class="table-responsive cart_info">
			
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="info">상품옵션명<br>(상품옵션번호)</td>
							<td class="optionProcedure">옵션순서</td>
							<td class="addPrice">추가금액</td>
							<td class="stat">재고수량</td>
							<td class="stats">옵션상태</td>
							<td class="delete">변경/삭제</td>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${list}" var="productOptionList" varStatus="status">
							<form name="cartDetailsForm" method="POST">
							<tr>
								<td class="cart_info">
									<p><input type="text" id="${status.count}" name="productOptionName" value="${productOptionList.productOptionName}" maxlength="20">
									<br>
									(${productOptionList.productOptionNo})</p>
								</td>
								<td class="cart_optionProcedure">
									<input type="number" id="${status.count}" name="optionProcedure" value="${productOptionList.optionProcedure}" min="1">
								</td>
								<td class="cart_addPrice">
									<input type="text" id="${status.count}" name="addPrice" value="${productOptionList.addPrice}">
								</td>
								<td class="cart_stat">
									<input type="hidden" id="${status.count}" name="productOptionNo" value="${productOptionList.productOptionNo}">
									<input type="hidden" id="${status.count}" name="productNo" value="${productOptionList.productNo}">
									<input type="hidden" id="${status.count}" name="optionStat" value="${productOptionList.optionStat}">
									<input type="number" id="${status.count}" name="productAmount" value="${productOptionList.productAmount}"  min="0"><br>
								</td>
								<td class="cart_statss">
									<select name="selectBox" id="list" onchange="getSelectValue(this.form,${status.count});" >
											<option value="-1">선택하세요</option>
											<c:if test="${productOptionList.optionStat eq 1}">
												<option value="1" selected>활성화</option>
												<option value="2">비활성화</option>
											</c:if>
											<c:if test="${productOptionList.optionStat eq 2}">
												<option value="1" >활성화</option>
												<option value="2" selected>비활성화</option>
											</c:if>
									</select>
								</td>
								<td class="cart_deletes">
									<button type="button" class="btn btn-fefault cart" name="updateButton"value="${status.count}"onclick="mySubmit(this.form,1,this.value);">변경</button>
									<br>
									<button type="button" class="btn btn-fefault cart" name="delButton"value="${status.count}"onclick="mySubmit(this.form,2,this.value);">삭제</button>
								</td>
							</tr>
							</form>
						</c:forEach>
					</tbody>
				</table>
				
				
				<hr>
				
				<form action="insertPrdOption.do" name="insertPOform" method="post" onSubmit="return checkIt()">
				<table class="table table-condensed">
				  <tr>
				    <td colspan="2" align="left" bgcolor="#FFFFFF">
				      <table width="100%" border="0" cellpadding="0" cellspacing="0">
				        <tr>
				         <td colspan="5" bgcolor="#FFFFFF" height="25" align="left">
					         <input name="addButton" type="button" style="cursor:hand" onClick="insRow()" value="옵션추가">
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
				      <input type="submit" name="button" value="상품옵션 등록" >
				      </td>
				    </tr>
				 </table>
				 </form>
			</div>
		</div>
	</section>
	
	
	
	<footer id="footer"><!--Footer-->
	</footer><!--/Footer-->
	

  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>