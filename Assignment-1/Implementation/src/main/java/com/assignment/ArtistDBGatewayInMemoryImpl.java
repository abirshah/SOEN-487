package com.assignment;

import com.assignment.dbGateway.ArtistDBGateway;
import com.assignment.entity.Artist;

import java.util.List;

public class ArtistDBGatewayInMemoryImpl implements ArtistDBGateway {
    @Override
    public Artist findByNickName(String nickName) {
        return (Artist) InMemoryDB.instance().findById(nickName);
    }

    @Override
    public List<Artist> findByFullName(String firstName, String lastName) {
        return InMemoryDB.instance()
                .filter(Artist.class, it->it.firstName.equals(firstName) && it.lastName.equals(lastName));
    }

    @Override
    public void save(Artist artist) {
        InMemoryDB.instance().save(artist);
    }

    @Override
    public void update(Artist artist) {
        InMemoryDB.instance().update(artist);
    }

    @Override
    public void delete(String nickName) {
        InMemoryDB.instance().deleteWhereIdEquals(nickName);
    }

    @Override
    public List<Artist> findAll() {
        return InMemoryDB.instance().findAll(Artist.class);
    }
}
