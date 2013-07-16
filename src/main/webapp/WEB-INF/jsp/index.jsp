<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="taglibs.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/css/bootstrap.css" />' rel="stylesheet"
	media="screen">

<link href='<c:url value="/css/bootstrap-responsive.css" />'
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="<c:url value="/js/html5shiv.js" />"></script>
    <![endif]-->

</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<jsp:include page="/WEB-INF/jsp/includes/navigation-include.jsp" />
		<div class="container">

			<div class="hero-unit">
				<h1>Hello world</h1>
				<p>Some text here</p>
			</div>
		</div>
	</div>


	<script type="text/javascript"
		src='<c:url value="/js/jquery-1.10.2.min.js" />'></script>
	<script type="text/javascript"
		src='<c:url value="/js/bootstrap.min.js" />'></script>
</body>
</html>