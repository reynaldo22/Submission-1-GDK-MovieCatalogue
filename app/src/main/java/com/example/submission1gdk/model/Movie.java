package com.example.submission1gdk.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int mMovieImage;
    private String mMovieName, mMovieDescription, mMovieDate, mMovieDuration;
    private int mMovieGenres;

    public Movie(String movieName, String movieDescription, String movieDate, String movieDuration, int movieGenres, int movieImage) {
        mMovieName = movieName;
        mMovieDescription = movieDescription;
        mMovieDate = movieDate;
        mMovieImage = movieImage;
        mMovieDuration = movieDuration;
        mMovieGenres = movieGenres;
    }

    protected Movie(Parcel in) {
        mMovieImage = in.readInt();
        mMovieName = in.readString();
        mMovieDescription = in.readString();
        mMovieDate = in.readString();
        mMovieDuration = in.readString();
        mMovieGenres = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mMovieImage);
        dest.writeString(mMovieName);
        dest.writeString(mMovieDescription);
        dest.writeString(mMovieDate);
        dest.writeString(mMovieDuration);
        dest.writeInt(mMovieGenres);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getMovieName() {
        return mMovieName;
    }

    public void setMovieName(String movieName) {
        mMovieName = movieName;
    }

    public String getMovieDescription() {
        return mMovieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        mMovieDescription = movieDescription;
    }

    public String getMovieDate() {
        return mMovieDate;
    }

    public void setMovieDate(String movieDate) {
        mMovieDate = movieDate;
    }

    public int getMovieImage() {
        return mMovieImage;
    }

    public void setMovieImage(int movieImage) {
        mMovieImage = movieImage;
    }

    public String getMovieDuration() {
        return mMovieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        mMovieDuration = movieDuration;
    }

    public int getMovieGenres() {
        return mMovieGenres;
    }

    public void setMovieGenres(int movieGenres) {
        mMovieGenres = movieGenres;
    }

}
