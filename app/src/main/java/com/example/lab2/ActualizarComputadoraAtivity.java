package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lab2.entity.Computadora;
import com.example.lab2.entity.ComputadorasLista;

public class ActualizarComputadoraAtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_computadora_ativity);

        EditText activo = findViewById(R.id.editText_computadora_activo_actualizar);
        Spinner marca = findViewById(R.id.spinner_pc_actualizar);
        EditText anho= findViewById(R.id.editText_anio_computadora_actualizar);
        EditText cpu = findViewById(R.id.editTextCPU_pc_actualizar);

        Intent intent=getIntent();
        int posicion = Integer.parseInt(intent.getStringExtra("position"));

        Computadora pc= ComputadorasLista.getListaComputadoras().get(posicion);



    }

}