<%@page import="TOs.BoardTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TOs.BoardListsTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nowUrl = "faqlist.mysql?" + request.getQueryString();
	session.setAttribute("endUrl", nowUrl);
	
	String sess_mseq = (String) session.getAttribute("sess_mseq");
	String sess_nickname = (String) session.getAttribute("sess_nickname");
	BoardListsTO boardListsTO = (BoardListsTO) request.getAttribute("boardListsTO");

	// 현재 게시판
	String pseq = boardListsTO.getPseq() + "";
	
	// 현재페이지
	int cpage = boardListsTO.getCpage();
	// 한 페이지당 출력 데이터 개수
	int recordPerPage = boardListsTO.getRecordPerPage();
	// 전체 페이지 개수 = 마지막 페이지
	int totalPage = boardListsTO.getTotalPage();
	// 전체 데이터(글) 개수
	int totalRecord = boardListsTO.getTotalRecord();
	// 페이지번호가 몇개씩 보이게 할지 설정
	int blockPerPage = boardListsTO.getBlockPerPage();
	// 보이는 페이지 번호의 시작부분이다.
	int startBlock = boardListsTO.getStartBlock();
	// 보이는 페이지 번호의 끝부분이다.
	int endBlock = boardListsTO.getEndBlock();
	// 목록을 받아옴
	ArrayList<BoardTO> toLists = boardListsTO.getBoardLists();

	StringBuffer sbHTML = new StringBuffer();
	if (toLists.size() == 0) {
		sbHTML.append("<td class='text-center' colspan='5'>등록 된 게시글이 없습니다.</td>");
	} else {
		for (int i = 0; i < toLists.size(); i++) {
			BoardTO boardTO = toLists.get(i);

			pseq = boardTO.getPseq();
			String seq = boardTO.getSeq();
			String subject = boardTO.getSubject();
			String content = boardTO.getContent();
			
			
			sbHTML.append("<div id=\"accordion1\" class=\"panel-group accordion\">");
			
			sbHTML.append("<div class=\"panel\">");
			sbHTML.append("	<div class=\"panel-title\">");
			sbHTML.append("		<a data-parent=\"#accordion1\" data-toggle=\"collapse\" href=\"#accordion_1\" aria-expanded=\"false\">");
			sbHTML.append("			<span class=\"open-sub\"></span> <strong>"+subject+"</strong>");
			sbHTML.append("		</a>");
			sbHTML.append("	</div>");
			sbHTML.append("	<div id=\"accordion_1\" class=\"panel-collapse collapse\" role=\"tablist\" aria-expanded=\"true\">");
			sbHTML.append("		<div class=\"panel-content\">"+content+"</div>");
			sbHTML.append("	</div>");
			sbHTML.append("</div>");
			sbHTML.append("</div>");
			
			

			
		}
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="utf-8">
<meta name="author" content="soledot">
<meta name="description" content="애완동물을 위한, DogCatLife 입니다.">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="ALL">

<meta property="og:title" content="DogCatLife">
<meta property="og:description" content="애완동물을 위한, DogCatLife 입니다.">
<meta property="og:image" content="resources/images/logo.png">
<!-- <meta property="og:url" content="http://medisvc.com/home/fo/index.sd"> -->
<meta property="og:type" content="website">

<title>DogCatLife</title>

<!-- commoncss -->


<!-- Favicon and Touch Icons -->
<link href="resources/sitedesign/images/favicon.png" rel="shortcut icon"
	type="image/png">
<link href="resources/sitedesign/images/apple-touch-icon.png"
	rel="apple-touch-icon">
<link href="resources/sitedesign/images/apple-touch-icon-72x72.png"
	rel="apple-touch-icon" sizes="72x72">
<link href="resources/sitedesign/images/apple-touch-icon-114x114.png"
	rel="apple-touch-icon" sizes="114x114">
<link href="resources/sitedesign/images/apple-touch-icon-144x144.png"
	rel="apple-touch-icon" sizes="144x144">

<!-- Stylesheet -->
<link href="resources/sitedesign/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/sitedesign/css/jquery-ui.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/sitedesign/css/animate.css" rel="stylesheet"
	type="text/css">
<link href="resources/sitedesign/css/css-plugin-collections.css"
	rel="stylesheet" />
<!-- CSS | menuzord megamenu skins -->

<link id="menuzord-menu-skins"
	href="resources/sitedesign/css/menuzord-skins/menuzord-subcolored.css"
	rel="stylesheet" />

<!-- CSS | Main style file -->
<link href="resources/sitedesign/css/style-main.css" rel="stylesheet"
	type="text/css">
<!-- CSS | Preloader Styles -->

<!-- CSS | Custom Margin Padding Collection -->
<link
	href="resources/sitedesign/css/custom-bootstrap-margin-padding.css"
	rel="stylesheet" type="text/css">
<!-- CSS | Responsive media queries -->
<link href="resources/sitedesign/css/responsive.css" rel="stylesheet"
	type="text/css">
<!-- CSS | Style css. This is the file where you can place your own custom css code. Just uncomment it and use it. -->
<!-- <link href="resources/sitedesign/css/style.css" rel="stylesheet" type="text/css"> -->

<!-- CSS | Theme Color -->
<link href="resources/sitedesign/css/colors/theme-skin-blue.css"
	rel="stylesheet" type="text/css">

<link href="resources/soledot/css/fo/soledot.css" rel="stylesheet"
	type="text/css">

<!-- Revolution Slider 5.x CSS settings -->
<link href="resources/sitedesign/js/revolution-slider/css/settings.css"
	rel="stylesheet" type="text/css" />
<link href="resources/sitedesign/js/revolution-slider/css/layers.css"
	rel="stylesheet" type="text/css" />
<link
	href="resources/sitedesign/js/revolution-slider/css/navigation.css"
	rel="stylesheet" type="text/css" />

<!-- commonheaderjs -->


<!-- external javascripts -->
<script src="resources/sitedesign/js/jquery-2.2.0.min.js"></script>
<script src="resources/sitedesign/js/jquery-ui.min.js"></script>
<script src="resources/sitedesign/js/bootstrap.min.js"></script>
<!-- JS | jquery plugin collection for this theme -->
<script src="resources/sitedesign/js/jquery-plugin-collection.js"></script>

<!-- Revolution Slider 5.x SCRIPTS 메인에만 필요?-->
<script
	src="resources/sitedesign/js/revolution-slider/js/jquery.themepunch.tools.min.js"></script>
<script
	src="resources/sitedesign/js/revolution-slider/js/jquery.themepunch.revolution.min.js"></script>

</head>

<body
	class="has-side-panel side-panel-right fullwidth-page side-push-panel">

	<div class="body-overlay"></div>

	<div id="wrapper" class="clearfix">
		<jsp:include page='../login_menu.jsp' />

		<!-- Start main-content -->
		<div class="main-content">
			<!-- Section: inner-header -->
			<section class="inner-header divider layer-overlay overlay-light"
				style="background-image: url('resources/images/dogcat_board_main.jpg');"
				data-bg-img="resources/images/dogcat_board_main.jpg">
				<div class="container pt-90 pb-50">
					<!-- Section Content -->
					<div class="section-content">
						<div class="row">
							<div class="col-md-12 xs-text-center">
								<h3 class="text-theme-colored font-36">고객센터</h3>
								<ol class="breadcrumb white mt-10">
									<li><a href="main.mysql">Home</a></li>
									<li><a href="album_board_list.mysql?pseq=12">고객센터</a></li>
									<li class="active text-theme-colored">공지사항</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
			</section>
			
			<!-- Section: event calendar -->
			<section>
				<div class="container">
					<div class="row">
						<div class="col-sm-12 col-md-12">
							<div class="row">
								<div class="col-sm-12 col-md-2">
									<div class="sidebar sidebar-left mt-sm-30">
										<div class="widget">
											<h5 class="widget-title line-bottom"><a href="">고객센터</a></h5>
											<div class="categories">
												<ul class="list list-border angle-double-right">
													<li><a href="noticelist.mysql?pseq=41">공지사항</a></li>
													<li><a href="faqlist.mysql?pseq=42">FAQ</a></li>
													<li><a href="./commonagree.mysql">이용약관</a></li>
													<li><a href="./commontext.mysql">개인정보처리방침</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-9">
									<!-- 게시판 타이틀 -->
									<div class="section-title mb-10">
										<div class="row">
											<div class="col-md-12">
												<div class="text-center">
													<h2 class="title heading-line-bottom">FAQ</h2>
												</div>
											</div>
										</div>
									</div>
									
									<div>
										<div class="row">
											<div class="col-md-12">
												<div>
													<%=sbHTML %>
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
		</div>
	</div>
	<!-- end main-content -->

	<!-- footer content -->


	<jsp:include page="../footer.jsp"></jsp:include>

	<!-- JS | Custom script for all pages -->
	<script src="resources/sitedesign/js/custom.js"></script>

	<!-- notify -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/mouse0270-bootstrap-notify/3.1.7/bootstrap-notify.min.js"></script>

	<!-- jquery-cookie-->
	<script src="resources/common/js/jquery-cookie/jquery.cookie.js"></script>

	<!-- soledot -->
	<script src="resources/soledot/js/fo/soledot.js"></script>
</body>
</html>