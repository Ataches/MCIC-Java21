package com.ing_software.veintiuno;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class JugadorTest {
	private Jugador jugador;
	
	@Before
	public void setup() throws InterruptedException{
		jugador = new Jugador("jugador");
	}
	
	@Test
	public void test() throws InterruptedException {
		Carta carta = new Carta("3", "Corazones");

		jugador.addCarta(carta);

		// cards should not be empty
		assertTrue(!jugador.getCartas().isEmpty());
	}
}
