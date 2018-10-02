package maps.peru.appmapperu;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityTipos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Button btn_Hibrido, btn_Normal, btn_Satelital, btn_Terreno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_tipos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_Hibrido = (Button) findViewById(R.id.btn_hibrido);
        btn_Normal = (Button) findViewById(R.id.btn_normal);
        btn_Satelital = (Button) findViewById(R.id.btn_salitetal);
        btn_Terreno = (Button) findViewById(R.id.btn_terreno);
    }

    public void CambiarHibrido(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void CambiarNormal(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void CambiarSatelite(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
    public void CambiarTerreno(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
