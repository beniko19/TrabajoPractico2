package app;

import generadorMinimo.Kruskal;
import grafos.BFS;
import grafos.GrafoVecinos;
import org.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {

        String archivoJSONnombre = "/Ninjas.json";
        InputStream archivoJSON = Main.class.getResourceAsStream(archivoJSONnombre);
        if (archivoJSON == null) {
            throw new NullPointerException("Cannot find resource file " + archivoJSONnombre);
        }

        JSONTokener tokener = new JSONTokener(archivoJSON);
        JSONObject ninjas = new JSONObject(tokener);
        GrafoVecinos grafo = new GrafoVecinos(ninjas.length());
        for (Integer i = 0; i < ninjas.length(); i++) {
            JSONObject ninja = new JSONObject(ninjas.get(i.toString()));
            //System.out.println(ninjas.get(i.toString()));
            JSONObject ninjaActualVecinos = (JSONObject) ninjas.get(i.toString());
            //System.out.println(ninjaActualVecinos.get("NinjasCercanos"));
            vecinosNinjaActual(i, ninjaActualVecinos.get("NinjasCercanos"), grafo);

        }

        Kruskal algoritmo = new Kruskal(grafo);
        algoritmo.generarArbolMinimo();

        //System.out.println(BFS.esConexo(grafo, 0));
        System.out.println(BFS.ordenRecorrido(grafo,0));

    }

    private static void vecinosNinjaActual(int vertice, Object ninjaActualObject, GrafoVecinos grafo) {
        JSONObject ninjaActual = (JSONObject) ninjaActualObject;
        Iterator<String> vecinos = ninjaActual.keys();
        while (vecinos.hasNext()){
            String vecinoActual = vecinos.next();
            //System.out.println("Vertice: " + vertice +" Vecino actual: "+vecinoActual + " Peso: " +ninjaActual.get(vecinoActual));
            grafo.agregarVecino(vertice, Integer.parseInt(vecinoActual),  Integer.parseInt(ninjaActual.get(vecinoActual).toString()));
        }

    }
}

