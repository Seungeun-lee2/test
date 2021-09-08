<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:set var="today" value="<%=new Date() %>"></c:set>

<h1>오늘날짜시간 : ${today }</h1>
<h1>오늘날짜시간 : <fmt:formatDate value="${today }" pattern="yyyy년MM월dd일HH시mm분ss초"/></h1>
