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

    public static void editarComputadora(int position, Computadora computadora){
        Computadora pc = ComputadorasLista.getListaComputadoras().get(position);
        pc.setActivo(computadora.getActivo());
        pc.setMarca(computadora.getMarca());
        pc.setAño(computadora.getAño());
        pc.setCpu(computadora.getCpu());
    }

    public static  void eliminarComputadora(int posicion){
        listaComputadoras.remove(ComputadorasLista.getListaComputadoras().get(posicion));
    }

    private static String marcasComputadoras(int i){
        String marcas[]=new String[]{
                "Dell","HP","Samsung","ACER","Otros"
        };
        return marcas[i];
    }
    public static ArrayList<String> buscarPC(String activo){
        ArrayList<String> listaPCs=new ArrayList<>();
        String item = "";
        for(Computadora pc: listaComputadoras){
           if(pc.getActivo().equalsIgnoreCase(activo)){
               item="Activo: "+ pc.getActivo()+"\n"+
                       "Marca: "+marcasComputadoras(pc.getMarca())+"\n"+
                       "Año: "+pc.getAño()+"\n"+
                       "CPU: "+pc.getCpu();

               listaPCs.add(item);
               return listaPCs;
           }
        }
        return listaPCs;
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
