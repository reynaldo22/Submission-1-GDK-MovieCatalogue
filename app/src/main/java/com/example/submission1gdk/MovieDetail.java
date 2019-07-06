package com.example.submission1gdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.submission1gdk.model.Movie;

public class MovieDetail extends AppCompatActivity {

    public static final String MOVIE_EXTRA = "MOVIE_EXTRA";

    ImageView mMoviePoster;
    TextView mMovieName, mMovieDate, mMovieGenres, mMovieDuration, mMovieDescription;

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        mMoviePoster = findViewById(R.id.movie_poster);
        mMovieName = findViewById(R.id.movie_detail_name_tv);
        mMovieDate = findViewById(R.id.movie_detail_date_tv);
        mMovieGenres = findViewById(R.id.movie_genres);
        mMovieDuration = findViewById(R.id.movie_duration);
        mMovieDescription = findViewById(R.id.movie_desc_tv);

        Bundle movieExtra = getIntent().getExtras();

        if (movieExtra != null) {
            movie = movieExtra.getParcelable(MOVIE_EXTRA);

            if (movie != null) {
                // append movie genres
                StringBuilder appendedMovieGenres = new StringBuilder();
                String[] movieGenres = getResources().getStringArray(movie.getMovieGenres());

                for (int i = 0; i < movieGenres.length; i++) {
                    appendedMovieGenres.append(movieGenres[i]);
                    if (i != movieGenres.length - 1) {
                        appendedMovieGenres.append(", ");
                    }
                }

                // set activity title corresponding to movie title
                setTitle(movie.getMovieName());

                Glide.with(this)
                        .load(movie.getMovieImage())
                        .into(mMoviePoster);
                mMovieName.setText(movie.getMovieName());
                mMovieDate.setText(movie.getMovieDate());
                mMovieGenres.setText(appendedMovieGenres.toString());
                mMovieDuration.setText(movie.getMovieDuration());
                mMovieDescription.setText(movie.getMovieDescription());
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
