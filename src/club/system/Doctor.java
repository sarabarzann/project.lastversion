package club.system;

import java.util.Scanner;

public class Doctor extends Staff {
    private String specialty;
    private int yearsOfExperience;

    public void setDoctorDetails(String specialty, int yearsOfExperience) {
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void input(Scanner scanner, boolean isInitializing) {
        super.input(scanner, isInitializing);
        if (!isInitializing) {
            System.out.print("Enter Specialty: ");
            this.specialty = scanner.nextLine();

            System.out.print("Enter Years of Experience: ");
            this.yearsOfExperience = scanner.nextInt(); 
            scanner.nextLine();  
        }
    }

    @Override
    public double calculateSalary() {
        double experienceBonus = getBaseSalary() * (yearsOfExperience * 0.03);
        return getBaseSalary() + experienceBonus;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
            "\nSpecialty: %s\nYears of Experience: %d\nCalculated Salary: %.2f",
            specialty, yearsOfExperience, calculateSalary()
        );
    }
}
