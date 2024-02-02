package com.svanreilly.moviestream;

import android.widget.Button;
import android.widget.ImageButton;

public class Movie {

        private String title;
        private String director;
        private String cover;
        private String releaseDate;
        private String streamingLink;
        private ImageButton playButton;
        public Movie(String title, String director, String cover, String releaseDate, String streamingLink, ImageButton playButton) {
            this.title = title;
            this.director = director;
            this.cover = cover;
            this.releaseDate = releaseDate;
            this.streamingLink = streamingLink;
            this.playButton = playButton;
        }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }

    public ImageButton getPlayButton() {
        return playButton;
    }

    public void setPlayButton(ImageButton playButton) {
        this.playButton = playButton;
    }
}
