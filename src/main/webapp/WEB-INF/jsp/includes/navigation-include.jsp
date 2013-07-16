<%@page pageEncoding="utf-8"%>
<%@include file="../taglibs.jsp"%>

<div class="navbar-inner">
	<div class="container">
		<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="brand" href="#">BikeWars</a>
		<div class="nav-collapse collapse">
			<ul class="nav">
				<li class="active"><a href='<c:url value="/index.htm" />'>Home</a></li>
				<li><a href='<c:url value="/secure/profile.htm" />'>Profile</a></li>
				<li><a href="#contact">Stocks</a></li>
				<li><a href="#contact">Cities</a></li>
			</ul>

			<c:choose>
			<c:when test="${not sessionScope.isLogged}">
				<form class="navbar-form pull-right" action='<c:url value="/user-login.htm" />' method="post">
					<input class="span2" type="text" name="username" placeholder="Email"> <input class="span2" type="password" name="password" placeholder="Password">
					<button type="submit" class="btn">Sign in</button>
				</form>
			</c:when>
			<c:otherwise>
				<p class="nav pull-right">${sessionScope.userName}</p>
			</c:otherwise>
			</c:choose>
			
			
		</div>
		<!--/.nav-collapse -->
	</div>
</div>