package com.example.myapplicationstfm.dao;

public class News {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String title;
    String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
