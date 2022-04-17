package app;

import grafos.GrafoVecinos;

public class Main {
    public static void main(String[] args) {

        GrafoVecinos grafo = new GrafoVecinos(8);

        grafo.agregarVecino(2,5);
        System.out.println(grafo.obtenerVecinos(2)[0]);

    }
}
