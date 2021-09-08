<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="price" value="10000"/>

<h1>el문 가격 : ${price }</h1>
<h1>가격 : ￦ <fmt:formatNumber value="${price }" pattern="#,###"/></h1>

<c:set var="phone" value="01012341234"/>

<h1>전화번호 : ${phone}</h1>
<h1>전화번호 : <fmt:formatNumber value="${phone }" pattern="###-####-####"/><br>
			${phone.substring(0,3)} - ${phone.substring(3,7) } - ${phone.substring(7)} 

<h1>전화번호 : <fmt:formatNumber var="won" value="${phone }" pattern="###-####-####"/><br>
			${phone.substring(0,3)} - ${phone.substring(3,7) } - ${phone.substring(7)} 

won으로 저장해놓으면 원이 출력되는 것이 아니라, set 된다!
어딘가에 쓸거면 저장해놓는다?

</h1>

<h1> attribute 저장, 출력 : won - ${won }</h1>


