package com.example.lab2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab2.entity.Monitor;

import java.util.ArrayList;

public class ActualizarMonitor extends AppCompatActivity {
    private EditText etActivo,etPcActivo, etMarca, etPulgadas, etAño,etModelo;
    private ArrayList<Monitor> list_monitores_cache = new ArrayList<>();
    private ArrayList<Monitor> list_monitores_cache_buscador = new ArrayList<>();
    private Monitor monitor ;

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

        list_monitores_cache = (ArrayList<Monitor>) getIntent().getSerializableExtra("lista");
        list_monitores_cache_buscador = (ArrayList<Monitor>) getIntent().getSerializableExtra("lista2")!=null? (ArrayList<Monitor>) getIntent().getSerializableExtra("lista2"):null ;


        Bundle objetoEnviado=getIntent().getExtras();
        monitor = (Monitor) objetoEnviado.getSerializable("monitor");
        etActivo.setText(monitor.getActivo());
        etPcActivo.setText(monitor.getPcActivo());
        etMarca.setText(monitor.getMarca());
        etPulgadas.setText(monitor.getPulgadas());
        etAño.setText(monitor.getAños());
        etModelo.setText(monitor.getModelo());


        /*Monitor monitor = null;

        if(objetoEnviado!=null){
            monitor = (Monitor) objetoEnviado.getSerializable("monitor");
            etActivo.setText(monitor.getActivo());
            etPcActivo.setText(monitor.getPcActivo());
            etMarca.setText(monitor.getMarca());
            etPulgadas.setText(monitor.getPulgadas());
            etAño.setText(monitor.getAños());
            etModelo.setText(monitor.getModelo());
        }*/






        //Monitor monitor = (Monitor) getIntent().getSerializableExtra("monitor");








    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_actualizar,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        ArrayList<Monitor> list_monitores_actual = new ArrayList<>();

        list_monitores_actual = list_monitores_cache_buscador==null ? list_monitores_cache : list_monitores_cache_buscador;


        int id=item.getItemId();
        if(id==R.id.actualizar){


            Monitor monitor2 = new Monitor(etActivo.getText().toString(),
                    etPcActivo.getText().toString(),
                    etMarca.getText().toString(),
                    etPulgadas.getText().toString(),
                    etAño.getText().toString(),
                    etModelo.getText().toString());

            //Toast.makeText(this, "Actualizar", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, ListaMonitor.class);
            startActivityForResult(intent, 1);

            /*Bundle bundle3 = new Bundle();
            bundle3.putSerializable("monitor2", monitor);
            intent.putExtras(bundle3);*/
            for (int x = 0; x < list_monitores_actual.size(); x++) {
                Monitor p = list_monitores_actual.get(x);
                if (p.getActivo().equalsIgnoreCase(monitor.getActivo())) {
                    p.setActivo(monitor2.getActivo());
                    p.setModelo(monitor2.getModelo());
                    p.setAños(monitor2.getAños());
                    p.setPulgadas(monitor2.getPulgadas());
                    p.setMarca(monitor2.getMarca());
                    p.setPcActivo(monitor2.getPcActivo());


                    break; // Terminar ciclo, pues ya lo encontramos
                }
            }


            intent.putExtra("lista", list_monitores_actual);

            startActivity(intent);


        } else if (id==R.id.eliminar){
            AlertDialog.Builder alertaDialog = new AlertDialog.Builder(this);
            alertaDialog.setTitle("");
            alertaDialog.setMessage("Esta seguro que desea Borrar?");
            alertaDialog.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            ArrayList<Monitor> finalList_monitores_actual = list_monitores_actual;
            alertaDialog.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Monitor monitor2 = new Monitor(etActivo.getText().toString(),
                            etPcActivo.getText().toString(),
                            etMarca.getText().toString(),
                            etPulgadas.getText().toString(),
                            etAño.getText().toString(),
                            etModelo.getText().toString());


                    Intent intent = new Intent(ActualizarMonitor.this, ListaMonitor.class);
                    startActivityForResult(intent, 1);


                    for (int x = 0; x < finalList_monitores_actual.size(); x++) {
                        Monitor p = finalList_monitores_actual.get(x);
                        if (p.getActivo().equalsIgnoreCase(monitor.getActivo())) {
                            finalList_monitores_actual.remove(p);


                            break; // Terminar ciclo, pues ya lo encontramos
                        }
                    }


                    intent.putExtra("lista", finalList_monitores_actual);

                    startActivity(intent);





                }
            });

            alertaDialog.show();


        }            //Toast.makeText(this, "Eliminar", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);

    }
}