package com.ssreilly.moviestreamnav;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ssreilly.moviestreamnav.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieAdapter.imageButtonClickListener {
    private RecyclerView recyclerView;
    ArrayList<Movie> movies = new ArrayList<>();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

//   From here to below is the added code from the previous MovieStream project




//        pokedexHeaderMain = findViewById(R.id.pokedexHeader);
//        Glide.with(this).asGif().load(R.drawable.pokedexnacionalspain).into(pokedexHeaderMain);

//        ImageView movieStreamTextViewMain = findViewById(R.id.movieStreamImageView);
//        Glide.with(this).asGif().load(R.drawable.moviestream).into(movieStreamTextViewMain);
//
//
//        recyclerView = findViewById(R.id.recView);
//
//        movies.add(new Movie(
//                "The Hobbit: Un Viaje Inesperado","Peter Jackson, Guillermo del Toro",
//                "anunexpectedjourney",
//                "2012-11-28", "https://gamovideo.com/0z4kq2o3cvhi"));
//
//
//        movies.add(new Movie("The Hobbit: La Desolación de Smaug", "Peter Jackson",
//                "desolationofsmaug",
//                "2013-12-13", "https://gamovideo.com/4yb0mv239hyl"));
//
//        movies.add(new Movie("The Hobbit: La Batalla de los Cinco Ejércitos", "Peter Jackson, Guillermo del Toro",
//                "battleofthefivearmies",
//                "2014-10-30", "https://gamovideo.com/jrqqzrzxaoc9"));
//
//
//
//        movies.add(new Movie("El Señor de los Anillos: La Comunidad del Anillo", "Peter Jackson",
//                "fellowshipofthering",
//                "2001-12-18", "https://gamovideo.com/8vivdsmwkf0r"));
//
//        movies.add(new Movie("El Señor de los Anillos: Las Dos Torres", "Peter Jackson",
//                "twotowers",
//                "2002-12-18", "https://gamovideo.com/2pl84tdwibii"));
//
//        movies.add(new Movie("El Señor de los Anillos: El Retorno del Rey", "Peter Jackson",
//                "returnoftheking",
//                "2003-11-30", "https://gamovideo.com/9yuqf8v7dx74"));
//
//
//        MovieAdapter adapter = new MovieAdapter(this, movies, this);
//
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,
//                LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onImageButtonClick(int position) {

    }


//    @Override
//    public void onImageButtonClick(int position) {
//        Toast.makeText(MainActivity.this, "Button clicked: " + (1+position), Toast.LENGTH_SHORT).show();
//
//        Intent browserIntent;
//
//
//        if (position == 0) {
//            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movies.get(0).getStreamingLink()));
//            startActivity(browserIntent);
//        } else if (position == 1) {
//            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movies.get(1).getStreamingLink()));
//            startActivity(browserIntent);
//        } else if (position == 2) {
//            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movies.get(2).getStreamingLink()));
//            startActivity(browserIntent);
//        } else if (position == 3) {
//            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movies.get(3).getStreamingLink()));
//            startActivity(browserIntent);
//        } else if (position == 4) {
//            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movies.get(4).getStreamingLink()));
//            startActivity(browserIntent);
//        } else if (position == 5) {
//            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(movies.get(5).getStreamingLink()));
//            startActivity(browserIntent);
//        }
//
//    }

}