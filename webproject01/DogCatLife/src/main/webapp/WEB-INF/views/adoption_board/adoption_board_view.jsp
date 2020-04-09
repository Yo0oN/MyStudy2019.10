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
	href="../../assets/img/favicon.ico">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="../../assets/css/slicknav.css">
<link rel="stylesheet" href="../../assets/css/animate.min.css">
<link rel="stylesheet" href="../../assets/css/magnific-popup.css">
<link rel="stylesheet" href="../../assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="../../assets/css/themify-icons.css">
<link rel="stylesheet" href="../../assets/css/slick.css">
<link rel="stylesheet" href="../../assets/css/nice-select.css">
<link rel="stylesheet" href="../../assets/css/style.css">
<link rel="stylesheet" href="../../assets/css/responsive.css">
</head>

<body>

	<!-- Preloader Start -->
	<!-- 페이지 들어올 때 애니메이션 -->
	<!-- <div id="preloader-active">
      <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
               <div class="preloader-circle"></div>
               <div class="preloader-img pere-text">
                  <img src="../../assets/img/logo/logo.png" alt="">
               </div>
            </div>
      </div>
   </div> -->
	<!-- Preloader Start-->
	<jsp:include page='../beforeLogin.jsp' />
	<jsp:include page='../menu_logo_form.jsp' />

	<hr>
	<!-- Slider Area Start-->
	<!-- <div class="services-area">
		<div class="container">
			Section-tittle
			<div class="row d-flex justify-content-center">
				<div class="col-lg-8">
					<div class="section-tittle text-center mb-80">
						<span>view 페이지는 디자인이안정해져서</span>
						<h2>아직 수정안함. 여기는 제목이오는듯</h2>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	<!-- Slider Area End-->

	<!--================Blog Area =================-->
	<section class="blog_area single-post-area">
		<!-- class=section-padding 패딩필요없을거같아서뺐음 -->
		<div class="container">
			<!-- <div style="align: center" class="mb-30">
				 section-tittle
				<h2>커뮤니티 게시판</h2>
			</div> -->


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
								<img class="img-fluid" src="../../assets/img/blog/single_blog_1.png"
									alt="">
							</div>

							<p>
								내용내용내용내용내용<br>내용내용내용
							</p>

						</div>
					</div>

					<!-- 이전글 다음글 -->
					<!-- <div class="navigation-top">
						<div class="navigation-area">
							<div class="row">
								<div
									class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
									<div class="thumb">
										<a href="#"> <img class="img-fluid"
											src="../../assets/img/post/preview.png" alt="">
										</a>
									</div>
									<div class="arrow">
										<a href="#"> <span class="lnr text-white ti-arrow-left"></span>
										</a>
									</div>
									<div class="detials">
										<p>Prev Post</p>
										<a href="#">
											<h4>이전글</h4>
										</a>
									</div>
								</div>
								<div
									class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
									<div class="detials">
										<p>Next Post</p>
										<a href="#">
											<h4>다음글</h4>
										</a>
									</div>
									<div class="arrow">
										<a href="#"> <span class="lnr text-white ti-arrow-right"></span>
										</a>
									</div>
									<div class="thumb">
										<a href="#"> <img class="img-fluid"
											src="../../assets/img/post/next.png" alt="">
										</a>
									</div>
								</div>
							</div>
						</div>
					</div> -->


					<!-- 작성자정보인데 우리는이거도 필요없음 -->
					<!-- <div class="blog-author">
						<div class="media align-items-center">
							<img src="../../assets/img/blog/author.png" alt="">
							<div class="media-body">
								<a href="#">
									<h4>Harvard milan</h4>
								</a>
								<p>Second divided from form fish beast made. Every of seas
									all gathered use saying you're, he our dominion twon Second
									divided from</p>
							</div>
						</div>
					</div> -->


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
	</section>
	<!--================ Blog Area end =================-->

	<jsp:include page='../footer.jsp' />

	<!-- JS here -->

	<!-- All JS Custom Plugins Link Here here -->
	<script src="./../../assets/js/vendor/modernizr-3.5.0.min.js"></script>

	<!-- Jquery, Popper, Bootstrap -->
	<script src="./../../assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="./../../assets/js/popper.min.js"></script>
	<script src="./../../assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="./../../assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="./../../assets/js/owl.carousel.min.js"></script>
	<script src="./../../assets/js/slick.min.js"></script>
	<!-- Date Picker -->
	<script src="./../../assets/js/gijgo.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="./../../assets/js/wow.min.js"></script>
	<script src="./../../assets/js/animated.headline.js"></script>
	<script src="./../../assets/js/jquery.magnific-popup.js"></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="./../../assets/js/jquery.scrollUp.min.js"></script>
	<script src="./../../assets/js/jquery.nice-select.min.js"></script>
	<script src="./../../assets/js/jquery.sticky.js"></script>

	<!-- contact js -->
	<script src="./../../assets/js/contact.js"></script>
	<script src="./../../assets/js/jquery.form.js"></script>
	<script src="./../../assets/js/jquery.validate.min.js"></script>
	<script src="./../../assets/js/mail-script.js"></script>
	<script src="./../../assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="./../../assets/js/plugins.js"></script>
	<script src="./../../assets/js/main.js"></script>


</body>

</html>