package com.ing_software.veintiuno;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JugadorTest {

	private Jugador jugador;

	@Before
	public void setup() {
		jugador = new Jugador("jugador");
	}

	@Test
	public void testGetCarta() {
		Carta carta = new Carta("3", "Corazones");
		jugador.addCarta(carta);
		// cards added to player should be card type
		assertEquals(carta.getClass(), jugador.getCartas().get(jugador.getCartas().size() - 1).getClass());
	}

	@Test
	public void testGetCarta2() {
		Carta carta = new Carta("3", "Corazones");
		jugador.addCarta(carta);
		// cards should not be empty
		assertFalse(jugador.getCartas().isEmpty());
	}

	@Test
	public void testSumarPuntos() {
		Carta carta = new Carta("3", "Corazones");
		Carta carta2 = new Carta("J", "Picas");
		jugador.addCarta(carta);
		jugador.addCarta(carta2);
		// cards added to player should be card type
		assertEquals(13, jugador.sumarPuntos());
	}

	@Test
	public void testGetPuntaje() {
		Carta carta = new Carta("As", "Corazones");
		Carta carta2 = new Carta("Q", "Picas");
		jugador.addCarta(carta);
		jugador.addCarta(carta2);
		jugador.sumarPuntos();
		// cards added to player should be card type
		assertEquals(21, jugador.getPuntaje());
	}

	@Test
	public void testGetNombre() {
		// cards added to player should be card type
		assertEquals("jugador", jugador.getNombre());
	}
}