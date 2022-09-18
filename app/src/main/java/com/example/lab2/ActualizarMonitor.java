package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab2.entity.Monitor;

public class ActualizarMonitor extends AppCompatActivity {
    private EditText etActivo,etPcActivo, etMarca, etPulgadas, etAño,etModelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_monitor);

        etActivo = findViewById(R.id.editText_activo);
        etPcActivo = findViewById(R.id.editText_PCactivo);
        etMarca = findViewById(R.id.editText_Marca);
        etPulgadas = findViewById(R.id.editText_Pulgadas);
        etAño = findViewById(R.id.editText_Año);
        etModelo = findViewById(R.id.editText_Modelo);

        Bundle objetoEnviado=getIntent().getExtras();
        Monitor monitor = null;

        if(objetoEnviado!=null){
            monitor = (Monitor) objetoEnviado.getSerializable("monitor");
            etActivo.setText(monitor.getActivo());
            etPcActivo.setText(monitor.getPcActivo());
            etMarca.setText(monitor.getMarca());
            etPulgadas.setText(monitor.getPulgadas());
            etAño.setText(monitor.getAños());
            etModelo.setText(monitor.getModelo());
        }




        //Monitor monitor = (Monitor) getIntent().getSerializableExtra("monitor");








    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_actualizar,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.actualizar){
            Toast.makeText(this, "Actualizar", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.eliminar){
            Toast.makeText(this, "Eliminar", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);

    }
}