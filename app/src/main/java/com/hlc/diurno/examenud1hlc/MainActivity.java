package com.hlc.diurno.examenud1hlc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Clase principal
 *
 * @Author Sergio Sánchez Polaino
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método que inicia la activity para recoger el nombre y madar el saludo
     * @param v
     */
    public void iniciarSolicitarNombre(View v){
        Intent saludo = new Intent(this, SolicitarNombre.class);
        startActivity(saludo);
    }

    /**
     * Método que abre el mapa con la dirección del IES Al-Andalus
     * @param v
     */
    public void iniciarDondeEstudias(View v){
        Intent mapa = new Intent(Intent.ACTION_VIEW);
        Uri localizacion = Uri.parse("geo:0,0?q=ies+al-andalus+almeria");
        mapa.setData(localizacion);
        if(mapa.resolveActivity(getPackageManager()) != null) {
            startActivity(mapa);
        }
    }

    /**
     * Método que inicia youtube con la busqueda de videos
     * @param v
     */
    public void iniciarVideoFavorito(View v){
        Intent youtube = new Intent(Intent.ACTION_VIEW);
        Uri buscarVideo = Uri.parse("https://www.youtube.com/results?search_query=eukz");
        youtube.setData(buscarVideo);
        if(youtube.resolveActivity(getPackageManager()) != null){
            startActivity(youtube);
        }
    }
}
