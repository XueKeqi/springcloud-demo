package com.jk.controller.film;

import com.jk.entity.MusicEntity;
import com.jk.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("music")
public class MusicController {
    @Resource
    private MusicService musicService;

    @RequestMapping("queryMusic")
    //@RequiresPermissions("user:query")
    public String queryMusic() {
        return "film/musicList";
    }

    @RequestMapping("findAll")
    @ResponseBody
    public List<MusicEntity> findlist() {
        return  musicService.findlist();
    }
    @RequestMapping("deleteAll")
    @ResponseBody
    public void deleteall(@RequestParam String [] id){
        musicService.deleteall(id);
    }
    @RequestMapping("Add")
    @ResponseBody
    public void add(@RequestBody MusicEntity music){
        musicService.add(music);
    }

    @RequestMapping("queryById")
    @ResponseBody
    public MusicEntity querybyid(@RequestParam Integer id) {

        return musicService.querybyid(id);
    }
}
