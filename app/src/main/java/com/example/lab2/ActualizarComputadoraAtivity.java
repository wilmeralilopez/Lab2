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

public class ActualizarComputadoraAtivity extends AppCompatActivity {
    EditText activo;
    Spinner marca;
    EditText anho;
    EditText cpu;
    int posicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_computadora_ativity);

        activo = findViewById(R.id.editText_computadora_activo_actualizar);
        marca = findViewById(R.id.spinner_pc_actualizar);
        anho= findViewById(R.id.editText_anio_computadora_actualizar);
        cpu = findViewById(R.id.editTextCPU_pc_actualizar);

        Intent intent=getIntent();
        posicion = Integer.parseInt(intent.getStringExtra("position"));
        //Para mostrar en la vista los datos de la pc escogida
        Computadora pc= ComputadorasLista.getListaComputadoras().get(posicion);
        activo.setText(pc.getActivo());
        marca.setSelection(pc.getMarca());
        anho.setText(String.valueOf(pc.getAño()));
        cpu.setText(pc.getCpu());

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actualizar_pc_menu,menu);
        return true;
    }
    public void actualizarComputadora(MenuItem menuItem){
        String activoStr=activo.getText().toString();
        String anhoStr=anho.getText().toString();
        String cpuStr=cpu.getText().toString();

        if(activoStr.isEmpty()  || anhoStr.isEmpty() || cpuStr.isEmpty()){
            Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_SHORT).show();
        }

        Computadora pcActualizada = new Computadora();
        pcActualizada.setActivo(activoStr);
        pcActualizada.setMarca(marca.getSelectedItemPosition());
        pcActualizada.setAño(anhoStr);
        pcActualizada.setCpu(cpuStr);

        ComputadorasLista.editarComputadora(posicion, pcActualizada);

        Intent intent2= new Intent(this, ComputadoraActivity.class);
        startActivity(intent2);



    }

    public void deleteComputadora(MenuItem menuItem){
        ComputadorasLista.eliminarComputadora(posicion);
    }


}