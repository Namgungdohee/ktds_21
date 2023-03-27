package com.hello.notice.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hello.notice.service.NoticeService;
import com.hello.notice.vo.NoticeVO;

@Controller
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/notice")
		public String viewNoticeListPage(Model model) {
			List<NoticeVO> noticeList = noticeService.readAllNotice();
			model.addAttribute("noticeList", noticeList);
			return "notice/list";	
	}
	
	@GetMapping("/notice/{noticeId}")
	public String viewNoticeDetailPage(@PathVariable int noticeId, Model model) {
		logger.debug("URL 변수 noticeId의 값" + noticeId);
		// System.out.println("URL 변수 noticeId의 값" + noticeId);
		
		NoticeVO notice = noticeService.readOneNoticeByNoticeId(noticeId);
		model.addAttribute("notice", notice);
		
		return "notice/detail";
	}
	
	@GetMapping("/notice/write")
	public String viewNoticeWritePage() {
		return "notice/write";
	}
	
}
