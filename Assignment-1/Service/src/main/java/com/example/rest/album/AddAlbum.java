package com.example.rest.album;


import com.assignment.AlbumDBGatewayInMemoryImpl;
import com.assignment.entity.Album;
import jakarta.ws.rs.*;



@Path("/albums")
public class AddAlbum {


    @POST
    public String addAlbum(@QueryParam("isrc") String isrc,
                             @QueryParam("title") String title,
                             @QueryParam("artistNickName") String artistNickName,
                             @QueryParam("contentDescription") String contentDescription,
                             @QueryParam("releasedYear") int releasedYear) {


        var gateway = new AlbumDBGatewayInMemoryImpl();
        Album album = new Album(isrc, title, artistNickName, contentDescription, releasedYear);
        gateway.save(album);

        return album.toString();
    }

}
