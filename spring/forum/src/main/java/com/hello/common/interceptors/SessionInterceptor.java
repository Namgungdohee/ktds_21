package com.hello.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hello.member.vo.MemberVO;

public class SessionInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession(); // Session 객체 얻어온다.
		// 세션 로그인 정보를 얻어온다.
		MemberVO member = (MemberVO)session.getAttribute("__USER_SESSION_DATA__");
		
		if(member == null) {
			response.sendRedirect(request.getContextPath() + "/member/login");
			return false; // Controller 실행을 하지 않는다.
		}
		
		return true; // Controller 실행을 계속한다.
	}

}
