<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		
	});</script>
</head>
<body>
	<img src="${pageContext.request.contextPath}/img/Instagram-Icon.png" style="width:200px; height:200px;"/>

	<form action="${pageContext.request.contextPath}/topic/write" method="post" enctype="multipart/form-data">
	
		<div>
			<label for="subject">제목</label>
			<input type="text" name="subject" id="subject" placeholder="제목입력"/>
		</div>
		<div>
			<label for="uploadFile">파일</label>
			<input type="file"
				   name="uploadFile"
				   id="uploadFile"
				   placeholder="파일을 선택하세요.">
				   <input type="file"
				   name="uploadFile"
				   id="uploadFile"
				   placeholder="파일을 선택하세요.">
				   <input type="file"
				   name="uploadFile"
				   id="uploadFile"
				   placeholder="파일을 선택하세요.">
		</div>
		<div>
			<label for="content">내용</label>
			<textarea name="content" id="content" placeholer="내용"></textarea>
		</div>
		<div>
			<input type="submit" value="등록"/>
		</div>
	</form>

</body>
</html>