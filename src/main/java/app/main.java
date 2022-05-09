package app;

import generadorMinimo.Kruskal;
import grafos.BFS;
import grafos.GrafoLV;
import grafos.GrafoPrim;
import grafos.GrafoVecinos;

import java.util.*;

public class main  {
    public static void main(String[] args) {
        ManejoJSON manejoJSON = new ManejoJSON();
        GrafoVecinos grafoVecinos = manejoJSON.leerJSON("pruebaManejoJSON");

        GrafoLV grafoLV = new GrafoLV(grafoVecinos.tamano());
        ArrayList<HashMap<Integer, Integer>> aristas = grafoVecinos.obtenerAristas();
        for (int i = 0; i < aristas.size(); i++) {
            HashMap<Integer, Integer> verticeActualVecinos = aristas.get(i);
            Set<Map.Entry<Integer, Integer>> verticeActualVecinosIterable = verticeActualVecinos.entrySet();
            Iterator<Map.Entry<Integer, Integer>> vecinoConPesoActual = verticeActualVecinosIterable.iterator();
            while (vecinoConPesoActual.hasNext()){
                Map.Entry<Integer, Integer> vecinoConPeso = vecinoConPesoActual.next();
                grafoLV.agregarArista(i, vecinoConPeso.getKey(), vecinoConPeso.getValue());
            }
        }
        GrafoPrim grafoPrim = new GrafoPrim(grafoLV);
        Kruskal kruskal = new Kruskal(grafoVecinos);
        GrafoVecinos grafoMinimo = kruskal.generarArbolMinimo();
        System.out.println(BFS.ordenRecorrido(grafoMinimo, 0));
        grafoPrim.getGrafoPrim();
    }

}
