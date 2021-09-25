package com.ing_software.stepdefinitions;

import static org.junit.Assert.assertFalse;

import com.ing_software.veintiuno.Carta;
import com.ing_software.veintiuno.Jugador;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;



public class StepDefinitions {
	private Jugador jugador;

	
@Dado("Dado que soy un jugador")
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
}

}
