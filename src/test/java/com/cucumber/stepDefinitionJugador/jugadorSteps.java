package com.cucumber.stepDefinitionJugador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.ing_software.veintiuno.Veintiuno;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class jugadorSteps {
    private Veintiuno veintiuno;
    public boolean estado;

    // Prueba 1

    @Given("un jugador")
    public void un_jugador() {
        veintiuno = new Veintiuno();
        veintiuno.getJugador("jugador");
        veintiuno.getJugador("casa");
    }

    @When("el juego inicia")
    public void el_juego_inicia() {
        veintiuno.setMazo(veintiuno.generarMazo());
        assertFalse(veintiuno.getMazo().isEmpty());
    }

    @Then("el jugador tiene dos cartas")
    public void el_jugador_tiene_dos_cartas() {
        veintiuno.jugar("jugador");
        assert(veintiuno.getJugador("jugador").getCartas().size() == 2);
    }

//--------------------------------------------------------------------------------------------

    //Prueba 2

    @When("el jugador solicita una carta")
    public void el_jugador_solicita_una_carta() {
        veintiuno.jugar("casa");
        veintiuno.setJuegoContinua(true);
        assert(veintiuno.isJuegoContinua());
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
        else
            veintiuno.imprimirResultado();
    }

    //-------------------------------------------------------------------------------------------------------------

    // Prueba 4

    @When("se conoce el {int} y el {int}")
    public void se_conoce_el_puntaje_jugador_y_el_puntaje_casa(int puntaje_jugador, int puntaje_casa) {
        veintiuno.getJugador("jugador").setPuntaje(puntaje_jugador);
        veintiuno.getJugador("casa").setPuntaje(puntaje_casa);
    }

    @Then("se conoce el {string}")
    public void se_conoce_el_ganador(String ganador) {
        assertEquals(veintiuno.imprimirResultado(),ganador);
    }
}
