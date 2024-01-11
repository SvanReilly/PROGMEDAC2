package com.example.mapas;

import static java.lang.Float.parseFloat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Marker.OnMarkerClickListener{

    ControladorMonumento controladorMonumento = new ControladorMonumento(this);
    private Button botonBuscar, botonComprar;
    private TextView nombreView, fechaView, descripcionView, rellenoDescView, ciudadView, latitudView, longitudView, mediaView;
    private ImageView fotoView;
    private WebView videoView;
    private MapView mapaView;
    private String id;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configuration.getInstance().setUserAgentValue("appIdMapPractice");

        //Vinculacion de los elementos con texto

        nombreView = findViewById(R.id.nombreView);
        fechaView = findViewById(R.id.fechaView);
        descripcionView = findViewById(R.id.descripcionView);
        rellenoDescView = findViewById(R.id.rellenoDescView);
        ciudadView = findViewById(R.id.ciudadView);
        latitudView = findViewById(R.id.latitudView);
        longitudView = findViewById(R.id.longitudView);
        mediaView = findViewById(R.id.mediaView);


        //Vinculacion de los elementos con acciones
        botonComprar = findViewById(R.id.botonComprar);

        //Vinculacion de los elementos con media
        fotoView = findViewById(R.id.fotoView);
        videoView = findViewById(R.id.videoView);

        //Vinculacion del mapa y control
        mapaView = findViewById(R.id.mapaView);
        MapController mapController = (MapController)  mapaView.getController();
        mapController.setCenter(new GeoPoint(37.1881700, -3.6066700));
        mapController.setZoom(14);

        //Obtenemos todos los monumentos para crear los marcadores en el mapa
        try {
            controladorMonumento.obtenerTodosMonumentos(new VolleyCallBack() {
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
        Marker marker = new Marker(mapaView);
        marker.setPosition(geoPoint);
        mapaView.getOverlays().add(marker);
        marker.setId(monumento.getId());
        marker.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker, MapView mapView) {
        id = marker.getId();
            try{
                controladorMonumento.obtenerMonumentoID(id, new VolleyCallBack() {
                    @Override
                    public void onSuccess(Context context, ArrayList<Monumento> monumentos) {
                        Monumento monumento = monumentos.get(0);

                        nombreView.setText(monumento.getNombre());
                        fechaView.setText(monumento.getFecha());
                        Picasso.get().load(monumento.getImagen()).into(fotoView);
                        rellenoDescView.setText(monumento.getDescripcion());
                        ciudadView.setText(monumento.getCiudad());
                        latitudView.setText("Latitud: " + monumento.getLatitud());
                        longitudView.setText("Longitud: " + monumento.getLongitud());
                        botonComprar.setText("Comprar entrada desde " +monumento.getPrecio() + monumento.getMoneda());

                        String html = monumento.getVideo();
                        WebSettings settings = videoView.getSettings();
                        settings.setJavaScriptEnabled(true);
                        videoView.loadData(html, "text/html", "UTF-8");
                    }
                });
            }
            catch(ServidorPHPException e){
            }
            return true;
    }
}