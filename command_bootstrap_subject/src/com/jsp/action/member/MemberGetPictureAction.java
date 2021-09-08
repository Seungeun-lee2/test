package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloaderResolver;
import com.jsp.util.GetUploadPath;

public class MemberGetPictureAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = null;
		
		String fileName = request.getParameter("picture");
		String savedPath = GetUploadPath.getUploadPath("member.picture.upload");
		
		FileDownloaderResolver.sendFile(fileName,savedPath,request,response);
		
		return null;
	}

}
