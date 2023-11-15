package com.example.tema7_act_01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class manejoBD extends SQLiteOpenHelper {
    private ArrayList<Books> booksList;
    private static final String DATABASE_NAME = "Libros.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Libros";
    private static final String COLUMN_AUTOR = "Autor";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NOMBRE = "Nombre";
    private static final String COLUMN_URL = "URL";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NOMBRE +
            " TEXT," + COLUMN_URL + " TEXT);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public manejoBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        booksList = new ArrayList<>();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    //Insertar libro
    public void insertarLibro(String nombre, String url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NOMBRE, nombre);
        contentValues.put(COLUMN_URL, url);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }


    //Obtener libro
    public ArrayList<Books> obtenerLibros() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ID, COLUMN_NOMBRE, COLUMN_URL};
        Cursor cursor = db.query(TABLE_NAME, projection, null, null,
                null, null, null);

        ArrayList<Books> booksList = new ArrayList<>();

        if (cursor != null) {
            try {
                int nombreIndex = cursor.getColumnIndex(COLUMN_NOMBRE);
                int urlIndex = cursor.getColumnIndex(COLUMN_URL);

                while (cursor.moveToNext()) {
                    String nombre = (nombreIndex != -1) ? cursor.getString(nombreIndex) :
                            "Nombre no disponible";
                    String url = (urlIndex != -1) ? cursor.getString(urlIndex) :
                            "URL no disponible";

                    Books book = new Books(nombre, "Autor por defecto", url);
                    booksList.add(book);
                }
            } finally {
                cursor.close();
            }
        }

        db.close();

        return booksList;
    }

    // Eliminar libro
    public void eliminarTodosLosLibros() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    //Cerrar conexión
    public void cerrarConexion() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }
}
