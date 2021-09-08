<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>

<body>
<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지등록</h1>  				
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
	<input type="text" name="title" class="form-control mt-4 mb-2" placeholder="제목을 입력해주세요." >
	<input type="text" name="writer" class="form-control mt-4 mb-2"value="${loginUser.id}" required>
		
	<p> 시작일  :  <input type="date" name="startdate" value="" ></p>
	<p> 종료일  :  <input type="date" name="enddate" value="" ></p>

	<div class="form-group">
		<textarea class="form-control mt-4 mb-4"rows="10" name="content"
			placeholder="내용을 입력해주세요" required
		></textarea>
	</div>
	<button type="submit" class="btn btn-secondary mb-3" onclick="regist_go()">등록하기</button>
	<button type="submit" class="btn btn-secondary mb-3" onclick="">닫기</button>
	
<form id="noticeRegistForm">
	<input type='hidden' name="title" value=""/>
	<input type='hidden' name="writer" value=""/>
	<input type='hidden' name="startdate" value=""/>
	<input type='hidden' name="enddate" value=""/>
	<input type='hidden' name="content" value=""/>		
</form>	

<script>
	function regist_go(url){
		alert('등록이 완료되었습니다.');
		if(!url) url="regist.do";
		
		var noticeRegistForm=$('#noticeRegistForm');
		
		noticeRegistForm.find("[name='title']").val($('input[name="title"]').val());
		noticeRegistForm.find("[name='writer']").val($('input[name="writer"]').val());
		noticeRegistForm.find("[name='startdate']").val($('input[name="startdate"]').val());
		noticeRegistForm.find("[name='enddate']").val($('input[name="enddate"]').val());
		noticeRegistForm.find("[name='content']").val($('textarea[name="content"]').val());
		
		noticeRegistForm.attr({
			action:url,
			method:'get'
		}).submit();
	}
</script>
	
</body>


	


