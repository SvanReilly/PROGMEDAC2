package com.example.practica9_1_php;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ControladorMonumento monumentController = new ControladorMonumento(getApplicationContext());
    private VolleyCallBack callBack;
    private ImageView monumentHeaderMain, resultsViewMain;
    private ImageButton searchButtonMain;
    private TextView monumentNameMain, monumentDateMain, monumentDescriptionMain, monumentActualLocation,
            monumentLat, monumentLong ;
    private WebView monumentVideoMain;
    private Button monumentPriceButtonMain;
    private EditText editMonumentIDMain;
    private TableRow monumentTableRowMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Diseño del encabezado de monument searcher
        monumentHeaderMain = findViewById(R.id.monumentHeader);
        Glide.with(this).asGif().load(R.drawable.monumentsearcher).into(monumentHeaderMain);
        //EditText del ID
        editMonumentIDMain = findViewById(R.id.editMonumentID);

        // Diseño boton buscar monumento
        searchButtonMain = findViewById(R.id.searchImageButton);
        Glide.with(this).asGif().load(R.drawable.searchbutton).into(searchButtonMain);
        //Diseño del view de Resultados
        resultsViewMain = findViewById(R.id.resultsView);
        Glide.with(this).asGif().load(R.drawable.resultsview).into(resultsViewMain);


        monumentTableRowMain= findViewById(R.id.monumentTableRow);
        monumentNameMain=findViewById(R.id.monumentName);
        monumentDateMain=findViewById(R.id.monumentDate);
        monumentDescriptionMain=findViewById(R.id.monumentDescription);
        monumentActualLocation=findViewById(R.id.monumentActualLocation);
        monumentLat=findViewById(R.id.monumentLat);
        monumentLong=findViewById(R.id.monumentLong);
        monumentPriceButtonMain = findViewById(R.id.monumentPriceButton);
        monumentVideoMain=findViewById(R.id.monumentVideo);


        searchButtonMain.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String idTextBoxContent = String.valueOf(editMonumentIDMain.getText());

        if (v.getId() == R.id.searchImageButton) {
            try {
                monumentController.obtenerMonumentoID(idTextBoxContent, new VolleyCallBack() {
                    @Override
                    public void onSuccess(Context context, ArrayList<Monumento> monumentos) {
                        monumentos Monument = monumentos.get(0);

                    }
                });
            } catch (ServidorPHPException e) {
                throw new RuntimeException(e);
            }




        }
    }
}