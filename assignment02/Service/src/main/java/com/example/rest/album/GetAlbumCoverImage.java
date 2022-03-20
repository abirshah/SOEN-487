package com.example.rest.album;


import com.assignment.repository.AlbumsRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;


@Path("/album-cover")
public class GetAlbumCoverImage {


    @Produces({"image/jpg"})
    @GET
    public Response getAlbumCoverImage(@QueryParam("isrc") String isrc) throws Exception {

        var album = AlbumsRepository.instance().fetchAlbumByISRC(isrc);

        if(album.hasCoverImage())
        {
            File file = new File(album.getCoverImageFilePath());
            var stream = new FileInputStream(file);
            return Response.ok(stream.readAllBytes()).build();

        }else
            return Response.status(404).build();

    }

}
