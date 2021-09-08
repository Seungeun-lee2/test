package com.jsp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.util.MakeFileName;

public class FileDownloaderResolver {

	public static void sendFile(String fileName, String savedPath, 
			HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{
		
		// 입력
		String filepath = savedPath + File.separator + fileName;
		
		// 보낼 파일 설정.
		File downloadFile = new File(filepath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		// 파일 포맷으로 mime을 결정한다.
		ServletContext context = request.getServletContext();
		String mimeType = context.getMimeType(filepath);
		if(mimeType == null) {
			mimeType = "application/octest-stream";
		}
		
		// response 수정
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		
		String headerKey = "Content-Disposition";
		// 한글깨짐방지 : ISO-8859-1
		String sendFileName = MakeFileName.parseFileNameFromUUID(downloadFile.getName(), "\\$\\$");
		
		String header = request.getHeader("User-Agent");
		if(header.contains("MSIE")) {
			sendFileName = URLEncoder.encode(sendFileName, "UTF-8");
		} else {
			sendFileName = new String(sendFileName.getBytes("utf-8"),"ISO-8859-1");
		}
		
		String headerValue = String.format("attachment; filename=\"%s\"", sendFileName);
		response.setHeader(headerKey, headerValue);
		
		//파일 내보내기
		OutputStream outStream = response.getOutputStream();
		
		try {
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			
			while((bytesRead = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
 		} finally {
 			outStream.close();
 			inStream.close();
 		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
