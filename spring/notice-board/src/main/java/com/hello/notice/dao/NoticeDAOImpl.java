package com.hello.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.notice.vo.NoticeVO;

@Repository
public class NoticeDAOImpl extends SqlSessionDaoSupport implements NoticeDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<NoticeVO> readAllNotice() {
		return getSqlSession().selectList("Notice.readAllNotice");
	}

	@Override
	public NoticeVO readOneNoticeByNoticeId(int id) {
		return getSqlSession().selectOne("Notice.readOneNoticeByNoticeId", id);
	}

	@Override
	public int createNewNotice(NoticeVO noticeVO) {
		return getSqlSession().insert("Notice.createNewNotice", noticeVO);
	}

	@Override
	public int updateOneNotice(NoticeVO noticeVO) {
		return getSqlSession().update("Notice.updateOneNotice", noticeVO);
	}

	@Override
	public int deleteOneNotice(int id) {
		return getSqlSession().delete("Notice.deleteOneNoticeById", id);
	}

}
