package com.example.practica_7_2pokedexbbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class PokedexBD extends SQLiteOpenHelper {

    private ArrayList<Pokemon> listaPokemon;
    private static final String DATABASE_NAME = "BDPokemon.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Pokemon";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_URL = "Picture";
    private SQLiteDatabase databaseSQL;
    private static final String SQLCREATE = "CREATE TABLE "
            + TABLE_NAME
            + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " NAME,"
            + COLUMN_URL + " URL);";
    private String SQLDROP = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public PokedexBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        listaPokemon = new ArrayList<>();
    }

    @Override
    public void onCreate(SQLiteDatabase databaseSQL) {
        databaseSQL.execSQL(SQLCREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase databaseSQL, int previousVersion, int newestVersion) {
        databaseSQL.execSQL(SQLDROP);
        onCreate(databaseSQL);
    }


    public ArrayList<Pokemon> getPokemon() {
        databaseSQL = this.getReadableDatabase();
        String [] SQL_COLUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_URL};
        Cursor c = databaseSQL.query(TABLE_NAME, SQL_COLUMNS, null, null,
                null,null,null);

        ArrayList<Pokemon> listaPokemon = new ArrayList<>();

        if (c!= null){
            try {
                int nameIndex = c.getColumnIndex(COLUMN_NAME);
                int pictureURLIndex = c.getColumnIndex(COLUMN_URL);

                while (c.moveToNext()) {
                    String name = (nameIndex != -1) ? c.getString(nameIndex) :
                            "Pokemon no identificado";
                    String pictureURL = (pictureURLIndex != -1) ? c.getString(pictureURLIndex) :
                            "Imagen no disponible";

                    Pokemon pokemon = new Pokemon(name, pictureURL);
                    listaPokemon.add(pokemon);
                }
            } finally {
                c.close();
            }
        }


        closeBD();
        return listaPokemon;
    }

    public void insertPokemon(String name, String URL) {

        databaseSQL = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_URL, URL);
        databaseSQL.insert(TABLE_NAME, null, contentValues);
        closeBD();

    }
    //Pendiente//
    public void removeOnlyOnePokemon(String Name){
        databaseSQL = this.getWritableDatabase();
        databaseSQL = this.getWritableDatabase();
        String selection = COLUMN_NAME + "=?";
        String[] selectionArgs = {Name};
        databaseSQL.delete(TABLE_NAME, selection, selectionArgs);
            closeBD();

    }

    public void dropPokedex(){
        databaseSQL = this.getWritableDatabase();
        databaseSQL.delete(TABLE_NAME, null, null);
        closeBD();
    }

    public void closeBD(){
        if (databaseSQL != null) {
            databaseSQL.close();
        }
    }
}
