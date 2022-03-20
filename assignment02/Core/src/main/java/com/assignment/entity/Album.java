package com.assignment.entity;

public class Album extends Entity{
    public  final String isrc;
    public  final String title;
    public  final String artistNickName;
    public  final String contentDescription;
    public  final int releasedYear;
    private String coverImageFilePath;

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
                ", hasCoverImageFilePath=" + hasCoverImage() +
                '}';
    }

    public void setCoverImageFilePath(String absolutePath) {
        this.coverImageFilePath = absolutePath;
    }

    public boolean hasCoverImage()
    {
        return coverImageFilePath!=null && !coverImageFilePath.isBlank();
    }

    public String getCoverImageFilePath()
    {
        return hasCoverImage()? coverImageFilePath:"";
    }
}
