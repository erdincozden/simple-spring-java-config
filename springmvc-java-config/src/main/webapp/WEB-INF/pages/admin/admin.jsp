<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADMİN PAGE</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/starter-template.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="brand" href="http://www.erdincozden.com"><b>Erdinc</b></a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/promo.html">Promo</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container">
		<h1>Java Spring MVC</h1>
		<p>The sample application</p>
		<a href="${pageContext.request.contextPath}/displayUsers">Display Users</a><br/>
		<a href="${pageContext.request.contextPath}/displayUsersMysql">Display Users Mysql</a><br/>
		<a href="${pageContext.request.contextPath}/newblogpost.html">New Blog Post</a><br/>
		<a href="${pageContext.request.contextPath}/blogposts">Blog Posts</a>
	</div>
	
	<footer class="footer">
		<div class="container">
			<p class="text-muted">Erdinc Ozden 2016 Free Spring MVC Project ozden@live.com</p>
			<a href="<%=request.getContextPath()%>?language=en">EN</a>
			<a href="<%=request.getContextPath()%>?language=de">DE</a>
			<spring:message code="language"/>
			<spring:message code="welcome.text"/>		
		</div>
	
	</footer>
	
	
	
	
	
	
	
	
	

</body>
</html>