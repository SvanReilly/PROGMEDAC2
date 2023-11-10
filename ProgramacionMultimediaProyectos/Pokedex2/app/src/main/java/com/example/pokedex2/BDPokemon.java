package com.example.pokedex2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDPokemon extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BDPokemon.db";
    private static final int DATABASE_VERSION = 1;

    private Context context;
    private SQLiteDatabase bd = null;
    private String SQLCREATE = "CREATE TABLE Pokemons (Nombre TEXT, Imagen STRING)";
    private String SQLDROP = "DROP TABLE IF EXISTS Pokemons";

    public BDPokemon(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    public void closeBD(){
        if (bd != null) {
            bd.close();
        }
    }
    //Crear y actualizar Base de datos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLCREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int preVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQLDROP);
        sqLiteDatabase.execSQL(SQLCREATE);
    }

    //Metodos para modificar la tabla (insertar, borrar, listar)
    public ArrayList<Pokemon> obtenerPokemons() {
        bd = getReadableDatabase();

        ArrayList<Pokemon> pokemons = new ArrayList<>();
        Cursor c = bd.query(
                "Pokemons",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
        );
        c.moveToFirst();
        if (c.getCount() > 0){
            do {
                pokemons.add(new Pokemon(c.getString(0), c.getString(1)));
            }while (c.moveToNext());
        }
        close();
        return pokemons;
    }

    public void insertarPokemon(String nombre, String URL) {
        bd = getWritableDatabase();
        if (bd != null) {
            ContentValues values= new ContentValues();
            values.put("Nombre", nombre);
            values.put("Imagen", URL);
            bd.insert("Pokemons", "", values);
            close();
        }
    }
    public void borrarPokemon(String nombre){
        bd = getWritableDatabase();
        if (bd != null) {
            String where = "Nombre = ?";
            String [] deleteArguments = {nombre};
            bd.delete("Pokemons", where, deleteArguments);
            close();
        }
    }
}
