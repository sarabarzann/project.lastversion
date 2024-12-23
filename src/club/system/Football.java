package club.system;

import java.util.Scanner;

class Football extends Sports {
    private int fieldLength;
    private int fieldWidth;
    private boolean hasArtificialTurf;

    public void setFootballDetails(int fieldLength, int fieldWidth, boolean hasArtificialTurf) {
        this.fieldLength = fieldLength;
        this.fieldWidth = fieldWidth;
        this.hasArtificialTurf = hasArtificialTurf;
    }

    @Override
    public void input(Scanner scanner) {
        
        setSportDetails(11, "Football Field");

        System.out.print("Enter Field Length (meters): ");
        fieldLength = scanner.nextInt(); 
        scanner.nextLine(); 

        System.out.print("Enter Field Width (meters): ");
        fieldWidth = scanner.nextInt();  
        scanner.nextLine();  

        System.out.print("Has Artificial Turf (true/false): ");
        hasArtificialTurf = scanner.nextBoolean(); 
        scanner.nextLine(); 
    }

    @Override
    public void displayRules() {
        System.out.println("Football Rules:");
        System.out.println("- Each team has 11 players on the field");
        System.out.println("- Game consists of two 45-minute halves");
        System.out.println("- No handling the ball except by goalkeeper within penalty area");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
            "\nField Size: %d x %d meters\nArtificial Turf: %b",
            fieldLength, fieldWidth, hasArtificialTurf
        );
    }
}
