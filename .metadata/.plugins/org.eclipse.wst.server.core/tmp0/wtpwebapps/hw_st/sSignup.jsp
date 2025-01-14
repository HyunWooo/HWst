<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8");%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<c:choose>
		<c:when test="${not empty sessionScope.userLoginInfo.name}">
			<script>
				alert("이미 로그인 된 상태입니다.");
				history.go(-1);
			</script>
		</c:when>
		<c:when test="${sessionScope.loginFail eq 'Y'}">
			<script>
				alert("아이디와 패스워드를 다시 확인하세요.");
				<%session.invalidate();%>
				history.go();
			</script>
		</c:when>
		<c:when test="${sessionScope.signupProcess eq 'Y'}">
			<script>
				alert("회원가입이 완료되었습니다.");
				 location.href = "index.do";
				 <%session.invalidate();%>
			</script>
		</c:when>
	<c:otherwise>
	

	<script type="text/javascript" charset="UTF-8" language="javascript">
		function checkIt(){
			if(!document.userinput.id.value){
				alert("ID를 입력하세요");
				return false;
			}
			if(!document.userinput.pw.value){
				alert("비밀번호를 입력하세요");
				return false;
			}
			if(document.userinput.pw.value != document.userinput.pw2.value){
				alert("비밀번호확인이 일치하지 않습니다");
				return false;
			}
			if(!document.userinput.name.value){
				alert("이름을 입력하세요");
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
		
		
		function openConfirmid(inputid)
		{
			if(inputid.id.value ==""){
				alert("아이디를 입력하세요");
				return;
			}
			url="checkId.do?id="+inputid.id.value;
			window.open(url);
		}
		</script>
		<script src="js/jquery-1.11.3.js" type="text/javascript">
					function chk(id) {
						alert("asd");
						$.ajax({
							url : "checkId.do",
							type : "post", 
							dataType : "text", 
							data : "id=" + $("#id").val(), 
							success : function(data) { 
								alert(data);
								$("chkResult").html(data);
							},
							error : function(err) { 
								alert(err + " : error");
							}
						});
					}
		</script>
		
		
 		<!-- <script type="text/javascript">
		$(document).ready(function(){
		$("#confirm").click(function(){
		        var id = $('#id').val();
		        $.ajax({
		        type: "POST",
		        url: "checkId.do", //이페이지에서 중복체크를 한다
		        data: "id="+ id ,//test.asp에 id 값을 보낸다
		        cache: false,
		        success: function(data){
		            $("#confirmView").html(data); //해당 내용을 보여준다
		        }
		        });
		    });
		 });
		 </script>  -->

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
								<li><a href="contact_us.jsp"><i class="fa fa-phone"></i> 010-3341-3855</a></li>
								<li><a href="contact_us.jsp"><i class="fa fa-envelope"></i> gusdn@sk.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6 col-xs-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<!-- <li><a href="#"><i class="fa fa-user"></i> Account</a></li> -->
 								<!--<li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li> -->
										<li><a href="chooseSignup.do"><i class="fa fa-pencil"></i> Sign Up</a></li>
										<li><a href="login.do"><i class="fa fa-lock"></i> Login</a></li>
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
					</div>
					<div class="col-sm-8">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
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
								<li><a href="contact_us.jsp">Contact-us</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	</header><!--/header-->
	
			<section id="form"><!--form-->
				<div class="container">
					<div class="row">
						<div class="col-sm-6 text-center">
							<div class="signup-form"><!--sign up form-->
								<h2>판매자 회원가입</h2>
								<form  action="signupSellerProcess.do" method="post" name="userinput" onSubmit="return checkIt()" >
									<input type="email" placeholder="아이디(이메일)" id = "usrId" name="usrId"  />
									<span id="chkResult"></span>
									<input type='button'  placeholder = '중복확인 ' id="chkButton" name = "chkButton" onclick="chk(userId.value)">
									<input type="password" placeholder="비밀번호" name="pw" />
									<input type="password" placeholder="비밀번호확인" name="pw2" />
									<input type="text" placeholder="이름" name="name"/>
									<input type="text" placeholder="전화번호" name="phone" />
									<input type="text" placeholder="우편번호" name="postCode" />
									<input type="text" placeholder="주소" name="address"/>
									<input type="hidden" placeholder="회원구분" name="userSection" value="2"/>
									<input type="text" placeholder="입금계좌은행명" name="bankName"/>
									<input type="text" placeholder="계좌번호" name="accountNo"/>
									<button type="submit" value="가입하기" class="btn btn-default" id="btn">가입하기</button>
								</form>
							</div><!--/sign up form-->
						</div>
					</div>
				</div>
			</section><!--/form-->
		</c:otherwise>
	</c:choose>
	
	
	
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