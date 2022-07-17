package com.zheng.service;

import com.zheng.pojo.Tag;
import com.zheng.pojo.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicExampleService {
    //查询所有信息
    List<Topic> getAllTopic();
    //删除
    int deleteTopic(Integer id );
    //添加
    int insertTopic(Topic topic);
    //数据回显并保存到域中
    Topic getTopicById(Integer id);
    //修改
    int updateTopic(Topic topic);
}
