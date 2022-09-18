package com.example.lab2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;

import com.example.lab2.entity.Computadora;

import java.util.ArrayList;

public class ComputadoraActivity extends AppCompatActivity {


    ArrayList<Computadora> computadoras = new ArrayList<>();
    public String texto_buscar_comp = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computadora);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.appbar_computadora, menu);

        return true;
    }

    public void btnMenuComputadoraAction(MenuItem menuItem) {
        Log.d("msg", "clic texto");
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        View view = findViewById(R.id.btn_menu_computadora);
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.appbar_submenu_computadora, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem1 -> {
            switch (menuItem1.getItemId()) {
                case R.id.btn_buscar_computadora:
                    Log.d("msg", "btn_buscar_computadora pressed");
                    alertDialog.setTitle("Computadora");
                    final EditText input = new EditText(this);
                    alertDialog.setView(input);

                    alertDialog.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            texto_buscar_comp = input.getText().toString();
                            Log.d("msg","Texto "+ texto_buscar_comp);
                        }
                    });
                    alertDialog.setNegativeButton("Cancelar", (dialogInterface, i) ->
                            Log.d("msg","btn cancelar presionado"));
                    alertDialog.show();



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
}