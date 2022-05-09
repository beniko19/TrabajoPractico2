package app;

import grafos.GrafoVecinos;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManejoJSONTest {

    @Test
    void leerJSON() {
        ManejoJSON manejoJSON = new ManejoJSON();
        GrafoVecinos grafoVecinos = manejoJSON.leerJSON("pruebaManejoJSON");
        int cantidadDevertices = 9;
        Assert.assertEquals(cantidadDevertices, grafoVecinos.tamano());
    }
}