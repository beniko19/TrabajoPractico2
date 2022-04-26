package test.app; 

import app.LecturaDeJsonAGrafo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/** 
* LecturaDeJsonAGrafo Tester. 
* 
* @author <Martin Gutierrez>
* @since <pre>abr. 25, 2022</pre> 
* @version 1.0 
*/ 
public class LecturaDeJsonAGrafoTest {
    LecturaDeJsonAGrafo lecturaDeJsonAGrafo;



@Before
public void before(){
    this.lecturaDeJsonAGrafo = new LecturaDeJsonAGrafo("ninjas.JSON");
}
@Test
public void constructorTest() throws Exception {

    Assert.assertNotNull(this.lecturaDeJsonAGrafo);
} 

@Test
public void testObtenerGrafo() throws Exception { 
    Assert.assertNotNull(this.lecturaDeJsonAGrafo.obtenerGrafo());
} 


} 
