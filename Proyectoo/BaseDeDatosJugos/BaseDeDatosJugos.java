package Proyectoo.BaseDeDatosJugos;

import Proyectoo.Jugo.Jugo;

import java.util.List;

public class BaseDeDatosJugos {
    private List<Jugo> jugos;

    public BaseDeDatosJugos(){
        jugos.add(new Jugo("Naranja", 15.0));
        jugos.add(new Jugo("Mango", 18.0));
        jugos.add(new Jugo("Fresa", 20.0));
        jugos.add(new Jugo("Piña", 16.0));
        jugos.add(new Jugo("Manzana", 17.0));
        jugos.add(new Jugo("Papaya", 15.0));
        jugos.add(new Jugo("Platano", 18.0));
        jugos.add(new Jugo("Sandia", 15.0));
        jugos.add(new Jugo("Maracuya", 20.0));
        jugos.add(new Jugo("Verde", 25.0));
    }

    public List<Jugo>getJugos(){
        return jugos;
    }

    public Jugo obtenerJugo(int indice){
        if (indice >=0 && indice<jugos.size()){
            return jugos.get(indice);
        }else {
            return null;
        }
    }
}
