package com.jk.service.impl;

import com.jk.dao.MusicMapper;
import com.jk.entity.MusicEntity;
import com.jk.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Resource
    private MusicMapper musicMapper;

    @Override
    public List<MusicEntity> findList() {
        return musicMapper.findList();
    }

    @Override
    public void deleteall(String[] id) {
        for (int i = 0; i < id.length; i++) {
            musicMapper.deleteall(id[i]);
        }
    }

    @Override
    public void add(MusicEntity music) {
        if (music.getMusicId() == null) {
            musicMapper.add(music);
        } else {
            musicMapper.update(music);
        }

    }

    @Override
    public MusicEntity querybyud(Integer id) {
        return musicMapper.querybyid(id);
    }
}