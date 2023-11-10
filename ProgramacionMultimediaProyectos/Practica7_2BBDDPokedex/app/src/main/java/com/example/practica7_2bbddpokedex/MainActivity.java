package com.example.practica7_2bbddpokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerViewMain;
    private EditText editPokeNameMain, editPokeURLPicMain;
    private String PokeNameMain,PokeURLPicMain;
    private PokedexBD pokedex;
    private Button insertButtonMain, removeButtonMain;

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
        pokedex = new PokedexBD();

        pokedex.getPokemon();

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