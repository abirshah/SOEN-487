package com.example.rest.album;


import com.assignment.AlbumDBGatewayInMemoryImpl;
import jakarta.ws.rs.*;


@Path("/albums/{isrc}")
public class GetAlbum {


    @GET
    public String addAlbum(@PathParam("isrc") String isrc) {
        
        var gateway = new AlbumDBGatewayInMemoryImpl();
        var album = gateway.findByISRC(isrc);
        return album.toString();
    }

}
