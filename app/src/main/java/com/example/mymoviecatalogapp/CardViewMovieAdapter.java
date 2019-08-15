package com.example.mymoviecatalogapp;

import android.content.Context;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewMovieAdapter extends RecyclerView.Adapter<CardViewMovieAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Movie> movie;

    private ArrayList<Movie> getListMovie() {
        return movie;
    }

    public CardViewMovieAdapter(Context context) {
        this.context = context;
    }

    public void setListMovie(ArrayList<Movie> movie) {
        this.movie = movie;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_movie, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        Movie m = getListMovie().get(i);
        Glide.with(context)
                .load(m.getMovie_poster())
                .apply(new RequestOptions().override(350, 500))
                .into(cardViewHolder.imgPhoto);

        cardViewHolder.tvMovieName.setText(m.getMovie_name());
        cardViewHolder.tvMovieRating.setText(m.getMovie_rating());
        cardViewHolder.tvMovieDuration.setText(m.getMovie_duration());
        cardViewHolder.tvMovieLanguage.setText(m.getMovie_language());
        cardViewHolder.tvMovieShortOverview.setText(m.getMovie_short_overview());

        cardViewHolder.btnSetChooseMovie.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Anda Memilih Film " + getListMovie().get(position).getMovie_name(), Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvMovieName, tvMovieRating, tvMovieDuration, tvMovieLanguage, tvMovieShortOverview;
        Button btnSetChooseMovie;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_movie_poster);
            tvMovieName = itemView.findViewById(R.id.tv_item_movie_name);
            tvMovieRating = itemView.findViewById(R.id.tv_item_movie_rating);
            tvMovieDuration = itemView.findViewById(R.id.tv_item_movie_duration);
            tvMovieLanguage = itemView.findViewById(R.id.tv_item_movie_language);
            tvMovieShortOverview = itemView.findViewById(R.id.tv_item_movie_short_overview);
            btnSetChooseMovie = itemView.findViewById(R.id.btn_set_choose_movie);
        }
    }
}
