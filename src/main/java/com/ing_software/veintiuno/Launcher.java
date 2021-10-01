package com.ing_software.veintiuno;

import java.util.ArrayList;
import java.util.List;

public class Launcher {// Clase principal que ejecuta la clase veintiuno
    private static GameAsker gameAsker = new GameAsker(System.in);
    private static List<Jugador> jugadores = new ArrayList<>();

    // Based on: https://github.com/mrtesteloper/page_object_model_example
    // Based on: https://mrtesteloper.com/2020/11/07/pruebas-bdd-con-selenium-java-y-cucumber/
    public static void main(String[] args) {
        Veintiuno veintiuno = new Veintiuno(gameAsker);
        jugadores.add(veintiuno.getJugador("casa"));
        jugadores.add(veintiuno.getJugador("jugador"));
        veintiuno.setJugadores(jugadores);
        System.out.println(veintiuno.empezarJuego());
    }
}