package com.example.openstreetmapspractice;
import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Switch;

import android.widget.TableRow;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Marker.OnMarkerClickListener {

    ControladorMonumento monumentController = new ControladorMonumento(this);
    private ImageView monumentPictureMain;
    private TextView monumentNameMain, monumentDateMain, monumentDescriptionMain, monumentActualLocation,
            monumentLat, monumentLong;
    private WebView monumentVideoMain;
    private Button monumentPriceButtonMain;
    private Switch showHideMapSwitchMain;
    private MapView openStreetMapMain;
    //private ScrollView scrollViewMain;
    private TableRow monumentTableRowMain;
    private String fechaConstruccionText, comprarEntradaText, latitudText, longitudText, markerID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Diseño del encabezado de monument searcher
        ImageView monumentHeaderMain = findViewById(R.id.monumentHeader);
        Glide.with(this).asGif().load(R.drawable.monumentsearcher).into(monumentHeaderMain);
        //Diseño del view de Resultados
        ImageView resultsViewMain = findViewById(R.id.resultsView);
        Glide.with(this).asGif().load(R.drawable.resultsview).into(resultsViewMain);

        Configuration.getInstance().setUserAgentValue("appIdMapPractice");

        //scrollViewMain= findViewById(R.id.scrollView);
        monumentTableRowMain = findViewById(R.id.monumentTableRow);
        monumentNameMain=findViewById(R.id.monumentName);
        monumentDateMain=findViewById(R.id.monumentDate);
        monumentPictureMain = findViewById(R.id.monumentImageView);
        monumentDescriptionMain=findViewById(R.id.monumentDescription);
        monumentActualLocation=findViewById(R.id.monumentActualLocation);
        monumentLat=findViewById(R.id.monumentLat);
        monumentLong=findViewById(R.id.monumentLong);
        monumentPriceButtonMain = findViewById(R.id.monumentPriceButton);
        monumentVideoMain=findViewById(R.id.monumentVideo);


        //Switch para mostrar ocultar mapa
        showHideMapSwitchMain=findViewById(R.id.showHideMapSwitch);
        showHideMapSwitchMain.setOnClickListener(v -> {
            if (showHideMapSwitchMain.isChecked()){
                showHideMapSwitchMain.setText(getString(R.string.ocultarMapa));
                openStreetMapMain.setVisibility(View.VISIBLE);
            } else if (!showHideMapSwitchMain.isChecked()) {
                showHideMapSwitchMain.setText(getString(R.string.mostrarMapa));
                openStreetMapMain.setVisibility(View.GONE);
            }
        });
        //Mapa
        openStreetMapMain = findViewById(R.id.openStreetMap);
        MapController mapController = (MapController) openStreetMapMain.getController();
        GeoPoint granada18011Point = new GeoPoint(37.1751700, -3.5947800);
        mapController.setCenter(granada18011Point);
        mapController.setZoom(15);

        try {
            monumentController.obtenerTodosMonumentos(new VolleyCallBack() {
                @Override
                public void onSuccess(Context context, ArrayList<Monumento> monuments) {
                    Monumento monument = monuments.get(0);
                    for (int i= 0; i< monuments.size(); i++) {
                        monumentMarker(monuments.get(i));
                    }
                }
            });
        } catch (ServidorPHPException e) {
            throw new RuntimeException(e);
        }
    }

    //Creando Marcadores
    public void monumentMarker(Monumento monument){
        GeoPoint monumentGeoPoint = new GeoPoint(parseFloat(monument.getLatitud()), parseFloat(monument.getLongitud()));
        Marker monumentMarker = new Marker(openStreetMapMain);
        monumentMarker.setPosition(monumentGeoPoint);
        openStreetMapMain.getOverlays().add(monumentMarker);
        monumentMarker.setId(monument.getId());
        monumentMarker.setOnMarkerClickListener(this);
    }


    @Override
    public boolean onMarkerClick(Marker marker, MapView mapView) {
        markerID = marker.getId();
        fechaConstruccionText = getResources().getString(R.string.date);
        comprarEntradaText = getResources().getString(R.string.button);
        latitudText = getResources().getString(R.string.latitud);
        longitudText = getResources().getString(R.string.longitud);

        try{
            monumentController.obtenerMonumentoID(markerID, new VolleyCallBack() {
                @Override
                public void onSuccess(Context context, ArrayList<Monumento> monuments) {
                    Monumento monument = monuments.get(0);

                    monumentNameMain.setText(monument.getNombre());
                    monumentDateMain.setText(fechaConstruccionText + " " + monument.getFecha());
                    Glide.with(monumentPictureMain).load(monument.getImagen()).into(monumentPictureMain);
                    monumentDescriptionMain.setText(monument.getDescripcion());
                    monumentActualLocation.setText(monument.getCiudad());
                    monumentLat.setText(latitudText + " " + monument.getLatitud());
                    monumentLong.setText(longitudText + " " + monument.getLongitud());
                    monumentPriceButtonMain.setText(comprarEntradaText + " " + monument.getPrecio() + monument.getMoneda());

                    String html = monument.getVideo();
                    WebSettings settings = monumentVideoMain.getSettings();
                    settings.setJavaScriptEnabled(true);
                    monumentVideoMain.loadData(html, "text/html", "UTF-8");

                    //scrollViewMain.setVisibility(View.VISIBLE);
                    monumentTableRowMain.setVisibility(View.VISIBLE);
                }
            });
        }
        catch(ServidorPHPException e){
            throw new RuntimeException(e);
        }
        return true;
    }
}