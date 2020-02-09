<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str1" value="   Hello JSTL, Hello JSTL   " />
	<!-- function은 태그보다는 EL과 많이쓰임 -->
	${ fn:length(str1) }
	<br> ${ fn:toUpperCase(str1) }
	<br> ${ fn:substring(str1, 6, 13) }
	<br> ${ fn:trim(str1) }
	<br> ${ fn:replace(str1, " ", "-") }
	<br> ${ fn:indexOf(str1, "JS") }
	<br>

	<c:set var="tokens" value="1,2,3,4,5" />
	<!-- split으로 분리하여 배열에 넣음 -->
	<c:set var="intArr" value="${ fn:split(tokens, ',') }" />
	<!-- join으로 다시 합침 -->
	${ fn:join(intArr, "-") }
	<br>
	
	<c:set var="strXML" value="<html><head></head></html>" />
	<!-- 원래 태그에 사용되는 <> 괄호는 밖에다 사용하면,
		저절로 해석되어 보이지 않지만, escpeXml을 사용하여 출력하면
		소스를 해석하지 않고 그대로 출력해준다. -->
	${fn:escapeXml(strXML) }
</body>
</html>
