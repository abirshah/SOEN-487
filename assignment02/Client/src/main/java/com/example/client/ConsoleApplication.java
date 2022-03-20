package com.example.client;

import com.example.client.soapClient.LogEntrySoapWebServiceImplService;
import jakarta.xml.ws.soap.SOAPFaultException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.UUID;

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

        System.out.println("11-Fetch All Log Entries");
        System.out.println("12-Delete All Log Entries");

        System.out.println("13-Update Album Cover Image");
        System.out.println("14-Delete Album Cover Image");
        System.out.println("15-Get Album Cover Image");



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

            case "11":
                var fromDate = askForEntry("from date? (Accepted Format : YYYY:MM:DD-H:M:S  or empty for any)");
                var toDate = askForEntry("to date? (Accepted Format : YYYY:MM:DD-H:M:S  or empty for any)");
                var logType = askForEntry("log type? (Create|Delete|Update or empty for any)");
                fetchAllLogEntries(fromDate,toDate,logType);
                break;

            case "12":
                deleteAllLogEntries();
                break;


            case "13":
                var isrc = askForEntry("enter isrc of the album you are trying to update cover image");
                var imageFilePath = askForEntry("enter image absolute file path");
                updateAlbumImageCover(isrc,imageFilePath);
                break;

            case "14":
                var isrcToDeleteCover = askForEntry("enter isrc of the album you are trying to delete cover image");
                deleteAlbumCoverImage(isrcToDeleteCover);
                break;

            case "15":
                var isrcToGetCoverImage = askForEntry("enter isrc of the album you are trying to get cover image");
                downloadAlbumCoverImage(isrcToGetCoverImage);
                break;

            case "0": throw new ApplicationWasQuit();
            default: System.out.println("please enter one of the specified numbers");
        }
    }

    private static void deleteAllLogEntries() {
        var log =new LogEntrySoapWebServiceImplService();
        try {
            System.out.println(log.getLogEntrySoapWebServiceImplPort().deleteAll());
        }catch (SOAPFaultException e)
        {
            var message = e.getFault().getFaultString();
            System.err.println("received soap fault with message "+message);
        }
    }

    private static void downloadAlbumCoverImage(String isrcToGetCoverImage) throws Exception {
        String url = "jax/album-cover";
        HttpResponse response = openConnection(url,"GET",
                new QueryParam("isrc",isrcToGetCoverImage)
        );

        if(response.responseCode==404)
        {
            System.out.println("there was no cover image for "+isrcToGetCoverImage);
            return;
        }

        File f = File.createTempFile(UUID.randomUUID().toString(),".png");
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        fileOutputStream.write(response.response);
        fileOutputStream.close();


        System.out.println("cover image of "+isrcToGetCoverImage+" was downloaded to file "+f.getAbsolutePath());
    }

    private static void deleteAlbumCoverImage(String isrcToDeleteCover) throws Exception{
        String url = "jax/album-cover";
        HttpResponse response = openConnection(url,"DELETE",
                new QueryParam("isrc",isrcToDeleteCover)
        );

        System.out.println(response);
    }

    private static void updateAlbumImageCover(String isrc, String imageFilePath) throws Exception{
        String url = "jax/album-cover";

        FileInputStream stream = new FileInputStream(imageFilePath);
        var bytes = stream.readAllBytes();

        HttpResponse response = openConnection(url,"POST",bytes,
                new QueryParam("isrc",isrc)
        );

        System.out.println("cover image of "+isrc+" was updated");
    }

    private static void fetchAllLogEntries(String fromDate, String toDate, String logType) {
        var log =new LogEntrySoapWebServiceImplService();
        System.out.println(log.getLogEntrySoapWebServiceImplPort().fetchFromDateToDateWithLogType(fromDate,toDate,logType));
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

        return openConnection(resourceUrl,method,new byte[0],params);
    }

    private static HttpResponse openConnection(String resourceUrl,String method,byte[] body,QueryParam... params) throws IOException {

        StringBuilder url = new StringBuilder(baseUrl + resourceUrl);
        if(params!=null)
        {
            url.append("?");
            for(QueryParam param:params)
                url.append(param.key).append("=").append(URLEncoder.encode(param.value.toString(), StandardCharsets.UTF_8)).append("&");
        }

        var connection = (HttpURLConnection)new URL(url.toString()).openConnection();
        connection.setRequestMethod(method);
        connection.setDoInput(true);

        boolean hasBody = body != null && body.length > 0;
        if(hasBody)
        {
            connection.setDoOutput(true);
            connection.setRequestProperty("content-length",body.length+"");
        }

        connection.connect();

        if(hasBody)
            connection.getOutputStream().write(body);


        var responseCode = connection.getResponseCode();

        if(responseCode >= 200 && responseCode<300)
            return new HttpResponse(connection.getInputStream().readAllBytes(),responseCode);

        return new HttpResponse(new byte[0],responseCode);
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
        public final byte[] response;
        public final int responseCode;

        public HttpResponse(byte[] response, int responseCode) {

            this.response = response;
            this.responseCode = responseCode;
        }

        public String responseAsString()
        {
            if(response!=null)
                return new String(response,StandardCharsets.UTF_8);

            return "";
        }

        public String toString() {
            return "response code was "+responseCode +"\n"+"response payload was "+responseAsString();
        }
    }

    public static class ApplicationWasQuit extends RuntimeException{}
}
