<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script> 
<script type=text/javascript>
	$().ready(function() {
		
		$("#submit_btn").click(function(event) {
			//submit 안되게 막기
			event.preventDefault();
			
			//이메일 입력체크
			if($.trim($("#email").val()) == "") {
				alert("이메일을 입력하세요!");
				$("#email").focus();	
				return;
			}
			
			//이름 입력체크
			if($.trim($("#name").val()) == "") {
				alert("이름을 입력하세요!");
				$("#name").focus();	
				return;
			}
			
			//비밀번호 입력체크
			if($.trim($("#password").val()) == "") {
				alert("비밀번호를 입력하세요!");
				$("#password").focus();	
				return;
			}
			
			//비밀번호 검증 입력체크
			if ($.trim($("#passwordConfirm").val()) == "") {
				alert("비밀번호를 입력하세요!");
				$("#passwordConfirm").focus();
				return;
			}
			
			//비밀번호 일치 체크
			if($.trim($("#password").val()) != $.trim($("#passwordConfirm").val())) {
				alert("비밀번호가 일치하지 않습니다.")
				return;
			}
			
			//Form 전송
			$("#regist_form").attr({
				"action": "${pageContext.request.contextPath}/member/regist",
				"method": "post"
			
			}).submit();
		});
	});
</script>
</head>
<body>

	<h1>회원가입을 환영합니다!</h1>
	<form id="regist_form">
	<div>
		<label for="email">이메일</label>
		<input type="email"
			   name="email"
			   id="email"
			   maxlength="100"
			   placeholder="EMAIL을 입력하세요."/>
	</div>
	<div>
		<label for="name">이름:</label>
		<input type="text"
			   name="name"
			     id="name"
			     maxlength="10"
			     placeholder="이름을 입력하세요"/>
	</div>
	<div>
		<label for="password">비밀번호</label>
		<input type="password"
			   name="password"
			     id="password"
			     maxlength="10"
			     placeholder="비밀번호를 입력하세요."/>
	</div>
	
	<div>
		<label for="password">비밀번호 검증</label>
		<input type="password"
			   name="passwordConfirm"
			     id="passwordConfirm"
			     maxlength="10"
			     placeholder="비밀번호를 한번 더 입력하세요."/>
	</div>
	<div>
		<!-- <input type="submit" value="가입"/> -->
		<button id="submit_btn">가입</button>
	</div>
	</form>

</body>
</html>