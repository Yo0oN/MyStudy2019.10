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
	href="resources/assets/img/favicon.ico">

<!-- CSS here -->
<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="resources/assets/css/flaticon.css">
<link rel="stylesheet" href="resources/assets/css/slicknav.css">
<link rel="stylesheet" href="resources/assets/css/animate.min.css">
<link rel="stylesheet" href="resources/assets/css/magnific-popup.css">
<link rel="stylesheet"
	href="resources/assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="resources/assets/css/themify-icons.css">
<link rel="stylesheet" href="resources/assets/css/slick.css">
<link rel="stylesheet" href="resources/assets/css/nice-select.css">
<link rel="stylesheet" href="resources/assets/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#confirmbtn').on('click', function() {
			var useremail = $('#email').val().trim();
			$.ajax({
				url : 'join_mail_confirm.mysql',
				data : {
					useremail : useremail
				},
				type : 'post',
				success : function(data) {
					if (data.length >= 6) {
						alert('인증메일을 전송하였습니다. 확인해주세요.');
						$('#confirmnumber').attr('vlaue', data);
					} else {
						if (data == "1") {
							alert('인증메일 전송에 실패하였습니다.1');
						} else if (data == "2"){
							alert('등록된 이메일입니다.');
						} else {
							alert('인증메일 전송에 실패하였습니다.' + data);
						}
					}
				},
				error : function(error) {
					alert('인증메일 발송에 실패하였습니다. 다시 시도해주세요.');
				}
			})
		})
		$('#submit').on('click', function() {
			if ($('#id').val().trim() == "") {
				alert('ID를 입력해주세요.');
				return false;
			}
			if ($('#password').val().trim() == "") {
				alert('암호를 입력해주세요.');
				return false;
			}
			if ($('#nickname').val().trim() == "") {
				alert('별명을 입력해주세요.');
				return false;
			}
			if ($('#name').val().trim() == "") {
				alert('이름를 입력해주세요.');
				return false;
			}
			if ($('#phone').val().trim() == "") {
				alert('전화번호를 입력해주세요.');
				return false;
			}
			if ($('#email').val().trim() == "") {
				alert('이메일을 입력해주세요.');
				return false;
			}
			if ($('#confirm').val().trim() == "") {
				alert('인증번호를 입력해주세요.');
				return false;
			}
			$('#frm').submit();
		});
	})
</script>
</head>

<body>

	<jsp:include page='../beforeLogin.jsp' />
	<jsp:include page='../menu_logo_form.jsp' />

	<hr>

	<section class="blog_area single-post-area mb-30">
		<div class="container">

			<div class="row">
				<div class="col-lg-12">
					<h3>회원가입</h3>
				</div>
			</div>
			<!-- <div class="row"> -->
			<form action="join_ok.mysql" method="post" id="frm">
				<input type="hidden" id="confirmnumber" value="">
				<div class="row">
					<div class="mt-20 col-12">
						<input type="text" id="id" name="id" placeholder="ID"
							onfocus="this.placeholder = ''" onblur="this.placeholder = 'ID'"
							required class="single-input-primary">
					</div>
					<div class="mt-20 col-12">
						<input type="password" id="password" name="password" placeholder="암호"
							onfocus="this.placeholder = ''" onblur="this.placeholder = '암호'"
							required class="single-input-primary">
					</div>
					<div class="mt-20 col-12">
						<input type="text" id="nickname" name="nickname" placeholder="별명"
							onfocus="this.placeholder = ''" onblur="this.placeholder = '별명'"
							required class="single-input-primary">
					</div>
					<div class="mt-20 col-12">
						<input type="text" id="name" name="name" placeholder="이름"
							onfocus="this.placeholder = ''" onblur="this.placeholder = '이름'"
							required class="single-input-primary">
					</div>
					<!-- <div class="mt-20 col-12 default-select" id="default-select">
						<select name="cars" class="custom-select">
							<option value="f">여자</option>
							<option value="m">남자</option>
						</select>
					</div> -->
					<div class="mt-20 col-12">
						<input type="text" id="phone" name="phone" placeholder="전화번호"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = '전화번호'" required
							class="single-input-primary">
					</div>
					<div class="mt-20 col-10">
						<input type="text" id="email" name="email" placeholder="이메일"
							onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일'"
							required class="single-input-primary" value="">
					</div>
					<div class="col-2" id="confirmbtn">
						<span style="background-color: #2B4B80"
							class="btn pt-20 pb-20 pl-30 pr-30">메일 인증</span>
					</div>
					<div class="col-12 mt-20">
						<input type="text" id="confirm" name="confirm" placeholder="인증번호를 입력하세요."
							onfocus="this.placeholder = ''" onblur="this.placeholder = '인증번호를 입력하세요.'"
							required class="single-input-primary">
					</div>
				</div>
				<div class="col-12 mt-30" style="text-align: right">
					<span id="submit" style="background-color: #2B4B80"
						class="btn pt-20 pb-20 pl-30 pr-30">회원 가입</span>
				</div>
				
			</form>

		</div>

		<!-- </div> -->
	</section>

	<jsp:include page='../footer.jsp' />

	<!-- JS here -->

	<!-- All JS Custom Plugins Link Here here -->
	<script src="resources/assets/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="resources/assets/js/popper.min.js"></script>
	<script src="resources/assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="resources/assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="resources/assets/js/owl.carousel.min.js"></script>
	<script src="resources/assets/js/slick.min.js"></script>
	<!-- Date Picker -->
	<script src="resources/assets/js/gijgo.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="resources/assets/js/wow.min.js"></script>
	<script src="resources/assets/js/animated.headline.js"></script>
	<script src="resources/assets/js/jquery.magnific-popup.js"></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="resources/assets/js/jquery.scrollUp.min.js"></script>
	<script src="resources/assets/js/jquery.nice-select.min.js"></script>
	<script src="resources/assets/js/jquery.sticky.js"></script>

	<!-- contact js -->
	<script src="resources/assets/js/contact.js"></script>
	<script src="resources/assets/js/jquery.form.js"></script>
	<script src="resources/assets/js/jquery.validate.min.js"></script>
	<script src="resources/assets/js/mail-script.js"></script>
	<script src="resources/assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="resources/assets/js/plugins.js"></script>
	<script src="resources/assets/js/main.js"></script>

</body>
</html>