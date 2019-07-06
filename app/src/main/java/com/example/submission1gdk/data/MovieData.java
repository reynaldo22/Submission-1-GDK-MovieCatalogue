package com.example.submission1gdk.data;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.submission1gdk.R;
import com.example.submission1gdk.model.Movie;

import java.util.ArrayList;

public class MovieData {

    private Context mContext;
    private String[] mMovieNames, mMovieDates, mMovieDescriptions, mMovieDuration;
    private TypedArray mMovieImage, mMovieGenres;

    public MovieData(Context context) {
        mContext = context;
    }

    public ArrayList<Movie> generateList() {
        prepare();

        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < mMovieNames.length; i++) {
            movies.add(new Movie(mMovieNames[i], mMovieDescriptions[i], mMovieDates[i], mMovieDuration[i], mMovieGenres.getResourceId(i, -1), mMovieImage.getResourceId(i, -1)));
        }

        mMovieImage.recycle();
        return movies;
    }

    private void prepare() {
        mMovieNames = mContext.getResources().getStringArray(R.array.movie_names);
        mMovieDates = mContext.getResources().getStringArray(R.array.movie_dates);
        mMovieDescriptions = mContext.getResources().getStringArray(R.array.movie_descriptions);
        mMovieImage = mContext.getResources().obtainTypedArray(R.array.movie_posters);
        mMovieDuration = mContext.getResources().getStringArray(R.array.movie_duration);
        mMovieGenres = mContext.getResources().obtainTypedArray(R.array.movie_genres);
    }
}
