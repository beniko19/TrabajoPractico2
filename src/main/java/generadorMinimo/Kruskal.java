package generadorMinimo;

import grafos.Arista;
import grafos.GrafoVecinos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Kruskal {
    private Arista arista;
    private GrafoVecinos arbolGeneradorMinimo;
    private GrafoVecinos grafo;
    private UnionFind union_find;

    public Kruskal(GrafoVecinos grafo){
        this.union_find = new UnionFind(grafo);
        this.arbolGeneradorMinimo = new GrafoVecinos(grafo.tamano());
        this.grafo = grafo;
        this.arista = new Arista();
    }

    public GrafoVecinos generarArbolMinimo(){
        int i = 1;
        while (i <= grafo.tamano()-1){
            buscarAristaMenorPesoDeGrafo(grafo);
            i++;
            union_find.union(arista.getVertice1(), arista.getVertice2());
            this.arbolGeneradorMinimo.agregarVecino(arista.getVertice1(), arista.getVertice2(), arista.getPeso());
            arista.setPeso(0);
            }
        return this.arbolGeneradorMinimo;
    }

    void buscarAristaMenorPesoDeGrafo(GrafoVecinos grafo) {
        for (int i = 0; i < grafo.tamano(); i++) {
            HashSet<Integer> vecinosVertice = grafo.obtenerVecinos(i);
            buscarAristaMenorPesoDeVertice(i, vecinosVertice, grafo);
        }
    }

    private void buscarAristaMenorPesoDeVertice(int vertice, HashSet<Integer> vecinosVertice, GrafoVecinos grafo) {
        Iterator<Integer> vecinos = vecinosVertice.iterator();
        while (vecinos.hasNext()){
            int vecino = vecinos.next();
            if((arista.getPeso() > grafo.pesoArista(vertice, vecino) || arista.getPeso() == 0) && !union_find.find(vertice, vecino)){
                arista.setPeso(grafo.pesoArista(vertice, vecino));
                arista.setVertice1(vertice);
                arista.setVertice2(vecino);
            }
        }
    }
    Arista getArista(){
        return this.arista;
    }

    public String[][] toArray2D(){
        //ACA LO INICIAMOS CON [NUMERO DE VERTICES]  [3 FIJO: ESPIA/ESPIA/PESO]
        String[][] grafo = new String[((this.arbolGeneradorMinimo.tamano())-1)*2][3];

        int x = 0;
        //INICIAMOS UN FOR QUE RECORRA LOS VERTICES DEL GRAFO.
        for (int i = 0; i < this.arbolGeneradorMinimo.tamano(); i++) {
            HashSet<Integer> vecinos = this.arbolGeneradorMinimo.obtenerVecinos(i);
            Iterator<Integer> iteratorVecinos = vecinos.iterator();

            while (iteratorVecinos.hasNext()){
                int vecinoActual = iteratorVecinos.next();
                grafo[x][0] = String.valueOf(vecinoActual);
                grafo[x][1] = String.valueOf(i);
                grafo[x][2] = String.valueOf(arbolGeneradorMinimo.pesoArista(i,vecinoActual));
                x++;
            }


        }
        return grafo;
    }
}
