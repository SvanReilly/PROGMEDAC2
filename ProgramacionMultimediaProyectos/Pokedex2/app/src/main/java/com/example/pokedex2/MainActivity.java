package com.example.pokedex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText editNombre, editURLImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recView);
        editNombre = findViewById(R.id.editNombre);
        editURLImagen = findViewById(R.id.editURLImagen);

        BDPokemon bdPokemon = new BDPokemon();

        bdPokemon.obtenerPokemons();
    }
}