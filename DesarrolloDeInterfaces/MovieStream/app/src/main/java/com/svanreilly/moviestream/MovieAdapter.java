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

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
        private Movie[] moviesList;

        public MovieAdapter(Movie[] booksList) {
            this.moviesList = booksList;
        }
        @NonNull
        @Override
        public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

            return new MovieViewHolder(view, parent.getContext());
        }
        @Override
        public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
            holder.BindMovies(this.moviesList[position]);
            holder.playButtonView.setTag(position);

        }
        @Override
        public int getItemCount() {
            return this.moviesList.length;
        }
        public static class MovieViewHolder extends RecyclerView.ViewHolder {
            public TextView titleView;
            public TextView directorView;
            public ImageView coverView;
            public TextView releaseDateView;
            public TextView streamingLinkView;
            public ImageButton playButtonView;

            private Context context;
            public MovieViewHolder(View view, Context context) {
                super(view);
                this.context = context;

                titleView = view.findViewById(R.id.movieTitleView);
                directorView = view.findViewById(R.id.movieDirectorView);
                coverView = view.findViewById(R.id.movieCoverView);
                releaseDateView = view.findViewById(R.id.movieReleaseDateView);
                playButtonView = view.findViewById(R.id.imagePlayButtonView);
            }
            public void BindMovies(Movie movie){
                titleView.setText(movie.getTitle());
                directorView.setText(movie.getDirector());
                coverView.setImageResource(
                        context.getResources().getIdentifier(movie.getCover(),
                                "drawable",
                                "com.svanreilly.moviestream"));
                releaseDateView.setText(movie.getReleaseDate());
                streamingLinkView.setText(movie.getStreamingLink());
                Glide.with(context).asGif().load(R.drawable.playbutton).into(playButtonView);
            }
        }

}
