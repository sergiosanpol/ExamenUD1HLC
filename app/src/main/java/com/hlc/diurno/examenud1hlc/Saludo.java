package com.hlc.diurno.examenud1hlc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Clase Saludo. Nos mostrará dos botones donde tendremos que aceptar o rechazar el saludo
 *
 * @Author Sergio Sánchez Polaino
 */
public class Saludo extends AppCompatActivity {

    private TextView titulo;
    private Button acepto, rechazo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        titulo = (TextView) findViewById(R.id.tv_titulo_saludo);
        acepto = (Button) findViewById(R.id.bt_acepto_saludo);
        rechazo = (Button) findViewById(R.id.bt_rechazo_saludo);

        //Comprar si la activiry anterior a mandado información
        if(getIntent().hasExtra("NOMBRE")){
            String nombre = getIntent().getStringExtra("NOMBRE");
            titulo.setText("Hola " + nombre + ", esto es muy fácil, pero date prisa!!");
        }
    }

    /**
     * Método que devuelve la respuesta de si hemos aceptado o rechazado el saludo a la activity anterior (SolicitarNombre.java)
     * @param v
     */
    public void devolverResultados(View v){
        String respuesta;
        if(v.getId() == acepto.getId()){ //Si acepta
            respuesta = "Eres muy agradable";
        }else{ //Si rechaza
            respuesta = "Recuérdame que no vuelva a saludarte";
        }
        Intent resultado = new Intent(this, SolicitarNombre.class);
        resultado.putExtra("RESPUESTA", respuesta);
        setResult(RESULT_OK, resultado); //Mandar resultados
        finish(); //Finalizar la activity
    }

}
