package com.ing_software.veintiuno;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class VentiunoTest {

    private static GameAsker _gameAsker = new GameAsker(System.in);

    Veintiuno _ventiunoObject= new Veintiuno(_gameAsker);
    private Carta carta;

    @Before
    public void setupTest3() throws Exception{

        _ventiunoObject.generarMazo();
        carta = new Carta("1", "A");
    }

    @Test
    public void generarMazo() {
        assertEquals(52, _ventiunoObject.generarMazo().size());
    }

    @Test
    public void generarMazo2() {
        assertNotEquals(104, _ventiunoObject.generarMazo().size());
    }

    @Test
    public void sacarmazo() {
        assertEquals(carta.getClass(), _ventiunoObject.sacarCartaMazo().getClass());
    }

    ///Solo es posible hacer prueba de nulidad ya que la lista de jugadores esta privada, por consiguiente no se cubrir
    ///esa parte del código
    @Test
    public void getJugadorFromObjectTest(){

        Jugador _jugadorCasa= new Jugador("casa");
        Jugador _jugadorJugador= new Jugador("jugador");
        assertEquals("casa", _jugadorCasa.getNombre());
        assertEquals("jugador", _jugadorJugador.getNombre());

    }

    @Before
    public void setupTest4() throws Exception{
        _ventiunoObject.generarMazo();
    }

 


    @Test
    public void imprimirCartasTest() throws UnsupportedEncodingException {
        String mensaje = "";
        mensaje += "\nCartas casa: \n " + "--";
        mensaje += "\n\nCartas jugador: \n" + "--";
        mensaje += "\nPuntaje jugador: " + "0";
        assertEquals(mensaje,_ventiunoObject.imprimirCartas());
    }

    @Test
    public void imprimirCartasTest2() throws UnsupportedEncodingException {

        Jugador _jugadorCasa= new Jugador("casa");
        Jugador _jugadorJugador= new Jugador("jugador");
        _jugadorCasa.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorCasa.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorCasa.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorCasa.sumarPuntos();

        _jugadorJugador.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorJugador.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorJugador.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorJugador.sumarPuntos();
        String mensaje = "";
        mensaje += "\nCartas casa: \n " + "--";
        mensaje += "\n\nCartas jugador: \n" + "--";
        mensaje += "\nPuntaje jugador: " + "0";
        assertEquals(mensaje,_ventiunoObject.imprimirCartas());
    }


    @Test
    public void imprimirResultadoTest() throws UnsupportedEncodingException {

        Jugador _jugadorCasa= new Jugador("casa");
        Jugador _jugadorJugador= new Jugador("jugador");
        _jugadorCasa.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorCasa.sumarPuntos();

        _jugadorJugador.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorJugador.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorJugador.addCarta(_ventiunoObject.sacarCartaMazo());
        _jugadorJugador.addCarta(_ventiunoObject.sacarCartaMazo());

        _jugadorJugador.sumarPuntos();

        assertEquals("Gano la casa",_ventiunoObject.imprimirResultado());
    }

   

}
