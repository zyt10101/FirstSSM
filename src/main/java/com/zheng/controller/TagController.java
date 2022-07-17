package com.zheng.controller;

import com.zheng.pojo.Tag;
import com.zheng.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

//标识该类的全部方法的返回值通过responseBody输出到页面上
@Controller
//解决跨域问题
@CrossOrigin(origins = "*", maxAge = 3600)
public class TagController {
    @Autowired
    private TagService tagService;
    //查询所有
    @RequestMapping(value = "/tag",method = RequestMethod.GET)
    public String getAllTag( Model model ){
        Collection<Tag> tagList = tagService.getAllTags ( );
        model.addAttribute ( "tagList",tagList );
        return "tag_List";
    }
    //删除
    @RequestMapping(value = "/tag/{id}",method = RequestMethod.DELETE)
    public String deleteTag( @PathVariable("id") Integer id ){
        tagService.deleteTag ( id );
        return "redirect:/tag";
    }
    //添加
    @RequestMapping(value = "/tag",method = RequestMethod.POST)
    public String insertTag(Tag tag){
        tagService.insertTag ( tag );
        return "redirect:/tag";
    }

    //数据回显并修改
    @RequestMapping(value = "/tag/{id}",method = RequestMethod.GET)
    public String getTagById(@PathVariable("id")Integer id,Model model){
        Tag tagById = tagService.getTagById ( id );
        model.addAttribute ( "tagById",tagById );
        return "tag_update";
    }
    @RequestMapping(value = "tag",method = RequestMethod.PUT)
    public String updateTag(Tag tag){
        tagService.updateTag ( tag );
        return "redirect:/tag";
    }
}
