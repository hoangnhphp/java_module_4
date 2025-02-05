package com.codegym.songs_management.service;

import com.codegym.songs_management.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song customer);

    Song findById(int id);

    void remove(int id);
}
