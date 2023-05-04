<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 폼</title>
</head>
<body>

	<!-- 	multipart/form-data : 
			form태그를 통해 파일을업로드할 경우 인코딩 형식 지정. 
			method 방식은 post여야 함
			
			
			 action은 어디로 가야할지 설정.
			 method는 전송 방식 -->
			
	<form enctype="multipart/form-data" action="<c:url value='/upload.do'/>" method="post">
	
		파일1:<input type="file" name="file1"><br><br>
		파일2:<input type="file" name="file2"><br><br>
		파일3:<input type="file" name="file3"><br><br>
	
	<input type="submit" value="업로드">
	
</form>
	
</body>
</html>