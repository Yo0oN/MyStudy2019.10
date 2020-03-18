<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#project-label {
	display: block;
	font-weight: bold;
	margin-bottom: 1em;
}

#project-icon {
	float: left;
	height: 32px;
	width: 32px;
}

#project-description {
	margin: 0;
	padding: 0;
}
</style>
<link rel="stylesheet" href="../css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var projects = [ {
					value : "jquery",
					label : "jQuery",
					desc : "the write less, do more, JavaScript library",
					icon : "jquery_32x32.png"
				}, {
					value : "jquery-ui",
					label : "jQuery UI",
					desc : "the official user interface library for jQuery",
					icon : "jqueryui_32x32.png"
				}, {
					value : "sizzlejs",
					label : "Sizzle JS",
					desc : "a pure-JavaScript CSS selector engine",
					icon : "sizzlejs_32x32.png"
				} ];

				$("#project").autocomplete(
						{
							minLength : 0,
							source : projects,
							focus : function(event, ui) {
								$("#project").val(ui.item.label);
								return false;
							},
							select : function(event, ui) {
								$("#project").val(ui.item.label);
								$("#project-id").val(ui.item.value);
								$("#project-description").html(ui.item.desc);
								$("#project-icon").attr("src",
										"images/" + ui.item.icon);

								return false;
							}
						}).autocomplete("instance")._renderItem = function(ul,
						item) {
					return $("<li>").append(
							"<div>" + item.label + "<br>" + item.desc
									+ "</div>").appendTo(ul);
				};
			});
</script>
</head>
<body>
	<div class="ui-widget">
		<label for="tags">Select a project(type "j" for a start)</label>
		<br>
		<input type="text" id="project">
	</div>
</body>
</html>