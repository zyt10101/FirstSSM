package com.zheng.controller;

import com.zheng.pojo.Topic;
import com.zheng.service.TopicExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicExampleController {
    @Autowired
    private TopicExampleService topicExampleService;

    @RequestMapping(value = "/topicExample", method = RequestMethod.GET)
    public String getAllTopic ( Model model ) {
        List<Topic> topicList = topicExampleService.getAllTopic ( );
        model.addAttribute ( "topicList", topicList );
        return "topic_List";
    }

    @RequestMapping(value = "/topicExample/{id}", method = RequestMethod.DELETE)
    public String deleteTopic ( @PathVariable("id") Integer id ) {
        topicExampleService.deleteTopic ( id );
        return "redirect:/topicExample";
    }

    @RequestMapping(value = "/topicExample", method = RequestMethod.POST)
    public String insertTopicExample ( Topic topic ) {
        topicExampleService.insertTopic ( topic );
        return "redirect:/topicExample";
    }

    //数据回显并修改　  将数据共享到域中
    @RequestMapping(value = "/topicExample/{id}", method = RequestMethod.GET)
    public String getTopicById ( @PathVariable("id") Integer id, Model model ) {
        Topic topic = topicExampleService.getTopicById ( id );
        model.addAttribute ( "topicById", topic );
        return "topic_update";
    }

    @RequestMapping(value = "/topicExample", method = RequestMethod.PUT)
    public String updateTopic ( Topic topic ) {
        topicExampleService.updateTopic ( topic );
        return "redirect:/topicExample";
    }
}
