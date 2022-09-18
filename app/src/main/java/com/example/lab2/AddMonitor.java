package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab2.entity.Monitor;

import java.util.ArrayList;

public class AddMonitor extends AppCompatActivity {

    private EditText etActivo, etPcActivo, etMarca,etPulgadas,etAños,etModelo;

    private ArrayList<Monitor> list_monitores_cache = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_monitor);

        etActivo = findViewById(R.id.et_activo);
        etPcActivo = findViewById(R.id.et_pcactivo);
        etMarca = findViewById(R.id.et_marca);
        etPulgadas = findViewById(R.id.et_pulgadas);
        etAños = findViewById(R.id.et_año);
        etModelo = findViewById(R.id.et_modelo);
        Bundle recibirdatos = getIntent().getExtras();

        list_monitores_cache = (ArrayList<Monitor>) recibirdatos.getSerializable("lista");

        Log.d("dato recibido de lista ", String.valueOf(list_monitores_cache));

    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_nuevo_monitor,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){


        int id=item.getItemId();


        if(id==R.id.nuevo){

            Monitor monitor = new Monitor(etActivo.getText().toString(),
                    etPcActivo.getText().toString(),
                    etMarca.getText().toString(),
                    etPulgadas.getText().toString(),
                    etAños.getText().toString(),
                    etModelo.getText().toString());
            //Toast.makeText(this, "datos aceptados"+ monitor.getActivo(), Toast.LENGTH_SHORT).show();

            //list_monitores_cache.add(monitor);



            Intent intent = new Intent(this, ListaMonitor.class);
            startActivityForResult(intent, 1);
            Bundle bundle3 = new Bundle();
            bundle3.putSerializable("monitor", monitor);
            intent.putExtras(bundle3);
            startActivity(intent);



        }
        return super.onOptionsItemSelected(item);

    }
}