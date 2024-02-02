package com.svanreilly.moviestream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ImageButton imagePlayButtonViewMain1;
    private ImageButton imagePlayButtonViewMain2;
    private ImageButton imagePlayButtonViewMain3;
    private ImageButton imagePlayButtonViewMain4;
    private ImageButton imagePlayButtonViewMain5;
    private ImageButton imagePlayButtonViewMain6;
    Movie[] movie = new Movie[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        pokedexHeaderMain = findViewById(R.id.pokedexHeader);
//        Glide.with(this).asGif().load(R.drawable.pokedexnacionalspain).into(pokedexHeaderMain);

        recyclerView = findViewById(R.id.recView);

        movie[0] = new Movie(
                "The Hobbit: Un Viaje Inesperado","Peter Jackson, Guillermo del Toro",
                "silmarillioncover",
                "2012-11-28", "https://gamovideo.com/0z4kq2o3cvhi", imagePlayButtonViewMain1 );
        movie[1] = new Movie("The Hobbit: La Desolación de Smaug", "Peter Jackson",
                "desolationofsmaug",
                "2013-12-13", "https://gamovideo.com/4yb0mv239hyl", imagePlayButtonViewMain2);
        movie[2] = new Movie("The Hobbit: La Batalla de los Cinco Ejércitos", "Peter Jackson, Guillermo del Toro",
                "battleofthefivearmies",
                "2014-10-30", "https://gamovideo.com/jrqqzrzxaoc9",imagePlayButtonViewMain3 );


        movie[3] = new Movie("El Señor de los Anillos: La Comunidad del Anillo", "Peter Jackson",
                "fellowshipofthering",
                "2001-12-18", "https://gamovideo.com/8vivdsmwkf0r", imagePlayButtonViewMain4 );
        movie[4] = new Movie("El Señor de los Anillos: Las Dos Torres", "Peter Jackson",
                "twotowers",
                "2002-12-18", "https://gamovideo.com/2pl84tdwibii", imagePlayButtonViewMain5 );
        movie[5] = new Movie("El Señor de los Anillos: El Retorno del Rey", "Peter Jackson",
                "returnoftheking",
                "2003-11-30", "https://gamovideo.com/9yuqf8v7dx74",imagePlayButtonViewMain6 );


        MovieAdapter adapter = new MovieAdapter(movie);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

    }





    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        Intent browserIntent;


        if (position == 0) {
            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie[0].getStreamingLink()));
            startActivity(browserIntent);
        } else if (position == 1) {
            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie[1].getStreamingLink()));
            startActivity(browserIntent);
        } else if (position == 2) {
            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie[2].getStreamingLink()));
            startActivity(browserIntent);
        } else if (position == 3) {
            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie[3].getStreamingLink()));
            startActivity(browserIntent);
        } else if (position == 4) {
            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie[4].getStreamingLink()));
            startActivity(browserIntent);
        } else if (position == 5) {
            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie[5].getStreamingLink()));
            startActivity(browserIntent);
        }

    }
}



