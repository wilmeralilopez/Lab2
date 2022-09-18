package com.example.lab2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<TecladoElemento> listaTeclados;
    Context context;

    public RecyclerViewAdapter(List<TecladoElemento> listaTeclados, Context context){
        this.listaTeclados = listaTeclados;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_teclado, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.textViewTecActivo.setText(listaTeclados.get(i).getActivo());
        holder.textViewTecAnho.setText(listaTeclados.get(i).getAño());
        holder.textViewTecIdioma.setText(listaTeclados.get(i).getIdioma());
        holder.textViewTecMarca.setText(listaTeclados.get(i).getMarca());
        holder.textViewTecPC.setText(listaTeclados.get(i).getPc());
        holder.textViewTecModelo.setText(listaTeclados.get(i).getModelo());

    }

    @Override
    public int getItemCount() {
        return listaTeclados.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTecActivo;
        TextView textViewTecPC;
        TextView textViewTecMarca;
        TextView textViewTecAnho;
        TextView textViewTecIdioma;
        TextView textViewTecModelo;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            textViewTecActivo = itemView.findViewById(R.id.textViewTecActivo);
            textViewTecPC = itemView.findViewById(R.id.textViewTecPC);
            textViewTecMarca = itemView.findViewById(R.id.textViewTecMarca);
            textViewTecAnho = itemView.findViewById(R.id.textViewTecAnho);
            textViewTecIdioma = itemView.findViewById(R.id.textViewTecIdioma);
            textViewTecModelo = itemView.findViewById(R.id.textViewTecModelo);

        }
    }
}
