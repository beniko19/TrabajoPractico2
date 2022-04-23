package app;

import generadorMinimo.Kruskal;
import grafos.BFS;
import grafos.GrafoVecinos;
import org.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class JsonLecturaConGrafo {
        String nombreArchivo;
        InputStream archivoJson;
        GrafoVecinos grafo;
        public JsonLecturaConGrafo(String nombreArchivo) {
            this.nombreArchivo = "/"+nombreArchivo;
            this.archivoJson = JsonLecturaConGrafo.class.getResourceAsStream(this.nombreArchivo);
            if(this.archivoJson == null){
                throw new RuntimeException("Archivo no encontrado: "+nombreArchivo);
            }
            else{
                cargarNinjasEnGrafo();
            }
        }

    private void cargarNinjasEnGrafo() {
        JSONTokener tokener = new JSONTokener(this.archivoJson);
        JSONObject ninjas = new JSONObject(tokener);
        this.grafo = new GrafoVecinos(ninjas.length());
        for (Integer i = 0; i < ninjas.length(); i++) {
            JSONObject ninja = new JSONObject(ninjas.get(i.toString()));
            //System.out.println(ninjas.get(i.toString()));
            JSONObject ninjaActualVecinos = (JSONObject) ninjas.get(i.toString());
            //System.out.println(ninjaActualVecinos.get("NinjasCercanos"));
            vecinosNinjaActual(i, ninjaActualVecinos.get("NinjasCercanos"), grafo);
        }
    }

    private void vecinosNinjaActual(int vertice, Object ninjaActualObject, GrafoVecinos grafo) {
        JSONObject ninjaActual = (JSONObject) ninjaActualObject;
        Iterator<String> vecinos = ninjaActual.keys();
        while (vecinos.hasNext()){
            String vecinoActual = vecinos.next();
            //System.out.println("Vertice: " + vertice +" Vecino actual: "+vecinoActual + " Peso: " +ninjaActual.get(vecinoActual));
            grafo.agregarVecino(vertice, Integer.parseInt(vecinoActual),  Integer.parseInt(ninjaActual.get(vecinoActual).toString()));
        }
    }

    public GrafoVecinos obtenerGrafo(){
            return this.grafo;
    }
}

