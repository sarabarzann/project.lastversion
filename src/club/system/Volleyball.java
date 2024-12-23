package club.system;

import java.util.Scanner;

public class Volleyball extends Sports {
    private int netHeight;
    private boolean isBeachVolleyball;
    private int setsToWin;

    public void setVolleyballDetails(int netHeight, boolean isBeachVolleyball, int setsToWin) {
        this.netHeight = netHeight;
        this.isBeachVolleyball = isBeachVolleyball;
        this.setsToWin = setsToWin;
    }

    @Override
    public void input(Scanner scanner) {
        
        setSportDetails( isBeachVolleyball ? 2 : 6, "Volleyball Court");

        System.out.print("Enter Net Height (cm): ");
        this.netHeight = scanner.nextInt(); 

        System.out.print("Is it Beach Volleyball? (true/false): ");
        this.isBeachVolleyball = scanner.nextBoolean();

        System.out.print("Sets Required to Win: ");
        this.setsToWin = scanner.nextInt(); 

        scanner.nextLine(); 
    }

    @Override
    public void displayRules() {
        System.out.println("Volleyball Rules:");
        System.out.println("- Indoor: 6 players per team, Beach: 2 players per team");
        System.out.println("- First team to win " + setsToWin + " sets wins the match");
        System.out.println("- Points scored on every serve (Rally Point System)");
        System.out.println("- Sets played to 25 points (must win by 2)");
        System.out.println("- Maximum of 3 touches per team before the ball must cross the net");
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nNet Height: %d cm\nBeach Volleyball: %b\nSets to Win: %d", netHeight, isBeachVolleyball, setsToWin);
    }
}
