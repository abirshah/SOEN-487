package com.assignment.entity;

public class Artist extends Entity{

    public final String firstName;
    public final String lastName;
    public final String nickName;
    public final String bio;

    public Artist(String firstName, String lastName, String nickName, String bio) {
        super(nickName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.bio = bio;
    }


    @Override
    public String toString() {
        return "Artist{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
