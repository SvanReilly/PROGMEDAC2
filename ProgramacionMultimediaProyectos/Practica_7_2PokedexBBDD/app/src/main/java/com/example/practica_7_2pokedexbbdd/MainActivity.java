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

        listaPokemonMain = new ArrayList<>();

        //Pokemon Arceus = new Pokemon("Arceus", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/493.png");
        //listaPokemonMain.add(Arceus);

        pokeAdapter = new PokemonAdapter(listaPokemonMain);

        recyclerViewMain.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerViewMain.setLayoutManager(linearLayoutManager);

        recyclerViewMain.setAdapter(pokeAdapter);

        InsertImageButtonMain.setOnClickListener(this);
        RemoveImageButtonMain.setOnClickListener(this);


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
                if (pokemonListedViewMain.getVisibility() != View.VISIBLE)
                pokemonListedViewMain.setVisibility(View.VISIBLE);

            }
        } else if (v.getId() == R.id.removeImageButton) {
            PokeNameMain = String.valueOf(editPokeNameMain.getText());
            pokedexBD.removeOnlyOnePokemon(PokeNameMain);



        } else if (v.getId() == R.id.dropImageButton) {
                pokedexBD.dropPokedex();
                listaPokemonMain.clear();
                pokeAdapter.setListaPokemon(listaPokemonMain);
                pokeAdapter.notifyDataSetChanged();
        }

    }
}



    /*
 InsertImageButtonMain.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {addPokemon();}
 });
 RemoveImageButtonMain.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {removePokemonList();}
 });
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
*/