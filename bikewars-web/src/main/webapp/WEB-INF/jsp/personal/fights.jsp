<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="page-header">
		<h1>
			Fights <small>Gain more money by attacking other users</small>
		</h1>
	</div>


	<table
		class="table   table-condensed table-hover">
		<c:forEach items="${users}" var="user" varStatus="inx">
			<c:if test="${inx.first}">
				<tr>
					<th>User</th>
					<th>Cash</th>
					<th>&nbsp;</th>

				</tr>
			</c:if>
			<tr>
				<td><c:out value="${user.nickName}" /></td>
				<td><c:out value="${user.cash }" /></td>
				<td><button class="btn fightEvent" value="${user.userId}">attack</button>
			</tr>
		</c:forEach>
	</table>
</body>
</html>