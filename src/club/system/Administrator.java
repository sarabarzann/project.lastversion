package club.system;

import java.util.Scanner;

class Administrator extends Staff {
    private int projectsManaged;
    private String jobTitle;

    public void setProperties(int projectsManaged, String jobTitle) {
        this.projectsManaged = projectsManaged;
        this.jobTitle = jobTitle;
    }

    @Override
    public void input(Scanner scanner, boolean isInitializing) {
        super.input(scanner, isInitializing);
        if (!isInitializing) {
            System.out.print("Enter Job Title: ");
            this.jobTitle = scanner.nextLine();
            System.out.print("Enter Number of Projects Managed: ");
            this.projectsManaged = scanner.nextInt();  
            scanner.nextLine();  
        }
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (projectsManaged * 200);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
            "\nJob Title: %s\nProjects Managed: %d\nCalculated Salary: %.2f",
            jobTitle, projectsManaged, calculateSalary()
        );
    }
}
