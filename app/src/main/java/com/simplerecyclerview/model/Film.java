package com.simplerecyclerview.model;

/**
 * Created by roma on 12.06.15.
 */
public class Film {

    private String name;
    private String date;

    public Film(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
