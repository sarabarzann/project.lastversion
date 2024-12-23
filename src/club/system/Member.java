package club.system;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public abstract class Member {
    private int memberId;
    private String name;
    private String contactInfo;
    private LocalDate joinDate;
    private static final Random random = new Random();
    private static final String SYSTEM_USERNAME = "admin";
    private static final String SYSTEM_PASSWORD = "admin123";

    public static boolean validateLogin(String username, String password) {
        return SYSTEM_USERNAME.equals(username) && SYSTEM_PASSWORD.equals(password);
    }

    private int generateMemberId() {
        return 1000 + random.nextInt(9000);
    }

    public void setMemberDetails(String name, String contactInfo) {
        this.memberId = generateMemberId();
        this.name = name;
        this.contactInfo = contactInfo;
        this.joinDate = LocalDate.now();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public Member() {
        setMemberDetails("John Doe", "123-456-7890");
    }

    public void input(Scanner scanner, boolean isInitializing) {
    if (!isInitializing) {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.next();
        setMemberDetails(name, contactInfo);
    }
}


    @Override
    public String toString() {
        return String.format("ID: %d\nName: %s\nContact: %s\nJoin Date: %s", memberId, name, contactInfo, joinDate);
    }
}
