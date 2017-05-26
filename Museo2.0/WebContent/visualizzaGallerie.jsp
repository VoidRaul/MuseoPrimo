<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gallerie</title>
</head>
<h1>Gallerie</h1>
<body>
	<%--  <%out.print(request.getAttribute("galleriePresenti")); %> --%>
	 <c:forEach  items='${galleriePresenti}' var="gal">
		<ul>
			<li>${gal.nome}</li>
		</ul>
	</c:forEach>
</body>
</html>