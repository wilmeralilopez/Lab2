package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lab2.entity.Computadora;

public class ListaMonitor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_monitor);
    }

    public   void addMonitor(View view){
        Intent intent = new Intent(ListaMonitor.this, AddMonitor.class);
        startActivityForResult(intent, 1);
    }
}