package com.hello.notice.dao;

import java.util.List;

import com.hello.notice.vo.NoticeVO;

public interface NoticeDAO {
	
	public List<NoticeVO> readAllNotice();
	
	public NoticeVO readOneNoticeByNoticeId(int id);
	
	public int createNewNotice(NoticeVO noticeVO);
	
	public int updateOneNotice(NoticeVO noticeVO);
	
	public int deleteOneNotice(int id);

}
