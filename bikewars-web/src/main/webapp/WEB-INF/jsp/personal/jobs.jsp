<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listing jobs</title>
</head>
<body>

	<h1>Listing jobs</h1>


	<c:forEach items="${jobs}" var="job" varStatus="inx">
		<c:if test="${inx.first}">
			<table>
				<tr>
					<th>Job</th>
					<th>income</th>
					<th>energy</th>
					<th>&nbsp;</th>
					
				</tr>
				</c:if>
				<tr>
					<td><c:out value="${job.name}" /><br /><c:out value="${job.description}" /></td>
					<td><c:out value="${job.income}" /></td>
					<td><c:out value="${job.energy}" /></td>
					<td>
					
						<button name="execute" name="job" value="${job.id}">Execute</button>
					</td>
				</tr>
				<c:if test="${inx.last}">
			</table>
		</c:if>
	</c:forEach>


</body>
</html>