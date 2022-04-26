package test.grafos; 

import app.LecturaDeJsonAGrafo;
import grafos.GrafoVecinos;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.File;

/** 
* ImagenGrafo Tester. 
* 
* @author <Authors name> 
* @since <pre>abr. 25, 2022</pre> 
* @version 1.0 
*/ 
public class ImagenGrafoTest {
    ImagenGrafo imagenGrafo;
    GrafoVecinos grafoVecinos;

@Before
public void before() throws Exception {
    LecturaDeJsonAGrafo lecturaDeJsonAGrafoTest = new LecturaDeJsonAGrafo("ninjas.JSON");
    this.imagenGrafo = new ImagenGrafo();
    this.grafoVecinos = lecturaDeJsonAGrafoTest.obtenerGrafo();
    this.grafoVecinos.obtenerGrafoImagen();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: obtenerGrafoImagen() 
* 
*/ 
@Test
public void testObtenerGrafoImagen() throws Exception {
    imagenGrafo.obtenerGrafoImagen();
    File imagen = new File("src/graph.jpg");
    Assert.assertEquals(true, imagen.exists());

}
} 
