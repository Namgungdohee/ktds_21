package com.hello.topic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.topic.dao.TopicDAO;
import com.hello.topic.vo.TopicVO;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDAO topicDAO;

	@Override
	public List<TopicVO> readAllTopics() {
		return topicDAO.readAllTopics();
	}

	@Override
	public TopicVO readOneTopicByTopicID(int id) {
		return topicDAO.readOneTopicByTopicId(id);
	}

	@Override
	public boolean createNewTopic(TopicVO topicVO) {
		return topicDAO.createNewTopic(topicVO) > 0;
	}

	@Override
	public boolean updateOneTopic(TopicVO topicVO) {
		return topicDAO.updateOneTopic(topicVO) > 0;
	}

	@Override
	public boolean deleteOneTopicByID(int id) {
		return topicDAO.deleteOneTopicById(id) > 0;
	}
}
