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

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon"
	href="./resources/assets/img/favicon.ico">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet" href="./resources/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="./resources/assets/css/slicknav.css">
<link rel="stylesheet" href="./resources/assets/css/animate.min.css">
<link rel="stylesheet" href="./resources/assets/css/magnific-popup.css">
<link rel="stylesheet"
	href="./resources/assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="./resources/assets/css/themify-icons.css">
<link rel="stylesheet" href="./resources/assets/css/slick.css">
<link rel="stylesheet" href="./resources/assets/css/nice-select.css">
<link rel="stylesheet" href="./resources/assets/css/style.css">
<link rel="stylesheet" href="./resources/assets/css/responsive.css">
</head>

<body>

	<jsp:include page='../beforeLogin.jsp' />
	<jsp:include page='../menu_logo_form.jsp' />

	<hr>

	<!--================Blog Area =================-->
	<section class="blog_area single-post-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div>
						<div>
							<h2 class="mb-30">제목제목제목</h2>

							<ul class="blog-info-link">
								<li><i class="fa fa-user"></i> 글쓴이글쓴이</li>
								<li><i class="fa fa-comments"></i> 3 Comments</li>
							</ul>

							<hr style="margin: 10px">

							<div class="mb-30 mt-30">
								<img class="img-fluid"
									src="./resources/assets/img/blog/single_blog_1.png" alt="">
							</div>

							<p>
								내용내용내용내용내용<br>내용내용내용
							</p>

						</div>
					</div>

					<!-- 댓글부분 -->
					<div class="comments-area">
						<h4>01 Comments</h4>
						<div class="comment-list">
							<div class="single-comment justify-content-between d-flex"
								style="border-bottom: 1px solid #ECEFF8">
								<div class="user justify-content-between d-flex">
									<div class="desc">
										<div class="d-flex justify-content-between">
											<div class="d-flex align-items-center">
												<h5>댓글작성자</h5>
												<p class="date">December 4, 2017 at 3:12 pm</p>
											</div>
										</div>
										<p>댓글댓글</p>
									</div>
								</div>
							</div>
							<div class="single-comment justify-content-between d-flex"
								style="border-bottom: 1px solid #ECEFF8">
								<div class="user justify-content-between d-flex">
									<div class="desc">
										<div class="d-flex justify-content-between">
											<div class="d-flex align-items-center">
												<h5>댓글작성자</h5>
												<p class="date">December 4, 2017 at 3:12 pm</p>
											</div>
										</div>
										<p>댓글댓글</p>
									</div>
								</div>
							</div>
							<div class="single-comment justify-content-between d-flex"
								style="border-bottom: 1px solid #ECEFF8">
								<div class="user justify-content-between d-flex">
									<div class="desc">
										<div class="d-flex justify-content-between">
											<div class="d-flex align-items-center">
												<h5>댓글작성자</h5>
												<p class="date">December 4, 2017 at 3:12 pm</p>
											</div>
										</div>
										<p>댓글댓글</p>
									</div>
								</div>
							</div>

						</div>

						<!-- 댓글쓰기 -->
						<div class="comment-form">
							<!-- <h4>댓글쓰기</h4> -->

							<form class="form-contact comment_form" action="#"
								id="commentForm">
								<div class="row">
									<div class="col-12">
										<div class="form-group">
											<textarea class="form-control w-100" name="comment"
												id="comment" cols="30" rows="9" placeholder="Write Comment"></textarea>
										</div>
									</div>
									<div class="col-12" align="right">
										<button type="button" style="background-color: #2B4B80"
											class="btn" disabled>댓글 쓰기</button>
									</div>
								</div>

								<!-- <div class="form-group">
								<button type="submit"
									class="button button-contactForm btn_1 boxed-btn">Send
									Message</button>
							</div> -->
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================ Blog Area end =================-->

	<jsp:include page='../footer.jsp' />

	<!-- JS here -->

	<!-- All JS Custom Plugins Link Here here -->
	<script src="./resources/assets/js/vendor/modernizr-3.5.0.min.js"></script>

	<!-- Jquery, Popper, Bootstrap -->
	<script src="./resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="./resources/assets/js/popper.min.js"></script>
	<script src="./resources/assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="./resources/assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="./resources/assets/js/owl.carousel.min.js"></script>
	<script src="./resources/assets/js/slick.min.js"></script>
	<!-- Date Picker -->
	<script src="./resources/assets/js/gijgo.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="./resources/assets/js/wow.min.js"></script>
	<script src="./resources/assets/js/animated.headline.js"></script>
	<script src="./resources/assets/js/jquery.magnific-popup.js"></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="./resources/assets/js/jquery.scrollUp.min.js"></script>
	<script src="./resources/assets/js/jquery.nice-select.min.js"></script>
	<script src="./resources/assets/js/jquery.sticky.js"></script>

	<!-- contact js -->
	<script src="./resources/assets/js/contact.js"></script>
	<script src="./resources/assets/js/jquery.form.js"></script>
	<script src="./resources/assets/js/jquery.validate.min.js"></script>
	<script src="./resources/assets/js/mail-script.js"></script>
	<script src="./resources/assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="./resources/assets/js/plugins.js"></script>
	<script src="./resources/assets/js/main.js"></script>


</body>

</html>