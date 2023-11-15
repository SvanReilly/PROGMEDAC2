package com.example.practica_7_2pokedexbbdd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMain;
    private EditText editPokeNameMain, editPokeURLPicMain;
    private PokedexBD pokedexBD;
    private Button insertButtonMain, removeButtonMain;
    private ArrayList<Pokemon> listaPokemonMain;
    private PokemonAdapter pokeAdapter;
    private String PokeNameMain,PokeURLPicMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = findViewById(R.id.recView);
        editPokeNameMain = findViewById(R.id.editPokeName);
        editPokeURLPicMain = findViewById(R.id.editPokeURLPic);

        insertButtonMain = findViewById(R.id.insertButton);
        removeButtonMain = findViewById(R.id.removeButton);



        pokedexBD = new PokedexBD(getApplicationContext());

        listaPokemonMain = new ArrayList<>();

        //Pokemon Arceus = new Pokemon("Arceus", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/493.png");
        //listaPokemonMain.add(Arceus);

        pokeAdapter = new PokemonAdapter(listaPokemonMain);

        recyclerViewMain.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewMain.setLayoutManager(linearLayoutManager);

        recyclerViewMain.setAdapter(pokeAdapter);


        insertButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {addPokemon();}
        });
        removeButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {removePokemonList();}
        });
    }


    private void addPokemon() {

        PokeNameMain = String.valueOf(editPokeNameMain.getText());
        PokeURLPicMain = String.valueOf(editPokeURLPicMain.getText());

        if (!PokeNameMain.isEmpty() && !PokeURLPicMain.isEmpty()) {
            Pokemon newPokemon = new Pokemon(PokeNameMain, PokeURLPicMain );
            pokedexBD.insertPokemon(newPokemon.getName(), newPokemon.getPicture());

            listaPokemonMain = pokedexBD.getPokemon();
            pokeAdapter.setListaPokemon(listaPokemonMain);
            pokeAdapter.notifyDataSetChanged();
            editPokeNameMain.setText("");
            editPokeURLPicMain.setText("");
        }
    }

    private void removePokemonList() {
        pokedexBD.dropPokedex();
        listaPokemonMain.clear();
        pokeAdapter.setListaPokemon(listaPokemonMain);
        pokeAdapter.notifyDataSetChanged();
    }

}
