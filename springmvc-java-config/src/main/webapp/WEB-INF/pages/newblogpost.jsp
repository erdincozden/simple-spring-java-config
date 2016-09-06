<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Blog Post</title>
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
		<h1>New Blog Post Page</h1>
		
		<c:if test="${not empty message}">
			${message}<br/>		
		</c:if>
		
		<form action="${pageContext.request.contextPath}/saveBlogPost" method="post">
			<table style="width: 650px" class="table table-striped">
				<tr><td>Title</td><td><input type="text" name="title" required autofocus></td></tr>
				<tr><td>Content</td><td><textarea name="content" required maxlength="4000" rows="5"></textarea></td></tr>
				<tr><td>Draft</td><td><input type="checkbox" name="draft"> </td></tr>
				<tr><td colspan="2"><input type="submit" value="Save"> </td></tr>		
			</table>
		</form>
		
		
		<a href="${pageContext.request.contextPath}">Back</a>
	</div>
	
	<footer class="footer">
		<div class="container">
			<p class="text-muted">Erdinc Ozden 2016 Free Spring MVC Project ozden@live.com</p>
			<a href="<%=request.getContextPath()%>?language=EN"></a>
			<a href="<%=request.getContextPath()%>?language=TR"></a>		
		</div>
	
	</footer>

</body>
</html>