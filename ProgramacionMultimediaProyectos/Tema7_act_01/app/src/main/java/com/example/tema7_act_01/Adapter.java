package com.example.tema7_act_01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.LibrosViewHolder> {
    private ArrayList<Books> listaLibros;
    public Adapter(ArrayList<Books> listaLibros){
        this.listaLibros = listaLibros;
    }
    public void setListaLibros(ArrayList<Books> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @NonNull
    @Override
    public LibrosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.books_item, parent, false);
        return new LibrosViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull LibrosViewHolder holder, int position) {
        holder.bLindLibros(this.listaLibros.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listaLibros.size();
    }

    public static class LibrosViewHolder extends RecyclerView.ViewHolder{
        public TextView tituloView, autorView;
        public ImageView portadaView;
        private Context context;

        public LibrosViewHolder(View view, Context context) {
            super(view);
            this.context = context;

            tituloView = view.findViewById(R.id.title);
            autorView = view.findViewById(R.id.autor);
            portadaView = view.findViewById(R.id.imageView);
        }

        public void bLindLibros(Books libro){
            tituloView.setText(libro.getTitle());
            autorView.setText(libro.getAuthor());
            Picasso.get().load(libro.getImageUrl()).into(portadaView);
        }
    }
}