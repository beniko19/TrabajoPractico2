package app;

import generadorMinimo.Kruskal;
import grafos.BFS;
import grafos.GrafoVecinos;

public class main  {
    public static void main(String[] args) {
        ManejoJSON manejoJSON = new ManejoJSON();
        GrafoVecinos grafoVecinos = manejoJSON.leerJSON("pruebaManejoJSON");
        Kruskal kruskal = new Kruskal(grafoVecinos);
        GrafoVecinos grafoMinimo = kruskal.generarArbolMinimo();

        System.out.println(BFS.ordenRecorrido(grafoMinimo,0));
    }
}
