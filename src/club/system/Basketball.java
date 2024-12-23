package club.system;

import java.util.Scanner;

public class Basketball extends Sports {
    private int courtLength;
    private int courtWidth;
    private boolean hasThreePointLine;

    public void setBasketballDetails(int courtLength, int courtWidth, boolean hasThreePointLine) {
        this.courtLength = courtLength;
        this.courtWidth = courtWidth;
        this.hasThreePointLine = hasThreePointLine;
    }

    @Override
    public void input(Scanner scanner) {
       
        setSportDetails( 5, "Basketball Court");

        System.out.print("Enter Court Length (meters): ");
        this.courtLength = scanner.nextInt();  
        System.out.print("Enter Court Width (meters): ");
        this.courtWidth = scanner.nextInt();  
        System.out.print("Has Three-Point Line (true/false): ");
        this.hasThreePointLine = scanner.nextBoolean(); 
        scanner.nextLine();  
    }

    @Override
    public void displayRules() {
        System.out.println("Basketball Rules:");
        System.out.println("- Each team has 5 players on court");
        System.out.println("- Game consists of 4 quarters of 12 minutes each");
        System.out.println("- Points: 2 points for field goal, 3 points beyond the arc, 1 point for free throw");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
            "\nCourt Size: %d x %d meters\nHas Three-Point Line: %b",
            courtLength, courtWidth, hasThreePointLine
        );
    }
}
