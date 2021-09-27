package com.cucumber.stepDefinition;

import static org.junit.Assert.assertFalse;

import com.ing_software.veintiuno.Carta;
import com.ing_software.veintiuno.Jugador;

import com.ing_software.veintiuno.Veintiuno;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;



public class jugadorSteps {
	private Jugador jugador;
	private Veintiuno veintiuno;
	public int puntaje;
	public boolean estado;

/*	@Dado("Dado que soy un jugador")
	@Given("I am a player")
	public void i_am_a_player() {
		jugador = new Jugador("jugador");
	}

	@Cuando("recibo mis dos primeras cartas {carta}, {carta}")
	@When("I receive my first two cards")
	public void i_fill_the_name_field_with(Carta primeraCarta, Carta segundaCarta) {
		jugador.addCarta(primeraCarta);
		jugador.addCarta(segundaCarta);
	}

	@Entonces("mi mazo no debe estar vacio")
	@Then("my deck should not be empty")
	public void the_field_email_should_not_be_empty() {
		assertFalse(jugador.getCartas().isEmpty());
	}*/

	@Given("un jugador")
	public void un_jugador() {
		veintiuno = new Veintiuno();
		veintiuno.jugadores.add(new Jugador("jugador"));
		veintiuno.getJugador("jugador");
	}

	@When("el juego inicia")
	public void el_juego_inicia() {
		veintiuno.generarMazo();
		assertFalse(veintiuno.mazo.isEmpty());
	}

	@Then("el jugador tiene dos cartas")
	public void el_jugador_tiene_dos_cartas() {
		veintiuno.jugar("jugador");
		assert(veintiuno.getJugador("jugador").getCartas().size() == 2);
	}
//--------------------------------------------------------------------------------------------

	@When("el jugador solicita una carta")
	public void el_jugador_solicita_una_carta() {
		veintiuno.jugadorContinua = true;
		veintiuno.jugar("jugador");
	}

	@When("se valida el {int}")
	public void se_valida_el_puntaje(int puntaje) {
		puntaje = veintiuno.getJugador("jugador").getPuntaje();
		if(!(veintiuno.getJugador("jugador").sumarPuntos()<=21))
			estado = true;
	}

	@Then("se reparte una carta : {string}")
	@Then("se reparte una carta : true")
	@Then("se reparte una carta : false")
	public void se_reparte_una_carta() {
		if(estado)
			veintiuno.getJugador("jugador").addCarta(veintiuno.sacarCartaMazo());
	}

}
