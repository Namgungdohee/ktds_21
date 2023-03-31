package com.ktdsuniversity.admin.gnr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.gnr.vo.GnrVO;

@Repository
public class GnrDAOImpl extends SqlSessionDaoSupport implements GnrDAO {

	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<GnrVO> readAllGnrVO(String gnrNm) {
		return getSqlSession().selectList("Gnr.readAllGnrVO", gnrNm);
	}

	@Override
	public int createOneGnr(GnrVO gnrVO) {
		return getSqlSession().insert("Gnr.createOneGnr", gnrVO);
	}

	@Override
	public int updateOneGnr(GnrVO gnrVO) {
		return getSqlSession().update("Gnr.updateOneGnr", gnrVO);
	}

	@Override
	public int deleteOneGnrByGnrId(int gnrId) {
		return getSqlSession().delete("Gnr.deleteOneGnrByGnrId", gnrId);
	}

}
