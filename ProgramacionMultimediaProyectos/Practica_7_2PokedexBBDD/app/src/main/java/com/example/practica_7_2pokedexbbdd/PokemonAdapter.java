package com.example.practica_7_2pokedexbbdd;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private Pokemon[] listaPokemon;

    public PokemonAdapter(Pokemon[] listaPokemon) {

        this.listaPokemon = listaPokemon;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_item, parent, false);

        return new PokemonViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.BindPokemon(this.listaPokemon[position]);
    }

    @Override
    public int getItemCount() {
        return this.listaPokemon.length;
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreView;
        public ImageView imagenView;
        private Context context;

        public PokemonViewHolder(View view, Context context) {
            super(view);
            this.context = context;

            imagenView = view.findViewById(R.id.pokePicView);
            nombreView = view.findViewById(R.id.pokeNameView);
        }

        public void BindPokemon(Pokemon pokemon) {
            nombreView.setText(pokemon.getName());
            Picasso.get().load(pokemon.sprites.front_default).into(imagenView);
        }
    }
}
