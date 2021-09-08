<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="notice" value="${notice}"></c:set>

<body>
	 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-12">
	  				<h1>공지글 보기</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				
	  			</div>
	  		</div>
	  	</div>
	</section>
	<br><br>

	<section class="content">
   		<div class="card">
   			<div class="card-header with-border">
   				<button type="button" class="btn btn-primary" onclick="delete_go()" >삭제</button>
   				<button type="button" class="btn btn-primary" onclick="update_go('${notice.nno}')" >수정</button>
   			 	<div id="keyword" class="card-tools" style="width:550px;">
   					 <div class="input-group row">				 
   		
					<!-- end : search bar -->		
   					 </div>
   				</div>    			
   			</div>
   			<div class="card-body" style="text-align:center;">
    		  <div class="row">
	             <div class="col-sm-12">
	             
	             	<table class="table table-bordered" >
							<tr>
								<th>NO</th>
								<td>${notice.nno}</td>
							</tr> 
							<tr>
								<th>제목</th>
								<td id="title">${notice.title}</td>
							</tr>							
							<tr>
								<th>작성자</th>
								<td id="writer">${notice.writer}</td>
							</tr>	
							<tr>
								<th>등록일</th>
								<td id="regDate">
									<fmt:formatDate value="${notice.regDate }" pattern="yyyy-MM-dd"/>
								</td>
							</tr>
							<tr>
								<th>조회수</th>
								<td id="viewcnt">${notice.viewcnt}</td>
							</tr>									
					</table>
					
					<div class="form-group">
						<textarea class="form-control mt-4 mb-4"rows="10" name="content" required>${notice.content}</textarea>
					</div>
		    	
		    		<button type="button" class="btn btn-primary" onclick="" >목록으로</button>
		    	
    		     </div> <!-- col-sm-12 -->
    	       </div> <!-- row -->
    		</div> <!-- card-body -->
    		<div class="card-footer">
    			<!-- pagenation -->
    			
    		</div>
	     </div>
   	</section>
   	
<form id="noticeUpdateForm">
	<input type='hidden' name="nno" value=""/>
	<input type='hidden' name="title" value=""/>
	<input type='hidden' name="writer" value=""/>
	<input type='hidden' name="content" value=""/>		
</form>
   	
<script>
 	function delete_go() {
		alert('삭제가 완료되었습니다.');
		location.href="/notice/delete.do?nno=${notice.nno}";
	} 
 	
 	function update_go(nno) {
 		
		var noticeUpdateForm=$('#noticeUpdateForm');
		
		noticeUpdateForm.find("[name='nno']").val(nno);
		noticeUpdateForm.find("[name='title']").val($('#title').text());
		noticeUpdateForm.find("[name='writer']").val($('#writer').text());
		noticeUpdateForm.find("[name='content']").val($('textarea[name="content"]').val());
		
/* 		noticeUpdateForm.find("[name='writer']").val($('td[name="writer"]').val());
		noticeUpdateForm.find("[name='startdate']").val($('td[name="startdate"]').val());
		noticeUpdateForm.find("[name='enddate']").val($('td[name="enddate"]').val());
		noticeUpdateForm.find("[name='content']").val($('textarea[name="content"]').val()); */

		noticeUpdateForm.attr({
			action:"updateForm.do?nno="+nno,
			method:'get'
		}).submit();
 	}
 	
	function list_go(page,url){
		if(!url) url="list.do";
	
	}
</script>	

</body>