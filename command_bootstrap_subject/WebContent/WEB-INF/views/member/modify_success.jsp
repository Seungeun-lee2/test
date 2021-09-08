<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${member.name}님의 정보가 수정되었습니다.");
	location.href='detail.do?id=${member.name}'; // 리다이렉트

	// 창이 열렸을때 부모를 reload하면, 부모 자식 관계가 꺠지기때문에, 부모창을 reload하기전에....
	if(${parentReload}) {
		if(confirm('로그인 사용자의 정보가 수정되었습니다.\n현재화면을 닫고 새로고침하시겠습니까?')) 
			window.opener.parent.location.reload(true);
			window.close();
	}
	
	
		
</script>