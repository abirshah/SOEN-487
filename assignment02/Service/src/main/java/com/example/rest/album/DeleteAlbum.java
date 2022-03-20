package com.example.rest.album;


import com.assignment.repository.AlbumsRepository;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/albums")
public class DeleteAlbum {


    @DELETE
    public Response deleteAlbum(@QueryParam("isrc") String isrc) {

        AlbumsRepository.instance().deleteAlbumByISRC(isrc);
        return Response.accepted().build();
    }

}
