package app;

import generadorMinimo.Kruskal;
import generadorMinimo.UnionFind;
import grafos.BFS;
import grafos.GrafoVecinos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        GrafoVecinos grafo = new GrafoVecinos(9);
        grafo.agregarVecino(0,1,4);
        grafo.agregarVecino(0,7,8);
        grafo.agregarVecino(1,2,8);
        grafo.agregarVecino(1,7,12);
        grafo.agregarVecino(2,3,6);
        grafo.agregarVecino(2,8,3);
        grafo.agregarVecino(2,5,4);
        grafo.agregarVecino(3,5,13);
        grafo.agregarVecino(3,4,9);
        grafo.agregarVecino(5,4,10);
        grafo.agregarVecino(6,5,3);
        grafo.agregarVecino(7,6,1);
        grafo.agregarVecino(7,8,6);
        grafo.agregarVecino(8,6,5);

        Kruskal algoritmoKruskal = new Kruskal(grafo);
        GrafoVecinos arbolMinimo = algoritmoKruskal.generarArbolMinino();

        System.out.println(BFS.ordenRecorrido(arbolMinimo, 0));

    }
}
