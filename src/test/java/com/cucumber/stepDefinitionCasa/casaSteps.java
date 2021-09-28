package com.cucumber.stepDefinitionCasa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.ing_software.veintiuno.Carta;
import com.ing_software.veintiuno.Jugador;
import com.ing_software.veintiuno.Veintiuno;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class casaSteps {

    private Veintiuno veintiuno;
    public boolean estado;
    public int puntaje;

    @Given("la casa")
    public void la_casa() {
        veintiuno = new Veintiuno();
        veintiuno.jugadores.add(new Jugador("casa"));
        veintiuno.jugadores.add(new Jugador("jugador"));
        veintiuno.jugadores.add(new Jugador("casa2"));
        veintiuno.getJugador("casa");
    }

    @When("el juego inicia")
    public void el_juego_inicia() {
        veintiuno.generarMazo();
        assertFalse(veintiuno.mazo.isEmpty());
    }

    @Then("la casa tiene dos cartas")
    public void la_casa_tiene_dos_cartas() {
        veintiuno.jugar("casa");
        assert(veintiuno.getJugador("casa").getCartas().size() == 2);
    }

    //-------------------------------------------------------------------------------------------------

    @When("el jugador se planta")
    public void el_jugador_se_planta() {
        veintiuno.jugadorContinua = false;
        assertFalse(veintiuno.jugadorContinua);
    }

    @When("se valida el {int} de la casa")
    public void se_valida_el_puntaje_de_la_casa(int puntaje) {
        veintiuno.jugar("casa");
        puntaje = veintiuno.getJugador("casa").getPuntaje();
        if(!(veintiuno.getJugador("casa").sumarPuntos()<=21))
            estado = true;
    }

    @Then("se reparte una carta : {string}")
    @Then("se reparte una carta : true")
    @Then("se reparte una carta : false")
    public void se_reparte_una_carta() {
        if(estado)
            veintiuno.getJugador("casa").addCarta(veintiuno.sacarCartaMazo());
    }

    //-----------------------------------------------------------------------------------------------

    @When("se suman las cartas: {string}")
    public void se_suman_las_cartas(String mano) {
        String str = mano;
        String[] arrOfStr = str.split(",");
        for (String a : arrOfStr) {
            Carta carta = new Carta(a, "Diamante");
            veintiuno.getJugador("casa2").addCarta(carta);
        }
        puntaje = veintiuno.getJugador("casa2").sumarPuntos();
    }

    @Then("el conteo es: {int}")
    public void el_conteo_es(int puntaje) {
        assertEquals(puntaje,this.puntaje);
    }

}
