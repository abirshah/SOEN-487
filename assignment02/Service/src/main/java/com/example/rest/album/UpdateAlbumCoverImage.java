package com.example.rest.album;


import com.assignment.entity.Album;
import com.assignment.repository.AlbumsRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;


@Path("/album-cover")
public class UpdateAlbumCoverImage {

    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Album updateAlbumCoverImage(@QueryParam("isrc") String isrc, @Context HttpServletRequest request) throws Exception {

        return AlbumsRepository.instance().updateAlbumCoverImage(isrc,request.getInputStream());
    }
}
