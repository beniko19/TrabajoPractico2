package test.generadorMinimo; 

import app.JsonLecturaConGrafo;
import generadorMinimo.Kruskal;
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
    JsonLecturaConGrafo lecturaConGrafo;
    Kruskal kruskal;
    GrafoVecinos arbolMinimo;
    @Before
    public void before(){
        this.lecturaConGrafo = new JsonLecturaConGrafo("Ninjas.json");
        this.kruskal = new Kruskal(lecturaConGrafo.obtenerGrafo());
        this.arbolMinimo = kruskal.generarArbolMinimo();
    }

    @Test
    public void testCompararOrdenDeRecorrido() throws Exception {
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
        Assert.assertEquals(expectedOrdenRecorridoDesdeVertice0, BFS.ordenRecorrido(this.arbolMinimo,0));

    }
} 
