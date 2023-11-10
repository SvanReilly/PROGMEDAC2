package com.example.pokedex2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AdaptadorPokemon extends RecyclerView.Adapter<AdaptadorPokemon.PokemonViewHolder> {

    private Pokemon[] listaPokemons;

    public AdaptadorPokemon(Pokemon[] listaPokemons) {

        this.listaPokemons = listaPokemons;
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
        holder.BindPokemon(this.listaPokemons[position]);
    }

    @Override
    public int getItemCount() {
        return this.listaPokemons.length;
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreView;
        public ImageView imagenView;
        private Context context;

        public PokemonViewHolder(View view, Context context) {
            super(view);
            this.context = context;

            imagenView = view.findViewById(R.id.imagenView);
            nombreView = view.findViewById(R.id.nombreView);
        }

        public void BindPokemon(Pokemon pokemon) {
            nombreView.setText(pokemon.getNombre());
            imagenView.setImageResource(
                    context.getResources()
                            .getIdentifier(pokemon.getImagen(),
                                    "drawable",
                                    "com.example.pokedex2"));
        }
    }
}
