package com.assignment.persistence.derbySQL;

import com.assignment.dbGateway.AlbumDBGateway;
import com.assignment.entity.Album;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDBGatewayDerbyImpl implements AlbumDBGateway {

    private static AlbumDBGatewayDerbyImpl instance;

    public static AlbumDBGatewayDerbyImpl instance() {
        if (instance == null)
            instance = new AlbumDBGatewayDerbyImpl();

        return instance;
    }

    private AlbumDBGatewayDerbyImpl() {
        doItInsideStatement(statement -> statement.execute("""

                            CREATE TABLE Albums (
                               isrc varchar(100) , 
                               title varchar(100) , 
                               artistNickName varchar(100) , 
                               contentDescription varchar(100) , 
                               coverImageFilePath varchar(500) , 
                               releasedYear INT 
                                )
                           
                """));
    }


    private <T> T doItInsideStatement(StatementTask runner) {
        try {
            var statement = DerbyGateway.instance().connection.createStatement();
            var returnValue = runner.doItInsideStatement(statement);
            statement.close();
            return (T)returnValue;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public Album findByISRC(String isrc) {

       return doItInsideStatement(statement -> {

            var resultSet = statement.executeQuery("select * from Albums where isrc='"+ isrc +"'");
            Album album = extractCurrentRecordAsAlbum(resultSet);
            resultSet.close();
            return album;
        });


    }

    private Album extractCurrentRecordAsAlbum( ResultSet resultSet) throws SQLException {

        if(!resultSet.next())
            return null;


        var isrc = resultSet.getString("isrc");
        var title = resultSet.getString("title");
        var artistNickName = resultSet.getString("artistNickName");
        var contentDescription = resultSet.getString("contentDescription");
        var coverImageFilePath = resultSet.getString("coverImageFilePath");
        var releasedYear = resultSet.getInt("releasedYear");

        Album album = new Album(isrc, title, artistNickName, contentDescription, releasedYear);
        album.setCoverImageFilePath(coverImageFilePath);
        return album;
    }

    @Override
    public List<Album> findByTitle(String title) {
        return doItInsideStatement(statement -> {

            var resultSet = statement.executeQuery("select * from Albums where title='"+ title +"'");
            Album album = extractCurrentRecordAsAlbum(resultSet);
            resultSet.close();
            return album;
        });
    }

    @Override
    public void save(Album album) {
        doItInsideStatement(statement -> {

            statement.execute("insert into Albums" +
                    "(isrc,title,artistNickName,contentDescription,coverImageFilePath,releasedYear)" +
                    " values("
                            +"'"+album.isrc+"'" + ","
                            +"'"+album.title+"'" +","
                            +"'"+album.artistNickName+"'"+","
                            +"'"+album.contentDescription+"'"+","
                            +"'"+album.getCoverImageFilePath()+"'"+","
                            +album.releasedYear +")"
            );


            if(statement.getUpdateCount()<1)
                throw new RuntimeException("could not save");

            return null;
        });
    }

    @Override
    public void update(Album album) {
        doItInsideStatement(statement -> {

            statement.execute("update Albums set "
                    +"isrc='" +album.isrc+ "',"
                    +"title='" +album.title+"',"
                    +"artistNickName='"+album.artistNickName+"',"
                    +"contentDescription='"+album.contentDescription+"',"
                    +"coverImageFilePath='"+album.getCoverImageFilePath()+"',"
                    +"releasedYear=" + album.releasedYear+
                    " where isrc='"+album.isrc+"'"
            );


            return null;
        });
    }

    @Override
    public void delete(String isrc) {
        doItInsideStatement(statement -> {

            statement.execute("delete from Albums where isrc='"+isrc+"'");

            return null;
        });
    }

    @Override
    public List<Album> findAll() {
        return doItInsideStatement(statement -> {

            var resultSet = statement.executeQuery("select * from Albums");
            var albums = new ArrayList<Album>();
            Album album ;
            while((album = extractCurrentRecordAsAlbum(resultSet))!=null)
                albums.add(album);

            resultSet.close();
            return albums;
        });
    }


}
