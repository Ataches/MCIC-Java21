package com.ing_software.veintiuno;

import java.io.InputStream;
import java.util.Scanner;

public class GameAsker {

    private final Scanner sc;

    public GameAsker(InputStream in){
        sc = new Scanner(in);
    }

    public String stringAsk(){
        return sc.nextLine();
    }

}
