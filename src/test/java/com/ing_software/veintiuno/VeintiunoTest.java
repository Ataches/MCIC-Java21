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
    public void setup() {
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
}
