package com.example.tema7_act_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText urlEditText;

    private RecyclerView recyclerView;
    private manejoBD control;
    private ArrayList<Books> booksList;
    private Adapter adapter;
    private EditText nombreEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recView);
        urlEditText = findViewById(R.id.urlEditText);
        nombreEditText = findViewById(R.id.nombreEditText);
        Button buttonInsertar = findViewById(R.id.buttonInsertar);
        Button buttonBorrar = findViewById(R.id.buttonBorrar);

        control = new manejoBD(this);

        booksList = new ArrayList<>();

        adapter = new Adapter(booksList);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarLibro();
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarLibros();
            }
        });
    }

    private void agregarLibro() {
        String nombre = nombreEditText.getText().toString();
        String url = urlEditText.getText().toString();

        if (!nombre.isEmpty() && !url.isEmpty()) {
            Books nuevoLibro = new Books(nombre, "Autor por defecto", url);
            control.insertarLibro(nuevoLibro.getTitle(), nuevoLibro.getImageUrl());

            booksList = control.obtenerLibros();
            adapter.setListaLibros(booksList);
            adapter.notifyDataSetChanged();
            nombreEditText.setText("");
            urlEditText.setText("");
        }
    }

    private void eliminarLibros() {
        control.eliminarTodosLosLibros();
        booksList.clear();
        adapter.setListaLibros(booksList);
        adapter.notifyDataSetChanged();
    }
}