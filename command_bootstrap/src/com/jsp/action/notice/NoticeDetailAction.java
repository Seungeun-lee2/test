package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeDetailAction implements Action {
	
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override

	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String url = "notice/detail";
		
		// 어디서 온 상세보기냐 이슈 (수정디테일만든 후 고치기)
		int nno = Integer.parseInt(request.getParameter("nno"));
		String from=request.getParameter("from");
		

		NoticeVO notice = noticeService.getNotice(nno);
		if(from!=null && from.equals("modify")) {
			notice=noticeService.getNoticeForModify(nno);
		} else {
			notice=noticeService.getNotice(nno);
		}
		
		
		request.setAttribute("notice", notice);
		
		return url;
	}

}
