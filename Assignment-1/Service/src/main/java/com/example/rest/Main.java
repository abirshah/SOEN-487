package com.example.rest;

import com.example.rest.artist.ArtistServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;





public class Main {


    public static Server startServer() throws Exception {


        Server server = new Server(8080);
        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        ctx.setContextPath("/");
        server.setHandler(ctx);
        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/jax/*");
        ServletHolder serHol2 = ctx.addServlet(ArtistServlet.class, "/servlet/artists");

        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages",
                "com.example.rest");

        server.start();


       return server;
    }

    public static void main(String[] args) throws Exception {;
        final Server server = startServer();
        System.out.println("app started");
        server.join();

    }
}

