package club.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Accountants extends Staff {
    private double bonusRate; 
    private int overtimeHours; 
    private ArrayList<Staff> staffMembers; 

    public Accountants() {
        super();
        this.staffMembers = new ArrayList<>();
    }

    public void setAccountingDetails(double bonusRate, int overtimeHours) {
        this.bonusRate = bonusRate;
        this.overtimeHours = overtimeHours;
    }

    public void addStaffMember(Staff staff) {
        staffMembers.add(staff);
    }

    @Override
    public void input(Scanner scanner, boolean isInitializing) {
        super.input(scanner, isInitializing);
        if (!isInitializing) {
            System.out.print("Enter Bonus Rate (0-1): ");
            this.bonusRate = scanner.nextDouble(); 
            System.out.print("Enter Overtime Hours: ");
            this.overtimeHours = scanner.nextInt();  
            scanner.nextLine(); 
        }
    }
    
    @Override
    public double calculateSalary() {
        double regularPay = getBaseSalary();
        double overtimePay = (getBaseSalary() / 160) * 1.5 * overtimeHours;
        double personalBonus = regularPay * bonusRate;

        double managementBonus = 0;
        for (Staff staff : staffMembers) {
            managementBonus += staff.calculateSalary() * 0.005; 
        }

        return regularPay + overtimePay + personalBonus + managementBonus;
    }

    @Override
    public String toString() {
        StringBuilder staffDetails = new StringBuilder();
        double totalSalaries = 0;

        for (Staff staff : staffMembers) {
            totalSalaries += staff.calculateSalary();
            staffDetails.append("\n").append(staff.toString());
        }

        return super.toString() + String.format(
            "\nBonus Rate: %.2f\nOvertime Hours: %d\nCalculated Salary: %.2f\n\nManaged Staff:\n%s\nTotal Salaries of Managed Staff: %.2f",
            bonusRate, overtimeHours, calculateSalary(), staffDetails, totalSalaries
        );
    }
}
