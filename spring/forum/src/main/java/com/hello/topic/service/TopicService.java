package com.hello.topic.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hello.topic.vo.TopicVO;

public interface TopicService {
	
	public List<TopicVO> readAllTopics();
	
	public TopicVO readOneTopicByTopicID(int id);
	
	public boolean createNewTopic(TopicVO topicVO, List<MultipartFile> uploadFile);
	
	public boolean updateOneTopic(TopicVO topicVO);
	
	public boolean deleteOneTopicByID(int id);

}
