package com.example.practica5listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private Books[] booksList;

    public BookAdapter(Books[] booksList) {
        this.booksList = booksList;
    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_item, parent, false);

        return new BookViewHolder(view, parent.getContext());
    }
    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.BindBooks(this.booksList[position]);

    }
    @Override
    public int getItemCount() {
        return this.booksList.length;
    }
    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public TextView authorView;
        public ImageView frontCoverView;
        public TextView releaseDateView;
        public TextView ISBNCodeView;
        private Context context;
        public BookViewHolder(View view, Context context) {
            super(view);
            this.context = context;

            titleView = view.findViewById(R.id.bookTitle);
            authorView = view.findViewById(R.id.bookAuthor);
            frontCoverView = view.findViewById(R.id.bookFrontCover);
            releaseDateView = view.findViewById(R.id.bookPublicationDate);
            ISBNCodeView = view.findViewById(R.id.bookISBN);
        }
        public void BindBooks(Books book){
            titleView.setText(book.getTitle());
            authorView.setText(book.getAuthor());
            frontCoverView.setImageResource(
                    context.getResources().getIdentifier(book.getFrontCover(),
                            "drawable",
                            "com.example.practica5listas"));
            releaseDateView.setText(book.getReleaseDate());
            ISBNCodeView.setText(book.getISBNCode());
        }
    }
}