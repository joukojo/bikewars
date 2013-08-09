<!DOCTYPE html>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>



<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglibs.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="bikewars" /></title>
<link href='<c:url value="/css/bootstrap.css" />' rel="stylesheet" media="screen">
<link href='<c:url value="/css/style.css" />' rel="stylesheet" media="screen">
<link href='<c:url value="/css/bootstrap-responsive.css" />' rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="<c:url value="/js/html5shiv.js" />"></script>
    <![endif]-->
    
    <decorator:head />
</head>

<body>
	<div id="wrap">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<jsp:include page="/WEB-INF/jsp/includes/navigation-include.jsp" />
			<div class="container">

				<decorator:body />
			</div>
		</div>
		<div id="push"></div>
	</div>
	<div id="footer">
		<div class="container">
			<p class="muted credit">
				&copy; Bikewars 2013
			</p>
		</div>

	</div>
	<script type="text/javascript" src='<c:url value="/js/jquery-1.10.2.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="/js/bootstrap.min.js" />'></script>

</body>

</html>