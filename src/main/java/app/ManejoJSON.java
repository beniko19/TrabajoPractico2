package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import grafos.GrafoVecinos;

import java.io.*;

public class ManejoJSON {

    public static void generarJson(String nombreArchivoGuardar, GrafoVecinos grafoVecinos){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(grafoVecinos);
        try{
            FileWriter writer = new FileWriter(nombreArchivoGuardar);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static GrafoVecinos leerJSON(FileReader ArchivoCargar){
        Gson gson = new Gson();
        GrafoVecinos grafo = null;
        BufferedReader reader = new BufferedReader(ArchivoCargar);
        grafo = gson.fromJson(reader, GrafoVecinos.class);
        return grafo;
    }
}
