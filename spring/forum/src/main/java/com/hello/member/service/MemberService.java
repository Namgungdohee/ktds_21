package com.hello.member.service;

import com.hello.member.vo.MemberVO;

public interface MemberService {
	
	public boolean createNewMember(MemberVO memberVO);
	
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO);


}
