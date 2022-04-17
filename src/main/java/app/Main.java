package app;

import grafos.GrafoVecinos;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        GrafoVecinos grafo = new GrafoVecinos(8);

        grafo.agregarVecino(2, 5, 10);
        grafo.agregarVecino(2, 1, 5);
        grafo.agregarVecino(2, 3, 15);
        grafo.agregarVecino(2, 4, 4);

        System.out.println(grafo.pesoArista(2,3));
    }
}
