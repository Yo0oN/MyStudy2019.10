<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource
	url="jdbc:mysql://127.0.0.7:3306/employees"
	driver="org.mariadb.jdbc.Driver"
	user="root"
	password="123456"
	var="ds"
 />
<%-- <sql:update dataSource="${ds}" sql="insert into dept values(91, '홍보', '서울')"/> --%>

<sql:update dataSource="${ds}" sql="insert into dept values(?, ?, ?)" >
	<sql:param value="97" />
	<sql:param value="홍보" />
	<sql:param value="대구" />
</sql:update>
실행완료
