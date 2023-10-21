package com.example.practica5listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recView);

        Books[] book = new Books[4];
        book[0] = new Books(
                "The Silmarillion","Tolkien, J. R. R.",
                "silmarillioncover",
                "2022-11-08", "0063280779" );
        book[1] = new Books("The Hobbit", "Tolkien, J. R. R.",
                "hobbitcover",
                "2012-09-18", "0547928246" );
        book[2] = new Books("The Lord of the Rings", "Tolkien, J. R. R.",
                "lotrcover",
                "2021-11-16", "0358653037" );
        book[3] = new Books("1984", "George Orwell",
                "cover1984",
                "1961-01-01", "0451524934" );

        BookAdapter adapter = new BookAdapter(book);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

    }
}