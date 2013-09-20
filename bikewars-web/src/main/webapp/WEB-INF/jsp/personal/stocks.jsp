<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stocks</title>
</head>
<body>

	<div class="page-header">
		<h1>
			Stocks <small>For selling and buying stocks</small>
		</h1>
	</div>


	<table class="table table-striped table-bordered table-condensed table-hover">
		<c:forEach items="${stocks}" var="stock" varStatus="inx">
			<c:if test="${inx.first}">
				<tr>
					<th>Id</th>
					<th>Stock name</th>
					<th>Stock description</th>
					<th>Owned</th>
					<th>Paid</th>
					<th>Current price</th>
					<th>&nbsp;</th>
					<th colspan="4">&nbsp;</th>
				</tr>
			</c:if>
			<tr>
				<td><c:out value="${stock.stockId}" /></td>
				<td><c:out value="${stock.name}" /></td>
				<td><c:out value="${stock.description}" /></td>
				<td><c:out value="${stock.count }" /></td>
				<td><c:out value="${stock.purchasePrice}" /></td>
				<td><c:out value="${stock.currentPrice}" /></td>
				<c:choose>
				<c:when test="${not empty stock.purchasePrice }">
					<c:choose>
					<c:when test="${stock.purchasePrice lt stock.currentPrice}">
						<td><p class="text-success"><c:out value="${stock.currentPrice - stock.purchasePrice}" /></p></td>
					</c:when>
					<c:otherwise>
						<td><p class="text-danger"><c:out value="${stock.currentPrice - stock.purchasePrice}" /></p></td>	
					</c:otherwise>
					</c:choose>
				
				</c:when>
				<c:otherwise>
				<td>-</td>
				</c:otherwise>
				</c:choose>
				<td><button class="btn btn-success stockEvent" type="button" value="${stock.stockId}" name="buy5">+5</button></td>
				<td><button class="btn btn-success stockEvent" type="button" value="${stock.stockId}" name="buy">+1</button></td>
				<td><button class="btn btn-warning stockEvent" type="button" value="${stock.stockId}" name="sell">-1</button></td>
				<td><button class="btn btn-warning stockEvent"  type="button" value="${stock.stockId}" name="sell5">-5</button></td>

			</tr>

			<!-- <c:out value="${stock}" /> -->
		</c:forEach>
	</table>


</body>
</html>