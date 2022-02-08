package com.example.rest.artist;

import com.assignment.ArtistDBGatewayInMemoryImpl;
import com.assignment.entity.Artist;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



public class ArtistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var firstName = req.getParameter("firstName");
        var lastName = req.getParameter("lastName");
        var nickName = req.getParameter("nickName");
        var bio = req.getParameter("bio");

        var artist = new Artist(firstName,lastName,nickName,bio);
        var gateway = new ArtistDBGatewayInMemoryImpl();
        gateway.save(artist);

        resp.getOutputStream().println(artist.toString());

        resp.setStatus(201);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var gateway = new ArtistDBGatewayInMemoryImpl();
        var nickName = req.getParameter("nickName");

        if(nickName!=null)
        {
            var artist = gateway.findByNickName(nickName);
            resp.getOutputStream().println(artist.toString());
        }else
        {
            var artists = gateway.findAll();
            resp.getOutputStream().println(artists.toString());
        }

        resp.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var gateway = new ArtistDBGatewayInMemoryImpl();
        var nickName = req.getParameter("nickName");
        gateway.delete(nickName);

        resp.getOutputStream().println("album with nick name "+nickName+" was deleted!");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var firstName = req.getParameter("firstName");
        var lastName = req.getParameter("lastName");
        var nickName = req.getParameter("nickName");
        var bio = req.getParameter("bio");

        var artist = new Artist(firstName,lastName,nickName,bio);
        var gateway = new ArtistDBGatewayInMemoryImpl();
        gateway.update(artist);

        resp.getOutputStream().println(artist.toString());

        resp.setStatus(201);
    }


}
