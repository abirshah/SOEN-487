package com.example.rest.album;


import com.assignment.entity.Album;
import com.assignment.repository.AlbumsRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/albums/{isrc}")
public class GetAlbum {

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Album getAlbumInfo(@PathParam("isrc") String isrc) {

        return AlbumsRepository.instance().getAlbumInfoByISRC(isrc);
    }

}
