package com.ing_software.veintiuno;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class VentiunoTest {

    Veintiuno _ventiunoObject= new Veintiuno();

    Veintiuno _ventiunoObjectMock= mock(Veintiuno.class);

    @BeforeAll
    public static void setUpClass() throws UnsupportedEncodingException {
        InputStream old = System.in;
    }

    ///Solo es posible hacer prueba de nulidad ya que la lista de jugadores esta privada, por consiguiente no se cubrir
    ///esa parte del código
    @Test
    public void getJugadorTest(){
        assertEquals(null, _ventiunoObject.getJugador("casa"));
        assertEquals(null, _ventiunoObject.getJugador("jugador"));
        assertEquals(null, _ventiunoObject.getJugador(null));
    }

    @Test
    public void simulateGetJugadorTest() throws UnsupportedEncodingException {
        String _userAnswer= "Si\n";
        _ventiunoObject.empezarJuego();
        assertEquals(null, _ventiunoObject.getJugador("casa"));
        System.setIn(new ByteArrayInputStream(_userAnswer.getBytes("UTF-8")));
    }

    @Test
    public void sacarCartaMazo(){
       System.out.println(_ventiunoObject.sacarCartaMazo());
    }

}
