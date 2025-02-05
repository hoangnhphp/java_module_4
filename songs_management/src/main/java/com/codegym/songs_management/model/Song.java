package com.codegym.songs_management.model;

import javax.persistence.*;

@Entity(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "artist", nullable = false, length = 255)
    private String artist;
    @Column(name = "link", nullable = false, length = 255)
    private String link;

    public Song() {}

    public Song(int id, String title, String artist, String link) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.link = link;
    }

    public Song(String title, String artist, String link) {
        this.title = title;
        this.artist = artist;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
