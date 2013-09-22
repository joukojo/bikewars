<%@page pageEncoding="utf-8"%>
<%@include file="../taglibs.jsp"%>
<c:if test="${not empty sessionScope.USER}" var="isLogged" />


<div class="navbar-inner">
	<div class="container">
		<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="brand" href='<c:url value="/index.htm" />'>BikeWars</a>
		<div class="nav-collapse collapse">
			<ul class="nav">
				<li class="active"><a href='<c:url value="/index.htm" />'>Home</a></li>
				<c:choose>
					<c:when test="${isLogged}">
						<li><a href='${pageContext.request.contextPath}/personal/ownpage.htm'>Ownpage</a></li>
						<li><a href='${pageContext.request.contextPath}/personal/stocks.htm' >Stocks</a></li>
						<li><a href='${pageContext.request.contextPath}/personal/jobs.htm' >Jobs</a></li>
						<li><a href='${pageContext.request.contextPath}/personal/cities.htm'>Cities</a></li>
						<li><a href='${pageContext.request.contextPath}/personal/fights.htm'>Fight!</a></li>
					</c:when>
					<c:otherwise>
						<li><a href='${pageContext.request.contextPath}/register.htm'>Register</a></li>
					</c:otherwise>
				</c:choose>
			</ul>

			<c:choose>
				<c:when test="${not isLogged}">
					<form class="navbar-form pull-right" action='${pageContext.request.contextPath}/user-login.htm' method="post">
						<input class="span2" type="text" name="username" placeholder="Email"> <input class="span2" type="password" name="password" placeholder="Password">
						<button type="submit" class="btn">Sign in</button>
					</form>
				</c:when>
				<c:otherwise>
					<c:set var="userName" value="${sessionScope.USER.email}" />
					<p class="nav pull-right">${userName}</p>
				</c:otherwise>
			</c:choose>


		</div>
		<!--/.nav-collapse -->
	</div>
</div>