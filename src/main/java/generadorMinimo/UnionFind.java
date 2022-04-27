package generadorMinimo;

import grafos.GrafoVecinos;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFind {
    int[] vertices;
    HashMap<Integer, Integer> raizEHijos;

    public UnionFind(GrafoVecinos grafo){
        vertices = new int [grafo.tamano()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = i;
        }
        this.raizEHijos = new HashMap<>();
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
        if (raizEHijos.get(ri) == raizEHijos.get(rj))
            vertices[ri] = rj;
        else if (raizEHijos.get(ri) > raizEHijos.get(rj))
            vertices[rj] = ri;
        else
            vertices[ri] = rj;
    }
}
