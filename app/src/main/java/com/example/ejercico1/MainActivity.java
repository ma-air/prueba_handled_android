package com.example.ejercico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = findViewById(R.id.button);
    }

    public void comprobar(View v) {
        //CREO LOS ATRIBUTOS QUE APARECEN EN LA PANTALLA
        EditText edit = findViewById(R.id.introduce_texto);
        String edit_string = edit.getText().toString();
        //SI EL TEXTO QUE APAREECE ES NULO LE DIREMOS UN MENSAJE DE ERROR SINO LE DIREMOS OTRO O LO EJECUTAREMOS
        if (edit_string.trim().equals("")) {
            edit.setError("INTRODUCE EN QUE DÍA ESTAMOS");
        } else if (!edit_string.trim().equals("")) {
            int edit_integer = Integer.parseInt(edit_string);
            if (edit_integer > 31 || edit_integer <= 0) {
                edit.setError("NINGÚN MES TIENE MÁS DE 31 DIAS");
            } else {
                Intent intent = new Intent(this, pantalla2.class);
                intent.putExtra("integer", edit_integer);
                startActivity(intent);
            }
        }
    }


}