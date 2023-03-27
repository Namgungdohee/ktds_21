package com.hello.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.member.vo.MemberVO;

@Repository
public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int createNewMember(MemberVO memberVO) {
		return getSqlSession().insert("Member.createNewMember", memberVO);
	}

	@Override
	public int readCountMemberByEmail(String email) {
		return getSqlSession().selectOne("Member.readCountMemberByEmail", email);
	}

	@Override
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO) {
		return getSqlSession().selectOne("Member.readOneMemberByEmailAndPassword", memberVO);
	}
	
	
}
