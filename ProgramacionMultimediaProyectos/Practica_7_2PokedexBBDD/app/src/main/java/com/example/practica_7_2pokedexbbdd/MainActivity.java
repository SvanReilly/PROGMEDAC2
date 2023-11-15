package com.example.practica_7_2pokedexbbdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMain;
    private EditText editPokeNameMain, editPokeURLPicMain;
    private String PokeNameMain,PokeURLPicMain;
    private PokedexBD pokedex;
    private Button insertButtonMain, removeButtonMain;
    private ArrayList<Pokemon> listaPokemonMain;
    private PokemonAdapter pokeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = findViewById(R.id.recView);
        editPokeNameMain = findViewById(R.id.editPokeName);
        editPokeURLPicMain = findViewById(R.id.editPokeURLPic);

        insertButtonMain = findViewById(R.id.insertButton);
        removeButtonMain = findViewById(R.id.removeButton);



        pokedex = new PokedexBD(getApplicationContext());
        listaPokemonMain = new ArrayList<>();
        pokeAdapter = new PokemonAdapter(listaPokemonMain);

        recyclerViewMain.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewMain.setLayoutManager(linearLayoutManager);

        recyclerViewMain.setAdapter(pokeAdapter);


        insertButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PokeNameMain = String.valueOf(editPokeNameMain.getText());
                PokeURLPicMain = String.valueOf(editPokeURLPicMain.getText());

                if (!PokeNameMain.isEmpty() && !PokeURLPicMain.isEmpty()) {
                    Pokemon newPokemon = new Pokemon(PokeNameMain, PokeURLPicMain );
                    pokedex.insertPokemon(newPokemon.getName(), newPokemon.getPicture());

                    listaPokemonMain = pokedex.getPokemon();
                    pokeAdapter.setListaPokemon(listaPokemonMain);
                    pokeAdapter.notifyDataSetChanged();
                    editPokeNameMain.setText("");
                    editPokeURLPicMain.setText("");
                }
            }
        });
        removeButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pokedex.dropPokedex();
                listaPokemonMain.clear();
                pokeAdapter.setListaPokemon(listaPokemonMain);
                pokeAdapter.notifyDataSetChanged();
            }
        });
    }
}


    /*
    private void addPokemon() {

        PokeNameMain = String.valueOf(editPokeNameMain.getText());
        PokeURLPicMain = String.valueOf(editPokeURLPicMain.getText());

        if (!PokeNameMain.isEmpty() && !PokeURLPicMain.isEmpty()) {
            Pokemon newPokemon = new Pokemon(PokeNameMain, PokeURLPicMain );
            pokedex.insertPokemon(newPokemon.getName(), newPokemon.getPicture());

            listaPokemonMain = pokedex.getPokemon();
            pokeAdapter.setListaPokemon(listaPokemonMain);
            pokeAdapter.notifyDataSetChanged();
            editPokeNameMain.setText("");
            editPokeURLPicMain.setText("");
        }
    }

    private void removePokemon() {
        pokedex.dropPokedex();
        listaPokemonMain.clear();
        pokeAdapter.setListaPokemon(listaPokemonMain);
        pokeAdapter.notifyDataSetChanged();
    }

}*/