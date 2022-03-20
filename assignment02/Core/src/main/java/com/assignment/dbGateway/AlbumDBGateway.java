package com.assignment.dbGateway;

import com.assignment.entity.Album;

import java.util.List;

public interface AlbumDBGateway {

    Album findByISRC(String isrc);
    List<Album> findByTitle(String title);
    void save(Album album);
    void update(Album albom);
    void delete(String isrc);

    List<Album> findAll();


}
