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
	public void testSumarPuntos2() {
		Carta carta = new Carta("3", "Corazones");
		Carta carta2 = new Carta("Q", "Picas");
		Carta carta3 = new Carta("As", "Picas");
		jugador.addCarta(carta);
		jugador.addCarta(carta2);
		jugador.addCarta(carta3);
		// cards added to player should be card type
		assertEquals(14, jugador.sumarPuntos());
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

	@Test
	public void testSumarPuntosString() {
		// cards added to player should be card type
		assertEquals(10, jugador.sumarPuntos("J"));
	}

	@Test
	public void testSumarPuntosString2() {
		// cards added to player should be card type
		assertEquals(10, jugador.sumarPuntos("Q"));
	}

	@Test
	public void testSumarPuntosString3() {
		// cards added to player should be card type
		assertEquals(11, jugador.sumarPuntos("As"));
	}

	@Test
	public void testImprimirStringTrue() {
		Carta carta = new Carta("3", "Corazones");
		Carta carta2 = new Carta("10", "Corazones");
		jugador.addCarta(carta);
		jugador.addCarta(carta2);
		// cards added to player should be card type
		assertEquals("[(X, X)], [(10, Corazones)]", jugador.imprimirCartas(true));
	}

	@Test
	public void testImprimirStringFalse() {
		Carta carta = new Carta("3", "Corazones");
		Carta carta2 = new Carta("10", "Picas");
		jugador.addCarta(carta);
		jugador.addCarta(carta2);
		// cards added to player should be card type
		assertEquals("[(3, Corazones)], [(10, Picas)]", jugador.imprimirCartas(false));
	}
}