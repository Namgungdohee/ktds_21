package com.hello.notice.service;

import java.util.List;

import com.hello.notice.vo.NoticeVO;

public interface NoticeService {
	
	public List<NoticeVO> readAllNotice();
	
	public NoticeVO readOneNoticeByNoticeId(int id);
	
	public boolean createNewNotice(NoticeVO noticeVO);
	
	public boolean updateOneNotice(NoticeVO noticeVO);
	
	public boolean deleteOneNotice(int id);

}
