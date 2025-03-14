package com.example.kvizko.Models;

public class ProfileModel {

    private String name;
    private String email;
    private int bookmarksCount;

    public ProfileModel(String name, String email, int bookmarksCount) {
        this.name = name;
        this.email = email;
        this.bookmarksCount=bookmarksCount;
    }

    public int getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(int bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
