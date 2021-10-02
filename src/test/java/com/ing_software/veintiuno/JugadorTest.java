package com.ing_software.veintiuno;

import static org.junit.Assert.assertEquals;

import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.annotation.processing.SupportedOptions;

@RunWith(MockitoJUnitRunner.class)
public class JugadorTest {
	private Jugador jugador;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		jugador = new Jugador("jugador");
		jugador.addCarta(new Carta("3", "Corazones"));
		jugador.addCarta(new Carta("J", "Picas"));
		jugador.addCarta(new Carta("As", "Picas"));
	}

	@Test
	public void imprimirCartas() {
		assertEquals("[(3, Corazones)], [(J, Picas)], [(As, Picas)]", jugador.imprimirCartas(false));
	}

	@Test
	public void imprimirCartasOcultarPrimera() {
		assertEquals("[(X, X)], [(J, Picas)], [(As, Picas)]", jugador.imprimirCartas(true));
	}

	@Test
	public void getPuntaje() {
		assertEquals("jugador",jugador.getNombre());
		assertEquals(14,jugador.sumarPuntos());
		assertEquals(14,jugador.getPuntaje());
	}
}