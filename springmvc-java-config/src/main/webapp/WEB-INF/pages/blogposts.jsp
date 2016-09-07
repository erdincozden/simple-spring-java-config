<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog Post</title>
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
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="http://www.erdincozden.com"><b>Erdinc</b></a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a
							href="${pageContext.request.contextPath}">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/promo.html">Promo</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<h1>Blog Posts</h1>
		
		<form action="${pageContext.request.contextPath}/searchByTitle" method="post">
			<table style="width: 650px" class="table table-striped">
				<tr><td>Title</td><td><input type="text" name="title" required autofocus></td></tr>
				<tr><td colspan="2"><input type="submit" value="Search"> </td></tr>		
			</table>
		</form>
		
		
		<c:if test="${ empty blogposts}">
			No blog posts found<br />
		</c:if>
		
		<c:if test="${ not empty blogposts}">
		<table style="width: 650px" class="table table-striped">
		<c:forEach var="blogpost" items="${blogposts}" > 
		    	<tr><td>Id</td><td><c:out value="${blogpost.id}"/></td></tr>
		    	<tr><td>Title</td><td><c:out value="${blogpost.title}"/></td></tr>
				<tr><td>Content</td><td><div style="white-space: pre;"><c:out value="${blogpost.content}"/></div> </td></tr>
				<tr><td>Draft</td><td><c:out value="${blogpost.title}"/></td></tr>			
		</c:forEach>
				
		</c:if>
		</table>
		<a href="${pageContext.request.contextPath}/newblogpost.html">New Blog Post</a><br/>
		<a href="${pageContext.request.contextPath}">Back</a>
	</div>

	<footer class="footer">
		<div class="container">
			<p class="text-muted">Erdinc Ozden 2016 Free Spring MVC Project
				ozden@live.com</p>
			<a href="<%=request.getContextPath()%>?language=EN"></a> <a
				href="<%=request.getContextPath()%>?language=TR"></a>
		</div>

	</footer>

</body>
</html>