import java.util.*;
import java.util.stream.Collectors;

public class Ventiuno { // Clase principal que dirige el juego dependiendo de las decisiones del jugador
    public static final String[] pintas = {"Corazones", "Picas", "Diamante", "Trébol"};
    public static final String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private List<Carta> mazo = new ArrayList<>();
    private List<Jugador> jugadores = new ArrayList<>();
    private final Scanner sc= new Scanner(System.in);
    private boolean jugadorContinua=true;
    private boolean finalizo=false;

    private Random random = new Random();


    public void launch(){ // Metodo principal que dependiendo de la continuación o juego del jugador direcciona la partida
        generarMazo();
        jugadores.add(new Jugador("casa"));
        jugadores.add(new Jugador("jugador"));
        do{
            jugar("jugador");
            if (jugadorContinua){
              jugar("casa");
              imprimirCartas();
              confirmar();
            }            
        }while (jugadorContinua);
        finalizo=true;
        imprimirCartas();
        System.out.println(imprimirResultado());
    } 
    
    public List<Carta> generarMazo(){ // Genera el mazo a partir de las cartas que se contiene en el array y pintas
        for (int i = 0; i < pintas.length; i++){
            for (int j = 0; j < valores.length; j++){
                Carta carta = new Carta(valores[j], pintas[i]);
                mazo.add(carta);
            }
        }
        return mazo;
    }

    public void jugar(String nombreJugador){
      Jugador jugador = getJugador(nombreJugador);
      if (!mazo.isEmpty()){
          if(jugador.getCartas().isEmpty()){//Inicia mazo
            jugador.addCarta(sacarCartaMazo());
            jugador.addCarta(sacarCartaMazo());
          }else{
            jugador.addCarta(sacarCartaMazo());
          }
          if(!(jugador.sumarPuntos()<=21)) //Si alguno de los jugadores paso los 21 termina el juego
            jugadorContinua = false;
      }
    }

    public void imprimirCartas(){ //Impresiones por pantalla
        if(!finalizo){
            System.out.println("\nCartas casa: \n "+getJugador("casa").imprimirCartas(true));
        }else{
            System.out.println("\n*** Termino el juego ***");
            System.out.println("\nCartas casa: \n"+ getJugador("casa").imprimirCartas(false));
            System.out.println("\nPuntaje casa: "+ getJugador("casa").getPuntaje());
        }
        System.out.println("\nCartas jugador: \n"+getJugador("jugador").imprimirCartas(false));
        System.out.println("Puntaje jugador: "+ getJugador("jugador").getPuntaje());
    }

    public void confirmar(){ //Confirma si quiere mas cartas, sino solo juega la casa
        System.out.println("\nJugador, quiere mas cartas? (Escriba 'No' para finalizar, escriba 'Si' para continuar): ");
        String str= sc.nextLine();
        jugadorContinua = !"no".equalsIgnoreCase(str);
        
    }

    public String imprimirResultado(){ //RESULTADOS: Analiza el puntaje de cada jugador e imprime el resultado
        int puntajeCasa = getJugador("casa").getPuntaje();
        int puntajeJugador = getJugador("jugador").getPuntaje();

        if((puntajeCasa==puntajeJugador)||
            ((puntajeCasa<=21)&&((puntajeCasa>puntajeJugador)&&(puntajeJugador<=21)))||
            ((puntajeCasa<=21)&&(puntajeJugador>=21)))
            return "Gano la casa";
        else{
            if((puntajeCasa>21) && (puntajeJugador>21))
                return "Nadie gano";
            return "Gano el jugador";
        }
    }

    public Carta sacarCartaMazo(){
        return mazo.remove(random.nextInt(mazo.size())+1);
    }

    public Jugador getJugador(String nombreJugador){
      return jugadores.stream().filter(
        jugador -> nombreJugador.equals(jugador.getNombre()))
      .findAny()
      .orElse(null);
    }
    // -  Arreglar cuando la casa se pasa
    // -  Revisar el if puntajeCasa linea 156
    // -  No recargar el main
    // -  Separar en clases .java
}