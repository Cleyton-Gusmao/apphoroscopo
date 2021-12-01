package com.pitagoras.apphoroscopo;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    TextView txtResultado, txtResultado2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtResultado = (TextView)findViewById(R.id.txtResultado);
        txtResultado2 = (TextView)findViewById(R.id.txtResultado2);

        txtResultado.setText(getIntent().getStringExtra("referencia"));
        txtResultado2.setText(getIntent().getStringExtra("texto"));

        findViewById(R.id.btn_voltar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}