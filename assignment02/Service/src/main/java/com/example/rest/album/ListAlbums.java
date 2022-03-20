package com.example.rest.album;


import com.assignment.entity.Album;
import com.assignment.repository.AlbumsRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/albums")
public class ListAlbums {

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Album> getAlbumsInfo() {

        return AlbumsRepository.instance().getAllAlbums();
    }

}
