import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class  Carta { // Clase que representa una carta con valor y pinta
    String valor;
    String pinta;

    public Carta(String valor, String pinta) {
        this.valor = valor;
        this.pinta = pinta;
    }
    public String cartaString() {
        return "[("+valor+", "+pinta+")]";
    }
}