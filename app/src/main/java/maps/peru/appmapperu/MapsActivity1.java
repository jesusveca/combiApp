package maps.peru.appmapperu;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity1 extends AppCompatActivity implements GoogleMap.OnInfoWindowClickListener,GoogleMap.OnMarkerDragListener,OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerPrueba;
    private Marker markerDrag;
    private Marker InfoWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng mex = new LatLng(19.4326077, -99.133207999997);
        mMap.addMarker(new MarkerOptions().position(mex).draggable(true).title("Marker Mexico").snippet("Esta es la ciudad de mexico cabrones").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus)));


        LatLng mex2 = new LatLng(20.4326077, -99.133207999997);
        mMap.addMarker(new MarkerOptions().position(mex2).draggable(true).title("Marker Mexico").snippet("Esta es la algo").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng prueba = new LatLng(19.0412967,-98.20619959);
        markerPrueba = googleMap.addMarker(new MarkerOptions().position(prueba).title("Prueba"));

        LatLng prueba2 = new LatLng(19.8412967,-98.40619959);
        markerDrag = googleMap.addMarker(new MarkerOptions().position(prueba2).title("Prueba2").draggable(true));



        LatLng toluca = new LatLng(19.284326077, -99.655699997);
        mMap.addMarker(new MarkerOptions().position(toluca).draggable(true).title("Marker Mexico").snippet("Esta TOLUCA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mex,7));

        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);
        googleMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.equals(markerPrueba)){
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this,lat + ", " + lng,Toast.LENGTH_SHORT).show();
        }


        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        if (marker.equals(markerDrag)){
            Toast.makeText(this,"Start",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if (marker.equals(markerDrag)){
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlng),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);
            setTitle(newTitle);
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if (marker.equals(markerDrag)){
            Toast.makeText(this,"Finished",Toast.LENGTH_LONG).show();
            setTitle(R.string.sitios);
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }
}
