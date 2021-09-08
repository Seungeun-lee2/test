<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%
	//pageContext.setAttribute("name", "mimi");
	String name="mimi";
%>

<c:set var="name" value="mimi" scope="page"></c:set>
<c:set var="name2" value="<%=name %>" scope="request"></c:set>

<%-- <c:remove var="name"/> --%>
<c:remove var="name" scope="request"/>


paceScope : ${name}
<br>
requestScope : ${requestScope.name}
