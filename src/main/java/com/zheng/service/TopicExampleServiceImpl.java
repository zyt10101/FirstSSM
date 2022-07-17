package com.zheng.service;

import com.zheng.mapper.TopicMapper;
import com.zheng.pojo.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopicExampleServiceImpl implements TopicExampleService {
    @Autowired
    private TopicMapper topicMapper;
    @Override
    public List<Topic> getAllTopic ( ) {
        return topicMapper.selectByExample ( null );
    }

    @Override
    public int deleteTopic ( Integer id ) {
        topicMapper.deleteByPrimaryKey ( id );
        return 0;
    }

    @Override
    public int insertTopic ( Topic topic ) {
        topicMapper.insert ( topic);
        return 0;
    }

    @Override
    public Topic getTopicById ( Integer id ) {
        Topic topic = topicMapper.selectByPrimaryKey ( id );
        return topic;
    }

    @Override
    public int updateTopic ( Topic topic ) {
        topicMapper.updateByPrimaryKeySelective ( topic );
        return 0;
    }
}
