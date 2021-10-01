package com.ing_software.veintiuno;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class VeintiunoTest {

    private Veintiuno veintiuno;
    private final List<Jugador> jugadores = new ArrayList<>();
    private Jugador jugador;
    private Jugador casa;

    @Before
    public void setup() throws Exception{
        GameAsker gameAsker = Mockito.mock(GameAsker.class);
        veintiuno = new Veintiuno(gameAsker);
        veintiuno.setJugadores(jugadores);
        jugador = Mockito.mock(Jugador.class);
        casa = Mockito.mock(Jugador.class);
        jugadores.add(jugador);
        jugadores.add(casa);
        when(jugador.getNombre()).thenReturn("jugador");
        when(casa.getNombre()).thenReturn("casa");
        when(gameAsker.stringAsk()).thenReturn("no");
    }

    @Test
    public void empezarJuego() {
        when(jugador.getPuntaje()).thenReturn(0);
        when(casa.getPuntaje()).thenReturn(0);
        assertEquals("Gano la casa", veintiuno.empezarJuego());
    }

/* CODIGO ANTERIOR, REVISAR

    Veintiuno _ventiunoObject= new Veintiuno();
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

    @Test
    public void simulateGetJugadorTest() throws UnsupportedEncodingException {
        String _userAnswer= "Si\n";
        _ventiunoObject.empezarJuego();
        assertEquals(null, _ventiunoObject.getJugador("casa"));
        System.setIn(new ByteArrayInputStream(_userAnswer.getBytes("UTF-8")));
    }
 */
}
