package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab2.entity.Computadora;
import com.example.lab2.entity.ComputadorasLista;

public class CrearComputadoraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_computadora);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nuevo_pc_check,menu);
        return true;
    }
    public void guardarComputadora(MenuItem menuItem){
        EditText activo = findViewById(R.id.editText_computadora_activo);
        Spinner marca = findViewById(R.id.spinner_marcas_pc);
        EditText anho= findViewById(R.id.editText_anio_computadora);
        EditText cpu = findViewById(R.id.editTextCPU_pc);

        String activoStr=activo.getText().toString();
        String marcaStr= marca.getSelectedItem().toString();
        String anhoStr=anho.getText().toString();
        String cpuStr=cpu.getText().toString();

        if(activoStr.isEmpty()|| anhoStr.isEmpty() || cpuStr.isEmpty()){
            Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_SHORT).show();
        }

        Computadora computadora= new Computadora();
        computadora.setActivo(activoStr);
        computadora.setMarca(Integer.parseInt(marcaStr));
        computadora.setAño(anhoStr);
        computadora.setCpu(cpuStr);

        ComputadorasLista.crearComputadora(computadora);

        Intent intent = new Intent(this, ComputadoraActivity.class);

    }
}