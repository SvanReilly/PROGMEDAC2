package com.example.practica7_2bbddpokedex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class PokedexBD extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BDPokemon.db";
    private static final int DATABASE_VERSION = 1;

    private Context context;
    private SQLiteDatabase databaseSQL = null;
    private String SQLCREATE = "CREATE TABLE Pokemon (Name TEXT, Picture STRING)";
    private String SQLDROP = "DROP TABLE IF EXISTS Pokemon";

    public PokedexBD(){
        super(null, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public PokedexBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    public void closeBD(){
        if (databaseSQL != null) {
            databaseSQL.close();
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
    public ArrayList<Pokemon> getPokemon() {
        databaseSQL = getReadableDatabase();

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        Cursor c = databaseSQL.query(
                "Pokemon",
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
                pokemonList.add(new Pokemon(c.getString(0), c.getString(1)));
            }while (c.moveToNext());
        }
        close();
        return pokemonList;
    }

    public void insertPokemon(String nombre, String URL) {
        databaseSQL = getWritableDatabase();
        if (databaseSQL != null) {
            ContentValues values= new ContentValues();
            values.put("Name", nombre);
            values.put("Picture", URL);
            databaseSQL.insert("Pokemon", "", values);
            close();
        }
    }
    public void removePokemon(String name){
        databaseSQL = getWritableDatabase();
        if (databaseSQL != null) {
            String where = "Name = ?";
            String [] deleteArguments = {name};
            databaseSQL.delete("Pokemon", where, deleteArguments);
            close();
        }
    }
}
