package com.example.rest;

import com.example.rest.artist.ArtistServlet;
import com.example.rest.logEntry.LogEntrySoapWebServiceImpl;
import jakarta.xml.ws.Endpoint;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;





public class Main {


    public static Server startServletServer() throws Exception {

        Server server = new Server(8080);

        var servletContextHandler = createServletContextHandler();

        server.setHandler(servletContextHandler);

        server.start();

        return server;
    }

    private static void startSoapServer() {
        Endpoint.publish(
                "http://localhost:8081/logEntry",
                new LogEntrySoapWebServiceImpl());
    }


    private static ServletContextHandler createServletContextHandler() {
        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        ctx.setContextPath("/");

        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/jax/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages", "com.example.rest");

        ctx.addServlet(ArtistServlet.class, "/servlet/artists");

        return ctx;
    }

    public static void main(String[] args) throws Exception {

        startSoapServer();

        Server server = startServletServer();

        System.out.println("app started");
        server.join();

    }
}

