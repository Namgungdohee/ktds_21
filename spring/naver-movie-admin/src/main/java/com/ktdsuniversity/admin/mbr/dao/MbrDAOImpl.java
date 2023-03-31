package com.ktdsuniversity.admin.mbr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@Repository
public class MbrDAOImpl extends SqlSessionDaoSupport implements MbrDAO {

	@Override
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public MbrVO readOneMbrByIdAndPwd(MbrVO mbrVO) {
		return getSqlSession().selectOne("mbr.readOneMbrByIdAndPwd", mbrVO);
	}

	@Override
	public List<MbrVO> readAllAdminMbr() {
		return getSqlSession().selectList("mbr.readAllAdminMbr");
	}

	@Override
	public int createNewAdminMbr(MbrVO mbrVO) {
		return getSqlSession().insert("mbr.createNewAdminMbr", mbrVO);
	}

	@Override
	public int updateOneAdminMbr(MbrVO mbrVO) {
		return getSqlSession().update("mbr.updateOneAdminMbr", mbrVO);
	}

	@Override
	public int deleteOneAdminMbr(String mbrId) {
		return getSqlSession().update("mbr.deleteOneAdminMbr", mbrId);
	}

	@Override
	public int readCountMbrById(String mbrId) {
		return getSqlSession().selectOne("mbr.readCountMbrById", mbrId);
	}



	@Override
	public String readSaltMbrById(String mbrId) {
		return getSqlSession().selectOne("mbr.readSaltMbrById", mbrId);
	}

	@Override
	public int updateMbrLgnFail(MbrVO mbrVO) {
		return getSqlSession().update("mbr.updateMbrLgnFail", mbrVO);
	}

	@Override
	public int updateMbrLgnBlock(MbrVO mbrVO) {
		return getSqlSession().update("mbr.updateMbrLgnBlock", mbrVO);
	}

	@Override
	public String readLgnBlockYnById(String mbrId) {
		return getSqlSession().selectOne("mbr.readLgnBlockYnById", mbrId);
	}

	@Override
	public int updateMbrLgnSucc(MbrVO mbrVO) {
		return getSqlSession().update("mbr.updateMbrLgnSucc", mbrVO);
	}
	
}
