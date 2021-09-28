package com.ing_software.veintiuno;

import java.util.*;

public class Veintiuno { // Clase principal que dirige el juego dependiendo de las decisiones del jugador
    public static final String[] pintas = {"Corazones", "Picas", "Diamante", "Trébol"};
    public static final String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private final List<Carta> mazo = new ArrayList<>();
    private final List<Jugador> jugadores = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private boolean jugadorContinua = true;
    private boolean finalizo = false;

    private final Random random = new Random();


    public void empezarJuego() { // Metodo principal que dependiendo de la continuación o juego del jugador direcciona la partida
        generarMazo();
        do {
            jugar("jugador");
            if (jugadorContinua) {
                jugar("casa");
                imprimirCartas();
                confirmar();
            }
        } while (jugadorContinua);
        finalizo = true;
        imprimirCartas();
        System.out.println(imprimirResultado());
    }

    public void generarMazo() { // Genera el mazo a partir de las cartas que se contiene en el array y pintas
        for (String pinta : pintas) {
            for (String valor : valores) {
                Carta carta = new Carta(valor, pinta);
                mazo.add(carta);
            }
        }
    }

    public void jugar(String nombreJugador) {
        Jugador jugador = getJugador(nombreJugador);
        if (!mazo.isEmpty()) {
            if (jugador.getCartas().isEmpty()) {//Inicia mazo
                jugador.addCarta(sacarCartaMazo());
                jugador.addCarta(sacarCartaMazo());
            } else {
                jugador.addCarta(sacarCartaMazo());
            }
            if (!(jugador.sumarPuntos() <= 21)) //Si alguno de los jugadores paso los 21 termina el juego
                jugadorContinua = false;
        }else {
            System.out.println("No quedan más cartas en el mazo");
            jugadorContinua = false;
        }
    }

    public void imprimirCartas() { //Impresiones por pantalla
        if (!finalizo) {
            System.out.println("\nCartas casa: \n " + getJugador("casa").imprimirCartas(true));
        } else {
            System.out.println("\n*** Termino el juego ***");
            System.out.println("\nCartas casa: \n" + getJugador("casa").imprimirCartas(false));
            System.out.println("\nPuntaje casa: " + getJugador("casa").getPuntaje());
        }
        System.out.println("\nCartas jugador: \n" + getJugador("jugador").imprimirCartas(false));
        System.out.println("Puntaje jugador: " + getJugador("jugador").getPuntaje());
    }

    public void confirmar() { //Confirma si quiere mas cartas, sino solo juega la casa
        System.out.println("\nJugador, quiere mas cartas? (Escriba 'No' para finalizar, escriba 'Si' para continuar): ");
        String str = sc.nextLine();
        jugadorContinua = !"no".equalsIgnoreCase(str);

    }

    public String imprimirResultado() { //RESULTADOS: Analiza el puntaje de cada jugador e imprime el resultado
        int puntajeCasa = getJugador("casa").getPuntaje();
        int puntajeJugador = getJugador("jugador").getPuntaje();

        if (puntajeCasa == puntajeJugador ||
                puntajeCasa <= 21 && puntajeCasa > puntajeJugador ||
                puntajeCasa <= 21 && puntajeJugador >= 21)
            return "Gano la casa";
        else {
            if ((puntajeCasa > 21) && (puntajeJugador > 21))
                return "Nadie gano";
            return "Gano el jugador";
        }
    }

    /**
     * Genera una nueva carta según un numero aleatorio basado en el tamaño del mazo
     * @return retorna la carta eliminada del mazo o una carta de error en caso de no
     * encontrar una carta dentro del mazo
     */
    public Carta sacarCartaMazo() {
        try {
            return mazo.remove((int) (Math.random() * mazo.size()));
        }catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            jugadorContinua = false;
        }
        return new Carta("-1","-1");
    }

    /**
     * Obtiene un jugador presente en el listado jugadores, en caso contrario crea
     * uno nuevo utilizando el nombre recibido.
     *
     * @param nombreJugador string con el nombre del jugador
     * @return jugador encontrado o jugador creado y añadido al listado de jugadores
     */
    public Jugador getJugador(String nombreJugador) {
        Optional<Jugador> optional = jugadores.stream().filter(
                jugador -> nombreJugador.equals(jugador.getNombre()))
                .findAny();
        if (optional.isPresent())
            return optional.get();
        else {
            jugadores.add(new Jugador(nombreJugador));
            return getJugador(nombreJugador);
        }
    }
    // -  Arreglar cuando la casa se pasa
    // -  Revisar el if puntajeCasa linea 82
}