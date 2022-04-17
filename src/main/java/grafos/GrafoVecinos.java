package grafos;

import java.util.ArrayList;
import java.util.HashSet;

public class GrafoVecinos {
    private ArrayList<HashSet<Integer>> vecinos;

    public GrafoVecinos(int vertices) {
        this.vecinos = new ArrayList<HashSet<Integer>>();

        for (int i = 0; i < vertices; ++i) {
            this.vecinos.add(new HashSet<Integer>());
        }
    }

    public void agregarVecino(int vertice, int vecino) {
        verificarVertice(vertice);
        verificarVertice(vertice);

        if (!verificarVecino(vertice, vecino)) {
            this.vecinos.get(vertice).add(vecino);
            this.vecinos.get(vecino).add(vertice);
        }
    }

    public Object[] obtenerVecinos(int vertice) {
        return this.vecinos.get(vertice).toArray();
    }

    public boolean contieneVecino(int vertice, int vecino) {
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

