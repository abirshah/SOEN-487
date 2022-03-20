package com.example.rest.album;


import com.assignment.entity.Album;
import com.assignment.repository.AlbumsRepository;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/albums")
public class UpdateAlbum {

    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public Album updateAlbum(@QueryParam("isrc") String isrc,
                             @QueryParam("title") String title,
                             @QueryParam("artistNickName") String artistNickName,
                             @QueryParam("contentDescription") String contentDescription,
                             @QueryParam("releasedYear") int releasedYear) {


        return AlbumsRepository.instance().updateAlbumByISRC(isrc,title,artistNickName,contentDescription,releasedYear);
    }

}
