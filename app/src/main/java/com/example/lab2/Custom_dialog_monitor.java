package com.example.lab2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class Custom_dialog_monitor extends AppCompatDialogFragment  {
    EditText editText;
    Custom_DialogInterface dialogInterface;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {




        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_buscar_monitor, null);
        builder .setView(view)
                .setTitle("Monitor")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String Monitor = editText.getText().toString();
                        dialogInterface.applyTexts((String) Monitor);



                    }
                });

        editText = view.findViewById(R.id.activo_Monitor);


        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        dialogInterface = (Custom_DialogInterface) context;
    }

    public interface Custom_DialogInterface{
        void applyTexts(String string);


    }
}
