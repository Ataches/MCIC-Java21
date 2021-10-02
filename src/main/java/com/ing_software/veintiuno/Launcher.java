package com.ing_software.veintiuno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {// Clase principal que ejecuta la clase veintiuno

    // Based on: https://github.com/mrtesteloper/page_object_model_example
    // Based on: https://mrtesteloper.com/2020/11/07/pruebas-bdd-con-selenium-java-y-cucumber/
    public static void main(String[] args) {
        GameAsker gameAsker;
        List<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        gameAsker = new GameAsker();
        gameAsker.setScanner(scanner);

        Veintiuno veintiuno = new Veintiuno(gameAsker);
        jugadores.add(veintiuno.getJugador("casa"));
        jugadores.add(veintiuno.getJugador("jugador"));
        veintiuno.setJugadores(jugadores);
        System.out.println(veintiuno.empezarJuego());
    }
}