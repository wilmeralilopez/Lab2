package com.example.lab2.entity;

import java.util.ArrayList;

public class ComputadorasLista {

    public static ArrayList<Computadora> listaComputadoras = new ArrayList<>();

    public static ArrayList<Computadora> getListaComputadoras() {
        return listaComputadoras;
    }

    public void crearComputadora(Computadora computadora){
        listaComputadoras.add(computadora);

    }
    public void eliminarComputadora(Computadora computadora){
        listaComputadoras.remove(computadora);
    }

    private static String marcasComputadoras(int i){
        String marcas[]=new String[]{
                "Dell","HP","Samsung","ACER","Otros"
        };
        return marcas[i];
    }
    public static Computadora buscarComputadora(String activo){
        for(Computadora pc : listaComputadoras){
            if(pc.getActivo().equalsIgnoreCase(activo)){
                return pc;
            }
        }
        return null;
    }
}
