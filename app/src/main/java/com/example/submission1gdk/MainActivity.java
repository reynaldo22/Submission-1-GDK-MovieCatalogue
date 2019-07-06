package com.example.submission1gdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.submission1gdk.adapter.MovieAdapter;
import com.example.submission1gdk.data.MovieData;

public class MainActivity extends AppCompatActivity {

    ListView listMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listMovie = findViewById(R.id.movie_list);

        listMovie.setAdapter(new MovieAdapter(this, new MovieData(this).generateList()));

    }
}
