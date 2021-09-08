<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="notice" value="${notice}"></c:set>

<body>
<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지수정</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>공지사항관리
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	목록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>

<%-- 입력 폼 --%>
	<input type="text" name="title" class="form-control mt-4 mb-2" value="${notice.title}" >
	<input type="text" name="writer" class="form-control mt-4 mb-2"value="${loginUser.id}" required>
		
	<p> 시작일  :  <input type="date" name="startdate" value="${notice.startdate}" ></p>
	<p> 종료일  :  <input type="date" name="enddate" value="${notice.enddate}" ></p>

	<div class="form-group">
		<textarea class="form-control mt-4 mb-4"rows="10" name="content" required>${notice.content}"</textarea>
	</div>
	<button type="submit" class="btn btn-secondary mb-3" onclick="regist_go()">수정하기</button>
	<button type="submit" class="btn btn-secondary mb-3" onclick="">닫기</button>
	
<form id="noticeUpdateForm">
	<input type='hidden' name="nno" value="">
	<input type='hidden' name="title" value=""/>
	<input type='hidden' name="writer" value=""/>
	<input type='hidden' name="startdate" value=""/>
	<input type='hidden' name="enddate" value=""/>
	<input type='hidden' name="content" value=""/>		
</form>	

<script>
	function regist_go(url){
		alert('수정이 완료되었습니다.');
		if(!url) url="update.do";
		
		var noticeUpdateForm=$('#noticeUpdateForm');
		
		noticeUpdateForm.find("[name='nno']").val(${notice.nno});
		noticeUpdateForm.find("[name='title']").val($('input[name="title"]').val());
		noticeUpdateForm.find("[name='writer']").val($('input[name="writer"]').val());
		noticeUpdateForm.find("[name='startdate']").val($('input[name="startdate"]').val());
		noticeUpdateForm.find("[name='enddate']").val($('input[name="enddate"]').val());
		noticeUpdateForm.find("[name='content']").val($('textarea[name="content"]').val());
		
		noticeUpdateForm.attr({
			action:url,
			method:'get'
		}).submit();
	}
</script>
	
</body>


	



 