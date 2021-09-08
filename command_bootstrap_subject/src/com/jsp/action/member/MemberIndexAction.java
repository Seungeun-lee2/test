package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

public class MemberIndexAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="member/main";//webinf,views,member,main.jsp 리턴 & 사이트매쉬적용
		return url;
	}

}
