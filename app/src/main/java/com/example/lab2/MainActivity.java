package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lab2.entity.Computadora;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irComputadora(View view){
        Intent intent = new Intent(MainActivity.this, ComputadoraActivity.class);
        startActivity(intent);
    }

    public   void irTeclado(View view){
        Intent intent = new Intent(this, Teclado.class);
        startActivity( intent );
    }

    public   void irMonitor(View view){
        Intent intent = new Intent(MainActivity.this, ListaMonitor.class);
        startActivity( intent );
    }
}