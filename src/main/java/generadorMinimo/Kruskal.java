package generadorMinimo;

import grafos.GrafoVecinos;

import java.util.HashSet;

public class Kruskal {
    private HashSet<Integer> aristas;
    private GrafoVecinos arbolGeneradorMinimo;
    private UnionFind union_find;
    private GrafoVecinos grafo;

    public Kruskal(GrafoVecinos grafo){
        UnionFind union_find = new UnionFind(grafo);
        this.grafo = grafo;
    }



}
