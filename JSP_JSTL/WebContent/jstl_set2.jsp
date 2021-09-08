<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	//pageContext.setAttribute("mimi","mimi");
	pageContext.setAttribute("pyohun", "pyohun_mimi");
%>

<c:set var="name" value="mimi"></c:set>
<c:set var="phone" value="010-5555-8888" scope="request"></c:set>

jstl 		: ${name}<br>
jstl(영역x)  : ${request.pyohun} <br>
표현식 		: <%=request.getAttribute("pyohun") %> <br><br><br>






