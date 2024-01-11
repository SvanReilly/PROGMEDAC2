package com.example.practica9_1_php;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Marker.OnMarkerClickListener {

    private ControladorMonumento monumentController = new ControladorMonumento(this);
    private ImageView monumentHeaderMain, resultsViewMain, monumentPictureMain;
    private ImageButton searchButtonMain;
    private TextView monumentNameMain, monumentDateMain, monumentDescriptionMain, monumentActualLocation,
            monumentLat, monumentLong;
    private WebView monumentVideoMain;
    private Button monumentPriceButtonMain;
    private EditText editMonumentIDMain;
    private TableRow monumentTableRowMain;
    String fechaConstruccionText, comprarEntradaText, latitudText, longitudText, id;
    private MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configuration.getInstance().setUserAgentValue("appIdMapPractice");


        //Diseño del encabezado de monument searcher
        monumentHeaderMain = findViewById(R.id.monumentHeader);
        Glide.with(this).asGif().load(R.drawable.monumentsearcher).into(monumentHeaderMain);
        //EditText del ID

        //Diseño del view de Resultados
        resultsViewMain = findViewById(R.id.resultsView);
        Glide.with(this).asGif().load(R.drawable.resultsview).into(resultsViewMain);


        mapView = findViewById(R.id.openStreetMap);
        MapController mapController = (MapController) mapView.getController();
        mapController.setCenter(new GeoPoint(37.1881700, -3.6066700));
        mapController.setZoom(14);

        monumentTableRowMain= findViewById(R.id.monumentTableRow);
        monumentNameMain=findViewById(R.id.monumentName);
        monumentDateMain=findViewById(R.id.monumentDate);
        monumentPictureMain = findViewById(R.id.monumentImageView);
        monumentDescriptionMain=findViewById(R.id.monumentDescription);
        monumentActualLocation=findViewById(R.id.monumentActualLocation);
        monumentLat=findViewById(R.id.monumentLat);
        monumentLong=findViewById(R.id.monumentLong);
        monumentPriceButtonMain = findViewById(R.id.monumentPriceButton);
        monumentVideoMain=findViewById(R.id.monumentVideo);


        fechaConstruccionText = String.valueOf(monumentDateMain.getText());
        comprarEntradaText = String.valueOf(monumentPriceButtonMain.getText());
        latitudText = String.valueOf(monumentLat.getText());
        longitudText = String.valueOf(monumentLong.getText());


        try {
            monumentController.obtenerTodosMonumentos(new VolleyCallBack() {
                @Override
                public void onSuccess(Context context, ArrayList<Monumento> monumentos) {
                    Monumento monumento = monumentos.get(0);
                    for (int i= 0; i< monumentos.size(); i++) {
                        marcador(monumentos.get(i));
                    }
                }
            });
        } catch (ServidorPHPException e) {
            throw new RuntimeException(e);
        }


    }


    private void marcador(Monumento monumento) {
        GeoPoint geoPoint = new GeoPoint(parseFloat(monumento.getLatitud()), parseFloat (monumento.getLongitud()));
        Marker marker = new Marker(mapView);
        marker.setPosition(geoPoint);
        mapView.getOverlays().add(marker);
        marker.setId(monumento.getId());
        marker.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker, MapView mapView) {

        id = marker.getId();

        try {
            monumentController.obtenerMonumentoID(id, new VolleyCallBack() {
                @Override
                public void onSuccess(Context context, ArrayList<Monumento> monumentos) {
                    Monumento monument = monumentos.get(0);

                    // Establecer los valores en el layout
                    monumentNameMain.setText(monument.getNombre());
                    monumentDateMain.setText(fechaConstruccionText + " " + monument.getFecha());
                    Glide.with(getApplicationContext()).load(monument.getImagen()).into(monumentPictureMain);
                    monumentDescriptionMain.setText(monument.getDescripcion());
                    monumentActualLocation.setText(monument.getCiudad());
                    monumentLat.setText(latitudText + " " + monument.getLatitud());
                    monumentLong.setText(longitudText + " " + monument.getLongitud());
                    monumentPriceButtonMain.setText(comprarEntradaText + " " + monument.getPrecio() + monument.getMoneda());


                    // Para mostrar una previsualizacion de video:
                    String html = monument.getVideo();
                    WebSettings settings = monumentVideoMain.getSettings();
                    settings.setJavaScriptEnabled(true);
                    monumentVideoMain.loadData(html, "text/html", "UTF-8");

                    // Si hay datos que mostrar se harán visibles los siguientes elementos:
                    resultsViewMain.setVisibility(View.VISIBLE);
                    monumentTableRowMain.setVisibility(View.VISIBLE);
                }
            });
        } catch (ServidorPHPException e) {

        }
        return false;
    }
}