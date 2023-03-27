<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원가입을 환영합니다!</h1>
	<form action="${pageContext.request.contextPath}/member/regist" method="post">
	
	<div>
		<label for="email">이메일</label>
		<input type="email"
			   name="email"
			   id="email"
			   placeholder="EMAIL을 입력하세요."/>
	</div>
	<div>
		<label for="name">이름:</label>
		<input type="text"
			   name="name"
			     id="name"
			     placeholder="이름을 입력하세요"/>
	</div>
	<div>
		<label for="password">비밀번호</label>
		<input type="password"
			   name="password"
			     id="password"
			     placeholder="비밀번호를 입력하세요."/>
	</div>
	<div>
		<input type="submit" value="가입"/>
	</div>
	</form>

</body>
</html>