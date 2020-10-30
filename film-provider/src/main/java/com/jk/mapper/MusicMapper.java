package com.jk.mapper;

import com.jk.entity.MusicEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MusicMapper {
    List<MusicEntity> findList();

    void deleteall(String s);

    void add(MusicEntity music);

    MusicEntity querybyid(Integer id);

    void update(MusicEntity music);
}
