package com.jsp.action.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.NoticeService;

public class NoticeDeleteAction implements Action {
	
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
	
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		try {
			
			noticeService.deleteNotice(nno);
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("window.close();window.opener.location.href='/notice/list.do';");
			out.println("</script>");
			
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
	
		return url;
	}

}
