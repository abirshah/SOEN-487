package com.assignment;

import com.assignment.dbGateway.AlbumDBGateway;
import com.assignment.entity.Album;

import java.util.List;

public class AlbumDBGatewayInMemoryImpl  implements AlbumDBGateway {


    public Album findByISRC(String isrc) {
        return (Album)InMemoryDB.instance().findById(isrc);
    }

    public List<Album> findByTitle(String title) {
        return InMemoryDB.instance()
                        .filter(Album.class,it->it.title.equals(title));
    }

    public void save(Album album) {
        InMemoryDB.instance().save(album);
    }

    public void update(Album album) {
        InMemoryDB.instance().update(album);
    }

    public void delete(String isrc) {
        InMemoryDB.instance().deleteWhereIdEquals(isrc);
    }

    @Override
    public List<Album> findAll() {
        return InMemoryDB.instance().findAll(Album.class);
    }
}
