<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp" %>
<c:set var="userName" value="${sessionScope.USER.email}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ownpage for user ${userName}</title>
</head>
<body>

	<h1>Ownpage</h1>

	<h2>Inventory</h2>
	
	<h2>Tasks</h2>

	<h2>Shop</h2>
	
</body>
</html>