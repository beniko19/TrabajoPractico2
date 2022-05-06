package generadorMinimo;

import grafos.GrafoVecinos;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFind {
    int[] vertices;
    HashMap<Integer, ArrayList<Integer>> raizEHijos;

    public UnionFind(GrafoVecinos grafo){
        vertices = new int [grafo.tamano()];
        this.raizEHijos = new HashMap<>();
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = i;
            raizEHijos.put(i, new ArrayList<>());
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
        if ( raizEHijos.get(ri).size() == raizEHijos.get(rj).size() ) {
            vertices[ri] = rj;
            raizEHijos.get(rj).add(ri);
        }
        else if ( raizEHijos.get(ri).size() > raizEHijos.get(rj).size() ){
            vertices[rj] = ri;
            raizEHijos.get(ri).add(rj);
        }
        else
            vertices[ri] = rj;
            raizEHijos.get(rj).add(ri);
    }
}
