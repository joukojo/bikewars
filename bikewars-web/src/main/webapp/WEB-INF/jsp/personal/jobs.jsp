<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listing jobs</title>
</head>
<body>

	<div class="page-header">
		<h1>
			Jobs <small>For executing jobs to gain money</small>
		</h1>
	</div>


	<table class="table   table-condensed table-hover">
		<c:forEach items="${jobs}" var="job" varStatus="inx">
			<c:if test="${inx.first}">
				<thead>
				<tr>
					<th>Job</th>
					<th>income</th>
					<th>energy</th>
					<th>&nbsp;</th>
				</tr>
				</thead>
			</c:if>
			<tbody>
				<tr>
					<td><c:out value="${job.name}" /><br /> <c:out value="${job.description}" /></td>
					<td><c:out value="${job.income}" /></td>
					<td><c:out value="${job.energy}" /></td>
					<td>
						<button class="btn btn-success jobExecute btn-xs" name="execute" name="job" value="${job.jobId}">Execute</button>
					</td>
				</tr>
			</tbody>
		</c:forEach>


	</table>
</body>
</html>