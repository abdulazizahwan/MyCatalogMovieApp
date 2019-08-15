package com.example.mymoviecatalogapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String movie_name, movie_rating, movie_duration, movie_language, movie_short_overview, movie_long_overview, movie_poster, movie_trailer;

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(String movie_rating) {
        this.movie_rating = movie_rating;
    }

    public String getMovie_duration() {
        return movie_duration;
    }

    public void setMovie_duration(String movie_duration) {
        this.movie_duration = movie_duration;
    }

    public String getMovie_language() {
        return movie_language;
    }

    public void setMovie_language(String movie_language) {
        this.movie_language = movie_language;
    }

    public String getMovie_short_overview() {
        return movie_short_overview;
    }

    public void setMovie_short_overview(String movie_short_overview) {
        this.movie_short_overview = movie_short_overview;
    }

    public String getMovie_long_overview() {
        return movie_long_overview;
    }

    public void setMovie_long_overview(String movie_long_overview) {
        this.movie_long_overview = movie_long_overview;
    }

    public String getMovie_poster() {
        return movie_poster;
    }

    public void setMovie_poster(String movie_poster) {
        this.movie_poster = movie_poster;
    }

    public String getMovie_trailer() {
        return movie_trailer;
    }

    public void setMovie_trailer(String movie_trailer) {
        this.movie_trailer = movie_trailer;
    }

    public Movie(String name, String rating, String duration, String language, String short_overview, String long_overview, String poster, String trailer) {
        this.movie_name = name;
        this.movie_rating = rating;
        this.movie_duration = duration;
        this.movie_language = language;
        this.movie_short_overview = short_overview;
        this.movie_long_overview = long_overview;
        this.movie_poster = poster;
        this.movie_trailer = trailer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movie_name);
        dest.writeString(this.movie_rating);
        dest.writeString(this.movie_duration);
        dest.writeString(this.movie_language);
        dest.writeString(this.movie_short_overview);
        dest.writeString(this.movie_long_overview);
        dest.writeString(this.movie_poster);
        dest.writeString(this.movie_trailer);
    }

    protected Movie(Parcel in) {
        this.movie_name = in.readString();
        this.movie_rating = in.readString();
        this.movie_duration = in.readString();
        this.movie_language = in.readString();
        this.movie_short_overview = in.readString();
        this.movie_long_overview = in.readString();
        this.movie_poster = in.readString();
        this.movie_trailer = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
