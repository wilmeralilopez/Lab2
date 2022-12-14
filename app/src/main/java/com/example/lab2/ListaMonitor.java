package com.example.lab2;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab2.entity.Monitor;

import java.util.ArrayList;

public class ListaMonitor extends AppCompatActivity implements Custom_dialog_monitor.Custom_DialogInterface{

    private TextView  textViewMonitor;
    private ListView listaMonitor;



    private final ArrayList<String> list_monitores = new ArrayList<>();
    private ArrayList<Monitor> list_monitores_cache = new ArrayList<>();
    private ArrayList<Monitor> list_monitores_cache_buscador = new ArrayList<>();
    private ArrayList<Monitor> list_monitores_actual_cache = new ArrayList<>();


    int encontrado = 0;
    String palabraBuscada;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_monitor);


        textViewMonitor = findViewById(R.id.tv_monitor);
        listaMonitor = findViewById(R.id.listView_monitor);

        Monitor monitor2 = new Monitor("C042323",
                "C012323",
                "Del3",
                "23\"",
                "2023",
                "d1233");


        list_monitores_cache.add(monitor2);
        Monitor monitor3 = new Monitor("C042324",
                "C012324",
                "Del34",
                "234\"",
                "2024",
                "d12334");


        list_monitores_cache.add(monitor3);
        Monitor monitor4 = new Monitor("CAA1234",
                "CAA1523",
                "Del33",
                "2AA\"",
                "202A",
                "d123A");


        list_monitores_cache.add(monitor4);
        try
        {
            //Bundle recibirdatos = getIntent().getExtras();
            //Monitor monitor = (Monitor) recibirdatos.getSerializable("monitor1");
            //Log.d("dato recibido en lista", String.valueOf(list_monitores_cache));
            //list_monitores_cache.add(monitor);
            list_monitores_cache = (ArrayList<Monitor>) getIntent().getSerializableExtra("lista") == null? list_monitores_cache : (ArrayList<Monitor>) getIntent().getSerializableExtra("lista") ;
           /* Monitor monitor2 = (Monitor) recibirdatos.getSerializable("monitor2");
            for (int x = 0; x < list_monitores_cache.size(); x++) {
                Monitor p = list_monitores_cache.get(x);
                if (p.getActivo().equalsIgnoreCase(monitor2.getActivo())) {
                    p.setModelo(monitor2.getModelo());
                    p.setA??os(monitor2.getA??os());
                    p.setPulgadas(monitor2.getPulgadas());
                    p.setMarca(monitor2.getMarca());
                    p.setPcActivo(monitor2.getPcActivo());
                    list_monitores_cache_buscador.add(p);


                    break; // Terminar ciclo, pues ya lo encontramos
                }
            }*/


        }
        catch(NullPointerException e)
        {
            System.out.print("NullPointerException Caught");
        }







            if (list_monitores_cache.size() != 0) {


                //Se crea el list View como String
                for (int i = 0; i < list_monitores_cache.size(); i++) {
                    String Monitor = "Activo: " + list_monitores_cache.get(i).getActivo()
                            + "\nPc: " + list_monitores_cache.get(i).getPcActivo()
                            + "\nMarca: " + list_monitores_cache.get(i).getMarca()
                            + "\nPulgadas: " + list_monitores_cache.get(i).getPulgadas()
                            + "\nA??o: " + list_monitores_cache.get(i).getA??os()
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

                        intent.putExtra("lista",list_monitores_cache);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("monitor", monitor);

                        intent.putExtras(bundle);
                        startActivity(intent);

                        //Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);
                        //intent.putExtra("monitor",(Monitor) list_monitores_cache.get((Integer) listaMonitor.getItemAtPosition(i)));
                        //startActivity(intent);
                        //textViewMonitor.setText("Monitor Seleccionado "+ listaMonitor.getItemAtPosition(i)+ " del a??o " + a??o [i] );
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

                ArrayList<String> list_monitores3 = new ArrayList<>();
                //Se crea el list View como String
                for (int i = 0; i < list_monitores_cache.size(); i++) {
                    String Monitor = "Activo: " + list_monitores_cache.get(i).getActivo()
                            + "\nPc: " + list_monitores_cache.get(i).getPcActivo()
                            + "\nMarca: " + list_monitores_cache.get(i).getMarca()
                            + "\nPulgadas: " + list_monitores_cache.get(i).getPulgadas()
                            + "\nA??o: " + list_monitores_cache.get(i).getA??os()
                            + "\nModelo: " + list_monitores_cache.get(i).getModelo();


                    list_monitores3.add(Monitor);
                }


                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_monitores, list_monitores3);
                listaMonitor.setAdapter(adapter);

                //logica al hacer click
                listaMonitor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Monitor monitor = list_monitores_cache.get(i);

                        Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);

                        intent.putExtra("lista", list_monitores_cache);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("monitor", monitor);

                        intent.putExtras(bundle);
                        startActivity(intent);

                        //Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);
                        //intent.putExtra("monitor",(Monitor) list_monitores_cache.get((Integer) listaMonitor.getItemAtPosition(i)));
                        //startActivity(intent);
                        //textViewMonitor.setText("Monitor Seleccionado "+ listaMonitor.getItemAtPosition(i)+ " del a??o " + a??o [i] );
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

        intent.putExtra("lista",list_monitores_cache);

        /*Bundle bundle2 = new Bundle();
        bundle2.putSerializable("lista", list_monitores_cache);
        intent.putExtras(bundle2);*/
        startActivity(intent);

    }

    @Override//Buscador
    public void applyTexts(String string) {


        if(string.trim().equals("")||string == null){
            list_monitores.clear();
            palabraBuscada= string;
            textViewMonitor.setText("Ingrese un ACTIVO para buscar un monitor");

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_monitores, list_monitores);
            listaMonitor.setAdapter(adapter);

        }else if (!string.trim().equals("")||string != null){
            list_monitores_cache_buscador.clear();
            for (int x = 0; x < list_monitores_cache.size(); x++) {
                Monitor p = list_monitores_cache.get(x);
                if (p.getActivo().equalsIgnoreCase(string.trim())) {
                    list_monitores_cache_buscador.add(p);


                    break; // Terminar ciclo, pues ya lo encontramos
                }
            }

            if(list_monitores_cache_buscador.size()!=0){

                encontrado = 1;
                ArrayList<String> list_monitores2 = new ArrayList<>();




                for (int i = 0; i < list_monitores_cache_buscador.size(); i++) {
                    String Monitor = "Activo: " + list_monitores_cache_buscador.get(i).getActivo()
                            + "\nPc: " + list_monitores_cache_buscador.get(i).getPcActivo()
                            + "\nMarca: " + list_monitores_cache_buscador.get(i).getMarca()
                            + "\nPulgadas: " + list_monitores_cache_buscador.get(i).getPulgadas()
                            + "\nA??o: " + list_monitores_cache_buscador.get(i).getA??os()
                            + "\nModelo: " + list_monitores_cache_buscador.get(i).getModelo();


                    list_monitores2.add(Monitor);
                }


                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_monitores, list_monitores2);
                listaMonitor.setAdapter(adapter);

                //logica al hacer click
                listaMonitor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Monitor monitor = list_monitores_cache_buscador.get(i);

                        Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);

                        intent.putExtra("lista",list_monitores_cache);
                        intent.putExtra("lista2",list_monitores_cache_buscador);


                        Bundle bundle = new Bundle();
                        bundle.putSerializable("monitor", monitor);


                        intent.putExtras(bundle);
                        startActivity(intent);

                        //Intent intent = new Intent(ListaMonitor.this, ActualizarMonitor.class);
                        //intent.putExtra("monitor",(Monitor) list_monitores_cache.get((Integer) listaMonitor.getItemAtPosition(i)));
                        //startActivity(intent);
                        //textViewMonitor.setText("Monitor Seleccionado "+ listaMonitor.getItemAtPosition(i)+ " del a??o " + a??o [i] );
                    }
                });
                textViewMonitor.setText("");




            }else if(list_monitores_cache_buscador.size()==0) {
                list_monitores.clear();
                encontrado = 2;
                palabraBuscada= string;
                textViewMonitor.setText("No existe el equipo con"+
                        "\nActivo: "+ palabraBuscada);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_monitores, list_monitores);
                listaMonitor.setAdapter(adapter);


            }

        }






        //Toast.makeText(this, "Buscador funciono:" + string + encontrado, Toast.LENGTH_SHORT).show();



    }
}