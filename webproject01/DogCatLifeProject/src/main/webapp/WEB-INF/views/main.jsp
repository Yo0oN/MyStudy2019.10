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
	href="../assets/img/favicon.ico">

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
	<jsp:include page='beforeLogin.jsp' />

	<jsp:include page='menu_logo_form.jsp' />


	<!-- Slider Area Start-->
	<div id="demo" class="carousel slide" data-ride="carousel"
		style="background-color: orange" align="center">
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active" />
			<li data-target="#demo" data-slide-to="1" />
			<li data-target="#demo" data-slide-to="2" />
		</ul>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="../images/spring-icon.png" width="50%" />
			</div>
			<div class="carousel-item">
				<img src="../images/spring-icon.png" width="50%" />
			</div>
			<div class="carousel-item">
				<img src="../images/spring-icon.png" width="50%" />
			</div>
		</div>
		<a href="#demo" class="carousel-control-prev" data-slide="prev"> <span
			class="carousel-control-prev-icon"></span>
		</a> <a href="#demo" class="carousel-control-next" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>

	<!-- What We do start-->
	<div class="container">
		<div class="row">
			<!-- style="margin-bottom: 4em;" -->
			<div class="col-lg-12 text-center">
				<br>
				<h3 class="wow fadeInDown title" data-wow-delay=".5s"
					style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInDown;">자랑하기</h3>
				<br>

			</div>
		</div>
		<div>
			<div class="row">
				<div class="col-4 pt-10 pb-10">
					<div>
						<a href="#"><img class="col-12 pb-10"
							src="http://com2petstory.com/data/file/2019table1/thumb-3076522375_3wmuBK7p_930339df05a539c4baf8f02b66be24ae87854251_400x400.jpg"></a>
					</div>
					<div class="col-12">
						<strong><span id="ca_name2">보호견</span></strong><br> <strong><span>라브라도리트리버</span></strong><br>
						<strong><span>베리</span></strong><br> <span>6개월령</span> / <span>여아</span><br>
						<span id="wr_datetime">등록일: 2020-04-07</span>
					</div>
				</div>

				<div class="col-4 pt-10 pb-10">
					<div>
						<a href="#"><img class="col-12 pb-10"
							src="http://com2petstory.com/data/file/2019table1/thumb-3076522375_JbY0F4lz_c4c5cea55562e48542e3be95d5d051c3a67250d3_400x400.jpg"></a>
					</div>
					<div class="col-12">
						<strong><span id="ca_name2">보호견</span></strong><br> <strong><span>믹스견</span></strong><br>
						<strong><span>봄이</span></strong><br> <span>1살</span> / <span>여아</span><br>
						<span id="wr_datetime">등록일: 2020-04-05</span>
					</div>
				</div>

				<div class="col-4 pt-10 pb-10">
					<div>
						<a href="#"><img class="col-12 pb-10"
							src="http://com2petstory.com/data/file/2019table1/thumb-3076522375_0GCIkw9R_d1d934c27b6b60ea158fa92cae12ea0c3d5052d3_400x400.jpg"></a>
					</div>
					<div class="col-12">
						<strong><span id="ca_name2">보호견</span></strong><br> <strong><span>믹스견</span></strong><br>
						<strong><span>대박이</span></strong><br> <span>3살</span> / <span>남아</span><br>
						<span id="wr_datetime">등록일: 2020-04-05</span>
					</div>
				</div>

				<div class="col-4 pt-10 pb-10">
					<div>
						<a href="#"><img class="col-12 pb-10"
							src="http://com2petstory.com/data/file/2019table1/thumb-3076522375_0odKmIzJ_3eafcd565e653567a757bde218cf41273a7cc764_400x400.jpg"></a>
					</div>
					<div class="col-12">
						<strong><span id="ca_name2">보호견</span></strong><br> <strong><span>치와와</span></strong><br>
						<strong><span>건</span></strong><br> <span>7살추정</span> / <span>남아</span><br>
						<span id="wr_datetime">등록일: 2020-04-03</span>
					</div>
				</div>

			</div>
		</div>

		<div align="center" class="mt-30 mb-30">
			<button type="button" class="btn">더보기</button>
		</div>
	</div>

	<hr>

	<!-- <div class="col-lg-12 col-md-12 text-center"> -->
	<div class="container">
		<div class="single-do text-center">
			<!-- style="padding-left: 100px; padding-right: 100px;" -->
			<div class="do-icon pb-20 pt-10">
				<h3 class="wow fadeInDown title" data-wow-delay=".5s"
					style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInDown;">커뮤니티</h3>
			</div>

			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th width="50%">제목</th>
							<th>글쓴이</th>
							<th>등록일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>3</td>
							<td><a href="#" style="color: black">제목제목</a></td>
							<td>작성자</td>
							<td>2020-01-01</td>
							<td>6</td>
						</tr>
						<tr>
							<td>2</td>
							<td><a href="#" style="color: black">제목제목</a></td>
							<td>작성자</td>
							<td>2020-01-01</td>
							<td>6</td>
						</tr>
						<tr>
							<td>1</td>
							<td><a href="#" style="color: black">제목제목</a></td>
							<td>작성자</td>
							<td>2020-01-01</td>
							<td>6</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
		<div align="center" class="mt-30 mb-30">
			<button type="button" class="btn">더보기</button>
		</div>
	</div>

	<hr>

	<div class="container">
		<div class="single-do text-center">
			<!-- style="padding-left: 100px; padding-right: 100px;" -->
			<div class="do-icon pb-20 pt-10">
				<h3 class="wow fadeInDown title" data-wow-delay=".5s"
					style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInDown;">공지사항</h3>
			</div>

			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th width="50%">제목</th>
							<th>글쓴이</th>
							<th>등록일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>3</td>
							<td><a href="#" style="color: black">제목제목</a></td>
							<td>작성자</td>
							<td>2020-01-01</td>
							<td>6</td>
						</tr>
						<tr>
							<td>2</td>
							<td><a href="#" style="color: black">제목제목</a></td>
							<td>작성자</td>
							<td>2020-01-01</td>
							<td>6</td>
						</tr>
						<tr>
							<td>1</td>
							<td><a href="#" style="color: black">제목제목</a></td>
							<td>작성자</td>
							<td>2020-01-01</td>
							<td>6</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div align="center" class="mt-30 mb-30">
			<button type="button" class="btn">더보기</button>
		</div>
	</div>

	<div class="pb-30"></div>

	<jsp:include page='footer.jsp' />

	<!-- JS here -->

	<!-- All JS Custom Plugins Link Here here -->
	<script src="../assets/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="../assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="../assets/js/popper.min.js"></script>
	<script src="../assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="../assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="../assets/js/owl.carousel.min.js"></script>
	<script src="../assets/js/slick.min.js"></script>
	<!-- Date Picker -->
	<script src="../assets/js/gijgo.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="../assets/js/wow.min.js"></script>
	<script src="../assets/js/animated.headline.js"></script>
	<script src="../assets/js/jquery.magnific-popup.js"></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="../assets/js/jquery.scrollUp.min.js"></script>
	<script src="../assets/js/jquery.nice-select.min.js"></script>
	<script src="../assets/js/jquery.sticky.js"></script>

	<!-- contact js -->
	<script src="../assets/js/contact.js"></script>
	<script src="../assets/js/jquery.form.js"></script>
	<script src="../assets/js/jquery.validate.min.js"></script>
	<script src="../assets/js/mail-script.js"></script>
	<script src="../assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="../assets/js/plugins.js"></script>
	<script src="../assets/js/main.js"></script>

</body>
</html>