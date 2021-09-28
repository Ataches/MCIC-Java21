package com.ing_software.veintiuno;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VentiunoTest {

    Veintiuno _ventiunoObject= new Veintiuno();

    ///Solo es posible hacer prueba de nulidad ya que la lista de jugadores esta privada, por consiguiente no se cubrir
    ///esa parte del código
    @Test
    public void getJugadorTest(){
        assertEquals(null, _ventiunoObject.getJugador("casa"));
        assertEquals(null, _ventiunoObject.getJugador("jugador"));
        assertEquals(null, _ventiunoObject.getJugador(null));
    }

}
