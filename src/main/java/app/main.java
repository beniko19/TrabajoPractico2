package app;

import generadorMinimo.Kruskal;
import grafos.BFS;
import grafos.GrafoLV;
import generadorMinimo.GrafoPrim;
import grafos.GrafoVecinos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class main  {
    public static void main(String[] args) throws FileNotFoundException {
        Link link = new Link();
        File file = new File("pruebaManejoJSON");
        link.cargarGrafo(file);
        System.out.println(link.ordenRecorridoAGMKruskal());
        System.out.println(link.ordenRecorridoAGMPrimm());
    }

}
