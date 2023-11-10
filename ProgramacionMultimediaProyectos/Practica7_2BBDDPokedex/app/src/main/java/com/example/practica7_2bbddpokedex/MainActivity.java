package com.example.practica7_2bbddpokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMain;
    private EditText editPokeNameMain, editPokeURLPicMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = findViewById(R.id.recView);
        editPokeNameMain = findViewById(R.id.editPokeName);
        editPokeURLPicMain = findViewById(R.id.editPokeURLPic);

        PokedexBD pokedex = new PokedexBD();

        pokedex.getPokemon();
    }
}