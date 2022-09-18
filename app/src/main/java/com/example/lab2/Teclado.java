package com.example.lab2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Teclado extends AppCompatActivity {

    List<TecladoElemento> listaTeclados = new ArrayList<TecladoElemento>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado);


        // TODO rellenar la lista
        TecladoElemento t1 = new TecladoElemento("a", "b", "c", "d", "e", "f");
        TecladoElemento t2 = new TecladoElemento("a", "b", "c", "d", "e", "f");

        listaTeclados.addAll(Arrays.asList(new TecladoElemento[] {t1, t2} ));
        Log.d("msg", listaTeclados.toString());

        // set up
        recyclerView = findViewById(R.id.lv_teclado);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerViewAdapter(listaTeclados, this);
        recyclerView.setAdapter(mAdapter);
    }

    // añadir un teclado
    public void añadirTeclado(View view){
        Intent intent = new Intent(this, TecladoNuevo.class);
        int requestCode = 1;
        startActivityForResult(intent, requestCode);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK){

            String activo = data.getStringExtra("activo");
            String pc = data.getStringExtra("pc");
            String marca = data.getStringExtra("marca");
            String idioma = data.getStringExtra("idioma");
            String año = data.getStringExtra("año");
            String modelo = data.getStringExtra("modelo");

            TecladoElemento nuevoTeclado = new TecladoElemento(activo, pc, marca, idioma, año, modelo);
            listaTeclados.addAll(Arrays.asList(new TecladoElemento[] {nuevoTeclado} ));

        }
    }

    // APPBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_teclado_listar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.tecladoPopup:

                View menuItemView = findViewById(R.id.tecladoPopup);
                PopupMenu popupMenu = new PopupMenu(this, menuItemView);
                popupMenu.getMenuInflater().inflate(R.menu.popup_teclado, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                     switch (menuItem.getItemId()){
                         case R.id.tecladoBuscar:
                             Log.d("msg", "buscar");
                             // TODO
                             return true;
                         case R.id.tecladoTodo:
                             Log.d("msg", "Todo");
                             // TODO
                             return true;
                         default:
                             return false;
                     }
                    }
                });
                popupMenu.show();


                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}