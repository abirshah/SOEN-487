package com.example.rest.album;


import com.assignment.AlbumDBGatewayInMemoryImpl;
import com.assignment.entity.Album;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;


@Path("/albums")
public class ListAlbums {


    @GET
    public String addAlbum() {


        var gateway = new AlbumDBGatewayInMemoryImpl();
        var albums = gateway.findAll();

        return albums.toString();
    }

}
