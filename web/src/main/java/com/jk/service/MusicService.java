package com.jk.service;

import com.jk.entity.MusicEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "filmclient")
public interface MusicService {
    @RequestMapping("music/findlist")
    public List<MusicEntity> findlist();

    @RequestMapping("music/deleteall")
    public void deleteall(@RequestParam String[] id);

    @RequestMapping("music/add")
    public void add(@RequestBody MusicEntity music);

    @RequestMapping("music/querybyid")
    public MusicEntity querybyid(@RequestParam Integer id);
}