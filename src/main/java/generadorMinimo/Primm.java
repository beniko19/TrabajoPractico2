package generadorMinimo;

import grafos.Arista;
import grafos.GrafoVecinos;

import java.util.ArrayList;
import java.util.HashSet;

public class Primm {

    private Arista arista;
    private GrafoVecinos arbolGeneradorMinimo;
    private GrafoVecinos grafo;

    public Primm(GrafoVecinos grafo) {
        this.arbolGeneradorMinimo = new GrafoVecinos(grafo.tamano());
        this.grafo = grafo;
        this.arista = new Arista();
    }

    public GrafoVecinos generarArbolMinimo(){
        int i = 1;
        while (i <= grafo.tamano()-1){

            i++;
        }
        return this.arbolGeneradorMinimo;
    }
}
