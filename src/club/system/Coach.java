package club.system;
import java.util.ArrayList;
import java.util.Scanner;

class Coach extends Staff {
    private String specialization;
    private int experienceYears;
    private double winRate;

    public void setCoachDetails(String specialization, int experienceYears, double winRate) {
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.winRate = winRate;
    }

    @Override
    public void input(Scanner scanner, boolean isInitializing) {
        super.input(scanner, isInitializing);
        if (!isInitializing) {
            System.out.print("Enter Specialization: ");
            this.specialization = scanner.nextLine();
            System.out.print("Enter Years of Experience: ");
            this.experienceYears = scanner.nextInt(); 
            System.out.print("Enter Win Rate (0-1): ");
            this.winRate = scanner.nextDouble(); 
            scanner.nextLine();
        }
    }

    @Override
    public double calculateSalary() {
        double experienceBonus = getBaseSalary() * (experienceYears * 0.05);
        double performanceBonus = getBaseSalary() * (winRate * 0.2);
        return getBaseSalary() + experienceBonus + performanceBonus;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
            "\nSpecialization: %s\nExperience: %d years\nWin Rate: %.2f\nCalculated Salary: %.2f",
            specialization, experienceYears, winRate, calculateSalary()
        );
    }
}
