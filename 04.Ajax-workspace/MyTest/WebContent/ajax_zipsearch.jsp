<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	/* background-color: #333333; */
}

li {
	float: left;
}

li.m {
	display: block;
	color: white;
	text-align: center;
	padding: 16px;
	text-decoration: none;
	background-color: #333333
}

li.z {
	display: block;
	color: black;
	padding: 5px;
}
</style>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('btn').onclick = function() {
			console.log(document.getElementById('dong').value);
			var request = new XMLHttpRequest();

			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200) {
						var data = request.response;

						var json = JSON.parse(data);

						var result = "<ul>";
						result += '<li class="m" >zipcode</li><li class="m" ">sido</li><li class="m">gugun</li><li class="m">dong</li><li class="m">bunji</li><li class="m">ri</li><li class="m">seq</li>';
						result += '</ul>';
						result += '<ul>';
						result += '<li>';

						for (var i = 0; i < json.length; i++) {
							result += "<ul>";
							result += '<li class="z" width="55">' + json[i]['zipcode']
									+ '</li>';
							result += '<li class="z" width="35">' + json[i]['sido']
									+ '</li>';
							result += '<li class="z" width="48">' + json[i]['gugun']
									+ '</li>';
							result += '<li class="z" width="60">' + json[i]['dong']
									+ '</li>';
							result += '<li class="z" width="90">' + json[i]['bunji']
									+ '</li>';
							result += '<li class="z" width="115">' + json[i]['ri']
									+ '</li>';
							result += '<li class="z" width="10">' + json[i]['seq']
									+ '</li>';
							result += "</ul>";
						}
						result += '</ li>';
						result += "</ul>";

						document.getElementById('result').innerHTML = result;
					} else {
						alert('error : ' + request.status + ", "
								+ request.readyState);
					}
				}
			}

			var dong = encodeURIComponent(document.getElementById('dong').value);
			request.open('get', './ajax_zipsearch_db.jsp?dong=' + dong, true);
			request.send();
		}
	}
</script>
</head>
<body>
	ajax_zipsearch.jsp
	<hr>
	동 :
	<input type="text" id="dong">
	<button id="btn">검색</button>
	<hr>
	<div id="result"></div>
</body>
</html>