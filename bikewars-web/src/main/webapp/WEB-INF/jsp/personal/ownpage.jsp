<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp"%>
<c:set var="userName" value="${sessionScope.USER.email}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ownpage for user ${userName}</title>
</head>
<body>

	<div class="page-header">
		<h1>
			Ownpage <small>Your personal profile page</small>
		</h1>
	</div>

	<div class="row">
		<div class="span5">
			<h2>Inventory</h2>

		</div>
		<div class="span5">
			<h2>Fights</h2>
			<c:forEach items="${fights}" var="fight" >
                <c:out value="${fight}" />
			</c:forEach>
		</div>

	</div>
	<div class="row">
		<div class="span5">
		<h2>Shop</h2>
		
		</div>
		<div class="span5">
		<h2>Rankings</h2>	
		</div>
		

	</div>

</body>
</html>