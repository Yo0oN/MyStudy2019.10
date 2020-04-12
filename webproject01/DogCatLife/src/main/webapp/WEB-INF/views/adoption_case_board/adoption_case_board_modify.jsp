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
<link rel="stylesheet" href="./resources/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="./resources/assets/css/slicknav.css">
<link rel="stylesheet" href="./resources/assets/css/animate.min.css">
<link rel="stylesheet" href="./resources/assets/css/magnific-popup.css">
<link rel="stylesheet" href="./resources/assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="./resources/assets/css/themify-icons.css">
<link rel="stylesheet" href="./resources/assets/css/slick.css">
<link rel="stylesheet" href="./resources/assets/css/nice-select.css">
<link rel="stylesheet" href="./resources/assets/css/style.css">
<link rel="stylesheet" href="./resources/assets/css/responsive.css">
<link rel="stylesheet" href="./resources/assets/css/board_comment_delete.css">
<link rel="stylesheet" href="./resources/assets/css/board_list.css">
<link rel="stylesheet" href="./resources/assets/css/board_view">
<link rel="stylesheet" href="./resources/assets/css/board_write">
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
						<div class="contents_sub">
						<br/>
							<h3 class="mb-30">게시글 수정</h3>

							<ul class="blog-info-link">
								<li>작성자&nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-user"></i> 글쓴이글쓴이</li>
							</ul>
							<!-- <br/><br/> -->
							<form Method = "post" Enctype="multipart/form-date" name="frm">
								<div style = "padding: 1px 10px 1px 10px;">
									<table>										
										<tr>
											<td><br/></td>
										</tr>
										<tr>
											<td>제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<td colspan="3"><input type="text" name="msubject" value="" style="width:990px;"/></td>
										</tr>
										<tr>
											<td><br/></td>
										</tr>
										<tr>
											<td>내용&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<td colspan="3"><textarea name="mcontent" rows=40 value="내용" cols=162 wrap="hard" style="resize:none;"></textarea></td>
										</tr>
										<tr>
											<td><br/></td>
										</tr>
										<tr>
											<td>첨부&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<td colspan="3"><input type="file" name="upload" value="" class="board_write_input"/></td>
										</tr>
									</table>
								</div>
								<div class="btn_area">
									<div class="align_right" style="margin: 0px 100px 10px 0px;">		
										<input type="button" value="취소" style="display:inline-block; background:#fcfcfc; border:1px solid #bcbcbc;padding:6px 17px 7px 17px;cursor: pointer; font-weight:600;"/>
										&nbsp;&nbsp;
										<input type="button" value="수정" id="submit1" class="btn_write btn_txt01" style="cursor: pointer;" />
									</div>
								</div>
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