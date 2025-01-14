<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<c:choose>
		<c:when test="${sessionScope.loginFail=='Y'}">
			<script>
				alert("아이디와 패스워드를 다시 확인하세요.");
				<%session.removeAttribute("loginFail");%>
				history.go();
			</script>
		</c:when>
		<c:when test="${sessionScope.uUpdateProcess eq 'Y'}">
			<script>
				alert("회원정보 수정이 완료되었습니다. 다시 로그인해주세요.");
				 location.href = "login.do";
				 <%session.removeAttribute("userLoginInfo");%>
				 <%session.removeAttribute("uUpdateProcess");%>
			</script>
		</c:when>
		<c:when test="${empty sessionScope.userLoginInfo.name}">
			<script>
				alert("로그인을 한 후 이용해주세요.");
				 location.href = "index.do";
			</script>
		</c:when>
		<c:when test="${sessionScope.deleteUsersProcess eq 'Y'}">
			<script>
				alert("회원탈퇴가 완료되었습니다.");
				 location.href = "index.do";
				 <%session.removeAttribute("userLoginInfo");%>
				 <%session.removeAttribute("deleteUsersProcess");%>
			</script>
		</c:when>
	<c:otherwise/>
	</c:choose>

	<script type="text/javascript" charset="UTF-8" language="javascript">
		function checkIt(){
			if(!document.userinput.pw.value){
				alert("비밀번호를 입력하세요");
				return false;
			}
			if(document.userinput.pw.value != document.userinput.pw2.value){
				alert("비밀번호확인이 일치하지 않습니다");
				return false;
			}
			if(!document.userinput.phone.value){
				alert("전화번호를 입력하세요");
				return false;
			}
			if(!document.userinput.postCode.value){
				alert("우편번호를 입력하세요");
				return false;
			}
			if(!document.userinput.address.value){
				alert("주소를 입력하세요");
				return false;
			}
		}
		
		function checkAgain(){
			var UP;
			UP = confirm("정말 회원탈퇴를 하시겠습니까?");
			
			if(UP){
				return true;
			}
			else{
				return false;
			}
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
										<li><a href= "userManagement.do"><i class="fa fa-user"></i>${sessionScope.userLoginInfo.name}님</a></li>
										<li><a href="logoutProcess.do"><i class="fa fa-crosshairs"></i> Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
	</header><!--/header-->
	
			<section id="form"><!--form-->
				<div class="container">
					<div class="row">
						<div class="col-sm-4 col-sm-offset-1">
							<div class="login-form"><!--login form-->
								<h2>회원정보수정</h2>
								<form  action="updateUsersInfoProcess.do" method="post" name="userinput" onSubmit="return checkIt()">
									<input type="hidden" placeholder="회원번호" name="userNo" value="${sessionScope.userLoginInfo.userNo}" />
									<input type="hidden" placeholder="아이디" name="id" value="${sessionScope.userLoginInfo.id}" />
									<input type="password" placeholder="비밀번호" name="pw" />
									<input type="password" placeholder="비밀번호확인" name="pw2" />
									<input type="text" placeholder="전화번호 : ${sessionScope.userLoginInfo.phone}" name="phone" />
									<input type="text" placeholder="우편번호 : ${sessionScope.userLoginInfo.postCode}" name="postCode" />
									<input type="text" placeholder="주소 : ${sessionScope.userLoginInfo.address}" name="address"/>
									<button type="submit" value="수정하기" class="btn btn-default" id="btn">회원정보 수정</button>
								</form>
								<br><br>
								<button type="submit" value="뒤로가기" class="btn btn-default" id="btn" onClick="history.back(-1);">뒤로가기</button>
								<br><br>
								<form  action="deleteUsersProcess.do?userNo=${sessionScope.userLoginInfo.userNo}&userSection=${sessionScope.userLoginInfo.userSection}" method="post" name="userdelete" onSubmit="return checkAgain()">
									<button type="submit" value="회원탈퇴" class="btn btn-default" id="userDelete">회원 탈퇴</button>
								</form>
							</div><!--/login form-->
						</div>
					</div>
				</div>
			</section><!--/form-->
		
	
	
	
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