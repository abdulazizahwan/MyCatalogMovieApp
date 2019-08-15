package com.example.mymoviecatalogapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MovieDetail extends AppCompatActivity {

    ImageView imgItemDetail;
    TextView tvItemDetailRating, tvItemDetailDuration, tvItemDetailLanguage, tvItemDescription;
    Button btnSetWatchMovieTrailer;
    String trailer_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        imgItemDetail = findViewById(R.id.img_item_detail);
        tvItemDetailRating = findViewById(R.id.tv_item_movie_rating);
        tvItemDetailDuration = findViewById(R.id.tv_item_movie_duration);
        tvItemDetailLanguage = findViewById(R.id.tv_item_movie_language);
        tvItemDescription = findViewById(R.id.tv_item_description);
        btnSetWatchMovieTrailer = findViewById(R.id.btn_set_watch_trailer);


        Movie movie = getIntent().getParcelableExtra("EXTRA_MOVIE");

        //Mengantisipasi terjadinya NullPointerException
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(movie.getMovie_name());
        }
        tvItemDetailRating.setText(movie.getMovie_rating());
        tvItemDetailDuration.setText(movie.getMovie_duration());
        tvItemDetailLanguage.setText(movie.getMovie_language());
        tvItemDescription.setText(movie.getMovie_long_overview());
        trailer_url = movie.getMovie_trailer();

        Glide.with(this).load(movie.getMovie_poster()).into(imgItemDetail);
    }

    public void onBrowseClick(View v) {
        Uri uri = Uri.parse(trailer_url);
        Intent setWatchMovieTrailerIntent = new Intent(Intent.ACTION_VIEW, uri);
        if (setWatchMovieTrailerIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(setWatchMovieTrailerIntent);
        }
    }
}
