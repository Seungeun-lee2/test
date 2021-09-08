package com.jsp.action.notice;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeRegistAction implements Action {
	
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
	
		DateFormat sdFormat = new SimpleDateFormat("yy-MM-dd");
			
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String content = request.getParameter("content");	
		
		
		NoticeVO notice = new NoticeVO();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setStartdate(sdFormat.parse(startdate));
		notice.setEnddate(sdFormat.parse(enddate));
		notice.setContent(content);
		
		try {
			
			noticeService.insertNotice(notice);
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("window.close();window.opener.location.href='/notice/list.do';");
			out.println("</script>");			
			out.close();
			
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
	
		return url;
	}

}
