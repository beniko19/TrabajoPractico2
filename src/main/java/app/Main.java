package app;

import grafos.BFS;
import grafos.GrafoVecinos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        GrafoVecinos grafo = new GrafoVecinos(8);
        grafo.agregarVecino(0,4,5);
        grafo.agregarVecino(4,7,1);
        grafo.agregarVecino(7,3,4);
        grafo.agregarVecino(3,6,10);
        grafo.agregarVecino(6,5,2);
        grafo.agregarVecino(5,1,11);
        grafo.agregarVecino(1,2,9);

        System.out.println(BFS.esConexo(grafo, 3));

        System.out.println(BFS.ordenRecorrido(grafo, 7));

    }
}
