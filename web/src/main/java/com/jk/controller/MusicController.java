package com.jk.controller;

import com.jk.entity.MusicEntity;
import com.jk.service.MusicService;
import com.jk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MusicController {
    @Resource
    private MusicService musicService;

    @RequestMapping("/music/findlist")
    public List<MusicEntity> findlist() {
        return  musicService.findlist();
    }
    @RequestMapping("/music/deleteall")
    public void deleteall(@RequestParam String [] id){
        musicService.deleteall(id);
    }
    @RequestMapping("/music/add")
    public void add(@RequestBody MusicEntity music){
        musicService.add(music);
    }

    @RequestMapping("/music/querybyid")
    public MusicEntity querybyid(@RequestParam Integer id) {

        return musicService.querybyid(id);
    }
}
