package com.hello.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.notice.dao.NoticeDAO;
import com.hello.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeVO> readAllNotice() {
		return noticeDAO.readAllNotice();
	}

	@Override
	public NoticeVO readOneNoticeByNoticeId(int id) {
		return noticeDAO.readOneNoticeByNoticeId(id);
	}

	@Override
	public boolean createNewNotice(NoticeVO noticeVO) {
		return noticeDAO.createNewNotice(noticeVO) > 0;
	}

	@Override
	public boolean updateOneNotice(NoticeVO noticeVO) {
		return noticeDAO.updateOneNotice(noticeVO) > 0;
	}

	@Override
	public boolean deleteOneNotice(int id) {
		return noticeDAO.deleteOneNotice(id) > 0;
	}

}
