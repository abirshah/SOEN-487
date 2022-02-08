package com.assignment.dbGateway;

import com.assignment.entity.Artist;

import java.util.List;

public interface ArtistDBGateway {

    Artist findByNickName(String nickName);
    List<Artist> findByFullName(String firstName,String lastName);
    void save(Artist artist);
    void  update(Artist artist);
    void delete (String nickName);

    List<Artist>  findAll();
}
