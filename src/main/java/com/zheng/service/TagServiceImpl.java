package com.zheng.service;

import com.zheng.mapper.TagMapper;
import com.zheng.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<Tag> getAllTags ( ) {
        return tagMapper.selectByExample ( null );
    }
    @Override
    public int deleteTag( Integer id){
        tagMapper.deleteByPrimaryKey ( id );
        return 0;
    }
    @Override
    public int insertTag(Tag tag){
        tagMapper.insert ( tag );
        return 0;
    }
    @Override
    public Tag getTagById(Integer id){
        Tag tag = tagMapper.selectByPrimaryKey ( id );
        return tag;
    }
    @Override
    public int updateTag(Tag tag){
        tagMapper.updateByPrimaryKey ( tag );
        return 0;
    }
}
