package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected TextView label1;
    protected TextView label2;
    protected TextView label3;
    protected ImageView img1;
    protected EditText caja1;
    protected Button btn1;

    String respuesta = "beatriz";
    String eleccion;
    int intentos = 4;
    int numImg = 1;
    Drawable dra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label1 = (TextView) findViewById(R.id.label1_start);
        label2 = (TextView) findViewById(R.id.label2_start);
        label3 = (TextView) findViewById(R.id.label3_start);
        img1 = (ImageView) findViewById(R.id.img1_start);
        caja1 = (EditText) findViewById(R.id.caja1_start);
        btn1 = (Button) findViewById(R.id.btn1_start);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eleccion = caja1.getText().toString().toLowerCase();
                if (eleccion.equalsIgnoreCase(respuesta)) {
                    label3.setText("CORRECTO!");
                    btn1.setEnabled(false);
                } else {
                    if (intentos > 1) {
                        intentos--;
                        Toast.makeText(MainActivity.this, "Incorrecto", Toast.LENGTH_LONG).show();
                        label3.setText("Te quedan " + intentos + " intentos");
                        numImg++;
                        int identificador = getResources().getIdentifier("@drawable/ahorcado" + numImg, null, getPackageName());
                        dra = getResources().getDrawable(identificador);
                        img1.setImageDrawable(dra);

                    } else {
                        img1.setImageResource(R.drawable.ahorcado5);
                        label3.setText("No lo has conseguido");
                        btn1.setEnabled(false);
                    }
                }
            }
        });
    }
}