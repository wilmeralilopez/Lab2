package com.example.lab2;

import android.content.Intent;
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
            Monitor monitor = new Monitor(etActivo.getText().toString(),
                    etPcActivo.getText().toString(),
                    etMarca.getText().toString(),
                    etPulgadas.getText().toString(),
                    etAño.getText().toString(),
                    etModelo.getText().toString());

            //Toast.makeText(this, "Actualizar", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, ListaMonitor.class);
            startActivityForResult(intent, 1);
            Bundle bundle3 = new Bundle();
            bundle3.putSerializable("monitor2", monitor);
            intent.putExtras(bundle3);
            startActivity(intent);


        } else if (id==R.id.eliminar){
            Toast.makeText(this, "Eliminar", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);

    }
}