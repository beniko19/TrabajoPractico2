package test.grafos; 

import grafos.GrafoVecinos;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** 
* GrafoVecinos Tester. 
* 
* @author <Authors name> 
* @since <pre>abr. 17, 2022</pre> 
* @version 1.0 
*/ 
public class GrafoVecinosTest {
    GrafoVecinos grafo;

@Before
    public void before() throws Exception {
    this.grafo = new GrafoVecinos(8);
    grafo.agregarVecino(2,5);
} 

@After
    public void after() throws Exception {
    this.grafo = null;
}

@Test
    public void testAgregarVecino(){

    assertTrue(grafo.contieneVecino(2,5));
    assertTrue(grafo.contieneVecino(5,2));
}

@Test
    public void testObtenerVecinos(){
    int [] vecinosDos = {5};
    int [] vecinosCinco = {2};

    assertEquals(5, grafo.obtenerVecinos(2)[0]);

}


} 
