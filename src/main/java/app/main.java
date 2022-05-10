package app;

import generadorMinimo.Kruskal;
import grafos.BFS;
import grafos.GrafoLV;
import generadorMinimo.GrafoPrim;
import grafos.GrafoVecinos;

import java.util.*;

public class main  {
    public static void main(String[] args) {
        Link link = new Link();
        link.cargarGrafo("pruebaManejoJSON");
        System.out.println(link.ordenRecorridoAGMKruskal());
        System.out.println(link.ordenRecorridoAGMPrimm().toString());

    }

}
