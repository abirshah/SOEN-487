package com.example.rest.album;


import com.assignment.entity.Album;
import com.assignment.repository.AlbumsRepository;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/album-cover")
public class DeleteAlbumCoverImage {

    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Album updateAlbumCoverImage(@QueryParam("isrc") String isrc) {

        return AlbumsRepository.instance().deleteAlbumCoverImage(isrc);
    }

}
