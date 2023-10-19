package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String correo,pass;
    private Button buttonContinuar;
    private Switch recordarUsuario;
    private TextView hiddenText;
    private TextView correoIns;
    private TextView passIns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContinuar = findViewById(R.id.buttonContinuar);
        hiddenText = findViewById(R.id.resultText);
        buttonContinuar.setOnClickListener(this);
        correoIns=findViewById(R.id.cajaTextoCorreo);
        passIns=findViewById(R.id.cajaTextoPass);
        recordarUsuario=findViewById(R.id.switchRecordar);
    }

    @Override
    public void onClick(View view) {
        correo= correoIns.getText().toString();
        pass=passIns.getText().toString();
        if (correo.equals("correo@correo.com") && pass.equals("123") ){
            hiddenText.setVisibility(View.VISIBLE);
            hiddenText.setTextColor(getColor(R.color.green));
            hiddenText.setText("Usuario y contraseña correctos.");
        } else if (correo.equals("correo@correo.com") && pass.equals("123") && recordarUsuario.isChecked()){
            hiddenText.setVisibility(View.VISIBLE);
            hiddenText.setTextColor(getColor(R.color.green));
            hiddenText.setText("Usuario y contraseña correctos. " +
                    "\nSe almacenó la información para próximos accesos.");
        } else if (!correo.equals("correo@correo.com") && pass.equals("123")){
            hiddenText.setVisibility(View.VISIBLE);
            hiddenText.setTextColor(getColor(R.color.orange));
            hiddenText.setText("Usuario incorrecto.");
        } else if (correo.equals("correo@correo.com") && !pass.equals("123")) {
            hiddenText.setVisibility(View.VISIBLE);
            hiddenText.setTextColor(getColor(R.color.orange));
            hiddenText.setText("Contraseña incorrecta.");
        } else {
            hiddenText.setVisibility(View.VISIBLE);
            hiddenText.setTextColor(getColor(R.color.red));
            hiddenText.setText("Usuario y contraseña incorrectos.");
        }

    }
}