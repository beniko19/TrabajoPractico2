package grafos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GrafoVecinos {
    private ArrayList<HashSet<Integer>> verticesConVecinos;
    private ArrayList<HashMap<Integer, Integer>> aristas;

    public GrafoVecinos(int vertices) {
        this.verticesConVecinos = new ArrayList<HashSet<Integer>>();
        this.aristas = new ArrayList<HashMap<Integer, Integer>>();

        for (int i = 0; i < vertices; ++i) {
            this.verticesConVecinos.add(new HashSet<Integer>());
            this.aristas.add(new HashMap<Integer, Integer>());
        }
    }

    public void agregarVecino(int vertice, int vecino, int peso) {
        verificarVertice(vertice);
        verificarVertice(vecino);
        if (!verificarVecino(vertice, vecino)) {
            this.verticesConVecinos.get(vertice).add(vecino);
            this.verticesConVecinos.get(vecino).add(vertice);
            this.aristas.get(vertice).put(vecino,peso);
            this.aristas.get(vecino).put(vertice,peso);
        }
    }

    public int pesoArista(int vertice, int vecino){
        verificarVertice(vertice);
        verificarVertice(vecino);
        return this.aristas.get(vertice).get(vecino);
    }

    public HashSet<Integer> obtenerVecinos(int vertice) {
        verificarVertice(vertice);
        return this.verticesConVecinos.get(vertice);
    }

    public boolean contieneVecino(int vertice, int vecino) {
        verificarVertice(vertice);
        verificarVertice(vecino);
        return this.verticesConVecinos.get(vertice).contains(vecino);
    }

    public int tamano(){
        return this.verticesConVecinos.size();
    }

    private void verificarVertice(int vertice) {
        if (this.verticesConVecinos.size() <= vertice) {
            throw new IllegalArgumentException("Los vertices deben estar entre 0 y " + (this.verticesConVecinos.size() - 1));
        }

        if (vertice < 0) {
            throw new IllegalArgumentException("El vertice no puede ser negativo: " + vertice);
        }

    }

    private boolean verificarVecino(int vertice, int vecino){
        return this.verticesConVecinos.get(vertice).contains(vecino);
    }

    public Integer[] obtenerVertices(){
        return (Integer[]) this.verticesConVecinos.toArray();
    }

}


