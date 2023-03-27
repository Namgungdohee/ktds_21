package com.hello.topic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hello.common.handler.DownloadUtil;
import com.hello.common.handler.UploadHandler;
import com.hello.topic.service.TopicService;
import com.hello.topic.vo.TopicVO;

@Controller
public class TopicController {
	
	private static final Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private UploadHandler uploadHandler;
	
	@Value("${upload.path}")
	private String uploadPath;
	
	@GetMapping("/topics")
	public String viewTopicListPage(Model model) {
		List<TopicVO> topicList = topicService.readAllTopics();
		model.addAttribute("topicList", topicList);
		return "topic/list";
	}
	
	@GetMapping("/topic/{topicId}")
	public String viewTopicDetailPage(@PathVariable int topicId, Model model) {
		// System.out.println("URL 변수 topicId의 값" + topicId);
		logger.info("URL 변수 topicId의 값: {}", topicId);
		
		Integer.parseInt("ABC");
		
		TopicVO topic = topicService.readOneTopicByTopicID(topicId);
		model.addAttribute("topic", topic);
		
		return "topic/detail";
	}
	
	@GetMapping("/topic/write")
	public String viewTopicWritePage() {
		return "topic/write";
	}
	
	@PostMapping("/topic/write")
	public String doTopicWrite(TopicVO topicVO, List<MultipartFile> uploadFile) {

		boolean createResult = topicService.createNewTopic(topicVO);
		uploadHandler.upload(uploadFile, topicVO.getId());
		
		if(!createResult) {
			return "topic/write";
		}
		return "redirect:/topic/" + topicVO.getId();
	}
	
	@GetMapping("/topic/delete/{topicId}")
	public String doTopicDelete(@PathVariable int topicId) {
		boolean deleteResult = topicService.deleteOneTopicByID(topicId);
		if(deleteResult) {
			return "redirect:/topics";
		}
		else {
			return "redirect:/topic/" + topicId;
		}
	}
	
	@GetMapping("/topic/update/{topicId}")
	public String viewTopicUpdatePage(@PathVariable int topicId, Model model) {
		TopicVO topic = topicService.readOneTopicByTopicID(topicId);
		model.addAttribute("topic", topic);
		return"topic/update";
	}
	
	@PostMapping("/topic/update/{topicId}")
	public String doTopicUpdate(@PathVariable int topicId, TopicVO topicVO) {
		topicVO.setId(topicId);
		boolean updateResult = topicService.updateOneTopic(topicVO);
		
		if(updateResult) {
			return "redirect:/topic/" + topicId;
		}
		else {
			return "redirect:/topics";
		}
	}
	
	@GetMapping("/topic/download/{topicId}")
	public void downloadFile(@PathVariable int topicId
					, HttpServletRequest request
					, HttpServletResponse response) {
		
		TopicVO topic = topicService.readOneTopicByTopicID(topicId);
		
		new DownloadUtil(response, request, this.uploadPath + "/" + topic.getFileName()).download(topic.getOriginFileName());
		
		
	}
}
