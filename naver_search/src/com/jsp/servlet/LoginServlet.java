package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;
import com.jsp.service.MemberServiceImpl;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private MemberServiceImpl memberService = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/loginForm.jsp").forward(request, response); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = "/loginSuccess.jsp";
	
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 처리 - 여기선 화면을
		try {
			memberService.login(id, pwd);
		} catch (InvalidPasswordException | NotFoundIdException e) {
			// 어디에 요청?, post여서 
			request.setAttribute("message", e.getMessage());
			url="loginFail.jsp";
		}
		
		// 출력
//		out.println("<script")
// 안대겠다 너무 길다. jsp를 실행시키자! forward로!
		// id, 로그인이 들어가나?
		request.getRequestDispatcher(url).forward(request, response);
	
	}
}
