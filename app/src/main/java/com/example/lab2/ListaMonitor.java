package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab2.entity.Monitor;

import java.util.ArrayList;

public class ListaMonitor extends AppCompatActivity implements Custom_dialog_monitor.Custom_DialogInterface{

    private TextView  textViewMonitor;
    private ListView listaMonitor;

    private String Nombres [] = {"Monitor 1", "Monitor 2"};
    private String año [] = {"2021", "2022"};

    private ArrayList<String> list_monitores = new ArrayList<>();
    private ArrayList<Monitor> list_monitores_cache = new ArrayList<>();
    private ArrayList<Monitor> list_monitores_cache_buscador = new ArrayList<>();


    int encontrado = 0;
    String palabraBuscada;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_monitor);


        textViewMonitor = findViewById(R.id.tv_monitor);
        listaMonitor = findViewById(R.id.listView_monitor);

        //Crear objetos de lista

       Monitor monitor1 = new Monitor("C042322",
                "C012322",
                "Dell",
                "25\"",
                "2022",
                "d1234");


        list_monitores_cache.add(monitor1);

        Monitor monitor2 = new Monitor("C042323",
                "C012323",
                "Del3",
                "23\"",
                "2023",
                "d1233");


        list_monitores_cache.add(monitor2);



            if (list_monitores_cache.size() != 0) {


                //Se crea el list View como String
                for (int i = 0; i < list_monitores_cache.size(); i++) {
                    String Monitor = "Activo: " + list_monitores_cache.get(i).getActivo()
                            + "\nPc: " + list_monitores_cache.get(i).getPcActivo()
                            + "\nMarca: " + list_monitores_cache.get(i).getMarca()
                            + "\nPulgadas: " + list_monitores_cache.get(i).getPulgadas()
                            + "\nAño: " + list_monitores_cache.get(i).getAños()
                            + "\nModelo: " + list_monitores_cache.get(i).getModelo();


                    list_monitores.add(Monitor);
                }


                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_monitores, list_monitores);
                listaMonitor.setAdapter(adapter);

                //logica al hacer click
                listaMonitor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Monitor monitor = list_monitores_cache.get(i);

                        Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("monitor", monitor);

                        intent.putExtras(bundle);
                        startActivity(intent);

                        //Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);
                        //intent.putExtra("monitor",(Monitor) list_monitores_cache.get((Integer) listaMonitor.getItemAtPosition(i)));
                        //startActivity(intent);
                        //textViewMonitor.setText("Monitor Seleccionado "+ listaMonitor.getItemAtPosition(i)+ " del año " + año [i] );
                    }
                });
                textViewMonitor.setText("");

            } else if (list_monitores_cache.size() == 0) {

                textViewMonitor.setText("No hay monitores registrados");


            }







    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_monitor,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.overflow_buscar){
            Custom_dialog_monitor custom_dialog_monitor =new Custom_dialog_monitor();
            custom_dialog_monitor.show(getSupportFragmentManager(),"Monitor");
            //Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.overflow_todo){
            //Toast.makeText(this, "Todo", Toast.LENGTH_SHORT).show();


            if (list_monitores_cache.size() != 0) {


                //Se crea el list View como String
                for (int i = 0; i < list_monitores_cache.size(); i++) {
                    String Monitor = "Activo: " + list_monitores_cache.get(i).getActivo()
                            + "\nPc: " + list_monitores_cache.get(i).getPcActivo()
                            + "\nMarca: " + list_monitores_cache.get(i).getMarca()
                            + "\nPulgadas: " + list_monitores_cache.get(i).getPulgadas()
                            + "\nAño: " + list_monitores_cache.get(i).getAños()
                            + "\nModelo: " + list_monitores_cache.get(i).getModelo();


                    list_monitores.add(Monitor);
                }


                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_monitores, list_monitores);
                listaMonitor.setAdapter(adapter);

                //logica al hacer click
                listaMonitor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Monitor monitor = list_monitores_cache.get(i);

                        Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("monitor", monitor);

                        intent.putExtras(bundle);
                        startActivity(intent);

                        //Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);
                        //intent.putExtra("monitor",(Monitor) list_monitores_cache.get((Integer) listaMonitor.getItemAtPosition(i)));
                        //startActivity(intent);
                        //textViewMonitor.setText("Monitor Seleccionado "+ listaMonitor.getItemAtPosition(i)+ " del año " + año [i] );
                    }
                });
                textViewMonitor.setText("");

            } else if (list_monitores_cache.size() == 0) {

                textViewMonitor.setText("No hay monitores registrados");


            }




    }
        return super.onOptionsItemSelected(item);

    }

    public   void addMonitor(View view){
        Intent intent = new Intent(ListaMonitor.this, AddMonitor.class);
        startActivityForResult(intent, 1);
    }

    @Override//Buscador
    public void applyTexts(String string) {
        list_monitores.clear();

        for (int x = 0; x < list_monitores_cache.size(); x++) {
            Monitor p = list_monitores_cache.get(x);
            if (p.getActivo().equalsIgnoreCase(string)) {
                list_monitores_cache_buscador.add(p);


                break; // Terminar ciclo, pues ya lo encontramos
            }
        }

        if(list_monitores_cache_buscador.size()!=0){

            encontrado = 1;



            for (int i = 0; i < list_monitores_cache_buscador.size(); i++) {
                String Monitor = "Activo: " + list_monitores_cache_buscador.get(i).getActivo()
                        + "\nPc: " + list_monitores_cache_buscador.get(i).getPcActivo()
                        + "\nMarca: " + list_monitores_cache_buscador.get(i).getMarca()
                        + "\nPulgadas: " + list_monitores_cache_buscador.get(i).getPulgadas()
                        + "\nAño: " + list_monitores_cache_buscador.get(i).getAños()
                        + "\nModelo: " + list_monitores_cache_buscador.get(i).getModelo();


                list_monitores.add(Monitor);
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_monitores, list_monitores);
            listaMonitor.setAdapter(adapter);

            //logica al hacer click
            listaMonitor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Monitor monitor = list_monitores_cache_buscador.get(i);

                    Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("monitor", monitor);

                    intent.putExtras(bundle);
                    startActivity(intent);

                    //Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);
                    //intent.putExtra("monitor",(Monitor) list_monitores_cache.get((Integer) listaMonitor.getItemAtPosition(i)));
                    //startActivity(intent);
                    //textViewMonitor.setText("Monitor Seleccionado "+ listaMonitor.getItemAtPosition(i)+ " del año " + año [i] );
                }
            });
            textViewMonitor.setText("");



        }else if(list_monitores_cache_buscador.size()==0) {
            encontrado = 2;
            palabraBuscada= string;
            textViewMonitor.setText("No existe el equipo con"+
                    "\nActivo: "+ palabraBuscada);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_monitores, list_monitores);
            listaMonitor.setAdapter(adapter);


        }


        //Toast.makeText(this, "Buscador funciono:" + string + encontrado, Toast.LENGTH_SHORT).show();



    }
}