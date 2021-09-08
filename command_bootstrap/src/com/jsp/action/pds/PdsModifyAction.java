package com.jsp.action.pds;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadResolver;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;
import com.jsp.util.GetUploadPath;
import com.jsp.util.MultipartHttpServletRequestParser;


public class PdsModifyAction implements Action {

   private PdsService pdsService;
   public void setPdsService (PdsService pdsService) {
      this.pdsService=pdsService;
   }
   
   
   
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String url = "pds/modify_success";
      
      PdsVO pds = null;
      try {
         pds = modifyFile(request,response);
         pdsService.modify(pds);
      } catch (SQLException e) {
         e.printStackTrace();
         throw e;
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      } finally {
         request.setAttribute("pds", pds);
      }
      return url;
   }
   
   // 업로드 파일 환경설정
   final private int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
   final private int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
   final private int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB
   
   private PdsVO modifyFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception{
      
      MultipartHttpServletRequestParser multiReq 
         = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);

      FileItem[] fileItems = multiReq.getFileItems("uploadFile");
      
      // 실제 저장 경로를 설정.
      String uploadPath = GetUploadPath.getUploadPath("pds.upload");
      List<File> fileList = FileUploadResolver.fileUpload(fileItems, uploadPath);
      
      List<AttachVO> attachList=null;
      attachList = new ArrayList<AttachVO>();
      //List<File> -> List<AttachVO>
      
      if(fileList !=null) {
         attachList = new ArrayList<AttachVO>();
         for(File file : fileList) {
            // DB에 저장할 attach에 file 내용 추가.
            AttachVO attach = new AttachVO();
            attach.setFileName(file.getName());
            attach.setUploadPath(uploadPath);
            attach.setFileType(file.getName().substring(file.getName().lastIndexOf(".")+1));

            attachList.add(attach);
         }         
      }
      
      PdsVO pds = new PdsVO();
      pds.setPno(Integer.parseInt(multiReq.getParameter("pno")));
      pds.setTitle(multiReq.getParameter("title"));
      pds.setWriter(multiReq.getParameter("writer"));
      pds.setContent(multiReq.getParameter("content"));
      pds.setAttachList(attachList);
      
      // 파일 삭제 및 DB 삭제
      String[] deleteFiles = multiReq.getParameterValues("deleteFile");
      if(deleteFiles != null && deleteFiles.length > 0) {
         for(String anoStr : deleteFiles) {
            int ano = Integer.parseInt(anoStr);
            AttachVO attach = pdsService.getAttachByAno(ano);
            
            String filePath = attach.getUploadPath()
                  + File.separator + attach.getFileName();
            File targetFile = new File(filePath);
            
            if(targetFile.exists()) {
               targetFile.delete(); //파일 삭제
            }
            pdsService.removeAttachByAno(ano); // DB 삭제
         }
      }
      
      return pds;
   }

}