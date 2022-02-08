package com.example.rest.album;


import com.assignment.AlbumDBGatewayInMemoryImpl;
import com.assignment.entity.Album;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;


@Path("/albums")
public class UpdateAlbum {

    @PUT
    public String addAlbum(@QueryParam("isrc") String isrc,
                             @QueryParam("title") String title,
                             @QueryParam("artistNickName") String artistNickName,
                             @QueryParam("contentDescription") String contentDescription,
                             @QueryParam("releasedYear") int releasedYear) {


        var gateway = new AlbumDBGatewayInMemoryImpl();
        Album album = new Album(isrc, title, artistNickName, contentDescription, releasedYear);
        gateway.update(album);

        return album.toString();
    }

}
