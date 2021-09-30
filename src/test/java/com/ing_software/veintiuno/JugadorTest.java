package com.ing_software.veintiuno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class JugadorTest {
	private Jugador jugador;

	@Before
	public void setup() {
		jugador = new Jugador("jugador");
		jugador.addCarta(new Carta("3", "Corazones"));
		jugador.addCarta(new Carta("10", "Picas"));
	}

	@Test
	public void imprimirCartas() {
		// cards added to player should be card type
		assertEquals("[(3, Corazones)], [(10, Picas)]", jugador.imprimirCartas(false));
	}

	@Test
	public void imprimirCartasOcultarPrimera() {
		// cards added to player should be card type
		assertEquals("[(X, X)], [(10, Picas)]", jugador.imprimirCartas(true));
	}

	@Test
	public void sumarCartas() {
		Carta carta = new Carta("3", "Corazones");
		jugador.addCarta(carta);
		// cards should not be empty
		assertFalse(jugador.getCartas().isEmpty());
	}
}