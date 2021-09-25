package com.ing_software.veintiuno;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class JugadorTest {
	private Jugador jugador;
	
	@Before
	public void setup() {
		jugador = new Jugador("jugador");
	}
	
	@Test
	public void test() {
		Carta carta = new Carta("3", "Corazones");

		jugador.addCarta(carta);

		// cards should not be empty
		assertFalse(jugador.getCartas().isEmpty());
	}
}