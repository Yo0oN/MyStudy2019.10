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
	
	<hr>

	<section class="blog_area single-post-area mb-30">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h3>Q & A</h3>
				</div>
			</div>
			<br>
			<div>
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"
						data-toggle="tab" href="#qna1" style="color: black">질문분류1</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#qna2" style="color: black">질문분류2</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#qna3" style="color: black">질문분류3</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div id="qna1" class="container tab-pane active">
						<br>
						<div id="accordion">
							<div class="card">
								<div class="card-header">
									<a class="card-link" data-toggle="collapse" href="#collapseOne"
										style="color: black"> 질문1 </a>
								</div>
								<div id="collapseOne" class="collapse"
									data-parent="#accordion">
									<div class="card-body">답변1답변1답변1</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header">
									<a class="collapsed card-link" data-toggle="collapse"
										href="#collapseTwo" style="color: black"> 질문2 </a>
								</div>
								<div id="collapseTwo" class="collapse" data-parent="#accordion">
									<div class="card-body">답변2답변2답변2</div>
								</div>
							</div>
						</div>
					</div>
					<div id="qna2" class="container tab-pane fade">
						<br>
						<div id="accordion">
							<div class="card">
								<div class="card-header">
									<a class="card-link" data-toggle="collapse" href="#collapseOne"
										style="color: black"> 질문1 </a>
								</div>
								<div id="collapseOne" class="collapse"
									data-parent="#accordion">
									<div class="card-body">답변1답변1답변1</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header">
									<a class="collapsed card-link" data-toggle="collapse"
										href="#collapseTwo" style="color: black"> 질문2 </a>
								</div>
								<div id="collapseTwo" class="collapse" data-parent="#accordion">
									<div class="card-body">답변2답변2답변2</div>
								</div>
							</div>
						</div>
					</div>
					<div id="qna3" class="container tab-pane fade">
						<br>
						<div id="accordion">
							<div class="card">
								<div class="card-header">
									<a class="card-link" data-toggle="collapse" href="#collapseOne"
										style="color: black"> 질문1 </a>
								</div>
								<div id="collapseOne" class="collapse"
									data-parent="#accordion">
									<div class="card-body">답변1답변1답변1</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header">
									<a class="collapsed card-link" data-toggle="collapse"
										href="#collapseTwo" style="color: black"> 질문2 </a>
								</div>
								<div id="collapseTwo" class="collapse" data-parent="#accordion">
									<div class="card-body">답변2답변2답변2</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		</div>

		</div>
	</section>



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