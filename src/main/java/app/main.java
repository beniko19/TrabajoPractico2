package app;

import generadorMinimo.Kruskal;
import grafos.BFS;
import grafos.GrafoLV;
import generadorMinimo.GrafoPrim;
import grafos.GrafoVecinos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class main  {
    public static void main(String[] args) throws FileNotFoundException {
        Link link = new Link();
        link.cargarGrafo(new FileReader("pruebaManejoJSON"));
        System.out.println(link.ordenRecorridoAGMKruskal());
        System.out.println(link.ordenRecorridoAGMPrimm());

    }

}
