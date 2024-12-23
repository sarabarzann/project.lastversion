package club.system;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Sports extends Member {
  
    private int numberOfPlayers;
    private String fieldType;

    public void setSportDetails( int numberOfPlayers, String fieldType) {
     
        this.numberOfPlayers = numberOfPlayers;
        this.fieldType = fieldType;
    }

    

    public abstract void input(Scanner scanner);

    public abstract void displayRules();

    @Override
    public String toString() {
        return String.format(
            "\nNumber of Players: %d\nField Type: %s",
             numberOfPlayers, fieldType
        );
    }
}


