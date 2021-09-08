<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
   MemberVO member = new MemberVO("mimi","mimi");
   
   //el문의 전제조건은 attribute에서 꺼내는거
   //page에 할당
   
   pageContext.setAttribute("member", member);
 
%>
<%
    //pageContext.setAttribute("msg", "안녕하세요");
	//request.setAttribute("msg", "반갑습니다.");
	//session.setAttribute("msg", "좋은 날씨군요.");
	application.setAttribute("msg", "점심 모 먹지?");
	
	pageContext.setAttribute("num",1); // compiler -> wrapping
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
   
   <ul> <!-- attribute -->
   <!-- scope를 주지 않으면 전체에서 찾지만, 주면 해당 영역에서 찾음 -->
   	<li>pageScope EL : ${msg}</li>
   	<%-- <li>pageScope EL : ${sessionScope.msg}</li> --%>
    <li>pageContext 표현식 : <%=pageContext.getAttribute("msg") %></li><br>
    
    
    <li>MemberVO id 표현식 : <%=((MemberVO)pageContext.getAttribute("member")).getId() %></li>
    <li>MemberVO id EL : ${member.id }</li>  
   </ul>
   
   <ul><!-- param -->
   	<li> 표현식 : <%=request.getParameter("name") %></li>
   	<li> EL : ${param.name}</li>
   </ul>
   
   <ul> <!-- 연산자 -->
   	<li> 산술연산 : ${num+1 }</li>
   	<%-- <li> 문자열 더하기 : ${num+msg }</li> 어짜피 out.println 따라서 더할 필요 없이 각각 써주면 된다.--%>
   	<li> 문자열 더하기 : ${num}${msg }</li>
   	<li> 비교연산 : ${num >=3 }</li> <!-- 자바적 요소를 최대한 줄이기 위해서 >=도 되지만,ge를 굳이 만들어서 사용한다. -->
   	<li> 비교연산 : ${num ge 3 }</li>
   	<li> 유무연산 : ${empty num}, ${not empty member}, ${empty requestScope.member}</li> <!-- 값이있으니까 false가 나온다 -->
   </ul>
   
   <ul> <!-- 일반 메소드 호출 -->
   		<li>member.getTime() : ${member.getTime() }</li>
   		<li>member.time : ${member.time }</li>
   </ul>
   
</body>
</html>