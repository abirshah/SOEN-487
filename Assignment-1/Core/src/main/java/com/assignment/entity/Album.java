package com.assignment.entity;

import com.assignment.dbGateway.AlbumDBGateway;

public class Album extends Entity{
    public  final String isrc;
    public  final String title;
    public  final String artistNickName;
    public  final String contentDescription;
    public  final int releasedYear;

    public Album(String isrc, String title, String artistNickName, String contentDescription, int releasedYear) {
        super(isrc);
        this.isrc = isrc;
        this.title = title;
        this.artistNickName = artistNickName;
        this.contentDescription = contentDescription;
        this.releasedYear = releasedYear;
    }




    @Override
    public String toString() {
        return "Album{" +
                "isrc='" + isrc + '\'' +
                ", title='" + title + '\'' +
                ", artistNickName='" + artistNickName + '\'' +
                ", contentDescription='" + contentDescription + '\'' +
                ", releasedYear=" + releasedYear +
                '}';
    }
}
