package com.example.lab2.entity;

import java.util.ArrayList;

public class ComputadorasLista {

    public static ArrayList<Computadora> listaComputadoras = new ArrayList<>();

    public static ArrayList<Computadora> getListaComputadoras() {
        return listaComputadoras;
    }

    public static void crearComputadora(Computadora computadora){
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
    public static ArrayList<String> computadorasDescripcion(){
        ArrayList<String> listaDescripcionesPC=new ArrayList<>();
        String item = "";
        for(Computadora pc: listaComputadoras){
            item="Activo: "+ pc.getActivo()+"\n"+
            "Marca: "+marcasComputadoras(pc.getMarca())+"\n"+
            "Año: "+pc.getAño()+"\n"+
            "CPU: "+pc.getCpu();

            listaDescripcionesPC.add(item);
        }
        return listaDescripcionesPC;
    }
}
