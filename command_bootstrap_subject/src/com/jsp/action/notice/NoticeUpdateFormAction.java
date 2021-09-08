package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeUpdateFormAction implements Action {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="notice/updateForm";
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		NoticeVO notice = noticeService.getNoticeDetail(nno);
		
		System.out.println(nno);
		System.out.println(notice);
		request.setAttribute("notice", notice);
		
		return url;
	}

}
