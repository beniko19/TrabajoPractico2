package app;

import generadorMinimo.Kruskal;
import generadorMinimo.Primm;
import grafos.BFS;
import grafos.GrafoVecinos;

public class main  {
    public static void main(String[] args) {
        ManejoJSON manejoJSON = new ManejoJSON();
        GrafoVecinos grafoVecinos = manejoJSON.leerJSON("pruebaManejoJSON");
        //Kruskal kruskal = new Kruskal(grafoVecinos);
        //GrafoVecinos grafoMinimo = kruskal.generarArbolMinimo();

        Primm primm = new Primm(grafoVecinos);
        GrafoVecinos grafoMinimo = primm.generarArbolMinimo(0);

        System.out.println(BFS.ordenRecorrido(grafoMinimo,0));
    }
}
