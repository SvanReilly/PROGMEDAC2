package com.example.practica6settingsactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView userNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameTextView = findViewById(R.id.userTextView);
        Button buttonSettings = findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(this);
        };
    @Override
    protected void onResume() {
        super.onResume();

        // Obtén el valor del switch de preferencias
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean showUser = prefs.getBoolean("show_user", false);
        if (showUser == true) {
            userNameTextView.setVisibility(View.VISIBLE);
            userNameTextView.setText("Usuario: " + prefs.getString("Usuario", ""));
        } else {
            userNameTextView.setVisibility(View.GONE);
        }
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
}
