package com.example.practica_7_2pokedexbbdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerViewMain;
    private EditText editPokeNameMain, editPokeURLPicMain;
    private String PokeNameMain,PokeURLPicMain;
    private PokedexBD pokedex;
    private Button insertButtonMain, removeButtonMain;
    private Pokemon[] listaPokemonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = findViewById(R.id.recView);
        editPokeNameMain = findViewById(R.id.editPokeName);
        editPokeURLPicMain = findViewById(R.id.editPokeURLPic);
        PokeNameMain = String.valueOf(editPokeNameMain.getText());
        PokeURLPicMain = String.valueOf(editPokeURLPicMain.getText());
        insertButtonMain = findViewById(R.id.insertButton);
        removeButtonMain = findViewById(R.id.removeButton);

        insertButtonMain.setOnClickListener(this);
        removeButtonMain.setOnClickListener(this);
        pokedex = new PokedexBD(getApplicationContext());

       PokemonAdapter pokeAdapter = new PokemonAdapter(listaPokemonMain);




    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.insertButton){
            pokedex.insertPokemon(PokeNameMain, PokeURLPicMain);
        } else if (v.getId()==R.id.removeButton) {
            pokedex.removePokemon(PokeNameMain);
        }

    }


}