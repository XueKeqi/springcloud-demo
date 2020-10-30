package com.jk.service;

import com.jk.entity.MusicEntity;

import java.util.List;

public interface MusicService {
    List<MusicEntity> findList();

    void deleteall(String[] id);

    void add(MusicEntity music);

    MusicEntity querybyud(Integer id);
}
