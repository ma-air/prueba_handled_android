package com.example.ejercico1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.time.LocalDate;

public class pantalla2 extends AppCompatActivity {
    //PARA PODER MANEJAR LAS PANTALLAS SIN NINGUN PROBLEMA
    Handler handler = new Handler();
    //TIEMPO QUE QUIERO QUE TARDE EN APARECER DE NUEVO LA PANTALLA NUEMRO 1
    private final int TIEMPO = 5000;


    //PARRA QUE ME COJA LAS VERSIONES ANTEIRIORES DE ANDROID Y FUNCIONE EL LOCAL TIME
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    //SE CREA ALL QUE APARECE EN LA PANTALLA AL APARECER
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        TextView solucion = findViewById(R.id.solucion);
        //COGE EL DATO ALMACENADO DE LA PANTALLA 1
       int diaMetido =  getIntent().getExtras().getInt("integer");
        //OBTENER EL DIA ACTUAL
        int dayOfMonth = LocalDate.now().getDayOfMonth();

        //SI ES IGUAL EL DATO QUE SE METIO EN LA PANTALLA UNO AL DIA ACTUAL ES CORRECTO SINO ES FALLO
        if (diaMetido == dayOfMonth) {
            solucion.setText(R.string.acierto);
            solucion.setTextColor(Color.GREEN);
            solucion.setTextSize(40);
        } else {
            solucion.setText(R.string.fallo);
            solucion.setTextColor(Color.RED);
            solucion.setTextSize(40);
        }
        //PARA PODER RETRASAR LA APARICION DE LA NUEVA PANTALLA
        ejecutarTarea();
    }
    public void ejecutarTarea() {
        handler.postDelayed(new Runnable() {
            public void run() {
                // función a ejecutar
                iniciar(); // función para refrescar la ubicación del conductor, creada en otra línea de código
                handler.postDelayed(this, TIEMPO);
            }
        }, TIEMPO);
    }
    public void iniciar(){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }
}