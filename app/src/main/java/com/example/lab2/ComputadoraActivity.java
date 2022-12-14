package com.example.lab2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab2.entity.Computadora;
import com.example.lab2.entity.ComputadorasLista;

import java.util.ArrayList;

public class ComputadoraActivity extends AppCompatActivity {


    TextView textView;
    public String texto_buscar_comp = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computadora);



        Computadora computadora = new Computadora();
        computadora.setActivo("aaa");
        computadora.setMarca(1);
        computadora.setAño("2001");
        computadora.setCpu("ccccc");
        ComputadorasLista.crearComputadora(computadora);


        if(!ComputadorasLista.getListaComputadoras().isEmpty()){
            textView= findViewById(R.id.text_noHayPC);
            textView.setText("");
            textView.setTextSize(0);


            ListView listView = findViewById(R.id.listView_computadoras);
            ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ComputadorasLista.computadorasDescripcion());
            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(ComputadoraActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ComputadoraActivity.this, ActualizarComputadoraAtivity.class);
                    intent.putExtra("position",Integer.toString(position));
                    startActivity(intent);
                }
            });

        }


    }
    public void añadirComputadora(View view){
        Intent intent = new Intent(this, CrearComputadoraActivity.class);
        int requestCode = 1;
        startActivityForResult(intent, requestCode);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.appbar_computadora, menu);

        return true;
    }

    public void btnMenuComputadoraAction(MenuItem menuItem) {


        View view = findViewById(R.id.btn_menu_computadora);
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.appbar_submenu_computadora, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem1 -> {
            switch (menuItem1.getItemId()) {
                case R.id.btn_buscar_computadora:
                    Log.d("msg", "btn_buscar_computadora pressed");
                    buscadorComp();
                    return true;
                case R.id.btn_todo_computadora:
                    Log.d("msg", "btn_todo_computadora pressed");
                    return true;
                default:
                    return false;
            }
        });
        popupMenu.show();
    }
    public void buscadorComp(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Computadora");
        final EditText input = new EditText(this);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                texto_buscar_comp = input.getText().toString();
                Log.d("msg","Texto "+ texto_buscar_comp);
                ArrayList<String> pcsBuscador = ComputadorasLista.buscarPC(texto_buscar_comp);
                ListView listView= findViewById(R.id.listView_computadoras);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ComputadoraActivity.this, android.R.layout.simple_list_item_1,pcsBuscador);
                listView.setAdapter(arrayAdapter);
                if(pcsBuscador.size()>0){
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(ComputadoraActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ComputadoraActivity.this, ActualizarComputadoraAtivity.class);
                            intent.putExtra("position",Integer.toString(position));
                            startActivity(intent);
                        }
                    });
                }else {
                    textView.setText("NO se encontraron resultados de busqueda");
                }
            }
        });
        alertDialog.setNegativeButton("Cancelar", (dialogInterface, i) ->
                Log.d("msg","btn cancelar presionado"));
        alertDialog.show();
    }
}