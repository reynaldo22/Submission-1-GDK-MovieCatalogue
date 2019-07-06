package com.example.submission1gdk.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.submission1gdk.MovieDetail;
import com.example.submission1gdk.R;
import com.example.submission1gdk.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private ArrayList<Movie> mMovies;
    private Context mcontext;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        mMovies = movies;
        mcontext = context;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int i) {
        return mMovies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(mcontext).inflate(R.layout.movie_item, viewGroup,false);
        }

        ViewHolder holder = new ViewHolder(view);
        holder.bind((Movie) getItem(i));
        return view;
    }

    private class ViewHolder {
        CardView mMovieCard;
        ImageView mImageView;
        TextView mMovieName, mMovieDate, mMovieShortDescription;

        ViewHolder(View view) {
            mMovieName = view.findViewById(R.id.movie_name_tv);
            mMovieDate = view.findViewById(R.id.movie_date_tv);
            mMovieShortDescription = view.findViewById(R.id.movie_short_desc_tv);
            mImageView = view.findViewById(R.id.movie_img);
            mMovieCard = view.findViewById(R.id.movie_card);
        }

        void bind(final Movie movie) {
            String shortDescription = movie.getMovieDescription();

            Glide.with(mcontext)
                    .load(movie.getMovieImage())
                    .centerCrop()
                    .into(mImageView);
            mMovieName.setText(movie.getMovieName());
            mMovieDate.setText(movie.getMovieDate());

            if (shortDescription.length() > 150) {
                shortDescription = shortDescription.substring(0, 146).concat("...");
            }

            mMovieShortDescription.setText(shortDescription);

            mMovieCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent to movie detail
                    Intent intent = new Intent(mcontext, MovieDetail.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    intent.putExtra(MovieDetail.MOVIE_EXTRA, movie);
                    mcontext.startActivity(intent);
                }
            });
        }
    }
}
