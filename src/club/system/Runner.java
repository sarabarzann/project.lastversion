package club.system;
import java.util.Scanner;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Players> playersList = new ArrayList<>();
        ArrayList<Session> sessionsList = new ArrayList<>();
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (Member.validateLogin(username, password)) {
                loggedIn = true;
                System.out.println("Login successful!\n");
            } else {
                System.out.println("Invalid username or password. Please try again.\n");
            }
        }

        Administrator admin = new Administrator();
        Coach coach = new Coach();
        Doctor doctor = new Doctor();
        Accountants accountant = new Accountants();

        Basketball basketball = new Basketball();
        Football football = new Football();

        Players player = new Players();

        while (true) {
            System.out.println("\n--- Club Registration System ---");
            System.out.println("1. Enter Player Details and Show Fees");
            System.out.println("2. Manage Staff Details and Salaries");
            System.out.println("3. Manage Sports Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); 

            switch (choice) {
                case 1:
                    System.out.println("\n--- Player Management ---");
                    System.out.println("1. Enter New Player Details");
                    System.out.println("2. Display All Players");
                    System.out.println("3. Go back to main menu");
                    System.out.print("Choose an option: ");
                    int playerChoice = scanner.nextInt(); 

                    switch (playerChoice) {
                        case 1:
                            System.out.println("\nEnter Player Details:");
                            player.input(scanner, false);
                            playersList.add(player);
                            System.out.println("\n--- Player Details ---");
                            System.out.println(player);
                            System.out.println("Total Fee Before Discount: " + player.getFee());
                            System.out.println("Total Fee After Discount: " + player.calculateDiscountedFee());
                            break;

                        case 2:
                            if (playersList.isEmpty()) {
                                System.out.println("No players registered yet.");
                            } else {
                                System.out.println("\n--- All Player Details ---");
                                for (int i = 0; i < playersList.size(); i++) {
                                    System.out.println("\nPlayer " + (i + 1) + ":");
                                    System.out.println(playersList.get(i));
                                }
                            }
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("Invalid choice. Returning to main menu.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Staff Management ---");
                    System.out.println("1. Enter Administrator Details");
                    System.out.println("2. Enter Coach Details");
                    System.out.println("3. Enter Doctor Details");
                    System.out.println("4. Enter Accountant Details");
                    System.out.println("5. Add Staff Members to Accountant");
                    System.out.println("6. Display Staff Details");
                    System.out.println("7. Calculate Total Salaries Managed by Accountant");
                    System.out.println("8. Go back to main menu");
                    System.out.print("Choose an option: ");
                    int staffChoice = scanner.nextInt(); 

                    switch (staffChoice) {
                        case 1:
                            System.out.println("\nEnter details for Administrator:");
                            admin.setBaseSalary(500); 
                            admin.input(scanner, false);
                            break;

                        case 2:
                            System.out.println("\nEnter details for Coach:");
                            coach.setBaseSalary(400); 
                            coach.input(scanner, false);
                            break;

                        case 3:
                            System.out.println("\nEnter details for Doctor:");
                            doctor.setBaseSalary(800); 
                            doctor.input(scanner, false);
                            break;

                        case 4:
                            System.out.println("\nEnter details for Accountant:");
                            accountant.setBaseSalary(600); 
                            accountant.input(scanner, false);
                            break;

                        case 5:
                            System.out.println("\nAdding staff members to Accountant:");
                            accountant.addStaffMember(admin);
                            accountant.addStaffMember(coach);
                            accountant.addStaffMember(doctor);
                            System.out.println("Staff members added to Accountant's management.");
                            break;

                        case 6:
                            System.out.println("\n--- Staff Details ---");
                            System.out.println("\nAdministrator Details:");
                            System.out.println(admin);
                            System.out.println("\nCoach Details:");
                            System.out.println(coach);
                            System.out.println("\nDoctor Details:");
                            System.out.println(doctor);
                            System.out.println("\nAccountant Details:");
                            System.out.println(accountant);
                            break;

                        case 7:
                            System.out.println("\nTotal Salaries Managed by Accountant: " + accountant.calculateSalary());
                            break;

                        case 8:
                            break;

                        default:
                            System.out.println("Invalid choice. Returning to main menu.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Sports Management ---");
                    System.out.println("1. Enter Basketball Details");
                    System.out.println("2. Enter Football Details");
                    System.out.println("3. Sessions");
                    System.out.println("4. Display Sport Details");
                    System.out.println("5. Go back to main menu");
                    System.out.print("Choose an option: ");
                    int sportsChoice = scanner.nextInt(); 

                    switch (sportsChoice) {
                        case 1:
                            System.out.println("\nEnter details for Basketball:");
                            basketball.input(scanner);
                            break;

                        case 2:
                            System.out.println("\nEnter details for Football:");
                            football.input(scanner);
                            break;

                        case 3:
                            System.out.println("\n--- Session Management ---");
                            System.out.println("1. Add New Session");
                            System.out.println("2. Remove Session");
                            System.out.println("3. Update Session");
                            System.out.println("4. Display All Sessions");
                            System.out.print("Choose an option: ");
                            int sessionChoice = scanner.nextInt(); 

                            switch (sessionChoice) {
                                case 1:
                                    System.out.println("\nEnter Session Details:");
                                    Session newSession = new Session();
                                    newSession.input(scanner, false);
                                    sessionsList.add(newSession);
                                    System.out.println("Session added successfully!");
                                    break;

                                case 2:
                                    if (sessionsList.isEmpty()) {
                                        System.out.println("No sessions available to remove.");
                                    } else {
                                        System.out.println("\nSelect a session to remove:");
                                        for (int i = 0; i < sessionsList.size(); i++) {
                                            System.out.println((i + 1) + ". " + sessionsList.get(i).toString());
                                        }
                                        System.out.print("Enter session number to remove: ");
                                        int removeIndex = scanner.nextInt() - 1; 
                                        if (removeIndex >= 0 && removeIndex < sessionsList.size()) {
                                            sessionsList.remove(removeIndex);
                                            System.out.println("Session removed successfully!");
                                        } else {
                                            System.out.println("Invalid session number.");
                                        }
                                    }
                                    break;

                                case 3:
                                    if (sessionsList.isEmpty()) {
                                        System.out.println("No sessions available to update.");
                                    } else {
                                        System.out.println("\nSelect a session to update:");
                                        for (int i = 0; i < sessionsList.size(); i++) {
                                            System.out.println((i + 1) + ". " + sessionsList.get(i).toString());
                                        }
                                        System.out.print("Enter session number to update: ");
                                        int updateIndex = scanner.nextInt() - 1; 
                                        if (updateIndex >= 0 && updateIndex < sessionsList.size()) {
                                            System.out.println("\nEnter New Session Details:");
                                            sessionsList.get(updateIndex).input(scanner, false);
                                            System.out.println("Session updated successfully!");
                                        } else {
                                            System.out.println("Invalid session number.");
                                        }
                                    }
                                    break;

                                case 4:
                                    if (sessionsList.isEmpty()) {
                                        System.out.println("No sessions available.");
                                    } else {
                                        System.out.println("\n--- All Sessions ---");
                                        for (Session session : sessionsList) {
                                            System.out.println(session);
                                        }
                                    }
                                    break;

                                default:
                                    System.out.println("Invalid choice. Returning to staff management menu.");
                            }
                            break;

                        case 4:
                            System.out.println("\n--- Sport Details ---");
                            System.out.println("\nBasketball Details:");
                            System.out.println(basketball);
                            basketball.displayRules();
                            System.out.println("\nFootball Details:");
                            System.out.println(football);
                            football.displayRules();

                            System.out.println("\n--- Session Details ---");
                            if (sessionsList.isEmpty()) {
                                System.out.println("No sessions available.");
                            } else {
                                for (int i = 0; i < sessionsList.size(); i++) {
                                    System.out.println("\nSession " + (i + 1) + ":");
                                    System.out.println(sessionsList.get(i));
                                }
                            }
                            break;

                        case 5:
                            break;

                        default:
                            System.out.println("Invalid choice. Returning to main menu.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

