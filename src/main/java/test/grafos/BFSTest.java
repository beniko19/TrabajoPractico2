package test.grafos; 

import grafos.BFS;
import grafos.GrafoVecinos;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** 
* BFS Tester. 
* 
* @author <Authors name> 
* @since <pre>abr. 17, 2022</pre> 
* @version 1.0 
*/ 
public class BFSTest {

    @Test (expected=IllegalArgumentException.class)
    public void grafoNuloTest() {
        BFS.esConexo(null,0);
    }

    @Test
    public void grafoVacioTest() {
        GrafoVecinos g = new GrafoVecinos(0);
        assertTrue(BFS.esConexo(g,0));
    }

    @Test
    public void grafoNoConexoTest() {
        GrafoVecinos g = inicializarGrafo();
        assertFalse(BFS.esConexo(g,0));
    }

    @Test
    public void grafoConexoTest() {
        GrafoVecinos g = inicializarGrafo();
        g.agregarVecino(3, 4,4);
        assertTrue(BFS.esConexo(g,0));
    }

    @Test
    public void alcanzablesTest() {
        GrafoVecinos g = inicializarGrafo();
        Set<Integer> alcanzables = BFS.alcanzables(g,0);
        Assert.iguales(new int[] {0,1,2,3}, alcanzables);
    }

    private GrafoVecinos inicializarGrafo() {
        GrafoVecinos grafo = new GrafoVecinos(5);
        grafo.agregarVecino(0, 1,2);
        grafo.agregarVecino(0, 2,1);
        grafo.agregarVecino(2, 3,5);
        return grafo;
    }

} 
