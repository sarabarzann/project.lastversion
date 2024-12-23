package club.system;

import java.util.Scanner;

public abstract class Staff extends Member {
    private double baseSalary;

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    @Override
    public void input(Scanner scanner, boolean isInitializing) {
        super.input(scanner, isInitializing);
        if (!isInitializing) {
            System.out.print("Enter Base Salary: ");
            this.baseSalary = scanner.nextDouble();
            scanner.nextLine(); 
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nBase Salary: %.2f", baseSalary);
    }
}
