package com.example.client;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleApplication {

    static Scanner scanner = new Scanner(System.in);
    static String baseUrl = "http://localhost:8080/";

    
    public static void main(String[] args) throws Exception {

        while (true)
            try{
                displayOptions();
            }catch (ApplicationWasQuit a)
            {
                System.out.println("see u later!!!");
                break;
            } catch (Throwable t)
            {
                System.err.println("something went wrong ");
                t.printStackTrace();
            }
    }

    private static void displayOptions() throws Exception {
        System.out.println("Please Select One...");

        System.out.println("0-Quit");

        System.out.println("1-Add Album");
        System.out.println("2-Update Album");
        System.out.println("3-Get Album By ISRC");
        System.out.println("4-Get Albums");
        System.out.println("5-Delete Album By ISRC");

        System.out.println("6-Add Artist");
        System.out.println("7-Update Artist");
        System.out.println("8-Get Artist By Nick Name");
        System.out.println("9-Get Artists");
        System.out.println("10-Delete Artist By Nick Name");



        var selectedOption = scanner.nextLine();

        switch (selectedOption)
        {
            case "1":
                addAlbum();
                break;

            case "2":
                updateAlbum();
                break;

            case "3":
                getSingleAlbum();
                break;

            case "4":
                getAlbums();
                break;

            case "5":
                deleteAlbum();
                break;

            case "6":
                addArtist();
                break;

            case "7":
                updateArtist();
                break;

            case "8":
                getSingleArtist();
                break;

            case "9":
                getAArtist();
                break;

            case "10":
                deleteArtist();
                break;

            case "0": throw new ApplicationWasQuit();
            default: System.out.println("please enter one of the specified numbers");
        }
    }

    private static void updateArtist() throws IOException {
        addOrUpdateArtist("PUT");
    }

    private static void deleteArtist() throws IOException {
        String isrc = askForEntry("nickName");

        String url = "servlet/artists";
        HttpResponse response = openConnection(url,"DELETE",
                new QueryParam("nickName",isrc)
        );

        System.out.println(response);
    }

    private static void getAArtist() throws IOException {
        String url = "servlet/artists";
        HttpResponse response = openConnection(url,"GET");
        System.out.println(response);
    }

    private static void getSingleArtist() throws IOException {
        String nickName = askForEntry("nickName");

        String url = "servlet/artists";
        HttpResponse response = openConnection(url,"GET",new QueryParam("nickName",nickName));

        System.out.println(response);
    }

    private static void addArtist() throws IOException {
        addOrUpdateArtist("POST");
    }

    private static void getSingleAlbum() throws IOException {
        String isrc = askForEntry("isrc");

        String url = "jax/albums/"+isrc;
        HttpResponse response = openConnection(url,"GET");

        System.out.println(response);
    }

    private static void getAlbums() throws IOException {
        String url = "jax/albums";
        HttpResponse response = openConnection(url,"GET");
        System.out.println(response);
    }

    private static void deleteAlbum() throws IOException {

        String isrc = askForEntry("isrc");

        String url = "jax/albums";
        HttpResponse response = openConnection(url,"DELETE",
                new QueryParam("isrc",isrc)
        );

        System.out.println(response);
    }

    private static void updateAlbum() throws IOException {
        addOrUpdateAlbum("PUT");
    }

    private static void addAlbum() throws Exception{

        addOrUpdateAlbum("POST");
    }

    private static void addOrUpdateAlbum(String method) throws IOException {
        String isrc = askForEntry("isrc");
        String title = askForEntry("title");
        String artistNickName = askForEntry("artistNickName");
        String contentDescription = askForEntry("contentDescription");
        String releasedYear = askForEntry("releasedYear");

        String url = "jax/albums";
        HttpResponse response = openConnection(url,method,
                new QueryParam("isrc",isrc),
                new QueryParam("title",title),
                new QueryParam("artistNickName",artistNickName),
                new QueryParam("contentDescription",contentDescription),
                new QueryParam("releasedYear",releasedYear)
        );

        System.out.println(response);
    }

    private static void addOrUpdateArtist(String method) throws IOException {
        String firstName = askForEntry("firstName");
        String lastName = askForEntry("lastName");
        String nickName = askForEntry("nickName");
        String bio = askForEntry("bio");


        String url = "servlet/artists";
        HttpResponse response = openConnection(url,method,
                new QueryParam("firstName",firstName),
                new QueryParam("lastName",lastName),
                new QueryParam("nickName",nickName),
                new QueryParam("bio",bio)
        );

        System.out.println(response);
    }

    private static String askForEntry(String fieldTitle) {
        System.out.println("enter "+fieldTitle+" ?");
        return scanner.nextLine();
    }

    private static HttpResponse openConnection(String resourceUrl,String method,QueryParam... params) throws IOException {

        var url = baseUrl +resourceUrl;
        if(params!=null)
        {
            url+="?";
            for(QueryParam param:params)
                url+=param.key+"="+URLEncoder.encode(param.value.toString(),StandardCharsets.UTF_8)+"&";
        }

        var connection = (HttpURLConnection)new URL(url ).openConnection();
        connection.setRequestMethod(method);
        connection.connect();
        var responseCode = connection.getResponseCode();
        var response = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        return new HttpResponse(response,responseCode);
    }

    public static class QueryParam{
        public final String key;
        public final Object value;

        public QueryParam(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class HttpResponse
    {
        public final String response;
        public final int responseCode;

        public HttpResponse(String response, int responseCode) {

            this.response = response;
            this.responseCode = responseCode;
        }


        public String toString() {
            return "response code was "+responseCode +"\n"+"response payload was "+response;
        }
    }

    public static class ApplicationWasQuit extends RuntimeException{}
}
