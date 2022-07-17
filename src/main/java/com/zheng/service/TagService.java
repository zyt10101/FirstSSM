package com.zheng.service;

import com.zheng.pojo.Tag;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface TagService {
    //查询所有信息
    List<Tag> getAllTags();
    //删除
    int deleteTag(Integer id );
    //添加
    int insertTag(Tag tag);
    //数据回显并保存到域中
    Tag getTagById(Integer id);
    //修改
    int updateTag(Tag tag);
}
