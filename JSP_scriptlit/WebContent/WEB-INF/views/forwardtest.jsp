<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<h2>이름 : <%=request.getAttribute("name") %></h2>
<h2>이름 : <%=request.getAttribute("age") %></h2>

</body>
</html>