package generadorMinimo;

import grafos.GrafoVecinos;

import java.util.ArrayList;

public class UnionFind {
    int[] vertices;

    public UnionFind(GrafoVecinos grafo){
        vertices = new int [grafo.tamano()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = i;
        }
    }

    public int encontrarRaiz(int i){
        while(vertices[i] != i){
            i = vertices[i];
        }
        return i;
    }

    public boolean find(int i, int j){
        return encontrarRaiz(i) == encontrarRaiz(j);
    }

    public void union(int i, int j){
        int ri = encontrarRaiz(i);
        int rj = encontrarRaiz(j);
        vertices[ri] = rj;
    }
}
