package com.example.dani.actividad3ajuanmi;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity  {
    Button cargar;
    public static final String PREFS = "prefe";
    Button guardar;
    RadioButton mascle;
    RadioButton femella;
    EditText nom;
    EditText identificacio;
    EditText fechaNaci;
    TextView cargador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargar= (Button) findViewById(R.id.buttonCargar);
        guardar = (Button) findViewById(R.id.buttonGuardar);
        mascle = (RadioButton)findViewById(R.id.radioButtonHombre);
        femella = (RadioButton)findViewById(R.id.radioButtonMujer);
        nom= (EditText) findViewById(R.id.editTextNombre);
        identificacio= (EditText) findViewById(R.id.editTextDni);
        fechaNaci=(EditText) findViewById(R.id.editTextFecha);
        cargador=(TextView) findViewById(R.id.textView);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

                SharedPreferences.Editor editor = mySharedPreferences.edit();
               String nombre,deneis,fechanaix;
                Boolean home,dona;
                nombre=nom.getText().toString();
                deneis=identificacio.getText().toString();
                fechanaix=fechaNaci.getText().toString();
                if(mascle.isChecked()){
                    home=true;
                    dona=false;
                }else{
                    dona=true;
                    home=false;
                }

                editor.putString("nombre",nombre);
                editor.putString("dni",deneis);
                editor.putString("fechaNaci",fechanaix);
                editor.putBoolean("home",home);
                editor.putBoolean("dona",dona);

                editor.commit();

            }
        });
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String concat ="";
            SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
                concat=(mySharedPreferences.getString("nombre", ""));
                concat=concat+"\n";
                concat=concat+(mySharedPreferences.getString("dni", ""));
                concat=concat+"\n";
                concat=concat+(mySharedPreferences.getString("fechaNaci", ""));
                concat=concat+"\n";
                if(mySharedPreferences.getBoolean("home",false)==true){
                  concat=concat+("Es home");
                }else{
                   concat= concat+("Es dona");
                }
                cargador.setText(concat);
            }
        });
    }
}
