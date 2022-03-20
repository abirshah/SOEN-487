package com.example.rest.album;


import com.assignment.entity.Album;
import com.assignment.repository.AlbumsRepository;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/albums")
public class AddAlbum {


    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Album addAlbum(@QueryParam("isrc") String isrc,
                          @QueryParam("title") String title,
                          @QueryParam("artistNickName") String artistNickName,
                          @QueryParam("contentDescription") String contentDescription,
                          @QueryParam("releasedYear") int releasedYear) {


        return AlbumsRepository.instance().createNewAlbum(isrc, title, artistNickName, contentDescription, releasedYear);
    }

}
