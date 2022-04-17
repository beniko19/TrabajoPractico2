package grafos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GrafoVecinos {
    private ArrayList<HashSet<Integer>> vecinos;
    private ArrayList<HashMap<Integer, Integer>> aristas;

    public GrafoVecinos(int vertices) {
        this.vecinos = new ArrayList<HashSet<Integer>>();
        this.aristas = new ArrayList<HashMap<Integer, Integer>>();

        for (int i = 0; i < vertices; ++i) {
            this.vecinos.add(new HashSet<Integer>());
            this.aristas.add(new HashMap<Integer, Integer>());
        }
    }

    public void agregarVecino(int vertice, int vecino, int peso) {
        verificarVertice(vertice);
        verificarVertice(vecino);

        if (!verificarVecino(vertice, vecino)) {
            this.vecinos.get(vertice).add(vecino);
            this.vecinos.get(vecino).add(vertice);
            this.aristas.get(vertice).put(vecino,peso);
            this.aristas.get(vecino).put(vertice,peso);
        }
    }

    public int pesoArista(int vertice, int vecino){
        verificarVertice(vertice);
        verificarVertice(vecino);
        return this.aristas.get(vertice).get(vecino);
    }

    public Object[] obtenerVecinos(int vertice) {
        verificarVertice(vertice);
        return this.vecinos.get(vertice).toArray();
    }

    public boolean contieneVecino(int vertice, int vecino) {
        verificarVertice(vertice);
        verificarVertice(vecino);
        return this.vecinos.get(vertice).contains(vecino);
    }

    private void verificarVertice(int vertice) {
        if (this.vecinos.size() <= vertice) {
            throw new IllegalArgumentException("Los vertices deben estar entre 0 y " + (this.vecinos.size() - 1));
        }

        if (vertice < 0) {
            throw new IllegalArgumentException("El vertice no puede ser negativo: " + vertice);
        }
    }

    private boolean verificarVecino(int vertice, int vecino){
        return this.vecinos.get(vertice).contains(vecino);
    }
}

