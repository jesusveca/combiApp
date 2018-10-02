package maps.peru.appmapperu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTipos, btnUbicacion, btnSitios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSitios = (Button)findViewById(R.id.btn_Sitios);
        btnTipos = (Button)findViewById(R.id.btn_Tipos);

        btnUbicacion=(Button)findViewById(R.id.btn_Ubicacion);



        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity1.class);
                startActivity(intent);
            }
        });

        btnUbicacion = (Button)findViewById(R.id.btn_Ubicacion);
        btnTipos = (Button)findViewById(R.id.btn_Tipos);
    }

    public void MapaSitios(View view){
        Intent intent = new Intent(getApplicationContext(), MapsActivityTipos.class);
        startActivity(intent);
    }


    public void MiLocalizacion(View view){
        Intent intent = new Intent(getApplicationContext(), MapsActivityLocalizacion.class);
        startActivity(intent);
    }

}
