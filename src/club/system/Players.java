package club.system;

import java.util.Scanner;

public class Players extends Member {
    private String teamName;
    private String position;
    private int gamesPlayed;
    private int gamesWon;
    private MembershipType membershipType;
    private double baseFee; 

    public enum MembershipType {
        DAILY(0.05),  
        MONTHLY(0.10), 
        YEARLY(0.20);  

        private final double discount;
        MembershipType(double discount) {
            this.discount = discount;
        }

        public double getDiscount() {
            return discount;
        }
    }

    public Players() {
        super();
        this.baseFee = 100;
    }

    public void setPlayerDetails(String teamName, String position, int gamesPlayed, 
                                 int gamesWon, MembershipType membershipType) {
        this.teamName = teamName;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.membershipType = membershipType;
    }

    @Override
    public void input(Scanner scanner, boolean isInitializing) {
        super.input(scanner, isInitializing);
        if (isInitializing) {
            setPlayerDetails("Eagles", "Forward", 10, 7, MembershipType.MONTHLY);
        } else {
            System.out.print("Enter Team Name: ");
            String team = scanner.nextLine();
            System.out.print("Enter Position: ");
            String pos = scanner.nextLine();
            System.out.print("Enter Games Played: ");
            gamesPlayed = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter Games Won: ");
            gamesWon = scanner.nextInt(); 
            scanner.nextLine(); 

            System.out.println("Select Membership Type:");
            System.out.println("1. Daily");
            System.out.println("2. Monthly");
            System.out.println("3. Yearly");
            int choice = scanner.nextInt(); 
            scanner.nextLine(); 

            MembershipType type;
            switch (choice) {
                case 1: 
                    type = MembershipType.DAILY; 
                    break;
                case 2: 
                    type = MembershipType.MONTHLY; 
                    break;
                case 3: 
                    type = MembershipType.YEARLY; 
                    break;
                default: 
                    type = MembershipType.MONTHLY;
            }

            setPlayerDetails(team, pos, gamesPlayed, gamesWon, type);
        }
    }

    public double getFee() {
        return baseFee;
    }

    public double calculateDiscountedFee() {
        double discount = membershipType.getDiscount();
        return baseFee - (baseFee * discount);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
            "\nTeam: %s\nPosition: %s\nGames Played: %d\nGames Won: %d\nMembership: %s",
            teamName, position, gamesPlayed, gamesWon, membershipType);
    }
}
