package generadorMinimo;

import app.ManejoJSON;
import generadorMinimo.Kruskal;
import grafos.Arista;
import grafos.BFS;
import grafos.GrafoVecinos;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

/** 
* Kruskal Tester. 
* 
* @author <Authors name> 
* @since <pre>abr. 23, 2022</pre> 
* @version 1.0 
*/ 
public class KruskalTest {
     Kruskal kruskalAlgoritmo;
     GrafoVecinos grafoVecinos;
     GrafoVecinos AGM;
    @Before
    public void before(){
        ManejoJSON manejoJSON = new ManejoJSON();
        grafoVecinos = manejoJSON.leerJSON("pruebaManejoJSON");
        kruskalAlgoritmo = new Kruskal(grafoVecinos);
    }

    @Test
    public void testCompararOrdenDeRecorrido() throws Exception {
        this.AGM = kruskalAlgoritmo.generarArbolMinimo();
        ArrayList<Integer> expectedOrdenRecorridoDesdeVertice0 = new ArrayList<>();
        expectedOrdenRecorridoDesdeVertice0.add(0);
        expectedOrdenRecorridoDesdeVertice0.add(1);
        expectedOrdenRecorridoDesdeVertice0.add(7);
        expectedOrdenRecorridoDesdeVertice0.add(6);
        expectedOrdenRecorridoDesdeVertice0.add(5);
        expectedOrdenRecorridoDesdeVertice0.add(2);
        expectedOrdenRecorridoDesdeVertice0.add(3);
        expectedOrdenRecorridoDesdeVertice0.add(8);
        expectedOrdenRecorridoDesdeVertice0.add(4);
        Assert.assertEquals(expectedOrdenRecorridoDesdeVertice0, BFS.ordenRecorrido(AGM,0));
    }

    @Test
    public void testBuscarAristaDeMenorPeso(){
        kruskalAlgoritmo.buscarAristaMenorPesoDeGrafo(grafoVecinos);
        Arista arista = new Arista();
        arista.setPeso(1);
        arista.setVertice1(6);
        arista.setVertice2(7);
        Assert.assertEquals(arista.getPeso(), kruskalAlgoritmo.getArista().getPeso());
        Assert.assertEquals(arista.getVertice1(), kruskalAlgoritmo.getArista().getVertice1());
        Assert.assertEquals(arista.getVertice2(), kruskalAlgoritmo.getArista().getVertice2());
    }
} 
