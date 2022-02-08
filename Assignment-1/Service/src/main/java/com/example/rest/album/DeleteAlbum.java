package com.example.rest.album;


import com.assignment.AlbumDBGatewayInMemoryImpl;
import com.assignment.entity.Album;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;


@Path("/albums")
public class DeleteAlbum {


    @DELETE
    public String addAlbum(@QueryParam("isrc") String isrc) {

        var gateway = new AlbumDBGatewayInMemoryImpl();
        gateway.delete(isrc);
        return isrc+" was deleted ";
    }

}
