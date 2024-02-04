package com.svanreilly.moviestream;

public class Movie {

        private String title;
        private String director;
        private String cover;
        private String releaseDate;
        private String streamingLink;
        public Movie(String title, String director, String cover, String releaseDate, String streamingLink) {
            this.title = title;
            this.director = director;
            this.cover = cover;
            this.releaseDate = releaseDate;
            this.streamingLink = streamingLink;

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

}
