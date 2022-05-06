package generadorMinimo;

import grafos.Arista;
import grafos.GrafoVecinos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Primm {

    private Arista arista;
    private GrafoVecinos arbolGeneradorMinimo;
    private GrafoVecinos grafo;
    private boolean[] marcados;
    ArrayList<Integer> verticesPendientes;

    public Primm(GrafoVecinos grafo) {
        this.arbolGeneradorMinimo = new GrafoVecinos(grafo.tamano());
        this.grafo = grafo;
        this.arista = new Arista();
        this.arista.setPeso(0);
        //this.marcados = new boolean[grafo.tamano()];
        this.verticesPendientes = new ArrayList<>();
    }

    public GrafoVecinos generarArbolMinimo(int source){

        /*for (int i = 0; i < grafo.tamano(); i++) {
            encontrarAristaMenorPesoDeVertice(i, verticesPendientes);
            arista.setPeso(0);
        }*/
        verticesPendientes.add(source);
        while ( verticesPendientes.size() != 0){
            Iterator<Integer> vertices = verticesPendientes.iterator();
            buscarAristaMenorPeso(vertices);
            arista.setPeso(0);
        }
        return this.arbolGeneradorMinimo;
    }

    private void buscarAristaMenorPeso(Iterator<Integer> vertices) {
        while (vertices.hasNext()){
            int verticeActual = vertices.next();
            HashSet<Integer> vecinos = grafo.obtenerVecinos(verticeActual);
            buscarAristaMenorPesoAxiliar(verticeActual, vecinos);
        }
    }

    private void buscarAristaMenorPesoAxiliar(Integer verticeActual, HashSet<Integer> vecinos) {
        Iterator<Integer> iterarVecinos = vecinos.iterator();

        while ( iterarVecinos.hasNext() ) {
            int vecinoActual = iterarVecinos.next();
            if( (arista.getPeso() > grafo.pesoArista(verticeActual, vecinoActual) || arista.getPeso() == 0) ){
                if ( !arbolGeneradorMinimo.sonVecinos(verticeActual, vecinoActual) ){
                    this.arista.setVertice1(verticeActual);
                    this.arista.setVertice2(vecinoActual);
                    this.arista.setPeso(grafo.pesoArista(verticeActual, vecinoActual));
                    iterarVecinos.remove();
                }
                else{
//                    vecinos.remove(vecinoActual);
                      iterarVecinos.remove();
                }
            }
            if ( (vecinos.size() <= 2 && grafo.obtenerVecinos(verticeActual).size() > 2) || (vecinos.size() < 2 && grafo.obtenerVecinos(verticeActual).size() == 2) ){
                this.verticesPendientes.remove(verticeActual);
            }
        }
        verticesPendientes.add(this.arista.getVertice2());
        //vecinos.remove(this.arista.getVertice2());

    /*private void encontrarAristaMenorPesoDeVertice(int vertice, ArrayList<Integer> verticesPendientes) {
        if(!verticesPendientes.contains(vertice)){
            verticesPendientes.add(vertice);
        }
        for (Integer verticeActual: verticesPendientes
             ) {
            HashSet<Integer> vecinos = grafo.obtenerVecinos(verticeActual);
            for (Integer vecino: vecinos
            ) {
                if( (arista.getPeso() > grafo.pesoArista(vertice, vecino) || arista.getPeso() == 0) && !arbolGeneradorMinimo.sonVecinos(vertice, vecino) ){
                    this.arista.setVertice1(vertice);
                    this.arista.setVertice2(vecino);
                    this.arista.setPeso(grafo.pesoArista(vertice, vecino));
                    verticesPendientes.add(vecino);
                    vecinos.remove(vecino);
                    if (vecinos.size() < 2){
                        verticesPendientes.remove(vertice);
                    }
                }
            }
        }*/
    }
}
