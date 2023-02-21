package com.moviedb;

import java.io.Serializable;

public class ModelClass implements Serializable {

    String id;
    String title;
    String poster_path;


    public ModelClass(String id, String title, String poster_path) {
        this.id = id;
        this.title = title;
        this.poster_path = poster_path;
    }

    public ModelClass() {
    }


    public String getId() {return id;}

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
