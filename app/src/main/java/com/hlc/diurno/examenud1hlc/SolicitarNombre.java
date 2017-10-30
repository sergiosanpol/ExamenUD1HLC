package com.hlc.diurno.examenud1hlc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SolicitarNombre extends AppCompatActivity {

    private final int CODIGO_CLASE_SALUDO = 1;

    private EditText nombre;
    private TextView respuestaSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_nombre);

        nombre = (EditText) findViewById(R.id.et_nombre);
        respuestaSaludo = (TextView) findViewById(R.id.tv_saludo_respuesta);
    }

    /**
     * Método que inicia la activity para mandar una respuesta del saludo
     * @param v
     */
    public void iniciarSaludo(View v){
        Intent saludo = new Intent(this, Saludo.class);
        saludo.putExtra("NOMBRE", nombre.getText().toString());
        startActivityForResult(saludo, CODIGO_CLASE_SALUDO);
    }

    @Override
    /**
     * Método que recoge la información recibida de la activity anterior (Saludo.java)
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CODIGO_CLASE_SALUDO && resultCode == RESULT_OK){
            respuestaSaludo.setText(data.getStringExtra("RESPUESTA"));
        }
    }
}
