package test.app; 

import app.JsonLecturaConGrafo;
import org.junit.Assert;
import org.junit.Test;

/** 
* JsonLecturaConGrafo Tester. 
* 
* @author <Authors name> 
* @since <pre>abr. 23, 2022</pre> 
* @version 1.0 
*/ 
public class JsonLecturaConGrafoTest {

@Test
    public void testCargarArchivoEnObjeto(){
        JsonLecturaConGrafo lecturaConGrafo = new JsonLecturaConGrafo("Ninjas.json");
        Assert.assertNotNull(lecturaConGrafo);
    }
} 
