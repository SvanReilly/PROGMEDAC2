package com.example.practica_7_2pokedexbbdd;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerViewMain;
    private EditText editPokeNameMain, editPokeURLPicMain;
    private PokedexBD pokedexBD;
    private ImageButton InsertImageButtonMain, RemoveImageButtonMain, DropImageButtonMain;
    private ImageView pokedexHeaderMain, pokemonListedViewMain, insertImageText, removeImageText, dropImageText;
    private ArrayList<Pokemon> listaPokemonMain;
    private PokemonAdapter pokeAdapter;
    private String PokeNameMain, PokeURLPicMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // String headerGIFURL = System.getProperty("user-dir") + "\\ProgramacionMultimediaProyectos\\Practica_7_2PokedexBBDD\\app\\build\\src\\main\\res\\drawable\\pokedexnacional";

        pokedexHeaderMain = findViewById(R.id.pokedexHeader);
        Glide.with(this).asGif().load(R.drawable.pokedexnacionalspain).into(pokedexHeaderMain);


        pokemonListedViewMain = findViewById(R.id.pokemonListedView);
        Glide.with(this).asGif().load(R.drawable.registrados).into(pokemonListedViewMain);

        recyclerViewMain = findViewById(R.id.recView);

        editPokeNameMain = findViewById(R.id.editPokeName);
        editPokeURLPicMain = findViewById(R.id.editPokeURLPic);
        // Insertar diseño
        InsertImageButtonMain = findViewById(R.id.insertImageButton);
        insertImageText = findViewById(R.id.insertText);
        Glide.with(this).asGif().load(R.drawable.insertarascendent).into(insertImageText);
        // Soltar un solo pokemon diseño
        RemoveImageButtonMain = findViewById(R.id.removeImageButton);
        removeImageText = findViewById(R.id.removeText);
        Glide.with(this).asGif().load(R.drawable.soltar).into(removeImageText);
        // Liberar todos los pokemons diseño
        DropImageButtonMain = findViewById(R.id.dropImageButton);
        dropImageText = findViewById(R.id.dropText);
        Glide.with(this).asGif().load(R.drawable.liberartodos).into(dropImageText);



        pokedexBD = new PokedexBD(getApplicationContext());
        /*
        Aqui algunos ejemplos de Pokemon con sus imagenes para probar las funciones de insertar y soltar.

        Mew https://assets.pokemon.com/assets/cms2/img/pokedex/full/151.png
        Arceus https://assets.pokemon.com/assets/cms2/img/pokedex/full/493.png
        Suicune https://assets.pokemon.com/assets/cms2/img/pokedex/full/245.png
        Mega-Gyarados https://assets.pokemon.com/assets/cms2/img/pokedex/full/130_f2.png

        */

        //Actualizar la lista de registrados que se mostrará incluso si la aplicacion es cerrada
        listaPokemonMain = pokedexBD.getPokemon();

        if (listaPokemonMain.size()!=0){
            pokemonListedViewMain.setVisibility(View.VISIBLE);
        } else{
            pokemonListedViewMain.setVisibility(View.GONE);
        }
        pokeAdapter = new PokemonAdapter(listaPokemonMain);

        recyclerViewMain.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewMain.setLayoutManager(linearLayoutManager);

        recyclerViewMain.setAdapter(pokeAdapter);

        InsertImageButtonMain.setOnClickListener(this);
        RemoveImageButtonMain.setOnClickListener(this);
        DropImageButtonMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.insertImageButton) {

            PokeNameMain = String.valueOf(editPokeNameMain.getText());
            PokeURLPicMain = String.valueOf(editPokeURLPicMain.getText());

            if (!PokeNameMain.isEmpty() && !PokeURLPicMain.isEmpty()) {
                Pokemon newPokemon = new Pokemon(PokeNameMain, PokeURLPicMain);
                pokedexBD.insertPokemon(newPokemon.getName(), newPokemon.getPicture());

                listaPokemonMain = pokedexBD.getPokemon();
                pokeAdapter.setListaPokemon(listaPokemonMain);
                pokeAdapter.notifyDataSetChanged();
                editPokeNameMain.setText("");
                editPokeURLPicMain.setText("");

                pokemonListedViewMain.setVisibility(View.VISIBLE);

            }
        } else if (v.getId() == R.id.removeImageButton) {

            PokeNameMain = String.valueOf(editPokeNameMain.getText());

            pokedexBD.removeOnlyOnePokemon(PokeNameMain);
            listaPokemonMain = pokedexBD.getPokemon();
            pokeAdapter.setListaPokemon(listaPokemonMain);
            pokeAdapter.notifyDataSetChanged();
            editPokeNameMain.setText("");
            editPokeURLPicMain.setText("");
            if (listaPokemonMain.size()==0){
                pokemonListedViewMain.setVisibility(View.GONE);
            }

        } else if (v.getId() == R.id.dropImageButton) {
                pokedexBD.dropPokedex();
                listaPokemonMain.clear();
                pokeAdapter.setListaPokemon(listaPokemonMain);
                pokeAdapter.notifyDataSetChanged();

                pokemonListedViewMain.setVisibility(View.GONE);
        }
    }
}