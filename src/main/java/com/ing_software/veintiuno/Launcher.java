package com.ing_software.veintiuno;

public class Launcher { // Clase principal que ejecuta la clase veintiuno

    // Based on: https://github.com/mrtesteloper/page_object_model_example
    // Based on: https://mrtesteloper.com/2020/11/07/pruebas-bdd-con-selenium-java-y-cucumber/
    public static void main(String[] args) {
        Veintiuno veintiuno = new Veintiuno();
        veintiuno.empezarJuego();
    }

}