<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>SEO HTML-5 Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">

<!-- CSS here -->
<link rel="stylesheet" href="./assets/css/bootstrap.min.css">
<link rel="stylesheet" href="./assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="./assets/css/flaticon.css">
<link rel="stylesheet" href="./assets/css/slicknav.css">
<link rel="stylesheet" href="./assets/css/animate.min.css">
<link rel="stylesheet" href="./assets/css/magnific-popup.css">
<link rel="stylesheet" href="./assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="./assets/css/themify-icons.css">
<link rel="stylesheet" href="./assets/css/slick.css">
<link rel="stylesheet" href="./assets/css/nice-select.css">
<link rel="stylesheet" href="./assets/css/style.css">
</head>

<body>

	<!-- Preloader Start -->
	<!-- 페이지 시작할때 애니메이션 -->
	<!-- <div id="preloader-active">
		<div
			class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle"></div>
				<div class="preloader-img pere-text">
					<img src="./images/logo.png" alt="">
				</div>
			</div>
		</div>
	</div> -->
	<!-- Preloader Start -->

	<jsp:include page='../beforeLogin.jsp' />
	<jsp:include page='../menu_logo_form.jsp' />


	<!-- 로긴폼 -->
	<div class="container" align="center">
		<div class="col-lg-12"></div>
		<div class="col-lg-6">
			<!-- 점보트론 -->
			<div class="jumbotron" style="padding-top: 40px;">
				<!-- 로그인 정보를 숨기면서 전송post -->
				<form method="post" action="loginAction.jsp">
					<h3 style="text-align: center;">견생묘생</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							name="userID" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							name="userPassword" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control"
						value="로그인">

					<!-- 회원가입, 아이디찾기,비밀호찾기 -->
					<div class="position_a" align="center">
						<div class="find_info" style="color: #8e8e8e">
							<a style="color: #8e8e8e" target="_blank" id="idinquiry"
								href="http://13.125.43.98:8080/dogcatlife/join.jsp">아이디 찾기</a> <span
								class="bar" aria-hidden="true">|</span> <a
								style="color: #8e8e8e" target="_blank" id="pwinquiry"
								href="http://13.125.43.98:8080/dogcatlife/join.jsp">비밀번호 찾기</a>
							<span class="bar" aria-hidden="true">|</span> <a
								style="color: #8e8e8e" target="_blank" id="join"
								href="http://13.125.43.98:8080/dogcatlife/join.jsp">회원가입</a>
						</div>
					</div>


				</form>
			</div>
		</div>


		<jsp:include page='../footer.jsp' />

		<!-- JS here -->

		<!-- All JS Custom Plugins Link Here here -->
		<script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
		<!-- Jquery, Popper, Bootstrap -->
		<script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
		<script src="./assets/js/popper.min.js"></script>
		<script src="./assets/js/bootstrap.min.js"></script>
		<!-- Jquery Mobile Menu -->
		<script src="./assets/js/jquery.slicknav.min.js"></script>

		<!-- Jquery Slick , Owl-Carousel Plugins -->
		<script src="./assets/js/owl.carousel.min.js"></script>
		<script src="./assets/js/slick.min.js"></script>
		<!-- Date Picker -->
		<script src="./assets/js/gijgo.min.js"></script>
		<!-- One Page, Animated-HeadLin -->
		<script src="./assets/js/wow.min.js"></script>
		<script src="./assets/js/animated.headline.js"></script>
		<script src="./assets/js/jquery.magnific-popup.js"></script>

		<!-- Scrollup, nice-select, sticky -->
		<script src="./assets/js/jquery.scrollUp.min.js"></script>
		<script src="./assets/js/jquery.nice-select.min.js"></script>
		<script src="./assets/js/jquery.sticky.js"></script>

		<!-- contact js -->
		<script src="./assets/js/contact.js"></script>
		<script src="./assets/js/jquery.form.js"></script>
		<script src="./assets/js/jquery.validate.min.js"></script>
		<script src="./assets/js/mail-script.js"></script>
		<script src="./assets/js/jquery.ajaxchimp.min.js"></script>

		<!-- Jquery Plugins, main Jquery -->
		<script src="./assets/js/plugins.js"></script>
		<script src="./assets/js/main.js"></script>
</body>
</html>