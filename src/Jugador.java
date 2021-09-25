import java.util.*;
import java.util.stream.Collectors;

public class  Jugador { // Jugador que tiene las cartas y a su vez metodos para el calculo de su puntaje
    private String nombreJugador;
    private int puntaje;
    private List<Carta> jugadorCartas = new ArrayList<>();

    public Jugador(String nombreJugador) {
      this.nombreJugador = nombreJugador;
    }
    
    public int getPuntaje() {
      return puntaje;
    }
    
    public String getNombre() {
      return nombreJugador;
    }
    
    public List<Carta> getCartas(){
      return jugadorCartas;
    }
    
    public void addCarta(Carta carta){
      jugadorCartas.add(carta);
    }

    public String imprimirCartas(boolean ocultarPrimera) {
        if(ocultarPrimera){
          return  "[(X, X)], " + jugadorCartas.subList(1, jugadorCartas.size())
          .stream().map(carta -> carta.cartaString())
                  .collect(Collectors.joining(", "));
        }
        else{
            return jugadorCartas
            .stream().map(carta -> carta.cartaString())
                    .collect(Collectors.joining(", "));
        }        
    }
    
    public int sumarPuntos(){
      puntaje = jugadorCartas.stream().mapToInt(carta -> sumarPuntos(carta.valor)).sum();
      return puntaje;
    }

    public int sumarPuntos(String carta){ 
        if(Pattern.matches("[JQK]+", carta)){
            return 10;
        }
        if(carta.equals("As")){
          if((puntaje+11)<=21)
            return 11;
          else
            return 1;
        }
        return Integer.parseInt(carta);
    }
}
