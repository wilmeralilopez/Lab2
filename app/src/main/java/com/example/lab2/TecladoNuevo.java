package com.example.lab2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class TecladoNuevo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado_nuevo);

        String[] listaPcActivo = {"PC1", "PC2", "PC3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaPcActivo);
        Spinner spinner = findViewById(R.id.spinnerPc);
        spinner.setAdapter(adapter);

        String[] listaMarca = {"Marca1", "Marca2", "Marca3"};
        ArrayAdapter<String> adapterMarca = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaMarca);
        Spinner spinnerMarca = findViewById(R.id.spinnerMarca);
        spinnerMarca.setAdapter(adapterMarca);

        String[] listaIdioma = {"Español", "Quechua", "Frances"};
        ArrayAdapter<String> adapterIdioma = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaIdioma);
        Spinner spinnerIdiomoa = findViewById(R.id.spinnerIdioma);
        spinnerIdiomoa.setAdapter(adapterIdioma);

    }

    // APPBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_teclado_nuevo, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.btnTecladoNuevo:
                // se crea un nuevo intent
                Intent intent = new Intent();

                //
                EditText editTextActivo = findViewById(R.id.editTextTextActivo);
                String textActivo = editTextActivo.getText().toString();

                Spinner spinnerPc = (Spinner) findViewById(R.id.spinnerPc);
                String textPc = spinnerPc.getSelectedItem().toString();

                Spinner spinnerMarca = (Spinner) findViewById(R.id.spinnerMarca);
                String textMarca = spinnerPc.getSelectedItem().toString();

                Spinner spinnerIdioma = (Spinner) findViewById(R.id.spinnerIdioma);
                String textIdioma = spinnerIdioma.getSelectedItem().toString();

                EditText editTextAnho = findViewById(R.id.editTextAnho);
                String textAnho = editTextAnho.getText().toString();

                EditText editTextModelo = findViewById(R.id.editTextModelo);
                String textModelo = editTextModelo.getText().toString();

                //
                intent.putExtra("activo", textActivo);
                intent.putExtra("pc", textPc);
                intent.putExtra("marca", textMarca);
                intent.putExtra("idioma", textIdioma);
                intent.putExtra("año", textAnho);
                intent.putExtra("modelo", textModelo);
                setResult(RESULT_OK, intent);
                finish();

                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}