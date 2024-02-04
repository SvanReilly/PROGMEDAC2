package com.svanreilly.moviestream;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final Context context;
    private final ArrayList<Movie> moviesList;
    public imageButtonClickListener imageButtonClickListener;

    public MovieAdapter(Context context, ArrayList<Movie> moviesList, imageButtonClickListener imageButtonClickListener) {
        this.context = context;
        this.moviesList = moviesList;
        this.imageButtonClickListener = imageButtonClickListener;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view, imageButtonClickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.BindMovies(this.moviesList.get(position));
    }
    @Override
    public int getItemCount() {
        return this.moviesList.size();
    }


    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleView;
        public TextView directorView;
        public ImageView coverView;
        public TextView releaseDateView;
        public ImageButton playButtonView;
        public imageButtonClickListener imageButtonClickListener;


        public MovieViewHolder(@NonNull View view, imageButtonClickListener imageButtonClickListener) {
            super(view);
            this.imageButtonClickListener = imageButtonClickListener;

            playButtonView = view.findViewById(R.id.imagePlayButtonView);
            playButtonView.setOnClickListener(this);

            titleView = view.findViewById(R.id.movieTitleView);
            directorView = view.findViewById(R.id.movieDirectorView);
            coverView = view.findViewById(R.id.movieCoverView);
            releaseDateView = view.findViewById(R.id.movieReleaseDateView);

        }

        public void BindMovies(Movie movie) {
            titleView.setText(movie.getTitle());
            directorView.setText(movie.getDirector());
            coverView.setImageResource(
                    coverView.getResources().getIdentifier(movie.getCover(),
                            "drawable",
                            "com.svanreilly.moviestream"));
            releaseDateView.setText(movie.getReleaseDate());
            Glide.with(playButtonView).asGif().load(R.drawable.playbutton).into(playButtonView);
        }

        @Override
        public void onClick(View v) {
            imageButtonClickListener.onImageButtonClick(getAdapterPosition());
        }
    }

    public interface imageButtonClickListener {
        void onImageButtonClick(int position);
    }

}
