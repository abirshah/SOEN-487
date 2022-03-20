package com.assignment.repository;

import com.assignment.dbGateway.AlbumDBGateway;
import com.assignment.dbGateway.LogEntryDBGateway;
import com.assignment.entity.Album;
import com.assignment.entity.LogEntry;
import com.assignment.persistence.derbySQL.AlbumDBGatewayDerbyImpl;
import com.assignment.persistence.derbySQL.LogEntryDBGatewayDerbyImpl;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class AlbumsRepository {

    private static AlbumsRepository instance ;
    public static AlbumsRepository instance()
    {
        if(instance ==null)
            instance = new AlbumsRepository();

        return instance;
    }


    private final AlbumDBGateway albumsDBGateway ;
    private final LogEntryDBGateway logEntryDBGateway;

    private AlbumsRepository(){
        albumsDBGateway = AlbumDBGatewayDerbyImpl.instance();
        logEntryDBGateway = LogEntryDBGatewayDerbyImpl.instance();
    }



    public Album createNewAlbum(String isrc, String title, String artistNickName, String contentDescription, int releasedYear) {

        Album album = new Album(isrc, title, artistNickName, contentDescription, releasedYear);
        albumsDBGateway.save(album);

       logTheChange(isrc, LogEntry.LogType.Create);

        return album;
    }

    private void logTheChange(String isrc, LogEntry.LogType logType) {
        var log = new LogEntry(isrc, logType);
        logEntryDBGateway.save(log);
    }

    public void deleteAlbumByISRC(String isrc) {
        albumsDBGateway.delete(isrc);
        logTheChange(isrc, LogEntry.LogType.Delete);
    }

    public Album getAlbumInfoByISRC(String isrc) {
        return albumsDBGateway.findByISRC(isrc);
    }

    public List<Album> getAllAlbums() {
        return albumsDBGateway.findAll();
    }

    public Album updateAlbumByISRC(String isrc, String title, String artistNickName, String contentDescription, int releasedYear) {
        Album album = new Album(isrc, title, artistNickName, contentDescription, releasedYear);
        albumsDBGateway.update(album);

        logTheChange(isrc, LogEntry.LogType.Update);

        return album;
    }

    public Album updateAlbumCoverImage(String isrc, InputStream inputStream) throws Exception {
        var album = albumsDBGateway.findByISRC(isrc);
        File file = File.createTempFile(UUID.randomUUID().toString(),".jpg");
        var fileStream = new FileOutputStream(file);
        fileStream.write(inputStream.readAllBytes());
        fileStream.close();

        album.setCoverImageFilePath(file.getAbsolutePath());
        albumsDBGateway.update(album);
        return album;
    }

    public Album deleteAlbumCoverImage(String isrc) {
        var album = albumsDBGateway.findByISRC(isrc);
        album.setCoverImageFilePath("");
        albumsDBGateway.update(album);
        return album;
    }

    public Album fetchAlbumByISRC(String isrc) {
        return albumsDBGateway.findByISRC(isrc);
    }
}
